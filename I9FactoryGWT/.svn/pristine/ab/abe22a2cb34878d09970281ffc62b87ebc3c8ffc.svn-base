package br.com.i9factory.client.i9factory.factory.for_fornecedor;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.ListUF;
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
public class For_fornecedorUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private For_fornecedorConsultGWT for_fornecedorConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private For_fornecedorDAOGWT for_fornecedorDao = new For_fornecedorDAOGWT();
    private For_fornecedorTGWT for_fornecedorT;
    private EasyTextField<String> for_nr_id = new EasyTextField<String>();
    private EasyTextField<String> for_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> for_tx_endereco = new EasyTextField<String>();
    private EasyTextField<String> for_tx_cpf_cnpj = new EasyTextField<String>();
    private EasyTextField<String> for_tx_rg_inscricao = new EasyTextField<String>();
    private EasyTextField<String> for_tx_cep = new EasyTextField<String>();
    private EasyTextField<String> for_tx_cidade = new EasyTextField<String>();
    private EasyTextField<String> for_tx_estado = new EasyTextField<String>();
    private EasyTextField<String> for_tx_bairro = new EasyTextField<String>();
    private EasyTextField<String> for_tx_email = new EasyTextField<String>();
    private EasyTextField<String> for_tx_home_page = new EasyTextField<String>();
    private EasyTextField<String> for_tx_contato = new EasyTextField<String>();
    private EasyTextField<String> for_tx_status = new EasyTextField<String>();
    private EasyTextField<String> for_tx_telefone1 = new EasyTextField<String>();
    private EasyTextField<String> for_tx_telefone2 = new EasyTextField<String>();
    private ListUF listUF = new ListUF();
    private ComboBox<UFTGWT> comboUF = new ComboBox<UFTGWT>();

    public For_fornecedorUpdateDeleteGWT() {
        this.setSize("500", "470");
        this.setHeading("Cadastro de Fornecedor");
        listUF.povoa();

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);

        getCpMaster().setLayout(layout);

        for_tx_nome.setAllowBlank(false);
        for_tx_nome.setWidth(350);
        getCpMaster().add(new LabelField("Nome*:"));
        for_tx_nome.setMaxLength(100);
        getCpMaster().add(for_tx_nome);

        getCpMaster().add(new LabelField("CPF/CNPJ:"));
        for_tx_cpf_cnpj.setMaxLength(15);
        getCpMaster().add(for_tx_cpf_cnpj);

        getCpMaster().add(new LabelField("Inscrição:"));
        for_tx_rg_inscricao.setMaxLength(18);
        getCpMaster().add(for_tx_rg_inscricao);

        for_tx_endereco.setWidth(350);
        getCpMaster().add(new LabelField("Endereço:"));
        for_tx_endereco.setMaxLength(100);
        getCpMaster().add(for_tx_endereco);

        getCpMaster().add(new LabelField("CEP:"));
        for_tx_cep.setMaxLength(10);
        getCpMaster().add(for_tx_cep);

        for_tx_bairro.setWidth(350);
        getCpMaster().add(new LabelField("Bairro:"));
        for_tx_bairro.setMaxLength(100);
        getCpMaster().add(for_tx_bairro);

        for_tx_cidade.setWidth(350);
        getCpMaster().add(new LabelField("Cidade:"));
        for_tx_cidade.setMaxLength(50);
        getCpMaster().add(for_tx_cidade);

        addComboUF();
        getCpMaster().add(new LabelField("UF*:"));
        getCpMaster().add(comboUF);

        for_tx_email.setWidth(350);
        getCpMaster().add(new LabelField("E-mail:"));
        for_tx_email.setMaxLength(200);
        getCpMaster().add(for_tx_email);

        for_tx_home_page.setWidth(350);
        getCpMaster().add(new LabelField("Home Page:"));
        for_tx_home_page.setMaxLength(200);
        getCpMaster().add(for_tx_home_page);

        for_tx_telefone1.setAllowBlank(false);
        getCpMaster().add(new LabelField("Telefone(01)*:"));
        for_tx_telefone1.setMaxLength(20);
        getCpMaster().add(for_tx_telefone1);

        getCpMaster().add(new LabelField("Telefone(02):"));
        for_tx_telefone2.setMaxLength(20);
        getCpMaster().add(for_tx_telefone2);

        for_tx_contato.setWidth(350);
        getCpMaster().add(new LabelField("Contatos:"));
        for_tx_contato.setMaxLength(100);
        getCpMaster().add(for_tx_contato);

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

    public void load(For_fornecedorTGWT for_fornecedorT) {
        this.for_fornecedorT = for_fornecedorT;
        for_nr_id.setValue(for_fornecedorT.getFor_nr_id() + "");
        for_tx_nome.setValue(for_fornecedorT.getFor_tx_nome());
        for_tx_endereco.setValue(for_fornecedorT.getFor_tx_endereco());
        for_tx_cpf_cnpj.setValue(for_fornecedorT.getFor_tx_cpf_cnpj());
        for_tx_rg_inscricao.setValue(for_fornecedorT.getFor_tx_rg_inscricao());
        for_tx_cep.setValue(for_fornecedorT.getFor_tx_cep() + "");
        for_tx_cidade.setValue(for_fornecedorT.getFor_tx_cidade());
        for_tx_estado.setValue(for_fornecedorT.getFor_tx_estado());
        for_tx_bairro.setValue(for_fornecedorT.getFor_tx_bairro());
        for_tx_email.setValue(for_fornecedorT.getFor_tx_email());
        for_tx_home_page.setValue(for_fornecedorT.getFor_tx_home_page());
        for_tx_contato.setValue(for_fornecedorT.getFor_tx_contato());
        for_tx_status.setValue(for_fornecedorT.getFor_tx_status());
        comboUF.setValue(listUF.getTreeUF().get(for_fornecedorT.getFor_tx_estado()));

    }

    public void btnUpdateAction(ButtonEvent ce) {
        String msg = "";
        if (!for_tx_nome.validate()) {
            msg += "Nome é obrigatório<br/>";
        }
        if (!comboUF.validate()) {
            msg += "Telefone(1) é obrigatório<br/>";
        }
        if (!for_tx_telefone1.validate()) {
            msg += "Telefone(1) é obrigatório<br/>";
        }
        if (msg.trim().length() > 0) {
            MessageBox.alert("Problemas na validação", msg, null);
        } else {
            for_fornecedorT.setFor_nr_id(Integer.parseInt(for_nr_id.getValue()));
            for_fornecedorT.setFor_tx_nome(for_tx_nome.getValue());
            for_fornecedorT.setFor_tx_endereco(for_tx_endereco.getValue());
            for_fornecedorT.setFor_tx_cpf_cnpj(for_tx_cpf_cnpj.getValue());
            for_fornecedorT.setFor_tx_rg_inscricao(for_tx_rg_inscricao.getValue());
            if (for_tx_cep.getValue() != null) {
                for_fornecedorT.setFor_tx_cep(Integer.parseInt(for_tx_cep.getValue()));
            } else {
                for_fornecedorT.setFor_tx_cep(0);
            }
            for_fornecedorT.setFor_tx_cidade(for_tx_cidade.getValue());
            for_fornecedorT.setFor_tx_estado(comboUF.getValue().getValue());
            for_fornecedorT.setFor_tx_bairro(for_tx_bairro.getValue());
            for_fornecedorT.setFor_tx_email(for_tx_email.getValue());
            for_fornecedorT.setFor_tx_home_page(for_tx_home_page.getValue());
            for_fornecedorT.setFor_tx_contato(for_tx_contato.getValue());
            for_fornecedorT.setFor_tx_status(for_tx_status.getValue());
            for_fornecedorT.setFor_tx_telefone1(for_tx_telefone1.getValue());
            for_fornecedorT.setFor_tx_telefone2(for_tx_telefone2.getValue());

            for_fornecedorDao.alterar(for_fornecedorT);
            Timer timer = new Timer() {

                public void run() {
                    String msg = for_fornecedorDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            for_fornecedorConsult.load();
                            setVisible(false);
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void btnDeltAction(ButtonEvent ce) {

        for_fornecedorDao.excluir(for_fornecedorT);
        Timer timer = new Timer() {

            public void run() {
                String msg = for_fornecedorDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        for_fornecedorConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the for_fornecedorConsult
     */
    public For_fornecedorConsultGWT getFor_fornecedorConsult() {
        return for_fornecedorConsult;
    }

    /**
     * @param for_fornecedorConsult the for_fornecedorConsult to set
     */
    public void setFor_fornecedorConsult(For_fornecedorConsultGWT for_fornecedorConsult) {
        this.for_fornecedorConsult = for_fornecedorConsult;
    }
}
