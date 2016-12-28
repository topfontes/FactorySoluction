package br.com.i9factory.client.i9factory.factory.cco_contacorrente;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.i9factory.client.i9factory.factory.cli_cliente.Locate_ClienteGWT;

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
public class Cco_contacorrenteUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Cco_contacorrenteConsultGWT cco_contacorrenteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Cco_contacorrenteDAOGWT cco_contacorrenteDao = new Cco_contacorrenteDAOGWT();
    private Cco_contacorrenteTGWT cco_contacorrenteT;
    private TextField<String> cco_nr_id = new TextField<String>();
    private TextField<String> cco_tx_nragencia = new TextField<String>();
    private TextField<String> cco_tx_nrcontacorrente = new TextField<String>();
    private TextField<String> cco_tx_nomecorrentista = new TextField<String>();
    private TextField<String> cco_bt_arqremessabanco = new TextField<String>();
    private TextField<String> cco_bt_arqretornobanco = new TextField<String>();
    private TextField<String> bco_nr_id = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> cor_nr_id = new TextField<String>();
    private TextField<String> age_nr_id = new TextField<String>();
    private Cli_clienteTGWT cli_clienteTGWT;
    private Org_orgaoTGWT org_orgaoTGWT;
    private ComboBox<Bco_bancoTGWT> comboBanco = new ComboBox<Bco_bancoTGWT>();
    private Bco_bancoDAOGWT bco_bancoDAOGWT = new Bco_bancoDAOGWT();
    private Locate_ClienteGWT locate_ClienteGWT;

    public Cco_contacorrenteUpdateDeleteGWT(Cli_clienteTGWT cli_clienteTGWT, Org_orgaoTGWT org_orgaoTGWT) {
        this.setSize("500", "200");
        bco_bancoDAOGWT.consultarTodos();

        this.setHeading("Alterar Conta Correte - " + cli_clienteTGWT.getCli_tx_nome() + ", Orgão " + org_orgaoTGWT.getOrg_tx_nomefantasia());

        this.cli_clienteTGWT = cli_clienteTGWT;
        this.org_orgaoTGWT = org_orgaoTGWT;
        TableLayout tableLayout = new TableLayout(2);
        tableLayout.setCellPadding(3);
        getCpMaster().setLayout(tableLayout);
        montarTela();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (bco_bancoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    getCpMaster().add(new LabelField("Banco:"));
                    addComboBanco();
                    getCpMaster().add(comboBanco);

                    getCpMaster().add(new LabelField("Agência:"));
                    cco_tx_nragencia.setAllowBlank(false);
                    cco_tx_nragencia.setMaxLength(10);
                    getCpMaster().add(cco_tx_nragencia);

                    getCpMaster().add(new LabelField("Conta Corrente:"));
                    cco_tx_nrcontacorrente.setAllowBlank(false);
                    cco_tx_nrcontacorrente.setMaxLength(10);
                    getCpMaster().add(cco_tx_nrcontacorrente);
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addComboBanco() {
        comboBanco.setStore(bco_bancoDAOGWT.getList());
        comboBanco.setDisplayField("bco_tx_nome");
        comboBanco.setAllowBlank(false);
        comboBanco.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboBanco.setWidth(250);
        comboBanco.setValue(bco_bancoDAOGWT.getTree().get(cco_contacorrenteT.getBco_nr_id()));

    }

    public void load(Cco_contacorrenteTGWT cco_contacorrenteT) {
        this.cco_contacorrenteT = cco_contacorrenteT;
        cco_nr_id.setValue(cco_contacorrenteT.getCco_nr_id() + "");
        cco_tx_nragencia.setValue(cco_contacorrenteT.getCco_tx_nragencia());
        cco_tx_nrcontacorrente.setValue(cco_contacorrenteT.getCco_tx_nrcontacorrente());
        cco_tx_nomecorrentista.setValue(cco_contacorrenteT.getCco_tx_nomecorrentista());
        comboBanco.setValue(bco_bancoDAOGWT.getTree().get(cco_contacorrenteT.getBco_nr_id()));
    }

    public void btnUpdateAction(ButtonEvent ce) {
        cco_contacorrenteT.setCco_nr_id(cco_contacorrenteT.getCco_nr_id());
        cco_contacorrenteT.setCco_tx_nragencia(cco_tx_nragencia.getValue());
        cco_contacorrenteT.setCco_tx_nrcontacorrente(cco_tx_nrcontacorrente.getValue());
        cco_contacorrenteT.setCco_tx_nomecorrentista(cco_tx_nomecorrentista.getValue());
        cco_contacorrenteT.setBco_nr_id(comboBanco.getValue().getBco_nr_id());
        cco_contacorrenteT.setCli_nr_id(cli_clienteTGWT.getCli_nr_id());
        cco_contacorrenteT.setOrg_nr_id(org_orgaoTGWT.getOrg_nr_id());
        cco_contacorrenteT.setCor_nr_id(0);

        cco_contacorrenteDao.alterar(cco_contacorrenteT);
        Timer timer = new Timer() {

            public void run() {
                String msg = cco_contacorrenteDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        if (locate_ClienteGWT != null) {
                            locate_ClienteGWT.cco_tx_nragencia.setValue(cco_tx_nragencia.getValue());
                            locate_ClienteGWT.cco_tx_nrcontacorrente.setValue(cco_tx_nrcontacorrente.getValue());
                            locate_ClienteGWT.bco_tx_nome.setValue(comboBanco.getValue().getBco_tx_nome());
                        } else {
                            cco_contacorrenteConsult.load();
                        }
                        setVisible(false);
                    }
                }
            }
        };

        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        cco_contacorrenteDao.excluir(cco_contacorrenteT);
        Timer timer = new Timer() {

            public void run() {
                String msg = cco_contacorrenteDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);

                        cco_contacorrenteConsult.load();

                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the cco_contacorrenteConsult
     */
    public Cco_contacorrenteConsultGWT getCco_contacorrenteConsult() {
        return cco_contacorrenteConsult;
    }

    /**
     * @param cco_contacorrenteConsult the cco_contacorrenteConsult to set
     */
    public void setCco_contacorrenteConsult(Cco_contacorrenteConsultGWT cco_contacorrenteConsult) {
        this.cco_contacorrenteConsult = cco_contacorrenteConsult;
    }

    /**
     * @return the locate_ClienteGWT
     */
    public Locate_ClienteGWT getLocate_ClienteGWT() {
        return locate_ClienteGWT;
    }

    /**
     * @param locate_ClienteGWT the locate_ClienteGWT to set
     */
    public void setLocate_ClienteGWT(Locate_ClienteGWT locate_ClienteGWT) {
        this.locate_ClienteGWT = locate_ClienteGWT;
    }
}
