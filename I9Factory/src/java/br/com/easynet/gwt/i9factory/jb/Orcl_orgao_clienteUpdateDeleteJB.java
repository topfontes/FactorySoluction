package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Orcl_orgao_clienteUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Orcl_orgao_clienteT orcl_orgao_clienteT = new Orcl_orgao_clienteT();

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
    }

    public void clear() throws Exception {

        orcl_orgao_clienteT = new Orcl_orgao_clienteT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
                orcl_orgao_clienteDAO.delete(orcl_orgao_clienteT);
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
            Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
            List<Orcl_orgao_clienteT> listTemp = orcl_orgao_clienteDAO.getByPK(orcl_orgao_clienteT);

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
                Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
                orcl_orgao_clienteDAO.update(orcl_orgao_clienteT);
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

    //Method Download Image � montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
            List<Orcl_orgao_clienteT> listTemp = orcl_orgao_clienteDAO.getByPK(orcl_orgao_clienteT);

            orcl_orgao_clienteT = listTemp.size() > 0 ? listTemp.get(0) : new Orcl_orgao_clienteT();

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
            String page = "orcl_orgao_clienteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "orcl_orgao_clienteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
