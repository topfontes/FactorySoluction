package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;


/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Age_agenciadorInsertJB extends SystemBase {

    // Atributos e propriedades
    private Age_agenciadorT age_agenciadorT = new Age_agenciadorT();
    private DataSet ds = new DataSet();

    public void setAge_agenciadorT(Age_agenciadorT age_agenciadorT) {
        this.age_agenciadorT = age_agenciadorT;
    }

    public Age_agenciadorT getAge_agenciadorT() {
        return age_agenciadorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        consultEqp_equipe();

    }

    // Metodo de Eventos
    public void insert() throws Exception {
        try {
            Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
            age_agenciadorDAO.insert(age_agenciadorT);
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
    private List<Eqp_equipeT> listeqp_equipe;

    public List<Eqp_equipeT> getListeqp_equipe() {
        return listeqp_equipe;
    }

    public void setListeqp_equipe(List<Eqp_equipeT> list) {
        this.listeqp_equipe = list;
    }

    public void consultEqp_equipe() throws Exception {
        try {
            Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
            ds = eqp_equipeDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        age_agenciadorT = new Age_agenciadorT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "age_agenciadorConsult.jsp";// defina aqui a pagina que deve ser chamada
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
