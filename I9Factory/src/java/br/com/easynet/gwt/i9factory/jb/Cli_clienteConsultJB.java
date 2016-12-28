package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.tmp.cli_casserpTemp;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.util.TreeMap;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cli_clienteConsultJB extends SystemBase implements INotSecurity {

    // Atributos e propriedades
    private Cli_clienteT cli_clienteT = new Cli_clienteT();
    private String campoFiltro;
    private DataSet dsConta = new DataSet();
    private DataSet dsMaxProposta = new DataSet();
    private int quantidade;
    private int qtde;
    private boolean filtrarOrgao;

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
        //cancel();
    }

    public String getTipoConsulta() {
        String tipo = "";
        if (isDouble()) {
            if (cli_clienteT.getCli_tx_nome().trim().length() == 11) {
                tipo = "CPF";
            } else {
                tipo = "MAT";
            }
        }
        return tipo;
    }

    public boolean isDouble() {
        try {
            double i = Double.parseDouble(cli_clienteT.getCli_tx_nome());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void consultByNome() throws Exception {
        try {
            String tipo = getTipoConsulta();
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            if (tipo.equalsIgnoreCase("CPF")) {
                cli_clienteT.setCli_tx_cpf(cli_clienteT.getCli_tx_nome());
                list = cli_clienteDAO.getByCli_tx_cpf(cli_clienteT);
            } else if (tipo.equalsIgnoreCase("MAT")) {
                cli_clienteT.setCli_tx_matricula(cli_clienteT.getCli_tx_nome());
                list = cli_clienteDAO.getByCli_tx_matricula(cli_clienteT);
            } else {
                list = cli_clienteDAO.getByCli_tx_nome(cli_clienteT);
            }
            qtde = list.size();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            if (campoFiltro == null || campoFiltro.equals("TODOS")) {
                list = cli_clienteDAO.getAll();
            } else {
                if (campoFiltro.equalsIgnoreCase("CPF")) {
                    list = cli_clienteDAO.getByCli_tx_cpf(cli_clienteT);
                    getContaCorrenteCliente();
                } else if (campoFiltro.equalsIgnoreCase("nome")) {
                    list = cli_clienteDAO.getByCli_tx_nome(cli_clienteT);
                    getContaCorrenteCliente();
                } else if (campoFiltro.equalsIgnoreCase("matricula")) {
                    list = cli_clienteDAO.getByCli_tx_matricula(cli_clienteT);
                    getContaCorrenteCliente();
                } else if (campoFiltro.equalsIgnoreCase("cli_nr_id")) {
                    list = cli_clienteDAO.getByCli_nr_id(cli_clienteT);
                } else {
                    list = cli_clienteDAO.getAll();
                }
            }
            qtde = list.size();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void getMaxProposta(String ids) throws Exception {
        try {
            Emp_emprestimoDAO edao = getEmp_emprestimoDAO();
            dsMaxProposta = edao.getMaxProposta(ids);
        } catch (Exception e) {
            throw e;
        }
    }

    public void getContaCorrenteCliente() throws Exception {
        try {
            if (isFiltrarOrgao()) {
                Cco_contacorrenteDAO cdao = getCco_contacorrenteDAO();
                String ids = getids();
                dsConta = cdao.getByCli_nr_id(ids);
                //dsConta = cdao.getByCli_nr_id(10);
                if (dsConta.getList().size() > 0) {
                    quantidade = dsConta.getList().size();
                }
                getMaxProposta(ids);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public String getids() {
        String id = "(0";
        for (Cli_clienteT cli_clienteT : list) {
            id += "," + cli_clienteT.getCli_nr_id();
        }

        return id + ")";
    }

    public void delete() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            cli_clienteDAO.delete(cli_clienteT);
            setMsg("Exclusao efetuada com sucesso!");
            cli_clienteT = new Cli_clienteT();
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
            String page = "cli_clienteInsert.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the campoFiltro
     */
    public String getCampoFiltro() {
        return campoFiltro;
    }

    /**
     * @param campoFiltro the campoFiltro to set
     */
    public void setCampoFiltro(String campoFiltro) {
        this.campoFiltro = campoFiltro;
    }

    /**
     * @return the dsConta
     */
    public DataSet getDsConta() {
        return dsConta;
    }

    /**
     * @param dsConta the dsConta to set
     */
    public void setDsConta(DataSet dsConta) {
        this.dsConta = dsConta;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the dsMaxProposta
     */
    public DataSet getDsMaxProposta() {
        return dsMaxProposta;
    }

    /**
     * @param dsMaxProposta the dsMaxProposta to set
     */
    public void setDsMaxProposta(DataSet dsMaxProposta) {
        this.dsMaxProposta = dsMaxProposta;
    }

    /**
     * @return the filtrarOrgao
     */
    public boolean isFiltrarOrgao() {
        return filtrarOrgao;
    }

    /**
     * @param filtrarOrgao the filtrarOrgao to set
     */
    public void setFiltrarOrgao(boolean filtrarOrgao) {
        this.filtrarOrgao = filtrarOrgao;
    }
}
