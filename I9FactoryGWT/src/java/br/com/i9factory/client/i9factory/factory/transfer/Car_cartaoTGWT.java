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
public class Car_cartaoTGWT extends BaseModel {

    public int getCar_nr_id() {
        return ((Integer) get("car_nr_id")).intValue();
//    return get("bco_nr_id");
    }

    public void setCar_nr_id(int car_nr_id) {
        set("car_nr_id", car_nr_id);
    }

    public String getCar_tx_nome() {
        return get("car_tx_nome");
//    return get("bco_tx_nome");
    }

    public void setCar_tx_nome(String car_tx_nome) {
        set("car_tx_nome", car_tx_nome);
    }

}
