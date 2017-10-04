/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.bl;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.jb.SystemBase;
import br.com.easynet.gwt.i9factory.transfer.Car_cartaoT;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Car_cartaoBL extends SystemBase  implements INotSecurity{

    public Car_cartaoBL() {
    }

    public boolean insert(Car_cartaoT car_cartaoT) throws Exception {
        try {
            
            getCar_cartaoDAO().insert(car_cartaoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public boolean update(Car_cartaoT car_cartaoT) throws Exception {
        try {
            getCar_cartaoDAO().update(car_cartaoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public boolean delete(Car_cartaoT car_cartaoT) throws Exception {
        try {
            getCar_cartaoDAO().delete(car_cartaoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public List<Car_cartaoT> consult() throws Exception {
        try {
            return getCar_cartaoDAO().getAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return new ArrayList<Car_cartaoT>();
    }
}
