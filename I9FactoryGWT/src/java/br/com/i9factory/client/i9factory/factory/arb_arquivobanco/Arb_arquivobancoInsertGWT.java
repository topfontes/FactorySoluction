/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.arb_arquivobanco;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

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
public class Arb_arquivobancoInsertGWT extends CadastrarBaseGWT {

    private Arb_arquivobancoConsultGWT arb_arquivobancoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Arb_arquivobancoDAOGWT arb_arquivobancoDao = new Arb_arquivobancoDAOGWT();
    private EasyTextField<String> arb_nr_id = new EasyTextField<String>();
    private DateField arb_dt_data = new DateField();
    private EasyTextField<String> arb_by_arquivo = new EasyTextField<String>();
    private EasyTextField<String> arb_tx_tipo = new EasyTextField<String>();

    public Arb_arquivobancoInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        LabelField lfarb_nr_id = new LabelField("arb_nr_id:");
        lfarb_nr_id.setId("lfarb_nr_id");
        getCpMaster().add(lfarb_nr_id);
        arb_nr_id.setId("arb_nr_id");
        arb_nr_id.setMaxLength(10);
        getCpMaster().add(arb_nr_id);

        LabelField lfarb_dt_data = new LabelField("arb_dt_data:");
        lfarb_dt_data.setId("lfarb_dt_data");
        getCpMaster().add(lfarb_dt_data);
        arb_dt_data.setId("arb_dt_data");
        arb_dt_data.setMaxLength(29);
        getCpMaster().add(arb_dt_data);

        LabelField lfarb_by_arquivo = new LabelField("arb_by_arquivo:");
        lfarb_by_arquivo.setId("lfarb_by_arquivo");
        getCpMaster().add(lfarb_by_arquivo);
        arb_by_arquivo.setId("arb_by_arquivo");        
        getCpMaster().add(arb_by_arquivo);

        LabelField lfarb_tx_tipo = new LabelField("arb_tx_tipo:");
        lfarb_tx_tipo.setId("lfarb_tx_tipo");
        getCpMaster().add(lfarb_tx_tipo);
        arb_tx_tipo.setId("arb_tx_tipo");
        arb_tx_tipo.setMaxLength(3);
        getCpMaster().add(arb_tx_tipo);


    }

    public void btnInsertAction(ButtonEvent ce) {
        Arb_arquivobancoTGWT arb_arquivobancoT = new Arb_arquivobancoTGWT();
        arb_arquivobancoT.setArb_nr_id(Integer.parseInt(arb_nr_id.getValue()));
        arb_arquivobancoT.setArb_dt_data(arb_dt_data.getValue());
        
        arb_arquivobancoT.setArb_tx_tipo(arb_tx_tipo.getValue());

        arb_arquivobancoDao.inserir(arb_arquivobancoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = arb_arquivobancoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        arb_arquivobancoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        arb_nr_id.setValue("");
        arb_dt_data.setValue(null);
        arb_by_arquivo.setValue("");
        arb_tx_tipo.setValue("");

    }

    /**
     * @return the arb_arquivobancoConsult
     */
    public Arb_arquivobancoConsultGWT getArb_arquivobancoConsult() {
        return arb_arquivobancoConsult;
    }

    /**
     * @param arb_arquivobancoConsult the arb_arquivobancoConsult to set
     */
    public void setArb_arquivobancoConsult(Arb_arquivobancoConsultGWT arb_arquivobancoConsult) {
        this.arb_arquivobancoConsult = arb_arquivobancoConsult;
    }
}
