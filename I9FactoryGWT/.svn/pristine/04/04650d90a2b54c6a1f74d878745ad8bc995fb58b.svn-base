package br.com.i9factory.client.i9factory.factory.res_restricao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

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
public class Res_restricaoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Res_restricaoConsultGWT res_restricaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Res_restricaoDAOGWT res_restricaoDao = new Res_restricaoDAOGWT();
    private Res_restricaoTGWT res_restricaoT;

    private TextField<String> res_nr_id = new TextField<String>();
    private TextField<String> res_tx_nome = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private Cli_clienteTGWT cli_clienteTGWT = new Cli_clienteTGWT();


    public Res_restricaoUpdateDeleteGWT(Cli_clienteTGWT cli_clienteTGWT) {
        this.setSize("430", "120");
        this.cli_clienteTGWT = cli_clienteTGWT;
        this.setHeading("Alterar Restrição - " + cli_clienteTGWT.getCli_tx_nome());

        getCpMaster().setFrame(true);

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        getCpMaster().add(new LabelField("Restrição:"));
        res_tx_nome.setWidth(300);
        res_tx_nome.setAllowBlank(false);
        res_tx_nome.setMaxLength(100);
        getCpMaster().add(res_tx_nome);

    }

    public void load(Res_restricaoTGWT res_restricaoT) {
	this.res_restricaoT = res_restricaoT;
		res_nr_id.setValue(res_restricaoT.getRes_nr_id() + "");
		res_tx_nome.setValue(res_restricaoT.getRes_tx_nome());
		cli_nr_id.setValue(res_restricaoT.getCli_nr_id() + "");

    }
    public void btnUpdateAction(ButtonEvent ce) {
		res_restricaoT.setRes_nr_id( Integer.parseInt(res_nr_id.getValue()));
		res_restricaoT.setRes_tx_nome(res_tx_nome.getValue());
		res_restricaoT.setCli_nr_id( Integer.parseInt(cli_nr_id.getValue()));

	res_restricaoDao.alterar(res_restricaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = res_restricaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  res_restricaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

	res_restricaoDao.excluir(res_restricaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = res_restricaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  res_restricaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }


   /**
     * @return the res_restricaoConsult
     */
    public Res_restricaoConsultGWT getRes_restricaoConsult() {
        return res_restricaoConsult;
    }

    /**
     * @param res_restricaoConsult the res_restricaoConsult to set
     */
    public void setRes_restricaoConsult(Res_restricaoConsultGWT res_restricaoConsult) {
        this.res_restricaoConsult = res_restricaoConsult;
    }

}

