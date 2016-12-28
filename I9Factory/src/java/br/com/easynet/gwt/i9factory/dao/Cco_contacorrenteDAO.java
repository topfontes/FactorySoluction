package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

public class Cco_contacorrenteDAO extends ObjectDAO {

    public Cco_contacorrenteDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.cco_contacorrente ( cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, cco_bt_arqremessabanco, cco_bt_arqretornobanco, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_tx_nragencia());
            pStmt.setObject(2, cco_contacorrenteT.getCco_tx_nrcontacorrente());
            pStmt.setObject(3, cco_contacorrenteT.getCco_tx_nomecorrentista());
            pStmt.setObject(4, cco_contacorrenteT.getCco_bt_arqremessabanco());
            pStmt.setObject(5, cco_contacorrenteT.getCco_bt_arqretornobanco());
            pStmt.setObject(6, cco_contacorrenteT.getBco_nr_id());
            pStmt.setObject(7, cco_contacorrenteT.getCli_nr_id());
            pStmt.setObject(8, cco_contacorrenteT.getOrg_nr_id());
            pStmt.setObject(9, cco_contacorrenteT.getCor_nr_id());
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

    public void updateStatusCadBanco(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.cco_contacorrente set  cco_tx_cadbanco=?where  cco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_tx_cadbanco());
            pStmt.setObject(2, cco_contacorrenteT.getCco_nr_id());
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

    public void update(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.cco_contacorrente set  cco_tx_nragencia=?, cco_tx_nrcontacorrente=?, cco_tx_nomecorrentista=?, cco_bt_arqremessabanco=?, cco_bt_arqretornobanco=?, bco_nr_id=?, cli_nr_id=?, org_nr_id=?, cor_nr_id=?  where  cco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_tx_nragencia());
            pStmt.setObject(2, cco_contacorrenteT.getCco_tx_nrcontacorrente());
            pStmt.setObject(3, cco_contacorrenteT.getCco_tx_nomecorrentista());
            pStmt.setObject(4, cco_contacorrenteT.getCco_bt_arqremessabanco());
            pStmt.setObject(5, cco_contacorrenteT.getCco_bt_arqretornobanco());
            pStmt.setObject(6, cco_contacorrenteT.getBco_nr_id());
            pStmt.setObject(7, cco_contacorrenteT.getCli_nr_id());
            pStmt.setObject(8, cco_contacorrenteT.getOrg_nr_id());
            pStmt.setObject(9, cco_contacorrenteT.getCor_nr_id());
            pStmt.setObject(10, cco_contacorrenteT.getCco_nr_id());
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

    public void delete(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.cco_contacorrente where  cco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_nr_id());
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

    public void deleteAllClinete(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.cco_contacorrente where  cli_nr_id = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    private List<Cco_contacorrenteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cco_contacorrenteT> objs = new Vector();
        while (rs.next()) {
            Cco_contacorrenteT cco_contacorrenteT = new Cco_contacorrenteT();
            cco_contacorrenteT.setCco_nr_id(rs.getInt("cco_nr_id"));
            cco_contacorrenteT.setCco_tx_nragencia(rs.getString("cco_tx_nragencia"));
            cco_contacorrenteT.setCco_tx_nrcontacorrente(rs.getString("cco_tx_nrcontacorrente"));
            cco_contacorrenteT.setCco_tx_nomecorrentista(rs.getString("cco_tx_nomecorrentista"));
            cco_contacorrenteT.setBco_nr_id(rs.getInt("bco_nr_id"));
            cco_contacorrenteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cco_contacorrenteT.setOrg_nr_id(rs.getInt("org_nr_id"));
            cco_contacorrenteT.setCor_nr_id(rs.getInt("cor_nr_id"));
            cco_contacorrenteT.setCco_tx_cadbanco(rs.getString("cco_tx_cadbanco"));
            objs.add(cco_contacorrenteT);
        }
        return objs;
    }

    public List<Cco_contacorrenteT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cco_contacorrenteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cco_contacorrenteT> getByRemessaBanco(String idsParcelas) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {

            String[] listIds = idsParcelas.split(",");
            StringBuffer sqlWhere = new StringBuffer(" vw.ple_nr_id=0 ");
            for (int i = 1; i < listIds.length; i++) {
                String id = listIds[i];
                sqlWhere.append(" or vw.ple_nr_id=").append(id);
            }            

            StringBuffer sql = new StringBuffer("select distinct cco.* from factory.cco_contacorrente cco, factory.vw_parcelas vw where vw.ple_dt_pagamento is null and (");
            sql.append(sqlWhere).append(") and cco.cli_nr_id = vw.cli_nr_id and cco.bco_nr_id=vw.bco_nr_id ");

//            StringBuffer sql = new StringBuffer("select distinct cco.* from factory.cco_contacorrente cco, factory.vw_parcelas vw where vw.ple_dt_pagamento is null and vw.ple_nr_id in (");
//            sql.append(idsParcelas).append(") and cco.cli_nr_id = vw.cli_nr_id and cco.bco_nr_id=vw.bco_nr_id ");
            System.out.println("conta corrente  -- parametros parcelas = "+idsParcelas);
            pStmt = con.prepareStatement(sql.toString());
            rs = pStmt.executeQuery();
            List<Cco_contacorrenteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cco_contacorrenteT> getByRemessaBanco(Cco_contacorrenteT ccoT, java.util.Date dtRemessa) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select distinct cco.* from factory.cco_contacorrente cco, factory.vw_parcelas vw where vw.org_nr_id = ? and vw.ple_dt_pagamento is null  and vw.ple_dt_vencimento <= ? and cco.cli_nr_id = vw.cli_nr_id and cco.bco_nr_id=vw.bco_nr_id ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccoT.getOrg_nr_id());
            java.sql.Date dt = new java.sql.Date(dtRemessa.getTime());
            pStmt.setObject(2, dt);
            rs = pStmt.executeQuery();
            List<Cco_contacorrenteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cco_contacorrenteT> getByPK(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  cco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_nr_id());
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

