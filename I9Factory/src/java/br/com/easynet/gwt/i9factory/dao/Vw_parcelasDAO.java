package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import java.text.SimpleDateFormat;

public class Vw_parcelasDAO extends ObjectDAO {

    public Vw_parcelasDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.vw_parcelas  ( ple_nr_id, emp_nr_id, ple_dt_vencimento, ple_dt_pagamento, ple_nr_valorparcela, ple_nr_valordesconto, ple_nr_cdformapagto, ple_tx_parcela, ple_tx_tipo, emp_dt_emprestimo, emp_nr_proposta, emp_nr_valor, emp_nr_valor_afin_liquido, cli_nr_id, org_nr_id, cli_tx_cpf, cli_tx_nome, cco_tx_nragencia, cco_tx_nrcontacorrente, bco_nr_id, bco_tx_nome, bco_tx_codigo) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getPle_nr_id());
            pStmt.setObject(2, vw_parcelasT.getEmp_nr_id());
            java.sql.Date dt3 = new java.sql.Date(vw_parcelasT.getPle_dt_vencimento().getTime());
            pStmt.setObject(3, dt3);
            java.sql.Date dt4 = new java.sql.Date(vw_parcelasT.getPle_dt_pagamento().getTime());
            pStmt.setObject(4, dt4);
            pStmt.setObject(5, vw_parcelasT.getPle_nr_valorparcela());
            pStmt.setObject(6, vw_parcelasT.getPle_nr_valordesconto());
            pStmt.setObject(7, vw_parcelasT.getPle_nr_cdformapagto());
            pStmt.setObject(8, vw_parcelasT.getPle_tx_parcela());
            pStmt.setObject(9, vw_parcelasT.getPle_tx_tipo());
            java.sql.Date dt10 = new java.sql.Date(vw_parcelasT.getEmp_dt_emprestimo().getTime());
            pStmt.setObject(10, dt10);
            pStmt.setObject(11, vw_parcelasT.getEmp_nr_proposta());
            pStmt.setObject(12, vw_parcelasT.getEmp_nr_valor());
            pStmt.setObject(13, vw_parcelasT.getEmp_nr_valor_afin_liquido());
            pStmt.setObject(14, vw_parcelasT.getCli_nr_id());
            pStmt.setObject(15, vw_parcelasT.getOrg_nr_id());
            pStmt.setObject(16, vw_parcelasT.getCli_tx_cpf());
            pStmt.setObject(17, vw_parcelasT.getCli_tx_nome());
            pStmt.setObject(18, vw_parcelasT.getCco_tx_nragencia());
            pStmt.setObject(19, vw_parcelasT.getCco_tx_nrcontacorrente());
            pStmt.setObject(20, vw_parcelasT.getBco_nr_id());
            pStmt.setObject(21, vw_parcelasT.getBco_tx_nome());
            pStmt.setObject(22, vw_parcelasT.getBco_tx_codigo());
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

    public void update(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.vw_parcelas set  ple_nr_id=?, emp_nr_id=?, ple_dt_vencimento=?, ple_dt_pagamento=?, ple_nr_valorparcela=?, ple_nr_valordesconto=?, ple_nr_cdformapagto=?, ple_tx_parcela=?, ple_tx_tipo=?, emp_dt_emprestimo=?, emp_nr_proposta=?, emp_nr_valor=?, emp_nr_valor_afin_liquido=?, cli_nr_id=?, org_nr_id=?, cli_tx_cpf=?, cli_tx_nome=?, cco_tx_nragencia=?, cco_tx_nrcontacorrente=?, bco_nr_id=?, bco_tx_nome=?, bco_tx_codigo=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getPle_nr_id());
            pStmt.setObject(2, vw_parcelasT.getEmp_nr_id());
            java.sql.Date dt3 = new java.sql.Date(vw_parcelasT.getPle_dt_vencimento().getTime());
            pStmt.setObject(3, dt3);
            java.sql.Date dt4 = new java.sql.Date(vw_parcelasT.getPle_dt_pagamento().getTime());
            pStmt.setObject(4, dt4);
            pStmt.setObject(5, vw_parcelasT.getPle_nr_valorparcela());
            pStmt.setObject(6, vw_parcelasT.getPle_nr_valordesconto());
            pStmt.setObject(7, vw_parcelasT.getPle_nr_cdformapagto());
            pStmt.setObject(8, vw_parcelasT.getPle_tx_parcela());
            pStmt.setObject(9, vw_parcelasT.getPle_tx_tipo());
            java.sql.Date dt10 = new java.sql.Date(vw_parcelasT.getEmp_dt_emprestimo().getTime());
            pStmt.setObject(10, dt10);
            pStmt.setObject(11, vw_parcelasT.getEmp_nr_proposta());
            pStmt.setObject(12, vw_parcelasT.getEmp_nr_valor());
            pStmt.setObject(13, vw_parcelasT.getEmp_nr_valor_afin_liquido());
            pStmt.setObject(14, vw_parcelasT.getCli_nr_id());
            pStmt.setObject(15, vw_parcelasT.getOrg_nr_id());
            pStmt.setObject(16, vw_parcelasT.getCli_tx_cpf());
            pStmt.setObject(17, vw_parcelasT.getCli_tx_nome());
            pStmt.setObject(18, vw_parcelasT.getCco_tx_nragencia());
            pStmt.setObject(19, vw_parcelasT.getCco_tx_nrcontacorrente());
            pStmt.setObject(20, vw_parcelasT.getBco_nr_id());
            pStmt.setObject(21, vw_parcelasT.getBco_tx_nome());
            pStmt.setObject(22, vw_parcelasT.getBco_tx_codigo());
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

    public void delete(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.vw_parcelas where -";
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

    private List<Vw_parcelasT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_parcelasT> objs = new Vector();
        while (rs.next()) {
            Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
            vw_parcelasT.setPle_nr_id(rs.getInt("ple_nr_id"));
            vw_parcelasT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            vw_parcelasT.setPle_dt_vencimento(rs.getDate("ple_dt_vencimento"));
            vw_parcelasT.setPle_dt_pagamento(rs.getDate("ple_dt_pagamento"));
            vw_parcelasT.setPle_nr_valorparcela(rs.getFloat("ple_nr_valorparcela"));
            vw_parcelasT.setPle_nr_valordesconto(rs.getFloat("ple_nr_valordesconto"));
            vw_parcelasT.setPle_nr_cdformapagto(rs.getInt("ple_nr_cdformapagto"));
            vw_parcelasT.setPle_tx_parcela(rs.getString("ple_tx_parcela"));
            vw_parcelasT.setPle_tx_tipo(rs.getString("ple_tx_tipo"));
            vw_parcelasT.setEmp_dt_emprestimo(rs.getDate("emp_dt_emprestimo"));
            vw_parcelasT.setEmp_nr_proposta(rs.getInt("emp_nr_proposta"));
            vw_parcelasT.setEmp_nr_valor(rs.getFloat("emp_nr_valor"));
            vw_parcelasT.setEmp_nr_valor_afin_liquido(rs.getFloat("emp_nr_valor_afin_liquido"));
            vw_parcelasT.setCli_nr_id(rs.getInt("cli_nr_id"));
            vw_parcelasT.setOrg_nr_id(rs.getInt("org_nr_id"));
            vw_parcelasT.setCli_tx_cpf(rs.getString("cli_tx_cpf"));
            vw_parcelasT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            vw_parcelasT.setCco_tx_nragencia(rs.getString("cco_tx_nragencia"));
            vw_parcelasT.setCco_tx_nrcontacorrente(rs.getString("cco_tx_nrcontacorrente"));
            vw_parcelasT.setBco_nr_id(rs.getInt("bco_nr_id"));
            vw_parcelasT.setBco_tx_nome(rs.getString("bco_tx_nome"));
            vw_parcelasT.setBco_tx_codigo(rs.getString("bco_tx_codigo"));
            vw_parcelasT.setOrg_tx_nome(rs.getString("org_tx_nome"));
            vw_parcelasT.setCor_tx_nome(rs.getString("cor_tx_nome"));
            vw_parcelasT.setCli_dt_nascimento(rs.getDate("cli_dt_nascimento"));
            vw_parcelasT.setCco_tx_cadbanco(rs.getString("cco_tx_cadbanco"));
            vw_parcelasT.setPle_tx_historico(getObs(rs.getString("ple_tx_historico")));
            vw_parcelasT.setCli_tx_matricula(rs.getString("cli_tx_matricula"));
            vw_parcelasT.setPle_nr_id_vinculo(rs.getInt("ple_nr_id_vinculo"));
            vw_parcelasT.setCli_tx_telefone1(getObs(rs.getString("cli_tx_telefone1")));
            vw_parcelasT.setCli_tx_telefone2(getObs(rs.getString("cli_tx_telefone2")));

            vw_parcelasT.setCli_tx_estadocivil(getObs(rs.getString("cli_tx_estadocivil")));
            vw_parcelasT.setCli_tx_rg(getObs(rs.getString("cli_tx_rg")));
            vw_parcelasT.setCli_tx_logradouro(getObs(rs.getString("cli_tx_logradouro")));
            vw_parcelasT.setCli_tx_bairro(getObs(rs.getString("cli_tx_bairro")));
            vw_parcelasT.setCli_tx_numero(getObs(rs.getString("cli_tx_numero")));
            vw_parcelasT.setCli_tx_municipio(getObs(rs.getString("cli_tx_municipio")));
            vw_parcelasT.setCli_tx_uf(getObs(rs.getString("cli_tx_uf")));
            vw_parcelasT.setCli_tx_celular(getObs(rs.getString("cli_tx_celular")));

            objs.add(vw_parcelasT);
        }
        return objs;
    }

    private List<Vw_parcelasT> resultSetToObjectTransferReport(ResultSet rs) throws Exception {
        List<Vw_parcelasT> objs = new Vector();
        while (rs.next()) {
//            ple_dt_vencimento, cli_dt_nascimento, cli_tx_cpf,cli_tx_nome,
//            ple_nr_valorparcela,emp_nr_proposta, emp_nr_valor_pago
//                    ,ple_nr_valordesconto,ple_dt_pagamento
            Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
            vw_parcelasT.setPle_dt_vencimento(rs.getDate("ple_dt_vencimento"));
            vw_parcelasT.setPle_dt_pagamento(rs.getDate("ple_dt_pagamento"));
            vw_parcelasT.setPle_nr_valorparcela(rs.getFloat("ple_nr_valorparcela"));
            vw_parcelasT.setPle_nr_valordesconto(rs.getFloat("ple_nr_valordesconto"));
            //vw_parcelasT.setPle_tx_parcela(rs.getString("ple_tx_parcela"));
            //vw_parcelasT.setPle_tx_tipo(rs.getString("ple_tx_tipo"));
            vw_parcelasT.setEmp_nr_proposta(rs.getInt("emp_nr_proposta"));
            vw_parcelasT.setCli_tx_cpf(rs.getString("cli_tx_cpf"));
            vw_parcelasT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            vw_parcelasT.setCli_dt_nascimento(rs.getDate("cli_dt_nascimento"));
            objs.add(vw_parcelasT);
        }
        return objs;
    }

    public String getObs(String observ) {
        if (observ != null && observ.length() > 0) {
            String obs = observ.replaceAll("\n", " ").replaceAll("\r", " ");
            return obs;
        } else {
            return "";
        }
    }

    public List<Vw_parcelasT> getByRemessa(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas vw where vw.org_nr_id = ? and vw.ple_dt_pagamento is null and vw.ple_dt_vencimento<= ? order by ple_dt_vencimento";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getOrg_nr_id());
            java.sql.Date dt = new java.sql.Date(vw_parcelasT.getPle_dt_vencimento().getTime());
            pStmt.setObject(2, dt);
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

    public List<Vw_parcelasT> getByRemessaBanco(Vw_parcelasT vw_parcelasT, String ids_orgaos) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {

            //String sql = "select * from factory.vw_parcelas vw where vw.org_nr_id = ?  and vw.bco_nr_id=? and vw.ple_dt_pagamento is null and vw.ple_dt_vencimento<= ? and ple_tx_tipo=? order by ple_dt_vencimento";
            StringBuffer sql = new StringBuffer("select * from factory.vw_parcelas vw where vw.bco_nr_id=? and vw.ple_dt_pagamento is null and vw.ple_dt_vencimento<= ? and ple_bl_suspenso = false ");
            sql.append(" and vw.org_nr_id in(");
            sql.append(ids_orgaos);
            sql.append(") ");
            if (!"T".equals(vw_parcelasT.getPle_tx_tipo())) {
                sql.append(" and ple_tx_tipo=? ");
            }

            if (vw_parcelasT.getPle_tx_tipo().equalsIgnoreCase("M")) {
                sql.append(" and cli_tx_socio = 'S' ");
            }
            
            //só server quando o orgao for INSS
            if (vw_parcelasT.getCli_tx_salario_minimo().equalsIgnoreCase("S")) {
                sql.append(" and cli_tx_salario_minimo = 'S' ");
            }

            sql.append(" order by ple_dt_vencimento ");
            //String sql = "select * from factory.vw_parcelas vw where vw.bco_nr_id=? and vw.ple_dt_pagamento is null and vw.ple_dt_vencimento<= ? and ple_tx_tipo=? order by ple_dt_vencimento";
            pStmt = con.prepareStatement(sql.toString());
            //pStmt.setObject(1, vw_parcelasT.getOrg_nr_id());
            pStmt.setObject(1, vw_parcelasT.getBco_nr_id());
            java.sql.Date dt = new java.sql.Date(vw_parcelasT.getPle_dt_vencimento().getTime());
            pStmt.setObject(2, dt);
            if (!"T".equals(vw_parcelasT.getPle_tx_tipo())) {
                pStmt.setObject(3, vw_parcelasT.getPle_tx_tipo());
            }
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

    public List<Vw_parcelasT> getByRemessaIdsParcelas(String idsParcelas) throws Exception {
        System.out.println("parametros parcelas = " + idsParcelas);
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            /*

             */
            //String ids = "0,631,1359,1575,3090,3666,3612,3523,14793,9797,18695,5951,9637,11567,12467,6167,15043,5039,15635,11981,11657,3415,3775,12089,3739,16899,11315,11153,12161,16265,10441,3469,11225,13343,16449,633,11441,14063,5073,14671,5341,5395,3039,11621,11855,1577,3793,3307,16809,11477,3253,3289,10387,1630,11423,12017,11243,8170,12269,16503,3379,18113,13361,14279,1361,10249,5359,5005,4739,15293,17417,2985,16193,7632,16229,6401,4387,14689,11333,10283,12629,17683,12395,12396,17684,17685,12397,12398,17686,12399,17687,12400,17688,1003,2087,10513,1997,7226,2518,2339,14847,13883,10129,3937,8402,12341,8010,16611,10514,16773,8046,7992,13523,3703,1700,10903,7441,5863,6203,1023,15941,12987,10029,10867,11279,13059,16953,11513,16319,10975,4477,2687,9424,6831,15347,8100,11011,4915,1980,8206,4881,8778,6473,9030,4845,14385,2895,11297,7227,10885,10957,1998,14369,8957,7722,10993,10849,4933,1005,10831,8814,14723,4863,17647,8508,11549,10777,4809,4951,2621,16791,12179,1505,11029,12359,13955,6705,1770,8330,11065,4827,11047,2088,7920,971,8922,8760,10921,15079,4611,17007,10795,10813,7315,14009,11099,1126,10741,16863,18677,10077,14527,16845,1108,12681,2827,1910,2447,5057,8472,17077,9601,5827,9851,1144,15311,3811,5719,17025,16575,1450,12611,9012,2034,9619,13973,1039,15599,4493,7029,13469,4297,12377,7560,15025,1789,14707,15581,8652,18095,15995,13739,345,13129,14351,309,12897,2465,17915,7242,7243,10565";
            StringBuffer sql = new StringBuffer();
            sql.append("select * from factory.vw_parcelas vw where vw.ple_dt_pagamento is null and ( ");
            String[] listIds = idsParcelas.split(",");
            StringBuffer sqlWhere = new StringBuffer(" vw.ple_nr_id=0 ");
            for (int i = 1; i < listIds.length; i++) {
                String id = listIds[i];
                sqlWhere.append(" or vw.ple_nr_id=").append(id);
            }
            sqlWhere.append(")");
//            StringBuffer sql = new StringBuffer("select * from factory.vw_parcelas vw where vw.ple_dt_pagamento is null and vw.ple_nr_id in (");
//            sql.append(idsParcelas).append(") order by ple_dt_vencimento");
            pStmt = con.prepareStatement(sql.append(sqlWhere).toString());
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

    public List<Vw_parcelasT> getAll(Vw_parcelasT vw_parcelasT, java.util.Date inicio, java.util.Date fim, String status) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.sql.Date dtInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfiim = new java.sql.Date(fim.getTime());
            String orderBy = " order by ple_dt_vencimento ";
            StringBuffer sql = new StringBuffer();
            if (status.equalsIgnoreCase("A")) {
                sql.append("select * from factory.vw_parcelas where ple_dt_vencimento between ? and ? and ple_dt_pagamento is null");
            } else if (status.equalsIgnoreCase("P")) {
                sql.append(" select * from factory.vw_parcelas where ple_dt_pagamento between ? and ?");
                orderBy = " order by ple_dt_pagamento";
            } else {
                sql.append("select * from factory.vw_parcelas where ple_dt_vencimento between ? and ? and ple_dt_pagamento is null and ple_bl_suspenso = true");
            }
            if (vw_parcelasT.getCli_nr_id() > 0) {
                sql.append(" and cli_nr_id=?");
            }
            sql.append(orderBy);

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, dtInicio);
            pStmt.setObject(2, dtfiim);
            if (vw_parcelasT.getCli_nr_id() > 0) {
                pStmt.setObject(3, vw_parcelasT.getCli_nr_id());
            }

            rs = pStmt.executeQuery();
            List<Vw_parcelasT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_parcelasT> getAllWithCorretor(java.util.Date inicio, java.util.Date fim, String status, int cli_nr_id, int corretor, String ple_tx_tipo, int orgao) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.sql.Date dtInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfiim = new java.sql.Date(fim.getTime());
            String sql = "";
            String strCli = "";
            String strCorretor = "";
            if (cli_nr_id > 0) {
                strCli = " and cli_nr_id= " + cli_nr_id;
            }
            if (corretor > 0) {
                strCli = " and cor_nr_id= " + corretor;
            }
            String orgaoStr = "";
            if (orgao > 0) {
                orgaoStr = " and org_nr_id = " + orgao;
            }

            if (status.equalsIgnoreCase("A")) {
                sql = "select * from factory.vw_parcelas where " + ple_tx_tipo + " ple_dt_vencimento >= ? and ple_dt_vencimento <? and ple_dt_pagamento is null " + strCli + strCorretor + orgaoStr + " order by cli_tx_nome, ple_dt_vencimento";
            } else {
                sql = "select * from factory.vw_parcelas where " + ple_tx_tipo + " ple_dt_pagamento between ? and ? " + strCli + strCorretor + orgaoStr + " order by org_tx_nome, cli_tx_nome, ple_dt_pagamento";
            }
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dtInicio);
            pStmt.setObject(2, dtfiim);
            rs = pStmt.executeQuery();
            List<Vw_parcelasT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_parcelasT> getAll(java.util.Date inicio, java.util.Date fim, String status, int cli_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.sql.Date dtInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfiim = new java.sql.Date(fim.getTime());
            String sql = "";
            String strCli = "";
            if (cli_nr_id > 0) {
                strCli = " and cli_nr_id= " + cli_nr_id;
            }
            if (status.equalsIgnoreCase("A")) {
                sql = "select * from factory.vw_parcelas where ple_dt_vencimento >= ? and ple_dt_vencimento <? and ple_dt_pagamento is null " + strCli + " order by org_tx_nome, ple_dt_vencimento";
            } else {
                sql = "select * from factory.vw_parcelas where ple_dt_pagamento between ? and ? " + strCli + " order by org_tx_nome, cli_tx_nome, ple_dt_pagamento";
            }
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dtInicio);
            pStmt.setObject(2, dtfiim);
            rs = pStmt.executeQuery();
            List<Vw_parcelasT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_parcelasT> getAllReport(java.util.Date inicio, java.util.Date fim, String status, int cli_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.sql.Date dtInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfiim = new java.sql.Date(fim.getTime());
            String sql = "";
            String strCli = "";
            if (cli_nr_id > 0) {
                strCli = " and cli_nr_id= " + cli_nr_id;
            }
            if (status.equalsIgnoreCase("A")) {
                sql = "select  ple_dt_vencimento, cli_dt_nascimento, cli_tx_cpf,cli_tx_nome,ple_nr_valorparcela,emp_nr_proposta,ple_nr_valordesconto,ple_dt_pagamento from factory.vw_parcelas where ple_dt_vencimento >= ? and ple_dt_vencimento <? and ple_dt_pagamento is null " + strCli + " order by cli_nr_id, ple_dt_vencimento";
            } else {
                sql = "select  ple_dt_vencimento, cli_dt_nascimento, cli_tx_cpf,cli_tx_nome,ple_nr_valorparcela,emp_nr_proposta,ple_nr_valordesconto,ple_dt_pagamento from factory.vw_parcelas where ple_dt_pagamento between ? and ? " + strCli + " order by cli_nr_id, ple_dt_pagamento";
            }
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dtInicio);
            pStmt.setObject(2, dtfiim);
            rs = pStmt.executeQuery();
            List<Vw_parcelasT> list = resultSetToObjectTransferReport(rs);
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

    public List<Vw_parcelasT> getAll(java.util.Date inicio, java.util.Date fim, String status, String tipo, int cli_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            boolean terceiroParametro = false;
            java.sql.Date dtInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfiim = new java.sql.Date(fim.getTime());
            String sql = "";

            String strCli = "";
            if (cli_nr_id > 0) {
                strCli = " and cli_nr_id= " + cli_nr_id;
            }

            if (status.equalsIgnoreCase("A")) {
                sql = "select * from factory.vw_parcelas where ple_dt_vencimento between ? and ? and ple_dt_pagamento is null and ple_tx_tipo =?" + strCli + " order by org_tx_nome, ple_dt_vencimento";
            } else {
                sql = "select * from factory.vw_parcelas where ple_dt_pagamento between ? and ?  and ple_tx_tipo =? " + strCli + " order by org_tx_nome, cli_tx_nome, ple_dt_pagamento";
//                terceiroParametro = true;
            }

            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dtInicio);
            pStmt.setObject(2, dtfiim);
//            if(tipo.equalsIgnoreCase("M")||tipo.equalsIgnoreCase("P")){
            pStmt.setObject(3, tipo);
//            }
            rs = pStmt.executeQuery();
            List<Vw_parcelasT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_parcelasT> getAllReport(java.util.Date inicio, java.util.Date fim, String status, String tipo, int cli_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            boolean terceiroParametro = false;
            java.sql.Date dtInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfiim = new java.sql.Date(fim.getTime());
            String sql = "";

            String strCli = "";
            if (cli_nr_id > 0) {
                strCli = " and cli_nr_id= " + cli_nr_id;
            }

            if (status.equalsIgnoreCase("A")) {
                sql = "select ple_dt_vencimento, cli_dt_nascimento, cli_tx_cpf,cli_tx_nome,ple_nr_valorparcela,emp_nr_proposta ,ple_nr_valordesconto,ple_dt_pagamento from factory.vw_parcelas where ple_dt_vencimento between ? and ? and ple_dt_pagamento is null and ple_tx_tipo =?" + strCli + " order by org_tx_nome, cli_nr_id ,ple_dt_vencimento";
            } else {
                sql = "select ple_dt_vencimento, cli_dt_nascimento, cli_tx_cpf,cli_tx_nome,ple_nr_valorparcela,emp_nr_proposta,ple_nr_valordesconto,ple_dt_pagamento from factory.vw_parcelas where ple_dt_pagamento between ? and ?  and ple_tx_tipo =? " + strCli + " order by org_tx_nome, cli_nr_id, ple_dt_pagamento";
//                terceiroParametro = true;
            }

            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dtInicio);
            pStmt.setObject(2, dtfiim);
//            if(tipo.equalsIgnoreCase("M")||tipo.equalsIgnoreCase("P")){
            pStmt.setObject(3, tipo);
//            }
            rs = pStmt.executeQuery();
            List<Vw_parcelasT> list = resultSetToObjectTransferReport(rs);
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

    public List<Vw_parcelasT> getByValorMen(int cli) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where cli_nr_id =? and ple_tx_tipo='M' order by ple_nr_id desc limit 1";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli);
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

    public List<Vw_parcelasT> getByPK(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas ";
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

    public List<Vw_parcelasT> getByPle_nr_id(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  ple_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getPle_nr_id());
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

    public List<Vw_parcelasT> getByEmp_nr_idAll(Emp_emprestimoT emp_emprestimoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_nr_id = ?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_emprestimoT.getEmp_nr_id());
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

    public List<Vw_parcelasT> getByEmp_nr_idAll(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_nr_id = ?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getEmp_nr_id());
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

    public List<Vw_parcelasT> getByEmp_nr_idTipo(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_nr_id = ? and ple_tx_tipo=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getEmp_nr_id());
            pStmt.setObject(2, vw_parcelasT.getPle_tx_tipo());
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

    public List<Vw_parcelasT> getByExtrato(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_nr_id = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getEmp_nr_id());
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

    public List<Vw_parcelasT> getByPle_dt_vencimento(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  ple_dt_vencimento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_parcelasT.getPle_dt_vencimento().getTime());
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

    public List<Vw_parcelasT> getByPle_dt_pagamento(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  ple_dt_pagamento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_parcelasT.getPle_dt_pagamento().getTime());
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

    public List<Vw_parcelasT> getByPle_nr_valorparcela(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  ple_nr_valorparcela = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getPle_nr_valorparcela());
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

    public List<Vw_parcelasT> getByPle_nr_valordesconto(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  ple_nr_valordesconto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getPle_nr_valordesconto());
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

    public List<Vw_parcelasT> getByPle_nr_cdformapagto(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  ple_nr_cdformapagto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getPle_nr_cdformapagto());
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

    public List<Vw_parcelasT> getByPle_tx_parcela(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.util.Date d_i = new java.util.Date();
            SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
            SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
            int mes = Integer.parseInt(sdfMes.format(d_i));
            int ano = Integer.parseInt(sdfAno.format(d_i));
            int anoPosterior = ano + 1;
            String sql = "select * from factory.vw_parcelas where ple_tx_parcela='12/12' and extract(month from ple_dt_vencimento) = ? and extract(year from ple_dt_vencimento) = ? and ple_tx_tipo='M' and cli_nr_id not in(select cli_nr_id from factory.vw_parcelas where extract(year from ple_dt_vencimento) =? and ple_tx_tipo='M')  order by cli_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, mes);
            pStmt.setObject(2, ano);
            pStmt.setObject(3, anoPosterior);
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

    public List<Vw_parcelasT> getBydecimaSegunda(int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.util.Date d_i = new java.util.Date();
            SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
            SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
            int anoPosterior = ano + 1;
            String sql = "select * from factory.vw_parcelas where Upper(ple_tx_parcela) like Upper(?) and extract(month from ple_dt_vencimento) = ? and extract(year from ple_dt_vencimento) = ? and ple_tx_tipo=? and cli_nr_id not in(select cli_nr_id from factory.vw_parcelas where extract(year from ple_dt_vencimento) =? and ple_tx_tipo='M')  order by cli_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, "12/12");
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, "M");
            pStmt.setObject(5, anoPosterior);
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

    public List<Vw_parcelasT> existeParcela(int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.util.Date d_i = new java.util.Date();
            SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
            SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
            String sql = "select cli_nr_id from factory.vw_parcelas where Upper(ple_tx_parcela) like Upper(?) and extract(month from ple_dt_vencimento) = ? and extract(year from ple_dt_vencimento) = ? and ple_tx_tipo=?  order by cli_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, "12/12");
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, "M");
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

    public List<Vw_parcelasT> getByPle_tx_tipo(Vw_parcelasT vw_parcelasT, java.util.Date inicio, java.util.Date fim, String status) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            java.sql.Date dtInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date dtfiim = new java.sql.Date(fim.getTime());
            String orderBy = " order by ple_dt_vencimento ";
            StringBuffer sql = new StringBuffer();
            if (status.equalsIgnoreCase("A")) {
                sql.append("select * from factory.vw_parcelas where ple_dt_vencimento between ? and ? and ple_tx_tipo=? and ple_dt_pagamento is null");
            } else if (status.equalsIgnoreCase("P")) {
                sql.append("select * from factory.vw_parcelas where ple_dt_pagamento between ? and ? and ple_tx_tipo=?");
                orderBy = " order by ple_dt_pagamento";
            } else {
                sql.append("select * from factory.vw_parcelas where ple_dt_vencimento between ? and ? and ple_tx_tipo=? and ple_dt_pagamento is null and ple_bl_suspenso = true");
            }
            if (vw_parcelasT.getCli_nr_id() > 0) {
                sql.append(" and cli_nr_id=?");
            }
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

            sql.append(orderBy);
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, dtInicio);
            pStmt.setObject(2, dtfiim);
            pStmt.setObject(3, vw_parcelasT.getPle_tx_tipo());
            if (vw_parcelasT.getCli_nr_id() > 0) {
                pStmt.setObject(4, vw_parcelasT.getCli_nr_id());
            }

            System.out.println(sql.toString() + " - " + format.format(fim) + " = " + format.format(fim) + " , tipo =" + vw_parcelasT.getPle_tx_tipo() + ", " + vw_parcelasT.getCli_nr_id());

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

    public List<Vw_parcelasT> getByEmp_dt_emprestimo(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_dt_emprestimo = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(vw_parcelasT.getEmp_dt_emprestimo().getTime());
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

    public List<Vw_parcelasT> getByEmp_nr_proposta(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_nr_proposta = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getEmp_nr_proposta());
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

    public List<Vw_parcelasT> getByEmp_nr_valor(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getEmp_nr_valor());
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

    public List<Vw_parcelasT> getByEmp_nr_valor_afin_liquido(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  emp_nr_valor_afin_liquido = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getEmp_nr_valor_afin_liquido());
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

    public List<Vw_parcelasT> getByCli_nr_id(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  cli_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getCli_nr_id());
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

    public List<Vw_parcelasT> getByOrg_nr_id(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  org_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getOrg_nr_id());
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

    public List<Vw_parcelasT> getByCli_tx_cpf(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  Upper(cli_tx_cpf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_parcelasT.getCli_tx_cpf() + '%');
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

    public List<Vw_parcelasT> getByCli_tx_nome(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  Upper(cli_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_parcelasT.getCli_tx_nome() + '%');
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

    public List<Vw_parcelasT> getByCco_tx_nragencia(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  Upper(cco_tx_nragencia) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_parcelasT.getCco_tx_nragencia() + '%');
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

    public List<Vw_parcelasT> getByCco_tx_nrcontacorrente(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  Upper(cco_tx_nrcontacorrente) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_parcelasT.getCco_tx_nrcontacorrente() + '%');
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

    public List<Vw_parcelasT> getByBco_nr_id(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  bco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_parcelasT.getBco_nr_id());
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

    public List<Vw_parcelasT> getByBco_tx_nome(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  Upper(bco_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_parcelasT.getBco_tx_nome() + '%');
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

    public List<Vw_parcelasT> getByBco_tx_codigo(Vw_parcelasT vw_parcelasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.vw_parcelas where  Upper(bco_tx_codigo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_parcelasT.getBco_tx_codigo() + '%');
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

    public List<Vw_parcelasT> existeMensalidadesFuturas(int cli_nr_id, int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.ple_parcelaemprestimo where cli_nr_id=? and extract(year from ple_dt_vencimento) = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_nr_id);
            pStmt.setObject(3, ano);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
        }
        return null;
    }
}