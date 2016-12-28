package br.com.i9factory.client.i9factory.factory.cor_corretora;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.ListTipoLogradouroGWT;
import br.com.i9factory.client.ListUF;
import br.com.i9factory.client.TipoLogradouroTGWT;
import br.com.i9factory.client.UFTGWT;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Cor_corretoraUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Cor_corretoraConsultGWT cor_corretoraConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Cor_corretoraDAOGWT cor_corretoraDao = new Cor_corretoraDAOGWT();
    private Cor_corretoraTGWT cor_corretoraT;
    private EasyTextField<String> cor_nr_id = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_cnpj = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_razaosocial = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_nomefantasia = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_inscestadual = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_responsavel = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_tipologradouro = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_logradouro = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_numero = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_cep = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_complemento = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_bairro = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_municipio = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_uf = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_telefone1 = new EasyTextField<String>();
    private EasyTextField<String> cor_tx_telefone2 = new EasyTextField<String>();
    private ListUF listUF = new ListUF();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();
    private ComboBox<TipoLogradouroTGWT> comboTipoLogradouro = new ComboBox<TipoLogradouroTGWT>();
    private ListTipoLogradouroGWT listTipoLogradouroGWT = new ListTipoLogradouroGWT();

    public Cor_corretoraUpdateDeleteGWT() {

        listUF.povoa();

        this.setSize("600", "510");
        this.setHeading("Alterar Corretora");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        cor_tx_razaosocial.setWidth(400);
        cor_tx_razaosocial.setAllowBlank(false);
        cor_tx_razaosocial.setMaxLength(100);
        getCpMaster().add(new LabelField("Razão Social*:"));
        getCpMaster().add(cor_tx_razaosocial);

        cor_tx_nomefantasia.setWidth(400);
        cor_tx_nomefantasia.setAllowBlank(false);
        cor_tx_nomefantasia.setMaxLength(100);
        getCpMaster().add(new LabelField("Nome Fantasia*:"));
        getCpMaster().add(cor_tx_nomefantasia);

        cor_tx_cnpj.setAllowBlank(false);
        cor_tx_cnpj.setMaxLength(14);
        getCpMaster().add(new LabelField("CNPJ*:"));
        getCpMaster().add(cor_tx_cnpj);

        cor_tx_inscestadual.setAllowBlank(false);
        cor_tx_inscestadual.setMaxLength(10);
        getCpMaster().add(new LabelField("Inscrição Estadual*:"));
        getCpMaster().add(cor_tx_inscestadual);

        cor_tx_responsavel.setAllowBlank(false);
        cor_tx_responsavel.setMaxLength(100);
        getCpMaster().add(new LabelField("Responsável*:"));
        getCpMaster().add(cor_tx_responsavel);


        cor_tx_cep.setAllowBlank(false);
        cor_tx_cep.setMaxLength(100);
        getCpMaster().add(new LabelField("CEP*:"));
        getCpMaster().add(cor_tx_cep);

        addComboTipoLogradouro();
        comboTipoLogradouro.setAllowBlank(false);
        getCpMaster().add(new LabelField("Tipo de Logradouro:"));
        getCpMaster().add(comboTipoLogradouro);

        cor_tx_logradouro.setWidth(400);
        cor_tx_logradouro.setMaxLength(250);
        cor_tx_logradouro.setAllowBlank(false);
        getCpMaster().add(new LabelField("Logradouro*:"));
        getCpMaster().add(cor_tx_logradouro);

        cor_tx_numero.setAllowBlank(false);
        getCpMaster().add(new LabelField("Número*:"));
        cor_tx_numero.setMaxLength(10);
        getCpMaster().add(cor_tx_numero);

        cor_tx_complemento.setWidth(400);
        cor_tx_complemento.setAllowBlank(true);
        getCpMaster().add(new LabelField("Complemento:"));
        cor_tx_complemento.setMaxLength(250);
        getCpMaster().add(cor_tx_complemento);

        cor_tx_bairro.setWidth(400);
        cor_tx_bairro.setAllowBlank(false);
        cor_tx_bairro.setMaxLength(100);
        getCpMaster().add(new LabelField("Bairro*:"));
        getCpMaster().add(cor_tx_bairro);

        cor_tx_municipio.setWidth(400);
        cor_tx_municipio.setAllowBlank(false);
        cor_tx_municipio.setMaxLength(100);
        getCpMaster().add(new LabelField("Município*:"));
        getCpMaster().add(cor_tx_municipio);

        addComboUF();
        comboUF.setAllowBlank(false);
        getCpMaster().add(new LabelField("UF*:"));
        getCpMaster().add(comboUF);

        cor_tx_telefone1.setAllowBlank(false);
        getCpMaster().add(new LabelField("Telefone(01)*:"));
        cor_tx_telefone1.setMaxLength(20);
        getCpMaster().add(cor_tx_telefone1);

        cor_tx_telefone2.setAllowBlank(true);
        getCpMaster().add(new LabelField("Telefone(02):"));
        cor_tx_telefone2.setMaxLength(20);
        getCpMaster().add(cor_tx_telefone2);

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

    public void addComboTipoLogradouro() {
        comboTipoLogradouro.setStore(listTipoLogradouroGWT.getList());
        comboTipoLogradouro.setDisplayField("display");
        comboTipoLogradouro.setValueField("value");
        comboTipoLogradouro.setAllowBlank(false);
        comboTipoLogradouro.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void load(Cor_corretoraTGWT cor_corretoraT) {
        this.cor_corretoraT = cor_corretoraT;
        cor_nr_id.setValue(cor_corretoraT.getCor_nr_id() + "");
        cor_tx_cnpj.setValue(cor_corretoraT.getCor_tx_cnpj());
        cor_tx_razaosocial.setValue(cor_corretoraT.getCor_tx_razaosocial());
        cor_tx_nomefantasia.setValue(cor_corretoraT.getCor_tx_nomefantasia());
        cor_tx_inscestadual.setValue(cor_corretoraT.getCor_tx_inscestadual());
        cor_tx_responsavel.setValue(cor_corretoraT.getCor_tx_responsavel());
        cor_tx_tipologradouro.setValue(cor_corretoraT.getCor_tx_tipologradouro());
        cor_tx_logradouro.setValue(cor_corretoraT.getCor_tx_logradouro());
        cor_tx_numero.setValue(cor_corretoraT.getCor_tx_numero());
        cor_tx_cep.setValue(cor_corretoraT.getCor_tx_cep());
        cor_tx_complemento.setValue(cor_corretoraT.getCor_tx_complemento());
        cor_tx_bairro.setValue(cor_corretoraT.getCor_tx_bairro());
        cor_tx_municipio.setValue(cor_corretoraT.getCor_tx_municipio());
        cor_tx_uf.setValue(cor_corretoraT.getCor_tx_uf());

        comboUF.setValue(listUF.getTreeUF().get(cor_corretoraT.getCor_tx_uf()));
        comboTipoLogradouro.setValue(listTipoLogradouroGWT.getTree().get(cor_corretoraT.getCor_tx_tipologradouro()));

        cor_tx_telefone1.setValue(cor_corretoraT.getCor_tx_telefone1());
        cor_tx_telefone2.setValue(cor_corretoraT.getCor_tx_telefone2());

    }

    public void btnUpdateAction(ButtonEvent ce) {
        String msg = "";
        if (!cor_tx_cnpj.validate() ) {
            msg += "Cnpj é obrigatório.<br/>";
        }
        if (!cor_tx_razaosocial.validate() ) {
            msg += "Razao Social é obrigatório.<br/>";
        }
        if (!cor_tx_nomefantasia.validate() ) {
            msg += "Nome Fantasia é obrigatório.<br/>";
        }
        if (!cor_tx_inscestadual.validate() ) {
            msg += "Inscricao Estadual é obrigatório.<br/>";
        }
        if (!cor_tx_responsavel.validate() ) {
            msg += "Responsavel é obrigatório.<br/>";
        }
        if (!cor_tx_cep.validate() ) {
            msg += "CEP é obrigatório.<br/>";
        }
        if (!cor_tx_nomefantasia.validate() ) {
            msg += "Nome Fantasia é obrigatório.<br/>";
        }
        if (!cor_tx_responsavel.validate() ) {
            msg += "Responsavel é obrigatório.<br/>";
        }
        if (!cor_tx_municipio.validate() ) {
            msg += "Municipio é obrigatório.<br/>";
        }
        if (!comboUF.validate() ) {
            msg += "UF é obrigatório.<br/>";
        }
        if (!comboTipoLogradouro.validate() ) {
            msg += "Municipio é obrigatório.<br/>";
        }
        if (!cor_tx_telefone1.validate() ) {
            msg += "Telefone(1) é obrigatório.<br/>";
        }

        if (msg.trim().length() > 0) {
            MessageBox.alert("Problemas na validação", msg, null);
        } else {
            cor_corretoraT.setCor_nr_id(Integer.parseInt(cor_nr_id.getValue()));
            cor_corretoraT.setCor_tx_cnpj(cor_tx_cnpj.getValue());
            cor_corretoraT.setCor_tx_razaosocial(cor_tx_razaosocial.getValue());
            cor_corretoraT.setCor_tx_nomefantasia(cor_tx_nomefantasia.getValue());
            cor_corretoraT.setCor_tx_inscestadual(cor_tx_inscestadual.getValue());
            cor_corretoraT.setCor_tx_responsavel(cor_tx_responsavel.getValue());
            cor_corretoraT.setCor_tx_tipologradouro(comboTipoLogradouro.getValue().getValue());
            cor_corretoraT.setCor_tx_logradouro(cor_tx_logradouro.getValue());
            cor_corretoraT.setCor_tx_numero(cor_tx_numero.getValue());
            cor_corretoraT.setCor_tx_cep(cor_tx_cep.getValue());
            cor_corretoraT.setCor_tx_complemento(cor_tx_complemento.getValue());
            cor_corretoraT.setCor_tx_bairro(cor_tx_bairro.getValue());
            cor_corretoraT.setCor_tx_municipio(cor_tx_municipio.getValue());
            cor_corretoraT.setCor_tx_uf(comboUF.getValue().getValue());
            cor_corretoraT.setCor_tx_telefone1(cor_tx_telefone1.getValue());
            cor_corretoraT.setCor_tx_telefone2(cor_tx_telefone2.getValue());

            cor_corretoraDao.alterar(cor_corretoraT);
            Timer timer = new Timer() {

                public void run() {
                    String msg = cor_corretoraDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            cor_corretoraConsult.load();
                            setVisible(false);
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void btnDeltAction(ButtonEvent ce) {

        cor_corretoraDao.excluir(cor_corretoraT);
        Timer timer = new Timer() {

            public void run() {
                String msg = cor_corretoraDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        cor_corretoraConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the cor_corretoraConsult
     */
    public Cor_corretoraConsultGWT getCor_corretoraConsult() {
        return cor_corretoraConsult;
    }

    /**
     * @param cor_corretoraConsult the cor_corretoraConsult to set
     */
    public void setCor_corretoraConsult(Cor_corretoraConsultGWT cor_corretoraConsult) {
        this.cor_corretoraConsult = cor_corretoraConsult;
    }
}
