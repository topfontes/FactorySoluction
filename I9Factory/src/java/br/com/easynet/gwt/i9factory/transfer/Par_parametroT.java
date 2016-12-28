package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Par_parametroT { 
	 private int par_nr_id;
	 private String par_tx_nome;
	 private String par_tx_valor;
	 private String par_tx_descricao;
	 public void setPar_nr_id(int par_nr_id) {
		 this.par_nr_id=par_nr_id;
	}
 
	 public int getPar_nr_id() {
		 return par_nr_id;
 	} 
 	 public void setPar_tx_nome(String par_tx_nome) {
		 this.par_tx_nome=par_tx_nome;
	}
 
	 public String getPar_tx_nome() {
		 return par_tx_nome;
 	} 
 	 public void setPar_tx_valor(String par_tx_valor) {
		 this.par_tx_valor=par_tx_valor;
	}
 
	 public String getPar_tx_valor() {
		 return par_tx_valor;
 	} 
 	 public void setPar_tx_descricao(String par_tx_descricao) {
		 this.par_tx_descricao=par_tx_descricao;
	}
 
	 public String getPar_tx_descricao() {
		 return par_tx_descricao;
 	} 
 }