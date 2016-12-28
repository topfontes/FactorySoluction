package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Arb_arquivobancoT { 
	 private int arb_nr_id;
	 private int arb_nr_seq;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp arb_dt_data;
	 private byte[] arb_by_arquivo;
	 private String arb_tx_tipo;
	 public void setArb_nr_id(int arb_nr_id) {
		 this.arb_nr_id=arb_nr_id;
	}
 
	 public int getArb_nr_id() {
		 return arb_nr_id;
 	} 
 	 public void setArb_dt_data(java.sql.Timestamp arb_dt_data) {
		 this.arb_dt_data=arb_dt_data;
	}
 
	 public java.sql.Timestamp getArb_dt_data() {
		 return arb_dt_data;
 	} 
 	 public void setArb_by_arquivo(byte[] arb_by_arquivo) {
		 this.arb_by_arquivo=arb_by_arquivo;
	}
 
	 public byte[] getArb_by_arquivo() {
		 return arb_by_arquivo;
 	} 
 	 public void setArb_tx_tipo(String arb_tx_tipo) {
		 this.arb_tx_tipo=arb_tx_tipo;
	}
 
	 public String getArb_tx_tipo() {
		 return arb_tx_tipo;
 	}

    /**
     * @return the arb_nr_seq
     */
    public int getArb_nr_seq() {
        return arb_nr_seq;
    }

    /**
     * @param arb_nr_seq the arb_nr_seq to set
     */
    public void setArb_nr_seq(int arb_nr_seq) {
        this.arb_nr_seq = arb_nr_seq;
    }
 }