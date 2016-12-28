/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.transfer.Arb_arquivobancoT;
import br.com.easynet.gwt.i9factory.transfer.Cco_contacorrenteT;
import br.com.easynet.gwt.i9factory.transfer.Ple_parcelaemprestimoT;
import br.com.easynet.gwt.i9factory.transfer.Teb_transmissao_empresa_bancoT;
import br.com.easynet.gwt.i9factory.util.BaixaBancaria;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author geoleite
 */
public class ArquivoRetornoJB extends SystemBase implements INotSecurity {

    private static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
    private byte[] arquivo;
    private static Pattern pTipoRegistroA = Pattern.compile("^A");
    private static Pattern pTipoRegistroZ = Pattern.compile("^Z");
    private static Pattern pTipoRegistroF = Pattern.compile("^F");
    private static Pattern pTipoRegistroB = Pattern.compile("^B");
    private static Pattern pCodigoBanco = Pattern.compile("[\\w|\\.| ]{40}(\\d{3})");
    private static Pattern pCodigoCliente = Pattern.compile("\\w{1}(\\d{25})");
    private static Pattern pCodigoSequencial = Pattern.compile(".{73}(\\d{6})");
    private static Pattern pDataCadDelVenc = Pattern.compile(".{44}(\\d{8})");
    private static Pattern pCodigoLancamento = Pattern.compile(".{80}(\\d{49})");
    private static Pattern pCodigoRetorno = Pattern.compile(".{67}(\\d{2})");
    private static Pattern p2OB12 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  12*");
    private static Pattern p2OB13 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  13*");
    private static Pattern p2OB14 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  14*");
    private static Pattern p2OB15 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  15*");
    private static Pattern p2OB16 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  16*");
    private static Pattern p2OB21 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  21*");
    private static Pattern p2OB22 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  22*");
    private static Pattern p2OB23 = Pattern.compile("^2( {5})(\\d{15})RE(\\d{10})OB(\\d)(\\d{13})  23*");
    private static Pattern p1 = Pattern.compile("^1");
    private static List<Pattern> listPattern = new ArrayList<Pattern>();
    private static TreeMap<String, String> mapMetodo = new TreeMap<String, String>();
    private int codigoSequencial;

    static {
        listPattern.add(pTipoRegistroA);
        mapMetodo.put(pTipoRegistroA.toString(), "executeTipoRegistroA");
        listPattern.add(pTipoRegistroZ);
        mapMetodo.put(pTipoRegistroZ.toString(), "executeTipoRegistroZ");
        listPattern.add(pTipoRegistroF);
        mapMetodo.put(pTipoRegistroF.toString(), "executeTipoRegistroF");
        listPattern.add(pTipoRegistroB);
        mapMetodo.put(pTipoRegistroB.toString(), "executeTipoRegistroB");
    }

