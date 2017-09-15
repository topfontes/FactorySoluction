/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.bl.Tac_taxa_cartaoBL;
import br.com.easynet.gwt.i9factory.transfer.Car_cartaoT;
import br.com.easynet.gwt.i9factory.transfer.Tac_taxa_cartaoT;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoJB extends SystemBase implements INotSecurity{
    
    private Car_cartaoT car_cartaoT = new Car_cartaoT();
    private Tac_taxa_cartaoT tac_taxa_cartaoT;
    private Tac_taxa_cartaoBL tac_taxa_cartaoBL = new Tac_taxa_cartaoBL();
    private List<Tac_taxa_cartaoT>list = new ArrayList<Tac_taxa_cartaoT>();
    private String array;
    

    public Tac_taxa_cartaoJB() {
    
    }
    
    public void insert(){
        try {
            tac_taxa_cartaoBL.insert(getTac_taxa_cartaoT(), array);
            setMsg(INFO,"Cadastro efetuado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(){
        try {
            tac_taxa_cartaoBL.update(getTac_taxa_cartaoT());
            setMsg("Alteracao efetuada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(){
        try {
            tac_taxa_cartaoBL.delete(getTac_taxa_cartaoT());
            setMsg("Exclusao efetuada com sucesso!");
        } catch (Exception e) {
        }
    }
    public void consult(){
        try { 
            list = tac_taxa_cartaoBL.consult(car_cartaoT);
            System.out.println(""+list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findById(){
        try {
            list = tac_taxa_cartaoBL.findById(tac_taxa_cartaoT);
        } catch (Exception e) {
        }
    }
        
    /**
     * @return the tac_taxa_cartaoT
     */
    public Tac_taxa_cartaoT getTac_taxa_cartaoT() {
        return tac_taxa_cartaoT;
    }

    /**
     * @param tac_taxa_cartaoT the tac_taxa_cartaoT to set
     */
    public void setTac_taxa_cartaoT(Tac_taxa_cartaoT tac_taxa_cartaoT) {
        this.tac_taxa_cartaoT = tac_taxa_cartaoT;
    }

    /**
     * @return the tac_taxa_cartaoBL
     */
    public Tac_taxa_cartaoBL getTac_taxa_cartaoBL() {
        return tac_taxa_cartaoBL;
    }

    /**
     * @param tac_taxa_cartaoBL the tac_taxa_cartaoBL to set
     */
    public void setTac_taxa_cartaoBL(Tac_taxa_cartaoBL tac_taxa_cartaoBL) {
        this.tac_taxa_cartaoBL = tac_taxa_cartaoBL;
    }

    /**
     * @return the list
     */
    public List<Tac_taxa_cartaoT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Tac_taxa_cartaoT> list) {
        this.list = list;
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
     * @return the array
     */
    public String getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(String array) {
        this.array = array;
    }
    
}
