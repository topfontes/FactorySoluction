package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.text.SimpleDateFormat;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ctp_conta_pagarUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
    private int id_conta;
    private float valor_pago;
    private String historico;
    private String dataLancamento;

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

    public void clear() throws Exception {

        ctp_conta_pagarT = new Ctp_conta_pagarT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                ctp_conta_pagarDAO.delete(ctp_conta_pagarT);
                setMsg("Exclusao efetuada com sucesso!");
                clear();
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void baixar() {
        DAOFactory dao = null;
        try {
            if (exist()) {

                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                dao = ctp_conta_pagarDAO.getDAOFactory();
                dao.beginTransaction();

                ctp_conta_pagarDAO.update(ctp_conta_pagarT);
                
                Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();
                lan_lancamentoT.setCtp_nr_id(ctp_conta_pagarT.getCtp_nr_id());
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                lan_lancamentoT.setLan_dt_lancamento(format.parse(dataLancamento));
                lan_lancamentoT.setLan_plc_nr_id_cred(id_conta);
                lan_lancamentoT.setLan_plc_nr_id_deb(0);
                lan_lancamentoT.setLan_tx_historico(historico);
                lan_lancamentoT.setLan_valor(valor_pago);
                Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
                lan_lancamentoDAO.insert(lan_lancamentoT);

                setMsg("Alteracao efetuada com sucesso!");

                dao.commitTransaction();
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            dao.rollbackTransaction();
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void update() throws Exception {
        try {
            if (exist()) {
                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                ctp_conta_pagarDAO.update(ctp_conta_pagarT);
                setMsg("Alteracao efetuada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<For_fornecedorT> listfor_fornecedor;

    public List<For_fornecedorT> getListfor_fornecedor() {
        return listfor_fornecedor;
    }

    public void setListfor_fornecedor(List<For_fornecedorT> list) {
        this.listfor_fornecedor = list;
    }

    public void consultFor_fornecedor() throws Exception {
        try {
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
            listfor_fornecedor = for_fornecedorDAO.getAll();
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
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            ctp_conta_pagarT = listTemp.size() > 0 ? listTemp.get(0) : new Ctp_conta_pagarT();

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
            String page = "ctp_conta_pagarConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ctp_conta_pagarConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the id_conta
     */
    public int getId_conta() {
        return id_conta;
    }

    /**
     * @param id_conta the id_conta to set
     */
    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }

    /**
     * @return the valor_pago
     */
    public float getValor_pago() {
        return valor_pago;
    }

    /**
     * @param valor_pago the valor_pago to set
     */
    public void setValor_pago(float valor_pago) {
        this.valor_pago = valor_pago;
    }

    /**
     * @return the historico
     */
    public String getHistorico() {
        return historico;
    }

    /**
     * @param historico the historico to set
     */
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    /**
     * @return the dataLancamento
     */
    public String getDataLancamento() {
        return dataLancamento;
    }

    /**
     * @param dataLancamento the dataLancamento to set
     */
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
