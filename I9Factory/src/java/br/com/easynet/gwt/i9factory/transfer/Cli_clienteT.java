package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;
//br.com.easynet.gwt.i9factory.transfer.Cli_clienteT
public class Cli_clienteT { 
	 private int cli_nr_id;
	 private String cli_tx_nome;
	 private String cli_tx_cpf;
	 private String cli_tx_rg;
	 private String cli_tx_matricula;
	 private String cli_tx_sexo;
	 private String cli_tx_estadocivil;
	 private String cli_tx_tipologradouro;
	 private String cli_tx_logradouro;
	 private String cli_tx_numero;
	 private String cli_tx_cep;
	 private String cli_tx_complemento;
	 private String cli_tx_bairro;
	 private String cli_tx_municipio;
	 private String cli_tx_uf;
	 private String cli_tx_email;
	 private String cli_tx_telefone1;
	 private String cli_tx_telefone2;
	 private String cli_tx_celular;
	 private String cli_tx_ramal;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date cli_dt_nascimento;
	 private byte[] cli_bt_foto;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date cli_dt_cadastro;
	 private String cli_tx_socio;
	 private int org_nr_id;
	 private int tmp_nr_id;
         private String orgao;
         private int mtc_nr_id;
         private String cli_tx_salario_minimo;
         
	 public void setCli_nr_id(int cli_nr_id) {
		 this.cli_nr_id=cli_nr_id;
	}
 
	 public int getCli_nr_id() {
		 return cli_nr_id;
 	} 
 	 public void setCli_tx_nome(String cli_tx_nome) {
		 this.cli_tx_nome=cli_tx_nome;
	}
 
	 public String getCli_tx_nome() {
		 return cli_tx_nome;
 	} 
 	 public void setCli_tx_cpf(String cli_tx_cpf) {
		 this.cli_tx_cpf=cli_tx_cpf;
	}
 
	 public String getCli_tx_cpf() {
		 return cli_tx_cpf;
 	} 
 	 public void setCli_tx_rg(String cli_tx_rg) {
		 this.cli_tx_rg=cli_tx_rg;
	}
 
	 public String getCli_tx_rg() {
		 return cli_tx_rg;
 	} 
 	 public void setCli_tx_matricula(String cli_tx_matricula) {
		 this.cli_tx_matricula=cli_tx_matricula;
	}
 
	 public String getCli_tx_matricula() {
		 return cli_tx_matricula;
 	} 
 	 public void setCli_tx_sexo(String cli_tx_sexo) {
		 this.cli_tx_sexo=cli_tx_sexo;
	}
 
	 public String getCli_tx_sexo() {
		 return cli_tx_sexo;
 	} 
 	 public void setCli_tx_estadocivil(String cli_tx_estadocivil) {
		 this.cli_tx_estadocivil=cli_tx_estadocivil;
	}
 
	 public String getCli_tx_estadocivil() {
		 return cli_tx_estadocivil;
 	} 
 	 public void setCli_tx_tipologradouro(String cli_tx_tipologradouro) {
		 this.cli_tx_tipologradouro=cli_tx_tipologradouro;
	}
 
	 public String getCli_tx_tipologradouro() {
		 return cli_tx_tipologradouro;
 	} 
 	 public void setCli_tx_logradouro(String cli_tx_logradouro) {
		 this.cli_tx_logradouro=cli_tx_logradouro;
	}
 
	 public String getCli_tx_logradouro() {
		 return cli_tx_logradouro;
 	} 
 	 public void setCli_tx_numero(String cli_tx_numero) {
		 this.cli_tx_numero=cli_tx_numero;
	}
 
	 public String getCli_tx_numero() {
		 return cli_tx_numero;
 	} 
 	 public void setCli_tx_cep(String cli_tx_cep) {
		 this.cli_tx_cep=cli_tx_cep;
	}
 
	 public String getCli_tx_cep() {
		 return cli_tx_cep;
 	} 
 	 public void setCli_tx_complemento(String cli_tx_complemento) {
		 this.cli_tx_complemento=cli_tx_complemento;
	}
 
	 public String getCli_tx_complemento() {
		 return cli_tx_complemento;
 	} 
 	 public void setCli_tx_bairro(String cli_tx_bairro) {
		 this.cli_tx_bairro=cli_tx_bairro;
	}
 
