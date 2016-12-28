package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cco_contacorrenteInsertJB extends SystemBase {

    // Atributos e propriedades
    private Cco_contacorrenteT cco_contacorrenteT = new Cco_contacorrenteT();

    public void setCco_contacorrenteT(Cco_contacorrenteT cco_contacorrenteT) {
        this.cco_contacorrenteT = cco_contacorrenteT;
    }

    public Cco_contacorrenteT getCco_contacorrenteT() {
        return cco_contacorrenteT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // Metodo de Eventos
    public void insert() throws Exception {

        try {
            Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
            cco_contacorrenteDAO.insert(cco_contacorrenteT);
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
            //listcor_corretora=cor_corretoraDAO.getAll();
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

    public void clear() throws Exception {

        cco_contacorrenteT = new Cco_contacorrenteT();
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
