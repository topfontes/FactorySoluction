package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Emp_emprestimoDAO extends ObjectDAO {

    private static Object inserir = "true";

    public Emp_emprestimoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int maxId() throws Exception {
        ResultSet rs = null;
        Statement st = null;
        try {
            String sql = "select max(emp_nr_id) as emp_nr_id from factory.emp_emprestimo";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("emp_nr_id");
            }
            return id;

        } catch (Exception e) {
            try {
                rs.close();
                st.close();
            } catch (Exception e1) {
                throw e1;
            }
        }
        return 0;
    }

    public void insert(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        synchronized (inserir) {
            try {
                String sql = "insert into factory.emp_emprestimo  ( cli_nr_id, Cor_nr_id, idc_nr_id, emp_dt_emprestimo, emp_nr_valor, emp_tx_status, emp_tx_observacoes, emp_dt_aprovacao, emp_dt_liberacao, emp_dt_quitacao, emp_dt_enviobanco, emp_dt_retornobanco, emp_tx_cdlancamentobanco, emp_tx_cdlancamentopendente, emp_tx_numerocheque, org_nr_id, emp_nr_valor_parcelas_anterior,emp_nr_valor_desc_parcela_anterior,emp_nr_valor_afin_bruto,emp_nr_valor_afin_liquido,emp_nr_proposta, usu_nr_id, tic_nr_id, emp_tx_compensado, emp_tx_acordo,emp_seq_nr_boletobb) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,?)";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, emp_emprestimoT.getCli_nr_id());
                pStmt.setObject(2, emp_emprestimoT.getCor_nr_id());
                pStmt.setObject(3, emp_emprestimoT.getIdc_nr_id());
                java.sql.Date dt4 = new java.sql.Date(emp_emprestimoT.getEmp_dt_emprestimo() != null ? emp_emprestimoT.getEmp_dt_emprestimo().getTime() : null);
                pStmt.setObject(4, dt4);
                pStmt.setObject(5, emp_emprestimoT.getEmp_nr_valor());
                pStmt.setObject(6, emp_emprestimoT.getEmp_tx_status());
                pStmt.setObject(7, getObs(emp_emprestimoT.getEmp_tx_observacoes()));
                java.sql.Date dt8 = new java.sql.Date(emp_emprestimoT.getEmp_dt_aprovacao() != null ? emp_emprestimoT.getEmp_dt_aprovacao().getTime() : null);
                pStmt.setObject(8, dt8);
                if (emp_emprestimoT.getEmp_dt_liberacao() != null) {
                    java.sql.Date dt9 = new java.sql.Date(emp_emprestimoT.getEmp_dt_liberacao().getTime());
                    pStmt.setObject(9, dt9);
                } else {
                    pStmt.setObject(9, null);
                }

//                java.sql.Date dt10 = new java.sql.Date(emp_emprestimoT.getEmp_dt_quitacao() != null ? emp_emprestimoT.getEmp_dt_quitacao().getTime() : null);
                pStmt.setObject(10, null);
                pStmt.setObject(11, emp_emprestimoT.getEmp_dt_enviobanco());
                pStmt.setObject(12, emp_emprestimoT.getEmp_dt_retornobanco());
                pStmt.setObject(13, emp_emprestimoT.getEmp_tx_cdlancamentobanco());
                pStmt.setObject(14, emp_emprestimoT.getEmp_tx_cdlancamentopendente());
                pStmt.setObject(15, emp_emprestimoT.getEmp_tx_numerocheque());
                pStmt.setObject(16, emp_emprestimoT.getOrg_nr_id());
                pStmt.setObject(17, emp_emprestimoT.getEmp_nr_valor_parcelas_anterior());
                pStmt.setObject(18, emp_emprestimoT.getEmp_nr_valor_desc_parcela_anterior());
                pStmt.setObject(19, emp_emprestimoT.getEmp_nr_valor_afin_bruto());
                pStmt.setObject(20, emp_emprestimoT.getEmp_nr_valor_afin_liquido());
                pStmt.setObject(21, emp_emprestimoT.getEmp_nr_proposta());
                pStmt.setObject(22, emp_emprestimoT.getUsu_nr_id());
                pStmt.setObject(23, emp_emprestimoT.getTic_nr_id());
                pStmt.setObject(24, "N");
                pStmt.setObject(25, emp_emprestimoT.getEmp_tx_acordo());
                pStmt.setObject(26, emp_emprestimoT.getEmp_seq_nr_boletobb());
                pStmt.execute();
                emp_emprestimoT.setEmp_nr_id(maxId());
            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    pStmt.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public void update(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.emp_emprestimo set  cli_nr_id=?, cor_nr_id=?, idc_nr_id=?, emp_dt_emprestimo=?, emp_nr_valor=?, emp_tx_status=?, emp_tx_observacoes=?, emp_dt_aprovacao=?, emp_dt_liberacao=?, emp_dt_quitacao=?, emp_dt_enviobanco=?, emp_dt_retornobanco=?, emp_tx_cdlancamentobanco=?, emp_tx_cdlancamentopendente=?, emp_tx_numerocheque=?, org_nr_id=?, emp_nr_valor_parcelas_anterior=?, emp_nr_valor_desc_parcela_anterior=?, emp_nr_valor_afin_bruto=?, emp_nr_valor_afin_liquido=?, emp_nr_proposta=?, usu_nr_id=?, tic_nr_id =?, emp_tx_compensado=? , emp_tx_acordo=?, emp_seq_nr_boletobb=? where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getCli_nr_id());
            pStmt.setObject(2, emp_emprestimoT.getCor_nr_id());
            pStmt.setObject(3, emp_emprestimoT.getIdc_nr_id());
            java.sql.Date dt4 = new java.sql.Date(emp_emprestimoT.getEmp_dt_emprestimo().getTime());
            pStmt.setObject(4, dt4);
            pStmt.setObject(5, emp_emprestimoT.getEmp_nr_valor());
            pStmt.setObject(6, emp_emprestimoT.getEmp_tx_status());
            pStmt.setObject(7, emp_emprestimoT.getEmp_tx_observacoes());
            java.sql.Date dt8 = new java.sql.Date(emp_emprestimoT.getEmp_dt_aprovacao().getTime());
            pStmt.setObject(8, dt8);
            if (emp_emprestimoT.getEmp_dt_liberacao() != null) {
                java.sql.Date dt9 = new java.sql.Date(emp_emprestimoT.getEmp_dt_liberacao().getTime());
                pStmt.setObject(9, dt9);
            } else {
                pStmt.setObject(9, null);
            }
            if (emp_emprestimoT.getEmp_dt_quitacao() != null) {
                java.sql.Date dt10 = new java.sql.Date(emp_emprestimoT.getEmp_dt_quitacao().getTime());
                pStmt.setObject(10, dt10);
            } else {
                pStmt.setObject(10, null);
            }

            pStmt.setObject(11, emp_emprestimoT.getEmp_dt_enviobanco());
            pStmt.setObject(12, emp_emprestimoT.getEmp_dt_retornobanco());
            pStmt.setObject(13, emp_emprestimoT.getEmp_tx_cdlancamentobanco());
            pStmt.setObject(14, emp_emprestimoT.getEmp_tx_cdlancamentopendente());
            pStmt.setObject(15, emp_emprestimoT.getEmp_tx_numerocheque());
            pStmt.setObject(16, emp_emprestimoT.getOrg_nr_id());
            pStmt.setObject(17, emp_emprestimoT.getEmp_nr_valor_parcelas_anterior());
            pStmt.setObject(18, emp_emprestimoT.getEmp_nr_valor_desc_parcela_anterior());
            pStmt.setObject(19, emp_emprestimoT.getEmp_nr_valor_afin_bruto());
            pStmt.setObject(20, emp_emprestimoT.getEmp_nr_valor_afin_liquido());
            pStmt.setObject(21, emp_emprestimoT.getEmp_nr_proposta());
            pStmt.setObject(22, emp_emprestimoT.getUsu_nr_id());
            pStmt.setObject(23, emp_emprestimoT.getTic_nr_id());
            pStmt.setObject(24, emp_emprestimoT.getEmp_tx_compensado());
            pStmt.setObject(25, emp_emprestimoT.getEmp_tx_acordo());
            pStmt.setObject(26, emp_emprestimoT.getEmp_seq_nr_boletobb());
            pStmt.setObject(27, emp_emprestimoT.getEmp_nr_id());

            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateCompensado(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.emp_emprestimo set emp_tx_compensado=? where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_tx_compensado());
            pStmt.setObject(2, emp_emprestimoT.getEmp_nr_id());

            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void updateBaixa(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.emp_emprestimo set emp_tx_status=?, emp_dt_quitacao=? where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_tx_status());

            if (emp_emprestimoT.getEmp_dt_quitacao() != null) {
                java.sql.Date dt10 = new java.sql.Date(emp_emprestimoT.getEmp_dt_quitacao().getTime());
                pStmt.setObject(2, dt10);
            } else {
                pStmt.setObject(2, null);
            }
            pStmt.setObject(3, emp_emprestimoT.getEmp_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void ExtornarBaixa(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.emp_emprestimo set emp_tx_status=?, emp_dt_quitacao=? where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_tx_status());
            pStmt.setObject(2, null);
            pStmt.setObject(3, emp_emprestimoT.getEmp_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.emp_emprestimo where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    private List<Emp_emprestimoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Emp_emprestimoT> objs = new Vector();
        while (rs.next()) {
            Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
            emp_emprestimoT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            emp_emprestimoT.setCli_nr_id(rs.getInt("cli_nr_id"));
            emp_emprestimoT.setOrg_nr_id(rs.getInt("org_nr_id"));
            emp_emprestimoT.setCor_nr_id(rs.getInt("cor_nr_id"));
            emp_emprestimoT.setIdc_nr_id(rs.getInt("idc_nr_id"));
            emp_emprestimoT.setEmp_dt_emprestimo(rs.getDate("emp_dt_emprestimo"));
            emp_emprestimoT.setEmp_nr_valor(rs.getFloat("emp_nr_valor"));
            emp_emprestimoT.setEmp_tx_status(rs.getString("emp_tx_status"));
            emp_emprestimoT.setEmp_dt_aprovacao(rs.getDate("emp_dt_aprovacao"));
            emp_emprestimoT.setEmp_dt_liberacao(rs.getDate("emp_dt_liberacao"));
            emp_emprestimoT.setEmp_dt_quitacao(rs.getDate("emp_dt_quitacao"));
            emp_emprestimoT.setEmp_dt_enviobanco(rs.getTimestamp("emp_dt_enviobanco"));
            emp_emprestimoT.setEmp_dt_retornobanco(rs.getTimestamp("emp_dt_retornobanco"));
            emp_emprestimoT.setEmp_tx_cdlancamentobanco(rs.getString("emp_tx_cdlancamentobanco"));
            emp_emprestimoT.setEmp_tx_cdlancamentopendente(rs.getString("emp_tx_cdlancamentopendente"));
            emp_emprestimoT.setEmp_tx_numerocheque(rs.getString("emp_tx_numerocheque"));
            
            emp_emprestimoT.setEmp_tx_acordo(rs.getString("emp_tx_acordo"));
            emp_emprestimoT.setEmp_seq_nr_boletobb(rs.getInt("emp_seq_nr_boletobb"));
            objs.add(emp_emprestimoT);
        }
        return objs;
    }

    public String getObs(String observ) {
        if (observ != null && observ.length() > 0) {
            String obs = observ.replaceAll("\n", " ").replaceAll("\r", " ");
            return obs;
        } else {
            return "";
        }
    }

    public DataSet getAll(Emp_emprestimoT emp_emprestimoT, java.sql.Date dtInicio, java.sql.Date dtFinal, String agrupamento, String status) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            ArrayList list = new ArrayList();

            String dtStatus = "";
            if (status.equalsIgnoreCase("A") || status.equalsIgnoreCase("T")) {
                dtStatus = " emp_dt_emprestimo ";
            } else {
                dtStatus = " emp_dt_quitacao ";
            }

            sql.append("select distinct emp.emp_nr_id, emp.cli_nr_id, emp.age_nr_id, emp.idc_nr_id, emp.emp_dt_emprestimo, emp.emp_nr_valor, emp.emp_tx_status, replace(replace(emp.emp_tx_observacoes,chr(10),'' ), chr(13),'') as emp_tx_observacoes, emp.emp_dt_aprovacao, emp.emp_dt_liberacao, emp.emp_dt_quitacao, emp.emp_dt_enviobanco, emp.emp_dt_retornobanco, emp.emp_tx_cdlancamentobanco, emp.emp_tx_cdlancamentopendente, emp.emp_tx_numerocheque, emp.org_nr_id, emp.cor_nr_id, cli.cli_tx_nome, org.org_tx_nomefantasia as org_tx_nome,cor.cor_tx_nomefantasia as cor_tx_nome, cli.cli_tx_cpf, cli.cli_tx_matricula,banco.bco_tx_nome, emp_nr_valor_parcelas_anterior, emp_nr_valor_desc_parcela_anterior, emp_nr_valor_afin_bruto, emp_nr_valor_afin_liquido, emp_nr_proposta, usu.usu_tx_nome, tic_nr_id, emp_tx_compensado, emp_tx_acordo, emp_seq_nr_boletobb from factory.emp_emprestimo as emp");
            sql.append(" inner join factory.cor_corretora as cor on(emp.cor_nr_id = cor.cor_nr_id) ");
            sql.append(" inner join factory.org_orgao as org on(org.org_nr_id = emp.org_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id) ");
            sql.append(" inner join factory.cco_contacorrente as conta on(conta.cli_nr_id = cli.cli_nr_id and conta.org_nr_id = org.org_nr_id)");
            sql.append(" inner join factory.bco_banco as banco on(banco.bco_nr_id = conta.bco_nr_id)");
            sql.append(" left outer join portal.usu_usuario as usu on(usu.usu_nr_id = emp.usu_nr_id)");
            System.out.println(sql.toString());

            sql.append(" where ");
            if (!status.equalsIgnoreCase("T")) {
                sql.append(" emp.emp_tx_status = ? ");
                sql.append(" and ");
                list.add(status);
            }

            list.add(dtInicio);
            list.add(dtFinal);

            sql.append(dtStatus);
            sql.append(" between ? and ?");

            String ordem = "";
            if (emp_emprestimoT.getCor_nr_id() > 0) {
                sql.append(" and emp.cor_nr_id =?");
                list.add(emp_emprestimoT.getCor_nr_id());
            } else if (emp_emprestimoT.getOrg_nr_id() > 0) {
                list.add(emp_emprestimoT.getOrg_nr_id());
                sql.append(" and emp.org_nr_id =?");
            } else if (emp_emprestimoT.getCli_nr_id() > 0) {
                list.add(emp_emprestimoT.getCli_nr_id());
                sql.append(" and emp.cli_nr_id =?");
            }

            if (agrupamento.equalsIgnoreCase("C") || agrupamento.equalsIgnoreCase("G")) {
                ordem = " cli.cli_tx_nome, " + dtStatus;
            } else if (agrupamento.equalsIgnoreCase("O")) {
                ordem = " org.org_tx_nomefantasia, " + dtStatus;
            } else if (agrupamento.equalsIgnoreCase("R")) {
                ordem = " cor.cor_tx_nomefantasia, " + dtStatus;
            }

            sql.append(" order by ");
            sql.append(ordem);
            System.out.println(sql.toString());
            ds = executeQuery(sql.toString(), list.toArray());
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getAllComissao(Emp_emprestimoT emp_emprestimoT, java.sql.Date dtInicio, java.sql.Date dtFinal) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            ArrayList list = new ArrayList();
            list.add(dtInicio);
            list.add(dtFinal);
            sql.append("select distinct emp.emp_nr_id, emp.cli_nr_id, emp.age_nr_id, emp.idc_nr_id, emp.emp_dt_emprestimo, emp.emp_nr_valor, emp.emp_tx_status, replace(replace(emp.emp_tx_observacoes,chr(10),'' ), chr(13),'')as emp_tx_observacoes, emp.emp_dt_aprovacao, emp.emp_dt_liberacao, emp.emp_dt_quitacao, emp.emp_dt_enviobanco, emp.emp_dt_retornobanco, emp.emp_tx_cdlancamentobanco, emp.emp_tx_cdlancamentopendente, emp.emp_tx_numerocheque, emp.org_nr_id, emp.cor_nr_id, cli.cli_tx_nome, org.org_tx_nomefantasia as org_tx_nome,cor.cor_tx_nomefantasia as cor_tx_nome, cli.cli_tx_cpf, cli.cli_tx_matricula,banco.bco_tx_nome, emp_nr_valor_parcelas_anterior, emp_nr_valor_desc_parcela_anterior, emp_nr_valor_afin_bruto, emp_nr_valor_afin_liquido, emp_nr_proposta, usu.usu_tx_nome, tic_nr_id, emp_tx_compensado from factory.emp_emprestimo as emp");
            sql.append(" inner join factory.cor_corretora as cor on(emp.cor_nr_id = cor.cor_nr_id) ");
            sql.append(" inner join factory.org_orgao as org on(org.org_nr_id = emp.org_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id) ");
            sql.append(" inner join factory.cco_contacorrente as conta on(conta.cli_nr_id = cli.cli_nr_id and conta.org_nr_id = org.org_nr_id)");
            sql.append(" inner join factory.bco_banco as banco on(banco.bco_nr_id = conta.bco_nr_id)");
            sql.append(" left outer join portal.usu_usuario as usu on(usu.usu_nr_id = emp.usu_nr_id)");
            sql.append(" where emp.emp_dt_emprestimo between ? and ? ");

            if (emp_emprestimoT.getCor_nr_id() > 0) {
                sql.append(" and emp.cor_nr_id =?");
                list.add(emp_emprestimoT.getCor_nr_id());
            }
            sql.append(" order by cor.cor_tx_nomefantasia, emp.emp_dt_emprestimo");
            ds = executeQuery(sql.toString(), list.toArray());
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getAllComissaoMensalidades(Emp_emprestimoT emp_emprestimoT, java.sql.Date dtInicio, java.sql.Date dtFinal) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            ArrayList list = new ArrayList();
            list.add(dtInicio);
            list.add(dtFinal);
            sql.append("select distinct emp.emp_nr_id, emp.cli_nr_id, emp.age_nr_id, emp.idc_nr_id, emp.emp_dt_emprestimo, emp.emp_nr_valor, emp.emp_tx_status, replace(replace(emp.emp_tx_observacoes,chr(10),'' ), chr(13),'')as emp_tx_observacoes, emp.emp_dt_aprovacao, emp.emp_dt_liberacao, emp.emp_dt_quitacao, emp.emp_dt_enviobanco, emp.emp_dt_retornobanco, emp.emp_tx_cdlancamentobanco, emp.emp_tx_cdlancamentopendente, emp.emp_tx_numerocheque, emp.org_nr_id, emp.cor_nr_id, cli.cli_tx_nome, org.org_tx_nomefantasia as org_tx_nome,cor.cor_tx_nomefantasia as cor_tx_nome, cli.cli_tx_cpf, cli.cli_tx_matricula,banco.bco_tx_nome, emp_nr_valor_parcelas_anterior, emp_nr_valor_desc_parcela_anterior, emp_nr_valor_afin_bruto, parcela.ple_nr_valorparcela as emp_nr_valor_afin_liquido, emp_nr_proposta, usu.usu_tx_nome,tic_nr_id, emp_tx_compensado from factory.emp_emprestimo as emp");
            sql.append(" inner join factory.cor_corretora as cor on(emp.cor_nr_id = cor.cor_nr_id) ");
            sql.append(" inner join factory.org_orgao as org on(org.org_nr_id = emp.org_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id) ");
            sql.append(" inner join factory.cco_contacorrente as conta on(conta.cli_nr_id = cli.cli_nr_id and conta.org_nr_id = org.org_nr_id)");
            sql.append(" inner join factory.bco_banco as banco on(banco.bco_nr_id = conta.bco_nr_id)");
            sql.append(" inner join factory.ple_parcelaemprestimo parcela on(parcela.emp_nr_id = emp.emp_nr_id)");
            sql.append(" left outer join portal.usu_usuario as usu on(usu.usu_nr_id = emp.usu_nr_id)");
            sql.append(" where parcela.ple_tx_tipo = 'M'");
            sql.append(" and parcela.ple_dt_pagamento between ? and ?");

            if (emp_emprestimoT.getCor_nr_id() > 0) {
                sql.append(" and emp.cor_nr_id =?");
                list.add(emp_emprestimoT.getCor_nr_id());
            }
            sql.append(" order by cor.cor_tx_nomefantasia, emp.emp_dt_emprestimo");
            ds = executeQuery(sql.toString(), list.toArray());
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getUltimos() throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();

            sql.append("select distinct emp.emp_nr_id, emp.cli_nr_id, emp.age_nr_id, emp.idc_nr_id, emp.emp_dt_emprestimo, emp.emp_nr_valor, emp.emp_tx_status, replace(replace(emp.emp_tx_observacoes,chr(10),'' ), chr(13),'') as emp_tx_observacoes, emp.emp_dt_aprovacao, emp.emp_dt_liberacao, emp.emp_dt_quitacao, emp.emp_dt_enviobanco, emp.emp_dt_retornobanco, emp.emp_tx_cdlancamentobanco, emp.emp_tx_cdlancamentopendente, emp.emp_tx_numerocheque, emp.org_nr_id, emp.cor_nr_id, cli.cli_tx_nome, org.org_tx_nomefantasia as org_tx_nome,cor.cor_tx_nomefantasia as cor_tx_nome, cli.cli_tx_cpf, cli.cli_tx_matricula,banco.bco_tx_nome, emp_nr_valor_parcelas_anterior, emp_nr_valor_desc_parcela_anterior, emp_nr_valor_afin_bruto, emp_nr_valor_afin_liquido, emp_nr_proposta, usu.usu_tx_nome, tic_nr_id, emp_tx_compensado, emp_tx_acordo, emp_seq_nr_boletobb from factory.emp_emprestimo as emp");
            sql.append(" inner join factory.cor_corretora as cor on(emp.cor_nr_id = cor.cor_nr_id) ");
            sql.append(" inner join factory.org_orgao as org on(org.org_nr_id = emp.org_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id) ");
            sql.append(" inner join factory.cco_contacorrente as conta on(conta.cli_nr_id = cli.cli_nr_id and conta.org_nr_id = org.org_nr_id)");
            sql.append(" inner join factory.bco_banco as banco on(banco.bco_nr_id = conta.bco_nr_id)");
            sql.append(" left outer join portal.usu_usuario as usu on(usu.usu_nr_id = emp.usu_nr_id)");
            sql.append(" order by emp.emp_dt_emprestimo, cli_tx_nome limit 10");

            ds = executeQuery(sql.toString(), null);

            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public List<Emp_emprestimoT> getByPK(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_nr_id(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByCli_nr_id(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  cli_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getCli_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByCor_nr_id(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  cor_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getCor_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByIdc_nr_id(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  idc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getIdc_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_dt_emprestimo(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_dt_emprestimo = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(emp_emprestimoT.getEmp_dt_emprestimo().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_nr_valor(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_nr_valor());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_tx_status(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  Upper(emp_tx_status) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_emprestimoT.getEmp_tx_status() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_tx_observacoes(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  Upper(emp_tx_observacoes) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_emprestimoT.getEmp_tx_observacoes() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_dt_aprovacao(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_dt_aprovacao = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(emp_emprestimoT.getEmp_dt_aprovacao().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_dt_liberacao(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_dt_liberacao = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(emp_emprestimoT.getEmp_dt_liberacao().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_dt_quitacao(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_dt_quitacao = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(emp_emprestimoT.getEmp_dt_quitacao().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_dt_enviobanco(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_dt_enviobanco = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_dt_enviobanco());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_dt_retornobanco(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  emp_dt_retornobanco = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_dt_retornobanco());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_tx_cdlancamentobanco(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  Upper(emp_tx_cdlancamentobanco) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_emprestimoT.getEmp_tx_cdlancamentobanco() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_tx_cdlancamentopendente(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  Upper(emp_tx_cdlancamentopendente) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_emprestimoT.getEmp_tx_cdlancamentopendente() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_emprestimoT> getByEmp_tx_numerocheque(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where  Upper(emp_tx_numerocheque) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_emprestimoT.getEmp_tx_numerocheque() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    /**
     * Metodo FK
     */
    public List<Emp_emprestimoT> getByCli_cliente(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where cli_cliente.cli_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getCli_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    /**
     * Metodo FK
     */
    public List<Emp_emprestimoT> getByIdc_indice(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.emp_emprestimo where idc_indice.idc_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getIdc_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public int maxProposta() throws Exception {
        ResultSet rs = null;
        Statement st = null;
        try {
            String sql = "select max(emp_nr_proposta) as emp_nr_proposta from factory.emp_emprestimo";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            int proposta = 0;
            if (rs.next()) {
                proposta = rs.getInt("emp_nr_proposta");
            }
            return proposta;

        } catch (Exception e) {
            try {
                rs.close();
                st.close();
            } catch (Exception e1) {
                throw e1;
            }
        }
        return 0;
    }

    public int maxPropostaCli(int cli_nr_id) throws Exception {
        ResultSet rs = null;
        Statement st = null;
        try {
            String sql = "select max(emp_nr_proposta) as emp_nr_proposta from factory.emp_emprestimo where cli_nr_id=" + cli_nr_id;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            int proposta = 0;
            if (rs.next()) {
                proposta = rs.getInt("emp_nr_proposta");
            }
            return proposta;

        } catch (Exception e) {
            try {
                rs.close();
                st.close();
            } catch (Exception e1) {
                throw e1;
            }
        }
        return 0;
    }

    public DataSet getMaxProposta(String ids) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select cli.cli_nr_id,");
            sql.append(" (select max(emp.emp_nr_proposta) from factory.emp_emprestimo emp where emp.cli_nr_id = cli.cli_nr_id) as proposta");
            sql.append(" from factory.cli_cliente cli where cli.cli_nr_id in");
            sql.append(ids);
            ds = executeQuery(sql.toString(), null);
            return ds;

        } catch (Exception e) {
            throw e;
        }
    }
}
