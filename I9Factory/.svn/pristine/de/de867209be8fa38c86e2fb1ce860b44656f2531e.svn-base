package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Criada Automaticamente pelo "EasyNet Generate JDragon"
 */
public class Emp_emprestimoUpdateDeleteJB extends SystemBase {

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
    private List<Emp_emprestimoT> list;

    public List<Emp_emprestimoT> getList() {
        return list;
    }

    public void setList(List<Emp_emprestimoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void clear() throws Exception {

        emp_emprestimoT = new Emp_emprestimoT();
    }

    public boolean OperacaoValida() throws Exception {
        boolean res = true;
        try {
            Ple_parcelaemprestimoDAO pdao = getPle_parcelaemprestimoDAO();
            List<Ple_parcelaemprestimoT> listTemp = pdao.getByEmp_emprestimo(emp_emprestimoT);
            if (listTemp.size() > 0) {
                res = false;
            }
            return res;
        } catch (Exception e) {
            throw e;
        } finally {
        }

    }

    public void delete() throws Exception {
        DAOFactory factory = null;
        try {
            if (exist()) {
                if (OperacaoValida()) {
                    Ple_parcelaemprestimoDAO pdao = getPle_parcelaemprestimoDAO();
                    factory = pdao.getDAOFactory();
                    factory.beginTransaction();
                    pdao.deleteAllEmprestimo(emp_emprestimoT);
                    Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
                    emp_emprestimoDAO.delete(emp_emprestimoT);
                    setMsg("Exclusao efetuada com sucesso!");
                    clear();
                    factory.commitTransaction();
                } else {
                    setMsg("Falha, existe parcelas quitadas deste emprestimo, favor verificar !");
                }
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
            List<Emp_emprestimoT> listTemp = emp_emprestimoDAO.getByPK(emp_emprestimoT);

            boolean res = list != null & listTemp.size() > 0;
            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;
    }

    public void updatecompensado() throws Exception {
        try {
            Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
            emp_emprestimoDAO.updateCompensado(emp_emprestimoT);   
            setMsg("Operação realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void update() throws Exception {
        String ms = "";
        if (exist()) {
//            if (OperacaoValida()) {
            DAOFactory factory = null;
            try {
                Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
                factory = emp_emprestimoDAO.getDAOFactory();
                factory.beginTransaction();
                emp_emprestimoT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());
                emp_emprestimoDAO.update(emp_emprestimoT);

                if (OperacaoValida()) {
                    Ple_parcelaemprestimoDAO pdao = getPle_parcelaemprestimoDAO();
                    Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
                    ple_parcelaemprestimoT.setEmp_nr_id(emp_emprestimoT.getEmp_nr_id());
                    pdao.deleteAllEmprestimo(emp_emprestimoT);
                    for (int i = 1; i <= getNumeroParAFIN(); i++) {
                        ple_parcelaemprestimoT.setPle_dt_vencimento(gerarVencimento(i));
                        ple_parcelaemprestimoT.setPle_nr_valorparcela(getValorParcAfin());
                        ple_parcelaemprestimoT.setPle_tx_parcela(formatarFloat("00", i) + "/" + formatarFloat("00", getNumeroParAFIN()));
                        ple_parcelaemprestimoT.setPle_tx_tipo("P");
                        pdao.insert(ple_parcelaemprestimoT);
                    }

                    for (int i = 1; i <= getNumeroParcMensalidade(); i++) {
                        ple_parcelaemprestimoT.setPle_dt_vencimento(gerarVencimento(i));
                        ple_parcelaemprestimoT.setPle_nr_valorparcela(getValorMensalidade());
                        ple_parcelaemprestimoT.setPle_tx_parcela(formatarFloat("00", i) + "/" + formatarFloat("00", getNumeroParcMensalidade()));
                        ple_parcelaemprestimoT.setPle_tx_tipo("M");
                        pdao.insert(ple_parcelaemprestimoT);
                    }

                    if (getVetDesconto() != null) {
                        Ple_parcelaemprestimoDAO pleDAO = getPle_parcelaemprestimoDAO();
                        for (int i = 0; i < getVetIdParcelas().length; i++) {
                            int idParcela = getVetIdParcelas()[i];
                            float valorDesconto = getVetDesconto()[i];
                            ple_parcelaemprestimoT.setPle_nr_id(idParcela);
                            ple_parcelaemprestimoT.setPle_nr_valordesconto(valorDesconto);
                            ple_parcelaemprestimoT.setPle_dt_pagamento(new Date());
                            ple_parcelaemprestimoT.setPle_tx_historico("QUITADO COM EMPRESTIMO " + formatarFloat("0000", emp_emprestimoT.getEmp_nr_id()));
                            pleDAO.updateDesconto(ple_parcelaemprestimoT);
                        }//32115751
                    }
                } else {
                    ms = "parcelas quitadas";
                }

                emp_emprestimoT = new Emp_emprestimoT();
                emp_emprestimoT.setEmp_nr_id(getId_emprestimoBaixa());
                emp_emprestimoT.setEmp_dt_quitacao(new Date());
                emp_emprestimoT.setEmp_tx_status("P");
                emp_emprestimoDAO.updateBaixa(emp_emprestimoT);

                String testo = "Alteração efetuada com sucesso! " + ms;
                setMsg(INFO, testo);
                factory.commitTransaction();
                clear();
            } catch (Exception e) {
                factory.rollbackTransaction();
                e.printStackTrace();
                setMsg(ERROR, "Falha ao realizar cadastro! ");
            } finally {
                close();
            }
            setMsg("Alteracao efetuada com sucesso!" + ms);
//            } else {
//                setMsg("Falha, existe parcelas quitadas deste emprestimo, favor verificar !");
//            }
        } else {
            setMsg(ERROR, "Error: Registro inexistente!");
        }
    }

    public boolean parcelaquitada() {
        boolean res = false;
        try {

            Ple_parcelaemprestimoDAO pdao = getPle_parcelaemprestimoDAO();
            List<Ple_parcelaemprestimoT> list = pdao.getByEmp_emprestimo(emp_emprestimoT);
            if (list != null & list.size() == 0) {
                res = true;
            }

        } catch (Exception e) {
        }
        return res;
    }

    public static String formatarFloat(String zeros, int numero) {
        String num = zeros + numero;
        return num.substring(num.length() - zeros.length());
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

    //Method Download Image � montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
            List<Emp_emprestimoT> listTemp = emp_emprestimoDAO.getByPK(emp_emprestimoT);

            emp_emprestimoT = listTemp.size() > 0 ? listTemp.get(0) : new Emp_emprestimoT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a pagina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "emp_emprestimoConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
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
}
