package br.com.easynet.gwt.i9factory.dao;

import br.com.easynet.database.DataSet;
import java.util.*;
import java.sql.*;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Orcl_orgao_clienteDAO extends ObjectDAO {

    public Orcl_orgao_clienteDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.orcl_orgao_cliente  ( cli_nr_id, org_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orcl_orgao_clienteT.getCli_nr_id());
            pStmt.setObject(2, orcl_orgao_clienteT.getOrg_nr_id());
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

    public void update(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.orcl_orgao_cliente set  cli_nr_id=?, org_nr_id=?  where  orcl_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orcl_orgao_clienteT.getCli_nr_id());
            pStmt.setObject(2, orcl_orgao_clienteT.getOrg_nr_id());
            pStmt.setObject(3, orcl_orgao_clienteT.getOrcl_nr_id());
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

    public void delete(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.orcl_orgao_cliente where  orcl_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orcl_orgao_clienteT.getOrcl_nr_id());
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

    private List<Orcl_orgao_clienteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Orcl_orgao_clienteT> objs = new Vector();
        while (rs.next()) {
            Orcl_orgao_clienteT orcl_orgao_clienteT = new Orcl_orgao_clienteT();
            orcl_orgao_clienteT.setOrcl_nr_id(rs.getInt("orcl_nr_id"));
            orcl_orgao_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            orcl_orgao_clienteT.setOrg_nr_id(rs.getInt("org_nr_id"));
            objs.add(orcl_orgao_clienteT);
        }
        return objs;
    }

    public DataSet getAll(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        DataSet ds = null;
        try {
            String sql = "select orcl.orcl_nr_id, orcl.cli_nr_id, orcl.org_nr_id, org.org_tx_nomefantasia as orgao from factory.orcl_orgao_cliente orcl inner join factory.org_orgao org on(org.org_nr_id = orcl.org_nr_id) where cli_nr_id=?";
            Object[] param = new Object[1];
            param[0] = orcl_orgao_clienteT.getCli_nr_id();
            ds = executeQuery(sql, param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public List<Orcl_orgao_clienteT> getByPK(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.orcl_orgao_cliente where orcl_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orcl_orgao_clienteT.getOrcl_nr_id());
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

    public List<Orcl_orgao_clienteT> getByOrcl_nr_id(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.orcl_orgao_cliente where orcl_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orcl_orgao_clienteT.getOrcl_nr_id());
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

    public List<Orcl_orgao_clienteT> getByCli_nr_id(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.orcl_orgao_cliente where cli_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orcl_orgao_clienteT.getCli_nr_id());
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

    public List<Orcl_orgao_clienteT> getByOrg_nr_id(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.orcl_orgao_cliente where  org_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, orcl_orgao_clienteT.getOrg_nr_id());
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
