package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Res_restricaoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Res_restricaoT res_restricaoT = new Res_restricaoT();
    private boolean todos;
    private DataSet ds ;

    public void setRes_restricaoT(Res_restricaoT res_restricaoT) {
        this.res_restricaoT = res_restricaoT;
    }

    public Res_restricaoT getRes_restricaoT() {
        return res_restricaoT;
    }
    private List<Res_restricaoT> list;

    public List<Res_restricaoT> getList() {
        return list;
    }

    public void setList(List<Res_restricaoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
            if (!todos) {
                ds = res_restricaoDAO.getByCli_nr_id(res_restricaoT);
            } else {
                ds = res_restricaoDAO.getAll();
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
            Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
            res_restricaoDAO.delete(res_restricaoT);
            setMsg("Exclusao efetuada com sucesso!");
            res_restricaoT = new Res_restricaoT();
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
            String page = "res_restricaoInsert.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
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
}
