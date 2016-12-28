/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.util;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 *
 * @author topfontes
 */
public class Mtc_motivo_cancelamento extends BaseModel {

    public int getMtc_nr_id() {
        return ((Integer) get("mtc_nr_id")).intValue();
//    return get("bco_nr_id");
    }

    public void setMtc_nr_id(int mtc_nr_id) {
        set("mtc_nr_id", mtc_nr_id);
    }

    public String getMtc_tx_nome() {
        return get("mtc_tx_nome");
//    return get("bco_tx_nome");
    }

    public void setMtc_tx_nome(String mtc_tx_nome) {
        set("mtc_tx_nome", mtc_tx_nome);
    }
}
