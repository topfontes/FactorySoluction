package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ple_parcelaemprestimoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
    private boolean todos;
    private int cli_nr_id;
    private int org_nr_id;
    private DataSet ds;
    private boolean vencidas;

    public void setPle_parcelaemprestimoT(Ple_parcelaemprestimoT ple_parcelaemprestimoT) {
        this.ple_parcelaemprestimoT = ple_parcelaemprestimoT;
    }

    public Ple_parcelaemprestimoT getPle_parcelaemprestimoT() {
        return ple_parcelaemprestimoT;
    }
    private List<Ple_parcelaemprestimoT> list;

    public List<Ple_parcelaemprestimoT> getList() {
        return list;
    }

    public void setList(List<Ple_parcelaemprestimoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
            if (!todos) {
                if (cli_nr_id == 0) {
                    ds = ple_parcelaemprestimoDAO.getByEmp_nr_id(ple_parcelaemprestimoT);
                } else {
                    if (org_nr_id > 0) {
                        ds = ple_parcelaemprestimoDAO.getByCli_nr_id_orgao_PendenteAll(cli_nr_id, ple_parcelaemprestimoT.getPle_tx_tipo(), org_nr_id);
                    } else if (ple_parcelaemprestimoT.getPle_tx_tipo().equalsIgnoreCase("T")) {// T = todos, tanto parcela e mensalidade
                        ds = ple_parcelaemprestimoDAO.getByCli_nr_idPendenteAll(cli_nr_id, ple_parcelaemprestimoT.getPle_tx_tipo());
                    } else {
                        if (!isVencidas()) {
                            ds = ple_parcelaemprestimoDAO.getByCli_nr_idPendente(cli_nr_id, ple_parcelaemprestimoT.getPle_tx_tipo());
                        } else {
                            ds = ple_parcelaemprestimoDAO.getByCli_nr_idVencidas(cli_nr_id, ple_parcelaemprestimoT.getPle_tx_tipo());
                        }
                    }
                }
            } else {
                ds = ple_parcelaemprestimoDAO.getAllAtraso();
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
            Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
            ple_parcelaemprestimoDAO.delete(ple_parcelaemprestimoT);
            setMsg("Exclusao efetuada com sucesso!");
            ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
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
            String page = "ple_parcelaemprestimoInsert.jsp";// defina aqui a p gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the todos
     */
    public boolean isTodos() {
        return todos;
    }

    /**
     * @param todos the todos to set
     */
    public void setTodos(boolean todos) {
        this.todos = todos;
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
     * @return the cli_nr_id
     */
    public int getCli_nr_id() {
        return cli_nr_id;
    }

    /**
     * @param cli_nr_id the cli_nr_id to set
     */
    public void setCli_nr_id(int cli_nr_id) {
        this.cli_nr_id = cli_nr_id;
    }

    /**
     * @return the org_nr_id
     */
    public int getOrg_nr_id() {
        return org_nr_id;
    }

    /**
     * @param org_nr_id the org_nr_id to set
     */
    public void setOrg_nr_id(int org_nr_id) {
        this.org_nr_id = org_nr_id;
    }

    /**
     * @return the vencidas
     */
    public boolean isVencidas() {
        return vencidas;
    }

    /**
     * @param vencidas the vencidas to set
     */
    public void setVencidas(boolean vencidas) {
        this.vencidas = vencidas;
    }
}
