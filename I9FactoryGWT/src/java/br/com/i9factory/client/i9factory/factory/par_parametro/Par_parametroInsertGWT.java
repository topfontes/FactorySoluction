/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.par_parametro;

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
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Par_parametroInsertGWT extends CadastrarBaseGWT {

    private Par_parametroConsultGWT par_parametroConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Par_parametroDAOGWT par_parametroDao = new Par_parametroDAOGWT();
    private EasyTextField<String> par_nr_id = new EasyTextField<String>();
    private EasyTextField<String> par_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> par_tx_valor = new EasyTextField<String>();
    private EasyTextField<String> par_tx_descricao = new EasyTextField<String>();

    public Par_parametroInsertGWT() {
        setHeading("Cadastrar Parametro");
        this.setSize("280", "200");
        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Nome:"));
        par_tx_nome.setMaxLength(100);
        getCpMaster().add(par_tx_nome);

        getCpMaster().add(new LabelField("Valor:"));
        par_tx_valor.setMaxLength(999);
        getCpMaster().add(par_tx_valor);

        getCpMaster().add(new LabelField("Descricao:"));
        par_tx_nome.setMaxLength(5000);
        getCpMaster().add(par_tx_descricao);


    }

    public void btnInsertAction(ButtonEvent ce) {
        Par_parametroTGWT par_parametroT = new Par_parametroTGWT();
        par_parametroT.setPar_tx_nome(par_tx_nome.getValue());
        par_parametroT.setPar_tx_valor(par_tx_valor.getValue());
        par_parametroT.setPar_tx_descricao(par_tx_descricao.getValue());

        par_parametroDao.inserir(par_parametroT);
        Timer timer = new Timer() {

            public void run() {
                String msg = par_parametroDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        par_parametroConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        par_tx_nome.setValue("");
        par_tx_valor.setValue("");
        par_tx_descricao.setValue("");
    }

    /**
     * @return the par_parametroConsult
     */
    public Par_parametroConsultGWT getPar_parametroConsult() {
        return par_parametroConsult;
    }

    /**
     * @param par_parametroConsult the par_parametroConsult to set
     */
    public void setPar_parametroConsult(Par_parametroConsultGWT par_parametroConsult) {
        this.par_parametroConsult = par_parametroConsult;
    }
}
