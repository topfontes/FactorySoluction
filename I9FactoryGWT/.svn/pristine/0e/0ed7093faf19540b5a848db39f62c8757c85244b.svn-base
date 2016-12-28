/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.i9factory.client.TipoLogradouroTGWT;
import br.com.i9factory.client.i9factory.factory.dao.Bco_bancoDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Org_orgaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.iconsAll.Icones;
import br.com.i9factory.client.i9factory.factory.transfer.Bco_bancoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Org_orgaoTGWT;
import br.com.i9factory.client.i9factory.factory.util.ListMtc_motivo_cancelamento;
import br.com.i9factory.client.i9factory.factory.util.Mtc_motivo_cancelamento;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.user.client.ui.Label;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class CamposCriteriosGWT extends Window {

    private RadioGroup estadocivil = new RadioGroup();
    private Radio solteiro = new Radio();
    private Radio casado = new Radio();

    private RadioGroup sexo = new RadioGroup();
    private Radio masculino = new Radio();
    private Radio feminino = new Radio();

    private RadioGroup ativo = new RadioGroup();
    private Radio ativosim = new Radio();
    private Radio ativonao = new Radio();

    private RadioGroup inadimplentes = new RadioGroup();
    private Radio avencer = new Radio();
    private Radio vencidas = new Radio();
    private Radio quitadas = new Radio();

    private ComboBox<Mtc_motivo_cancelamento> cbCancelamento = new ComboBox<Mtc_motivo_cancelamento>();
    private ComboBox<Org_orgaoTGWT> cbOrgao = new ComboBox<Org_orgaoTGWT>();
    private ComboBox<Bco_bancoTGWT> cbBanco = new ComboBox<Bco_bancoTGWT>();
    private ComboBox<TipoLogradouroTGWT> comboTipoLogradouro = new ComboBox<TipoLogradouroTGWT>();

    private CheckBox chkAtivo = new CheckBox();
    private CheckBox chkEstadoCivil = new CheckBox();
    private CheckBox chkOrgao = new CheckBox();
    private CheckBox chkBanco = new CheckBox();
    private CheckBox chkSexo = new CheckBox();
    private CheckBox chkMotivo = new CheckBox();
    private CheckBox chkInadimplentes = new CheckBox();
    private MalaDireta malaDireta = new MalaDireta();

    private List<CheckBox> listchk = new ArrayList<CheckBox>();
    private final int metodo;

    public CamposCriteriosGWT(final MalaDireta malaDireta, final int metodo) {
        //getToolBarMaster().add(button);

        this.malaDireta = malaDireta;
        this.metodo = metodo;
        this.setSize(450, 300);

        chkAtivo.setId("1");
        chkEstadoCivil.setId("2");
        chkSexo.setId("3");
        chkMotivo.setId("4");
        chkOrgao.setId("5");
        chkBanco.setId("6");
        chkInadimplentes.setId("7");

        setHeading("Critérios");
        TableLayout layout = new TableLayout();
        layout.setColumns(3);
        layout.setCellPadding(5);
        setLayout(layout);

        preencherCombos();

        solteiro.setBoxLabel("Solteiro");
        casado.setBoxLabel("Casado");
        estadocivil.add(solteiro);
        estadocivil.add(casado);

        masculino.setBoxLabel("Masculino");
        feminino.setBoxLabel("Feminino");
        sexo.add(masculino);
        sexo.add(feminino);

        ativosim.setBoxLabel("Sim");
        ativonao.setBoxLabel("Não");
        ativo.add(ativosim);
        ativo.add(ativonao);

        avencer.setBoxLabel("A Vencer");
        vencidas.setBoxLabel("Vencidas");
        quitadas.setBoxLabel("Quitadas");
        inadimplentes.add(vencidas);
        inadimplentes.add(avencer);
        inadimplentes.add(quitadas);

        this.add(new Label("Cliente ativo:"));
        this.add(chkAtivo);
        listchk.add(chkAtivo);
        this.add(ativo);
        ativo.setVisible(false);

        this.add(new Label("Estado civil:"));
        this.add(chkEstadoCivil);
        listchk.add(chkEstadoCivil);
        this.add(estadocivil);
        estadocivil.setVisible(false);

        this.add(new Label("Sexo:"));
        this.add(chkSexo);
        listchk.add(chkSexo);
        this.add(sexo);
        sexo.setVisible(false);

        this.add(new Label("Motivo cancelamento:"));
        this.add(chkMotivo);
        listchk.add(chkMotivo);
        this.add(cbCancelamento);
        cbCancelamento.setVisible(false);

        this.add(new Label("Orgão:"));
        this.add(chkOrgao);
        listchk.add(chkOrgao);
        this.add(cbOrgao);
        cbOrgao.setVisible(false);

        this.add(new Label("Banco:"));
        this.add(chkBanco);
        listchk.add(chkBanco);
        this.add(cbBanco);
        cbBanco.setVisible(false);

        this.add(new Label("Status das Parcelas:"));
        this.add(chkInadimplentes);
        listchk.add(chkInadimplentes);
        this.add(inadimplentes);
        inadimplentes.setVisible(false);
        eventoCheckbox();

        ToolBar bar = new ToolBar();
        Button btnExecult = new Button("Imprimir");
        btnExecult.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                malaDireta.setCriteirios(getCritérios());
                if (metodo == 1) {
                    malaDireta.filtrarCriterios();
                } else {
                    malaDireta.exportarPDFCriterios();
                }
                close();
            }
        });

        btnExecult.setIcon(Icones.ICONS.print2());
        bar.setAlignment(Style.HorizontalAlignment.CENTER);
        bar.add(btnExecult);
        setBottomComponent(bar);
        layout();
    }

    public String getCritérios() {
        String criterio = "&";
        for (CheckBox box : listchk) {
            if (box.getValue().booleanValue()) {
                if (box.getId().equalsIgnoreCase("1")) {
                    String vl  =ativo.getValue() == ativosim ?"S":"N";
                    criterio +=  "ativo="+vl+"&";
                } else if (box.getId().equalsIgnoreCase("2")) {
                    String vl = estadocivil.getValue() == solteiro ? "S" : "C";
                    criterio += "estadocivil=" + vl + "&";
                } else if (box.getId().equalsIgnoreCase("3")) {
                    String vl = sexo.getValue() ==masculino ? "M" : "F";
                    criterio += "sexo=" + vl + "&";
                } else if (box.getId().equalsIgnoreCase("4")) {
                    String vl = cbCancelamento.getValue().getMtc_nr_id() + "";
                    criterio += "cancelamento=" + vl + "&";
                } else if (box.getId().equalsIgnoreCase("5")) {
                    String vl = cbOrgao.getValue().getOrg_nr_id() + "";
                    criterio += "orgao=" + vl + "&";
                } else if (box.getId().equalsIgnoreCase("6")) {
                    String vl = cbBanco.getValue().getBco_nr_id() + "";
                    criterio += "banco=" + vl + "&";
                } else if (box.getId().equalsIgnoreCase("7")) {
                    String vl = inadimplentes.getValue() == avencer ? "A" : inadimplentes.getValue() == vencidas ? "V" : "Q";
                    criterio += "status=" + vl + "&";
                }
            }
        }

        return criterio;
    }

    public void eventoCheckbox() {
        chkAtivo.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {

                ativo.setVisible(chkAtivo.getValue().booleanValue());
                ativo.setValue(null);
            }
        });

        chkEstadoCivil.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                estadocivil.setVisible(chkEstadoCivil.getValue().booleanValue());
                estadocivil.setValue(null);
            }
        });
        chkSexo.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                sexo.setVisible(chkSexo.getValue().booleanValue());
                sexo.setValue(null);
            }
        });
        chkMotivo.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                cbCancelamento.setVisible(chkMotivo.getValue().booleanValue());
                cbCancelamento.setValue(null);
            }
        });
        chkOrgao.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                cbOrgao.setVisible(chkOrgao.getValue().booleanValue());
                cbOrgao.setValue(null);
            }
        });
        chkBanco.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                cbBanco.setVisible(chkBanco.getValue().booleanValue());
                cbBanco.setValue(null);
            }
        });
        chkInadimplentes.addListener(Events.OnChange, new Listener<FieldEvent>() {
            public void handleEvent(FieldEvent be) {
                inadimplentes.setVisible(chkInadimplentes.getValue().booleanValue());
                inadimplentes.setValue(null);
            }
        });

    }

    public void preencherCombos() {
        ListMtc_motivo_cancelamento list = new ListMtc_motivo_cancelamento();
        ListStore<Mtc_motivo_cancelamento> store = new ListStore<Mtc_motivo_cancelamento>();
        store.add(list.getList());
        cbCancelamento.setDisplayField("mtc_tx_nome");
        cbCancelamento.setStore(store);
        cbCancelamento.setTriggerAction(ComboBox.TriggerAction.ALL);
        addComboBanco();
        addOrgao();
    }

    public void addComboBanco() {
        final Bco_bancoDAOGWT bco_bancoDAOGWT = new Bco_bancoDAOGWT();
        bco_bancoDAOGWT.consultarTodos();
        cbBanco.setDisplayField("bco_tx_nome");
        //cbBanco.setAllowBlank(false);
        cbBanco.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbBanco.setWidth(250);

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (bco_bancoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    cbBanco.setStore(bco_bancoDAOGWT.getList());
                    cbBanco.getView().refresh();
                    layout();
                }

            }
        };
        timer.schedule(500);
    }

    public void addOrgao() {
        final Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();
        org_orgaoDAOGWT.consultarTodos();
        cbOrgao.setDisplayField("org_tx_nomefantasia");
        //cbOrgao.setAllowBlank(false);
        cbOrgao.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbOrgao.setWidth(250);

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (org_orgaoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    cbOrgao.setStore(org_orgaoDAOGWT.getList());
                    cbOrgao.getView().refresh();
                    layout();
                }

            }
        };
        timer.schedule(500);
    }

}