	 public String getCli_tx_bairro() {
		 return cli_tx_bairro;
 	} 
 	 public void setCli_tx_municipio(String cli_tx_municipio) {
		 this.cli_tx_municipio=cli_tx_municipio;
	}
 
	 public String getCli_tx_municipio() {
		 return cli_tx_municipio;
 	} 
 	 public void setCli_tx_uf(String cli_tx_uf) {
		 this.cli_tx_uf=cli_tx_uf;
	}
 
	 public String getCli_tx_uf() {
		 return cli_tx_uf;
 	} 
 	 public void setCli_tx_email(String cli_tx_email) {
		 this.cli_tx_email=cli_tx_email;
	}
 
	 public String getCli_tx_email() {
		 return cli_tx_email;
 	} 
 	 public void setCli_tx_telefone1(String cli_tx_telefone1) {
		 this.cli_tx_telefone1=cli_tx_telefone1;
	}
 
	 public String getCli_tx_telefone1() {
		 return cli_tx_telefone1;
 	} 
 	 public void setCli_tx_telefone2(String cli_tx_telefone2) {
		 this.cli_tx_telefone2=cli_tx_telefone2;
	}
 
	 public String getCli_tx_telefone2() {
		 return cli_tx_telefone2;
 	} 
 	 public void setCli_tx_celular(String cli_tx_celular) {
		 this.cli_tx_celular=cli_tx_celular;
	}
 
	 public String getCli_tx_celular() {
		 return cli_tx_celular;
 	} 
 	 public void setCli_tx_ramal(String cli_tx_ramal) {
		 this.cli_tx_ramal=cli_tx_ramal;
	}
 
	 public String getCli_tx_ramal() {
		 return cli_tx_ramal;
 	} 
 	 public void setCli_dt_nascimento(java.util.Date cli_dt_nascimento) {
		 this.cli_dt_nascimento=cli_dt_nascimento;
	}
 
	 public java.util.Date getCli_dt_nascimento() {
		 return cli_dt_nascimento;
 	} 
 	 public void setCli_bt_foto(byte[] cli_bt_foto) {
		 this.cli_bt_foto=cli_bt_foto;
	}
 
	 public byte[] getCli_bt_foto() {
		 return cli_bt_foto;
 	} 
 	 public void setCli_dt_cadastro(java.util.Date cli_dt_cadastro) {
		 this.cli_dt_cadastro=cli_dt_cadastro;
	}
 
	 public java.util.Date getCli_dt_cadastro() {
		 return cli_dt_cadastro;
 	} 
 	 public void setCli_tx_socio(String cli_tx_socio) {
		 this.cli_tx_socio=cli_tx_socio;
	}
 
	 public String getCli_tx_socio() {
		 return cli_tx_socio;
 	} 
 	 public void setOrg_nr_id(int org_nr_id) {
		 this.org_nr_id=org_nr_id;
	}
 
	 public int getOrg_nr_id() {
		 return org_nr_id;
 	} 
 	 public void setTmp_nr_id(int tmp_nr_id) {
		 this.tmp_nr_id=tmp_nr_id;
	}
 
	 public int getTmp_nr_id() {
		 return tmp_nr_id;
 	} 

    /**
     * @return the orgao
     */
    public String getOrgao() {
        return orgao;
    }

    /**
     * @param orgao the orgao to set
     */
    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    /**
     * @return the mtc_nr_id
     */
    public int getMtc_nr_id() {
        return mtc_nr_id;
    }

    /**
     * @param mtc_nr_id the mtc_nr_id to set
     */
    public void setMtc_nr_id(int mtc_nr_id) {
        this.mtc_nr_id = mtc_nr_id;
    }

    /**
     * @return the cli_tx_salario_minimo
     */
    public String getCli_tx_salario_minimo() {
        return cli_tx_salario_minimo;
    }

    /**
     * @param cli_tx_salario_minimo the cli_tx_salario_minimo to set
     */
    public void setCli_tx_salario_minimo(String cli_tx_salario_minimo) {
        this.cli_tx_salario_minimo = cli_tx_salario_minimo;
    }
 }