    public List<Cco_contacorrenteT> getByCco_nr_id(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  cco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_nr_id());
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

    public List<Cco_contacorrenteT> getByCco_tx_nragencia(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  Upper(cco_tx_nragencia) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cco_contacorrenteT.getCco_tx_nragencia() + '%');
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

    public List<Cco_contacorrenteT> getByCco_tx_nrcontacorrente(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  Upper(cco_tx_nrcontacorrente) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cco_contacorrenteT.getCco_tx_nrcontacorrente() + '%');
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

    public List<Cco_contacorrenteT> getByCco_tx_nomecorrentista(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  Upper(cco_tx_nomecorrentista) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cco_contacorrenteT.getCco_tx_nomecorrentista() + '%');
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

    public List<Cco_contacorrenteT> getByCco_bt_arqremessabanco(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  cco_bt_arqremessabanco = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_bt_arqremessabanco());
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

    public List<Cco_contacorrenteT> getByCco_bt_arqretornobanco(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  cco_bt_arqretornobanco = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCco_bt_arqretornobanco());
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

    public List<Cco_contacorrenteT> getByBco_nr_id(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  bco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getBco_nr_id());
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

    public List<Cco_contacorrenteT> getByBancoClienteNovo(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  bco_nr_id = ? and cli_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getBco_nr_id());
            pStmt.setObject(2, cco_contacorrenteT.getCli_nr_id());
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

    public List<Cco_contacorrenteT> getByNovasContas(Bco_bancoT bcoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id, cco_tx_cadbanco from factory.cco_contacorrente where  bco_nr_id = ? and cco_tx_cadbanco='N' order by cli_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, bcoT.getBco_nr_id());
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

    public DataSet getByCli_nr_id(String id_clientes) throws Exception {
        DataSet ds;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select conta.cco_nr_id, conta.cco_tx_nragencia, conta.cco_tx_nrcontacorrente, conta.cco_tx_nomecorrentista, conta.bco_nr_id, conta.cli_nr_id, conta.org_nr_id, conta.cor_nr_id, banco.bco_tx_nome, orgao.org_tx_nomefantasia as org_tx_nome, orgao.org_nr_id");
            sql.append(" from factory.cco_contacorrente as conta inner join factory.bco_banco as banco on(banco.bco_nr_id = conta.bco_nr_id)");
            sql.append(" inner join factory.orcl_orgao_cliente as orgcli on(orgcli.org_nr_id = conta.org_nr_id and conta.cli_nr_id = orgcli.cli_nr_id) ");
            sql.append(" inner join factory.org_orgao as orgao on(orgao.org_nr_id = orgcli.org_nr_id)");
            sql.append(" where  conta.cli_nr_id in " + id_clientes);
            ds = executeQuery(sql.toString(), null);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }

    }

    public DataSet getByCli_nr_id_Orgao(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        DataSet ds;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select conta.cco_nr_id, conta.cco_tx_nragencia, conta.cco_tx_nrcontacorrente, conta.cco_tx_nomecorrentista, conta.bco_nr_id, conta.cli_nr_id, conta.org_nr_id, conta.cor_nr_id, banco.bco_tx_nome");
            sql.append(" from factory.cco_contacorrente as conta inner join factory.bco_banco as banco on(banco.bco_nr_id = conta.bco_nr_id)");
            sql.append(" where  conta.cli_nr_id =? and conta.org_nr_id =? ");
            Object[] param = new Object[2];
            param[0] = cco_contacorrenteT.getCli_nr_id();
            param[1] = cco_contacorrenteT.getOrg_nr_id();
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    public List<Cco_contacorrenteT> getByCor_nr_id(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id,cco_tx_cadbanco from factory.cco_contacorrente where  org_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getOrg_nr_id());
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
    public List<Cco_contacorrenteT> getByBco_banco(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id,cco_tx_cadbanco from factory.cco_contacorrente where bco_banco.bco_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getBco_nr_id());
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
    public List<Cco_contacorrenteT> getByCli_cliente(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id,cco_tx_cadbanco from factory.cco_contacorrente where cli_cliente.cli_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCli_nr_id());
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
    public List<Cco_contacorrenteT> getByCor_corretora(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id,cco_tx_cadbanco from factory.cco_contacorrente where cor_corretora.cor_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getCor_nr_id());
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
    public List<Cco_contacorrenteT> getByOrg_nr_id(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select cco_nr_id, cco_tx_nragencia, cco_tx_nrcontacorrente, cco_tx_nomecorrentista, bco_nr_id, cli_nr_id, org_nr_id, cor_nr_id,cco_tx_cadbanco from factory.cco_contacorrente where age_agenciador.org_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cco_contacorrenteT.getOrg_nr_id());
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
