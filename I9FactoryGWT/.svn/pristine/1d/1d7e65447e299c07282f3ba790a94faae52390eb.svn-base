package br.com.i9factory.client.i9factory.factory.ple_parcelaemprestimo;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.i9factory.client.i9factory.factory.emp_emprestimo.Emp_emprestimoConsultGWT;
import br.com.i9factory.client.i9factory.factory.vw_parcelas.Vw_parcelasConsultGWT;
import com.extjs.gxt.ui.client.data.MemoryProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;

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
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Ple_parcelaemprestimoUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Vw_parcelasConsultGWT vw_parcelasConsultGWT;
    private Ple_parcelaemprestimoConsultGWT ple_parcelaemprestimoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Ple_parcelaemprestimoDAOGWT ple_parcelaemprestimoDao = new Ple_parcelaemprestimoDAOGWT();
    private Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT;
    private TextField<String> ple_nr_id = new TextField<String>();
    private TextField<String> emp_nr_id = new TextField<String>();
    private DateField ple_dt_vencimento = new DateField();
    private DateField ple_dt_pagamento = new DateField();
    private EasyNumberField ple_nr_valorparcela = new EasyNumberField();
    private TextField<String> ple_nr_valordesconto = new TextField<String>();
    private TextField<String> ple_nr_cdformapagto = new TextField<String>();
    private TextArea tx_observacao = new TextArea();
    private TextField<String> ple_tx_parcela = new TextField<String>();
    private NumberFormat format = NumberFormat.getFormat("#,##0.00");
    private CheckBox chkvincular = new CheckBox();
    private ComboBox<Ple_parcelaemprestimoTGWT> cbParcelas = new ComboBox<Ple_parcelaemprestimoTGWT>();
    private ContentPanel cpCombo = new ContentPanel();
    private Emp_emprestimoConsultGWT emp_emprestimoConsultGWT;

    public Ple_parcelaemprestimoUpdateDeleteGWT() {
        this.setSize(520, 320);
        this.setHeading("Alterar Título");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        getCpMaster().add(new LabelField("Vencimento:"));
        ple_dt_vencimento.getPropertyEditor().setFormat(dtfDate);
        getCpMaster().add(ple_dt_vencimento);

        getCpMaster().add(new LabelField("Parcela:"));
        ple_tx_parcela.setEnabled(false);
        getCpMaster().add(ple_tx_parcela);

        getCpMaster().add(new LabelField("Valor:"));
        ple_nr_valorparcela.setFormat(format);
        getCpMaster().add(ple_nr_valorparcela);

        chkvincular.setBoxLabel("Vincular a parcela");
        getCpMaster().add(chkvincular);
        getCpMaster().add(cpCombo);

        tx_observacao.setWidth(360);
        tx_observacao.setHeight(110);
        getCpMaster().add(new LabelField("Observação:"));
        getCpMaster().add(tx_observacao);

        cpCombo.setHeaderVisible(false);
        cpCombo.setBodyBorder(false);
        layout();

        chkvincular.addListener(Events.Change, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                cbParcelas.setEnabled(chkvincular.getValue().booleanValue());
            }
        });

    }

    public void povoaCombo(int cli_nr_id) {
        final Ple_parcelaemprestimoDAOGWT ple_parcelaemprestimoDAOGWT = new Ple_parcelaemprestimoDAOGWT();
        ple_parcelaemprestimoDAOGWT.consultarTodosClienteVencidas(cli_nr_id, "P");
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Ple_parcelaemprestimoTGWT> store = ple_parcelaemprestimoDAOGWT.getList();
                if (store == null) {
                    schedule(300);
                } else {
                    cbParcelas.setDisplayField("ple_tx_parcela");
                    cbParcelas.setStore(store);
                    cbParcelas.setItemSelector("div.search-item");
                    cbParcelas.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbParcelas.setTemplate(getTemplate());
                    cpCombo.removeAll();
                    cbParcelas.setEnabled(false);
                    cpCombo.add(cbParcelas);
                    cbParcelas.setWidth(200);
                    if (ple_parcelaemprestimoT.getPle_nr_id_vinculo() > 0) {
                        cbParcelas.setValue(cbParcelas.getStore().findModel("ple_nr_id", ple_parcelaemprestimoT.getPle_nr_id_vinculo()));
                        chkvincular.setEnabled(true);
                        cbParcelas.setEnabled(true);
                    }
                    layout();
                }
            }
        };
        timer.schedule(300);
    }

    private native String getTemplate() /*-{
    return [
    '<tpl for="."><div class="search-item">',
    '<h3><span>{ple_tx_parcela}  </h3>  {ple_dt_vencimento:date("dd/MM/yyyy")}  Vl.: {ple_nr_valorparcela}</span> ',
    '</div></tpl>'
    ].join("");
    }-*/;

    public void load(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT, int cli_nr_id) {
        this.ple_parcelaemprestimoT = ple_parcelaemprestimoT;

        if (cli_nr_id > 0) {
            povoaCombo(cli_nr_id);
        } else {
            chkvincular.setEnabled(false);
        }

        ple_dt_vencimento.setValue(ple_parcelaemprestimoT.getPle_dt_vencimento());
        ple_nr_valorparcela.setValue(ple_parcelaemprestimoT.getPle_nr_valorparcela());
        ple_tx_parcela.setValue(ple_parcelaemprestimoT.getPle_tx_parcela());
        tx_observacao.setValue(ple_parcelaemprestimoT.getPle_tx_historico());
        ple_nr_valorparcela.focus();

    }

    public void btnUpdateAction(ButtonEvent ce) {
//        ple_parcelaemprestimoT.setPle_nr_id(Integer.parseInt(ple_nr_id.getValue()));
//        ple_parcelaemprestimoT.setEmp_nr_id(Integer.parseInt(emp_nr_id.getValue()));
        ple_parcelaemprestimoT.setPle_dt_vencimento(ple_dt_vencimento.getValue());
        ple_parcelaemprestimoT.setPle_nr_valorparcela(ple_nr_valorparcela.getValue().floatValue());
        ple_parcelaemprestimoT.setPle_tx_historico(tx_observacao.getValue() != null ? tx_observacao.getValue() : "");
        ple_parcelaemprestimoT.setPle_nr_valordesconto(0);
        ple_parcelaemprestimoT.setPle_nr_id_vinculo(0);
        if (cbParcelas.getValue() != null) {
            ple_parcelaemprestimoT.setPle_nr_id_vinculo(cbParcelas.getValue().getPle_nr_id());
        }
        ple_parcelaemprestimoDao.alterar(ple_parcelaemprestimoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = ple_parcelaemprestimoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        if (emp_emprestimoConsultGWT != null) {
                            emp_emprestimoConsultGWT.povoaParcela(ple_parcelaemprestimoT.getEmp_nr_id());
                        } else {
                            vw_parcelasConsultGWT.load();
                        }
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        ple_parcelaemprestimoDao.excluir(ple_parcelaemprestimoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = ple_parcelaemprestimoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        ple_parcelaemprestimoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the ple_parcelaemprestimoConsult
     */
    public Ple_parcelaemprestimoConsultGWT getPle_parcelaemprestimoConsult() {
        return ple_parcelaemprestimoConsult;
    }

    /**
     * @param ple_parcelaemprestimoConsult the ple_parcelaemprestimoConsult to set
     */
    public void setPle_parcelaemprestimoConsult(Ple_parcelaemprestimoConsultGWT ple_parcelaemprestimoConsult) {
        this.ple_parcelaemprestimoConsult = ple_parcelaemprestimoConsult;
    }

    /**
     * @return the vw_parcelasConsultGWT
     */
    public Vw_parcelasConsultGWT getVw_parcelasConsultGWT() {
        return vw_parcelasConsultGWT;
    }

    /**
     * @param vw_parcelasConsultGWT the vw_parcelasConsultGWT to set
     */
    public void setVw_parcelasConsultGWT(Vw_parcelasConsultGWT vw_parcelasConsultGWT) {
        this.vw_parcelasConsultGWT = vw_parcelasConsultGWT;
    }

    /**
     * @return the emp_emprestimoConsultGWT
     */
    public Emp_emprestimoConsultGWT getEmp_emprestimoConsultGWT() {
        return emp_emprestimoConsultGWT;
    }

    /**
     * @param emp_emprestimoConsultGWT the emp_emprestimoConsultGWT to set
     */
    public void setEmp_emprestimoConsultGWT(Emp_emprestimoConsultGWT emp_emprestimoConsultGWT) {
        this.emp_emprestimoConsultGWT = emp_emprestimoConsultGWT;
    }
}
