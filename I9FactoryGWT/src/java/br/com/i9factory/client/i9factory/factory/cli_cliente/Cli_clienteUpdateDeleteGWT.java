package br.com.i9factory.client.i9factory.factory.cli_cliente;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.ListTipoLogradouroGWT;
import br.com.i9factory.client.ListUF;
import br.com.i9factory.client.TipoLogradouroTGWT;
import br.com.i9factory.client.UFTGWT;
import br.com.i9factory.client.i9factory.factory.util.ListMtc_motivo_cancelamento;
import br.com.i9factory.client.i9factory.factory.util.Mtc_motivo_cancelamento;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Cli_clienteUpdateDeleteGWT extends AlterarExcluirBaseGWT implements IListenetResponse {

    private Cli_clienteConsultGWT cli_clienteConsult;
    private Cli_clienteTGWT cli_clienteT;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Cli_clienteDAOGWT cli_clienteDao = new Cli_clienteDAOGWT();
    private EasyTextField<String> cli_nr_id = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_cpf = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_rg = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_matricula = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_sexo = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_estadocivil = new EasyTextField<String>();
    private ComboBox<TipoLogradouroTGWT> comboTipoLogradouro = new ComboBox<TipoLogradouroTGWT>();
    private EasyTextField<String> cli_tx_logradouro = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_numero = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_cep = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_complemento = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_bairro = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_municipio = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_uf = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_email = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_telefone1 = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_telefone2 = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_celular = new EasyTextField<String>();
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
    private String campoFiltro;
    private ContentPanel cpOutros = new ContentPanel();
    private ComboBox<Mtc_motivo_cancelamento> cbMotivoCancel = new ComboBox<Mtc_motivo_cancelamento>();
    private CheckBox chksalriominimo = new CheckBox();

    public Cli_clienteUpdateDeleteGWT() {
        setHeading("Alterar Cliente");
        listUF.povoa();
        tabPanel.setHeight(300);

        tabPanel.add(tbIEntdereco);
        tabPanel.add(tbIOutros);

        tbIOutros.setLayout(new FillLayout());
        tbIEntdereco.setLayout(new FillLayout());

        this.setSize(600, 580);
        formPanel.setHeaderVisible(false);

        formPanel.setAction(Constantes.URL + cli_clienteDao.PAGE_ALTERAR_EXCLUIR);
        formPanel.setEncoding(FormPanel.Encoding.MULTIPART);
        formPanel.setMethod(FormPanel.Method.POST);
        formPanel.setFrame(true);

        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("update");
        formPanel.add(hfOp);
        formPanel.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                mb = MessageBox.progress("Alterando Cliente", "Aguarde!!!", "Requisitando o servidor");
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

        TableLayout layoutcp = new TableLayout(2);
        layoutcp.setCellPadding(3);

        ContentPanel cp = new ContentPanel();
        cp.setHeight(120);
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);
        cp.setLayout(layoutcp);

        cp.add(new LabelField("Nome:"));
        cli_tx_nome.setMaxLength(100);
        cli_tx_nome.setName("cli_clienteT.cli_tx_nome");
        cli_tx_nome.setAllowBlank(false);
        cli_tx_nome.setWidth(400);
        cp.add(cli_tx_nome);

        cp.add(new LabelField("CPF:"));
        cli_tx_cpf.setMaxLength(14);
        cli_tx_cpf.setName("cli_clienteT.cli_tx_cpf");
        cli_tx_cpf.setAllowBlank(false);
        cp.add(cli_tx_cpf);

        cp.add(new LabelField("RG:"));
        cli_tx_rg.setMaxLength(20);
        cli_tx_rg.setName("cli_clienteT.cli_tx_rg");
        cli_tx_rg.setAllowBlank(false);
        cp.add(cli_tx_rg);

        cp.add(new LabelField("Matrícula:"));
        cli_tx_matricula.setName("cli_clienteT.cli_tx_matricula");
        cli_tx_matricula.setMaxLength(20);
        cli_tx_matricula.setAllowBlank(false);
        cp.add(cli_tx_matricula);
        formPanel.add(cp);
        formPanel.add(addPanelSeparador());

        ContentPanel cpSexo = new ContentPanel();
        cpSexo.setHeaderVisible(false);
        cpSexo.setFrame(true);
        TableLayout tableLayout = new TableLayout(4);
        tableLayout.setCellPadding(3);
        cpSexo.setLayout(tableLayout);

        cpSexo.add(new LabelField("Sexo:"));
        rdMasculino.setBoxLabel("Masculino");
        rdMasculino.setValue(true);

        rdFeminino.setBoxLabel("Feminino");
        rdFeminino.setValue(true);
        rdgSexo.add(rdMasculino);
        rdgSexo.add(rdFeminino);
        cpSexo.add(rdgSexo);

        cpSexo.add(new LabelField("Estado Civil:"));

        rdSolteiro.setBoxLabel("Solteiro(a)");
        rdSolteiro.setValue(true);
        rdgEstadocivil.add(rdSolteiro);
        rdgEstadocivil.add(rdCasado);

        rdCasado.setBoxLabel("Casado(a)");
        cpSexo.add(rdgEstadocivil);

        formPanel.add(cpSexo);
        formPanel.add(addPanelSeparador());

        formPanel.add(tabPanel);

        ContentPanel cpEndereco = new ContentPanel();
        TableLayout layout1 = new TableLayout(2);
        layout1.setCellSpacing(3);
        cpEndereco.setLayout(layout1);
        cpEndereco.setBodyBorder(false);
        cpEndereco.setHeaderVisible(false);

        addComboTipoLogradouro();
        addCbMotivoCancel();

        cpEndereco.add(new LabelField("Tipo de Logradouro:"));
        comboTipoLogradouro.setName(stateId);
        cpEndereco.add(comboTipoLogradouro);

        cpEndereco.add(new LabelField("Logradouro:"));
        cli_tx_logradouro.setName("cli_clienteT.cli_tx_logradouro");
        cli_tx_logradouro.setAllowBlank(false);
        cli_tx_logradouro.setWidth(400);
        cli_tx_logradouro.setMaxLength(100);
        cpEndereco.add(cli_tx_logradouro);

        cpEndereco.add(new LabelField("Número:"));
        cli_tx_numero.setName("cli_clienteT.cli_tx_numero");
        cli_tx_numero.setAllowBlank(false);
        cli_tx_numero.setMaxLength(10);
        cpEndereco.add(cli_tx_numero);

        cpEndereco.add(new LabelField("CEP:"));
        cli_tx_cep.setName("cli_clienteT.cli_tx_cep");
        cli_tx_cep.setAllowBlank(false);
        cli_tx_cep.setMaxLength(10);
        cpEndereco.add(cli_tx_cep);

        cpEndereco.add(new LabelField("Complemento:"));
        cli_tx_complemento.setName("cli_clienteT.cli_tx_complemento");
        cli_tx_complemento.setWidth(400);
        cli_tx_complemento.setMaxLength(300);
        cpEndereco.add(cli_tx_complemento);

        cpEndereco.add(new LabelField("Bairro:"));
        cli_tx_bairro.setName("cli_clienteT.cli_tx_bairro");
        cli_tx_bairro.setAllowBlank(false);
        cli_tx_bairro.setWidth(400);
        cli_tx_bairro.setMaxLength(100);
        cpEndereco.add(cli_tx_bairro);

        cpEndereco.add(new LabelField("Cidade:"));
        cli_tx_municipio.setName("cli_clienteT.cli_tx_municipio");
        cli_tx_municipio.setAllowBlank(false);
        cli_tx_municipio.setWidth(400);
        cli_tx_municipio.setMaxLength(100);
        cpEndereco.add(cli_tx_municipio);

        cpEndereco.add(new LabelField("UF:"));
        addComboUF();
        cpEndereco.add(comboUF);
        tbIEntdereco.add(cpEndereco);

        TableLayout layout2 = new TableLayout(2);
        layout2.setCellSpacing(3);
        cpOutros.setLayout(layout2);
        cpOutros.setHeaderVisible(false);
        cpOutros.setBodyBorder(false);

        cpOutros.add(new LabelField("E-mail:"));
        cli_tx_email.setWidth(400);
        cli_tx_email.setMaxLength(100);
        cli_tx_email.setName("cli_clienteT.cli_tx_email");
        cpOutros.add(cli_tx_email);

        cpOutros.add(new LabelField("Telefone(1):"));
        cli_tx_telefone1.setName("cli_clienteT.cli_tx_telefone1");
        cli_tx_telefone1.setAllowBlank(false);
        cli_tx_telefone1.setMaxLength(20);
        cpOutros.add(cli_tx_telefone1);

        cpOutros.add(new LabelField("Telefone(2):"));
        cli_tx_telefone2.setName("cli_clienteT.cli_tx_telefone2");
        cli_tx_telefone2.setMaxLength(20);
        cpOutros.add(cli_tx_telefone2);

        cpOutros.add(new LabelField("Celular:"));
        cli_tx_celular.setName("cli_clienteT.cli_tx_celular");
        cli_tx_celular.setMaxLength(20);
        cpOutros.add(cli_tx_celular);

        cpOutros.add(new LabelField("Ramal:"));
        cli_tx_ramal.setName("cli_clienteT.cli_tx_ramal");
        cli_tx_ramal.setMaxLength(20);
        cpOutros.add(cli_tx_ramal);

        cpOutros.add(new LabelField("Dt. Nancimento:"));
        cli_dt_nascimento.setAllowBlank(false);
        cli_dt_nascimento.getPropertyEditor().setFormat(dtfDate);
        cpOutros.add(cli_dt_nascimento);

        cpOutros.add(new LabelField("Foto:"));
        cli_bt_foto.setWidth(400);
        cli_bt_foto.setName("cli_clienteT.cli_bt_foto");
        cpOutros.add(cli_bt_foto);

//        cpOutros.add(new LabelField("Dt. Cadastro:"));
//        cli_dt_cadastro.setAllowBlank(false);
//        cli_dt_cadastro.setName("cli_clienteT.cli_dt_cadastro");
//        cli_dt_cadastro.getPropertyEditor().setFormat(dtfDate);
//        cpOutros.add(cli_dt_cadastro);
        //cpOutros.add(new LabelField("Sócio:"));
        chksalriominimo.setBoxLabel("Benefício de até um sálario mínino");
        cli_tx_socio.setBoxLabel("Sócio");
        cpOutros.add(cli_tx_socio);
        cpOutros.add(chksalriominimo);
        cpOutros.add(new LabelField("Motivo cancelamento"));
        cpOutros.add(cbMotivoCancel);
        
        
        

        tbIOutros.add(cpOutros);

        formPanel.add(addPanelSeparador());

        getCpMaster().add(formPanel);
        tabPanel.setSelection(tbIOutros);
        tabPanel.setSelection(tbIEntdereco);
        layout();

        cli_tx_socio.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                cbMotivoCancel.setEnabled(!cli_tx_socio.getValue());
                cbMotivoCancel.setValue(null);
            }
        });

    }

    public void addCbMotivoCancel() {
        ListMtc_motivo_cancelamento lm = new ListMtc_motivo_cancelamento();
        ListStore store = new ListStore();
        store.add(lm.getList());
        cbMotivoCancel.setStore(store);
        cbMotivoCancel.setDisplayField("mtc_tx_nome");
        cbMotivoCancel.setValueField("mtc_nr_id");
        cbMotivoCancel.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbMotivoCancel.setAllowBlank(false);
        cbMotivoCancel.setMinChars(2);
        cbMotivoCancel.disable();
    }

    public void addComboTipoLogradouro() {
        comboTipoLogradouro.setStore(listTipoLogradouroGWT.getList());
        comboTipoLogradouro.setDisplayField("display");
        comboTipoLogradouro.setValueField("tid_nr_id");
        comboTipoLogradouro.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboTipoLogradouro.setAllowBlank(false);
        comboTipoLogradouro.setMinChars(2);
    }

    public void addComboUF() {
        ListStore<UFTGWT> store = new ListStore<UFTGWT>();
        store.add(listUF.getList());
        comboUF.setStore(store);
        comboUF.setDisplayField("display");
        comboUF.setValueField("value");
        comboUF.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboUF.setAllowBlank(false);
        comboUF.setMinChars(2);
    }

    public ContentPanel addPanelSeparador() {
        ContentPanel cp = new ContentPanel();
        cp.setHeaderVisible(false);
        cp.setHeight(3);
        cp.setBodyBorder(false);
        return cp;
    }

    public void load(final Cli_clienteTGWT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;

        cli_nr_id.setValue(cli_clienteT.getCli_nr_id() + "");
        cli_tx_nome.setValue(cli_clienteT.getCli_tx_nome());
        cli_tx_cpf.setValue(cli_clienteT.getCli_tx_cpf());
        cli_tx_rg.setValue(cli_clienteT.getCli_tx_rg());
        cli_tx_matricula.setValue(cli_clienteT.getCli_tx_matricula());
        if (cli_clienteT.getCli_tx_estadocivil().equalsIgnoreCase("S")) {
            rdSolteiro.setValue(true);
        } else {
            rdCasado.setValue(true);
        }

        if (cli_clienteT.getCli_tx_sexo().equalsIgnoreCase("M")) {
            rdMasculino.setValue(true);
        } else {
            rdFeminino.setValue(true);
        }

        comboTipoLogradouro.setValue(listTipoLogradouroGWT.getTree().get(cli_clienteT.getCli_tx_tipologradouro()));

        cli_tx_logradouro.setValue(cli_clienteT.getCli_tx_logradouro());
        cli_tx_numero.setValue(cli_clienteT.getCli_tx_numero());
        cli_tx_cep.setValue(cli_clienteT.getCli_tx_cep());
        cli_tx_complemento.setValue(cli_clienteT.getCli_tx_complemento());
        cli_tx_bairro.setValue(cli_clienteT.getCli_tx_bairro());
        cli_tx_municipio.setValue(cli_clienteT.getCli_tx_municipio());
        comboUF.setValue(listUF.getTreeUF().get(cli_clienteT.getCli_tx_uf()));
        cli_tx_email.setValue(cli_clienteT.getCli_tx_email() == null ? "" : cli_clienteT.getCli_tx_email());
        cli_tx_telefone1.setValue(cli_clienteT.getCli_tx_telefone1() == null ? "" : cli_clienteT.getCli_tx_telefone1());
        cli_tx_telefone2.setValue(cli_clienteT.getCli_tx_telefone2() == null ? "" : cli_clienteT.getCli_tx_telefone2());
        cli_tx_celular.setValue(cli_clienteT.getCli_tx_celular() == null ? "" : cli_clienteT.getCli_tx_celular());
        cli_tx_ramal.setValue(cli_clienteT.getCli_tx_ramal() == null ? "" : cli_clienteT.getCli_tx_ramal());
        cli_dt_nascimento.setValue(cli_clienteT.getCli_dt_nascimento());

        cli_tx_socio.setValue(cli_clienteT.getCli_tx_socio().equalsIgnoreCase("S") ? true : false);

        cbMotivoCancel.setValue(cbMotivoCancel.getStore().findModel("mtc_nr_id", cli_clienteT.getMtc_nr_id()));
        cbMotivoCancel.setEnabled(!cli_tx_socio.getValue());
        chksalriominimo.setValue(cli_clienteT.getCli_tx_salario_minimo().equalsIgnoreCase("S") ? true : false);

    }

    public void btnUpdateAction(ButtonEvent ce) {
        tabPanel.setTabIndex(1);
        cpOutros.layout();

        HiddenField<String> hfOpCli_nr_id = new HiddenField<String>();
        hfOpCli_nr_id = new HiddenField<String>();
        hfOpCli_nr_id.setName("cli_clienteT.cli_nr_id");
        hfOpCli_nr_id.setValue(cli_clienteT.getCli_nr_id() + "");
        formPanel.add(hfOpCli_nr_id);

        HiddenField<String> hfOpsexo = new HiddenField<String>();
        hfOpsexo = new HiddenField<String>();
        hfOpsexo.setName("cli_clienteT.cli_tx_sexo");
        hfOpsexo.setValue(rdgSexo.getValue().getBoxLabel().equalsIgnoreCase("Masculino") ? "M" : "F");
        formPanel.add(hfOpsexo);

        HiddenField<String> hfEstCivil = new HiddenField<String>();
        hfEstCivil = new HiddenField<String>();
        hfEstCivil.setName("cli_clienteT.cli_tx_estadocivil");
        hfEstCivil.setValue(rdgEstadocivil.getValue().getBoxLabel().equalsIgnoreCase("Solteiro(a)") ? "S" : "C");
        formPanel.add(hfEstCivil);

        HiddenField<String> hfTipoLog = new HiddenField<String>();
        hfTipoLog = new HiddenField<String>();
        hfTipoLog.setName("cli_clienteT.cli_tx_tipologradouro");
        hfTipoLog.setValue(comboTipoLogradouro.getValue().getValue());
        formPanel.add(hfTipoLog);

        HiddenField<String> hfUf = new HiddenField<String>();
        hfUf = new HiddenField<String>();
        hfUf.setName("cli_clienteT.cli_tx_uf");
        hfUf.setValue(comboUF.getValue().getValue());
        formPanel.add(hfUf);

        HiddenField<String> hfUdataNasc = new HiddenField<String>();
        hfUdataNasc.setName("cli_clienteT.cli_dt_nascimento");
        hfUdataNasc.setValue(dtfDate.format(cli_dt_nascimento.getValue()));
        formPanel.add(hfUdataNasc);

        HiddenField<String> hfSocio = new HiddenField<String>();
        hfSocio = new HiddenField<String>();
        hfSocio.setName("cli_clienteT.cli_tx_socio");
        hfSocio.setValue(cli_tx_socio.getValue() ? "S" : "N");
        formPanel.add(hfSocio);

        HiddenField<String> hfmotivoCancel = new HiddenField<String>();
        hfmotivoCancel.setName("cli_clienteT.mtc_nr_id");
        hfmotivoCancel.setValue(cbMotivoCancel.getValue() == null ? "0" : cbMotivoCancel.getValue().getMtc_nr_id() + "");
        formPanel.add(hfmotivoCancel);

        HiddenField<String> hfsalariominimo = new HiddenField<String>();
        hfsalariominimo.setName("cli_clienteT.cli_tx_salario_minimo");
        hfsalariominimo.setValue(chksalriominimo.getValue().booleanValue() ? "S" : "N");
        formPanel.add(hfsalariominimo);

        formPanel.layout();
        layout();
        formPanel.layout();
        formPanel.submit();
    }

    public void btnDeltAction(ButtonEvent ce) {

        cli_clienteDao.excluir(cli_clienteT);
        Timer timer = new Timer() {

            public void run() {
                String msg = cli_clienteDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        cli_clienteConsult.load(cli_clienteConsult.getCampoFiltro());
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
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
        if (jsonValue.toString().indexOf("sucesso") > -1) {
            Info.display("INFORMAÇÃO", "Alteração efetuado com sucesso!");
            cli_clienteConsult.load(cli_clienteConsult.getCampoFiltro());
            setVisible(false);
        } else {
            mb = new MessageBox().alert("ATENÇÃO", "Falha ao realizar o cadastro!", null);
        }
    }

    /**
     * @return the campoFiltro
     */
    public String getCampoFiltro() {
        return campoFiltro;
    }

    /**
     * @param campoFiltro the campoFiltro to set
     */
    public void setCampoFiltro(String campoFiltro) {
        this.campoFiltro = campoFiltro;
    }
}
