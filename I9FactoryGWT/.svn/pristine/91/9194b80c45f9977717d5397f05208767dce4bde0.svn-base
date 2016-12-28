/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.ple_parcelaemprestimo;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9factory.client.i9factory.factory.emp_emprestimo.Emp_emprestimoConsultGWT;
import br.com.i9factory.client.i9factory.factory.vw_parcelas.Vw_parcelasConsultGWT;

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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Ple_parcelaemprestimoInsertGWT extends CadastrarBaseGWT {

    private Ple_parcelaemprestimoConsultGWT ple_parcelaemprestimoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Ple_parcelaemprestimoDAOGWT ple_parcelaemprestimoDao = new Ple_parcelaemprestimoDAOGWT();
    private TextField<String> ple_nr_id = new TextField<String>();
//    private TextField<String> emp_nr_id = new TextField<String>();
    private DateField ple_dt_vencimento = new DateField();
    private DateField ple_dt_pagamento = new DateField();
    private EasyNumberField ple_nr_valorparcela = new EasyNumberField();
    private TextField<String> ple_nr_valordesconto = new TextField<String>();
    private TextField<String> ple_nr_cdformapagto = new TextField<String>();
    private TextField<String> ple_tx_parcela = new TextField<String>();
    private Vw_parcelasConsultGWT vw_parcelasConsultGWT;
    private RadioGroup rdgTipo = new RadioGroup();
    private Radio rdParcelas = new Radio();
    private Radio rdMensalidade = new Radio();
    private int emp_nr_id;
    private Emp_emprestimoConsultGWT emp_emprestimoConsultGWT;
    private TextArea tx_obs = new TextArea();

    public Ple_parcelaemprestimoInsertGWT(int emp_nr_id, Emp_emprestimoConsultGWT emp_emprestimoConsultGWT) {

        this.emp_emprestimoConsultGWT = emp_emprestimoConsultGWT;
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        this.emp_nr_id = emp_nr_id;
        this.setHeading("Cadastro Títulos a Receber");
        this.setSize("600", "250");

        rdMensalidade.setBoxLabel("Mensalidade");
        rdParcelas.setBoxLabel("Parcela");
        rdgTipo.add(rdParcelas);
        rdgTipo.add(rdMensalidade);
        rdgTipo.setValue(rdParcelas);

        getCpMaster().add(new LabelField("Tipo:"));
        getCpMaster().add(rdgTipo);

        getCpMaster().add(new LabelField("Vencimento:"));
        getCpMaster().add(ple_dt_vencimento);

        getCpMaster().add(new LabelField("Parcela:"));
        getCpMaster().add(ple_tx_parcela);

        getCpMaster().add(new LabelField("valor:"));
        getCpMaster().add(ple_nr_valorparcela);

        getCpMaster().add(new LabelField("Obs:"));
        getCpMaster().add(tx_obs);
        tx_obs.setHeight(40);
        tx_obs.setWidth(350);
        layout();

    }

    public void btnInsertAction(ButtonEvent ce) {
        Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT = new Ple_parcelaemprestimoTGWT();
        ple_parcelaemprestimoT.setEmp_nr_id(emp_nr_id);
        ple_parcelaemprestimoT.setPle_dt_vencimento(ple_dt_vencimento.getValue());
        ple_parcelaemprestimoT.setPle_nr_valorparcela(ple_nr_valorparcela.getValue().floatValue());
        ple_parcelaemprestimoT.setPle_tx_tipo(rdgTipo.getValue() == rdMensalidade ? "M" : "P");
        ple_parcelaemprestimoT.setPle_tx_parcela(ple_tx_parcela.getValue());
        ple_parcelaemprestimoT.setPle_tx_historico(tx_obs.getValue());
        ple_parcelaemprestimoDao.inserir(ple_parcelaemprestimoT);
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
                        btnLimpartAction(null);
                        emp_emprestimoConsultGWT.povoaParcela(emp_nr_id);
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        ple_nr_id.setValue("");
        ple_dt_vencimento.setValue(null);
        ple_dt_pagamento.setValue(null);
        ple_nr_valorparcela.setValue(null);
        ple_nr_valordesconto.setValue("");
        ple_nr_cdformapagto.setValue("");

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
