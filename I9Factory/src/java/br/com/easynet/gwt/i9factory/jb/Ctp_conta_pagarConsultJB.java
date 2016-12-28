package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ctp_conta_pagarConsultJB extends SystemBase {

    // Atributos e propriedades
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
    private String dt_inicio;
    private String dt_fim;
    private String agrupamento;
    private int id_fornecedor;
    private int id_tipoDesp;
    private String status;
    private DataSet ds = new DataSet();
    private Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();
    private boolean avencer;

    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
    }

    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }
    private List<Ctp_conta_pagarT> list;

    public List<Ctp_conta_pagarT> getList() {
        return list;
    }

    public void setList(List<Ctp_conta_pagarT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            if (!avencer) {
                if (dt_inicio != null && dt_inicio.trim().length() > 0 && dt_fim != null && dt_fim.trim().length() > 0) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    Date dtIni = format.parse(dt_inicio);
                    Date dtFim = format.parse(dt_fim);
                    long ti = dtIni.getTime();
                    long tf = dtFim.getTime();
                    long total = tf - ti;
                    Calendar cal = Calendar.getInstance();
                    if (total < 0) {
                        setMsg(INFO, "Data inicial nao pode ser menor que a data final.");
                        return;
                    }
                    cal.setTimeInMillis(total);
                    long dias = cal.get(Calendar.DAY_OF_YEAR);
                    Par_parametroT parT = getPar_parametroDAOLocal().getByPar_tx_nome("diasLimiteConsulta");
                    if (parT != null) {
                        long limiteDias = Integer.parseInt(parT.getPar_tx_valor());
                        if (limiteDias >= dias || total == 0) {
                            ds = ctp_conta_pagarDAO.getAll(status, dtIni, dtFim, id_fornecedor, id_tipoDesp, agrupamento);
                        } else {
                            setMsg(INFO, "Limite de dias para consulta é de 60.");
                        }
                    }
                } else {

                    ds = ctp_conta_pagarDAO.getAll(status, id_fornecedor, id_tipoDesp, agrupamento);
                }
            } else {
                ds = ctp_conta_pagarDAO.getAll("F", ctp_conta_pagarT.getCtp_dt_vencimento(), ctp_conta_pagarT.getCtp_dt_vencimento(), 0, 0, "G");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ctp_conta_pagarDAO.delete(ctp_conta_pagarT);
            setMsg("Exclusao efetuada com sucesso!");
            ctp_conta_pagarT = new Ctp_conta_pagarT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "ctp_conta_pagarInsert.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void extornar_pag() {

        DAOFactory factory = null;
        try {
            Lan_lancamentoDAO dAO = getLan_lancamentoDAO();
            factory = dAO.getDAOFactory();
            factory.beginTransaction();

            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            ctp_conta_pagarT.setCtp_nr_id(lan_lancamentoT.getCtp_nr_id());
            ctp_conta_pagarT = cdao.getByCtp_nr_id(ctp_conta_pagarT).get(0);
            ctp_conta_pagarT.setCtp_tx_pago("F");
            ctp_conta_pagarT.setCtp_saldo(ctp_conta_pagarT.getCtp_saldo() + lan_lancamentoT.getLan_valor());
            ctp_conta_pagarT.setCtp_vl_pago(ctp_conta_pagarT.getCtp_vl_pago() - lan_lancamentoT.getLan_valor());
            ctp_conta_pagarT.setCtp_dt_pagamento(null);

            cdao.update(ctp_conta_pagarT);
            dAO.delete(lan_lancamentoT);

            factory.commitTransaction();

            consult();

            setMsg("Extorno efetuada com sucesso!");
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar extorno!");
        } finally {
            close();
        }

    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the dt_inicio
     */
    public String getDt_inicio() {
        return dt_inicio;
    }

    /**
     * @param dt_inicio the dt_inicio to set
     */
    public void setDt_inicio(String dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    /**
     * @return the dt_fim
     */
    public String getDt_fim() {
        return dt_fim;
    }

    /**
     * @param dt_fim the dt_fim to set
     */
    public void setDt_fim(String dt_fim) {
        this.dt_fim = dt_fim;
    }

    /**
     * @return the Agrupamento
     */
    public String getAgrupamento() {
        return agrupamento;
    }

    /**
     * @param Agrupamento the Agrupamento to set
     */
    public void setAgrupamento(String agrupamento) {
        this.agrupamento = agrupamento;
    }

    /**
     * @return the id_fornecedor
     */
    public int getId_fornecedor() {
        return id_fornecedor;
    }

    /**
     * @param id_fornecedor the id_fornecedor to set
     */
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    /**
     * @return the id_tipoDesp
     */
    public int getId_tipoDesp() {
        return id_tipoDesp;
    }

    /**
     * @param id_tipoDesp the id_tipoDesp to set
     */
    public void setId_tipoDesp(int id_tipoDesp) {
        this.id_tipoDesp = id_tipoDesp;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the ds
     */
    public DataSet getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSet ds) {
        this.ds = ds;
    }

    /**
     * @return the lan_lancamentoT
     */
    public Lan_lancamentoT getLan_lancamentoT() {
        return lan_lancamentoT;
    }

    /**
     * @param lan_lancamentoT the lan_lancamentoT to set
     */
    public void setLan_lancamentoT(Lan_lancamentoT lan_lancamentoT) {
        this.lan_lancamentoT = lan_lancamentoT;
    }

    /**
     * @return the avencer
     */
    public boolean isAvencer() {
        return avencer;
    }

    /**
     * @param avencer the avencer to set
     */
    public void setAvencer(boolean avencer) {
        this.avencer = avencer;
    }
}
