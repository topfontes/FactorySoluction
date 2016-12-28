package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Res_restricaoDAO extends ObjectDAO {

    public Res_restricaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Res_restricaoT res_restricaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.res_restricao  ( res_tx_nome, cli_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, res_restricaoT.getRes_tx_nome());
            pStmt.setObject(2, res_restricaoT.getCli_nr_id());
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

    public void update(Res_restricaoT res_restricaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.res_restricao set  res_tx_nome=?, cli_nr_id=?  where  res_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, res_restricaoT.getRes_tx_nome());
            pStmt.setObject(2, res_restricaoT.getCli_nr_id());
            pStmt.setObject(3, res_restricaoT.getRes_nr_id());
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

    public void delete(Res_restricaoT res_restricaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.res_restricao where  res_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, res_restricaoT.getRes_nr_id());
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

    private List<Res_restricaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Res_restricaoT> objs = new Vector();
        while (rs.next()) {
            Res_restricaoT res_restricaoT = new Res_restricaoT();
            res_restricaoT.setRes_nr_id(rs.getInt("res_nr_id"));
            res_restricaoT.setRes_tx_nome(rs.getString("res_tx_nome"));
            res_restricaoT.setCli_nr_id(rs.getInt("cli_nr_id"));
            objs.add(res_restricaoT);
        }
        return objs;
    }

    public DataSet getAll() throws Exception {
        DataSet ds = null;
        try {
            String sql = "select res.res_nr_id,res.res_tx_nome,res.cli_nr_id,cli.cli_tx_nome from factory.res_restricao as res inner join factory.cli_cliente as cli on(cli.cli_nr_id = res.cli_nr_id) order by cli.cli_tx_nome ";
            ds = executeQuery(sql.toString(), null);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();

        }
    }

    public List<Res_restricaoT> getByPK(Res_restricaoT res_restricaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.res_restricao where  res_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, res_restricaoT.getRes_nr_id());
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

    public List<Res_restricaoT> getByRes_nr_id(Res_restricaoT res_restricaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.res_restricao where  res_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, res_restricaoT.getRes_nr_id());
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

    public List<Res_restricaoT> getByRes_tx_nome(Res_restricaoT res_restricaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.res_restricao where  Upper(res_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + res_restricaoT.getRes_tx_nome() + '%');
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

    public DataSet getByCli_nr_id(Res_restricaoT res_restricaoT) throws Exception {
        DataSet ds = null;
        try {
            String sql = "select res.res_nr_id,res.res_tx_nome,res.cli_nr_id,cli.cli_tx_nome from factory.res_restricao as res inner join factory.cli_cliente as cli on(cli.cli_nr_id = res.cli_nr_id) where res.cli_nr_id=? order by cli.cli_tx_nome ";
            Object[] param = new Object[1];
            param[0] = res_restricaoT.getCli_nr_id();
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    /** Metodo FK */
    public List<Res_restricaoT> getByCli_cliente(Res_restricaoT res_restricaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.res_restricao where cli_cliente.cli_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, res_restricaoT.getCli_nr_id());
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
