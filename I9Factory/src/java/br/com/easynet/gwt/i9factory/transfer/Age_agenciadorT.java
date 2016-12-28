package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Age_agenciadorT { 
	 private int age_nr_id;
	 private String age_tx_cpf;
	 private String age_tx_nome;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp age_dt_cadastro;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date age_dt_nascimento;
	 private int eqp_nr_id;
	 private String age_tx_tipologradouro;
	 private String age_tx_logradouro;
	 private String age_tx_numero;
	 private String age_tx_cep;
	 private String age_tx_complemento="";
	 private String age_tx_bairro;
	 private String age_tx_municipio;
	 private String age_tx_uf;
	 private String age_tx_telefone2="";
	 private String age_tx_telefone2_1="";
	 private String age_tx_celular="";
	 private String age_tx_email="";
	 private float age_nr_taxaemprestimo;
	 private float age_nr_taxamensalidade;
	 public void setAge_nr_id(int age_nr_id) {
		 this.age_nr_id=age_nr_id;
	}
 
	 public int getAge_nr_id() {
		 return age_nr_id;
 	} 
 	 public void setAge_tx_cpf(String age_tx_cpf) {
		 this.age_tx_cpf=age_tx_cpf;
	}
 
	 public String getAge_tx_cpf() {
		 return age_tx_cpf;
 	} 
 	 public void setAge_tx_nome(String age_tx_nome) {
		 this.age_tx_nome=age_tx_nome;
	}
 
	 public String getAge_tx_nome() {
		 return age_tx_nome;
 	} 
 	 public void setAge_dt_cadastro(java.sql.Timestamp age_dt_cadastro) {
		 this.age_dt_cadastro=age_dt_cadastro;
	}
 
	 public java.sql.Timestamp getAge_dt_cadastro() {
		 return age_dt_cadastro;
 	} 
 	 public void setAge_dt_nascimento(java.util.Date age_dt_nascimento) {
		 this.age_dt_nascimento=age_dt_nascimento;
	}
 
	 public java.util.Date getAge_dt_nascimento() {
		 return age_dt_nascimento;
 	} 
 	 public void setEqp_nr_id(int eqp_nr_id) {
		 this.eqp_nr_id=eqp_nr_id;
	}
 
	 public int getEqp_nr_id() {
		 return eqp_nr_id;
 	} 
 	 public void setAge_tx_tipologradouro(String age_tx_tipologradouro) {
		 this.age_tx_tipologradouro=age_tx_tipologradouro;
	}
 
	 public String getAge_tx_tipologradouro() {
		 return age_tx_tipologradouro;
 	} 
 	 public void setAge_tx_logradouro(String age_tx_logradouro) {
		 this.age_tx_logradouro=age_tx_logradouro;
	}
 
	 public String getAge_tx_logradouro() {
		 return age_tx_logradouro;
 	} 
 	 public void setAge_tx_numero(String age_tx_numero) {
		 this.age_tx_numero=age_tx_numero;
	}
 
	 public String getAge_tx_numero() {
		 return age_tx_numero;
 	} 
 	 public void setAge_tx_cep(String age_tx_cep) {
		 this.age_tx_cep=age_tx_cep;
	}
 
	 public String getAge_tx_cep() {
		 return age_tx_cep;
 	} 
 	 public void setAge_tx_complemento(String age_tx_complemento) {
		 this.age_tx_complemento=age_tx_complemento;
	}
 
	 public String getAge_tx_complemento() {
		 return age_tx_complemento;
 	} 
 	 public void setAge_tx_bairro(String age_tx_bairro) {
		 this.age_tx_bairro=age_tx_bairro;
	}
 
	 public String getAge_tx_bairro() {
		 return age_tx_bairro;
 	} 
 	 public void setAge_tx_municipio(String age_tx_municipio) {
		 this.age_tx_municipio=age_tx_municipio;
	}
 
	 public String getAge_tx_municipio() {
		 return age_tx_municipio;
 	} 
 	 public void setAge_tx_uf(String age_tx_uf) {
		 this.age_tx_uf=age_tx_uf;
	}
 
	 public String getAge_tx_uf() {
		 return age_tx_uf;
 	} 
 	 public void setAge_tx_telefone2(String age_tx_telefone2) {
		 this.age_tx_telefone2=age_tx_telefone2;
	}
 
	 public String getAge_tx_telefone2() {
		 return age_tx_telefone2;
 	} 
 	 public void setAge_tx_telefone2_1(String age_tx_telefone2_1) {
		 this.age_tx_telefone2_1=age_tx_telefone2_1;
	}
 
	 public String getAge_tx_telefone2_1() {
		 return age_tx_telefone2_1;
 	} 
 	 public void setAge_tx_celular(String age_tx_celular) {
		 this.age_tx_celular=age_tx_celular;
	}
 
	 public String getAge_tx_celular() {
		 return age_tx_celular;
 	} 
 	 public void setAge_tx_email(String age_tx_email) {
		 this.age_tx_email=age_tx_email;
	}
 
	 public String getAge_tx_email() {
		 return age_tx_email;
 	} 
 	 public void setAge_nr_taxaemprestimo(float age_nr_taxaemprestimo) {
		 this.age_nr_taxaemprestimo=age_nr_taxaemprestimo;
	}
 
	 public float getAge_nr_taxaemprestimo() {
		 return age_nr_taxaemprestimo;
 	} 
 	 public void setAge_nr_taxamensalidade(float age_nr_taxamensalidade) {
		 this.age_nr_taxamensalidade=age_nr_taxamensalidade;
	}
 
	 public float getAge_nr_taxamensalidade() {
		 return age_nr_taxamensalidade;
 	} 
 }