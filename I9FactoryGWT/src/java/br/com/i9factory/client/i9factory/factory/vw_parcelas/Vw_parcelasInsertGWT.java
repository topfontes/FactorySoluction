/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9factory.client.i9factory.factory.vw_parcelas;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Vw_parcelasInsertGWT extends CadastrarBaseGWT  {
    private Vw_parcelasConsultGWT vw_parcelasConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Vw_parcelasDAOGWT vw_parcelasDao = new Vw_parcelasDAOGWT();
    private TextField<String> ple_nr_id = new TextField<String>();
    private TextField<String> emp_nr_id = new TextField<String>();
    private DateField ple_dt_vencimento = new DateField();
    private DateField ple_dt_pagamento = new DateField();
    private TextField<String> ple_nr_valorparcela = new TextField<String>();
    private TextField<String> ple_nr_valordesconto = new TextField<String>();
    private TextField<String> ple_nr_cdformapagto = new TextField<String>();
    private TextField<String> ple_tx_parcela = new TextField<String>();
    private TextField<String> ple_tx_tipo = new TextField<String>();
    private DateField emp_dt_emprestimo = new DateField();
    private TextField<String> emp_nr_proposta = new TextField<String>();
    private TextField<String> emp_nr_valor = new TextField<String>();
    private TextField<String> emp_nr_valor_afin_liquido = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> org_nr_id = new TextField<String>();
    private TextField<String> cli_tx_cpf = new TextField<String>();
    private TextField<String> cli_tx_nome = new TextField<String>();
    private TextField<String> cco_tx_nragencia = new TextField<String>();
    private TextField<String> cco_tx_nrcontacorrente = new TextField<String>();
    private TextField<String> bco_nr_id = new TextField<String>();
    private TextField<String> bco_tx_nome = new TextField<String>();
    private TextField<String> bco_tx_codigo = new TextField<String>();


    public Vw_parcelasInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("ple_nr_id:"));
        getCpMaster().add(ple_nr_id);

        getCpMaster().add(new LabelField("emp_nr_id:"));
        getCpMaster().add(emp_nr_id);

        getCpMaster().add(new LabelField("ple_dt_vencimento:"));
        getCpMaster().add(ple_dt_vencimento);

        getCpMaster().add(new LabelField("ple_dt_pagamento:"));
        getCpMaster().add(ple_dt_pagamento);

        getCpMaster().add(new LabelField("ple_nr_valorparcela:"));
        getCpMaster().add(ple_nr_valorparcela);

        getCpMaster().add(new LabelField("ple_nr_valordesconto:"));
        getCpMaster().add(ple_nr_valordesconto);

        getCpMaster().add(new LabelField("ple_nr_cdformapagto:"));
        getCpMaster().add(ple_nr_cdformapagto);

        getCpMaster().add(new LabelField("ple_tx_parcela:"));
        getCpMaster().add(ple_tx_parcela);

        getCpMaster().add(new LabelField("ple_tx_tipo:"));
        getCpMaster().add(ple_tx_tipo);

        getCpMaster().add(new LabelField("emp_dt_emprestimo:"));
        getCpMaster().add(emp_dt_emprestimo);

        getCpMaster().add(new LabelField("emp_nr_proposta:"));
        getCpMaster().add(emp_nr_proposta);

        getCpMaster().add(new LabelField("emp_nr_valor:"));
        getCpMaster().add(emp_nr_valor);

        getCpMaster().add(new LabelField("emp_nr_valor_afin_liquido:"));
        getCpMaster().add(emp_nr_valor_afin_liquido);

        getCpMaster().add(new LabelField("cli_nr_id:"));
        getCpMaster().add(cli_nr_id);

        getCpMaster().add(new LabelField("org_nr_id:"));
        getCpMaster().add(org_nr_id);

        getCpMaster().add(new LabelField("cli_tx_cpf:"));
        getCpMaster().add(cli_tx_cpf);

        getCpMaster().add(new LabelField("cli_tx_nome:"));
        getCpMaster().add(cli_tx_nome);

        getCpMaster().add(new LabelField("cco_tx_nragencia:"));
        getCpMaster().add(cco_tx_nragencia);

        getCpMaster().add(new LabelField("cco_tx_nrcontacorrente:"));
        getCpMaster().add(cco_tx_nrcontacorrente);

        getCpMaster().add(new LabelField("bco_nr_id:"));
        getCpMaster().add(bco_nr_id);

        getCpMaster().add(new LabelField("bco_tx_nome:"));
        getCpMaster().add(bco_tx_nome);

        getCpMaster().add(new LabelField("bco_tx_codigo:"));
        getCpMaster().add(bco_tx_codigo);


    }

    public void btnInsertAction(ButtonEvent ce){
	Vw_parcelasTGWT vw_parcelasT = new Vw_parcelasTGWT();
			vw_parcelasT.setPle_nr_id( Integer.parseInt(ple_nr_id.getValue()));
		vw_parcelasT.setEmp_nr_id( Integer.parseInt(emp_nr_id.getValue()));
		vw_parcelasT.setPle_dt_vencimento(ple_dt_vencimento.getValue());
		vw_parcelasT.setPle_dt_pagamento(ple_dt_pagamento.getValue());
		vw_parcelasT.setPle_nr_valorparcela( Float.parseFloat(ple_nr_valorparcela.getValue()));
		vw_parcelasT.setPle_nr_valordesconto( Float.parseFloat(ple_nr_valordesconto.getValue()));
		vw_parcelasT.setPle_nr_cdformapagto( Integer.parseInt(ple_nr_cdformapagto.getValue()));
		vw_parcelasT.setPle_tx_parcela(ple_tx_parcela.getValue());
		vw_parcelasT.setPle_tx_tipo(ple_tx_tipo.getValue());
		vw_parcelasT.setEmp_dt_emprestimo(emp_dt_emprestimo.getValue());
		vw_parcelasT.setEmp_nr_proposta( Integer.parseInt(emp_nr_proposta.getValue()));
		vw_parcelasT.setEmp_nr_valor( Float.parseFloat(emp_nr_valor.getValue()));
		vw_parcelasT.setEmp_nr_valor_afin_liquido( Float.parseFloat(emp_nr_valor_afin_liquido.getValue()));
		vw_parcelasT.setCli_nr_id( Integer.parseInt(cli_nr_id.getValue()));
		vw_parcelasT.setOrg_nr_id( Integer.parseInt(org_nr_id.getValue()));
		vw_parcelasT.setCli_tx_cpf(cli_tx_cpf.getValue());
		vw_parcelasT.setCli_tx_nome(cli_tx_nome.getValue());
		vw_parcelasT.setCco_tx_nragencia(cco_tx_nragencia.getValue());
		vw_parcelasT.setCco_tx_nrcontacorrente(cco_tx_nrcontacorrente.getValue());
		vw_parcelasT.setBco_nr_id( Integer.parseInt(bco_nr_id.getValue()));
		vw_parcelasT.setBco_tx_nome(bco_tx_nome.getValue());
		vw_parcelasT.setBco_tx_codigo(bco_tx_codigo.getValue());

        vw_parcelasDao.inserir(vw_parcelasT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = vw_parcelasDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  vw_parcelasConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			ple_nr_id.setValue("");
		emp_nr_id.setValue("");
		ple_dt_vencimento.setValue(null);
		ple_dt_pagamento.setValue(null);
		ple_nr_valorparcela.setValue("");
		ple_nr_valordesconto.setValue("");
		ple_nr_cdformapagto.setValue("");
		ple_tx_parcela.setValue("");
		ple_tx_tipo.setValue("");
		emp_dt_emprestimo.setValue(null);
		emp_nr_proposta.setValue("");
		emp_nr_valor.setValue("");
		emp_nr_valor_afin_liquido.setValue("");
		cli_nr_id.setValue("");
		org_nr_id.setValue("");
		cli_tx_cpf.setValue("");
		cli_tx_nome.setValue("");
		cco_tx_nragencia.setValue("");
		cco_tx_nrcontacorrente.setValue("");
		bco_nr_id.setValue("");
		bco_tx_nome.setValue("");
		bco_tx_codigo.setValue("");

    }

   /**
     * @return the vw_parcelasConsult
     */
    public Vw_parcelasConsultGWT getVw_parcelasConsult() {
        return vw_parcelasConsult;
    }

    /**
     * @param vw_parcelasConsult the vw_parcelasConsult to set
     */
    public void setVw_parcelasConsult(Vw_parcelasConsultGWT vw_parcelasConsult) {
        this.vw_parcelasConsult = vw_parcelasConsult;
    }
}

