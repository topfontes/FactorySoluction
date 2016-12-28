/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.idc_indice;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Idc_indiceInsertGWT extends CadastrarBaseGWT {

    private Idc_indiceConsultGWT idc_indiceConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Idc_indiceDAOGWT idc_indiceDao = new Idc_indiceDAOGWT();
    private TextField<String> idc_nr_id = new TextField<String>();
    private EasyNumberField idc_nr_diainicial = new EasyNumberField();
    private EasyNumberField idc_nr_diafinal = new EasyNumberField();
    private EasyNumberField idc_nr_qtdparcelas = new EasyNumberField();
    private EasyNumberField idc_nr_valor = new EasyNumberField();
    private Idc_indiceDAOGWT idaogwt = new Idc_indiceDAOGWT();
    private MessageBox mb = new MessageBox();

    public Idc_indiceInsertGWT() {
        this.setSize("250", "200");
        this.setHeading("Cadastro de Indíces");

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);
        idaogwt.consultarTodos();


        idc_nr_diainicial.setAllowBlank(false);
        idc_nr_diainicial.setFormat(NumberFormat.getFormat("00"));

        idc_nr_diainicial.setWidth(70);
        getCpMaster().add(new LabelField("Dia inícial*:"));
        idc_nr_diainicial.setMaxLength(2);
        getCpMaster().add(idc_nr_diainicial);

        idc_nr_diafinal.setAllowBlank(false);
        idc_nr_diafinal.setWidth(70);
        idc_nr_diafinal.setFormat(NumberFormat.getFormat("00"));
        getCpMaster().add(new LabelField("Dia Final*:"));
        idc_nr_diafinal.setMaxLength(2);
        getCpMaster().add(idc_nr_diafinal);

        idc_nr_qtdparcelas.setAllowBlank(false);
        idc_nr_qtdparcelas.setWidth(70);
        idc_nr_qtdparcelas.setFormat(NumberFormat.getFormat("00"));
        idc_nr_qtdparcelas.setMaxLength(3);
        getCpMaster().add(new LabelField("Qtde. Parcelas*:"));
        getCpMaster().add(idc_nr_qtdparcelas);

        idc_nr_valor.setAllowBlank(false);
        idc_nr_valor.setWidth(100);
        idc_nr_valor.setMaxLength(17);
        getCpMaster().add(new LabelField("Indice*:"));
        getCpMaster().add(idc_nr_valor);

    }

    public void btnInsertAction(ButtonEvent ce) {
        String msg = "";
        if (!idc_nr_diainicial.validate()) {
            msg += "Dia Inicial é obrigatório";
        }
        if (!idc_nr_diafinal.validate()) {
            msg += "Dia Final é obrigatório";
        }
        if (!idc_nr_qtdparcelas.validate()) {
            msg += "Quantidade de Parcelas é obrigatório";
        }
        if (!idc_nr_valor.validate()) {
            msg += "Valor é obrigatório";
        }
        if (msg.trim().length() > 0) {
            MessageBox.alert("Problemas na validação", msg, null);
        } else {
            if (valido()) {
                Idc_indiceTGWT idc_indiceT = new Idc_indiceTGWT();
                idc_indiceT.setIdc_nr_diainicial(idc_nr_diainicial.getValue().intValue());
                idc_indiceT.setIdc_nr_diafinal(idc_nr_diafinal.getValue().intValue());
                idc_indiceT.setIdc_nr_qtdparcelas(idc_nr_qtdparcelas.getValue().intValue());
                idc_indiceT.setIdc_nr_valor(idc_nr_valor.getValue().floatValue());

                idc_indiceDao.inserir(idc_indiceT);
                Timer timer = new Timer() {

                    public void run() {
                        String msg = idc_indiceDao.getMsg();
                        if (msg == null) {
                            schedule(500);
                        } else {
                            if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                MessageBox.alert("Problemas", msg, null);
                            } else {
                                Info.display("Resultado", msg);
                                btnLimpartAction(null);
                                idc_indiceConsult.load();
                                setVisible(false);
                            }
                        }
                    }
                };
                timer.schedule(500);
            }
        }
    }

    public boolean valido() {
        ListStore<Idc_indiceTGWT> list = idaogwt.getList();
        boolean res = true;
        int dia_inicio = idc_nr_diainicial.getValue().intValue();
        int dia_fim = idc_nr_diafinal.getValue().intValue();
        if (dia_inicio > dia_fim) {
            mb.alert("ATENÇÃO", "Dia Inícial estar maior que o dia Final", null);
            res = false;
        } else {
            for (Idc_indiceTGWT idc_indiceTGWT : list.getModels()) {
                if (dia_inicio >= idc_indiceTGWT.getIdc_nr_diainicial() & dia_inicio <= idc_indiceTGWT.getIdc_nr_diafinal() & idc_nr_qtdparcelas.getValue().intValue() == idc_indiceTGWT.getIdc_nr_qtdparcelas()) {
                    res = false;
                    mb.alert("ATENÇÃO", "Dia Incial está entre a faxa do indíce " + idc_indiceTGWT.getIdc_nr_diainicial() + " a " + idc_indiceTGWT.getIdc_nr_diafinal(), null);
                }
            }
        }
        return res;
    }

    public void btnLimpartAction(ButtonEvent ce) {
        idc_nr_diainicial.setValue(null);
        idc_nr_diafinal.setValue(null);
        idc_nr_qtdparcelas.setValue(null);
        idc_nr_valor.setValue(null);
    }

    /**
     * @return the idc_indiceConsult
     */
    public Idc_indiceConsultGWT getIdc_indiceConsult() {
        return idc_indiceConsult;
    }

    /**
     * @param idc_indiceConsult the idc_indiceConsult to set
     */
    public void setIdc_indiceConsult(Idc_indiceConsultGWT idc_indiceConsult) {
        this.idc_indiceConsult = idc_indiceConsult;
    }
}
