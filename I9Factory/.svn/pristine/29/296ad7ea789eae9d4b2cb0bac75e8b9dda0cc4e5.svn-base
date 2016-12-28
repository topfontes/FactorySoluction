package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Emp_emprestimoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
    private DataSet ds = new DataSet();
    private String status;
    private String agrupamento;
    private String dtInicio;
    private String dtFinal;
    private boolean ultimos;
    private float percComissao;
    private String tipo;

    public void setEmp_emprestimoT(Emp_emprestimoT emp_emprestimoT) {
        this.emp_emprestimoT = emp_emprestimoT;
    }

    public Emp_emprestimoT getEmp_emprestimoT() {
        return emp_emprestimoT;
    }
    private List<Emp_emprestimoT> list;

    public List<Emp_emprestimoT> getList() {
        return list;
    }

    public void setList(List<Emp_emprestimoT> list) {
        this.list = list;
    }

public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() throws Exception {
        try {
            Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
            if (!ultimos) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date dt_i = format.parse(dtInicio);
                java.util.Date dt_f = format.parse(dtFinal);

                Date dtsqlIni = new Date(dt_i.getTime());
                Date dtsqlFim = new Date(dt_f.getTime());

                ds = emp_emprestimoDAO.getAll(emp_emprestimoT, dtsqlIni, dtsqlFim, agrupamento, status);
                int a =1;
            } else {
                ds = emp_emprestimoDAO.getUltimos();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarComissao() throws Exception {
        try {
            Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dt_i = format.parse(dtInicio);
            java.util.Date dt_f = format.parse(dtFinal);

            Date dtsqlIni = new Date(dt_i.getTime());
            Date dtsqlFim = new Date(dt_f.getTime());

            if (tipo.equalsIgnoreCase("E")) {
                ds = emp_emprestimoDAO.getAllComissao(emp_emprestimoT, dtsqlIni, dtsqlFim);
            } else {
                ds = emp_emprestimoDAO.getAllComissaoMensalidades(emp_emprestimoT, dtsqlIni, dtsqlFim);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        DAOFactory factory = null;
        try {
            if (exclusaoValida()) {
                Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
                factory = emp_emprestimoDAO.getDAOFactory();
                factory.beginTransaction();
                Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
                ple_parcelaemprestimoDAO.deleteAllEmprestimo(emp_emprestimoT);
                emp_emprestimoDAO.delete(emp_emprestimoT);
                setMsg("Exclusao efetuada com sucesso!");
                emp_emprestimoT = new Emp_emprestimoT();
                factory.commitTransaction();
            } else {
                setMsg("Alguma(s) parcela(s) foi realizado quitação !");
            }
            consult();
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao realizar exclusao!");
            factory.rollbackTransaction();
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public boolean exclusaoValida() {
        try {
            boolean resultado = true;
            Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
            List<Ple_parcelaemprestimoT> listtemp = ple_parcelaemprestimoDAO.getByEmp_emprestimo(emp_emprestimoT);
            if (listtemp.size() > 0) {
                resultado = false;
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "emp_emprestimoInsert.jsp";// defina aqui a pagina que deve ser chamada
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
     * @return the ds
     */
    public DataSet getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSet ds) {
        this.ds = ds;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the agrupamento
     */
    public String getAgrupamento() {
        return agrupamento;
    }

    /**
     * @param agrupamento the agrupamento to set
     */
    public void setAgrupamento(String agrupamento) {
        this.agrupamento = agrupamento;
    }

    /**
     * @return the dtInicio
     */
    public String getDtInicio() {
        return dtInicio;
    }

    /**
     * @param dtInicio the dtInicio to set
     */
    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return the dtFinal
     */
    public String getDtFinal() {
        return dtFinal;
    }

    /**
     * @param dtFinal the dtFinal to set
     */
    public void setDtFinal(String dtFinal) {
        this.dtFinal = dtFinal;
    }

    /**
     * @return the ultimos
     */
    public boolean isUltimos() {
        return ultimos;
    }

    /**
     * @param ultimos the ultimos to set
     */
    public void setUltimos(boolean ultimos) {
        this.ultimos = ultimos;
    }

    /**
     * @return the percComissao
     */
    public float getPercComissao() {
        return percComissao;
    }

    /**
     * @param percComissao the percComissao to set
     */
    public void setPercComissao(float percComissao) {
        this.percComissao = percComissao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
//atualizado 03/11/2011 - marcos