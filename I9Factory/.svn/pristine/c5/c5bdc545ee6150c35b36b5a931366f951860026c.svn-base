package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Dep_dependenteConsultJB extends SystemBase {

    // Atributos e propriedades
    private Dep_dependenteT dep_dependenteT = new Dep_dependenteT();

    public void setDep_dependenteT(Dep_dependenteT dep_dependenteT) {
        this.dep_dependenteT = dep_dependenteT;
    }

    public Dep_dependenteT getDep_dependenteT() {
        return dep_dependenteT;
    }
    private List<Dep_dependenteT> list;

    public List<Dep_dependenteT> getList() {
        return list;
    }

    public void setList(List<Dep_dependenteT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
            list = dep_dependenteDAO.getByCli_nr_id(dep_dependenteT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
            dep_dependenteDAO.delete(dep_dependenteT);
            setMsg("Exclusao efetuada com sucesso!");
            dep_dependenteT = new Dep_dependenteT();
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
            String page = "dep_dependenteInsert.jsp";// defina aqui a pagina que deve ser chamada
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
}