    public static void main(String[] param) {
        try {
            /*
            CharSequence inputStr = "A119408               CASSERP BENEFICIOS  001Banco do Brasil     2011073000001205DEBITO AUTOMATICO                                                    ";
            //CharSequence inputStr = "E00000000000000000000000100454000000000123232011070700000000000120003M000000000000000000000000000000000000000000000000000000015802000091136830553    0";
            //            CharSequence inputStr = "B000000000000000000000001212340000000000432120110730                                                                                                 2";

            String patternStr = "[\\w|\\.| ]{40}(\\d{3})";

            // Compile and use regular expression
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(inputStr);
            boolean matchFound = matcher.find();

            if (matchFound) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(matcher.groupCount()));
            // Get all groups for this match
            //                for (int i = 0; i <= matcher.groupCount(); i++) {
            //                    String groupStr = matcher.group(i);
            //                    System.out.println(groupStr);
            //                }
            }
             */
            FileInputStream fis = new FileInputStream("/Users/geoleite/Desktop/SDA.DAT.106682.20120227.50104.RET");
            int controle = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((controle = fis.read()) != -1) {
                baos.write(controle);
            }
            fis.close();

            ArquivoRetornoJB retorno = new ArquivoRetornoJB();
            retorno.arquivo = baos.toByteArray();
            retorno.processoBaixa();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrarBaixa() {
        try {
            if (arquivo == null) {
                System.out.println("Nulo");
            } else {
                processoBaixa();
                Arb_arquivobancoT arbT = new Arb_arquivobancoT();
                arbT.setArb_by_arquivo(arquivo);
                arbT.setArb_dt_data(new Timestamp(System.currentTimeMillis()));
                arbT.setArb_tx_tipo("RET");
                arbT.setArb_nr_seq(codigoSequencial);
                getArb_arquivobancoDAO().insert(arbT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void identificandoTipoLinha(String linha) throws Exception {
        for (Pattern pattern : listPattern) {
            Matcher matcher = pattern.matcher(linha);
            if (matcher.find()) {
                String metodo = mapMetodo.get(pattern.toString());
                Class[] param = {String.class};
                Method method = this.getClass().getMethod(metodo, param);
                Object[] valores = {linha};
                try {
                    method.invoke(this, valores);
                } catch (Exception e) {
                    System.err.println("Contem erros na linha " + e.getCause().getMessage());
                }
                //System.out.println(" OK " + pattern.toString());
                continue;
            }
        }
    }

    private void processoBaixa() throws Exception {
        StringReader sr = new StringReader(new String(arquivo));
        BufferedReader br = new BufferedReader(sr);
        while (br.ready()) {
            String linha = br.readLine();
            if (linha == null) {
                break;
            } else if (linha != null && linha.trim().length() > 0) {
                identificandoTipoLinha(linha);
            }
        }
    }

    public void executeTipoRegistroA(String linha) {
        System.out.println("A");
        Matcher matcher = pCodigoSequencial.matcher(linha);
        if (matcher.find()) {
            System.out.println("Codigo Sequencial:" + matcher.group(matcher.groupCount()));
            codigoSequencial = Integer.parseInt(matcher.group(matcher.groupCount()));
        }
    }

    public void executeTipoRegistroZ(String linha) {
        System.out.println("Z");
    }

    public void executeTipoRegistroF(String linha) {
        System.out.println("F");
        try {
            Matcher matcher = pCodigoCliente.matcher(linha);
            if (matcher.find()) {
                System.out.println("Codigo CLiente:" + matcher.group(matcher.groupCount()));
            }
            matcher = pDataCadDelVenc.matcher(linha);
            String dataDebito = "";
            if (matcher.find()) {
                System.out.println("Dt cad|del|ven:" + matcher.group(matcher.groupCount()));
                dataDebito = matcher.group(matcher.groupCount());
            }
            matcher = pCodigoLancamento.matcher(linha);
            String codigoParcela = "-1";
            if (matcher.find()) {
                System.out.println("Codigo Lancamento:" + matcher.group(matcher.groupCount()));
                codigoParcela = matcher.group(matcher.groupCount());
            }
            matcher = pCodigoRetorno.matcher(linha);
            String codigoRetorno = "-1";
            if (matcher.find()) {
                codigoRetorno = matcher.group(matcher.groupCount());
            }
            if ("00".equals(codigoRetorno)) {
                Ple_parcelaemprestimoT pleT = new Ple_parcelaemprestimoT();
                pleT.setPle_nr_id(Integer.parseInt(codigoParcela));
                List<Ple_parcelaemprestimoT> listPle = getPle_parcelaemprestimoDAO().getByPle_nr_id(pleT);
                if (listPle.size() > 0) {
                    pleT = listPle.get(0);
                    //Verificando se esta parcela está vinculada à outra
                    if (pleT.getPle_nr_id_vinculo() != 0) {
                        Ple_parcelaemprestimoT pleTVinculo = new Ple_parcelaemprestimoT();
                        pleTVinculo.setPle_nr_id(pleT.getPle_nr_id_vinculo());
                        List<Ple_parcelaemprestimoT> listPleVinculo = getPle_parcelaemprestimoDAO().getByPle_nr_id(pleTVinculo);
                        if (listPleVinculo.size() > 0) {
                            //Simula a baixa da mensalidade zerando o valor
                            pleTVinculo = listPleVinculo.get(0);
                            pleT.setPle_nr_valorparcela(pleT.getPle_nr_valorparcela() - pleTVinculo.getPle_nr_valorparcela());
                            pleT.setPle_dt_pagamento(SDF.parse(dataDebito));
                            StringBuffer descricao = new StringBuffer("Vinculação de Título: foi feito uma vinculação do título");
                            descricao.append(pleT.getPle_nr_id()).append(" com valor de").append(pleT.getPle_nr_valorparcela())
                                    .append(", com o título ").append(pleTVinculo.getPle_nr_id_vinculo())
                                    .append(" de valor de ").append(pleTVinculo.getPle_nr_valorparcela());
                            pleT.setPle_tx_historico(descricao.toString());
                            getPle_parcelaemprestimoDAO().updateBaixaVinculada(pleT);
                            atualizarRegistroEnviadoBanco(pleT.getPle_nr_id(), codigoRetorno);
                            pleT = pleTVinculo;
                        } else {
                            System.err.println("Nao encontrou Parcela vinculada: " + pleTVinculo.getPle_nr_id());
                        }
                    }
                    pleT.setPle_dt_pagamento(SDF.parse(dataDebito));
                    getPle_parcelaemprestimoDAO().updateDataPagamento(pleT);
                    atualizarRegistroEnviadoBanco(pleT.getPle_nr_id(), codigoRetorno);
                    getPle_parcelaemprestimoDAO().commit();
                } else {
                    System.err.println("Nao encontrou Parcela: " + pleT.getPle_nr_id());
                }
            } else {
                Ple_parcelaemprestimoT pleT = new Ple_parcelaemprestimoT();
                pleT.setPle_nr_id(Integer.parseInt(codigoParcela));
                List<Ple_parcelaemprestimoT> listPle = getPle_parcelaemprestimoDAO().getByPle_nr_id(pleT);
                if (listPle.size() > 0) {
                    pleT = listPle.get(0);
                    atualizarRegistroEnviadoBanco(pleT.getPle_nr_id(), codigoRetorno);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Atualizando retorno
     * @param tebNrId
     * @param status
     * @throws Exception
     */
    private void atualizarRegistroEnviadoBanco(int tebNrId, String status) throws Exception {
        Teb_transmissao_empresa_bancoT tebT = new Teb_transmissao_empresa_bancoT();
        tebT.setTeb_nr_id(tebNrId);
        tebT.setTeb_tx_status(status);
        getTeb_transmissao_empresa_bancoDAO().update(tebT);
    }

    private void retorno() {
        /*
        “00” = Débito efetuado
        “01” = Débito não efetuado - Insuficiência de fundos
        “02” = Débito não efetuado - Conta não cadastrada
        “04” = Débito não efetuado - Outras restrições
        “05” = Débito não efetuado – valor do débito excede valor limite
        aprovado.
        “10” = Débito não efetuado - Agência em regime de encerramento
        “12” = Débito não efetuado - Valor inválido
        “13” = Débito não efetuado - Data de lançamento inválida
        “14” = Débito não efetuado - Agência inválida
        “15” = Débito não efetuado - conta inválida
        “18” = Débito não efetuado - Data do débito anterior à do
        processamento
        “19”= Débito não efetuado – Agência/Conta não pertence ao
        CPF/CNPJ informado
        “20” = Débito não efetuado – conta conjunta não solidária
        “30” = Débito não efetuado - Sem contrato de débito automático
        “31” = Débito efetuado em data diferente da data informada –
        feriado na praça de débito
        “96” = Manutenção do Cadastro
        “97” = Cancelamento - Não encontrado
        “98” = Cancelamento - Não efetuado, fora do tempo hábil
        “99” = Cancelamento - cancelado conforme solicitação
         */
    }

    public void executeTipoRegistroB(String linha) {
        System.out.println("B");
//        try {
//            Matcher matcher = pCodigoCliente.matcher(linha);
//            String codigoCliente = "";
//            if (matcher.find()) {
//                codigoCliente = matcher.group(matcher.groupCount());
//            }
//            matcher = pDataCadDelVenc.matcher(linha);
//            String dataDebito = "";
//            if (matcher.find()) {
//                dataDebito = matcher.group(matcher.groupCount());
//            }
//            int ccoNrId = Integer.parseInt(codigoCliente);
//            Cco_contacorrenteT ccoT = new Cco_contacorrenteT();
//            ccoT.setCco_nr_id(ccoNrId);
//            //atualizando a conta como cadastrada no banco
//            getCco_contacorrenteDAO().updateStatusCadBanco(ccoT);
//            atualizarRegistroEnviadoBanco(ccoNrId, "O");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * @return the arquivo
     */
    public byte[] getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
}
