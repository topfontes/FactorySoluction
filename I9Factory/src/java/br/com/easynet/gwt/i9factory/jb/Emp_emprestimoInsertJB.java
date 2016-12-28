package br.com.easynet.gwt.i9factory.jb;

import java.text.ParseException;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class Emp_emprestimoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
    private int numeroParAFIN;
    private float valorParcAfin;
    private float valorMensalidade;
    private int numeroParcMensalidade;
    private int[] vetIdParcelas;
    private float[] vetDesconto;
    private String dataAverbacao;
    private int id_emprestimoBaixa;

    public void setEmp_emprestimoT(Emp_emprestimoT emp_emprestimoT) {
        this.emp_emprestimoT = emp_emprestimoT;
    }

    public Emp_emprestimoT getEmp_emprestimoT() {
        return emp_emprestimoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // Metodo de Eventos
    public void insert() throws Exception {
        DAOFactory factory = null;
        try {
            Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
            factory = emp_emprestimoDAO.getDAOFactory();
            factory.beginTransaction();
            emp_emprestimoT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());
//            int proposta = getProposta();
//            if(proposta == emp_emprestimoT.getEmp_nr_proposta()){
//
//            }
            //emp_emprestimoT.setEmp_nr_proposta(getProposta());
            emp_emprestimoDAO.insert(emp_emprestimoT);
            Ple_parcelaemprestimoDAO pdao = getPle_parcelaemprestimoDAO();
            Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
            ple_parcelaemprestimoT.setEmp_nr_id(emp_emprestimoT.getEmp_nr_id());
            int seq = emp_emprestimoT.getEmp_seq_nr_boletobb();
            for (int i = 1; i <= numeroParAFIN; i++) {
                ple_parcelaemprestimoT.setPle_dt_vencimento(gerarVencimento(i));
                ple_parcelaemprestimoT.setPle_nr_valorparcela(valorParcAfin);
                ple_parcelaemprestimoT.setPle_tx_parcela(formatarFloat("00", i) + "/" + formatarFloat("00", numeroParAFIN));
                ple_parcelaemprestimoT.setPle_tx_tipo("P");
                if(seq > 1){
                    ple_parcelaemprestimoT.setPle_nr_seq_boleto(seq);
                    seq ++;
                }
                pdao.insert(ple_parcelaemprestimoT);
            }

            ple_parcelaemprestimoT.setPle_nr_seq_boleto(0);
            for (int i = 1; i <= numeroParcMensalidade; i++) {
                ple_parcelaemprestimoT.setPle_dt_vencimento(gerarVencimento(i));
                ple_parcelaemprestimoT.setPle_nr_valorparcela(valorMensalidade);
                ple_parcelaemprestimoT.setPle_tx_parcela(formatarFloat("00", i) + "/" + formatarFloat("00", numeroParcMensalidade));
                ple_parcelaemprestimoT.setPle_tx_tipo("M");
                pdao.insert(ple_parcelaemprestimoT);
            }
            
            if (id_emprestimoBaixa > 0) {
                if (vetDesconto != null) {
                    Ple_parcelaemprestimoDAO pleDAO = getPle_parcelaemprestimoDAO();
                    for (int i = 0; i < vetIdParcelas.length; i++) {
                        int idParcela = vetIdParcelas[i];
                        float valorDesconto = vetDesconto[i];
                        ple_parcelaemprestimoT.setPle_nr_id(idParcela);
                        ple_parcelaemprestimoT.setPle_nr_valordesconto(valorDesconto);
                        ple_parcelaemprestimoT.setPle_dt_pagamento(new Date());
                        pleDAO.updateDesconto(ple_parcelaemprestimoT);
                    }
                }

                emp_emprestimoT = new Emp_emprestimoT();
                emp_emprestimoT.setEmp_nr_id(id_emprestimoBaixa);
                emp_emprestimoT.setEmp_dt_quitacao(new Date());
                emp_emprestimoT.setEmp_tx_status("P");

                emp_emprestimoDAO.updateBaixa(emp_emprestimoT);
            }

            setMsg(INFO, "Cadastro efetuado com sucesso!");
            factory.commitTransaction();
            clear();
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

    public int getProposta() {
        Emp_emprestimoDAO edao = null;
        try {
            edao = getEmp_emprestimoDAO();
            return edao.maxProposta() + 1;
        } catch (Exception e) {
        }
        return 0;
    }

    public static String formatarFloat(String zeros, int numero) {
        String num = zeros + numero;
        return num.substring(num.length() - zeros.length());
    }

    public static Date addDias(Date date, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dias);
        return calendar.getTime();
    }

    public Date gerarVencimento(int sequencia) {
        try {

            SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatMes = new SimpleDateFormat("MM");
            SimpleDateFormat formatDia = new SimpleDateFormat("dd");
            SimpleDateFormat formatAno = new SimpleDateFormat("yyyy");

            int mesAverbacao = Integer.parseInt(formatMes.format(formatData.parse(getDataAverbacao())));
            int anoAverbacao = Integer.parseInt(formatAno.format(formatData.parse(getDataAverbacao())));
            int dia = Integer.parseInt(formatDia.format(formatData.parse(getDataAverbacao())));

            int mes = mesAverbacao + (sequencia - 1);
            int ano = anoAverbacao;
            if (mes == 13) {
                mes = 1;
                ano++;
            }
            String data = formatarFloat("00", dia) + "/" + formatarFloat("00", mes) + "/" + ano;
            return formatData.parse(data);
        } catch (Exception e) {
        }
        return null;
    }
// Method de lookup
// 
    private List<Cli_clienteT> listcli_cliente;

    public List<Cli_clienteT> getListcli_cliente() {
        return listcli_cliente;
    }

    public void setListcli_cliente(List<Cli_clienteT> list) {
        this.listcli_cliente = list;
    }

    public void consultCli_cliente() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            listcli_cliente = cli_clienteDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Age_agenciadorT> listage_agenciador;

    public List<Age_agenciadorT> getListage_agenciador() {
        return listage_agenciador;
    }

    public void setListage_agenciador(List<Age_agenciadorT> list) {
        this.listage_agenciador = list;
    }

    public void consultAge_agenciador() throws Exception {
        try {
            Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
//			listage_agenciador=age_agenciadorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Idc_indiceT> listidc_indice;

    public List<Idc_indiceT> getListidc_indice() {
        return listidc_indice;
    }

    public void setListidc_indice(List<Idc_indiceT> list) {
        this.listidc_indice = list;
    }

    public void consultIdc_indice() throws Exception {
        try {
            Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
            listidc_indice = idc_indiceDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        emp_emprestimoT = new Emp_emprestimoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "emp_emprestimoConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the numeroParAFIN
     */
    public int getNumeroParAFIN() {
        return numeroParAFIN;
    }

    /**
     * @param numeroParAFIN the numeroParAFIN to set
     */
    public void setNumeroParAFIN(int numeroParAFIN) {
        this.numeroParAFIN = numeroParAFIN;
    }

    /**
     * @return the valorParcAfin
     */
    public float getValorParcAfin() {
        return valorParcAfin;
    }

    /**
     * @param valorParcAfin the valorParcAfin to set
     */
    public void setValorParcAfin(float valorParcAfin) {
        this.valorParcAfin = valorParcAfin;
    }

    /**
     * @return the valorMensalidade
     */
    public float getValorMensalidade() {
        return valorMensalidade;
    }

    /**
     * @param valorMensalidade the valorMensalidade to set
     */
    public void setValorMensalidade(float valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    /**
     * @return the numeroParcMensalidade
     */
    public int getNumeroParcMensalidade() {
        return numeroParcMensalidade;
    }

    /**
     * @param numeroParcMensalidade the numeroParcMensalidade to set
     */
    public void setNumeroParcMensalidade(int numeroParcMensalidade) {
        this.numeroParcMensalidade = numeroParcMensalidade;
    }

    /**
     * @return the vetIdParcelas
     */
    public int[] getVetIdParcelas() {
        return vetIdParcelas;
    }

    /**
     * @param vetIdParcelas the vetIdParcelas to set
     */
    public void setVetIdParcelas(int[] vetIdParcelas) {
        this.vetIdParcelas = vetIdParcelas;
    }

    /**
     * @return the vetDesconto
     */
    public float[] getVetDesconto() {
        return vetDesconto;
    }

    /**
     * @param vetDesconto the vetDesconto to set
     */
    public void setVetDesconto(float[] vetDesconto) {
        this.vetDesconto = vetDesconto;
    }

    /**
     * @return the id_emprestimoBaixa
     */
    public int getId_emprestimoBaixa() {
        return id_emprestimoBaixa;
    }

    /**
     * @param id_emprestimoBaixa the id_emprestimoBaixa to set
     */
    public void setId_emprestimoBaixa(int id_emprestimoBaixa) {
        this.id_emprestimoBaixa = id_emprestimoBaixa;
    }

    /**
     * @return the dataAverbacao
     */
    public String getDataAverbacao() {
        return dataAverbacao;
    }

    /**
     * @param dataAverbacao the dataAverbacao to set
     */
    public void setDataAverbacao(String dataAverbacao) {
        this.dataAverbacao = dataAverbacao;
    }
}
