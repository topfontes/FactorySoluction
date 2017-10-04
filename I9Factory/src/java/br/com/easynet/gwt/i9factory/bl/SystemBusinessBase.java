package br.com.easynet.gwt.i9factory.bl;

import br.com.easynet.bl.BusinessBase;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.util.List;
import javax.sql.DataSource;

public class SystemBusinessBase extends BusinessBase {

    private int typeDatabase = DAOFactory.POSTGRESQL;
    private String url = "jdbc:postgresql://192.168.25.163:5432/casserp";
    private String user = "postgres";
    private String pass = "i9factory2017";
    private DAOFactory dao;
    private String datasourceName = "java:comp/env/jdbc/NOME_CONEXAO";

    public DAOFactory getDAO() throws Exception {
        if (dao != null) {
            return dao;
        }
        return getDAO(typeDatabase, url, user, pass);
    }

    public DAOFactory getDAODataSource() throws Exception {

        DataSource ds = getDataSource(datasourceName);
        return DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
    }

    public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
        if (dao != null) {
            return dao;
        }
        return DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
    }

    public void close() {
        try {
            dao.close();
            dao = null;
        } catch (Exception e) {
        }
    }

    /**
     * Método para validar a seguranca
     */
    public boolean valide(String metodo) throws Exception {
        // Logica da seguranca
        return true;
    }

    public Age_agenciadorDAO getAge_agenciadorDAO() throws Exception {
        dao = getDAO();
        return new Age_agenciadorDAO(dao);
    }

    public Bco_bancoDAO getBco_bancoDAO() throws Exception {
        dao = getDAO();
        return new Bco_bancoDAO(dao);
    }

    public Cco_contacorrenteDAO getCco_contacorrenteDAO() throws Exception {
        dao = getDAO();
        return new Cco_contacorrenteDAO(dao);
    }

    public Cli_clienteDAO getCli_clienteDAO() throws Exception {
        dao = getDAO();
        return new Cli_clienteDAO(dao);
    }

    public Car_cartaoDAO getCar_cartaoDAO() throws Exception {
        dao = getDAO();
        return new Car_cartaoDAO(dao);
    }
