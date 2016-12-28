/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.age_agenciador;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.ListTipoLogradouroGWT;
import br.com.i9factory.client.ListUF;
import br.com.i9factory.client.TipoLogradouroTGWT;
import br.com.i9factory.client.UFTGWT;
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
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.google.gwt.user.client.Element;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Age_agenciadorInsertGWT extends CadastrarBaseGWT {

    private Age_agenciadorConsultGWT age_agenciadorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Age_agenciadorDAOGWT age_agenciadorDao = new Age_agenciadorDAOGWT();
    private EasyTextField<String> age_nr_id = new EasyTextField<String>();
    private EasyTextField<String> age_tx_cpf = new EasyTextField<String>();
    private EasyTextField<String> age_tx_nome = new EasyTextField<String>();
    private DateField age_dt_cadastro = new DateField();
    private DateField age_dt_nascimento = new DateField();
    private EasyTextField<String> eqp_nr_id = new EasyTextField<String>();
    private EasyTextField<String> age_tx_tipologradouro = new EasyTextField<String>();
    private EasyTextField<String> age_tx_logradouro = new EasyTextField<String>();
    private EasyTextField<String> age_tx_numero = new EasyTextField<String>();
    private EasyTextField<String> age_tx_cep = new EasyTextField<String>();
    private EasyTextField<String> age_tx_complemento = new EasyTextField<String>();
    private EasyTextField<String> age_tx_bairro = new EasyTextField<String>();
    private EasyTextField<String> age_tx_municipio = new EasyTextField<String>();
    private EasyTextField<String> age_tx_uf = new EasyTextField<String>();
    private EasyTextField<String> age_tx_telefone2 = new EasyTextField<String>();
    private EasyTextField<String> age_tx_telefone2_1 = new EasyTextField<String>();
    private EasyTextField<String> age_tx_celular = new EasyTextField<String>();
    private EasyTextField<String> age_tx_email = new EasyTextField<String>();
    private EasyNumberField age_nr_taxaemprestimo = new EasyNumberField();
    private EasyNumberField age_nr_taxamensalidade = new EasyNumberField();
    private ListUF listUF = new ListUF();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();
    private ComboBox<TipoLogradouroTGWT> comboTipoLogradouro = new ComboBox<TipoLogradouroTGWT>();
    private ComboBox<Eqp_equipeTGWT> comboequipe = new ComboBox<Eqp_equipeTGWT>();
    private Eqp_equipeDAOGWT eqp_equipeDAOGWT = new Eqp_equipeDAOGWT();
    private DateTimeFormat dateTimeFormat;
    private ListTipoLogradouroGWT listTipoLogradouroGWT = new ListTipoLogradouroGWT();

    public Age_agenciadorInsertGWT() {
        this.setSize("570", "540");
        this.setHeading("Cadastro Agênciador");
        eqp_equipeDAOGWT.consultarTodos();
        listUF.povoa();

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);
        montarTela();
    }

    public void montarTela() {

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (eqp_equipeDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    age_tx_nome.setAllowBlank(false);
                    age_tx_nome.setWidth(350);
                    getCpMaster().add(new LabelField("Nome*:"));
                    age_tx_nome.setMaxLength(100);
                    getCpMaster().add(age_tx_nome);

                    age_tx_cpf.setMaxLength(14);
                    age_tx_cpf.setAllowBlank(false);
                    getCpMaster().add(new LabelField("CPF*:"));
                    getCpMaster().add(age_tx_cpf);

                    age_dt_nascimento.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Dt. Nascimento*:"));
                    getCpMaster().add(age_dt_nascimento);

                    addComboEquipe();
                    comboequipe.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Equipe*:"));
                    getCpMaster().add(comboequipe);

                    addComboTipoLogradouro();
                    comboTipoLogradouro.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Tipo Logradouro*:"));
                    getCpMaster().add(comboTipoLogradouro);

                    age_tx_logradouro.setWidth(350);
                    age_tx_logradouro.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Logradouro*:"));
                    age_tx_logradouro.setMaxLength(250);
                    getCpMaster().add(age_tx_logradouro);

                    age_tx_numero.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Número*:"));
                    age_tx_numero.setMaxLength(10);
                    getCpMaster().add(age_tx_numero);

                    age_tx_cep.setMaxLength(8);
                    age_tx_cep.setAllowBlank(false);
                    getCpMaster().add(new LabelField("CEP*:"));
                    age_tx_cep.setMaxLength(10);
                    getCpMaster().add(age_tx_cep);

                    age_tx_complemento.setWidth(350);
                    age_tx_complemento.setAllowBlank(true);
                    getCpMaster().add(new LabelField("Complemento:"));
                    age_tx_complemento.setMaxLength(250);
                    getCpMaster().add(age_tx_complemento);

                    age_tx_bairro.setWidth(350);
                    age_tx_bairro.setAllowBlank(false);
                    getCpMaster().add(new LabelField("Bairro*:"));
                    age_tx_bairro.setMaxLength(100);
                    getCpMaster().add(age_tx_bairro);

                    age_tx_municipio.setAllowBlank(false);
                    age_tx_municipio.setWidth(350);
                    getCpMaster().add(new LabelField("Município*:"));
                    age_tx_municipio.setMaxLength(100);
                    getCpMaster().add(age_tx_municipio);

                    addComboUF();
                    comboUF.setAllowBlank(false);
                    getCpMaster().add(new LabelField("UF*:"));
                    getCpMaster().add(comboUF);

                    getCpMaster().add(new LabelField("Telefones:"));

                    ContentPanel cpTel = new ContentPanel();
                    TableLayout lay = new TableLayout(3);
                    lay.setCellPadding(3);
                    cpTel.setLayout(lay);
                    cpTel.setHeaderVisible(false);
                    cpTel.setFrame(false);
                    cpTel.setBodyBorder(false);

                    age_tx_telefone2.setWidth(111);
                    age_tx_telefone2.setMaxLength(20);
                    cpTel.add(age_tx_telefone2);

                    age_tx_telefone2_1.setWidth(111);
                    age_tx_telefone2_1.setMaxLength(20);
                    cpTel.add(age_tx_telefone2_1);

                    age_tx_celular.setWidth(112);
                    age_tx_celular.setMaxLength(20);
                    cpTel.add(age_tx_celular);
                    getCpMaster().add(cpTel);

                    age_tx_email.setWidth(350);
                    age_tx_email.setAllowBlank(true);
                    getCpMaster().add(new LabelField("Email*:"));
                    age_tx_email.setMaxLength(20);
                    getCpMaster().add(age_tx_email);

                    age_nr_taxaemprestimo.setWidth(70);
                    age_nr_taxaemprestimo.setFormat(NumberFormat.getFormat("#,##0.00"));
                    age_nr_taxaemprestimo.setMaxLength(17);
                    getCpMaster().add(new LabelField("Taxa Emprestimmo*:"));

                    ContentPanel cpTaxa = new ContentPanel();
                    TableLayout layTaxa = new TableLayout(3);
                    layTaxa.setCellPadding(3);
                    cpTaxa.setLayout(layTaxa);
                    cpTaxa.setHeaderVisible(false);
                    cpTaxa.setFrame(false);
                    cpTaxa.setBodyBorder(false);

                    age_nr_taxaemprestimo.setAllowBlank(false);
                    age_nr_taxaemprestimo.setMaxLength(17);
                    cpTaxa.add(age_nr_taxaemprestimo);

                    age_nr_taxamensalidade.setWidth(70);
                    age_nr_taxamensalidade.setFormat(NumberFormat.getFormat("#,##0.00"));
                    cpTaxa.add(new LabelField("Taxa Mensalidade*:"));
                    age_nr_taxamensalidade.setAllowBlank(false);
                    age_nr_taxamensalidade.setMaxLength(17);
                    cpTaxa.add(age_nr_taxamensalidade);
                    getCpMaster().add(cpTaxa);
                    layout();

                }
            }
        };
        timer.schedule(500);
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

    public void addComboEquipe() {

        comboequipe.setStore(eqp_equipeDAOGWT.getList());
        comboequipe.setDisplayField("eqp_tx_nome");
        comboequipe.setValueField("eqp_nr_id");
        comboequipe.setAllowBlank(false);
        comboequipe.setWidth(300);
        comboequipe.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void addComboTipoLogradouro() {
        comboTipoLogradouro.setStore(listTipoLogradouroGWT.getList());
        comboTipoLogradouro.setDisplayField("display");
        comboTipoLogradouro.setValueField("value");
        comboTipoLogradouro.setAllowBlank(false);
        comboTipoLogradouro.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void btnInsertAction(ButtonEvent ce) {
        String msg = "";
        if (!age_tx_nome.validate()) {
            msg += "Nome é obrigatório.<br/>";
        }
        if (!age_tx_cpf.validate()) {
            msg += "CPF é obrigatório.<br/>";
        }
        if (!age_dt_nascimento.validate()) {
            msg += "Data Nascimento é obrigatório.<br/>";
        }
        if (!comboTipoLogradouro.validate()) {
            msg += "Tipo Logradouro é obrigatório.<br/>";
        }
        if (!age_tx_logradouro.validate()) {
            msg += "Logradouro é obrigatório.<br/>";
        }
        if (!age_tx_numero.validate()) {
            msg += "Numero é obrigatório.<br/>";
        }
        if (!age_tx_cep.validate()) {
            msg += "CEP é obrigatório.<br/>";
        }
        if (!age_tx_bairro.validate()) {
            msg += "Bairro é obrigatório.<br/>";
        }
        if (!age_tx_municipio.validate()) {
            msg += "Municipio é obrigatório.<br/>";
        }
        if (!age_tx_uf.validate()) {
            msg += "UF é obrigatório.<br/>";
        }
        if (!age_nr_taxaemprestimo.validate()) {
            msg += "Taxa Empréstimo é obrigatório.<br/>";
        }
        if (!age_nr_taxamensalidade.validate()) {
            msg += "Taxa Mensalidade é obrigatório.<br/>";
        }
        if (msg.trim().length() > 0) {
            MessageBox.alert("Problema na validação", msg, null);
        } else {
            Age_agenciadorTGWT age_agenciadorT = new Age_agenciadorTGWT();
            age_agenciadorT.setAge_tx_cpf(age_tx_cpf.getValue());
            age_agenciadorT.setAge_tx_nome(age_tx_nome.getValue());
            age_agenciadorT.setAge_dt_cadastro(age_dt_cadastro.getValue());
            age_agenciadorT.setAge_dt_nascimento(age_dt_nascimento.getValue());
            age_agenciadorT.setEqp_nr_id(comboequipe.getValue().getEqp_nr_id());
            age_agenciadorT.setAge_tx_tipologradouro(comboTipoLogradouro.getValue().getValue());
            age_agenciadorT.setAge_tx_logradouro(age_tx_logradouro.getValue());
            age_agenciadorT.setAge_tx_numero(age_tx_numero.getValue());
            age_agenciadorT.setAge_tx_cep(age_tx_cep.getValue());
            age_agenciadorT.setAge_tx_complemento(age_tx_complemento.getValue());
            age_agenciadorT.setAge_tx_bairro(age_tx_bairro.getValue());
            age_agenciadorT.setAge_tx_municipio(age_tx_municipio.getValue());
            age_agenciadorT.setAge_tx_uf(comboUF.getValue().getValue());
            age_agenciadorT.setAge_tx_telefone2(age_tx_telefone2.getValue());
            age_agenciadorT.setAge_tx_telefone2_1(age_tx_telefone2_1.getValue());
            age_agenciadorT.setAge_tx_celular(age_tx_celular.getValue());
            age_agenciadorT.setAge_tx_email(age_tx_email.getValue());
            age_agenciadorT.setAge_nr_taxaemprestimo(age_nr_taxaemprestimo.getValue().floatValue());
            age_agenciadorT.setAge_nr_taxamensalidade(age_nr_taxamensalidade.getValue().floatValue());

            age_agenciadorDao.inserir(age_agenciadorT);
            Timer timer = new Timer() {

                public void run() {
                    String msg = age_agenciadorDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            btnLimpartAction(null);
                            age_agenciadorConsult.load();
                            setVisible(false);
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void btnLimpartAction(ButtonEvent ce) {
        age_nr_id.setValue("");
        age_tx_cpf.setValue("");
        age_tx_nome.setValue("");
        age_dt_cadastro.setValue(null);
        age_dt_nascimento.setValue(null);
        eqp_nr_id.setValue("");
        age_tx_tipologradouro.setValue("");
        age_tx_logradouro.setValue("");
        age_tx_numero.setValue("");
        age_tx_cep.setValue("");
        age_tx_complemento.setValue("");
        age_tx_bairro.setValue("");
        age_tx_municipio.setValue("");
        age_tx_uf.setValue("");
        age_tx_telefone2.setValue("");
        age_tx_telefone2_1.setValue("");
        age_tx_celular.setValue("");
        age_tx_email.setValue("");
        age_nr_taxaemprestimo.setValue(null);
        age_nr_taxamensalidade.setValue(null);

    }

    /**
     * @return the age_agenciadorConsult
     */
    public Age_agenciadorConsultGWT getAge_agenciadorConsult() {
        return age_agenciadorConsult;
    }

    /**
     * @param age_agenciadorConsult the age_agenciadorConsult to set
     */
    public void setAge_agenciadorConsult(Age_agenciadorConsultGWT age_agenciadorConsult) {
        this.age_agenciadorConsult = age_agenciadorConsult;
    }
}
