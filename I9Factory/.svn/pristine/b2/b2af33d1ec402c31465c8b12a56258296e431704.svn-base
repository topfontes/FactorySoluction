package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Org_orgaoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Org_orgaoT org_orgaoT = new Org_orgaoT();
    private String campoFiltro;
    private int quantItens;

    public void setOrg_orgaoT(Org_orgaoT org_orgaoT) {
        this.org_orgaoT = org_orgaoT;
    }

    public Org_orgaoT getOrg_orgaoT() {
        return org_orgaoT;
    }
    private List<Org_orgaoT> list;

    public List<Org_orgaoT> getList() {
        return list;
    }

    public void setList(List<Org_orgaoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consultByNome() throws Exception {
        try {
            Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
            list = org_orgaoDAO.getByOrg_tx_nomefantasia(org_orgaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult() throws Exception {
        try {
            Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
            if (campoFiltro == null) {
                list = org_orgaoDAO.getAll();
            } else {
                if (campoFiltro.equalsIgnoreCase("CNPJ")) {
                    list = org_orgaoDAO.getByOrg_tx_cnpj(org_orgaoT);
                } else if (campoFiltro.equalsIgnoreCase("nome")) {
                    list = org_orgaoDAO.getByOrg_tx_nomefantasia(org_orgaoT);
                } else {
                    list = org_orgaoDAO.getAll();
                }
            }
            quantItens = 0;
            if (list != null) {
                quantItens = list.size();
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
            Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
            org_orgaoDAO.delete(org_orgaoT);
            setMsg("Exclusao efetuada com sucesso!");
            org_orgaoT = new Org_orgaoT();
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
            String page = "org_orgaoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
     * @return the campoFiltro
     */
    public String getCampoFiltro() {
        return campoFiltro;
    }

    /**
     * @param campoFiltro the campoFiltro to set
     */
    public void setCampoFiltro(String campoFiltro) {
        this.campoFiltro = campoFiltro;
    }

    /**
     * @return the quantItens
     */
    public int getQuantItens() {
        return quantItens;
    }

    /**
     * @param quantItens the quantItens to set
     */
    public void setQuantItens(int quantItens) {
        this.quantItens = quantItens;
    }
}
