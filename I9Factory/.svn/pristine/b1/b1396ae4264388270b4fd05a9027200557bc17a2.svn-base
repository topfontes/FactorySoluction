package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cco_contacorrenteUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Cco_contacorrenteT cco_contacorrenteT = new Cco_contacorrenteT();

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

    public void clear() throws Exception {

        cco_contacorrenteT = new Cco_contacorrenteT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
                cco_contacorrenteDAO.delete(cco_contacorrenteT);
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
            Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
            List<Cco_contacorrenteT> listTemp = cco_contacorrenteDAO.getByPK(cco_contacorrenteT);
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
                Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
                cco_contacorrenteDAO.update(cco_contacorrenteT);
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
    private List<Bco_bancoT> listbco_banco;

    public List<Bco_bancoT> getListbco_banco() {
        return listbco_banco;
    }

    public void setListbco_banco(List<Bco_bancoT> list) {
        this.listbco_banco = list;
    }

    public void consultBco_banco() throws Exception {
        try {
            Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
            listbco_banco = bco_bancoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
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
    private List<Cor_corretoraT> listcor_corretora;

    public List<Cor_corretoraT> getListcor_corretora() {
        return listcor_corretora;
    }

    public void setListcor_corretora(List<Cor_corretoraT> list) {
        this.listcor_corretora = list;
    }

    public void consultCor_corretora() throws Exception {
        try {
            Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
            listcor_corretora = cor_corretoraDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Age_agenciadorT> listage_agenciador;

    public List<Age_agenciadorT> getListage_agenciador() {
        return listage_agenciador;
    }

    public void setListage_agenciador(List<Age_agenciadorT> list) {
        this.listage_agenciador = list;
    }

    public void consultAge_agenciador() throws Exception {
        try {
            Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
//			listage_agenciador=age_agenciadorDAO.getAll();
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
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "cco_contacorrenteT.jpg");
            getRequest().setAttribute(EasyDownloadJB.DATA, cco_contacorrenteT.getCco_bt_arqremessabanco());
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
            Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
            List<Cco_contacorrenteT> listTemp = cco_contacorrenteDAO.getByPK(cco_contacorrenteT);
            cco_contacorrenteT = listTemp.size() > 0 ? listTemp.get(0) : new Cco_contacorrenteT();
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
            String page = "cco_contacorrenteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cco_contacorrenteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
