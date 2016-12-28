package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Arb_arquivobancoDAO extends ObjectDAO {

    public Arb_arquivobancoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.arb_arquivobanco  ( arb_dt_data, arb_by_arquivo, arb_tx_tipo, arb_nr_seq) values ( ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arb_arquivobancoT.getArb_dt_data());
            pStmt.setObject(2, arb_arquivobancoT.getArb_by_arquivo());
            pStmt.setObject(3, arb_arquivobancoT.getArb_tx_tipo());
            pStmt.setObject(4, arb_arquivobancoT.getArb_nr_seq());
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

    public void update(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.arb_arquivobanco set  arb_nr_id=?, arb_dt_data=?, arb_by_arquivo=?, arb_tx_tipo=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arb_arquivobancoT.getArb_nr_id());
            pStmt.setObject(2, arb_arquivobancoT.getArb_dt_data());
            pStmt.setObject(3, arb_arquivobancoT.getArb_by_arquivo());
            pStmt.setObject(4, arb_arquivobancoT.getArb_tx_tipo());
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

    public void delete(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.arb_arquivobanco where -";
            pStmt = con.prepareStatement(sql);
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

    private List<Arb_arquivobancoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Arb_arquivobancoT> objs = new Vector();
        while (rs.next()) {
            Arb_arquivobancoT arb_arquivobancoT = new Arb_arquivobancoT();
            arb_arquivobancoT.setArb_nr_id(rs.getInt("arb_nr_id"));
            arb_arquivobancoT.setArb_dt_data(rs.getTimestamp("arb_dt_data"));
            //arb_arquivobancoT.setArb_by_arquivo(rs.getBytes("arb_by_arquivo"));
            arb_arquivobancoT.setArb_tx_tipo(rs.getString("arb_tx_tipo"));
            arb_arquivobancoT.setArb_nr_seq(rs.getInt("arb_nr_seq"));
            objs.add(arb_arquivobancoT);
        }
        return objs;
    }

    private List<Arb_arquivobancoT> resultSetToObjectTransferArquivo(ResultSet rs) throws Exception {
        List<Arb_arquivobancoT> objs = new Vector();
        while (rs.next()) {
            Arb_arquivobancoT arb_arquivobancoT = new Arb_arquivobancoT();
            arb_arquivobancoT.setArb_nr_id(rs.getInt("arb_nr_id"));
            arb_arquivobancoT.setArb_by_arquivo(rs.getBytes("arb_by_arquivo"));
            objs.add(arb_arquivobancoT);
        }
        return objs;
    }

    public List<Arb_arquivobancoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arb_nr_id,arb_dt_data,arb_tx_tipo,arb_nr_seq from factory.arb_arquivobanco order by arb_dt_data desc, arb_tx_tipo ";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Arb_arquivobancoT> list = resultSetToObjectTransfer(rs);
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

    public List<Arb_arquivobancoT> getByPK(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arb_nr_id,arb_dt_data,arb_tx_tipo,arb_nr_seq from factory.arb_arquivobanco where -";
            pStmt = con.prepareStatement(sql);
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

    public List<Arb_arquivobancoT> getByArb_nr_id(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arb_nr_id,arb_dt_data,arb_tx_tipo,arb_nr_seq from factory.arb_arquivobanco where  arb_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arb_arquivobancoT.getArb_nr_id());
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

    public List<Arb_arquivobancoT> getByArb_dt_data(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arb_nr_id,arb_dt_data,arb_tx_tipo,arb_nr_seq from factory.arb_arquivobanco where  arb_dt_data = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arb_arquivobancoT.getArb_dt_data());
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

    public List<Arb_arquivobancoT> getByArb_by_arquivo(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.arb_arquivobanco where  arb_by_arquivo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arb_arquivobancoT.getArb_by_arquivo());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferArquivo(rs);
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

    public List<Arb_arquivobancoT> getByArb_tx_tipo(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arb_nr_id,arb_dt_data,arb_tx_tipo,arb_nr_seq from factory.arb_arquivobanco where  Upper(arb_tx_tipo) like Upper(?) order by arb_dt_data desc ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arb_arquivobancoT.getArb_tx_tipo());
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
