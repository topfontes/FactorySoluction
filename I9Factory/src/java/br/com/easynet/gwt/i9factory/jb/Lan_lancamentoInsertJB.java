package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Lan_lancamentoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();

    public void setLan_lancamentoT(Lan_lancamentoT lan_lancamentoT) {
        this.lan_lancamentoT = lan_lancamentoT;
    }

    public Lan_lancamentoT getLan_lancamentoT() {
        return lan_lancamentoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
//        consultCtp_conta_pagar();

    }

    // Metodo de Eventos
    public void insert() throws Exception {

        try {
            Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
            lan_lancamentoDAO.insert(lan_lancamentoT);
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
    private List<Ctp_conta_pagarT> listctp_conta_pagar;

    public List<Ctp_conta_pagarT> getListctp_conta_pagar() {
        return listctp_conta_pagar;
    }

    public void setListctp_conta_pagar(List<Ctp_conta_pagarT> list) {
        this.listctp_conta_pagar = list;
    }

    public void clear() throws Exception {

        lan_lancamentoT = new Lan_lancamentoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "lan_lancamentoConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
