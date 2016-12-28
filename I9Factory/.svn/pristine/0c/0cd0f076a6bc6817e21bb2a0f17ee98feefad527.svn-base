package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Lan_lancamentoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();

    public void setLan_lancamentoT(Lan_lancamentoT lan_lancamentoT) {
        this.lan_lancamentoT = lan_lancamentoT;
    }

    public Lan_lancamentoT getLan_lancamentoT() {
        return lan_lancamentoT;
    }
    private List<Lan_lancamentoT> list;

    public List<Lan_lancamentoT> getList() {
        return list;
    }

    public void setList(List<Lan_lancamentoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
            if (lan_lancamentoT.getCtp_nr_id() > 0) {
                list = lan_lancamentoDAO.getByCtp_nr_id(lan_lancamentoT);
            } else {
                list = lan_lancamentoDAO.getAll();

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
            Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
            lan_lancamentoDAO.delete(lan_lancamentoT);
            setMsg("Exclusao efetuada com sucesso!");
            lan_lancamentoT = new Lan_lancamentoT();
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
            String page = "lan_lancamentoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
}
