/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.ctp_conta_pagar;

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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.Timer;
//import org.apache.commons.collections.functors.ForClosure;

/**
 *
 * @author geoleite
 */
public class Ctp_conta_pagarInsertGWT extends CadastrarBaseGWT {

    private Ctp_conta_pagarConsultGWT ctp_conta_pagarConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Ctp_conta_pagarDAOGWT ctp_conta_pagarDao = new Ctp_conta_pagarDAOGWT();
    private TextField<String> ctp_nr_id = new TextField<String>();
    private TextField<String> ctp_nr_doc = new TextField<String>();
    private DateField ctp_dt_emissao = new DateField();
    private DateField ctp_dt_vencimento = new DateField();
    private TextField<String> ctp_tx_pago = new TextField<String>();
    private TextField<String> ctp_tx_parcela = new TextField<String>();
    private NumberField ctp_valor = new NumberField();
    private DateField ctp_dt_pagamento = new DateField();
    private TextField<String> ctp_vl_pago = new TextField<String>();
    private TextField<String> ctp_saldo = new TextField<String>();
    private TextField<String> for_nr_id = new TextField<String>();
    private TextField<String> ctp_tx_obs = new TextField<String>();
    private Tid_tipo_despesaDAOGWT tid_tipo_despesaDAOGWT = new Tid_tipo_despesaDAOGWT();
    private For_fornecedorDAOGWT for_fornecedorDAOGWT = new For_fornecedorDAOGWT();
    private ComboBox<Tid_tipo_despesaTGWT> comboTipo = new ComboBox<Tid_tipo_despesaTGWT>();
    private ComboBox<For_fornecedorTGWT> comboFor = new ComboBox<For_fornecedorTGWT>();

    public Ctp_conta_pagarInsertGWT() {
        for_fornecedorDAOGWT.consultarTodos();
        tid_tipo_despesaDAOGWT.consultarTodos();
        this.setSize("470", "330");
        this.setHeading("Cadastro contas a pagar");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);
        montaTela();
    }

    public void montaTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (for_fornecedorDAOGWT.getList() == null || tid_tipo_despesaDAOGWT.getList() == null) {
                    schedule(300);
                } else {
                    ctp_nr_doc.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Documento:"));
                    getCpMaster().add(ctp_nr_doc);

                    ctp_dt_emissao.getPropertyEditor().setFormat(dtfDate);
                    ctp_dt_emissao.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Dt.Emissão:"));
                    getCpMaster().add(ctp_dt_emissao);

                    ctp_dt_vencimento.getPropertyEditor().setFormat(dtfDate);
                    ctp_dt_vencimento.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Vencimento:"));
                    getCpMaster().add(ctp_dt_vencimento);

                    ctp_tx_parcela.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Parcela:"));
                    getCpMaster().add(ctp_tx_parcela);

                    ctp_valor.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Valor:"));
                    getCpMaster().add(ctp_valor);

                    ctp_tx_obs.setWidth(300);
                    getCpMaster().add(new LabelField("Obs:"));
                    getCpMaster().add(ctp_tx_obs);

                    addcomboFornec();
                    getCpMaster().add(new LabelField("Fornecedor:"));
                    getCpMaster().add(comboFor);

                    addcomboTipo();
                    getCpMaster().add(new LabelField("Tipo Despesa:"));
                    getCpMaster().add(comboTipo);
                    layout();

                }
            }
        };
        timer.schedule(500);
    }

    public void addcomboFornec() {
        comboFor.setStore(for_fornecedorDAOGWT.getList());
        comboFor.setDisplayField("for_tx_nome");
        comboFor.setAllowBlank(false);
        comboFor.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboFor.setWidth(300);
    }

    public void addcomboTipo() {
        comboTipo.setStore(tid_tipo_despesaDAOGWT.getList());
        comboTipo.setEmptyText("Selecione a Despesa");
        comboTipo.setDisplayField("tid_tx_nome");
        comboTipo.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboTipo.setWidth(300);
        layout();
    }

    public void btnInsertAction(ButtonEvent ce) {

        Ctp_conta_pagarTGWT ctp_conta_pagarT = new Ctp_conta_pagarTGWT();
        ctp_conta_pagarT.setCtp_nr_doc(Integer.parseInt(ctp_nr_doc.getValue()));
        ctp_conta_pagarT.setCtp_dt_emissao(ctp_dt_emissao.getValue());
        ctp_conta_pagarT.setCtp_dt_vencimento(ctp_dt_vencimento.getValue());
        ctp_conta_pagarT.setCtp_tx_pago("F");

        ctp_conta_pagarT.setCtp_tx_parcela(ctp_tx_parcela.getValue());
        ctp_conta_pagarT.setCtp_valor(ctp_valor.getValue().floatValue());
        if (ctp_dt_pagamento.getValue() != null) {
            ctp_conta_pagarT.setCtp_dt_pagamento(ctp_dt_pagamento.getValue());
        }
        ctp_conta_pagarT.setCtp_vl_pago(0);
        if (ctp_vl_pago.getValue() != null) {
            ctp_conta_pagarT.setCtp_vl_pago(Float.parseFloat(ctp_vl_pago.getValue()));
        }

        ctp_conta_pagarT.setCtp_saldo(ctp_valor.getValue().floatValue());
        ctp_conta_pagarT.setFor_nr_id(comboFor.getValue().getFor_nr_id());
        ctp_conta_pagarT.setTid_nr_id(comboTipo.getValue().getTid_nr_id());
        if (ctp_tx_obs.getValue() != null) {
            ctp_conta_pagarT.setCtp_tx_obs(ctp_tx_obs.getValue());
        }

        ctp_conta_pagarDao.inserir(ctp_conta_pagarT);
        Timer timer = new Timer() {

            public void run() {
                String msg = ctp_conta_pagarDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        ctp_conta_pagarConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        ctp_nr_id.setValue("");
        ctp_nr_doc.setValue("");
        ctp_dt_emissao.setValue(null);
        ctp_dt_vencimento.setValue(null);
        ctp_tx_pago.setValue("");
        ctp_tx_parcela.setValue("");
        ctp_valor.setValue(null);
        ctp_dt_pagamento.setValue(null);
        ctp_vl_pago.setValue("");
        ctp_saldo.setValue("");
        for_nr_id.setValue("");
        ctp_tx_obs.setValue("");

    }

    /**
     * @return the ctp_conta_pagarConsult
     */
    public Ctp_conta_pagarConsultGWT getCtp_conta_pagarConsult() {
        return ctp_conta_pagarConsult;
    }

    /**
     * @param ctp_conta_pagarConsult the ctp_conta_pagarConsult to set
     */
    public void setCtp_conta_pagarConsult(Ctp_conta_pagarConsultGWT ctp_conta_pagarConsult) {
        this.ctp_conta_pagarConsult = ctp_conta_pagarConsult;
    }
}
