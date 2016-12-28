/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.tid_tipo_despesa;

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
public class Tid_tipo_despesaInsertGWT extends CadastrarBaseGWT {

    private Tid_tipo_despesaConsultGWT tid_tipo_despesaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tid_tipo_despesaDAOGWT tid_tipo_despesaDao = new Tid_tipo_despesaDAOGWT();
    private TextField<String> tid_nr_id = new TextField<String>();
    private TextField<String> tid_tx_nome = new TextField<String>();

    public Tid_tipo_despesaInsertGWT() {
        this.setSize("470", "120");
        this.setHeading("Cadastro Tipo de Despesa");

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        tid_tx_nome.setWidth(300);
        tid_tx_nome.setAllowBlank(false);
        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(tid_tx_nome);

    }

    public void btnInsertAction(ButtonEvent ce) {
        Tid_tipo_despesaTGWT tid_tipo_despesaT = new Tid_tipo_despesaTGWT();

        tid_tipo_despesaT.setTid_tx_nome(tid_tx_nome.getValue());

        tid_tipo_despesaDao.inserir(tid_tipo_despesaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = tid_tipo_despesaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        tid_tipo_despesaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        tid_nr_id.setValue("");
        tid_tx_nome.setValue("");

    }

    /**
     * @return the tid_tipo_despesaConsult
     */
    public Tid_tipo_despesaConsultGWT getTid_tipo_despesaConsult() {
        return tid_tipo_despesaConsult;
    }

    /**
     * @param tid_tipo_despesaConsult the tid_tipo_despesaConsult to set
     */
    public void setTid_tipo_despesaConsult(Tid_tipo_despesaConsultGWT tid_tipo_despesaConsult) {
        this.tid_tipo_despesaConsult = tid_tipo_despesaConsult;
    }
}
