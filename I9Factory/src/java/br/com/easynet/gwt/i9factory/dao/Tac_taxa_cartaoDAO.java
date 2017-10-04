/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoDAO extends ObjectDAO {

    public Tac_taxa_cartaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Tac_taxa_cartaoT tac_taxa_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.tac_taxa_cartao  (tac_tx_nome, tac_nr_taxa,car_nr_id) values (?,?,?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tac_taxa_cartaoT.getTac_tx_nome());
            pStmt.setObject(2, tac_taxa_cartaoT.getTac_nr_taxa());
            pStmt.setObject(3, tac_taxa_cartaoT.getCar_nr_id());
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

    public void update(Tac_taxa_cartaoT tac_taxa_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.tac_taxa_cartao set tac_tx_nome=? , tac_nr_taxa= ? where tac_nr_id =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tac_taxa_cartaoT.getTac_tx_nome());
            pStmt.setObject(2, tac_taxa_cartaoT.getTac_nr_taxa());
            pStmt.setObject(3, tac_taxa_cartaoT.getTac_nr_id());
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

    public void delete(Tac_taxa_cartaoT tac_taxa_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from  factory.tac_taxa_cartao where tac_nr_id =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tac_taxa_cartaoT.getTac_nr_id());
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

    public List<Tac_taxa_cartaoT> getAll(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tac_taxa_cartao where car_nr_id=?";
            pStmt = con.prepareStatement(sql);
            //System.out.println(" "+car_cartaoT.getCar_nr_id());
            pStmt.setObject(1, car_cartaoT.getCar_nr_id());
            rs = pStmt.executeQuery();
            return resultTransferObject(rs);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tac_taxa_cartaoT> getByID(Tac_taxa_cartaoT tac_taxa_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.tac_taxa_cartao where tac_nr_id=?";
            pStmt = con.prepareStatement(sql);
            //System.out.println(" "+car_cartaoT.getCar_nr_id());
            pStmt.setObject(1, tac_taxa_cartaoT.getTac_nr_id());
            rs = pStmt.executeQuery();
            return resultTransferObject(rs);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Tac_taxa_cartaoT> resultTransferObject(ResultSet rs) throws Exception {
        List<Tac_taxa_cartaoT> list = new ArrayList<Tac_taxa_cartaoT>();

        try {
            while (rs.next()) {
                Tac_taxa_cartaoT tac_taxa_cartaoT = new Tac_taxa_cartaoT();
                tac_taxa_cartaoT.setCar_nr_id(rs.getInt("car_nr_id"));
                tac_taxa_cartaoT.setTac_nr_id(rs.getInt("tac_nr_id"));
                tac_taxa_cartaoT.setTac_tx_nome(rs.getString("tac_tx_nome"));
                tac_taxa_cartaoT.setTac_nr_taxa(rs.getFloat("tac_nr_taxa"));
                list.add(tac_taxa_cartaoT);
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

}
