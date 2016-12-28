package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cco_contacorrenteConsultJB extends SystemBase {

    // Atributos e propriedades
    private Cco_contacorrenteT cco_contacorrenteT = new Cco_contacorrenteT();
    private DataSet ds = new DataSet();

    public void setCco_contacorrenteT(Cco_contacorrenteT cco_contacorrenteT) {
        this.cco_contacorrenteT = cco_contacorrenteT;
    }

    public Cco_contacorrenteT getCco_contacorrenteT() {
        return cco_contacorrenteT;
    }
    private List<Cco_contacorrenteT> list;

    public List<Cco_contacorrenteT> getList() {
        return list;
    }

    public void setList(List<Cco_contacorrenteT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
            ds = cco_contacorrenteDAO.getByCli_nr_id_Orgao(cco_contacorrenteT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
            cco_contacorrenteDAO.delete(cco_contacorrenteT);
            setMsg("Exclusao efetuada com sucesso!");
            cco_contacorrenteT = new Cco_contacorrenteT();
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
            String page = "cco_contacorrenteInsert.jsp";// defina aqui a pagina que deve ser chamada
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
