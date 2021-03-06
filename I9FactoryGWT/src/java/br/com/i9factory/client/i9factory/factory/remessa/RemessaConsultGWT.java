/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.remessa;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.i9factory.client.Constantes;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.i9factory.client.i9factory.factory.icons.I9FactoryIcones;
import br.com.i9factory.client.i9factory.factory.iconsAll.Icones;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.CheckChangedEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.CheckBoxListView;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author George Leite Junior
 */
public class RemessaConsultGWT extends CPConsultarBaseGWT {

    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private RemessaDAOGWT remessaDAOGWT = new RemessaDAOGWT();
    private Vw_parcelasDAOGWT vw_parcelasDAOGWT = new Vw_parcelasDAOGWT();
    private Grid<Vw_parcelasTGWT> grid;
    private static String MARCAR_TODOS = "Marcar Todos";
    private static String DESMARCAR_TODOS = "Desmarcar Todos";
    private Button btnGerarRemessa = new Button("Gerar Remessa");
    private Button btnPesquisar = new Button("Pesquisar");
    private Org_orgaoDAOGWT orgDao = new Org_orgaoDAOGWT();
    private Bco_bancoDAOGWT bcoDao = new Bco_bancoDAOGWT();
    //private ComboBox<Org_orgaoTGWT> cbOrgao = new ComboBox<Org_orgaoTGWT>();
    private ComboBox<Bco_bancoTGWT> cbBanco = new ComboBox<Bco_bancoTGWT>();
    private ComboBox<BaseModel> cbTipo = new ComboBox<BaseModel>();
    private EasyNumberField etfSequencial = new EasyNumberField();
    private DateField dfVencimento = new DateField();
    private DateField dfEnvio = new DateField();
    private HashMap<Integer, Org_orgaoTGWT> mapOrg = new HashMap<Integer, Org_orgaoTGWT>();
    private Window winOrgao = new Window();
    private String actionButton;
    private CheckBoxListView<Org_orgaoTGWT> listview;
    private TreeMap<Integer, Org_orgaoTGWT> treOrgaoSelecionado = new TreeMap<Integer, Org_orgaoTGWT>();
    private TreeMap<Integer, Org_orgaoTGWT> treOrgaoConsult = new TreeMap<Integer, Org_orgaoTGWT>();
    private ListStore<Org_orgaoTGWT> StoreOrgao = new ListStore<Org_orgaoTGWT>();
    private ContentPanel cp = new ContentPanel(new FillLayout());
    private ListStore<Vw_parcelasTGWT> list;
    private CheckBoxSelectionModel<Vw_parcelasTGWT> chk = new CheckBoxSelectionModel<Vw_parcelasTGWT>();
    private ListStore<Org_orgaoTGWT> listOrgao = new ListStore<Org_orgaoTGWT>();
    private FormPanel formDownload = new FormPanel();
    private Button btnDownload = new Button("Download", ICONS.download());
    private ListStore<Org_orgaoTGWT> listOrg;
    private String orgaosIds;
    private CheckBox chksalariominimo = new CheckBox();

