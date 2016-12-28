/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.cco_contacorrente;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;

import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
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
public class Cco_contacorrenteInsertGWT extends CadastrarBaseGWT {

    private Cco_contacorrenteConsultGWT cco_contacorrenteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Cco_contacorrenteDAOGWT cco_contacorrenteDao = new Cco_contacorrenteDAOGWT();
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

    public Cco_contacorrenteInsertGWT(Cli_clienteTGWT cli_clienteTGWT, Org_orgaoTGWT org_orgaoTGWT) {
        bco_bancoDAOGWT.consultarTodos();

        this.setHeading("Cadastro Conta Correte - " + cli_clienteTGWT.getCli_tx_nome()+", Orgão "+org_orgaoTGWT.getOrg_tx_nomefantasia());

        this.cli_clienteTGWT = cli_clienteTGWT;
        this.org_orgaoTGWT = org_orgaoTGWT;

        this.setSize("500", "200");
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

    }

    public void btnInsertAction(ButtonEvent ce) {
        Cco_contacorrenteTGWT cco_contacorrenteT = new Cco_contacorrenteTGWT();
        cco_contacorrenteT.setCco_tx_nragencia(cco_tx_nragencia.getValue());
        cco_contacorrenteT.setCco_tx_nrcontacorrente(cco_tx_nrcontacorrente.getValue());
        cco_contacorrenteT.setCco_tx_nomecorrentista(cli_clienteTGWT.getCli_tx_nome());
//		cco_contacorrenteT.setCco_bt_arqremessabanco(cco_bt_arqremessabanco.getValue());
//		cco_contacorrenteT.setCco_bt_arqretornobanco(cco_bt_arqretornobanco.getValue());
        cco_contacorrenteT.setBco_nr_id(comboBanco.getValue().getBco_nr_id());
        cco_contacorrenteT.setCli_nr_id(cli_clienteTGWT.getCli_nr_id());
        cco_contacorrenteT.setOrg_nr_id(org_orgaoTGWT.getOrg_nr_id());
        cco_contacorrenteT.setCor_nr_id(0);

        cco_contacorrenteDao.inserir(cco_contacorrenteT);
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
                        btnLimpartAction(null);
                        cco_contacorrenteConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        cco_nr_id.setValue("");
        cco_tx_nragencia.setValue("");
        cco_tx_nrcontacorrente.setValue("");
        cco_tx_nomecorrentista.setValue("");
        cco_bt_arqremessabanco.setValue("");
        cco_bt_arqretornobanco.setValue("");
        bco_nr_id.setValue("");
        cli_nr_id.setValue("");
        cor_nr_id.setValue("");
        age_nr_id.setValue("");

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
}
