/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoTGWT extends BaseModel {

    public int getCar_nr_id() {
        return ((Integer) get("car_nr_id")).intValue();
//    return get("bco_nr_id");
    }

    public void setCar_nr_id(int car_nr_id) {
        set("car_nr_id", car_nr_id);
    }
    
    
    public int getTac_nr_id() {
        return ((Integer) get("tac_nr_id")).intValue();
//    return get("bco_nr_id");
    }

    public void setTac_nr_id(int tac_nr_id) {
        set("tac_nr_id", tac_nr_id);
    }

    public float getTac_nr_taxa() {
        return ((Float) get("tac_nr_taxa")).floatValue();
    }

    public void setTac_nr_taxa(float tac_nr_taxa) {
        set("tac_nr_taxa", tac_nr_taxa);
    }

    public String getTac_tx_nome() {
        return get("tac_tx_nome");
    }

    public void setTac_tx_nome(String tac_tx_nome) {
        set("tac_tx_nome", tac_tx_nome);
    }
}
