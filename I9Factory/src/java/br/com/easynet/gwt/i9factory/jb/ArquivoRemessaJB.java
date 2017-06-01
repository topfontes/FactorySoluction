/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * teste de atualizacao
 */
package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Bco_bancoDAO;
import br.com.easynet.gwt.i9factory.dao.Lan_lancamentoDAO;
import br.com.easynet.gwt.i9factory.dao.Vw_parcelasDAO;
import br.com.easynet.gwt.i9factory.transfer.Arb_arquivobancoT;
import br.com.easynet.gwt.i9factory.transfer.Bco_bancoT;
import br.com.easynet.gwt.i9factory.transfer.Cco_contacorrenteT;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import br.com.easynet.gwt.i9factory.transfer.Lan_lancamentoT;
import br.com.easynet.gwt.i9factory.transfer.Par_parametroT;
import br.com.easynet.gwt.i9factory.transfer.RemessaT;
import br.com.easynet.gwt.i9factory.transfer.Teb_transmissao_empresa_bancoT;
import br.com.easynet.gwt.i9factory.transfer.Vw_parcelasT;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.easynet.util.Text;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author George Leite Junior
 */
public class ArquivoRemessaJB extends SystemBase implements INotSecurity {

    private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
    private Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
    private TreeMap<String, Cco_contacorrenteT> contasClientes = new TreeMap<String, Cco_contacorrenteT>();
    private String orgaos;
    private List<RemessaT> listRemessa;
    private String dtEnvio;
    private String idsParcelas;
    private String tipo;
    private String codigoConvenio = "00103               ";
    private String nomeEmpresa = "CASSERP BENEFICIOS  ";
    private String codigoBanco = "047";
    private String nomeBanco = "BANCO DE SERGIPE    ";
    private String dataGeracao = "";
    private String sequencial = "000001";
    private String versaoLayout = "04"; //05 ou 04
    private String identificacaoServico = "DEBITO AUTOMATICO";
    private String identificacaoServicoCaixa = "DEB AUTOMAT      ";
    private String brancos = "                                                    ";
    //_________________________________________________________
    private String identificacaoClienteEmpresa = "0000000000000000000000000";
    private String agenciaCliente = "0000";
    private String identificacaoClienteBanco = "00000000000000";
    private String dataVencimento = "";
    private String valorDebito = "000000000000000";
    private String codigoMoeda = "03";
    private String usoEmpresa = "000000000000000000000000000000000000000000000000000000000000";
    private String tipoIdentificacao = "2";
    private String cpfCnpj = "000000999999999";
    private String brancosE = "    ";
    private String codigoMovimento = "0";
    //________________________________________________________
    private String totalRegistros = "000000";
    private String somatorio = "00000000000000000";
    private String brancosZ = "                                                                                                                              ";
    private int nrSeq = 0;
    //sda.dat.106682.20110527.00508.REM
    private String nomeArquivoBanese = "sda.dat.106682.";
    //BBR05022.REM
    private String nomeArquivoBancoBrasil = "BBR";
    private String nomeArquivoCaixa = "CEF";
    private String nomeArquivo = "";
    private int contRegistroCaixa = 1;
    private int numeroSequencialRegCF = 0;
    private String masknumeroSeqRegCF = "";
    private int bco_nr_id;

    public void pageLoad() throws Exception {
        //Aumenentando o tamanhodo buffer
        response.setBufferSize(8192);
        sequencial = Text.padLeft(String.valueOf(nrSeq), '0', 6);
    }

    private void loadContasClientes() throws Exception {
        Cco_contacorrenteT ccoT = new Cco_contacorrenteT();
        ccoT.setBco_nr_id(vw_parcelasT.getBco_nr_id());
        ccoT.setOrg_nr_id(vw_parcelasT.getOrg_nr_id());
        List<Cco_contacorrenteT> list = getCco_contacorrenteDAO().getByRemessaBanco(idsParcelas);
        for (Cco_contacorrenteT cco_contacorrenteT : list) {
            StringBuffer sb = new StringBuffer();
            sb.append(cco_contacorrenteT.getBco_nr_id()).append(";").append(cco_contacorrenteT.getCli_nr_id());
            contasClientes.put(sb.toString(), cco_contacorrenteT);
        }
    }

