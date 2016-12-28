package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Lan_lancamentoDAO extends ObjectDAO {

    public Lan_lancamentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.lan_lancamento  ( ctr_nr_id, ctp_nr_id, lan_plc_nr_id_deb, lan_plc_nr_id_cred, lan_dt_lancamento, lan_tx_historico, lan_valor, lan_nr_id_super) values ( ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtr_nr_id());
            pStmt.setObject(2, lan_lancamentoT.getCtp_nr_id());
            pStmt.setObject(3, lan_lancamentoT.getLan_plc_nr_id_deb());
            pStmt.setObject(4, lan_lancamentoT.getLan_plc_nr_id_cred());
            java.sql.Date dt5 = new java.sql.Date(lan_lancamentoT.getLan_dt_lancamento().getTime());
            pStmt.setObject(5, dt5);
            pStmt.setObject(6, lan_lancamentoT.getLan_tx_historico());
            pStmt.setObject(7, lan_lancamentoT.getLan_valor());
            pStmt.setObject(8, lan_lancamentoT.getLan_nr_id_super());
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

    public void update(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.lan_lancamento set  ctr_nr_id=?, ctp_nr_id=?, lan_plc_nr_id_deb=?, lan_plc_nr_id_cred=?, lan_dt_lancamento=?, lan_tx_historico=?, lan_valor=?, lan_nr_id_super=?  where  lan_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtr_nr_id());
            pStmt.setObject(2, lan_lancamentoT.getCtp_nr_id());
            pStmt.setObject(3, lan_lancamentoT.getLan_plc_nr_id_deb());
            pStmt.setObject(4, lan_lancamentoT.getLan_plc_nr_id_cred());
            java.sql.Date dt5 = new java.sql.Date(lan_lancamentoT.getLan_dt_lancamento().getTime());
            pStmt.setObject(5, dt5);
            pStmt.setObject(6, lan_lancamentoT.getLan_tx_historico());
            pStmt.setObject(7, lan_lancamentoT.getLan_valor());
            pStmt.setObject(8, lan_lancamentoT.getLan_nr_id_super());
            pStmt.setObject(9, lan_lancamentoT.getLan_nr_id());
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

    public void delete(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.lan_lancamento where  lan_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id());
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

    private List<Lan_lancamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Lan_lancamentoT> objs = new Vector();
        while (rs.next()) {
            Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();
            lan_lancamentoT.setLan_nr_id(rs.getInt("lan_nr_id"));
            lan_lancamentoT.setCtr_nr_id(rs.getInt("ctr_nr_id"));
            lan_lancamentoT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            lan_lancamentoT.setLan_plc_nr_id_deb(rs.getInt("lan_plc_nr_id_deb"));
            lan_lancamentoT.setLan_plc_nr_id_cred(rs.getInt("lan_plc_nr_id_cred"));
            lan_lancamentoT.setLan_dt_lancamento(rs.getDate("lan_dt_lancamento"));
            lan_lancamentoT.setLan_tx_historico(rs.getString("lan_tx_historico"));
            lan_lancamentoT.setLan_valor(rs.getFloat("lan_valor"));
            lan_lancamentoT.setLan_nr_id_super(rs.getFloat("lan_nr_id_super"));
            objs.add(lan_lancamentoT);
        }
        return objs;
    }


    public List<Lan_lancamentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Lan_lancamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Lan_lancamentoT> getByPeriodo(java.util.Date dtInicio, java.util.Date dtFim) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where lan_dt_lancamento between ? and ? order by lan_dt_lancamento";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt = new java.sql.Date(dtInicio.getTime());
            pStmt.setDate(1, dt);
            dt = new java.sql.Date(dtFim.getTime());
            pStmt.setDate(2, dt);
            rs = pStmt.executeQuery();
            List<Lan_lancamentoT> list = resultSetToObjectTransfer(rs);
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


    public List<Lan_lancamentoT> getByPK(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  lan_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id());
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

    public List<Lan_lancamentoT> getByLan_nr_id(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  lan_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id());
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

    public List<Lan_lancamentoT> getByCtr_nr_id(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  ctr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtr_nr_id());
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

    public List<Lan_lancamentoT> getByCtp_nr_id(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  ctp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getCtp_nr_id());
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

    public List<Lan_lancamentoT> getByLan_plc_nr_id_deb(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  lan_plc_nr_id_deb = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_plc_nr_id_deb());
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

    public List<Lan_lancamentoT> getByLan_plc_nr_id_cred(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  lan_plc_nr_id_cred = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_plc_nr_id_cred());
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

    public List<Lan_lancamentoT> getByLan_dt_lancamento(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  lan_dt_lancamento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(lan_lancamentoT.getLan_dt_lancamento().getTime());
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

    public List<Lan_lancamentoT> getByLan_tx_historico(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  Upper(lan_tx_historico) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + lan_lancamentoT.getLan_tx_historico() + '%');
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

    public List<Lan_lancamentoT> getByLan_valor(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  lan_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_valor());
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

    public List<Lan_lancamentoT> getByLan_nr_id_super(Lan_lancamentoT lan_lancamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.lan_lancamento where  lan_nr_id_super = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, lan_lancamentoT.getLan_nr_id_super());
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
