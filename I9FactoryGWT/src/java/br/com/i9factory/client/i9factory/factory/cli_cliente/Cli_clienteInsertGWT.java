/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.cli_cliente;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.easynet.gwt.client.util.ValidacaoCPFCNPJ;
import br.com.i9factory.client.ListTipoLogradouroGWT;
import br.com.i9factory.client.ListUF;
import br.com.i9factory.client.TipoLogradouroTGWT;
import br.com.i9factory.client.UFTGWT;
import br.com.i9factory.client.i9factory.factory.emp_emprestimo.Emp_emprestimoInsertGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Bco_bancoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cco_contacorrenteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Org_orgaoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Tmp_tipomensalidadeTGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import java.util.Date;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Cli_clienteInsertGWT extends CadastrarBaseGWT implements IListenetResponse {

    private Cli_clienteConsultGWT cli_clienteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Cli_clienteDAOGWT cli_clienteDao = new Cli_clienteDAOGWT();
    private EasyTextField<String> cli_nr_id = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_cpf = new EasyTextField<String>();
    private EasyNumberField cli_tx_rg = new EasyNumberField();
    private EasyNumberField cli_tx_matricula = new EasyNumberField();
    private EasyTextField<String> cli_tx_sexo = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_estadocivil = new EasyTextField<String>();
    private ComboBox<TipoLogradouroTGWT> comboTipoLogradouro = new ComboBox<TipoLogradouroTGWT>();
    private EasyTextField<String> cli_tx_logradouro = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_numero = new EasyTextField<String>();
    private EasyNumberField cli_tx_cep = new EasyNumberField();
    private EasyTextField<String> cli_tx_complemento = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_bairro = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_municipio = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_uf = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_email = new EasyTextField<String>();
    private EasyNumberField cli_tx_telefone1 = new EasyNumberField();
    private EasyNumberField cli_tx_telefone2 = new EasyNumberField();
    private EasyNumberField cli_tx_celular = new EasyNumberField();
    private EasyTextField<String> cli_tx_ramal = new EasyTextField<String>();
    private DateField cli_dt_nascimento = new DateField();
    private FileUploadField cli_bt_foto = new FileUploadField();
    //private DateField cli_dt_cadastro = new DateField();
    private CheckBox cli_tx_socio = new CheckBox();
    private EasyTextField<String> org_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tmp_nr_id = new EasyTextField<String>();
    private FormPanel formPanel = new FormPanel();
    private RadioGroup rdgSexo = new RadioGroup();
    private RadioGroup rdgEstadocivil = new RadioGroup();
    private ListTipoLogradouroGWT listTipoLogradouroGWT = new ListTipoLogradouroGWT();
    private ListUF listUF = new ListUF();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();
    private TabPanel tabPanel = new TabPanel();
    private TabItem tbIEntdereco = new TabItem("Localização");
    private TabItem tbIOutros = new TabItem("Contatos/Outros");
    private Radio rdMasculino = new Radio();
    private Radio rdFeminino = new Radio();
    private Radio rdSolteiro = new Radio();
    private Radio rdCasado = new Radio();
    private MessageBox mb = new MessageBox();
    private List<Tmp_tipomensalidadeTGWT> listTmp;
    private ComboBox<Org_orgaoTGWT> cbOrgao = new ComboBox<Org_orgaoTGWT>();
    private ComboBox<Bco_bancoTGWT> cbBanco = new ComboBox<Bco_bancoTGWT>();
    private EasyTextField<String> tx_Agencia = new EasyTextField<String>();
    private EasyTextField<String> tx_Conta = new EasyTextField<String>();
    private ContentPanel cpOrgao = new ContentPanel();
    private Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();
    private Bco_bancoDAOGWT bco_bancoDAOGWT = new Bco_bancoDAOGWT();
    private Emp_emprestimoInsertGWT emp_emprestimoInsertGWT;
    private Cli_clienteTGWT cli_clienteTGWT = new Cli_clienteTGWT();
    private Cco_contacorrenteTGWT cco_contacorrenteTGWT = new Cco_contacorrenteTGWT();
    private CheckBox chksalriominimo = new CheckBox();

    public Cli_clienteInsertGWT() {
        this.setHeading("Cadastro de Clientes");

        cli_tx_cpf.setMaskFormat("00000000000");
        listUF.povoa();
        tabPanel.setHeight(260);

        tabPanel.add(tbIEntdereco);
        tabPanel.add(tbIOutros);

        tbIOutros.setLayout(new FillLayout());
        tbIEntdereco.setLayout(new FillLayout());

        this.setSize(800, 570);
        formPanel.setHeaderVisible(false);

        formPanel.setAction(Constantes.URL + cli_clienteDao.PAGE_INSERIR);
        formPanel.setEncoding(FormPanel.Encoding.MULTIPART);
        formPanel.setMethod(FormPanel.Method.POST);
        formPanel.setFrame(true);

        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("insert");
        formPanel.add(hfOp);
        formPanel.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                mb = MessageBox.progress("Cadastrando Cliente", "Aguarde!!!", "Requisitando o servidor");
                JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                read(jsonValue);
                for (int i = 0; i < formPanel.getItemCount(); i++) {
                    formPanel.getItems().get(i).clearState();
                }
            }
        });

        montarTela();
    }

    public void montarTela() {
        formPanel.setFrame(false);

        TableLayout layoutcp = new TableLayout(4);
        layoutcp.setCellPadding(3);

        ContentPanel cp = new ContentPanel();
//        cp.setHeight(60);
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);
        cp.setLayout(layoutcp);

        cp.add(new LabelField("Nome * "));
        cli_tx_nome.setName("cli_clienteT.cli_tx_nome");
        cli_tx_nome.setAllowBlank(false);
        cli_tx_nome.setWidth(352);
        cli_tx_nome.setMaxLength(100);

        cp.add(new LabelField("CPF * "));
        cli_tx_cpf.setName("cli_clienteT.cli_tx_cpf");
        cli_tx_cpf.setAllowBlank(false);
        cli_tx_cpf.setMaxLength(11);

        cp.add(new LabelField("RG * "));
        cli_tx_rg.setName("cli_clienteT.cli_tx_rg");
        cli_tx_rg.setWidth(100);
        cli_tx_rg.setMaxLength(20);
        cli_tx_rg.setAllowBlank(false);

        cp.add(new LabelField("Matrícula "));
        cli_tx_matricula.setWidth(100);
        cli_tx_matricula.setEmptyText("AUTOMATICO");