    private Bco_bancoT getBco_bancoT(int bcoNrId) throws Exception {
        Bco_bancoT bco_bancoT = new Bco_bancoT();
        bco_bancoT.setBco_nr_id(bcoNrId);
        List<Bco_bancoT> list = getBco_bancoDAO().getByPK(bco_bancoT);
        return list.size() > 0 ? list.get(0) : null;
    }

    private void registrarEnvioBanco(int tebNrId, String operacao) throws Exception {
        Teb_transmissao_empresa_bancoT tebT = new Teb_transmissao_empresa_bancoT();
        tebT.setTeb_nr_id(tebNrId);
        tebT.setTeb_tx_operacao(operacao);
        Teb_transmissao_empresa_bancoT tebTTemp = getTeb_transmissao_empresa_bancoDAO().getByTeb_nr_id(tebT);
        if (tebTTemp == null) {
            getTeb_transmissao_empresa_bancoDAO().insert(tebT);
        } else {
            // Já houve lançamento, verificar se foi pago, se já foi pago nao faz nada
            if ("E".equalsIgnoreCase(tebTTemp.getTeb_tx_operacao())) {
                //Alterar a data de envio
                tebT.setTeb_dt_envio(new Date());
                getTeb_transmissao_empresa_bancoDAO().updateDataLancamento(tebTTemp);
            }
        }
    }

