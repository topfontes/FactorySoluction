/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.orcl_orgao_cliente;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;
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
public class Orcl_orgao_clienteInsertGWT extends CadastrarBaseGWT {

    private Orcl_orgao_clienteConsultGWT orcl_orgao_clienteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Orcl_orgao_clienteDAOGWT orcl_orgao_clienteDao = new Orcl_orgao_clienteDAOGWT();
    private TextField<String> orcl_nr_id = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> org_nr_id = new TextField<String>();
    private ComboBox<Org_orgaoTGWT> comboOrgao = new ComboBox<Org_orgaoTGWT>();
    private Cli_clienteTGWT cli_clienteTGWT;
    private Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();
    private ComboBox<Bco_bancoTGWT> comboBanco = new ComboBox<Bco_bancoTGWT>();
    private Bco_bancoDAOGWT bco_bancoDAOGWT = new Bco_bancoDAOGWT();
    private TextField<String> cco_tx_nragencia = new TextField<String>();
    private TextField<String> cco_tx_nrcontacorrente = new TextField<String>();
    private Locate_ClienteGWT locate_ClienteGWT;

    public Orcl_orgao_clienteInsertGWT(Cli_clienteTGWT cli_clienteTGWT) {
        bco_bancoDAOGWT.consultarTodos();
        org_orgaoDAOGWT.consultarTodos();

        cco_tx_nragencia.setAllowBlank(false);
        cco_tx_nrcontacorrente.setAllowBlank(false);

        addComboBanco();
        this.cli_clienteTGWT = cli_clienteTGWT;
        this.setHeading("Cadastro Orgão Cliente - " + cli_clienteTGWT.getCli_tx_nome());
        this.setSize(350, 220);

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);
        montarTela();


    }

    public void addComboBanco() {

        comboBanco.setDisplayField("bco_tx_nome");
        comboBanco.setAllowBlank(false);
        comboBanco.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboBanco.setWidth(250);

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (bco_bancoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    comboBanco.setStore(bco_bancoDAOGWT.getList());
                    comboBanco.getView().refresh();
                }

            }
        };
        timer.schedule(500);
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
                    getCpMaster().add(new LabelField("Banco:"));
                    getCpMaster().add(comboBanco);

                    getCpMaster().add(new LabelField("Agência:"));
                    getCpMaster().add(cco_tx_nragencia);

                    getCpMaster().add(new LabelField("Conta:"));
                    getCpMaster().add(cco_tx_nrcontacorrente);

                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void btnInsertAction(ButtonEvent ce) {
        Orcl_orgao_clienteTGWT orcl_orgao_clienteT = new Orcl_orgao_clienteTGWT();
        orcl_orgao_clienteT.setCli_nr_id(cli_clienteTGWT.getCli_nr_id());
        orcl_orgao_clienteT.setOrg_nr_id(comboOrgao.getValue().getOrg_nr_id());

        final Cco_contacorrenteTGWT cco_contacorrenteTGWT = new Cco_contacorrenteTGWT();
        cco_contacorrenteTGWT.setBco_nr_id(comboBanco.getValue().getBco_nr_id());
        cco_contacorrenteTGWT.setCco_tx_nragencia(cco_tx_nragencia.getValue());
        cco_contacorrenteTGWT.setCco_tx_nrcontacorrente(cco_tx_nrcontacorrente.getValue());
        cco_contacorrenteTGWT.setCli_nr_id(cli_clienteTGWT.getCli_nr_id());
        cco_contacorrenteTGWT.setCco_tx_nomecorrentista(cli_clienteTGWT.getCli_tx_nome());
        cco_contacorrenteTGWT.setOrg_nr_id(comboOrgao.getValue().getOrg_nr_id());
        cco_contacorrenteTGWT.setBco_tx_nome(comboBanco.getValue().getBco_tx_nome());
        cco_contacorrenteTGWT.setOrg_tx_nome(comboOrgao.getValue().getOrg_tx_nomefantasia());

        orcl_orgao_clienteDao.inserir(orcl_orgao_clienteT, cco_contacorrenteTGWT);
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
                        btnLimpartAction(null);
                        if (orcl_orgao_clienteConsult != null) {
                            orcl_orgao_clienteConsult.load();
                        }else if(locate_ClienteGWT != null){
                            locate_ClienteGWT.setCco_contacorrenteTGWT(cco_contacorrenteTGWT);
                            locate_ClienteGWT.confirma();
                        }
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public boolean valido() {

        boolean res = true;

        if (cco_tx_nragencia.getValue() == null || cco_tx_nragencia.getValue().trim().length() == 0) {
            res = false;
            MessageBox.alert("ATENÇÃO", "O campo conta tem preenchimento obrigatório", null);
        }

        if (cco_tx_nrcontacorrente.getValue() == null || cco_tx_nrcontacorrente.getValue().trim().length() == 0) {
            res = false;
            MessageBox.alert("ATENÇÃO", "O campo número da conta tem preenchimento obrigatório", null);
        }

        return res;

    }

    public void btnLimpartAction(ButtonEvent ce) {
        orcl_nr_id.setValue("");
        cli_nr_id.setValue("");
        org_nr_id.setValue("");
        comboOrgao.setValue(null);
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
