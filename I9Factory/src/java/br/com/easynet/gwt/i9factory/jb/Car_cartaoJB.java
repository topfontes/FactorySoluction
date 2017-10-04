/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.bl.Car_cartaoBL;
import br.com.easynet.gwt.i9factory.transfer.Car_cartaoT;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Car_cartaoJB extends SystemBase implements INotSecurity{

    private Car_cartaoT car_cartaoT = new Car_cartaoT();
    private Car_cartaoBL car_cartaoBL = new Car_cartaoBL();
    private List<Car_cartaoT> list = new ArrayList<Car_cartaoT>();
    
    public Car_cartaoJB() {
        
    }
    
    public void insert(){
        try {
            getCar_cartaoDAO().insert(car_cartaoT);
            setMsg(INFO,"Cadastro efetuado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(){
        try {
            getCar_cartaoDAO().update(car_cartaoT);
            setMsg("Alteracao efetuada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(){
        try {
            getCar_cartaoDAO().delete(car_cartaoT);
            setMsg("Exclusao efetuada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void consult(){
        try {
            setList(getCar_cartaoDAO().getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the car_cartaoT
     */
    public Car_cartaoT getCar_cartaoT() {
        return car_cartaoT;
    }

    /**
     * @param car_cartaoT the car_cartaoT to set
     */
    public void setCar_cartaoT(Car_cartaoT car_cartaoT) {
        this.car_cartaoT = car_cartaoT;
    }

    /**
     * @return the list
     */
    public List<Car_cartaoT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Car_cartaoT> list) {
        this.list = list;
    }
    
}
