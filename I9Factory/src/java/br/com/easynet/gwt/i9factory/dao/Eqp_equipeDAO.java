package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Eqp_equipeDAO extends ObjectDAO {

    public Eqp_equipeDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.eqp_equipe  ( eqp_tx_nome, eqp_tx_descricao, cor_nr_id) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqp_equipeT.getEqp_tx_nome());
            pStmt.setObject(2, eqp_equipeT.getEqp_tx_descricao());
            pStmt.setObject(3, eqp_equipeT.getCor_nr_id());
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

    public void update(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.eqp_equipe set  eqp_tx_nome=?, eqp_tx_descricao=?, cor_nr_id=?  where  eqp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqp_equipeT.getEqp_tx_nome());
            pStmt.setObject(2, eqp_equipeT.getEqp_tx_descricao());
            pStmt.setObject(3, eqp_equipeT.getCor_nr_id());
            pStmt.setObject(4, eqp_equipeT.getEqp_nr_id());
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

    public void delete(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.eqp_equipe where  eqp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqp_equipeT.getEqp_nr_id());
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

    private List<Eqp_equipeT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Eqp_equipeT> objs = new Vector();
        while (rs.next()) {
            Eqp_equipeT eqp_equipeT = new Eqp_equipeT();
            eqp_equipeT.setEqp_nr_id(rs.getInt("eqp_nr_id"));
            eqp_equipeT.setEqp_tx_nome(rs.getString("eqp_tx_nome"));
            eqp_equipeT.setEqp_tx_descricao(rs.getString("eqp_tx_descricao"));
            eqp_equipeT.setCor_nr_id(rs.getInt("cor_nr_id"));
            objs.add(eqp_equipeT);
        }
        return objs;
    }

    public DataSet getAll() throws Exception {
        DataSet ds = null;
        try {
            String sql = "select eqp.eqp_nr_id,eqp.eqp_tx_nome,eqp.eqp_tx_descricao,eqp.cor_nr_id,cor.cor_tx_nomefantasia as cor_tx_nome from factory.eqp_equipe eqp inner join factory.cor_corretora cor on(cor.cor_nr_id = eqp.cor_nr_id)";
            ds = executeQuery(sql, null);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }
        
    }

    public List<Eqp_equipeT> getByPK(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.eqp_equipe where  eqp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqp_equipeT.getEqp_nr_id());
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

    public List<Eqp_equipeT> getByEqp_nr_id(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.eqp_equipe where  eqp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqp_equipeT.getEqp_nr_id());
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

    public List<Eqp_equipeT> getByEqp_tx_nome(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.eqp_equipe where  Upper(eqp_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + eqp_equipeT.getEqp_tx_nome() + '%');
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

    public List<Eqp_equipeT> getByEqp_tx_descricao(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.eqp_equipe where  Upper(eqp_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + eqp_equipeT.getEqp_tx_descricao() + '%');
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

    public List<Eqp_equipeT> getByCor_nr_id(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.eqp_equipe where  cor_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqp_equipeT.getCor_nr_id());
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

    /** Metodo FK */
    public List<Eqp_equipeT> getByCor_corretora(Eqp_equipeT eqp_equipeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.eqp_equipe where cor_corretora.cor_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqp_equipeT.getCor_nr_id());
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