    //private CheckBoxSelectionModel<Vw_parcelasTGWT> sm;
    public RemessaConsultGWT() {
        getCpTop().setHeight(27);
        getToolBarMaster().setHeight(26);
        createWindowOrgao();
        btnDownload.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                submeter();
            }
        });

        formDownload.setLayout(new CenterLayout());
        formDownload.addButton(btnDownload);

        formDownload.setHeaderVisible(false);
        //formDownload.set
        formDownload.setAction(Constantes.URL + vw_parcelasDAOGWT.PAGE_CONSULTAR_REMESSA);
        formDownload.setEncoding(FormPanel.Encoding.MULTIPART);
        formDownload.setMethod(FormPanel.Method.POST);
        formDownload.setFrame(true);
        formDownload.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                for (int i = 0; i < formDownload.getItemCount(); i++) {
                    formDownload.getItems().get(i).clearState();
                }
            }
        });

        this.setHeaderVisible(false);

        //cbOrgao.setEmptyText("Selecione um Orgao");
        //cbOrgao.setDisplayField("org_tx_nomefantasia");
        //cbOrgao.setTriggerAction(ComboBox.TriggerAction.ALL);
        actionButton = "Marcar Todos";
        //getToolBarPage().setVisible(false);

        cbBanco.setEmptyText("Selecione um Banco");
        cbBanco.setDisplayField("bco_tx_nome");
        cbBanco.setTriggerAction(ComboBox.TriggerAction.ALL);

        cbTipo.setEmptyText("Selecione o Tipo");
        cbTipo.setDisplayField("tipo");
        cbTipo.setTriggerAction(ComboBox.TriggerAction.ALL);

        dfVencimento.setWidth(100);
        dfVencimento.getPropertyEditor().setFormat(dtfDate);
        dfEnvio.getPropertyEditor().setFormat(dtfDate);

        getBtnNovoSuper().setVisible(false);

//        getBtnNovoSuper().setToolTip("");
//        getBtnNovoSuper().setIcon(I9FactoryIcones.I9FACTORY_ICONS.checkall());
//        getBtnNovoSuper().setText(MARCAR_TODOS);
        btnGerarRemessa.setIcon(I9FactoryIcones.I9FACTORY_ICONS.raio());
        btnPesquisar.setIcon(ICONS.find());
        etfSequencial.setMaxLength(5);
        etfSequencial.setEmptyText("Nr. Seq.");
        etfSequencial.setTitle("Defina o numero sequencial.");
        etfSequencial.setWidth(50);
        getToolBarMaster().add(new SeparatorToolItem());
        //getToolBarMaster().add(cbOrgao);
        dfEnvio.setWidth(100);
        getToolBarMaster().add(cbBanco);
        getToolBarMaster().add(cbTipo);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(dfVencimento);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnPesquisar);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(dfEnvio);
        getToolBarMaster().add(etfSequencial);
        getToolBarMaster().add(btnGerarRemessa);
        dfEnvio.setValue(new Date());

        btnPesquisar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                //load();
                chksalariominimo.setValue(false);
                winOrgao.setVisible(true);
                getBtnNovoSuper().setIcon(I9FactoryIcones.I9FACTORY_ICONS.checkall());
                getBtnNovoSuper().setText(MARCAR_TODOS);
            }
        });
        btnGerarRemessa.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                //   gerarRemessa();
                validaRemessa();
            }
        });
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<RemessaTGWT>> numberRenderer = new NumberCellRenderer<Grid<RemessaTGWT>>(currency);
        GridCellRenderer<Vw_parcelasTGWT> cellRenderTipo = new GridCellRenderer<Vw_parcelasTGWT>() {

            public Object render(Vw_parcelasTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_parcelasTGWT> store, Grid<Vw_parcelasTGWT> grid) {
                return "P".equals(model.getPle_tx_tipo()) ? "Parcela" : "Mensalidade";
            }
        };

        GridCellRenderer<Vw_parcelasTGWT> celRenderCheck = new GridCellRenderer<Vw_parcelasTGWT>() {

            public Object render(Vw_parcelasTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_parcelasTGWT> store, Grid<Vw_parcelasTGWT> grid) {
                return new Button(model.getOrg_tx_nome());
            }
        };

//        sm = new CheckBoxSelectionModel<Vw_parcelasTGWT>();
//        configs.add(sm.getColumn());
        SummaryColumnConfig column = null;

//        column = new SummaryColumnConfig();
//        column.setId("imgCheck");
//        column.setWidth(30);
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setRenderer(getEditarRender());
//        configs.add(column);
        //chk.setLocked(true);
