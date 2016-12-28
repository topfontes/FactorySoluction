package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Orcl_orgao_clienteConsultJB extends SystemBase {

    // Atributos e propriedades
    private Orcl_orgao_clienteT orcl_orgao_clienteT = new Orcl_orgao_clienteT();
    private DataSet ds;

    public void setOrcl_orgao_clienteT(Orcl_orgao_clienteT orcl_orgao_clienteT) {
        this.orcl_orgao_clienteT = orcl_orgao_clienteT;
    }

    public Orcl_orgao_clienteT getOrcl_orgao_clienteT() {
        return orcl_orgao_clienteT;
    }
    private List<Orcl_orgao_clienteT> list;

    public List<Orcl_orgao_clienteT> getList() {
        return list;
    }

    public void setList(List<Orcl_orgao_clienteT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
    }

    public void consult() throws Exception {
        try {
            Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
            ds = orcl_orgao_clienteDAO.getAll(orcl_orgao_clienteT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
            System.out.println("teste");
        }
    }

    public void delete() throws Exception {
        try {
            Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
            orcl_orgao_clienteDAO.delete(orcl_orgao_clienteT);
            setMsg("Exclusao efetuada com sucesso!");
            orcl_orgao_clienteT = new Orcl_orgao_clienteT();
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
            String page = "orcl_orgao_clienteInsert.jsp";// defina aqui a pagina que deve ser chamada
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
