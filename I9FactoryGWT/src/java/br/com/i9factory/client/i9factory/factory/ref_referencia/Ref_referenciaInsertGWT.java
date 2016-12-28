/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.ref_referencia;

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
public class Ref_referenciaInsertGWT extends CadastrarBaseGWT {

    private Ref_referenciaConsultGWT ref_referenciaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Ref_referenciaDAOGWT ref_referenciaDao = new Ref_referenciaDAOGWT();
    private TextField<String> ref_nr_id = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> ref_tx_nome = new TextField<String>();
    private TextField<String> ref_tx_telefone = new TextField<String>();
    private TextField<String> ref_tx_celular = new TextField<String>();
    private Cli_clienteTGWT cli_clienteTGWT;

    public Ref_referenciaInsertGWT(Cli_clienteTGWT cli_clienteTGWT) {

        this.setSize("500", "170");
        this.setHeading("Cadastro Referência - " + cli_clienteTGWT.getCli_tx_nome());
        this.cli_clienteTGWT = cli_clienteTGWT;
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        ref_tx_nome.setWidth(300);
        ref_tx_nome.setAllowBlank(false);
        ref_tx_nome.setMaxLength(100);
        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(ref_tx_nome);

        ref_tx_telefone.setAllowBlank(false);
        getCpMaster().add(new LabelField("Telefone:"));
        getCpMaster().add(ref_tx_telefone);

        getCpMaster().add(new LabelField("Celular:"));
        getCpMaster().add(ref_tx_celular);
    }

    public void btnInsertAction(ButtonEvent ce) {
        Ref_referenciaTGWT ref_referenciaT = new Ref_referenciaTGWT();
        ref_referenciaT.setCli_nr_id(cli_clienteTGWT.getCli_nr_id());
        ref_referenciaT.setRef_tx_nome(ref_tx_nome.getValue());
        ref_referenciaT.setRef_tx_telefone(ref_tx_telefone.getValue());
        if (ref_tx_celular.getValue() != null) {
            ref_referenciaT.setRef_tx_celular(ref_tx_celular.getValue());
        }

        ref_referenciaDao.inserir(ref_referenciaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = ref_referenciaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        ref_referenciaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        ref_nr_id.setValue("");
        cli_nr_id.setValue("");
        ref_tx_nome.setValue("");
        ref_tx_telefone.setValue("");
        ref_tx_celular.setValue("");

    }

    /**
     * @return the ref_referenciaConsult
     */
    public Ref_referenciaConsultGWT getRef_referenciaConsult() {
        return ref_referenciaConsult;
    }

    /**
     * @param ref_referenciaConsult the ref_referenciaConsult to set
     */
    public void setRef_referenciaConsult(Ref_referenciaConsultGWT ref_referenciaConsult) {
        this.ref_referenciaConsult = ref_referenciaConsult;
    }
}
