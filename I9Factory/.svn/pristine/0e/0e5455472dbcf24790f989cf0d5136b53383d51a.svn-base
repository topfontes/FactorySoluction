package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Vw_arquivo_retorno_bancoDAO extends ObjectDAO {

    public Vw_arquivo_retorno_bancoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.vw_arquivo_retorno_banco  ( teb_nr_id, teb_dt_envio, teb_dt_retorno, teb_tx_status, teb_tx_operacao, ple_dt_vencimento, ple_tx_parcela, ple_nr_valorparcela, emp_nr_proposta, cli_tx_nome) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_arquivo_retorno_bancoT.getTeb_nr_id());
            java.sql.Date dt2 = new java.sql.Date(vw_arquivo_retorno_bancoT.getTeb_dt_envio().getTime());
            pStmt.setObject(2, dt2);
            java.sql.Date dt3 = new java.sql.Date(vw_arquivo_retorno_bancoT.getTeb_dt_retorno().getTime());
            pStmt.setObject(3, dt3);
            pStmt.setObject(4, vw_arquivo_retorno_bancoT.getTeb_tx_status());
            pStmt.setObject(5, vw_arquivo_retorno_bancoT.getTeb_tx_operacao());
            java.sql.Date dt6 = new java.sql.Date(vw_arquivo_retorno_bancoT.getPle_dt_vencimento().getTime());
            pStmt.setObject(6, dt6);
            pStmt.setObject(7, vw_arquivo_retorno_bancoT.getPle_tx_parcela());
            pStmt.setObject(8, vw_arquivo_retorno_bancoT.getPle_nr_valorparcela());
            pStmt.setObject(9, vw_arquivo_retorno_bancoT.getEmp_nr_proposta());
            pStmt.setObject(10, vw_arquivo_retorno_bancoT.getCli_tx_nome());
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

    public void update(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.vw_arquivo_retorno_banco set  teb_nr_id=?, teb_dt_envio=?, teb_dt_retorno=?, teb_tx_status=?, teb_tx_operacao=?, ple_dt_vencimento=?, ple_tx_parcela=?, ple_nr_valorparcela=?, emp_nr_proposta=?, cli_tx_nome=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_arquivo_retorno_bancoT.getTeb_nr_id());
            java.sql.Date dt2 = new java.sql.Date(vw_arquivo_retorno_bancoT.getTeb_dt_envio().getTime());
            pStmt.setObject(2, dt2);
            java.sql.Date dt3 = new java.sql.Date(vw_arquivo_retorno_bancoT.getTeb_dt_retorno().getTime());
            pStmt.setObject(3, dt3);
            pStmt.setObject(4, vw_arquivo_retorno_bancoT.getTeb_tx_status());
            pStmt.setObject(5, vw_arquivo_retorno_bancoT.getTeb_tx_operacao());
            java.sql.Date dt6 = new java.sql.Date(vw_arquivo_retorno_bancoT.getPle_dt_vencimento().getTime());
            pStmt.setObject(6, dt6);
            pStmt.setObject(7, vw_arquivo_retorno_bancoT.getPle_tx_parcela());
            pStmt.setObject(8, vw_arquivo_retorno_bancoT.getPle_nr_valorparcela());
            pStmt.setObject(9, vw_arquivo_retorno_bancoT.getEmp_nr_proposta());
            pStmt.setObject(10, vw_arquivo_retorno_bancoT.getCli_tx_nome());
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

    public void delete(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.vw_arquivo_retorno_banco where -";
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

    private List<Vw_arquivo_retorno_bancoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_arquivo_retorno_bancoT> objs = new Vector();
        while (rs.next()) {
            Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT = new Vw_arquivo_retorno_bancoT();
            vw_arquivo_retorno_bancoT.setTeb_nr_id(rs.getInt("teb_nr_id"));
            vw_arquivo_retorno_bancoT.setTeb_dt_envio(rs.getDate("teb_dt_envio"));
            vw_arquivo_retorno_bancoT.setTeb_dt_retorno(rs.getDate("teb_dt_retorno"));
            vw_arquivo_retorno_bancoT.setTeb_tx_status(rs.getString("teb_tx_status"));
            vw_arquivo_retorno_bancoT.setTeb_tx_operacao(rs.getString("teb_tx_operacao"));
            vw_arquivo_retorno_bancoT.setPle_dt_vencimento(rs.getDate("ple_dt_vencimento"));
            vw_arquivo_retorno_bancoT.setPle_tx_parcela(rs.getString("ple_tx_parcela"));
            vw_arquivo_retorno_bancoT.setPle_nr_valorparcela(rs.getFloat("ple_nr_valorparcela"));
            vw_arquivo_retorno_bancoT.setEmp_nr_proposta(rs.getInt("emp_nr_proposta"));
            vw_arquivo_retorno_bancoT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            objs.add(vw_arquivo_retorno_bancoT);
        }
        return objs;
    }

    public List<Vw_arquivo_retorno_bancoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Vw_arquivo_retorno_bancoT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_arquivo_retorno_bancoT> getByPK(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where -";
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

    public List<Vw_arquivo_retorno_bancoT> getByTeb_nr_id(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  teb_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_arquivo_retorno_bancoT.getTeb_nr_id());
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

    public List<Vw_arquivo_retorno_bancoT> getByTeb_dt_envio(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  teb_dt_envio = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_arquivo_retorno_bancoT.getTeb_dt_envio().getTime());
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

    public List<Vw_arquivo_retorno_bancoT> getByTeb_dt_retorno(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  teb_dt_retorno = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_arquivo_retorno_bancoT.getTeb_dt_retorno().getTime());
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

    public List<Vw_arquivo_retorno_bancoT> getByTeb_tx_status(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  Upper(teb_tx_status) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_arquivo_retorno_bancoT.getTeb_tx_status() + '%');
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

    public List<Vw_arquivo_retorno_bancoT> getByTeb_tx_operacao(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  Upper(teb_tx_operacao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_arquivo_retorno_bancoT.getTeb_tx_operacao() + '%');
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

    public List<Vw_arquivo_retorno_bancoT> getByPle_dt_vencimento(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  ple_dt_vencimento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_arquivo_retorno_bancoT.getPle_dt_vencimento().getTime());
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

    public List<Vw_arquivo_retorno_bancoT> getByPle_tx_parcela(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  Upper(ple_tx_parcela) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_arquivo_retorno_bancoT.getPle_tx_parcela() + '%');
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

    public List<Vw_arquivo_retorno_bancoT> getByPle_nr_valorparcela(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  ple_nr_valorparcela = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_arquivo_retorno_bancoT.getPle_nr_valorparcela());
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

    public List<Vw_arquivo_retorno_bancoT> getByEmp_nr_proposta(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  emp_nr_proposta = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_arquivo_retorno_bancoT.getEmp_nr_proposta());
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

    public List<Vw_arquivo_retorno_bancoT> getByCli_tx_nome(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_arquivo_retorno_banco where  Upper(cli_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_arquivo_retorno_bancoT.getCli_tx_nome() + '%');
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
