package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Ref_referenciaDAO extends ObjectDAO {

    public Ref_referenciaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.ref_referencia  ( cli_nr_id, ref_tx_nome, ref_tx_telefone, ref_tx_celular) values ( ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ref_referenciaT.getCli_nr_id());
            pStmt.setObject(2, ref_referenciaT.getRef_tx_nome());
            pStmt.setObject(3, ref_referenciaT.getRef_tx_telefone());
            pStmt.setObject(4, ref_referenciaT.getRef_tx_celular());
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

    public void update(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.ref_referencia set  cli_nr_id=?, ref_tx_nome=?, ref_tx_telefone=?, ref_tx_celular=?  where  ref_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ref_referenciaT.getCli_nr_id());
            pStmt.setObject(2, ref_referenciaT.getRef_tx_nome());
            pStmt.setObject(3, ref_referenciaT.getRef_tx_telefone());
            pStmt.setObject(4, ref_referenciaT.getRef_tx_celular());
            pStmt.setObject(5, ref_referenciaT.getRef_nr_id());
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

    public void delete(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.ref_referencia where  ref_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ref_referenciaT.getRef_nr_id());
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

    private List<Ref_referenciaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ref_referenciaT> objs = new Vector();
        while (rs.next()) {
            Ref_referenciaT ref_referenciaT = new Ref_referenciaT();
            ref_referenciaT.setRef_nr_id(rs.getInt("ref_nr_id"));
            ref_referenciaT.setCli_nr_id(rs.getInt("cli_nr_id"));
            ref_referenciaT.setRef_tx_nome(rs.getString("ref_tx_nome"));
            ref_referenciaT.setRef_tx_telefone(rs.getString("ref_tx_telefone"));
            ref_referenciaT.setRef_tx_celular(rs.getString("ref_tx_celular"));
            objs.add(ref_referenciaT);
        }
        return objs;
    }

    public List<Ref_referenciaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ref_referenciaT> list = resultSetToObjectTransfer(rs);
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

    public List<Ref_referenciaT> getByPK(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia where  ref_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ref_referenciaT.getRef_nr_id());
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

    public List<Ref_referenciaT> getByRef_nr_id(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia where  ref_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ref_referenciaT.getRef_nr_id());
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

    public List<Ref_referenciaT> getByCli_nr_id(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia where  cli_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ref_referenciaT.getCli_nr_id());
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

    public List<Ref_referenciaT> getByRef_tx_nome(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia where  Upper(ref_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ref_referenciaT.getRef_tx_nome() + '%');
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

    public List<Ref_referenciaT> getByRef_tx_telefone(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia where  Upper(ref_tx_telefone) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ref_referenciaT.getRef_tx_telefone() + '%');
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

    public List<Ref_referenciaT> getByRef_tx_celular(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia where  Upper(ref_tx_celular) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ref_referenciaT.getRef_tx_celular() + '%');
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

    public List<Ref_referenciaT> getByCli_cliente(Ref_referenciaT ref_referenciaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ref_referencia where cli_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ref_referenciaT.getCli_nr_id());
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