//getTac_taxa_cartaoDAO
    public Tac_taxa_cartaoDAO getTac_taxa_cartaoDAO() throws Exception {
        dao = getDAO();
        return new Tac_taxa_cartaoDAO(dao);
    }
    public Cor_corretoraDAO getCor_corretoraDAO() throws Exception {
        dao = getDAO();
        return new Cor_corretoraDAO(dao);
    }

    public Ctp_conta_pagarDAO getCtp_conta_pagarDAO() throws Exception {
        dao = getDAO();
        return new Ctp_conta_pagarDAO(dao);
    }

    public Dep_dependenteDAO getDep_dependenteDAO() throws Exception {
        dao = getDAO();
        return new Dep_dependenteDAO(dao);
    }

    public Emp_emprestimoDAO getEmp_emprestimoDAO() throws Exception {
        dao = getDAO();
        return new Emp_emprestimoDAO(dao);
    }

    public Eqp_equipeDAO getEqp_equipeDAO() throws Exception {
        dao = getDAO();
        return new Eqp_equipeDAO(dao);
    }

    public For_fornecedorDAO getFor_fornecedorDAO() throws Exception {
        dao = getDAO();
        return new For_fornecedorDAO(dao);
    }

    public Idc_indiceDAO getIdc_indiceDAO() throws Exception {
        dao = getDAO();
        return new Idc_indiceDAO(dao);
    }

    public Org_orgaoDAO getOrg_orgaoDAO() throws Exception {
        dao = getDAO();
        return new Org_orgaoDAO(dao);
    }

    public Ple_parcelaemprestimoDAO getPle_parcelaemprestimoDAO() throws Exception {
        dao = getDAO();
        return new Ple_parcelaemprestimoDAO(dao);
    }

    public Ref_referenciaDAO getRef_referenciaDAO() throws Exception {
        dao = getDAO();
        return new Ref_referenciaDAO(dao);
    }

    public Res_restricaoDAO getRes_restricaoDAO() throws Exception {
        dao = getDAO();
        return new Res_restricaoDAO(dao);
    }

    public Tid_tipo_despesaDAO getTid_tipo_despesaDAO() throws Exception {
        dao = getDAO();
        return new Tid_tipo_despesaDAO(dao);
    }

    

    public Tmp_tipomensalidadeDAO getTmp_tipomensalidadeDAO() throws Exception {
        dao = getDAO();
        return new Tmp_tipomensalidadeDAO(dao);
    }

    public Age_agenciadorT findbyIdAge_agenciador(Age_agenciadorT age_agenciadorT) throws Exception {
        try {
            Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();

            List<Age_agenciadorT> listTemp = age_agenciadorDAO.getByPK(age_agenciadorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Bco_bancoT findbyIdBco_banco(Bco_bancoT bco_bancoT) throws Exception {
        try {
            Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();

            List<Bco_bancoT> listTemp = bco_bancoDAO.getByPK(bco_bancoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cco_contacorrenteT findbyIdCco_contacorrente(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        try {
            Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();

            List<Cco_contacorrenteT> listTemp = cco_contacorrenteDAO.getByPK(cco_contacorrenteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cli_clienteT findbyIdCli_cliente(Cli_clienteT cli_clienteT) throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();

            List<Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cor_corretoraT findbyIdCor_corretora(Cor_corretoraT cor_corretoraT) throws Exception {
        try {
            Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();

            List<Cor_corretoraT> listTemp = cor_corretoraDAO.getByPK(cor_corretoraT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ctp_conta_pagarT findbyIdCtp_conta_pagar(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();

            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Dep_dependenteT findbyIdDep_dependente(Dep_dependenteT dep_dependenteT) throws Exception {
        try {
            Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();

            List<Dep_dependenteT> listTemp = dep_dependenteDAO.getByPK(dep_dependenteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Emp_emprestimoT findbyIdEmp_emprestimo(Emp_emprestimoT emp_emprestimoT) throws Exception {
        try {
            Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();

            List<Emp_emprestimoT> listTemp = emp_emprestimoDAO.getByPK(emp_emprestimoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Eqp_equipeT findbyIdEqp_equipe(Eqp_equipeT eqp_equipeT) throws Exception {
        try {
            Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();

            List<Eqp_equipeT> listTemp = eqp_equipeDAO.getByPK(eqp_equipeT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public For_fornecedorT findbyIdFor_fornecedor(For_fornecedorT for_fornecedorT) throws Exception {
        try {
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();

            List<For_fornecedorT> listTemp = for_fornecedorDAO.getByPK(for_fornecedorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Idc_indiceT findbyIdIdc_indice(Idc_indiceT idc_indiceT) throws Exception {
        try {
            Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();

            List<Idc_indiceT> listTemp = idc_indiceDAO.getByPK(idc_indiceT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Org_orgaoT findbyIdOrg_orgao(Org_orgaoT org_orgaoT) throws Exception {
        try {
            Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();

            List<Org_orgaoT> listTemp = org_orgaoDAO.getByPK(org_orgaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ple_parcelaemprestimoT findbyIdPle_parcelaemprestimo(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        try {
            Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();

            List<Ple_parcelaemprestimoT> listTemp = ple_parcelaemprestimoDAO.getByPK(ple_parcelaemprestimoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ref_referenciaT findbyIdRef_referencia(Ref_referenciaT ref_referenciaT) throws Exception {
        try {
            Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();

            List<Ref_referenciaT> listTemp = ref_referenciaDAO.getByPK(ref_referenciaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Res_restricaoT findbyIdRes_restricao(Res_restricaoT res_restricaoT) throws Exception {
        try {
            Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();

            List<Res_restricaoT> listTemp = res_restricaoDAO.getByPK(res_restricaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tid_tipo_despesaT findbyIdTid_tipo_despesa(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception {
        try {
            Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();

            List<Tid_tipo_despesaT> listTemp = tid_tipo_despesaDAO.getByPK(tid_tipo_despesaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tmp_tipomensalidadeT findbyIdTmp_tipomensalidade(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        try {
            Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();

            List<Tmp_tipomensalidadeT> listTemp = tmp_tipomensalidadeDAO.getByPK(tmp_tipomensalidadeT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Lan_lancamentoDAO getLan_lancamentoDAO() throws Exception {
        dao = getDAO();
        return new Lan_lancamentoDAO(dao);
    }

    public Lan_lancamentoT findbyIdLan_lancamento(Lan_lancamentoT lan_lancamentoT) throws Exception {
        try {
            Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();

            List<Lan_lancamentoT> listTemp = lan_lancamentoDAO.getByPK(lan_lancamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Orcl_orgao_clienteDAO getOrcl_orgao_clienteDAO() throws Exception {
        dao = getDAO();
        return new Orcl_orgao_clienteDAO(dao);
    }

    public Orcl_orgao_clienteT findbyIdOrcl_orgao_cliente(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        try {
            Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();

            List<Orcl_orgao_clienteT> listTemp = orcl_orgao_clienteDAO.getByPK(orcl_orgao_clienteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Par_parametroDAO getPar_parametroDAO() throws Exception {
        dao = getDAO();
        return new Par_parametroDAO(dao);
    }

    public Par_parametroT findbyIdPar_parametro(Par_parametroT par_parametroT) throws Exception {
        try {
            Par_parametroDAO par_parametroDAO = getPar_parametroDAO();

            List<Par_parametroT> listTemp = par_parametroDAO.getByPK(par_parametroT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Arb_arquivobancoDAO getArb_arquivobancoDAO() throws Exception {
        dao = getDAO();
        return new Arb_arquivobancoDAO(dao);
    }

    public Arb_arquivobancoT findbyIdArb_arquivobanco(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        try {
            Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();

            List<Arb_arquivobancoT> listTemp = arb_arquivobancoDAO.getByPK(arb_arquivobancoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Teb_transmissao_empresa_bancoDAO getTeb_transmissao_empresa_bancoDAO() throws Exception {
        dao = getDAO();
        return new Teb_transmissao_empresa_bancoDAO(dao);
    }

    public Teb_transmissao_empresa_bancoT findbyIdTeb_transmissao_empresa_banco(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        try {
            Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tic_tipo_creditoDAO getTic_tipo_creditoDAO() throws Exception {
        dao = getDAO();
        return new Tic_tipo_creditoDAO(dao);
    }

    public Tic_tipo_creditoT findbyIdTic_tipo_credito(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception {
        try {
            Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();

            List<Tic_tipo_creditoT> listTemp = tic_tipo_creditoDAO.getByPK(tic_tipo_creditoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

}
