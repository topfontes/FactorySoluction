/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.transfer;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoT {
    private int car_nr_id;
    private int tac_nr_id;
    private String tac_tx_nome;
    private float tac_nr_taxa;

    /**
     * @return the car_nr_id
     */
    public int getCar_nr_id() {
        return car_nr_id;
    }

    /**
     * @param car_nr_id the car_nr_id to set
     */
    public void setCar_nr_id(int car_nr_id) {
        this.car_nr_id = car_nr_id;
    }

    /**
     * @return the tac_nr_id
     */
    public int getTac_nr_id() {
        return tac_nr_id;
    }

    /**
     * @param tac_nr_id the tac_nr_id to set
     */
    public void setTac_nr_id(int tac_nr_id) {
        this.tac_nr_id = tac_nr_id;
    }

    /**
     * @return the tac_tx_nome
     */
    public String getTac_tx_nome() {
        return tac_tx_nome;
    }

    /**
     * @param tac_tx_nome the tac_tx_nome to set
     */
    public void setTac_tx_nome(String tac_tx_nome) {
        this.tac_tx_nome = tac_tx_nome;
    }

    /**
     * @return the tac_nr_taxa
     */
    public float getTac_nr_taxa() {
        return tac_nr_taxa;
    }

    /**
     * @param tac_nr_taxa the tac_nr_taxa to set
     */
    public void setTac_nr_taxa(float tac_nr_taxa) {
        this.tac_nr_taxa = tac_nr_taxa;
    }
}
