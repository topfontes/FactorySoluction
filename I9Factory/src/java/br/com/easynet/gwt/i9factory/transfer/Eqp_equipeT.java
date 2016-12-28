package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Eqp_equipeT { 
	 private int eqp_nr_id;
	 private String eqp_tx_nome;
	 private String eqp_tx_descricao;
	 private int cor_nr_id;
	 public void setEqp_nr_id(int eqp_nr_id) {
		 this.eqp_nr_id=eqp_nr_id;
	}
 
	 public int getEqp_nr_id() {
		 return eqp_nr_id;
 	} 
 	 public void setEqp_tx_nome(String eqp_tx_nome) {
		 this.eqp_tx_nome=eqp_tx_nome;
	}
 
	 public String getEqp_tx_nome() {
		 return eqp_tx_nome;
 	} 
 	 public void setEqp_tx_descricao(String eqp_tx_descricao) {
		 this.eqp_tx_descricao=eqp_tx_descricao;
	}
 
	 public String getEqp_tx_descricao() {
		 return eqp_tx_descricao;
 	} 
 	 public void setCor_nr_id(int cor_nr_id) {
		 this.cor_nr_id=cor_nr_id;
	}
 
	 public int getCor_nr_id() {
		 return cor_nr_id;
 	} 
 }