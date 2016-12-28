package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Dep_dependenteInsertJB extends SystemBase {

    // Atributos e propriedades
    private Dep_dependenteT dep_dependenteT = new Dep_dependenteT();

    public void setDep_dependenteT(Dep_dependenteT dep_dependenteT) {
        this.dep_dependenteT = dep_dependenteT;
    }

    public Dep_dependenteT getDep_dependenteT() {
        return dep_dependenteT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    // Metodo de Eventos
    public void insert() throws Exception {

        try {
            Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
            dep_dependenteDAO.insert(dep_dependenteT);
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
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

    public void clear() throws Exception {

        dep_dependenteT = new Dep_dependenteT();
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
