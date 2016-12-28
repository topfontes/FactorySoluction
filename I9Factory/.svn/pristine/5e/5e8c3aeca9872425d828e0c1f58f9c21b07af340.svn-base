package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ple_parcelaemprestimoUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
    private int cli_nr_id;
    private String ids;
    private Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
    private boolean suspenso = false;

    public void setPle_parcelaemprestimoT(Ple_parcelaemprestimoT ple_parcelaemprestimoT) {
        this.ple_parcelaemprestimoT = ple_parcelaemprestimoT;
    }

    public Ple_parcelaemprestimoT getPle_parcelaemprestimoT() {
        return ple_parcelaemprestimoT;
    }
    private List<Ple_parcelaemprestimoT> list;

    public List<Ple_parcelaemprestimoT> getList() {
        return list;
    }

    public void setList(List<Ple_parcelaemprestimoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void clear() throws Exception {

        ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
                ple_parcelaemprestimoDAO.delete(ple_parcelaemprestimoT);
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
            Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
            List<Ple_parcelaemprestimoT> listTemp = ple_parcelaemprestimoDAO.getByPK(ple_parcelaemprestimoT);

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
        DAOFactory factory = null;
        try {
            if (exist()) {
                Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
                factory = ple_parcelaemprestimoDAO.getDAOFactory();
                factory.beginTransaction();
                if (!suspenso) {
                    if (ple_parcelaemprestimoT.getPle_dt_pagamento() != null) {
                        boolean baixaemp = baixarEmprestimo(ple_parcelaemprestimoT.getEmp_nr_id(), 1);
                        ple_parcelaemprestimoDAO.update(ple_parcelaemprestimoT);
                        if (baixaemp) {
                            Emp_emprestimoDAO edao = getEmp_emprestimoDAO();
                            emp_emprestimoT.setEmp_nr_id(ple_parcelaemprestimoT.getEmp_nr_id());
                            emp_emprestimoT.setEmp_dt_quitacao(ple_parcelaemprestimoT.getPle_dt_pagamento());
                            emp_emprestimoT.setEmp_tx_status("P");
                            edao.updateBaixa(emp_emprestimoT);
                        }
                    } else {
                        ple_parcelaemprestimoDAO.update(ple_parcelaemprestimoT);
                        Emp_emprestimoDAO edao = getEmp_emprestimoDAO();
                        emp_emprestimoT.setEmp_nr_id(ple_parcelaemprestimoT.getEmp_nr_id());
                        emp_emprestimoT.setEmp_tx_status("A");
                        edao.ExtornarBaixa(emp_emprestimoT);
                    }
                }else{
                   ple_parcelaemprestimoDAO.updateSuspenso(ple_parcelaemprestimoT);
                }
                factory.commitTransaction();
                setMsg("Alteracao efetuada com sucesso!");
            } else {

                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            close();
        }
    }

    public void updateAll() throws Exception {
        Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = null;
        DAOFactory factory = null;
        try {
            ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
            factory = ple_parcelaemprestimoDAO.getDAOFactory();
            factory.beginTransaction();

            boolean baixaemp = baixarEmprestimo(ple_parcelaemprestimoT.getEmp_nr_id(), qtdItensABaixar());
            ple_parcelaemprestimoDAO.updateAll(ple_parcelaemprestimoT, ids);
            if (baixaemp) {
                Emp_emprestimoDAO edao = getEmp_emprestimoDAO();
                emp_emprestimoT.setEmp_nr_id(ple_parcelaemprestimoT.getEmp_nr_id());
                emp_emprestimoT.setEmp_dt_quitacao(ple_parcelaemprestimoT.getPle_dt_pagamento());
                emp_emprestimoT.setEmp_tx_status("P");
                edao.updateBaixa(emp_emprestimoT);
            }
            factory.commitTransaction();
            setMsg("Alteracao efetuada com sucesso!");
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
        } finally {
            close();
        }
    }

    public boolean baixarEmprestimo(int emp_nr_id, int qtItens) throws Exception {
        boolean res = false;
        try {
            Ple_parcelaemprestimoDAO pdao = getPle_parcelaemprestimoDAO();
            emp_emprestimoT.setEmp_nr_id(emp_nr_id);
            List<Ple_parcelaemprestimoT> list = pdao.getByEmp_emprestimoAPagar(emp_emprestimoT);
            if (list != null) {
                if (list.size() == qtItens) {
                    res = true;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return res;
    }

    public int qtdItensABaixar() {
        int qt = 0;
        for (int i = 0; i < ids.length(); i++) {
            String caractet = ids.substring(i, i + 1);
            if (caractet.equals(",")) {
                qt++;
            }
        }
        return qt;
    }
// Method de lookup
// 
    private List<Emp_emprestimoT> listemp_emprestimo;

    public List<Emp_emprestimoT> getListemp_emprestimo() {
        return listemp_emprestimo;
    }

    public void setListemp_emprestimo(List<Emp_emprestimoT> list) {
        this.listemp_emprestimo = list;
    }

    //Method Download Image � montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
            List<Ple_parcelaemprestimoT> listTemp = ple_parcelaemprestimoDAO.getByPK(ple_parcelaemprestimoT);
            ple_parcelaemprestimoT = listTemp.size() > 0 ? listTemp.get(0) : new Ple_parcelaemprestimoT();
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
            String page = "ple_parcelaemprestimoConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ple_parcelaemprestimoConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the cli_nr_id
     */
    public int getCli_nr_id() {
        return cli_nr_id;
    }

    /**
     * @param cli_nr_id the cli_nr_id to set
     */
    public void setCli_nr_id(int cli_nr_id) {
        this.cli_nr_id = cli_nr_id;
    }

    /**
     * @return the ids
     */
    public String getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(String ids) {
        this.ids = ids;
    }

    /**
     * @return the suspenso
     */
    public boolean isSuspenso() {
        return suspenso;
    }

    /**
     * @param suspenso the suspenso to set
     */
    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }
}
