/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.ped_percentual_desconto;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;

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
public class Ped_percentual_descontoInsertGWT extends CadastrarBaseGWT {

    private Ped_percentual_descontoConsultGWT ped_percentual_descontoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Ped_percentual_descontoDAOGWT ped_percentual_descontoDao = new Ped_percentual_descontoDAOGWT();
    private EasyTextField<String> ped_nr_id = new EasyTextField<String>();
    private EasyNumberField ped_nr_parcela = new EasyNumberField();
    private EasyNumberField ped_nr_desconto = new EasyNumberField();

    public Ped_percentual_descontoInsertGWT() {
        this.setSize("300", "160");
        this.setHeading("Cadastrar Percentual Desconto");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        LabelField lfped_nr_parcela = new LabelField("Número Parcelas:");
        lfped_nr_parcela.setId("lfped_nr_parcela");
        getCpMaster().add(lfped_nr_parcela);
        ped_nr_parcela.setId("ped_nr_parcela");
        ped_nr_parcela.setMaxLength(10);
        getCpMaster().add(ped_nr_parcela);
        ped_nr_parcela.setAllowBlank(false);

        LabelField lfped_nr_desconto = new LabelField("% Desconto:");
        lfped_nr_desconto.setId("lfped_nr_desconto");
        getCpMaster().add(lfped_nr_desconto);
        ped_nr_desconto.setId("ped_nr_desconto");
        ped_nr_desconto.setMaxLength(10);
        getCpMaster().add(ped_nr_desconto);
        ped_nr_desconto.setAllowBlank(false);

    }

    public void btnInsertAction(ButtonEvent ce) {
        Ped_percentual_descontoTGWT ped_percentual_descontoT = new Ped_percentual_descontoTGWT();

        ped_percentual_descontoT.setPed_nr_parcela(ped_nr_parcela.getValue().intValue());
        ped_percentual_descontoT.setPed_nr_desconto(ped_nr_desconto.getValue().floatValue());

        ped_percentual_descontoDao.inserir(ped_percentual_descontoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = ped_percentual_descontoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        ped_percentual_descontoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        ped_nr_id.setValue("");
        ped_nr_parcela.setValue(null);
        ped_nr_desconto.setValue(null);

    }

    /**
     * @return the ped_percentual_descontoConsult
     */
    public Ped_percentual_descontoConsultGWT getPed_percentual_descontoConsult() {
        return ped_percentual_descontoConsult;
    }

    /**
     * @param ped_percentual_descontoConsult the ped_percentual_descontoConsult to set
     */
    public void setPed_percentual_descontoConsult(Ped_percentual_descontoConsultGWT ped_percentual_descontoConsult) {
        this.ped_percentual_descontoConsult = ped_percentual_descontoConsult;
    }
}
