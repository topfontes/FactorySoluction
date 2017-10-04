package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Ple_parcelaemprestimoDAO extends ObjectDAO {

    public Ple_parcelaemprestimoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public String getObs(String observ) {
        if (observ!= null && observ.length() > 0) {
            String obs = observ.replaceAll("\n", " ").replaceAll("\r", " ");
            return obs;
        } else {
            return "";
        }
    }

    public void insert(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.ple_parcelaemprestimo  ( emp_nr_id, ple_dt_vencimento, ple_dt_pagamento, ple_nr_valorparcela, ple_nr_valordesconto, ple_nr_cdformapagto, ple_tx_parcela, ple_tx_tipo,ple_tx_historico,ple_nr_seq_boleto) values ( ?, ?, ?, ? , ? , ? , ? , ? , ? ,?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getEmp_nr_id());
            java.sql.Date dt2 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_vencimento().getTime());
            pStmt.setObject(2, dt2);
            //java.sql.Date dt3 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_pagamento().getTime());
            pStmt.setObject(3, null);
            pStmt.setObject(4, ple_parcelaemprestimoT.getPle_nr_valorparcela());
            pStmt.setObject(5, ple_parcelaemprestimoT.getPle_nr_valordesconto());
            pStmt.setObject(6, ple_parcelaemprestimoT.getPle_nr_cdformapagto());
            pStmt.setObject(7, ple_parcelaemprestimoT.getPle_tx_parcela());
            pStmt.setObject(8, ple_parcelaemprestimoT.getPle_tx_tipo());
            pStmt.setObject(9, getObs(ple_parcelaemprestimoT.getPle_tx_historico()));
            pStmt.setObject(10, ple_parcelaemprestimoT.getPle_nr_seq_boleto() ==0?null:ple_parcelaemprestimoT.getPle_nr_seq_boleto());
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

    public boolean baixaCartao(java.util.Date dt_inicio, java.util.Date dt_final){
        PreparedStatement pStmt = null;
        try {
            java.sql.Date dt_ini = new java.sql.Date(dt_inicio.getTime());
            java.sql.Date dt_fim = new java.sql.Date(dt_final.getTime());
            String sql ="";
            pStmt = con.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();
            return true;
            
        } catch (Exception e) {
        }
        return false;
    }
    
    public void updateDataPagamento(Ple_parcelaemprestimoT pleT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.ple_parcelaemprestimo set  ple_dt_pagamento=?  where  ple_nr_id=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt3 = new java.sql.Date(pleT.getPle_dt_pagamento().getTime());
            pStmt.setObject(1, dt3);
            pStmt.setObject(2, pleT.getPle_nr_id());

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

    public void updateBaixaVinculada(Ple_parcelaemprestimoT pleT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.ple_parcelaemprestimo set ple_nr_valorparcela=?,  ple_dt_pagamento=?, ple_tx_historico=?  where  ple_nr_id=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt3 = new java.sql.Date(pleT.getPle_dt_pagamento().getTime());
            pStmt.setObject(1, pleT.getPle_nr_valorparcela());
            pStmt.setObject(2, dt3);
            pStmt.setObject(3, getObs(pleT.getPle_tx_historico()));
            pStmt.setObject(4, pleT.getPle_nr_id());

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

//
    public void updateSuspenso(Ple_parcelaemprestimoT pleT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.ple_parcelaemprestimo set  ple_bl_suspenso=?  where  ple_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pleT.isPle_bl_suspenso());
            pStmt.setObject(2, pleT.getPle_nr_id());

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

    public void update(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.ple_parcelaemprestimo set  emp_nr_id=?, ple_dt_vencimento=?, ple_dt_pagamento=?, ple_nr_valorparcela=?, ple_nr_valordesconto=?, ple_nr_cdformapagto=?, ple_tx_tipo=?, ple_tx_historico=?, ple_nr_id_vinculo=?  where  ple_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getEmp_nr_id());
            java.sql.Date dt2 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_vencimento().getTime());
            pStmt.setObject(2, dt2);
            if (ple_parcelaemprestimoT.getPle_dt_pagamento() == null) {
                pStmt.setObject(3, null);
            } else {
                java.sql.Date dt3 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_pagamento().getTime());
                pStmt.setObject(3, dt3);
            }
            pStmt.setObject(4, ple_parcelaemprestimoT.getPle_nr_valorparcela());
            pStmt.setObject(5, ple_parcelaemprestimoT.getPle_nr_valordesconto());
            pStmt.setObject(6, ple_parcelaemprestimoT.getPle_nr_cdformapagto());
            pStmt.setObject(7, ple_parcelaemprestimoT.getPle_tx_tipo());
            pStmt.setObject(8, getObs(ple_parcelaemprestimoT.getPle_tx_historico()));
            pStmt.setObject(9, ple_parcelaemprestimoT.getPle_nr_id_vinculo());
            pStmt.setObject(10, ple_parcelaemprestimoT.getPle_nr_id());

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

    public void updateAll(Ple_parcelaemprestimoT ple_parcelaemprestimoT, String ids) throws Exception {
        PreparedStatement pStmt = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("update factory.ple_parcelaemprestimo set ple_dt_pagamento = ?, ple_tx_historico=?, ple_nr_valordesconto=?  where  ple_nr_id in(");
            sql.append(ids);
            sql.append(")");
            pStmt = con.prepareStatement(sql.toString());
            if (ple_parcelaemprestimoT.getPle_dt_pagamento() == null) {
                java.util.Date d = new java.util.Date();
                java.sql.Date dt = new java.sql.Date(d.getTime());
                pStmt.setObject(1, dt);
            } else {
                java.sql.Date dt1 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_pagamento().getTime());
                pStmt.setObject(1, dt1);
            }
            pStmt.setObject(2, getObs(ple_parcelaemprestimoT.getPle_tx_historico()));
            pStmt.setObject(3, ple_parcelaemprestimoT.getPle_nr_valordesconto());
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

    public void updateDesconto(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.ple_parcelaemprestimo set  ple_dt_pagamento=?, ple_nr_valordesconto=?  where  ple_nr_id=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt3 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_pagamento().getTime());
            pStmt.setObject(1, dt3);
            pStmt.setObject(2, ple_parcelaemprestimoT.getPle_nr_valordesconto());
            pStmt.setObject(3, ple_parcelaemprestimoT.getPle_nr_id());
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

    public void delete(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.ple_parcelaemprestimo where  ple_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getPle_nr_id());
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

    public void deleteAllEmprestimo(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.ple_parcelaemprestimo where emp_nr_id=?";
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

    private List<Ple_parcelaemprestimoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ple_parcelaemprestimoT> objs = new Vector();
        while (rs.next()) {
            Ple_parcelaemprestimoT ple_parcelaemprestimoT = new Ple_parcelaemprestimoT();
            ple_parcelaemprestimoT.setPle_nr_id(rs.getInt("ple_nr_id"));
            ple_parcelaemprestimoT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            ple_parcelaemprestimoT.setPle_dt_vencimento(rs.getDate("ple_dt_vencimento"));
            ple_parcelaemprestimoT.setPle_dt_pagamento(rs.getDate("ple_dt_pagamento"));
            ple_parcelaemprestimoT.setPle_nr_valorparcela(rs.getFloat("ple_nr_valorparcela"));
            ple_parcelaemprestimoT.setPle_nr_valordesconto(rs.getFloat("ple_nr_valordesconto"));
            ple_parcelaemprestimoT.setPle_nr_cdformapagto(rs.getInt("ple_nr_cdformapagto"));
            ple_parcelaemprestimoT.setPle_tx_parcela(rs.getString("ple_tx_parcela"));
            ple_parcelaemprestimoT.setPle_tx_parcela(rs.getString("ple_tx_historico"));
            ple_parcelaemprestimoT.setPle_nr_id_vinculo(rs.getInt("ple_nr_id_vinculo"));
            objs.add(ple_parcelaemprestimoT);
        }
        return objs;
    }

    public DataSet getAllAtraso() throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo, replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo, ple_nr_seq_boleto");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where par.ple_dt_pagamento is null and par.ple_dt_vencimento <?");

            sql.append(" order by cli.cli_tx_nome, par.ple_tx_tipo, par.ple_dt_vencimento ");
            Object[] param = new Object[1];
            java.util.Date dt = new java.util.Date();
            java.sql.Date hoje = new java.sql.Date(dt.getTime());
            param[0] = hoje;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public List<Ple_parcelaemprestimoT> getByPK(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where  ple_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getPle_nr_id());
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

    public List<Ple_parcelaemprestimoT> getByPle_nr_id(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where  ple_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getPle_nr_id());
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

    public DataSet getByEmp_nr_id(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo, replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo, ple_nr_seq_boleto");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where par.emp_nr_id =? order by par.ple_tx_tipo, par.ple_dt_vencimento");
            Object[] param = new Object[1];
            param[0] = ple_parcelaemprestimoT.getEmp_nr_id();
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getByCli_nr_idAll(int cli_nr_id) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo, replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where emp.cli_nr_id =? order by par.ple_tx_tipo, par.ple_dt_vencimento");
            Object[] param = new Object[1];
            param[0] = cli_nr_id;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getByCli_nr_idPendente(int cli_nr_id, String tipo) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo, replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo, ple_nr_seq_boleto");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where emp.cli_nr_id =? and par.ple_tx_tipo =? and par.ple_dt_pagamento is null order by par.ple_tx_tipo, par.ple_dt_vencimento");
            Object[] param = new Object[2];
            param[0] = cli_nr_id;
            param[1] = tipo;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getByCli_nr_idVencidas(int cli_nr_id, String tipo) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo, replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo, ple_nr_seq_boleto");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where emp.cli_nr_id =? and par.ple_tx_tipo =? and par.ple_dt_vencimento <? and par.ple_dt_pagamento is null order by par.ple_tx_tipo, par.ple_dt_vencimento");
            Object[] param = new Object[3];
            param[0] = cli_nr_id;
            param[1] = tipo;
            java.util.Date hoje = new java.util.Date();
            java.sql.Date hj = new java.sql.Date(hoje.getTime());
            param[2] = hj;

            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getByCli_nr_idPendenteAll(int cli_nr_id, String tipo) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo, replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo, ple_nr_seq_boleto");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where emp.cli_nr_id =? and par.ple_dt_pagamento is null order by par.ple_tx_tipo, par.ple_dt_vencimento");
            Object[] param = new Object[1];
            param[0] = cli_nr_id;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getByCli_nr_id_orgao_PendenteAll(int cli_nr_id, String tipo, int org_nr_id) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo, replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo, ple_nr_seq_boleto");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where emp.cli_nr_id =? and emp.org_nr_id=? and par.ple_dt_pagamento is null order by par.ple_tx_tipo, par.ple_dt_vencimento");
            Object[] param = new Object[2];
            param[0] = cli_nr_id;
            param[1] = org_nr_id;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public DataSet getByCli_nr_idQuitado(int cli_nr_id) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select par.ple_nr_id, par.emp_nr_id, par.ple_dt_vencimento, par.ple_dt_pagamento, par.ple_nr_valorparcela, par.ple_nr_valordesconto, par.ple_nr_cdformapagto, par.ple_tx_parcela, cli.cli_tx_nome, par.ple_tx_tipo,replace(replace(par.ple_tx_historico,chr(10),''),chr(13),'') as ple_tx_historico, par.ple_nr_id_vinculo");
            sql.append(" from factory.ple_parcelaemprestimo as par");
            sql.append(" inner join factory.emp_emprestimo as emp on(emp.emp_nr_id = par.emp_nr_id) ");
            sql.append(" inner join factory.cli_cliente as cli on(cli.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where emp.cli_nr_id =? and par.ple_dt_pagamento is not null order by par.ple_tx_tipo, par.ple_dt_vencimento");
            Object[] param = new Object[1];
            param[0] = cli_nr_id;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public List<Ple_parcelaemprestimoT> getByPle_dt_vencimento(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where  ple_dt_vencimento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_vencimento().getTime());
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

    public List<Ple_parcelaemprestimoT> getByPle_dt_pagamento(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where  ple_dt_pagamento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(ple_parcelaemprestimoT.getPle_dt_pagamento().getTime());
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

    public List<Ple_parcelaemprestimoT> getByPle_nr_valorparcela(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where  ple_nr_valorparcela = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getPle_nr_valorparcela());
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

    public List<Ple_parcelaemprestimoT> getByPle_nr_valordesconto(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where  ple_nr_valordesconto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getPle_nr_valordesconto());
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

    public List<Ple_parcelaemprestimoT> getByPle_nr_cdformapagto(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where  ple_nr_cdformapagto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getPle_nr_cdformapagto());
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
     * Mï¿½todos FK
     */
    public List<Ple_parcelaemprestimoT> getByEmp_emprestimo(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where emp_emprestimo.emp_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ple_parcelaemprestimoT.getEmp_nr_id());
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

    public List<Ple_parcelaemprestimoT> getByEmp_emprestimo(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where emp_nr_id=?  and ple_dt_pagamento is not null";
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

    public List<Ple_parcelaemprestimoT> getByEmp_emprestimoAPagar(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where emp_nr_id=?  and ple_dt_pagamento is null";
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
}
