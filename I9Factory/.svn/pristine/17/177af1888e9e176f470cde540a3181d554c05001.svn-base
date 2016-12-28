package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ped_percentual_descontoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Ped_percentual_descontoT ped_percentual_descontoT = new Ped_percentual_descontoT();

    public void setPed_percentual_descontoT(Ped_percentual_descontoT ped_percentual_descontoT) {
        this.ped_percentual_descontoT = ped_percentual_descontoT;
    }

    public Ped_percentual_descontoT getPed_percentual_descontoT() {
        return ped_percentual_descontoT;
    }
    private List<Ped_percentual_descontoT> list;

    public List<Ped_percentual_descontoT> getList() {
        return list;
    }

    public void setList(List<Ped_percentual_descontoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
            list = ped_percentual_descontoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult_desconto() {
        try {
            Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
            list = ped_percentual_descontoDAO.getByPed_nr_parcela(ped_percentual_descontoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
            ped_percentual_descontoDAO.delete(ped_percentual_descontoT);
            setMsg("Exclusao efetuada com sucesso!");
            ped_percentual_descontoT = new Ped_percentual_descontoT();
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
            String page = "ped_percentual_descontoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
