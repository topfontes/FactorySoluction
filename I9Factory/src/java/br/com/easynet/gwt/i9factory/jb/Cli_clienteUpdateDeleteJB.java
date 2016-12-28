package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cli_clienteUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Cli_clienteT cli_clienteT = new Cli_clienteT();

    public void setCli_clienteT(Cli_clienteT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;
    }

    public Cli_clienteT getCli_clienteT() {
        return cli_clienteT;
    }
    private List<Cli_clienteT> list;

    public List<Cli_clienteT> getList() {
        return list;
    }

    public void setList(List<Cli_clienteT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void clear() throws Exception {

        cli_clienteT = new Cli_clienteT();
    }

    public void delete() throws Exception {
        DAOFactory factory = null;
        try {
            if (exist()) {
                Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();;
                    factory = cco_contacorrenteDAO.getDAOFactory();
                factory.beginTransaction();
                cco_contacorrenteDAO.deleteAllClinete(cli_clienteT);

                Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
                cli_clienteDAO.delete(cli_clienteT);
                factory.commitTransaction();
                setMsg("Exclusao efetuada com sucesso!");
                clear();
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            List<Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);

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
                Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
                if (cli_clienteT.getCli_bt_foto() != null) {
                    cli_clienteDAO.update(cli_clienteT);
                } else {
                    cli_clienteDAO.updateNotImage(cli_clienteT);
                }                
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
    private List<Tmp_tipomensalidadeT> listtmp_tipomensalidade;

    public List<Tmp_tipomensalidadeT> getListtmp_tipomensalidade() {
        return listtmp_tipomensalidade;
    }

    public void setListtmp_tipomensalidade(List<Tmp_tipomensalidadeT> list) {
        this.listtmp_tipomensalidade = list;
    }

    public void consultTmp_tipomensalidade() throws Exception {
        try {
            Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
            listtmp_tipomensalidade = tmp_tipomensalidadeDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    //Method Download Image � montando se houver algum campo do tipo binario
    //
    /**
     * Download de Imagem caso existe sen�o pode remover
     */
    public void downloadImage() throws Exception {

        try {
            findbyid();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "cli_clienteT.jpg");
            getRequest().setAttribute(EasyDownloadJB.DATA, cli_clienteT.getCli_bt_foto());
            getPage().forward("easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }

    public void findbyid() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            List<Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);

            cli_clienteT = listTemp.size() > 0 ? listTemp.get(0) : new Cli_clienteT();

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
            String page = "cli_clienteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cli_clienteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
