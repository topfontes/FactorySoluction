package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Orcl_orgao_clienteInsertJB extends SystemBase {

    // Atributos e propriedades
    private Orcl_orgao_clienteT orcl_orgao_clienteT = new Orcl_orgao_clienteT();
    private Cco_contacorrenteT cco_contacorrenteT = new Cco_contacorrenteT();

    public void setOrcl_orgao_clienteT(Orcl_orgao_clienteT orcl_orgao_clienteT) {
        this.orcl_orgao_clienteT = orcl_orgao_clienteT;
    }

    public Orcl_orgao_clienteT getOrcl_orgao_clienteT() {
        return orcl_orgao_clienteT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // Metodo de Eventos
    public void insert() throws Exception {
        DAOFactory factory = null;
        try {
            Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
            factory = orcl_orgao_clienteDAO.getDAOFactory();
            factory.beginTransaction();
            orcl_orgao_clienteDAO.insert(orcl_orgao_clienteT);
            
            Cco_contacorrenteDAO cdao = getCco_contacorrenteDAO();
            cdao.insert(cco_contacorrenteT);

            factory.commitTransaction();
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            factory.rollbackTransaction();
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
    private List<Org_orgaoT> listorg_orgao;

    public List<Org_orgaoT> getListorg_orgao() {
        return listorg_orgao;
    }

    public void setListorg_orgao(List<Org_orgaoT> list) {
        this.listorg_orgao = list;
    }

    public void consultOrg_orgao() throws Exception {
        try {
            Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
            listorg_orgao = org_orgaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        orcl_orgao_clienteT = new Orcl_orgao_clienteT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "orcl_orgao_clienteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the cco_contacorrenteT
     */
    public Cco_contacorrenteT getCco_contacorrenteT() {
        return cco_contacorrenteT;
    }

    /**
     * @param cco_contacorrenteT the cco_contacorrenteT to set
     */
    public void setCco_contacorrenteT(Cco_contacorrenteT cco_contacorrenteT) {
        this.cco_contacorrenteT = cco_contacorrenteT;
    }
}
