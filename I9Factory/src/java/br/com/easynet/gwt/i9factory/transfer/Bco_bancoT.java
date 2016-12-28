package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Bco_bancoT { 
	 private int bco_nr_id;
	 private String bco_tx_nome;
	 private String bco_tx_telefone1="";
	 private String bco_tx_telefone2="";
	 private String bco_tx_nomecontato="";
         private String bco_tx_codigo;
         
	 public void setBco_nr_id(int bco_nr_id) {
		 this.bco_nr_id=bco_nr_id;
	}
 
	 public int getBco_nr_id() {
		 return bco_nr_id;
 	} 
 	 public void setBco_tx_nome(String bco_tx_nome) {
		 this.bco_tx_nome=bco_tx_nome;
	}
 
	 public String getBco_tx_nome() {
		 return bco_tx_nome;
 	} 
 	 public void setBco_tx_telefone1(String bco_tx_telefone1) {
		 this.bco_tx_telefone1=bco_tx_telefone1;
	}
 
	 public String getBco_tx_telefone1() {
		 return bco_tx_telefone1;
 	} 
 	 public void setBco_tx_telefone2(String bco_tx_telefone2) {
		 this.bco_tx_telefone2=bco_tx_telefone2;
	}
 
	 public String getBco_tx_telefone2() {
		 return bco_tx_telefone2;
 	} 
 	 public void setBco_tx_nomecontato(String bco_tx_nomecontato) {
		 this.bco_tx_nomecontato=bco_tx_nomecontato;
	}
 
	 public String getBco_tx_nomecontato() {
		 return bco_tx_nomecontato;
 	}

    /**
     * @return the bco_tx_codigo
     */
    public String getBco_tx_codigo() {
        return bco_tx_codigo;
    }

    /**
     * @param bco_tx_codigo the bco_tx_codigo to set
     */
    public void setBco_tx_codigo(String bco_tx_codigo) {
        this.bco_tx_codigo = bco_tx_codigo;
    }
 }