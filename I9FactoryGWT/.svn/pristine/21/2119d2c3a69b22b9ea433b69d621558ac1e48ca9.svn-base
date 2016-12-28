/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.eqp_equipe;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.component.EasyTextField;

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
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Eqp_equipeInsertGWT extends CadastrarBaseGWT {

    private Eqp_equipeConsultGWT eqp_equipeConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Eqp_equipeDAOGWT eqp_equipeDao = new Eqp_equipeDAOGWT();
    private EasyTextField<String> eqp_nr_id = new EasyTextField<String>();
    private EasyTextField<String> eqp_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> eqp_tx_descricao = new EasyTextField<String>();
    private EasyTextField<String> cor_nr_id = new EasyTextField<String>();
    private ComboBox<Cor_corretoraTGWT> comboCorretora = new ComboBox<Cor_corretoraTGWT>();
    private Cor_corretoraDAOGWT cor_corretoraDAOGWT = new Cor_corretoraDAOGWT();

    public Eqp_equipeInsertGWT() {
        this.setSize("470", "170");
        this.setHeading("Cadastro Equipes");
        cor_corretoraDAOGWT.consultarTodos();
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);
        montarTela();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (cor_corretoraDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    eqp_tx_nome.setWidth(300);
                    eqp_tx_nome.setAllowBlank(false);
                    eqp_tx_nome.setMaxLength(100);
                    getCpMaster().add(new LabelField("Equipe*:"));
                    getCpMaster().add(eqp_tx_nome);

                    eqp_tx_descricao.setWidth(300);
                    eqp_tx_descricao.setAllowBlank(false);
                    eqp_tx_nome.setMaxLength(250);
                    getCpMaster().add(new LabelField("Descrição*:"));
                    getCpMaster().add(eqp_tx_descricao);

                    addComboCorretora();
                    getCpMaster().add(new LabelField("Corretora*:"));
                    getCpMaster().add(comboCorretora);
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addComboCorretora() {
        comboCorretora.setStore(cor_corretoraDAOGWT.getList());
        comboCorretora.setDisplayField("cor_tx_nomefantasia");
        comboCorretora.setAllowBlank(false);
        comboCorretora.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboCorretora.setWidth(300);
    }

    public void btnInsertAction(ButtonEvent ce) {
        String msg = "";
        if (!eqp_tx_nome.validate()) {
            msg += "Nome é obrigatório<br/>";
        }
        if (!eqp_tx_descricao.validate()) {
            msg += "Descricao é obrigatório<br/>";
        }
        if (!comboCorretora.validate()) {
            msg += "Corretora é obrigatório<br/>";
        }
        if (msg.trim().length() > 0) {
            MessageBox.alert("Problemas na valicao", msg, null);
        } else {

            Eqp_equipeTGWT eqp_equipeT = new Eqp_equipeTGWT();
            eqp_equipeT.setEqp_tx_nome(eqp_tx_nome.getValue());
            eqp_equipeT.setEqp_tx_descricao(eqp_tx_descricao.getValue());
            eqp_equipeT.setCor_nr_id(comboCorretora.getValue().getCor_nr_id());

            eqp_equipeDao.inserir(eqp_equipeT);
            Timer timer = new Timer() {

                public void run() {
                    String msg = eqp_equipeDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            btnLimpartAction(null);
                            eqp_equipeConsult.load();
                            setVisible(false);
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void btnLimpartAction(ButtonEvent ce) {
        eqp_nr_id.setValue("");
        eqp_tx_nome.setValue("");
        eqp_tx_descricao.setValue("");
        cor_nr_id.setValue("");

    }

    /**
     * @return the eqp_equipeConsult
     */
    public Eqp_equipeConsultGWT getEqp_equipeConsult() {
        return eqp_equipeConsult;
    }

    /**
     * @param eqp_equipeConsult the eqp_equipeConsult to set
     */
    public void setEqp_equipeConsult(Eqp_equipeConsultGWT eqp_equipeConsult) {
        this.eqp_equipeConsult = eqp_equipeConsult;
    }
}
