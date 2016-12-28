package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Dep_dependenteUpdateDeleteJB extends SystemBase {

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
        consultCli_cliente();

    }

    public void clear() throws Exception {

        dep_dependenteT = new Dep_dependenteT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
                dep_dependenteDAO.delete(dep_dependenteT);
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

    public boolean exist() throws Exception {
        try {
            Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
            List<Dep_dependenteT> listTemp = dep_dependenteDAO.getByPK(dep_dependenteT);

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
                Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
                dep_dependenteDAO.update(dep_dependenteT);
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

    //Method Download Image � montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
            List<Dep_dependenteT> listTemp = dep_dependenteDAO.getByPK(dep_dependenteT);

            dep_dependenteT = listTemp.size() > 0 ? listTemp.get(0) : new Dep_dependenteT();

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
            String page = "dep_dependenteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "dep_dependenteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
