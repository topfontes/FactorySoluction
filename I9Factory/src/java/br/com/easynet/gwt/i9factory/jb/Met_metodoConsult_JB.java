package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.dao.Met_metodoDAO;
import br.com.easynet.easyportal.transfer.Met_metodoT;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import java.util.List;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Met_metodoConsult_JB extends SystemBase { 

    // Atributos e propriedades
    private Met_metodoT met_metodoT = new Met_metodoT();
    private Per_perfilT per_pefilT = new Per_perfilT();
    private boolean allSistema;

    public void setMet_metodoT(Met_metodoT met_metodoT) {
        this.met_metodoT = met_metodoT;
    }

    public Met_metodoT getMet_metodoT() {
        return met_metodoT;
    }
    private List<Met_metodoT> list;

    public List<Met_metodoT> getList() {
        return list;
    }

    public void setList(List<Met_metodoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void consult() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        try {
            met_metodoDAO = (Met_metodoDAO)getMet_metodoDAO();
            list = met_metodoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            met_metodoDAO.close();
        }
    }

    public void consultMetodosPerfil() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        try {
            met_metodoDAO = (Met_metodoDAO)getMet_metodoDAO();
            if(!allSistema){
                list = met_metodoDAO.getByMetodosPerfil(per_pefilT, met_metodoT);
            }else{
                list = met_metodoDAO.getAllMetodosPerfilSistema(per_pefilT, met_metodoT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            met_metodoDAO.close();
        }
    }
 
    public void consultMetodosNaoPerfil() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        try {
            met_metodoDAO = (Met_metodoDAO)getMet_metodoDAO();
            list = met_metodoDAO.getByMetodosNaoPerfil(per_pefilT, met_metodoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            met_metodoDAO.close();
        }
    }

    public void delete() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        try {
            met_metodoDAO = (Met_metodoDAO)getMet_metodoDAO();
            met_metodoDAO.delete(met_metodoT);
            setMsg("Exclusao efetuada com sucesso!");
            met_metodoT = new Met_metodoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusao!");
        } finally {
            met_metodoDAO.close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "met_metodoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
     * @return the per_pefilT
     */
    public Per_perfilT getPer_pefilT() {
        return per_pefilT;
    }

    /**
     * @param per_pefilT the per_pefilT to set
     */
    public void setPer_pefilT(Per_perfilT per_pefilT) {
        this.per_pefilT = per_pefilT;
    }

    /**
     * @return the allSistema
     */
    public boolean getAllSistema() {
        return allSistema;
    }

    /**
     * @param allSistema the allSistema to set
     */
    public void setAllSistema(boolean allSistema) {
        this.allSistema = allSistema;
    }
}
