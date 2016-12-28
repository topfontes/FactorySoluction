package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Teb_transmissao_empresa_bancoDAO extends ObjectDAO {

    public Teb_transmissao_empresa_bancoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.teb_transmissao_empresa_banco  ( teb_nr_id, teb_dt_envio, teb_tx_operacao, teb_tx_status) values ( ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, teb_transmissao_empresa_bancoT.getTeb_nr_id());
            
            pStmt.setObject(2, new java.sql.Date(System.currentTimeMillis()));
            pStmt.setObject(3, teb_transmissao_empresa_bancoT.getTeb_tx_operacao());
            pStmt.setObject(4, "E");
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

    public void update(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.teb_transmissao_empresa_banco set  teb_dt_retorno=?, teb_tx_status=?, teb_tx_operacao=?  where  teb_nr_id=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(System.currentTimeMillis());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, teb_transmissao_empresa_bancoT.getTeb_tx_status());
            pStmt.setObject(3, "R");
            pStmt.setObject(4, teb_transmissao_empresa_bancoT.getTeb_nr_id());
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

    public void updateDataLancamento(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.teb_transmissao_empresa_banco set  teb_dt_envio=?  where  teb_nr_id=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt2 = new java.sql.Date(System.currentTimeMillis());
            pStmt.setObject(1, dt2);
            pStmt.setObject(2, teb_transmissao_empresa_bancoT.getTeb_nr_id());
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


    public void delete(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.teb_transmissao_empresa_banco where  teb_dt_envio=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(teb_transmissao_empresa_bancoT.getTeb_dt_envio().getTime());
            pStmt.setObject(1, dt1);
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

    private List<Teb_transmissao_empresa_bancoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Teb_transmissao_empresa_bancoT> objs = new Vector();
        while (rs.next()) {
            Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT = new Teb_transmissao_empresa_bancoT();
            teb_transmissao_empresa_bancoT.setTeb_nr_id(rs.getInt("teb_nr_id"));
            teb_transmissao_empresa_bancoT.setTeb_dt_envio(rs.getDate("teb_dt_envio"));
            teb_transmissao_empresa_bancoT.setTeb_dt_retorno(rs.getDate("teb_dt_retorno"));
            teb_transmissao_empresa_bancoT.setTeb_tx_status(rs.getString("teb_tx_status"));
            teb_transmissao_empresa_bancoT.setTeb_tx_operacao(rs.getString("teb_tx_operacao"));
            objs.add(teb_transmissao_empresa_bancoT);
        }
        return objs;
    }

    public List<Teb_transmissao_empresa_bancoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.teb_transmissao_empresa_banco order by teb_dt_envio, teb_nr_id, teb_dt_retorno";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Teb_transmissao_empresa_bancoT> list = resultSetToObjectTransfer(rs);
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

    public Teb_transmissao_empresa_bancoT getByPK(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.teb_transmissao_empresa_banco where  teb_nr_id=? order by teb_dt_envio desc limit 1";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(teb_transmissao_empresa_bancoT.getTeb_dt_envio().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            List<Teb_transmissao_empresa_bancoT> list = resultSetToObjectTransfer(rs);
            return list.size() > 0?list.get(0):null;
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
    

    public Teb_transmissao_empresa_bancoT getByTeb_nr_id(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.teb_transmissao_empresa_banco where  teb_nr_id = ? order by teb_dt_envio desc limit 1";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, teb_transmissao_empresa_bancoT.getTeb_nr_id());
            rs = pStmt.executeQuery();
            List<Teb_transmissao_empresa_bancoT> list = resultSetToObjectTransfer(rs);
            return list.size() > 0?list.get(0):null;
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

    public List<Teb_transmissao_empresa_bancoT> getByTeb_dt_envio(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.teb_transmissao_empresa_banco where  teb_dt_envio = ? order by teb_dt_envio, teb_nr_id";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(teb_transmissao_empresa_bancoT.getTeb_dt_envio().getTime());
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

    public List<Teb_transmissao_empresa_bancoT> getByTeb_dt_retorno(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.teb_transmissao_empresa_banco where  teb_dt_retorno = ? order by teb_dt_retorno";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(teb_transmissao_empresa_bancoT.getTeb_dt_retorno().getTime());
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

    public List<Teb_transmissao_empresa_bancoT> getByTeb_tx_status(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.teb_transmissao_empresa_banco where  Upper(teb_tx_status) like Upper(?) order by teb_dt_envio, teb_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + teb_transmissao_empresa_bancoT.getTeb_tx_status() + '%');
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

    public List<Teb_transmissao_empresa_bancoT> getByTeb_tx_operacao(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.teb_transmissao_empresa_banco where  Upper(teb_tx_operacao) = Upper(?) order by teb_dt_envio, teb_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, teb_transmissao_empresa_bancoT.getTeb_tx_operacao());
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
