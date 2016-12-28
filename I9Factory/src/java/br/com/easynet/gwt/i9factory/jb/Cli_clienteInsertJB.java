package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cli_clienteInsertJB extends SystemBase {

    // Atributos e propriedades
    private Cli_clienteT cli_clienteT = new Cli_clienteT();
    private String dt_cadastro;
    private int orgao;
    private int banco;
    private String agencia;
    private String conta;
    private String salariominimo;
    private DataSet dsConta;

    public void setCli_clienteT(Cli_clienteT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;
    }

    public Cli_clienteT getCli_clienteT() {
        return cli_clienteT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    // Metodo de Eventos
    public void insert() throws Exception {
        DAOFactory factory = null;
        try {
            System.out.println("validar existencia");
            if (!clienteExiste()) {
                System.out.println("clinete não existe");
                Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
                factory = cli_clienteDAO.getDAOFactory();
                factory.beginTransaction();
                if (cli_clienteT.getCli_bt_foto() != null) {
                    cli_clienteT.setCli_tx_socio("S");
                    cli_clienteDAO.insert(cli_clienteT);
                } else {
                    cli_clienteDAO.insertNotImage(cli_clienteT);
                    cli_clienteT.setCli_tx_salario_minimo(salariominimo);
                }
                InsertOrgao();
                insertContaCorrente();
                factory.commitTransaction();
                setMsg(INFO, "Cadastro efetuado com sucesso!");
                getContaCorrenteCliente();
            } else {
                System.out.println("cliente já cadastrado com este CPF");
                setMsg(ERROR, "Falha, cliente já cadastrado com este CPF!");
            }
            //clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
            factory.rollbackTransaction();
        } finally {
            close();
        }
    }

    public void getContaCorrenteCliente() throws Exception {
        try {
            Cco_contacorrenteDAO cdao = getCco_contacorrenteDAO();
            String ids = "(" + cli_clienteT.getCli_nr_id() + ")";
            setDsConta(cdao.getByCli_nr_id(ids));
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public void InsertOrgao() throws Exception {
        try {
            Orcl_orgao_clienteDAO odao = getOrcl_orgao_clienteDAO();
            Orcl_orgao_clienteT orcl_orgao_clienteT = new Orcl_orgao_clienteT();
            orcl_orgao_clienteT.setCli_nr_id(cli_clienteT.getCli_nr_id());
            orcl_orgao_clienteT.setOrg_nr_id(orgao);
            odao.insert(orcl_orgao_clienteT);
        } catch (Exception e) {
            throw e;
        }finally{
        }
    }

    public void insertContaCorrente() throws Exception {
        try {
            Cco_contacorrenteDAO cdao = getCco_contacorrenteDAO();
            Cco_contacorrenteT cco_contacorrenteT = new Cco_contacorrenteT();
            cco_contacorrenteT.setCli_nr_id(cli_clienteT.getCli_nr_id());
            cco_contacorrenteT.setOrg_nr_id(orgao);
            cco_contacorrenteT.setBco_nr_id(banco);
            cco_contacorrenteT.setCco_tx_nragencia(agencia);
            cco_contacorrenteT.setCco_tx_nrcontacorrente(conta);
            cdao.insert(cco_contacorrenteT);
        } catch (Exception e) {
            throw e;
        }finally{
        }
    }

    public boolean clienteExiste() throws Exception {
        boolean res = false;
        try {
            System.out.println("intanciando o dao");
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            System.out.println("dao intanciando");
            List<Cli_clienteT> lis = cli_clienteDAO.getByCli_tx_cpf(cli_clienteT);
            System.out.println("lista preenchida");
            if (lis != null & lis.size() > 0) {
                res = true;
            }
        } catch (Exception e) {
            System.out.println("na exceção");
            throw e;
        }
        return res;

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

    public void clear() throws Exception {

        cli_clienteT = new Cli_clienteT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cli_clienteConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the dt_cadastro
     */
    public String getDt_cadastro() {
        return dt_cadastro;
    }

    /**
     * @param dt_cadastro the dt_cadastro to set
     */
    public void setDt_cadastro(String dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    /**
     * @return the orgao
     */
    public int getOrgao() {
        return orgao;
    }

    /**
     * @param orgao the orgao to set
     */
    public void setOrgao(int orgao) {
        this.orgao = orgao;
    }

    /**
     * @return the banco
     */
    public int getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(int banco) {
        this.banco = banco;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the conta
     */
    public String getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(String conta) {
        this.conta = conta;
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
     * @return the salariominimo
     */
    public String getSalariominimo() {
        return salariominimo;
    }

    /**
     * @param salariominimo the salariominimo to set
     */
    public void setSalariominimo(String salariominimo) {
        this.salariominimo = salariominimo;
    }
}
