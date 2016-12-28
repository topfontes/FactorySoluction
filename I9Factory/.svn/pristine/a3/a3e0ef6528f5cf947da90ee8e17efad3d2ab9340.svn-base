package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Ctp_conta_pagarDAO extends ObjectDAO {

    public Ctp_conta_pagarDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.ctp_conta_pagar  ( ctp_nr_doc, ctp_dt_emissao, ctp_dt_vencimento, ctp_tx_pago, ctp_tx_parcela, ctp_valor, ctp_dt_pagamento, ctp_vl_pago, ctp_saldo, for_nr_id, ctp_tx_obs,tid_nr_id) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_doc());
            java.sql.Date dt2 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
            pStmt.setObject(2, dt2);
            java.sql.Date dt3 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
            pStmt.setObject(3, dt3);
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_tx_pago());
            pStmt.setObject(5, ctp_conta_pagarT.getCtp_tx_parcela());
            pStmt.setObject(6, ctp_conta_pagarT.getCtp_valor());
            if (ctp_conta_pagarT.getCtp_dt_pagamento() != null) {
                java.sql.Date dt10 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_pagamento().getTime());
                pStmt.setObject(7, dt10);
            } else {
                pStmt.setObject(7, null);
            }
            pStmt.setObject(8, ctp_conta_pagarT.getCtp_vl_pago());
            pStmt.setObject(9, ctp_conta_pagarT.getCtp_saldo());
            pStmt.setObject(10, ctp_conta_pagarT.getFor_nr_id());
            pStmt.setObject(11, ctp_conta_pagarT.getCtp_tx_obs());
            pStmt.setObject(12, ctp_conta_pagarT.getTid_nr_id());
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

    public void update(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.ctp_conta_pagar set  ctp_nr_doc=?, ctp_dt_emissao=?, ctp_dt_vencimento=?, ctp_tx_pago=?, ctp_tx_parcela=?, ctp_valor=?, ctp_dt_pagamento=?, ctp_vl_pago=?, ctp_saldo=?, for_nr_id=?, ctp_tx_obs=?, tid_nr_id=?  where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_doc());
            java.sql.Date dt2 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
            pStmt.setObject(2, dt2);
            java.sql.Date dt3 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
            pStmt.setObject(3, dt3);
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_tx_pago());
            pStmt.setObject(5, ctp_conta_pagarT.getCtp_tx_parcela());
            pStmt.setObject(6, ctp_conta_pagarT.getCtp_valor());
            if (ctp_conta_pagarT.getCtp_dt_pagamento() != null) {
                java.sql.Date dt10 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_pagamento().getTime());
                pStmt.setObject(7, dt10);
            } else {
                pStmt.setObject(7, null);
            }
            pStmt.setObject(8, ctp_conta_pagarT.getCtp_vl_pago());
            pStmt.setObject(9, ctp_conta_pagarT.getCtp_saldo());
            pStmt.setObject(10, ctp_conta_pagarT.getFor_nr_id());
            pStmt.setObject(11, ctp_conta_pagarT.getCtp_tx_obs());
            pStmt.setObject(12, ctp_conta_pagarT.getTid_nr_id());
            pStmt.setObject(13, ctp_conta_pagarT.getCtp_nr_id());
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

    public void delete(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.ctp_conta_pagar where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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

    private List<Ctp_conta_pagarT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ctp_conta_pagarT> objs = new Vector();
        while (rs.next()) {
            Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
            ctp_conta_pagarT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            ctp_conta_pagarT.setCtp_nr_doc(rs.getInt("ctp_nr_doc"));
            ctp_conta_pagarT.setCtp_dt_emissao(rs.getDate("ctp_dt_emissao"));
            ctp_conta_pagarT.setCtp_dt_vencimento(rs.getDate("ctp_dt_vencimento"));
            ctp_conta_pagarT.setCtp_tx_pago(rs.getString("ctp_tx_pago"));
            ctp_conta_pagarT.setCtp_tx_parcela(rs.getString("ctp_tx_parcela"));
            ctp_conta_pagarT.setCtp_valor(rs.getFloat("ctp_valor"));
            ctp_conta_pagarT.setCtp_dt_pagamento(rs.getDate("ctp_dt_pagamento"));
            ctp_conta_pagarT.setCtp_vl_pago(rs.getFloat("ctp_vl_pago"));
            ctp_conta_pagarT.setCtp_saldo(rs.getFloat("ctp_saldo"));
            ctp_conta_pagarT.setFor_nr_id(rs.getInt("for_nr_id"));
            ctp_conta_pagarT.setCtp_tx_obs(rs.getString("ctp_tx_obs"));
            ctp_conta_pagarT.setTid_nr_id(rs.getInt("tid_nr_id"));
            objs.add(ctp_conta_pagarT);
        }
        return objs;
    }

    //
    public DataSet getAll(String status, java.util.Date inicio, java.util.Date fim, int fornecedor, int tipo, String grupo) throws Exception {
        DataSet ds = null;
        try {
            ArrayList list = new ArrayList();
            list.add(status);
            java.sql.Date dtini = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfim = new java.sql.Date(fim.getTime());

            list.add(dtini);
            list.add(dtfim);

            StringBuffer sql = new StringBuffer();
            sql.append("select ctp.ctp_nr_id , ctp.ctp_nr_doc, ctp.ctp_dt_emissao, ctp.ctp_dt_vencimento, ctp.ctp_tx_pago, ctp.ctp_tx_parcela, ctp.ctp_valor , ctp.ctp_dt_pagamento, ctp.ctp_vl_pago, ctp.ctp_saldo, ctp.for_nr_id, ctp.ctp_tx_obs");
            sql.append(" ,forn.for_tx_nome, tid.tid_tx_nome, ctp.tid_nr_id");
            sql.append(" from factory.ctp_conta_pagar ctp");
            sql.append(" inner join factory.for_fornecedor forn on(ctp.for_nr_id = forn.for_nr_id)");
            sql.append(" inner join factory.tid_tipo_despesa tid on(ctp.tid_nr_id = tid.tid_nr_id)");
            sql.append(" where ctp.ctp_tx_pago =?");
            if (status.equalsIgnoreCase("F")) {
                sql.append(" and ctp.ctp_dt_vencimento between ? and ?");
            } else {
                sql.append(" and ctp.ctp_dt_pagamento between ? and ?");
            }

            if (fornecedor > 0) {
                sql.append(" and ctp.for_nr_id =?");
                list.add(fornecedor);
            } else {
                if (tipo > 0) {
                    sql.append(" and ctp.tid_nr_id =?");
                    list.add(tipo);
                }
            }

            if (grupo.equalsIgnoreCase("G")) {
                sql.append(status.equalsIgnoreCase("F") ? " order by ctp.ctp_dt_vencimento" : " order by ctp.ctp_dt_pagamento");
            } else {
                if (fornecedor > 0) {
                    sql.append(" order by forn.for_tx_nome, ctp_dt_vencimento");
                } else {
                    sql.append(" order by tid.tid_tx_nome, ctp_dt_vencimento");
                }
            }

            ds = executeQuery(sql.toString(), list.toArray());
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
            } catch (Exception e) {
            }

        }
    }

    public DataSet getAll(String status,  int fornecedor, int tipo, String grupo) throws Exception {
        DataSet ds = null;
        try {
            ArrayList list = new ArrayList();
            list.add(status);

            StringBuffer sql = new StringBuffer();
            sql.append("select ctp.ctp_nr_id , ctp.ctp_nr_doc, ctp.ctp_dt_emissao, ctp.ctp_dt_vencimento, ctp.ctp_tx_pago, ctp.ctp_tx_parcela, ctp.ctp_valor , ctp.ctp_dt_pagamento, ctp.ctp_vl_pago, ctp.ctp_saldo, ctp.for_nr_id, ctp.ctp_tx_obs");
            sql.append(" ,forn.for_tx_nome, tid.tid_tx_nome, ctp.tid_nr_id");
            sql.append(" from factory.ctp_conta_pagar ctp");
            sql.append(" inner join factory.for_fornecedor forn on(ctp.for_nr_id = forn.for_nr_id)");
            sql.append(" inner join factory.tid_tipo_despesa tid on(ctp.tid_nr_id = tid.tid_nr_id)");
            sql.append(" where ctp.ctp_tx_pago =?");
//            if (status.equalsIgnoreCase("F")) {
//                sql.append(" and ctp.ctp_dt_vencimento between ? and ?");
//            } else {
//                sql.append(" and ctp.ctp_dt_pagamento between ? and ?");
//            }

            if (fornecedor > 0) {
                sql.append(" and ctp.for_nr_id =?");
                list.add(fornecedor);
            } else {
                if (tipo > 0) {
                    sql.append(" and ctp.tid_nr_id =?");
                    list.add(tipo);
                }
            }

            if (grupo.equalsIgnoreCase("G")) {
                sql.append(status.equalsIgnoreCase("F") ? " order by ctp.ctp_dt_vencimento" : " order by ctp.ctp_dt_pagamento");
            } else {
                if (fornecedor > 0) {
                    sql.append(" order by forn.for_tx_nome, ctp_dt_vencimento");
                } else {
                    sql.append(" order by tid.tid_tx_nome, ctp_dt_vencimento");
                }
            }

            ds = executeQuery(sql.toString(), list.toArray());
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
            } catch (Exception e) {
            }

        }
    }

    public List<Ctp_conta_pagarT> getByPK(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_nr_doc(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_nr_doc = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_doc());
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

    public List<Ctp_conta_pagarT> getByCtp_dt_emissao(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_dt_emissao = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
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

    public List<Ctp_conta_pagarT> getByCtp_dt_vencimento(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_dt_vencimento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
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

    public List<Ctp_conta_pagarT> getByCtp_tx_pago(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  Upper(ctp_tx_pago) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_pago() + '%');
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

    public List<Ctp_conta_pagarT> getByCtp_tx_parcela(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  Upper(ctp_tx_parcela) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_parcela() + '%');
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

    public List<Ctp_conta_pagarT> getByCtp_valor(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_valor());
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

    public List<Ctp_conta_pagarT> getByCtp_dt_pagamento(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_dt_pagamento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_pagamento().getTime());
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

    public List<Ctp_conta_pagarT> getByCtp_vl_pago(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_vl_pago = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_vl_pago());
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

    public List<Ctp_conta_pagarT> getByCtp_saldo(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  ctp_saldo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_saldo());
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

    public List<Ctp_conta_pagarT> getByFor_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  for_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getFor_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_tx_obs(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where  Upper(ctp_tx_obs) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_obs() + '%');
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
    public List<Ctp_conta_pagarT> getByFor_fornecedor(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ctp_conta_pagar where for_fornecedor.for_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getFor_nr_id());
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
