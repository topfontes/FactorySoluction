/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.org_orgao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.ListTipoLogradouroGWT;
import br.com.i9factory.client.ListUF;
import br.com.i9factory.client.TipoLogradouroTGWT;
import br.com.i9factory.client.UFTGWT;

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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Org_orgaoInsertGWT extends CadastrarBaseGWT {

    private Org_orgaoConsultGWT org_orgaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Org_orgaoDAOGWT org_orgaoDao = new Org_orgaoDAOGWT();
    private EasyTextField<String> org_nr_id = new EasyTextField<String>();
    private EasyTextField<String> org_tx_cnpj = new EasyTextField<String>();
    private EasyTextField<String> org_tx_razaosocial = new EasyTextField<String>();
    private EasyTextField<String> org_tx_nomefantasia = new EasyTextField<String>();
    private EasyTextField<String> org_tx_inscestadual = new EasyTextField<String>();
    private EasyTextField<String> org_tx_tipologradouro = new EasyTextField<String>();
    private EasyTextField<String> org_tx_logradouro = new EasyTextField<String>();
    private EasyTextField<String> org_tx_numero = new EasyTextField<String>();
    private EasyTextField<String> org_tx_cep = new EasyTextField<String>();
    private EasyTextField<String> org_tx_complemento = new EasyTextField<String>();
    private EasyTextField<String> org_tx_bairro = new EasyTextField<String>();
    private EasyTextField<String> org_tx_municipio = new EasyTextField<String>();
    private EasyTextField<String> org_tx_uf = new EasyTextField<String>();
    private EasyTextField<String> org_tx_telefone1 = new EasyTextField<String>();
    private EasyTextField<String> org_tx_telefone2 = new EasyTextField<String>();
    private ListTipoLogradouroGWT listTipoLogradouroGWT = new ListTipoLogradouroGWT();
    private ComboBox<TipoLogradouroTGWT> comboTipoLogradouro = new ComboBox<TipoLogradouroTGWT>();
    private ListUF listUF = new ListUF();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();

    public Org_orgaoInsertGWT() {
        this.setSize("600", "480");
        this.setHeading("Cadastro de Orgãos");
        listUF.povoa();

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);


        org_tx_razaosocial.setAllowBlank(false);
        org_tx_razaosocial.setWidth(350);
        org_tx_razaosocial.setMaxLength(100);
        getCpMaster().add(new LabelField("Razão Social*:"));
        getCpMaster().add(org_tx_razaosocial);

        org_tx_nomefantasia.setWidth(350);
        org_tx_nomefantasia.setAllowBlank(false);
        org_tx_nomefantasia.setMaxLength(100);
        getCpMaster().add(new LabelField("Nome Fantasia*:"));
        getCpMaster().add(org_tx_nomefantasia);

        org_tx_cnpj.setAllowBlank(false);
        org_tx_cnpj.setMaxLength(14);
        getCpMaster().add(new LabelField("CNPJ*:"));
        org_tx_cnpj.setMaxLength(14);
        getCpMaster().add(org_tx_cnpj);

        getCpMaster().add(new LabelField("Insc. Estadual:"));
        org_tx_inscestadual.setMaxLength(10);
        getCpMaster().add(org_tx_inscestadual);

        org_tx_cep.setAllowBlank(false);
        getCpMaster().add(new LabelField("CEP*:"));
        org_tx_cep.setMaxLength(10);
        getCpMaster().add(org_tx_cep);

        addComboTipoLogradouro();
        getCpMaster().add(new LabelField("Tipo Logradouro*:"));
        getCpMaster().add(comboTipoLogradouro);

        org_tx_logradouro.setWidth(350);
        org_tx_logradouro.setAllowBlank(false);
        getCpMaster().add(new LabelField("Logradouro*:"));
        org_tx_logradouro.setMaxLength(200);
        getCpMaster().add(org_tx_logradouro);

        org_tx_numero.setAllowBlank(false);
        getCpMaster().add(new LabelField("Número*:"));
        org_tx_numero.setMaxLength(10);
        getCpMaster().add(org_tx_numero);

        org_tx_complemento.setWidth(350);
        getCpMaster().add(new LabelField("Complemento:"));
        org_tx_complemento.setMaxLength(300);
        getCpMaster().add(org_tx_complemento);

        org_tx_bairro.setAllowBlank(false);
        org_tx_bairro.setWidth(350);
        getCpMaster().add(new LabelField("Bairro*:"));
        org_tx_bairro.setMaxLength(100);
        getCpMaster().add(org_tx_bairro);

        org_tx_municipio.setWidth(350);
        org_tx_municipio.setAllowBlank(false);
        getCpMaster().add(new LabelField("Município*:"));
        org_tx_municipio.setMaxLength(100);
        getCpMaster().add(org_tx_municipio);

        addComboUF();
        getCpMaster().add(new LabelField("UF*:"));
        getCpMaster().add(comboUF);

        org_tx_telefone1.setAllowBlank(false);
        getCpMaster().add(new LabelField("Telefone(01)*:"));
        org_tx_telefone1.setMaxLength(20);
        getCpMaster().add(org_tx_telefone1);

        getCpMaster().add(new LabelField("Telefone(02):"));
        org_tx_telefone2.setMaxLength(20);
        getCpMaster().add(org_tx_telefone2);
        layout();
    }

    public void addComboTipoLogradouro() {
        comboTipoLogradouro.setStore(listTipoLogradouroGWT.getList());
        comboTipoLogradouro.setDisplayField("display");
        comboTipoLogradouro.setValueField("value");
        comboTipoLogradouro.setAllowBlank(false);
        comboTipoLogradouro.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void addComboUF() {
        ListStore<UFTGWT> store = new ListStore<UFTGWT>();
        store.add(listUF.getList());
        comboUF.setStore(store);
        comboUF.setDisplayField("display");
        comboUF.setDisplayField("value");
        comboUF.setAllowBlank(false);
        comboUF.setWidth(200);
        comboUF.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void btnInsertAction(ButtonEvent ce) {
        String msg = "";
        if (!org_tx_razaosocial.validate()) {
            msg += "Razao social é obrigatório</br>";
        }
        if (!org_tx_nomefantasia.validate()) {
            msg += "Nome Fantasia é obrigatório</br>";
        }
        if (!org_tx_cnpj.validate()) {
            msg += "CNPJ é obrigatório</br>";
        }
        if (!org_tx_cep.validate()) {
            msg += "CEP é obrigatório</br>";
        }
        if (!org_tx_tipologradouro.validate()) {
            msg += "Tipo Logradouro é obrigatório</br>";
        }
        if (!org_tx_logradouro.validate()) {
            msg += "Logradouro é obrigatório</br>";
        }
        if (!org_tx_numero.validate()) {
            msg += "Numero é obrigatório</br>";
        }
        if (!org_tx_bairro.validate()) {
            msg += "Bairro é obrigatório</br>";
        }
        if (!org_tx_municipio.validate()) {
            msg += "Municipio é obrigatório</br>";
        }
        if (!org_tx_uf.validate()) {
            msg += "UF é obrigatório</br>";
        }
        if (!org_tx_telefone1.validate()) {
            msg += "Telefone(1) é obrigatório</br>";
        }
        if (msg.trim().length() > 0) {
            MessageBox.alert("Problemas na validação", msg, null);
        } else {
            Org_orgaoTGWT org_orgaoT = new Org_orgaoTGWT();
            org_orgaoT.setOrg_tx_cnpj(org_tx_cnpj.getValue());
            org_orgaoT.setOrg_tx_razaosocial(org_tx_razaosocial.getValue());
            org_orgaoT.setOrg_tx_nomefantasia(org_tx_nomefantasia.getValue());
            org_orgaoT.setOrg_tx_inscestadual(org_tx_inscestadual.getValue());
            org_orgaoT.setOrg_tx_tipologradouro(comboTipoLogradouro.getValue().getValue());
            org_orgaoT.setOrg_tx_logradouro(org_tx_logradouro.getValue());
            org_orgaoT.setOrg_tx_numero(org_tx_numero.getValue());
            org_orgaoT.setOrg_tx_cep(org_tx_cep.getValue());
            org_orgaoT.setOrg_tx_complemento(org_tx_complemento.getValue());
            org_orgaoT.setOrg_tx_bairro(org_tx_bairro.getValue());
            org_orgaoT.setOrg_tx_municipio(org_tx_municipio.getValue());
            org_orgaoT.setOrg_tx_uf(comboUF.getValue().getValue());
            org_orgaoT.setOrg_tx_telefone1(org_tx_telefone1.getValue());
            org_orgaoT.setOrg_tx_telefone2(org_tx_telefone2.getValue());

            org_orgaoDao.inserir(org_orgaoT);
            Timer timer = new Timer() {

                public void run() {
                    String msg = org_orgaoDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            btnLimpartAction(null);
                            org_orgaoConsult.load();
                            setVisible(false);
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void btnLimpartAction(ButtonEvent ce) {
        org_nr_id.setValue("");
        org_tx_cnpj.setValue("");
        org_tx_razaosocial.setValue("");
        org_tx_nomefantasia.setValue("");
        org_tx_inscestadual.setValue("");
        org_tx_tipologradouro.setValue("");
        org_tx_logradouro.setValue("");
        org_tx_numero.setValue("");
        org_tx_cep.setValue("");
        org_tx_complemento.setValue("");
        org_tx_bairro.setValue("");
        org_tx_municipio.setValue("");
        org_tx_uf.setValue("");
        org_tx_telefone1.setValue("");
        org_tx_telefone2.setValue("");

    }

    /**
     * @return the org_orgaoConsult
     */
    public Org_orgaoConsultGWT getOrg_orgaoConsult() {
        return org_orgaoConsult;
    }

    /**
     * @param org_orgaoConsult the org_orgaoConsult to set
     */
    public void setOrg_orgaoConsult(Org_orgaoConsultGWT org_orgaoConsult) {
        this.org_orgaoConsult = org_orgaoConsult;
    }
}
