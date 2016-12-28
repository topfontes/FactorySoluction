package br.com.i9factory.client.i9factory.factory.teb_transmissao_empresa_banco;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

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
public class Teb_transmissao_empresa_bancoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Teb_transmissao_empresa_bancoConsultGWT teb_transmissao_empresa_bancoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Teb_transmissao_empresa_bancoDAOGWT teb_transmissao_empresa_bancoDao = new Teb_transmissao_empresa_bancoDAOGWT();
    private Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT;

    private EasyTextField<String> teb_nr_id = new EasyTextField<String>();
    private DateField teb_dt_envio = new DateField();
    private DateField teb_dt_retorno = new DateField();
    private EasyTextField<String> teb_tx_status = new EasyTextField<String>();


    public Teb_transmissao_empresa_bancoUpdateDeleteGWT() {
        this.setSize("500", "400");
	
        getCpMaster().setLayout(new TableLayout(2));
	LabelField lfteb_nr_id = new LabelField("teb_nr_id:");
        lfteb_nr_id.setId("lfteb_nr_id");
	getCpMaster().add(lfteb_nr_id);
        teb_nr_id.setId("teb_nr_id");
        teb_nr_id.setMaxLength(10);
        getCpMaster().add(teb_nr_id);

	LabelField lfteb_dt_envio = new LabelField("teb_dt_envio:");
        lfteb_dt_envio.setId("lfteb_dt_envio");
	getCpMaster().add(lfteb_dt_envio);
        teb_dt_envio.setId("teb_dt_envio");
        teb_dt_envio.setMaxLength(13);
        getCpMaster().add(teb_dt_envio);

	LabelField lfteb_dt_retorno = new LabelField("teb_dt_retorno:");
        lfteb_dt_retorno.setId("lfteb_dt_retorno");
	getCpMaster().add(lfteb_dt_retorno);
        teb_dt_retorno.setId("teb_dt_retorno");
        teb_dt_retorno.setMaxLength(13);
        getCpMaster().add(teb_dt_retorno);

	LabelField lfteb_tx_status = new LabelField("teb_tx_status:");
        lfteb_tx_status.setId("lfteb_tx_status");
	getCpMaster().add(lfteb_tx_status);
        teb_tx_status.setId("teb_tx_status");
        teb_tx_status.setMaxLength(100);
        getCpMaster().add(teb_tx_status);


    }

    public void load(Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT) {
	this.teb_transmissao_empresa_bancoT = teb_transmissao_empresa_bancoT;
		teb_nr_id.setValue(teb_transmissao_empresa_bancoT.getTeb_nr_id() + "");
		teb_dt_envio.setValue(teb_transmissao_empresa_bancoT.getTeb_dt_envio());
		teb_dt_retorno.setValue(teb_transmissao_empresa_bancoT.getTeb_dt_retorno());
		teb_tx_status.setValue(teb_transmissao_empresa_bancoT.getTeb_tx_status());

    }
    public void btnUpdateAction(ButtonEvent ce) {
		teb_transmissao_empresa_bancoT.setTeb_nr_id( Integer.parseInt(teb_nr_id.getValue()));
		teb_transmissao_empresa_bancoT.setTeb_dt_envio(teb_dt_envio.getValue());
		teb_transmissao_empresa_bancoT.setTeb_dt_retorno(teb_dt_retorno.getValue());
		teb_transmissao_empresa_bancoT.setTeb_tx_status(teb_tx_status.getValue());

	teb_transmissao_empresa_bancoDao.alterar(teb_transmissao_empresa_bancoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = teb_transmissao_empresa_bancoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  teb_transmissao_empresa_bancoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

	teb_transmissao_empresa_bancoDao.excluir(teb_transmissao_empresa_bancoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = teb_transmissao_empresa_bancoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  teb_transmissao_empresa_bancoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }


   /**
     * @return the teb_transmissao_empresa_bancoConsult
     */
    public Teb_transmissao_empresa_bancoConsultGWT getTeb_transmissao_empresa_bancoConsult() {
        return teb_transmissao_empresa_bancoConsult;
    }

    /**
     * @param teb_transmissao_empresa_bancoConsult the teb_transmissao_empresa_bancoConsult to set
     */
    public void setTeb_transmissao_empresa_bancoConsult(Teb_transmissao_empresa_bancoConsultGWT teb_transmissao_empresa_bancoConsult) {
        this.teb_transmissao_empresa_bancoConsult = teb_transmissao_empresa_bancoConsult;
    }

}

