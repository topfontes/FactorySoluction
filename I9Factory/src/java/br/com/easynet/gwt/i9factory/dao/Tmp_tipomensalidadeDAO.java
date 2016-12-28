package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Tmp_tipomensalidadeDAO extends ObjectDAO {

    public Tmp_tipomensalidadeDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.tmp_tipomensalidade  ( tmp_tx_nome, tmp_tx_descricao, tmp_nr_valor) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tmp_tipomensalidadeT.getTmp_tx_nome());
            pStmt.setObject(2, tmp_tipomensalidadeT.getTmp_tx_descricao());
            pStmt.setObject(3, tmp_tipomensalidadeT.getTmp_nr_valor());
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

    public void update(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.tmp_tipomensalidade set  tmp_tx_nome=?, tmp_tx_descricao=?, tmp_nr_valor=?  where  tmp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tmp_tipomensalidadeT.getTmp_tx_nome());
            pStmt.setObject(2, tmp_tipomensalidadeT.getTmp_tx_descricao());
            pStmt.setObject(3, tmp_tipomensalidadeT.getTmp_nr_valor());
            pStmt.setObject(4, tmp_tipomensalidadeT.getTmp_nr_id());
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

    public void delete(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.tmp_tipomensalidade where  tmp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tmp_tipomensalidadeT.getTmp_nr_id());
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

    private List<Tmp_tipomensalidadeT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Tmp_tipomensalidadeT> objs = new Vector();
        while (rs.next()) {
            Tmp_tipomensalidadeT tmp_tipomensalidadeT = new Tmp_tipomensalidadeT();
            tmp_tipomensalidadeT.setTmp_nr_id(rs.getInt("tmp_nr_id"));
            tmp_tipomensalidadeT.setTmp_tx_nome(rs.getString("tmp_tx_nome"));
            tmp_tipomensalidadeT.setTmp_tx_descricao(rs.getString("tmp_tx_descricao"));
            tmp_tipomensalidadeT.setTmp_nr_valor(rs.getFloat("tmp_nr_valor"));
            objs.add(tmp_tipomensalidadeT);
        }
        return objs;
    }

    public List<Tmp_tipomensalidadeT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tmp_tipomensalidade";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Tmp_tipomensalidadeT> list = resultSetToObjectTransfer(rs);
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

    public List<Tmp_tipomensalidadeT> getByPK(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tmp_tipomensalidade where  tmp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tmp_tipomensalidadeT.getTmp_nr_id());
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

    public List<Tmp_tipomensalidadeT> getByTmp_nr_id(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tmp_tipomensalidade where  tmp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tmp_tipomensalidadeT.getTmp_nr_id());
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

    public List<Tmp_tipomensalidadeT> getByTmp_tx_nome(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tmp_tipomensalidade where  Upper(tmp_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + tmp_tipomensalidadeT.getTmp_tx_nome() + '%');
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

    public List<Tmp_tipomensalidadeT> getByTmp_tx_descricao(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tmp_tipomensalidade where  Upper(tmp_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + tmp_tipomensalidadeT.getTmp_tx_descricao() + '%');
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

    public List<Tmp_tipomensalidadeT> getByTmp_nr_valor(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tmp_tipomensalidade where  tmp_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tmp_tipomensalidadeT.getTmp_nr_valor());
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