//        cli_tx_matricula.setEditable(false);
        cli_tx_matricula.setName("cli_clienteT.cli_tx_matricula");
        cli_tx_matricula.setMaxLength(20);
        //cli_tx_matricula.setAllowBlank(false);

        cp.add(cli_tx_nome);
        cp.add(cli_tx_cpf);
        cp.add(cli_tx_rg);
        cp.add(cli_tx_matricula);

        ContentPanel cpSexo = new ContentPanel();
        cpSexo.setHeaderVisible(false);
        cpSexo.setBodyBorder(false);
        cpSexo.setFrame(false);
        TableLayout tableLayout = new TableLayout(2);
        tableLayout.setCellPadding(3);
        cpSexo.setLayout(tableLayout);

        FieldSet fsSexo = new FieldSet();

        fsSexo.setHeading("Sexo");
        cpSexo.add(fsSexo);

        rdMasculino.setBoxLabel("Masculino");
        rdMasculino.setValue(true);

        rdFeminino.setBoxLabel("Feminino");
        rdFeminino.setValue(true);
        rdgSexo.add(rdMasculino);
        rdgSexo.add(rdFeminino);
        fsSexo.add(rdgSexo);

        FieldSet fsestCivil = new FieldSet();
        fsestCivil.setHeading("Eastado Civil");

        rdSolteiro.setBoxLabel("Solteiro(a)");
        rdSolteiro.setValue(true);
        rdgEstadocivil.add(rdSolteiro);
        rdgEstadocivil.add(rdCasado);

        rdCasado.setBoxLabel("Casado(a)");
        fsestCivil.add(rdgEstadocivil);
        cpSexo.add(fsestCivil);

        TableLayout layEnd = new TableLayout(4);
        layEnd.setCellPadding(3);

        ContentPanel cpEndereco = new ContentPanel();
        cpEndereco.setLayout(layEnd);
        cpEndereco.setBodyBorder(false);
        cpEndereco.setHeaderVisible(false);
        addComboTipoLogradouro();

        cpEndereco.add(new LabelField("Tipo de Logradouro"));
        cpEndereco.add(new LabelField("Logradouro * "));
        cpEndereco.add(new LabelField("Número * "));
        cpEndereco.add(new LabelField("CEP * "));

        comboTipoLogradouro.setName(stateId);
        cpEndereco.add(comboTipoLogradouro);

        cli_tx_logradouro.setName("cli_clienteT.cli_tx_logradouro");
        cli_tx_logradouro.setAllowBlank(false);
        cli_tx_logradouro.setWidth(401);
        cli_tx_logradouro.setMaxLength(100);
        cpEndereco.add(cli_tx_logradouro);

        cli_tx_numero.setName("cli_clienteT.cli_tx_numero");
        cli_tx_numero.setWidth(100);
        cli_tx_numero.setAllowBlank(false);
        cli_tx_numero.setMaxLength(10);
        cpEndereco.add(cli_tx_numero);

        cli_tx_cep.setName("cli_clienteT.cli_tx_cep");
        cli_tx_cep.setAllowBlank(false);
        cli_tx_cep.setWidth(102);
        cli_tx_cep.setMaxLength(10);
        cpEndereco.add(cli_tx_cep);

        TableLayout layCompEnd = new TableLayout(2);
        layCompEnd.setCellPadding(3);
        ContentPanel cpCompEnd = new ContentPanel(layCompEnd);
        cpCompEnd.setHeaderVisible(false);
        cpCompEnd.setBodyBorder(false);

        cpCompEnd.add(new LabelField("Complemento"));
        cpCompEnd.add(new LabelField("Bairro *"));

        cli_tx_complemento.setName("cli_clienteT.cli_tx_complemento");
        cli_tx_complemento.setWidth(400);
        cli_tx_complemento.setMaxLength(100);
        cpCompEnd.add(cli_tx_complemento);

        cli_tx_bairro.setName("cli_clienteT.cli_tx_bairro");
        cli_tx_bairro.setAllowBlank(false);
        cli_tx_bairro.setWidth(316);
        cli_tx_bairro.setMaxLength(100);
        cpCompEnd.add(cli_tx_bairro);

        cpCompEnd.add(new LabelField("Cidade *"));
        cpCompEnd.add(new LabelField("UF * "));
        cli_tx_municipio.setName("cli_clienteT.cli_tx_municipio");
        cli_tx_municipio.setAllowBlank(false);
        cli_tx_municipio.setWidth(400);
        cli_tx_municipio.setMaxLength(100);
        cpCompEnd.add(cli_tx_municipio);

        addComboUF();
        cpCompEnd.add(comboUF);

        TableLayout layOutros = new TableLayout(5);
        layOutros.setCellPadding(3);
        ContentPanel cpOutros = new ContentPanel(layOutros);
        cpOutros.setHeaderVisible(false);
        cpOutros.setBodyBorder(false);

        cpOutros.add(new LabelField("E-mail"));
        cpOutros.add(new LabelField("Telefone(1) * "));
        cpOutros.add(new LabelField("Telefone(2)"));
        cpOutros.add(new LabelField("Celular"));
        cpOutros.add(new LabelField("Ramal"));

        cli_tx_email.setWidth(300);
        cli_tx_email.setMaxLength(100);
        cli_tx_email.setName("cli_clienteT.cli_tx_email");

        cli_tx_telefone1.setWidth(100);
        cli_tx_telefone1.setName("cli_clienteT.cli_tx_telefone1");
        cli_tx_telefone1.setAllowBlank(false);
        cli_tx_telefone1.setMaxLength(20);

        cli_tx_telefone2.setWidth(100);
        cli_tx_telefone2.setName("cli_clienteT.cli_tx_telefone2");
        cli_tx_telefone2.setMaxLength(20);

        cli_tx_celular.setWidth(100);
        cli_tx_celular.setName("cli_clienteT.cli_tx_celular");
        cli_tx_celular.setMaxLength(20);
        cli_tx_ramal.setWidth(100);
        cli_tx_ramal.setName("cli_clienteT.cli_tx_ramal");
        cli_tx_ramal.setMaxLength(20);

        cpOutros.add(cli_tx_email);
        cpOutros.add(cli_tx_telefone1);
        cpOutros.add(cli_tx_telefone2);
        cpOutros.add(cli_tx_celular);
        cpOutros.add(cli_tx_ramal);

        TableLayout layoutFoto = new TableLayout(4);
        layoutFoto.setCellPadding(3);
        ContentPanel cp1Foto = new ContentPanel(layoutFoto);
        cp1Foto.setHeaderVisible(false);
        cp1Foto.setBodyBorder(false);

        cp1Foto.add(new LabelField("Dt. Nancimento * : "));
        cp1Foto.add(new LabelField("Foto:"));
        cp1Foto.add(new LabelField(" "));
        cp1Foto.add(new LabelField(" "));

        cli_dt_nascimento.setAllowBlank(false);
        cli_dt_nascimento.getPropertyEditor().setFormat(dtfDate);
        cli_dt_nascimento.setName("cli_clienteT.cli_dt_nascimento");
        cp1Foto.add(cli_dt_nascimento);

        cli_bt_foto.setWidth(400);
        cli_bt_foto.setName("cli_clienteT.cli_bt_foto");

        cli_tx_socio.setBoxLabel("Sócio");
        cp1Foto.add(cli_bt_foto);
        cp1Foto.add(cli_tx_socio);
        cp1Foto.add(chksalriominimo);
        chksalriominimo.setBoxLabel("Benefício de até um sálario mínino");

        TableLayout layoutOrgao = new TableLayout(4);
        layoutOrgao.setCellPadding(3);
        cpOrgao.setHeaderVisible(false);
        cpOrgao.setBodyBorder(false);

        cpOrgao.setLayout(layoutOrgao);
        cpOrgao.add(new LabelField("Orgão"));
        cpOrgao.add(new LabelField("Banco"));
        cpOrgao.add(new LabelField("Agência"));
        cpOrgao.add(new LabelField("Conta Corretnte"));

        cbOrgao.setWidth(255);
        cbBanco.setWidth(255);
        cpOrgao.add(cbOrgao);
        cpOrgao.add(cbBanco);
        tx_Agencia.setAllowBlank(false);
        tx_Agencia.setWidth(98);
        cpOrgao.add(tx_Agencia);
        tx_Conta.setWidth(100);
        tx_Conta.setAllowBlank(false);
        cpOrgao.add(tx_Conta);

        formPanel.add(cp);
        formPanel.add(cpSexo);
        formPanel.add(cpEndereco);
        formPanel.add(cpCompEnd);
        formPanel.add(cpOutros);
        formPanel.add(cp1Foto);
        formPanel.add(cpOrgao);

        getCpMaster().add(formPanel);

        addComboOrgao();
        addComboBanco();
        povoaComboOrgao();
        povoaComboBanco();
        layout();

    }

    public void povoaComboOrgao() {
        org_orgaoDAOGWT.consultarTodos();
        com.google.gwt.user.client.Timer timer = new com.google.gwt.user.client.Timer() {

            @Override
            public void run() {
                if (org_orgaoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    ListStore<Org_orgaoTGWT> list = new ListStore<Org_orgaoTGWT>();
                    list = org_orgaoDAOGWT.getList();
                    cbOrgao.setStore(list);
                    cbOrgao.getView().refresh();
                }
            }
        };
        timer.schedule(500);
    }

    public void povoaComboBanco() {
        bco_bancoDAOGWT.consultarTodos();
        com.google.gwt.user.client.Timer timer = new com.google.gwt.user.client.Timer() {

            @Override
            public void run() {
                if (bco_bancoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    ListStore<Bco_bancoTGWT> list = new ListStore<Bco_bancoTGWT>();
                    list = bco_bancoDAOGWT.getList();
                    cbBanco.setStore(list);
                    cbBanco.getView().refresh();
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addComboOrgao() {

        cbOrgao.setEmptyText("Selecione o orgão");
        cbOrgao.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbOrgao.setAllowBlank(false);
        cbOrgao.setDisplayField("org_tx_nomefantasia");
        cbOrgao.setValueField("org_nr_id");
        cbOrgao.setMinChars(2);
        cbOrgao.setStore(null);
        //povoaComboOrgao();

    }

    public void addComboBanco() {
        cbBanco.setEmptyText("Selecione o banco");
        cbBanco.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbBanco.setAllowBlank(false);
        cbBanco.setDisplayField("bco_tx_nome");
        cbBanco.setValueField("bco_nr_id");
        cbBanco.setStore(null);
        cbBanco.setMinChars(2);
        //povoaComboBanco();
    }

    public void addComboTipoLogradouro() {
        comboTipoLogradouro.setStore(listTipoLogradouroGWT.getList());
        comboTipoLogradouro.setDisplayField("display");
        comboTipoLogradouro.setValueField("tid_nr_id");
        comboTipoLogradouro.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboTipoLogradouro.setAllowBlank(false);
        comboTipoLogradouro.setMinChars(2);
        comboTipoLogradouro.setWidth(100);
    }

    public void addComboUF() {
        ListStore<UFTGWT> store = new ListStore<UFTGWT>();
        store.add(listUF.getList());
        comboUF.setStore(store);
        comboUF.setDisplayField("display");
        comboUF.setValueField("value");
        comboUF.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboUF.setMinChars(2);
        comboUF.setAllowBlank(false);
    }

    public void btnInsertAction(ButtonEvent ce) {
        if (cadastroValido()) {
            if (formPanel.isValid()) {
                HiddenField<String> hfOpTmp_nr_id = new HiddenField<String>();
                //hfOpTmp_nr_id = new HiddenField<String>();
                hfOpTmp_nr_id.setName("cli_clienteT.tmp_nr_id");
                formPanel.add(hfOpTmp_nr_id);

                HiddenField<String> hfOpsexo = new HiddenField<String>();
                //hfOpsexo = new HiddenField<String>();
                hfOpsexo.setName("cli_clienteT.cli_tx_sexo");
                hfOpsexo.setValue(rdgSexo.getValue().getBoxLabel().equalsIgnoreCase("Masculino") ? "M" : "F");
                formPanel.add(hfOpsexo);

                HiddenField<String> hfEstCivil = new HiddenField<String>();
                //hfEstCivil = new HiddenField<String>();
                hfEstCivil.setName("cli_clienteT.cli_tx_estadocivil");
                hfEstCivil.setValue(rdgEstadocivil.getValue().getBoxLabel().equalsIgnoreCase("Solteiro(a)") ? "S" : "C");
                formPanel.add(hfEstCivil);

                HiddenField<String> hfTipoLog = new HiddenField<String>();
                //hfTipoLog = new HiddenField<String>();
                hfTipoLog.setName("cli_clienteT.cli_tx_tipologradouro");
                hfTipoLog.setValue(comboTipoLogradouro.getValue().getValue());
                formPanel.add(hfTipoLog);

                HiddenField<String> hfUf = new HiddenField<String>();
                //hfUf = new HiddenField<String>();
                hfUf.setName("cli_clienteT.cli_tx_uf");
                hfUf.setValue(comboUF.getValue().getValue());
                formPanel.add(hfUf);

                HiddenField<String> hfSocio = new HiddenField<String>();
                //hfSocio = new HiddenField<String>();
                hfSocio.setName("cli_clienteT.cli_tx_socio");
                hfSocio.setValue(cli_tx_socio.getValue() ? "S" : "N");
                formPanel.add(hfSocio);

                HiddenField<String> hfOrgao = new HiddenField<String>();
                hfOrgao.setName("orgao");
                hfOrgao.setValue(cbOrgao.getValue().getOrg_nr_id() + "");
                formPanel.add(hfOrgao);

                HiddenField<String> hfbanco = new HiddenField<String>();
                hfbanco.setName("banco");
                hfbanco.setValue(cbBanco.getValue().getBco_nr_id() + "");
                formPanel.add(hfbanco);

                HiddenField<String> hfAgencia = new HiddenField<String>();
                hfAgencia.setName("agencia");
                hfAgencia.setValue(tx_Agencia.getValue());
                formPanel.add(hfAgencia);

                HiddenField<String> hfconta = new HiddenField<String>();
                hfconta.setName("conta");
                hfconta.setValue(tx_Conta.getValue());
                formPanel.add(hfconta);

                HiddenField<String> hfsalariominimo = new HiddenField<String>();
                hfsalariominimo.setName("cli_clienteT.cli_tx_salario_minimo");
                hfsalariominimo.setValue(chksalriominimo.getValue().booleanValue() ? "S" : "N");
                formPanel.add(hfsalariominimo);

                formPanel.layout();
                layout();
                formPanel.submit();
            }
        }
    }

    public void btnLimpartAction(ButtonEvent ce) {
        cli_tx_nome.setValue("");
        cli_tx_cpf.setValue(null);
        cli_tx_rg.setValue(null);
        cli_tx_matricula.setValue(null);
        cli_tx_sexo.setValue("");
        cli_tx_estadocivil.setValue("");
        comboTipoLogradouro.setValue(null);
        cli_tx_logradouro.setValue("");
        cli_tx_numero.setValue("");
        cli_tx_cep.setValue(null);
        cli_tx_complemento.setValue("");
        cli_tx_bairro.setValue("");
        cli_tx_municipio.setValue("");
        cli_tx_uf.setValue("");
        cli_tx_email.setValue("");
        cli_tx_telefone1.setValue(null);
        cli_tx_telefone2.setValue(null);
        cli_tx_celular.setValue(null);
        cli_tx_ramal.setValue("");
        cli_dt_nascimento.setValue(null);
        cli_bt_foto.setValue("");
//        cli_dt_cadastro.setValue(null);
        cli_tx_socio.setValue(false);
        cbOrgao.setValue(null);
        cbBanco.setValue(null);
        tx_Agencia.setValue("");
        tx_Conta.setValue("");

    }

    /**
     * @return the cli_clienteConsult
     */
    public Cli_clienteConsultGWT getCli_clienteConsult() {
        return cli_clienteConsult;
    }

    /**
     * @param cli_clienteConsult the cli_clienteConsult to set
     */
    public void setCli_clienteConsult(Cli_clienteConsultGWT cli_clienteConsult) {
        this.cli_clienteConsult = cli_clienteConsult;
    }

    public void read(JSONValue jsonValue) {
        mb.close();
        JSONObject jsonObject = jsonValue.isObject();
        JSONObject resultado = jsonObject.get("resultado").isObject();
        JSONObject conta = jsonObject.get("conta").isObject();
        if (jsonValue.toString().indexOf("sucesso") > -1) {
            Info.display("INFORMAÇÃO", "Cadastro efetuado com sucesso!");
            btnLimpartAction(null);
            if (emp_emprestimoInsertGWT != null) {
                setClienteJson(resultado, conta);
                enviarDadostelaEmprestimo();
            }
            setVisible(false);
        } else {
            JSONObject resultadomsg = resultado.get("msg").isObject();
            mb = new MessageBox().alert("ATENÇÃO", resultadomsg.get("msg").isString().stringValue(), null);
        }
    }

    public void setClienteJson(JSONObject resultado, JSONObject conta) {
        JSONObject resultadoCli = resultado.get("cli_cliente").isObject();
        JSONObject resultadoConta = conta;
        lerJsonCliente(resultadoCli);
        lerRegistroJsonContas(resultadoConta);
    }

    public void lerJsonCliente(JSONObject registro) {

        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        cli_clienteTGWT.setCli_nr_id(cli_nr_id);

        String cli_tx_nome = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
        cli_clienteTGWT.setCli_tx_nome(cli_tx_nome);

        String cli_tx_cpf = EasyContainer.clearAspas(registro.get("cli_tx_cpf").toString());
        cli_clienteTGWT.setCli_tx_cpf(cli_tx_cpf);

        String cli_tx_rg = EasyContainer.clearAspas(registro.get("cli_tx_rg").toString());
        cli_clienteTGWT.setCli_tx_rg(cli_tx_rg.equalsIgnoreCase("null") ? "" : cli_tx_rg);

        String cli_tx_matricula = EasyContainer.clearAspas(registro.get("cli_tx_matricula").toString());
        cli_clienteTGWT.setCli_tx_matricula(cli_tx_matricula);

    }

    public void enviarDadostelaEmprestimo() {
        emp_emprestimoInsertGWT.getNumeroProposta().setValue(1);
        emp_emprestimoInsertGWT.getCli_tx_matricula().setValue(cli_clienteTGWT.getCli_tx_matricula());
        emp_emprestimoInsertGWT.getCli_tx_cpf().setValue(cli_clienteTGWT.getCli_tx_cpf());
        emp_emprestimoInsertGWT.getCli_tx_nome().setValue(cli_clienteTGWT.getCli_tx_nome());
        emp_emprestimoInsertGWT.getBco_tx_nome().setValue(cco_contacorrenteTGWT.getBco_tx_nome());
        emp_emprestimoInsertGWT.getOrg_tx_nome().setValue(cco_contacorrenteTGWT.getOrg_tx_nome());
        emp_emprestimoInsertGWT.getCli_nr_id().setValue(cli_clienteTGWT.getCli_nr_id() + "");
        emp_emprestimoInsertGWT.setOrg_nr_id(cco_contacorrenteTGWT.getOrg_nr_id());
        emp_emprestimoInsertGWT.consultarParcelasAberto();
    }

    private void lerRegistroJsonContas(JSONObject registro) {

        Integer cco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cco_nr_id").toString()));
        cco_contacorrenteTGWT.setCco_nr_id(cco_nr_id);

        int cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        cco_contacorrenteTGWT.setCli_nr_id(cli_nr_id);

        String cco_tx_nragencia = EasyContainer.clearAspas(registro.get("cco_tx_nragencia").toString());
        cco_contacorrenteTGWT.setCco_tx_nragencia(cco_tx_nragencia);

        String cco_tx_nrcontacorrente = EasyContainer.clearAspas(registro.get("cco_tx_nrcontacorrente").toString());
        cco_contacorrenteTGWT.setCco_tx_nrcontacorrente(cco_tx_nrcontacorrente);

        int bco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("bco_nr_id").toString()));
        cco_contacorrenteTGWT.setBco_nr_id(bco_nr_id);

        int org_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("org_nr_id").toString()));
        cco_contacorrenteTGWT.setOrg_nr_id(org_nr_id);

        String bco_tx_nome = EasyContainer.clearAspas(registro.get("bco_tx_nome").toString());
        cco_contacorrenteTGWT.setBco_tx_nome(bco_tx_nome);

        String org_tx_nome = EasyContainer.clearAspas(registro.get("org_tx_nome").toString());
        cco_contacorrenteTGWT.setOrg_tx_nome(org_tx_nome);

    }

    /**
     * @return the emp_emprestimoInsertGWT
     */
    public Emp_emprestimoInsertGWT getEmp_emprestimoInsertGWT() {
        return emp_emprestimoInsertGWT;
    }

    /**
     * @param emp_emprestimoInsertGWT the emp_emprestimoInsertGWT to set
     */
    public void setEmp_emprestimoInsertGWT(Emp_emprestimoInsertGWT emp_emprestimoInsertGWT) {
        this.emp_emprestimoInsertGWT = emp_emprestimoInsertGWT;
    }

    public boolean cadastroValido() {
        boolean res = true;

        if (!ValidacaoCPFCNPJ.isValidCPF(cli_tx_cpf.getValue().toString().trim())) {
            res = false;
            MessageBox.alert("IMPORTANTE", "CPF invalido!", null);
            cli_tx_cpf.focus();
        }

        return res;
    }
}
