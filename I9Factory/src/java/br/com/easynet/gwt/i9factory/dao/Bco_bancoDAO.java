package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Bco_bancoDAO extends ObjectDAO {

    public Bco_bancoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.bco_banco  ( bco_tx_nome, bco_tx_telefone1, bco_tx_telefone2, bco_tx_nomecontato, bco_tx_codigo) values ( ? , ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, bco_bancoT.getBco_tx_nome());
            pStmt.setObject(2, bco_bancoT.getBco_tx_telefone1());
            pStmt.setObject(3, bco_bancoT.getBco_tx_telefone2());
            pStmt.setObject(4, bco_bancoT.getBco_tx_nomecontato());
            pStmt.setObject(5, bco_bancoT.getBco_tx_codigo());
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

    public void update(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.bco_banco set  bco_tx_nome=?, bco_tx_telefone1=?, bco_tx_telefone2=?, bco_tx_nomecontato=?, bco_tx_codigo=?  where  bco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, bco_bancoT.getBco_tx_nome());
            pStmt.setObject(2, bco_bancoT.getBco_tx_telefone1());
            pStmt.setObject(3, bco_bancoT.getBco_tx_telefone2());
            pStmt.setObject(4, bco_bancoT.getBco_tx_nomecontato());
            pStmt.setObject(5, bco_bancoT.getBco_tx_codigo());
            pStmt.setObject(6, bco_bancoT.getBco_nr_id());
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

    public void delete(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.bco_banco where  bco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, bco_bancoT.getBco_nr_id());
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

    private List<Bco_bancoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Bco_bancoT> objs = new Vector();
        while (rs.next()) {
            Bco_bancoT bco_bancoT = new Bco_bancoT();
            bco_bancoT.setBco_nr_id(rs.getInt("bco_nr_id"));
            bco_bancoT.setBco_tx_nome(rs.getString("bco_tx_nome"));
            bco_bancoT.setBco_tx_telefone1(rs.getString("bco_tx_telefone1"));
            bco_bancoT.setBco_tx_telefone2(rs.getString("bco_tx_telefone2"));
            bco_bancoT.setBco_tx_nomecontato(rs.getString("bco_tx_nomecontato"));
            bco_bancoT.setBco_tx_codigo(rs.getString("bco_tx_codigo"));
            objs.add(bco_bancoT);
        }
        return objs;
    }


    public List<Bco_bancoT> getByRemessa(java.util.Date dtRemessa, int orgNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select distinct bco_nr_id, bco_tx_nome, bco_tx_codigo, '' as bco_tx_telefone1, '' as bco_tx_telefone2, '' as bco_tx_nomecontato from factory.vw_parcelas vw where vw.org_nr_id = ? and vw.ple_dt_pagamento is null and vw.ple_dt_vencimento<=? order by bco_tx_codigo";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orgNrId);
            java.sql.Date dt = new java.sql.Date(dtRemessa.getTime());
            pStmt.setObject(2, dt);
            rs = pStmt.executeQuery();
            List<Bco_bancoT> list = resultSetToObjectTransfer(rs);
            return list;
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
    public List<Bco_bancoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.bco_banco order by bco_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Bco_bancoT> list = resultSetToObjectTransfer(rs);
            return list;
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

    public List<Bco_bancoT> getByPK(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.bco_banco where  bco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, bco_bancoT.getBco_nr_id());
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

    public List<Bco_bancoT> getByBco_tx_codigo(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.bco_banco where  bco_tx_codigo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, bco_bancoT.getBco_tx_codigo());
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

    public List<Bco_bancoT> getByBco_tx_nome(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.bco_banco where  Upper(bco_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + bco_bancoT.getBco_tx_nome() + '%');
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

    public List<Bco_bancoT> getByBco_tx_telefone1(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.bco_banco where  Upper(bco_tx_telefone1) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + bco_bancoT.getBco_tx_telefone1() + '%');
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

    public List<Bco_bancoT> getByBco_tx_telefone2(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.bco_banco where  Upper(bco_tx_telefone2) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + bco_bancoT.getBco_tx_telefone2() + '%');
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

    public List<Bco_bancoT> getByBco_tx_nomecontato(Bco_bancoT bco_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.bco_banco where  Upper(bco_tx_nomecontato) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + bco_bancoT.getBco_tx_nomecontato() + '%');
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