//        configs.add(chk.getColumn());
        column = new SummaryColumnConfig();
        column.setId("ple_nr_id");
        column.setHeader("ID Parcela");
        column.setHidden(true);
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("emp_nr_id");
        column.setHeader("ID emprestimo");
        column.setHidden(true);
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("org_tx_nome");
        column.setHeader("Orgao");
        column.setWidth(80);
//        column.setRenderer(celRenderCheck);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("ple_tx_tipo");
        column.setHeader("Tipo");
        column.setWidth(80);
        column.setRenderer(cellRenderTipo);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("ple_dt_vencimento");
        column.setHeader("Vencimento");
        column.setDateTimeFormat(dtfDate);
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("ple_nr_valorparcela");
        column.setHeader("Valor");
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setSummaryType(SummaryType.SUM);
        column.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("ple_nr_valordesconto");
        column.setHeader("Vl. Desconto");
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setSummaryType(SummaryType.SUM);
        column.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("emp_nr_proposta");
        column.setHeader("Proposta");
        column.setNumberFormat(NumberFormat.getFormat("000"));
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("cli_tx_cpf");
        column.setHeader("CPF - cliente");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig();
        column.setId("cli_tx_nome");
        column.setHeader("Nome - cliente");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

//        column = new ColumnConfig();
//        column.setId("linha");
//        column.setHeader("Linha");
//        column.setWidth(700);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);
        loadTipo();
        loadBancos();
        loadOrgaos();
    }

    @Override
    public void btnAtualizarAction(ButtonEvent be) {
        for (Vw_parcelasTGWT wT : grid.getSelectionModel().getSelectedItems()) {
            com.google.gwt.user.client.Window.alert(wT.getCli_tx_cpf());
        }

    }

    public void createWindowOrgao() {

        final Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();
        org_orgaoDAOGWT.consultarTodos();
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (org_orgaoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    listOrgao = org_orgaoDAOGWT.getList();
                    listview = new CheckBoxListView<Org_orgaoTGWT>() {

                        @Override
                        protected Org_orgaoTGWT prepareData(Org_orgaoTGWT model) {
                            String s = model.get("CodigoNome");
                            model.set("CodigoNome", Format.ellipse(s, 40));
                            return model;
                        }
                    };
                    //com.google.gwt.user.client.Window.alert(StoreOrgao.getCount()+"");
                    listview.setStore(listOrgao);
                    listview.setDisplayProperty("CodigoNome");
                    cp.add(listview);
                    listview.refresh();
                    cp.layout();
                    winOrgao.layout();
                }
            }
        };
        timer.schedule(500);

        final CheckBox box = new CheckBox();
        box.setBoxLabel("Marcar todos");


        box.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                
                changeBox(box.getValue().booleanValue());
                box.setBoxLabel(box.getValue().booleanValue()?"Desmarcar todos":"Marcar todos");
            }
        });

        chksalariominimo.setBoxLabel("Benefício de um salário mínimo");
        ToolBar bar = new ToolBar();
        bar.add(box);
        bar.add(new LabelToolItem("  "));
        bar.add(chksalariominimo);
        cp.setTopComponent(bar);

        cp.setHeaderVisible(false);
        cp.setFrame(false);
        cp.setBodyBorder(false);
        winOrgao.setSize(300, 450);
        winOrgao.setModal(true);
        winOrgao.setLayout(new FillLayout());
        winOrgao.add(cp);

        ToolBar barBottom = new ToolBar();
        barBottom.setAlignment(HorizontalAlignment.CENTER);
        Button btnTop = new Button(actionButton, Icones.ICONS.carimbo());
        Button btnBotton = new Button("Aplicar", ICONS.aplicar());
        barBottom.add(btnBotton);
        winOrgao.setBottomComponent(barBottom);
        btnBotton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
                winOrgao.setVisible(false);
            }
        });
    }

    public void changeBox(boolean vl) {
        for (Org_orgaoTGWT org_orgaoTGWT : listview.getStore().getModels()) {
            listview.setChecked(org_orgaoTGWT, vl);
        }
    }

    private void loadOrgaos() {
        orgDao.consultarTodos();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Org_orgaoTGWT> list = orgDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    for (int i = 0; i < list.getCount(); i++) {
                        Org_orgaoTGWT orgT = list.getAt(i);
                        mapOrg.put(orgT.getOrg_nr_id(), orgT);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public String getOrgaosSelecionado() {
        String id_orgaos = "0";
        treOrgaoSelecionado = new TreeMap<Integer, Org_orgaoTGWT>();
        List<Org_orgaoTGWT> list = listview.getChecked();
        if (list != null) {
            for (Org_orgaoTGWT org_orgaoTGWT : list) {
                id_orgaos += "-" + org_orgaoTGWT.getOrg_nr_id();
                listview.setChecked(org_orgaoTGWT, false);
            }
        }
        return id_orgaos;
    }

    private void loadTipo() {
        ListStore<BaseModel> listTipo = new ListStore<BaseModel>();
        BaseModel bmTodos = new BaseModel();
        bmTodos.set("tipo", "Todos");
        BaseModel bmMensalidade = new BaseModel();
        bmMensalidade.set("tipo", "Mensalidade");
        BaseModel bmParcela = new BaseModel();
        bmParcela.set("tipo", "Parcela");
        listTipo.add(bmTodos);
        listTipo.add(bmMensalidade);
        listTipo.add(bmParcela);
        cbTipo.setStore(listTipo);
        cbTipo.getView().refresh();
    }

    public void loadBancos() {
        //orgDao.consultarTodos();
        bcoDao.consultarTodos();
        Timer timer = new Timer() {

            @Override
            public void run() {
                //ListStore<Org_orgaoTGWT> listOrg = orgDao.getList();
                ListStore<Bco_bancoTGWT> listBco = bcoDao.getList();
                if (listBco == null) {
                    schedule(500);
                } else {
                    //cbOrgao.setStore(listOrg);
                    cbBanco.setStore(listBco);
                    //cbOrgao.getView().refresh();
                    cbBanco.getView().refresh();
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void validaRemessa() {

        List<ColumnConfig> listConfigs = new Vector<ColumnConfig>();
        ColumnConfig column = null;

        column = new SummaryColumnConfig();
        column.setId("cli_tx_nome");
        column.setHeader("Nome - cliente");
        column.setWidth(230);
        column.setAlignment(HorizontalAlignment.LEFT);
        listConfigs.add(column);

        column = new ColumnConfig();
        column.setId("ple_dt_vencimento");
        column.setHeader("Vencimento");
        column.setDateTimeFormat(dtfDate);
        column.setWidth(80);
        column.setAlignment(HorizontalAlignment.LEFT);
        listConfigs.add(column);

        column = new ColumnConfig();
        column.setId("ple_nr_valorparcela");
        column.setHeader("Valor");
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        column.setWidth(80);
        column.setAlignment(HorizontalAlignment.RIGHT);
        listConfigs.add(column);

        column = new SummaryColumnConfig();
        column.setId("cli_tx_cpf");
        column.setHeader("CPF - cliente");
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.LEFT);
        listConfigs.add(column);

        column = new SummaryColumnConfig();
        column.setId("org_tx_nome");
        column.setHeader("Orgao");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        listConfigs.add(column);

        ListStore<Vw_parcelasTGWT> list = new ListStore<Vw_parcelasTGWT>();
        list.add(grid.getSelectionModel().getSelectedItems());
        ColumnModel cm = new ColumnModel(listConfigs);
        Grid<Vw_parcelasTGWT> gridSelect = new Grid<Vw_parcelasTGWT>(list, cm);
        gridSelect.getSelectionModel().setSelectionMode(SelectionMode.SIMPLE);
        gridSelect.setStripeRows(true);

        if (list.getCount() > 0) {
            final Window win = new Window();
            win.setLayout(new FillLayout());

            Button btnOk = new Button("Cornifirmar", br.com.easynet.gwt.client.icons.Icones.ICONS.aplicar());
            Button btnCancel = new Button("Cancelar", Icones.ICONS.cancel());

            btnOk.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    gerarRemessa();
                    win.setVisible(false);
                }
            });

            btnCancel.addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    win.setVisible(false);
                }
            });
            win.setModal(true);
            win.setHeading("Títulos que não serão gerados a remessa");
            win.setSize(600, 300);
            win.addButton(btnOk);
            win.addButton(btnCancel);

            win.add(gridSelect);
            win.show();
        } else {
            gerarRemessa();
        }

    }

    public void gerarRemessa() {

        if (etfSequencial.getValue() == null) {
            MessageBox.alert("ATENÇÃO", "É obrigatório informar o número sequencial do arquivo!", null);
            return;
        }
        String param = "0";
        ListStore<Vw_parcelasTGWT> list = new ListStore<Vw_parcelasTGWT>();
        list.add(grid.getSelectionModel().getSelectedItems());
        for (int i = 0; i < grid.getStore().getCount(); i++) {
            if (list.findModel("ple_nr_id", grid.getStore().getAt(i).getPle_nr_id()) == null) {
                Vw_parcelasTGWT vwParT = grid.getStore().getAt(i);
                param += "-" + vwParT.getPle_nr_id();
            }
        }
        if (param.trim().length() > 2) {

            //op=gerarRemessaIdsParcela&idsParcelas&ple_nr_id=7242&ple_nr_id=10565&ple_nr_id=7243&vw_parcelaT.ple_tx_tipo=P&dtEnvio=19/01/2012&nrSeq=123
            //vw_parcelasDAOGWT.gerarRemessaIdsParcela(param);
            String urlAction = Constantes.URL + vw_parcelasDAOGWT.PAGE_CONSULTAR_REMESSA + "?controlidentity=" + System.currentTimeMillis() + "&";
            String url = Constantes.URL + vw_parcelasDAOGWT.PAGE_CONSULTAR_REMESSA;
            url += "?op=gerarRemessaIdsParcela&vw_parcelasT.ple_tx_tipo=" + getTipo() + "&idsParcelas=" + param;
            url +="&bco_nr_id="+cbBanco.getValue().getBco_nr_id();
            url += "&dtEnvio=" + dtfDate.format(dfEnvio.getValue()) + "&nrSeq=" + etfSequencial.getValue();
            url += "&orgaos=" + orgaosIds;
            final Window winDownload = new Window();
            winDownload.setLayout(new FitLayout());
            winDownload.setHeading("Download do arquivo remessa.");
            String form = "<form target=\"novo\" method=\"post\" action=\"" + urlAction + "\">";
            form += "<input type=\"hidden\" name=\"op\" value=\"gerarRemessaIdsParcela\" />";
            form += "<input type=\"hidden\" name=\"idsParcelas\" value=\"" + param + "\" />";
            form += "<input type=\"hidden\" name=\"bco_nr_id\" value=\"" + cbBanco.getValue().getBco_nr_id() + "\" />";
            form += "<input type=\"hidden\" name=\"vw_parcelasT.ple_tx_tipo\" value=\"" + getTipo() + "\" />";
            form += "<input type=\"hidden\" name=\"dtEnvio\" value=\"" + dtfDate.format(dfEnvio.getValue()) + "\" />";
            form += "<input type=\"hidden\" name=\"nrSeq\" value=\"" + etfSequencial.getValue() + "\" />";
            form += "<input type=\"submit\" value=\"Download\"/>";
            form += "</form>";
//            LabelField txtDownload = new LabelField("<a href=\"" + url + "\"> DOWNLOAD </a>");
            LabelField txtDownload = new LabelField(form);
            //winDownload.setUrl(url);
            winDownload.setLayout(new CenterLayout());
            winDownload.add(txtDownload);
            winDownload.setSize(100, 50);
            //winDownload.add(formDownload);
            winDownload.setVisible(true);

        }
    }


    /*
     public void gerarRemessa() {
     if (etfSequencial.getValue() == null) {
     MessageBox.alert("ATENÇÃO", "É obrigatório informar o número sequencial do arquivo!", null);
     return;
     }
     String param = "0";
     ListStore<Vw_parcelasTGWT> list = new ListStore<Vw_parcelasTGWT>();
     list.add(grid.getSelectionModel().getSelectedItems());
     for (int i = 0; i < grid.getStore().getCount(); i++) {
     if (list.findModel("ple_nr_id", grid.getStore().getAt(i).getPle_nr_id()) == null) {
     Vw_parcelasTGWT vwParT = grid.getStore().getAt(i);
     param += "-" + vwParT.getPle_nr_id();
     }
     }
     if (param.trim().length() > 2) {

     //op=gerarRemessaIdsParcela&idsParcelas&ple_nr_id=7242&ple_nr_id=10565&ple_nr_id=7243&vw_parcelaT.ple_tx_tipo=P&dtEnvio=19/01/2012&nrSeq=123
     //vw_parcelasDAOGWT.gerarRemessaIdsParcela(param);
     //String urlAction = Constantes.URL + vw_parcelasDAOGWT.PAGE_CONSULTAR_REMESSA;
     String url = Constantes.URL + vw_parcelasDAOGWT.PAGE_CONSULTAR_REMESSA;
     url += "?op=gerarRemessaIdsParcela&vw_parcelasT.ple_tx_tipo=" + getTipo() + "&idsParcelas=" + param;
     url += "&dtEnvio=" + dtfDate.format(dfEnvio.getValue()) + "&nrSeq=" + etfSequencial.getValue();
     final Window winDownload = new Window();
     winDownload.setLayout(new FitLayout());
     winDownload.setHeading("Download do arquivo remessa.");
     LabelField txtDownload = new LabelField("<a href=\"" + url + "\"> DOWNLOAD </a>");
     //winDownload.setUrl(url);
     winDownload.setLayout(new CenterLayout());
     //winDownload.add(txtDownload);
     winDownload.setSize(100, 50);
     winDownload.add(formDownload);
     winDownload.setVisible(true);


     }
     }

     */
    public String getIds() {
        String param = "0";
        ListStore<Vw_parcelasTGWT> list = new ListStore<Vw_parcelasTGWT>();
        list.add(grid.getSelectionModel().getSelectedItems());
        for (int i = 0; i < grid.getStore().getCount(); i++) {
            if (list.findModel("ple_nr_id", grid.getStore().getAt(i).getPle_nr_id()) == null) {
                Vw_parcelasTGWT vwParT = grid.getStore().getAt(i);
                param += "-" + vwParT.getPle_nr_id();
            }
        }
        return param;
    }

    public void submeter() {
        formDownload.layout();
        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("gerarRemessaIdsParcela");
        formDownload.add(hfOp);

        HiddenField<String> idParcelas = new HiddenField<String>();
        idParcelas.setName("idsParcelas");
        idParcelas.setValue(getIds());
        formDownload.add(idParcelas);

        HiddenField<String> tipo = new HiddenField<String>();
        tipo.setName("vw_parcelaT.ple_tx_tipo");
        tipo.setValue(getTipo());
        formDownload.add(tipo);

        HiddenField<String> nrSeq = new HiddenField<String>();
        nrSeq.setName("nrSeq");
        nrSeq.setValue(etfSequencial.getValue() + "");
        formDownload.add(nrSeq);

        HiddenField<String> dtEnvio = new HiddenField<String>();
        dtEnvio.setName("dtEnvio");
        dtEnvio.setValue(dtfDate.format(dfEnvio.getValue()));
        formDownload.add(dtEnvio);
        formDownload.layout();
        formDownload.submit();

//                    url += "?op=gerarRemessaIdsParcela&idsParcelas=" + param + "&vw_parcelaT.ple_tx_tipo=" + getTipo();
//            url += "&dtEnvio=" + dtfDate.format(dfEnvio.getValue()) + "&nrSeq=" + etfSequencial.getValue();
    }

    public void btnNovoAction(ButtonEvent be) {
        if (grid != null) {
            if (MARCAR_TODOS.equals(getBtnNovoSuper().getText())) {
                getBtnNovoSuper().setText(DESMARCAR_TODOS);
                getBtnNovoSuper().setIcon(I9FactoryIcones.I9FACTORY_ICONS.excluir());
                //marcarTodos();
                actionButton = DESMARCAR_TODOS;

            } else {
                getBtnNovoSuper().setIcon(I9FactoryIcones.I9FACTORY_ICONS.checkall());
                getBtnNovoSuper().setText(MARCAR_TODOS);
                actionButton = MARCAR_TODOS;

            }
        }
    }

    private GridCellRenderer<Vw_parcelasTGWT> getEditarRender() {
        return new GridCellRenderer<Vw_parcelasTGWT>() {

            public Object render(final Vw_parcelasTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_parcelasTGWT> store, Grid<Vw_parcelasTGWT> grid) {

                CheckBox ch = new CheckBox();
                ch.setValue(true);
                return ch;
            }
        };
    }

    private String getTipo() {
        String tipo = "T";
        if ("Parcela".equals(cbTipo.getValue().get("tipo"))) {
            tipo = "P";
        } else if ("Mensalidade".equals(cbTipo.getValue().get("tipo"))) {
            tipo = "M";
        }
        return tipo;
    }

    public void load() {
        Bco_bancoTGWT bcoT = cbBanco.getValue();
        String tipo = getTipo();
        if (bcoT == null) {
            MessageBox.alert("Aviso", "E necessario informar o banco.", null);
        } else {
            Vw_parcelasTGWT vwParT = new Vw_parcelasTGWT();
            vwParT.setBco_nr_id(bcoT.getBco_nr_id());
            vwParT.setPle_tx_tipo(tipo);
            vwParT.setPle_dt_vencimento(dfVencimento.getValue());
            orgaosIds = getOrgaosSelecionado();
            vw_parcelasDAOGWT.consultarParcelasRemessa(vwParT, orgaosIds, chksalariominimo.getValue().booleanValue());
            list = null;
            Timer timer = new Timer() {

                public void run() {
                    list = vw_parcelasDAOGWT.getList();
                    if (list == null) {
                        schedule(500);
                    } else {
                        GroupingStore<Vw_parcelasTGWT> store = new GroupingStore<Vw_parcelasTGWT>();
                        store.add(list.getModels());
                        store.groupBy("org_tx_nome");
                        final ColumnModel cm = new ColumnModel(configs);
                        GroupSummaryView view = new GroupSummaryView();
                        view.setShowGroupedColumn(false);
                        view.setForceFit(true);

                        view.setGroupRenderer(new GridGroupRenderer() {

                            public String render(GroupColumnData data) {
                                String f = cm.getColumnById(data.field).getHeader();
                                String l = data.models.size() == 1 ? "Item" : "Items";
                                return data.text + "(" + data.models.size() + " " + l + ")";
                            }
                        });

                        grid = new Grid<Vw_parcelasTGWT>(store, cm);
                        grid.setView(view);
                        grid.setLoadMask(true);

                        grid.setStyleAttribute("borderTop", "none");
                        grid.setBorders(true);
                        grid.getSelectionModel().setSelectionMode(SelectionMode.MULTI);
                        getCpMaster().removeAll();
                        getCpMaster().add(grid);
                        getCpMaster().layout();
                        layout();
                    }
                }
            };
            timer.schedule(500);
        }
    }
}
