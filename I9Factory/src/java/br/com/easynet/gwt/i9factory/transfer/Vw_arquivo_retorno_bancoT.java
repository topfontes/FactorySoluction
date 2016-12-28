package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Vw_arquivo_retorno_bancoT { 
	 private int teb_nr_id;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date teb_dt_envio;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date teb_dt_retorno;
	 private String teb_tx_status;
	 private String teb_tx_operacao;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date ple_dt_vencimento;
	 private String ple_tx_parcela;
	 private float ple_nr_valorparcela;
	 private int emp_nr_proposta;
	 private String cli_tx_nome;
	 public void setTeb_nr_id(int teb_nr_id) {
		 this.teb_nr_id=teb_nr_id;
	}
 
	 public int getTeb_nr_id() {
		 return teb_nr_id;
 	} 
 	 public void setTeb_dt_envio(java.util.Date teb_dt_envio) {
		 this.teb_dt_envio=teb_dt_envio;
	}
 
	 public java.util.Date getTeb_dt_envio() {
		 return teb_dt_envio;
 	} 
 	 public void setTeb_dt_retorno(java.util.Date teb_dt_retorno) {
		 this.teb_dt_retorno=teb_dt_retorno;
	}
 
	 public java.util.Date getTeb_dt_retorno() {
		 return teb_dt_retorno;
 	} 
 	 public void setTeb_tx_status(String teb_tx_status) {
		 this.teb_tx_status=teb_tx_status;
	}
 
	 public String getTeb_tx_status() {
		 return teb_tx_status;
 	} 
 	 public void setTeb_tx_operacao(String teb_tx_operacao) {
		 this.teb_tx_operacao=teb_tx_operacao;
	}
 
	 public String getTeb_tx_operacao() {
		 return teb_tx_operacao;
 	} 
 	 public void setPle_dt_vencimento(java.util.Date ple_dt_vencimento) {
		 this.ple_dt_vencimento=ple_dt_vencimento;
	}
 
	 public java.util.Date getPle_dt_vencimento() {
		 return ple_dt_vencimento;
 	} 
 	 public void setPle_tx_parcela(String ple_tx_parcela) {
		 this.ple_tx_parcela=ple_tx_parcela;
	}
 
	 public String getPle_tx_parcela() {
		 return ple_tx_parcela;
 	} 
 	 public void setPle_nr_valorparcela(float ple_nr_valorparcela) {
		 this.ple_nr_valorparcela=ple_nr_valorparcela;
	}
 
	 public float getPle_nr_valorparcela() {
		 return ple_nr_valorparcela;
 	} 
 	 public void setEmp_nr_proposta(int emp_nr_proposta) {
		 this.emp_nr_proposta=emp_nr_proposta;
	}
 
	 public int getEmp_nr_proposta() {
		 return emp_nr_proposta;
 	} 
 	 public void setCli_tx_nome(String cli_tx_nome) {
		 this.cli_tx_nome=cli_tx_nome;
	}
 
	 public String getCli_tx_nome() {
		 return cli_tx_nome;
 	} 
 }