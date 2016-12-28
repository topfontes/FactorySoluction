package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Ple_parcelaemprestimoT { 
	 private int ple_nr_id;
	 private int emp_nr_id; 
         private String ple_tx_parcela;
         private String ple_tx_tipo;
         
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date ple_dt_vencimento;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date ple_dt_pagamento;
	 private double ple_nr_valorparcela;
	 private double ple_nr_valordesconto;
	 private int ple_nr_cdformapagto;
         private String ple_tx_historico;
         private int ple_nr_id_vinculo;
         private boolean ple_bl_suspenso;
         private int ple_nr_seq_boleto;
         
	 public void setPle_nr_id(int ple_nr_id) {
		 this.ple_nr_id=ple_nr_id;
	}
 
	 public int getPle_nr_id() {
		 return ple_nr_id;
 	} 
 	 public void setEmp_nr_id(int emp_nr_id) {
		 this.emp_nr_id=emp_nr_id;
	}
 
	 public int getEmp_nr_id() {
		 return emp_nr_id;
 	} 
 	 public void setPle_dt_vencimento(java.util.Date ple_dt_vencimento) {
		 this.ple_dt_vencimento=ple_dt_vencimento;
	}
 
	 public java.util.Date getPle_dt_vencimento() {
		 return ple_dt_vencimento;
 	} 
 	 public void setPle_dt_pagamento(java.util.Date ple_dt_pagamento) {
		 this.ple_dt_pagamento=ple_dt_pagamento;
	}
 
	 public java.util.Date getPle_dt_pagamento() {
		 return ple_dt_pagamento;
 	} 
 	 public void setPle_nr_valorparcela(double ple_nr_valorparcela) {
		 this.ple_nr_valorparcela=ple_nr_valorparcela;
	}
 
	 public double getPle_nr_valorparcela() {
		 return ple_nr_valorparcela;
 	} 
 	 public void setPle_nr_valordesconto(double ple_nr_valordesconto) {
		 this.ple_nr_valordesconto=ple_nr_valordesconto;
	}
 
	 public double getPle_nr_valordesconto() {
		 return ple_nr_valordesconto;
 	} 
 	 public void setPle_nr_cdformapagto(int ple_nr_cdformapagto) {
		 this.ple_nr_cdformapagto=ple_nr_cdformapagto;
	}
 
	 public int getPle_nr_cdformapagto() {
		 return ple_nr_cdformapagto;
 	}

    /**
     * @return the ple_tx_parcela
     */
    public String getPle_tx_parcela() {
        return ple_tx_parcela;
    }

    /**
     * @param ple_tx_parcela the ple_tx_parcela to set
     */
    public void setPle_tx_parcela(String ple_tx_parcela) {
        this.ple_tx_parcela = ple_tx_parcela;
    }

    /**
     * @return the ple_tx_tipo
     */
    public String getPle_tx_tipo() {
        return ple_tx_tipo;
    }

    /**
     * @param ple_tx_tipo the ple_tx_tipo to set
     */
    public void setPle_tx_tipo(String ple_tx_tipo) {
        this.ple_tx_tipo = ple_tx_tipo;
    }

    /**
     * @return the ple_tx_historico
     */
    public String getPle_tx_historico() {
        return ple_tx_historico;
    }

    /**
     * @param ple_tx_historico the ple_tx_historico to set
     */
    public void setPle_tx_historico(String ple_tx_historico) {
        this.ple_tx_historico = ple_tx_historico;
    }

    /**
     * @return the ple_nr_id_vinculo
     */
    public int getPle_nr_id_vinculo() {
        return ple_nr_id_vinculo;
    }

    /**
     * @param ple_nr_id_vinculo the ple_nr_id_vinculo to set
     */
    public void setPle_nr_id_vinculo(int ple_nr_id_vinculo) {
        this.ple_nr_id_vinculo = ple_nr_id_vinculo;
    }

    /**
     * @return the ple_bl_suspenso
     */
    public boolean isPle_bl_suspenso() {
        return ple_bl_suspenso;
    }
 
    /**
     * @param ple_bl_suspenso the ple_bl_suspenso to set
     */
    public void setPle_bl_suspenso(boolean ple_bl_suspenso) {
        this.ple_bl_suspenso = ple_bl_suspenso;
    }

    /**
     * @return the ple_nr_seq_boleto
     */
    public int getPle_nr_seq_boleto() {
        return ple_nr_seq_boleto;
    }

    /**
     * @param ple_nr_seq_boleto the ple_nr_seq_boleto to set
     */
    public void setPle_nr_seq_boleto(int ple_nr_seq_boleto) {
        this.ple_nr_seq_boleto = ple_nr_seq_boleto;
    }


 }