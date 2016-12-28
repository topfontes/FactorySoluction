package br.com.i9factory.client.i9factory.factory.orcl_orgao_cliente;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

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
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Orcl_orgao_clienteUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Orcl_orgao_clienteConsultGWT orcl_orgao_clienteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Orcl_orgao_clienteDAOGWT orcl_orgao_clienteDao = new Orcl_orgao_clienteDAOGWT();
    private Orcl_orgao_clienteTGWT orcl_orgao_clienteT;
    private TextField<String> orcl_nr_id = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> org_nr_id = new TextField<String>();
    private ComboBox<Org_orgaoTGWT> comboOrgao = new ComboBox<Org_orgaoTGWT>();
    private Cli_clienteTGWT cli_clienteTGWT;
    private Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();

    public Orcl_orgao_clienteUpdateDeleteGWT(Cli_clienteTGWT cli_clienteTGWT) {
        org_orgaoDAOGWT.consultarTodos();
        this.cli_clienteTGWT = cli_clienteTGWT;
        this.setHeading("Alterar Orgão Cliente - " + cli_clienteTGWT.getCli_tx_nome());
        this.setSize(350, 110);

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);
        montarTela();
    }

    private void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (org_orgaoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    getCpMaster().add(new LabelField("Orgão:"));
                    comboOrgao.setStore(org_orgaoDAOGWT.getList());
                    comboOrgao.setDisplayField("org_tx_nomefantasia");
                    comboOrgao.setAllowBlank(false);
                    comboOrgao.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboOrgao.setWidth(250);
                    getCpMaster().add(comboOrgao);
                    comboOrgao.setValue(org_orgaoDAOGWT.getTree().get(orcl_orgao_clienteT.getOrg_nr_id()));

                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void load(Orcl_orgao_clienteTGWT orcl_orgao_clienteT) {
        this.orcl_orgao_clienteT = orcl_orgao_clienteT;
        orcl_nr_id.setValue(orcl_orgao_clienteT.getOrcl_nr_id() + "");
        cli_nr_id.setValue(orcl_orgao_clienteT.getCli_nr_id() + "");
        org_nr_id.setValue(orcl_orgao_clienteT.getOrg_nr_id() + "");

        comboOrgao.setValue(org_orgaoDAOGWT.getTree().get(orcl_orgao_clienteT.getOrg_nr_id()));
    }

    public void btnUpdateAction(ButtonEvent ce) {
        orcl_orgao_clienteT.setOrcl_nr_id(Integer.parseInt(orcl_nr_id.getValue()));
        orcl_orgao_clienteT.setCli_nr_id(cli_clienteTGWT.getCli_nr_id());
        orcl_orgao_clienteT.setOrg_nr_id(comboOrgao.getValue().getOrg_nr_id());

        orcl_orgao_clienteDao.alterar(orcl_orgao_clienteT);
        Timer timer = new Timer() {

            public void run() {
                String msg = orcl_orgao_clienteDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        orcl_orgao_clienteConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        orcl_orgao_clienteDao.excluir(orcl_orgao_clienteT);
        Timer timer = new Timer() {

            public void run() {
                String msg = orcl_orgao_clienteDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        orcl_orgao_clienteConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the orcl_orgao_clienteConsult
     */
    public Orcl_orgao_clienteConsultGWT getOrcl_orgao_clienteConsult() {
        return orcl_orgao_clienteConsult;
    }

    /**
     * @param orcl_orgao_clienteConsult the orcl_orgao_clienteConsult to set
     */
    public void setOrcl_orgao_clienteConsult(Orcl_orgao_clienteConsultGWT orcl_orgao_clienteConsult) {
        this.orcl_orgao_clienteConsult = orcl_orgao_clienteConsult;
    }
}
