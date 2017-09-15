/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.dao;

import br.com.easynet.gwt.i9factory.transfer.Car_cartaoT;
import br.com.jdragon.dao.DAOFactory;
import br.com.jdragon.dao.ObjectDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Car_cartaoDAO extends ObjectDAO {

    public Car_cartaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into factory.car_cartao  ( car_tx_nome) values (?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, car_cartaoT.getCar_tx_nome());
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

    public void update(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update factory.car_cartao  set car_tx_nome =? where car_nr_id = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, car_cartaoT.getCar_tx_nome());
            pStmt.setObject(2, car_cartaoT.getCar_nr_id());
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

    public void delete(Car_cartaoT car_cartaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from factory.car_cartao where car_nr_id = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, car_cartaoT.getCar_nr_id());
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

    public List<Car_cartaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from factory.car_cartao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultTransferObject(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Car_cartaoT> resultTransferObject(ResultSet rs) throws Exception {
        List<Car_cartaoT> list = new ArrayList<Car_cartaoT>();

        try {
            while (rs.next()) {
                Car_cartaoT car_cartaoT = new Car_cartaoT();
                car_cartaoT.setCar_nr_id(rs.getInt("car_nr_id"));
                car_cartaoT.setCar_tx_nome(rs.getString("car_tx_nome"));
                list.add(car_cartaoT);
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }
}