    public void gerarRemessaIdsParcela() {
        try {

            if (getBco_nr_id() == 1) {
                gerarRemessaIdsParcelaBB();
            } else if (getBco_nr_id() ==104){
                gerarRemessaIdsParcelaCF();
            }

//            idsParcelas = idsParcelas.replace("-", ",");
//            List<Vw_parcelasT> listP = getVw_parcelasDAO().getByRemessaIdsParcelas(idsParcelas);
//            Bco_bancoT bcoT = new Bco_bancoT();
//            bcoT.setBco_nr_id(listP.get(0).getBco_nr_id());
//            List<Bco_bancoT> list = getBco_bancoDAO().getByPK(bcoT);
//
//            if (list.size() > 0) {
//                if (list.get(0).getBco_tx_nome().toUpperCase().indexOf("BRASIL") > -1) {
//                    gerarRemessaIdsParcelaBB();
//                } else {
//                    gerarRemessaIdsParcelaCF();
//                }
//            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gerarRemessaIdsParcelaBB() {
        try {
            idsParcelas = idsParcelas.replace("-", ",");
            StringBuffer sbArquivosBancos = new StringBuffer();
            System.out.println("tipo " + vw_parcelasT.getPle_tx_tipo());
            List<Vw_parcelasT> list = getVw_parcelasDAO().getByRemessaIdsParcelas(idsParcelas,bco_nr_id);

            int qntRegistros = 2;
            double somatorioValor = 0;
            loadContasClientes();
            Bco_bancoT bcoT = null;
            String dataEnvio = "";
            System.out.println("Size parcelas: " + list.size());
            if (list.size() > 0) {
                vw_parcelasT = list.get(0);
                System.out.println("tipo 2 " + vw_parcelasT.getPle_tx_tipo());
                System.out.println("banco 2 " + vw_parcelasT.getBco_tx_codigo());
                StringBuffer sb = new StringBuffer();
                sb.append(vw_parcelasT.getBco_nr_id()).append(";").append(vw_parcelasT.getCli_nr_id());
                Cco_contacorrenteT ccoT = contasClientes.get(sb.toString());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataDoEnvio = sdf.parse(dtEnvio);
                sdf = new SimpleDateFormat("yyyyMMdd");
                dataEnvio = sdf.format(dataDoEnvio);
                dataGeracao = dataEnvio;
                bcoT = getBco_bancoT(ccoT.getBco_nr_id());
                nomeArquivo = nomeArquivoBanese + dataEnvio + "." + sequencial + ".REM";
                if (bcoT != null) {
                    if (bcoT.getBco_tx_nome().toUpperCase().indexOf("BRASIL") > -1) {
                        nomeArquivo = nomeArquivoBancoBrasil + sequencial + ".REM";
                    }
                }
            }

            sbArquivosBancos.append(getCabecalhoBB());

            String nomeParametro = "valorCusto001";
            Par_parametroT parT = getPar_parametroDAOLocal().getByPar_tx_nome(nomeParametro);
            String custoBB = parT.getPar_tx_valor();
            nomeParametro = "valorCusto047";
            parT = getPar_parametroDAOLocal().getByPar_tx_nome(nomeParametro);
            String custoBanese = parT.getPar_tx_valor();
            for (Vw_parcelasT vw_parcelasT : list) {
                StringBuffer sb = new StringBuffer();
                sb.append(vw_parcelasT.getBco_nr_id()).append(";").append(vw_parcelasT.getCli_nr_id());
                Cco_contacorrenteT ccoT = contasClientes.get(sb.toString());
                if (ccoT != null) {
                    String codigoCliente = Text.padRight(String.valueOf(vw_parcelasT.getCli_tx_cpf()), ' ', 25);
                    double vlCusto = Double.parseDouble(custoBanese);
                    if ("001".equals(codigoBanco)) {
                        codigoCliente = Text.padRight(String.valueOf(vw_parcelasT.getCli_tx_matricula()), ' ', 25);
                        vlCusto = Double.parseDouble(custoBB);
                    }
                    identificacaoClienteEmpresa = codigoCliente;//"0000000000000000000000000";
                    agenciaCliente = Text.padLeft(ccoT.getCco_tx_nragencia(), '0', 4);// "0000";
                    //Alterado por George
                    identificacaoClienteBanco = ccoT.getCco_tx_nrcontacorrente();
                    identificacaoClienteBanco = identificacaoClienteBanco.substring(0, identificacaoClienteBanco.length() - 1);
                    identificacaoClienteBanco = Text.padLeft(identificacaoClienteBanco, '0', 13);//"00000000000000";
                    //Fim Alteracao de George
                    //dataVencimento = SDF.format(vw_parcelasT.getPle_dt_vencimento());
                    dataVencimento = dataEnvio;
                    double vlParcela = (vw_parcelasT.getPle_nr_valorparcela() + vlCusto);
                    BigDecimal bd = new BigDecimal(vlParcela * 100);
                    valorDebito = Text.padLeft(String.valueOf(bd.longValue()), '0', 15);// "000000000000000";
                    codigoMoeda = "03";
                    //usoEmpresa = "000000000000000000000000000000000000000000000000000000000000";
                    //usoEmpresa = vw_parcelasT.getPle_tx_tipo() + Text.padLeft(String.valueOf(vw_parcelasT.getPle_nr_id()), '0', 59);
                    usoEmpresa = vw_parcelasT.getPle_tx_tipo() + Text.padLeft(String.valueOf(vw_parcelasT.getCli_tx_matricula()), '0', 10) + Text.padLeft(String.valueOf(vw_parcelasT.getPle_nr_id()), '0', 49);
                    tipoIdentificacao = "2"; // CPF
                    cpfCnpj = Text.padLeft(vw_parcelasT.getCli_tx_cpf(), '0', 15);// "000000999999999";
                    brancosE = "                    ";
                    codigoMovimento = "0";
                    qntRegistros++;
                    somatorioValor += convertStringDouble(valorDebito);
                    //somatorioValor += vlParcela;
                    String linha = getRegistrosDebitoContaBB();
                    sbArquivosBancos.append("\r\n").append(linha);
                    RemessaT remessaT = new RemessaT();
                    remessaT.setLinha(linha);
                    registrarEnvioBanco(vw_parcelasT.getPle_nr_id(), "E");
//                    listRemessa.add(remessaT);
                }
            }
            totalRegistros = Text.padLeft(String.valueOf(qntRegistros), '0', 6);
            BigDecimal bdSomatorio = new BigDecimal(somatorioValor * 100);
            somatorio = Text.padLeft(String.valueOf(bdSomatorio.longValue()), '0', 17);
            sbArquivosBancos.append("\r\n").append(getFinalizacao());

            Arb_arquivobancoT arbT = new Arb_arquivobancoT();
            arbT.setArb_by_arquivo(sbArquivosBancos.toString().getBytes());
            arbT.setArb_dt_data(new Timestamp(System.currentTimeMillis()));
            arbT.setArb_tx_tipo("REM");
            arbT.setArb_nr_seq(nrSeq);
            getArb_arquivobancoDAO().insert(arbT);

//            getResponse().setBufferSize(9999999);
//            getResponse().setContentType("application/rem");
//            getResponse().setHeader("Content-Disposition", ";filename=" + nomeArquivo);
//            getResponse().getOutputStream().write(sbArquivosBancos.toString().getBytes());
//            getResponse().getOutputStream().flush();
//            getResponse().getOutputStream().close();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/rem");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, nomeArquivo);
            getRequest().setAttribute(EasyDownloadJB.DATA, sbArquivosBancos.toString().getBytes());
            getPage().forward("/portal/easydownload.jsp");
            //System.out.println(sbArquivosBancos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    private String getCabecalhoBB() throws Exception {
        StringBuffer sb = new StringBuffer();
        Bco_bancoT bcoT = new Bco_bancoT();
        System.out.println("Log id banco: " + vw_parcelasT.getBco_nr_id());
        bcoT.setBco_nr_id(vw_parcelasT.getBco_nr_id());
        List<Bco_bancoT> listBco = getBco_bancoDAO().getByPK(bcoT);
        bcoT = listBco.size() > 0 ? listBco.get(0) : null;
        if (bcoT != null) {
            System.out.println("Log codigobanco: " + bcoT.getBco_tx_codigo());
            String tipo = "P".equals(vw_parcelasT.getPle_tx_tipo()) ? "Parcela" : "Mensalidade";
            String nomeParametro = "numeroConvenio" + bcoT.getBco_tx_codigo() + tipo;
            codigoBanco = Text.padLeft(bcoT.getBco_tx_codigo(), '0', 3);
            nomeBanco = Text.padRight(bcoT.getBco_tx_nome(), ' ', 20);
            System.out.println("Log nomeparametor: " + nomeParametro + " / " + codigoBanco + " / " + nomeBanco);
            Par_parametroT parT = getPar_parametroDAOLocal().getByPar_tx_nome(nomeParametro);
            codigoConvenio = Text.padRight(parT.getPar_tx_valor(), ' ', 20);
            //A200104               CASSERP BENEFICIOS  047BANCO DE SERGIPE    2010062900082904DEBITO AUTOMATICO                                                   0
            sb.append("A").append("1").append(codigoConvenio).append(nomeEmpresa).append(codigoBanco).append(nomeBanco).append(dataGeracao).append(sequencial).append(versaoLayout).append(identificacaoServico).append(brancos);
            return sb.toString();
        }
        return "null";
    }

    public void gerarRemessaIdsParcelaCF() {
        try {
            idsParcelas = idsParcelas.replace("-", ",");
            StringBuffer sbArquivosBancos = new StringBuffer();
            System.out.println("tipo " + vw_parcelasT.getPle_tx_tipo());
            List<Vw_parcelasT> list = getVw_parcelasDAO().getByRemessaIdsParcelas(idsParcelas, bco_nr_id);

            int qntRegistros = 2;
            double somatorioValor = 0;
            loadContasClientes();
            Bco_bancoT bcoT = null;
            String dataEnvio = "";
            System.out.println("Size parcelas: " + list.size());
            if (list.size() > 0) {
                vw_parcelasT = list.get(0);
                System.out.println("tipo 2 " + vw_parcelasT.getPle_tx_tipo());
                System.out.println("banco 2 " + vw_parcelasT.getBco_tx_codigo());
                StringBuffer sb = new StringBuffer();
                sb.append(vw_parcelasT.getBco_nr_id()).append(";").append(vw_parcelasT.getCli_nr_id());
                Cco_contacorrenteT ccoT = contasClientes.get(sb.toString());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataDoEnvio = sdf.parse(dtEnvio);
                sdf = new SimpleDateFormat("yyyyMMdd");
                dataEnvio = sdf.format(dataDoEnvio);
                dataGeracao = dataEnvio;
                bcoT = getBco_bancoT(ccoT.getBco_nr_id());
                nomeArquivo = nomeArquivoBanese + dataEnvio + "." + sequencial + ".REM";
                if (bcoT != null) {
                    if (bcoT.getBco_tx_nome().toUpperCase().indexOf("BRASIL") > -1) {
                        nomeArquivo = nomeArquivoBancoBrasil + sequencial + ".REM";
                    } else if (bcoT.getBco_tx_nome().toUpperCase().indexOf("CAIXA") > -1) {
                        //Preparando para o envio para a Caixa
                        nomeArquivo = nomeArquivoCaixa + sequencial + ".REM";
                    }
                }
            }

            sbArquivosBancos.append(getCabecalhoCF());

            String nomeParametro = "valorCusto001";
            Par_parametroT parT = getPar_parametroDAOLocal().getByPar_tx_nome(nomeParametro);
            String custoBB = parT.getPar_tx_valor();
            nomeParametro = "valorCusto047";
            parT = getPar_parametroDAOLocal().getByPar_tx_nome(nomeParametro);
            String custoBanese = parT.getPar_tx_valor();
            for (Vw_parcelasT vw_parcelasT : list) {
                StringBuffer sb_ = new StringBuffer();
                sb_.append(vw_parcelasT.getBco_nr_id()).append(";").append(vw_parcelasT.getCli_nr_id());
                Cco_contacorrenteT ccoT = contasClientes.get(sb_.toString());

                if (ccoT != null) {
                    String codigoCliente = Text.padRight(String.valueOf(vw_parcelasT.getCli_tx_cpf()), ' ', 25);
                    double vlCusto = Double.parseDouble(custoBanese);
                    if ("001".equals(codigoBanco)) {
                        codigoCliente = Text.padRight(String.valueOf(vw_parcelasT.getCli_tx_cpf()), ' ', 25);
                        vlCusto = Double.parseDouble(custoBB);
                        identificacaoClienteBanco = ccoT.getCco_tx_nrcontacorrente();
                        identificacaoClienteBanco = identificacaoClienteBanco.substring(0, identificacaoClienteBanco.length() - 1);
                        identificacaoClienteBanco = Text.padLeft(identificacaoClienteBanco, '0', 13);//"00000000000000";

                    } else if ("104".equals(codigoBanco)) {
                        //preparando para o banco Caixa
                        codigoCliente = Text.padRight(String.valueOf(vw_parcelasT.getCli_tx_cpf()), ' ', 25);
                        vlCusto = Double.parseDouble(custoBB);
                        String codigoOperacao = "003";
                        identificacaoClienteBanco = /*codigoOperacao +*/ ccoT.getCco_tx_nrcontacorrente();
                        identificacaoClienteBanco = Text.padLeft(identificacaoClienteBanco, '0', 12);//"00000000000000";
                    }
                    identificacaoClienteEmpresa = codigoCliente;//"0000000000000000000000000";
                    agenciaCliente = Text.padLeft(ccoT.getCco_tx_nragencia(), '0', 4);// "0000";
                    //Alterado por George

                    //Fim Alteracao de George
                    //dataVencimento = SDF.format(vw_parcelasT.getPle_dt_vencimento());
                    dataVencimento = dataEnvio;
                    double vlParcela = (vw_parcelasT.getPle_nr_valorparcela() + vlCusto);
                    BigDecimal bd = new BigDecimal(vlParcela * 100);
                    valorDebito = Text.padLeft(String.valueOf(bd.longValue()), '0', 15);// "000000000000000";
                    codigoMoeda = "03";
                    numeroSequencialRegCF++;
                    masknumeroSeqRegCF = Text.padLeft(numeroSequencialRegCF + "", '0', 6);
                    //usoEmpresa = "000000000000000000000000000000000000000000000000000000000000";
                    //usoEmpresa = vw_parcelasT.getPle_tx_tipo() + Text.padLeft(String.valueOf(vw_parcelasT.getPle_nr_id()), '0', 59);
                    usoEmpresa = vw_parcelasT.getPle_tx_tipo() + Text.padLeft(String.valueOf(vw_parcelasT.getCli_tx_matricula()), '0', 10) + Text.padLeft(String.valueOf(vw_parcelasT.getPle_nr_id()), '0', 49);
                    tipoIdentificacao = "2"; // CPF
                    cpfCnpj = Text.padLeft(vw_parcelasT.getCli_tx_cpf(), '0', 15);// "000000999999999";
                    brancosE = "                    ";
                    codigoMovimento = "0";
                    qntRegistros++;
                    somatorioValor += convertStringDouble(valorDebito);
                    //somatorioValor += vlParcela;
                    String linha = getRegistrosDebitoContaCF();
                    sbArquivosBancos.append("\r\n").append(linha);
                    RemessaT remessaT = new RemessaT();
                    remessaT.setLinha(linha);
                    registrarEnvioBanco(vw_parcelasT.getPle_nr_id(), "E");
//                    listRemessa.add(remessaT);
                }
            }
            totalRegistros = Text.padLeft(String.valueOf(qntRegistros), '0', 6);
            BigDecimal bdSomatorio = new BigDecimal(somatorioValor * 100);
            somatorio = Text.padLeft(String.valueOf(bdSomatorio.longValue()), '0', 17);
            sbArquivosBancos.append("\r\n").append(getFinalizacao());

            Arb_arquivobancoT arbT = new Arb_arquivobancoT();
            arbT.setArb_by_arquivo(sbArquivosBancos.toString().getBytes());
            arbT.setArb_dt_data(new Timestamp(System.currentTimeMillis()));
            arbT.setArb_tx_tipo("REM");
            arbT.setArb_nr_seq(nrSeq);
            getArb_arquivobancoDAO().insert(arbT);

//            getResponse().setBufferSize(9999999);
//            getResponse().setContentType("application/rem");
//            getResponse().setHeader("Content-Disposition", ";filename=" + nomeArquivo);
//            getResponse().getOutputStream().write(sbArquivosBancos.toString().getBytes());
//            getResponse().getOutputStream().flush();
//            getResponse().getOutputStream().close();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/rem");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, nomeArquivo);
            getRequest().setAttribute(EasyDownloadJB.DATA, sbArquivosBancos.toString().getBytes());
            getPage().forward("/portal/easydownload.jsp");
            //System.out.println(sbArquivosBancos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void main(String[] ola) {
        // System.out.println("valor doble "+convertStringDouble("100"));

    }

    private double convertStringDouble(String strValue) {
        String strvl = "";
        for (int i = 0; i < strValue.length(); i++) {
            strvl += strValue.substring(i, i + 1);
            if (strValue.length() - (i + 1) == 2) {
                strvl += ".";
            }
        }
        System.out.println(strvl);
        return Double.parseDouble(strvl);
    }

    private String getCabecalhoCF() throws Exception {
        //dataGeracao = SDF.format(new Date());
        StringBuffer sb = new StringBuffer();
        Bco_bancoT bcoT = new Bco_bancoT();
        System.out.println("Log id banco: " + vw_parcelasT.getBco_nr_id());
        bcoT.setBco_nr_id(vw_parcelasT.getBco_nr_id());
        List<Bco_bancoT> listBco = getBco_bancoDAO().getByPK(bcoT);
        bcoT = listBco.size() > 0 ? listBco.get(0) : null;
        if (bcoT != null) {
            System.out.println("Log codigobanco: " + bcoT.getBco_tx_codigo());
            String tipo = "P".equals(vw_parcelasT.getPle_tx_tipo()) ? "Parcela" : "Mensalidade";
            String nomeParametro = "numeroConvenio" + bcoT.getBco_tx_codigo() + tipo;
            codigoBanco = Text.padLeft(bcoT.getBco_tx_codigo(), '0', 3);
            nomeBanco = Text.padRight(bcoT.getBco_tx_nome(), ' ', 20);
            System.out.println("Log nomeparametor: " + nomeParametro + " / " + codigoBanco + " / " + nomeBanco);

            Par_parametroT parT = getPar_parametroDAOLocal().getByPar_tx_nome(nomeParametro);
            codigoConvenio = parT.getPar_tx_valor();

            parT = getPar_parametroDAOLocal().getByPar_tx_nome("tipo_compromisso104");
            codigoConvenio += parT.getPar_tx_valor();

            parT = getPar_parametroDAOLocal().getByPar_tx_nome("numero_compromisso104");
            codigoConvenio += parT.getPar_tx_valor();

            codigoConvenio = Text.padRight(codigoConvenio, ' ', 20);
            //A200104               CASSERP BENEFICIOS  047BANCO DE SERGIPE    2010062900082904DEBITO AUTOMATICO                                                   0
            sb.append("A").append("1").append(codigoConvenio).append(nomeEmpresa).append(codigoBanco).append(nomeBanco).append(dataGeracao).append(sequencial).append(versaoLayout);
            if ("104".equalsIgnoreCase(codigoBanco)) {
                parT = getPar_parametroDAOLocal().getByPar_tx_nome("agencia104");
                String ag = parT.getPar_tx_valor();

                parT = getPar_parametroDAOLocal().getByPar_tx_nome("operacaoConta104");
                String operacaoConta = parT.getPar_tx_valor();

                parT = getPar_parametroDAOLocal().getByPar_tx_nome("conta104");
                String nrConta = parT.getPar_tx_valor();

                parT = getPar_parametroDAOLocal().getByPar_tx_nome("digitoConta104");
                String dvConta = parT.getPar_tx_valor();

                parT = getPar_parametroDAOLocal().getByPar_tx_nome("idAmbienteCliente");
                String idAmbienteCliente = parT.getPar_tx_valor();
                parT = getPar_parametroDAOLocal().getByPar_tx_nome("idAmbienteCaixa");
                String idAmbienteCaixa = parT.getPar_tx_valor();

                //27 posicoes
                String brancos14 = "                           ";
                String nrSeqRegistro = "000000";
                String brancos16 = " ";
                sb.append(identificacaoServicoCaixa).append(ag)
                        .append(operacaoConta)
                        .append(nrConta).append(dvConta)
                        .append(idAmbienteCliente)
                        .append(idAmbienteCaixa)
                        .append(brancos14)
                        .append(nrSeqRegistro)
                        .append(brancos16);
            } else {
                sb.append(identificacaoServico).append(brancos);
            }

            return sb.toString();
        }
        return "null";
    }

    private String getRegistrosDebitoContaCF() {
        StringBuffer sb = new StringBuffer();
        if ("104".equalsIgnoreCase(codigoBanco)) {
            sb.append("E").append(identificacaoClienteEmpresa).append(agenciaCliente).append(identificacaoClienteBanco).append("  ").append(dataVencimento).append(valorDebito).append(codigoMoeda).append(usoEmpresa).append(masknumeroSeqRegCF).append("        ").append(masknumeroSeqRegCF).append(codigoMovimento);
        } else {
            String contador = Text.padLeft("" + contRegistroCaixa, '0', 6);
            String brancos = "        ";
            String numSeqRegistro = "";
            sb.append("E").append(identificacaoClienteEmpresa).append(agenciaCliente).append(identificacaoClienteBanco).append(" ").append(dataVencimento).append(valorDebito).append(codigoMoeda).append(usoEmpresa).append(contador).append(brancos).append(numSeqRegistro).append(codigoMovimento);
            contRegistroCaixa++;
        }
        return sb.toString();
    }

    private String getRegistrosDebitoContaBB() {
        StringBuffer sb = new StringBuffer();
        sb.append("E").append(identificacaoClienteEmpresa).append(agenciaCliente).append(identificacaoClienteBanco).append(" ").append(dataVencimento).append(valorDebito).append(codigoMoeda).append(usoEmpresa).append(brancosE).append(codigoMovimento);
        return sb.toString();
    }

    /**
     * Cadastro no banco (BB ou Banese) um novo cliente para debito em conta,
     * registro tipo B
     *
     * @return
     */
    private String getCadastroBancoDebitoConta(String codigoCliente, String agencia, String conta) {
        StringBuffer sb = new StringBuffer();
        String dataExclusaoInclusao = SDF.format(new Date());
        String brancos = Text.padLeft(" ", ' ', 97);
        String codigoMov = "2";//optante pelo debito automatico
        codigoCliente = Text.padRight(codigoCliente, ' ', 25);
        agencia = Text.padLeft(agencia, '0', 4);
        conta = Text.padLeft(conta, '0', 14);
        sb.append("B").append(codigoCliente).append(agencia).append(conta).append(dataExclusaoInclusao).append(brancos).append(codigoMov);
        return sb.toString();
    }

    private String getFinalizacao() {
        StringBuffer sb = new StringBuffer();
        //totalRegistros = "10";
        //totalRegistros = Text.padLeft(totalRegistros, '0', 6);
        sb.append("Z").append(totalRegistros).append(somatorio).append(brancosZ);
        return sb.toString();
    }

    /**
     * @return the vw_parcelasT
     */
    public Vw_parcelasT getVw_parcelasT() {
        return vw_parcelasT;
    }

    /**
     * @param vw_parcelasT the vw_parcelasT to set
     */
    public void setVw_parcelasT(Vw_parcelasT vw_parcelasT) {
        this.vw_parcelasT = vw_parcelasT;
    }

    /**
     * @return the listRemessa
     */
    public List<RemessaT> getListRemessa() {
        return listRemessa;
    }

    /**
     * @param listRemessa the listRemessa to set
     */
    public void setListRemessa(List<RemessaT> listRemessa) {
        this.listRemessa = listRemessa;
    }

    /**
     * @return the idsParcelas
     */
    public String getIdsParcelas() {
        return idsParcelas;
    }

    /**
     * @param idsParcelas the idsParcelas to set
     */
    public void setIdsParcelas(String idsParcelas) {
        this.idsParcelas = idsParcelas;
    }

    /**
     * @return the dtEnvio
     */
    public String getDtEnvio() {
        return dtEnvio;
    }

    /**
     * @param dtEnvio the dtEnvio to set
     */
    public void setDtEnvio(String dtEnvio) {
        this.dtEnvio = dtEnvio;
    }

    /**
     * @return the nrSeq
     */
    public int getNrSeq() {
        return nrSeq;
    }

    /**
     * @param nrSeq the nrSeq to set
     */
    public void setNrSeq(int nrSeq) {
        this.nrSeq = nrSeq;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the orgaos
     */
    public String getOrgaos() {
        return orgaos;
    }

    /**
     * @param orgaos the orgaos to set
     */
    public void setOrgaos(String orgaos) {
        this.orgaos = orgaos;
    }

    /**
     * @return the bco_nr_id
     */
    public int getBco_nr_id() {
        return bco_nr_id;
    }

    /**
     * @param bco_nr_id the bco_nr_id to set
     */
    public void setBco_nr_id(int bco_nr_id) {
        this.bco_nr_id = bco_nr_id;
    }
}
