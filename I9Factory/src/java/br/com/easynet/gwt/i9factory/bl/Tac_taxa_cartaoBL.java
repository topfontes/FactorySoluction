/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.bl;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.jb.SystemBase;
import br.com.easynet.gwt.i9factory.transfer.Car_cartaoT;
import br.com.easynet.gwt.i9factory.transfer.Tac_taxa_cartaoT;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoBL extends SystemBase implements INotSecurity{

    public Tac_taxa_cartaoBL() {
    }

    public boolean insert(Tac_taxa_cartaoT tac_taxa_cartaoT, String array) throws Exception {
        try {
            String[] itens = array.split("\\$");
            for (int i = 0; i < itens.length; i++) {
                String[] item = itens[i].split("\\|");
                tac_taxa_cartaoT.setTac_tx_nome(item[0]);
                tac_taxa_cartaoT.setTac_nr_taxa(Float.parseFloat(item[1]));
                getTac_taxa_cartaoDAO().insert(tac_taxa_cartaoT);
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }
    public static void main(String[] arg){
        String a = "ABC|0.98$DEF|0.8$";
        String[]b = a.split("$");
        String[] c = a.split("\\$");
        System.out.println(b.toString());
    }

    public boolean update(Tac_taxa_cartaoT tac_taxa_cartaoT) throws Exception {
        try {
            getTac_taxa_cartaoDAO().update(tac_taxa_cartaoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public boolean delete(Tac_taxa_cartaoT tac_taxa_cartaoT) throws Exception {
        try {
            getTac_taxa_cartaoDAO().delete(tac_taxa_cartaoT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public List<Tac_taxa_cartaoT> consult(Car_cartaoT car_cartaoT) throws Exception {
        try {
            return getTac_taxa_cartaoDAO().getAll(car_cartaoT);
        } catch (Exception e) {
            return new ArrayList<Tac_taxa_cartaoT>();
        } finally {
            close();
        }
        
    }
    public List<Tac_taxa_cartaoT> findById(Tac_taxa_cartaoT tac_taxa_cartaoT){
       try {
            return getTac_taxa_cartaoDAO().getByID(tac_taxa_cartaoT);
        } catch (Exception e) {
            return new ArrayList<Tac_taxa_cartaoT>();
        } finally {
            close();
        } 
    }

}
