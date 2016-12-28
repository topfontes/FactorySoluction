/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9factory.client.i9factory.factory.lan_lancamento;

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
public class Lan_lancamentoInsertGWT extends CadastrarBaseGWT  {
    private Lan_lancamentoConsultGWT lan_lancamentoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Lan_lancamentoDAOGWT lan_lancamentoDao = new Lan_lancamentoDAOGWT();
    private TextField<String> lan_nr_id = new TextField<String>();
    private TextField<String> ctr_nr_id = new TextField<String>();
    private TextField<String> ctp_nr_id = new TextField<String>();
    private TextField<String> lan_plc_nr_id_deb = new TextField<String>();
    private TextField<String> lan_plc_nr_id_cred = new TextField<String>();
    private DateField lan_dt_lancamento = new DateField();
    private TextField<String> lan_tx_historico = new TextField<String>();
    private TextField<String> lan_valor = new TextField<String>();
    private TextField<String> lan_nr_id_super = new TextField<String>();


    public Lan_lancamentoInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("lan_nr_id:"));
        getCpMaster().add(lan_nr_id);

        getCpMaster().add(new LabelField("ctr_nr_id:"));
        getCpMaster().add(ctr_nr_id);

        getCpMaster().add(new LabelField("ctp_nr_id:"));
        getCpMaster().add(ctp_nr_id);

        getCpMaster().add(new LabelField("lan_plc_nr_id_deb:"));
        getCpMaster().add(lan_plc_nr_id_deb);

        getCpMaster().add(new LabelField("lan_plc_nr_id_cred:"));
        getCpMaster().add(lan_plc_nr_id_cred);

        getCpMaster().add(new LabelField("lan_dt_lancamento:"));
        getCpMaster().add(lan_dt_lancamento);

        getCpMaster().add(new LabelField("lan_tx_historico:"));
        getCpMaster().add(lan_tx_historico);

        getCpMaster().add(new LabelField("lan_valor:"));
        getCpMaster().add(lan_valor);

        getCpMaster().add(new LabelField("lan_nr_id_super:"));
        getCpMaster().add(lan_nr_id_super);


    }

    public void btnInsertAction(ButtonEvent ce){
	Lan_lancamentoTGWT lan_lancamentoT = new Lan_lancamentoTGWT();
			lan_lancamentoT.setLan_nr_id( Integer.parseInt(lan_nr_id.getValue()));
		lan_lancamentoT.setCtr_nr_id( Integer.parseInt(ctr_nr_id.getValue()));
		lan_lancamentoT.setCtp_nr_id( Integer.parseInt(ctp_nr_id.getValue()));
		lan_lancamentoT.setLan_plc_nr_id_deb( Integer.parseInt(lan_plc_nr_id_deb.getValue()));
		lan_lancamentoT.setLan_plc_nr_id_cred( Integer.parseInt(lan_plc_nr_id_cred.getValue()));
		lan_lancamentoT.setLan_dt_lancamento(lan_dt_lancamento.getValue());
		lan_lancamentoT.setLan_tx_historico(lan_tx_historico.getValue());
		lan_lancamentoT.setLan_valor( Float.parseFloat(lan_valor.getValue()));
		lan_lancamentoT.setLan_nr_id_super( Float.parseFloat(lan_nr_id_super.getValue()));

        lan_lancamentoDao.inserir(lan_lancamentoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = lan_lancamentoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  lan_lancamentoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			lan_nr_id.setValue("");
		ctr_nr_id.setValue("");
		ctp_nr_id.setValue("");
		lan_plc_nr_id_deb.setValue("");
		lan_plc_nr_id_cred.setValue("");
		lan_dt_lancamento.setValue(null);
		lan_tx_historico.setValue("");
		lan_valor.setValue("");
		lan_nr_id_super.setValue("");

    }

   /**
     * @return the lan_lancamentoConsult
     */
    public Lan_lancamentoConsultGWT getLan_lancamentoConsult() {
        return lan_lancamentoConsult;
    }

    /**
     * @param lan_lancamentoConsult the lan_lancamentoConsult to set
     */
    public void setLan_lancamentoConsult(Lan_lancamentoConsultGWT lan_lancamentoConsult) {
        this.lan_lancamentoConsult = lan_lancamentoConsult;
    }
}

