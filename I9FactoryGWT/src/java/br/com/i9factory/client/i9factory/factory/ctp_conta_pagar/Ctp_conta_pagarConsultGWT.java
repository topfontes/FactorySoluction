/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.ctp_conta_pagar;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9factory.client.ConsultaGWTHeight;
import br.com.i9factory.client.i9factory.factory.lan_lancamento.BaixaTitulosGWT;
import com.extjs.gxt.ui.client.data.ModelData;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.GridView;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RadioButton;
import java.util.Map;

/**
 *
 * @author geoleite
 */
public class Ctp_conta_pagarConsultGWT extends ConsultaGWTHeight {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Ctp_conta_pagarDAOGWT ctp_conta_pagarDao = new Ctp_conta_pagarDAOGWT();
    private For_fornecedorDAOGWT for_fornecedorDAOGWT = new For_fornecedorDAOGWT();
    private Tid_tipo_despesaDAOGWT tid_tipo_despesaDAOGWT = new Tid_tipo_despesaDAOGWT();
    private ComboBox<For_fornecedorTGWT> comboFor = new ComboBox<For_fornecedorTGWT>();
    private ComboBox<Tid_tipo_despesaTGWT> comboTipo = new ComboBox<Tid_tipo_despesaTGWT>();
    private ToolBar toolbarFilter = new ToolBar();
    private Button filtrar = new Button("Filtrar");
    private Button Im = new Button("Filtrar");
    private FieldSet fsOp = new FieldSet();
    private FieldSet fsPeriodo = new FieldSet();
    private Radio rbPagas = new Radio();
    private Radio rbAPagar = new Radio();
    private Radio rbGeral = new Radio();
    private Radio rbTipoDes = new Radio();
    private Radio rbFornecedor = new Radio();
    private RadioGroup radioGroupOP = new RadioGroup();
    private RadioGroup radioGroup = new RadioGroup();
    private DateField dfIinicio = new DateField();
    private DateField dfFim = new DateField();
    private ContentPanel cpOp = new ContentPanel();
    private ContentPanel cpCombo = new ContentPanel();
    private FormBinding formBinding;
    private Grid<Ctp_conta_pagarTGWT> grid;
    private String tipo_Agrupamento;
    private ContentPanel cpBaixa = new ContentPanel();
    private int id_ctp;
    public Lan_lancamentoDAOGWT lan_lancamentoDao = new Lan_lancamentoDAOGWT();
    private List<ColumnConfig> configsbaixa = new ArrayList<ColumnConfig>();
    private Lan_lancamentoTGWT lan_lancamentoT = new Lan_lancamentoTGWT();
    private ContentPanel container = new ContentPanel(new FillLayout());


    public Ctp_conta_pagarConsultGWT() {

        this.setHeaderVisible(false);
        getDataNORTH().setSize(26);
        getDataWEST().setHidden(true);
        getDataEAST().setSize(260);
        getCpRight().setWidth(260);
        getDataEAST().setHidden(false);
        getCpRight().setHeading("Operações");

        FillLayout flay = new FillLayout();
        getCpRight().setLayout(flay);
        
        container.setHeaderVisible(false);
        container.setBottomComponent(cpBaixa);

        for_fornecedorDAOGWT.consultarTodos();
        tid_tipo_despesaDAOGWT.consultarTodos();

        montarTelaOP();
        filtrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });

        createColumbaixa();
        createColumn();
    }

    public void createColumn() {
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("#,##0.00");
        final NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ctp_conta_pagarTGWT>>(currency);

        ColumnConfig column = null;

        SummaryColumnConfig<Integer> fornec = new SummaryColumnConfig<Integer>("for_tx_nome", "Fornecedor", 150);
        configs.add(fornec);

        SummaryColumnConfig<Integer> despesa = new SummaryColumnConfig<Integer>("tid_tx_nome", "Tipo Despesas", 100);
        configs.add(despesa);

        SummaryColumnConfig<Integer> documento = new SummaryColumnConfig<Integer>("ctp_nr_doc", "Documento", 80);
        documento.setSummaryType(SummaryType.COUNT);
        documento.setSummaryRenderer(new SummaryRenderer() {

            public String render(Number value, Map<String, Number> data) {
                return value.intValue() > 1 ? "(" + value.intValue() + " Items)" : "(1 Item)";
            }
        });
        configs.add(documento);

        SummaryColumnConfig<Double> vencimento = new SummaryColumnConfig<Double>("ctp_dt_vencimento", "Vencimento", 70);
        vencimento.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        vencimento.setAlignment(HorizontalAlignment.LEFT);
        configs.add(vencimento);

        SummaryColumnConfig<Integer> parcela = new SummaryColumnConfig<Integer>("ctp_tx_parcela", "Parcela", 30);
        configs.add(parcela);

        SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("ctp_valor", "Valor", 90);
        valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setAlignment(HorizontalAlignment.RIGHT);
        valor.setSummaryType(SummaryType.SUM);
        configs.add(valor);

        SummaryColumnConfig<Double> vlPago = new SummaryColumnConfig<Double>("ctp_vl_pago", "Valor Pago", 90);
        vlPago.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        vlPago.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        vlPago.setAlignment(HorizontalAlignment.RIGHT);
        vlPago.setSummaryType(SummaryType.SUM);
        configs.add(vlPago);

        SummaryColumnConfig<Double> saldo = new SummaryColumnConfig<Double>("ctp_saldo", "Saldo", 90);
        saldo.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        saldo.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        saldo.setAlignment(HorizontalAlignment.RIGHT);
        saldo.setSummaryType(SummaryType.SUM);

        configs.add(saldo);

        SummaryColumnConfig<Integer> columnDel = new SummaryColumnConfig<Integer>();
        columnDel.setId("imgEditar");
        columnDel.setWidth(30);
        columnDel.setAlignment(HorizontalAlignment.CENTER);
        columnDel.setRenderer(getEditarRender());
        configs.add(columnDel);

        SummaryColumnConfig<Integer> columnBaixa = new SummaryColumnConfig<Integer>();
        columnBaixa.setId("imgEditar");
        columnBaixa.setWidth(30);
        columnBaixa.setAlignment(HorizontalAlignment.CENTER);
        columnBaixa.setRenderer(getBaixaRender());
        configs.add(columnBaixa);

    }

    public void montarTelaOP() {

        rbGeral.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addGeral();
            }
        });

        rbFornecedor.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addcomboFornec();
            }
        });

        rbTipoDes.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addcomboTipo();
            }
        });

        ContentPanel cpopMaster = new ContentPanel();
        cpopMaster.setHeaderVisible(false);
        cpopMaster.setBodyBorder(false);

        filtrar.setIcon(ICONS.filter());
        toolbarFilter.setAlignment(HorizontalAlignment.CENTER);
        toolbarFilter.setBorders(true);

        toolbarFilter.add(filtrar);

        rbAPagar.setBoxLabel("A Pagar");
        rbAPagar.setValue(true);
        rbPagas.setBoxLabel("Pagas");
        radioGroup.add(rbAPagar);
        radioGroup.add(rbPagas);
        ToolBar toolStatus = new ToolBar();
        toolStatus.setBorders(true);
        toolStatus.add(new LabelToolItem("Status"));

        toolStatus.add(new SeparatorToolItem());
        toolStatus.add(new SeparatorToolItem());
        toolStatus.add(new SeparatorToolItem());

        toolStatus.add(radioGroup);
        //toolStatus.setBorders(true);
        cpopMaster.setTopComponent(toolStatus);
        cpopMaster.add(addCpSeparador());

        cpOp.setHeaderVisible(false);
        ToolBar toolBarOp = new ToolBar();
        toolBarOp.add(new LabelToolItem("Tipo de Agrupamento"));
        cpOp.setTopComponent(toolBarOp);
        rbGeral.setBoxLabel("Geral");
        rbGeral.setValue(true);
        rbFornecedor.setBoxLabel("Fornecedor");
        rbTipoDes.setBoxLabel("Despesa");
        radioGroupOP.add(rbGeral);
        radioGroupOP.add(rbFornecedor);
        radioGroupOP.add(rbTipoDes);
        radioGroupOP.setBorders(false);
        radioGroupOP.setSpacing(5);

        radioGroupOP.setOrientation(Orientation.VERTICAL);
        ContentPanel panel = new ContentPanel();
        panel.setHeaderVisible(false);
        panel.setBodyBorder(false);
        TableLayout lay = new TableLayout(1);
        lay.setCellPadding(4);
        panel.setLayout(lay);
        panel.add(radioGroupOP);
        cpOp.add(panel);
        TableLayout layoutCombo = new TableLayout(1);
        layoutCombo.setCellPadding(3);
        cpCombo.setLayout(layoutCombo);
        cpCombo.setHeaderVisible(false);
        cpCombo.setBodyBorder(false);
        cpCombo.setHeight(30);
        addGeral();
        cpOp.add(cpCombo);

        cpopMaster.add(cpOp);
        cpopMaster.add(addCpSeparador());

        ContentPanel cpPeriodo = new ContentPanel();
        TableLayout layout = new TableLayout(2);
        cpPeriodo.setLayout(layout);
        cpPeriodo.setHeaderVisible(false);
        ToolBar toolPeriodo = new ToolBar();
        toolPeriodo.add(new LabelToolItem("Período"));
        toolPeriodo.setBorders(true);

        cpPeriodo.setTopComponent(toolPeriodo);
        layout.setCellPadding(3);
        cpPeriodo.setHeaderVisible(false);
        cpPeriodo.setBodyBorder(true);
        cpPeriodo.add(new LabelField("Início:"));
        dfIinicio.getPropertyEditor().setFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        dfFim.getPropertyEditor().setFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        cpPeriodo.add(dfIinicio);
        cpPeriodo.add(new LabelField("Final:"));
        cpPeriodo.add(dfFim);
        cpopMaster.add(cpPeriodo);
        BorderLayoutData bl = new BorderLayoutData(LayoutRegion.CENTER);


        FillLayout layoutBaixa = new FillLayout();
        cpBaixa.setLayout(layoutBaixa);
        cpBaixa.setHeaderVisible(false);
        cpBaixa.setBodyBorder(false);
        cpBaixa.setFrame(true);
        ToolBar barBaixa = new ToolBar();
        barBaixa.setBorders(true);
        barBaixa.add(new LabelToolItem("Pagamentos Realizados"));
        cpBaixa.setTopComponent(barBaixa);
        cpBaixa.setHeight(130);
        cpopMaster.add(addCpSeparador());
//        cpopMaster.add(cpBaixa);
        getCpRight().add(cpopMaster, new RowData(1, 1, new Margins(4, 4, 4, 4)));
        getCpRight().setBottomComponent(toolbarFilter);
        layout();
    }

    public ContentPanel addCpSeparador() {
        ContentPanel panel = new ContentPanel();
        panel.setHeaderVisible(false);
        panel.setHeight(4);
        panel.setBodyBorder(false);

        return panel;

    }

    public void addcomboFornec() {
        tipo_Agrupamento = "F";
        cpCombo.setPosition(5, 10);
        cpCombo.removeAll();
        comboFor.setStore(for_fornecedorDAOGWT.getList());
        comboFor.setEmptyText("Selecione o Fornecedor");
        comboFor.setDisplayField("for_tx_nome");
        comboFor.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboFor.setWidth(200);
        cpCombo.add(comboFor);
        comboTipo.setValue(null);
        layout();
    }

    public void addcomboTipo() {
        cpCombo.removeAll();
        comboTipo.setStore(tid_tipo_despesaDAOGWT.getList());
        comboTipo.setEmptyText("Selecione a Despesa");
        comboTipo.setDisplayField("tid_tx_nome");
        comboTipo.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboTipo.setWidth(200);
        cpCombo.add(comboTipo);
        tipo_Agrupamento = "D";
        comboFor.setValue(null);
        layout();
    }

    public void addGeral() {
        cpCombo.removeAll();
        cpCombo.add(new LabelField("Todos os itens no período!"));
        tipo_Agrupamento = "G";
        layout();
    }

    public void btnNovoAction(ButtonEvent be) {
        Ctp_conta_pagarInsertGWT ctp_conta_pagarInsertGWT = new Ctp_conta_pagarInsertGWT();
        ctp_conta_pagarInsertGWT.setCtp_conta_pagarConsult(this);
        ctp_conta_pagarInsertGWT.setModal(true);
        ctp_conta_pagarInsertGWT.show();
        tipo_Agrupamento = "F";
    }

    private GridCellRenderer<Ctp_conta_pagarTGWT> getEditarRender() {
        return new GridCellRenderer<Ctp_conta_pagarTGWT>() {

            public Object render(final Ctp_conta_pagarTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ctp_conta_pagarTGWT> store, Grid<Ctp_conta_pagarTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Ctp_conta_pagarUpdateDeleteGWT ctp_conta_pagarUpdateDeleteGWT = new Ctp_conta_pagarUpdateDeleteGWT();
                        ctp_conta_pagarUpdateDeleteGWT.setCtp_conta_pagarConsult(Ctp_conta_pagarConsultGWT.this);
                        ctp_conta_pagarUpdateDeleteGWT.load(model);
                        ctp_conta_pagarUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Ctp_conta_pagarTGWT> getBaixaRender() {
        return new GridCellRenderer<Ctp_conta_pagarTGWT>() {

            public Object render(final Ctp_conta_pagarTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ctp_conta_pagarTGWT> store, Grid<Ctp_conta_pagarTGWT> grid) {
                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        BaixaTitulosGWT baixaTitulosGWT = new BaixaTitulosGWT();
                        baixaTitulosGWT.load(model, Ctp_conta_pagarConsultGWT.this);
                        baixaTitulosGWT.setModal(true);
                        baixaTitulosGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Baixar título");
                b.setIcon(ICONS.aplicar());

                return b;
            }
        };
    }

    public void load() {
        String status = radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Pagas") ? "T" : "F";
        int id_fornec = 0;
        int id_tipo = 0;
        if (comboFor.getValue() != null) {
            id_fornec = comboFor.getValue().getFor_nr_id();
        }
        if (comboTipo.getValue() != null) {
            id_tipo = comboTipo.getValue().getTid_nr_id();
        }
        if (dfIinicio.getValue() == null || dfFim == null) {
            ctp_conta_pagarDao.consultarTodosSemData(status, id_fornec, id_tipo, tipo_Agrupamento);
        } else {
            ctp_conta_pagarDao.consultarTodos(status, dfIinicio.getValue(), dfFim.getValue(), id_fornec, id_tipo, tipo_Agrupamento);
        }
        Timer timer = new Timer() {

            public void run() {
                ListStore<Ctp_conta_pagarTGWT> list = ctp_conta_pagarDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    String msg = ctp_conta_pagarDao.getMsg();
                    if (msg != null && msg.indexOf("Limite") >= 0) {
                        MessageBox.alert("Problema", msg, null);
                    } else {
                        List lista = getCpMaster().getItems();
                        if (lista.size() > 0) {
                            getCpMaster().removeAll();
                        }

                        ColumnModel cm = new ColumnModel(configs);

                        GroupSummaryView view = null;
                        GroupingStore<Ctp_conta_pagarTGWT> store = new GroupingStore<Ctp_conta_pagarTGWT>();
                        AggregationRowConfig<Ctp_conta_pagarTGWT> agRowConfig = null;
                        if (!tipo_Agrupamento.equalsIgnoreCase("G")) {
                            agRowConfig = new AggregationRowConfig<Ctp_conta_pagarTGWT>();
                            agRowConfig.setSummaryFormat("ctp_valor", NumberFormat.getFormat("#,##0.00"));
                            agRowConfig.setSummaryType("ctp_valor", SummaryType.SUM);
                            cm.addAggregationRow(agRowConfig);
                            store.add(list.getModels());
                            view = new GroupSummaryView();
                            view.setShowGroupedColumn(false);
                            view.setForceFit(true);

                            if (tipo_Agrupamento.equalsIgnoreCase("F")) {
                                store.groupBy("for_tx_nome");
                            } else {
                                store.groupBy("tid_tx_nome");
                            }
                        }
                        if (!tipo_Agrupamento.equalsIgnoreCase("G")) {
                            grid = new Grid<Ctp_conta_pagarTGWT>(store, cm);
                        } else {
                            grid = new Grid<Ctp_conta_pagarTGWT>(list, cm);
                        }

                        if (!tipo_Agrupamento.equalsIgnoreCase("G")) {
                            grid.setView(view);
                            grid.getView().setShowDirtyCells(false);
                        }

                        grid.setLoadMask(true);
                        grid.setStyleAttribute("borderTop", "none");
                        grid.setBorders(true);
                        //grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                        GridSelectionModel gsm = grid.getSelectionModel();
                        gsm.setSelectionMode(SelectionMode.SINGLE);
                        grid.setSelectionModel(gsm);

                        grid.getSelectionModel().addListener(Events.SelectionChange,
                                new Listener<SelectionChangedEvent<Ctp_conta_pagarTGWT>>() {

                                    public void handleEvent(SelectionChangedEvent<Ctp_conta_pagarTGWT> be) {
                                        if (be.getSelection().size() > 0) {
                                            id_ctp = be.getSelection().get(0).getCtp_nr_id();
                                            povoaPagamento(id_ctp);
                                        }
                                    }
                                });
                       
                        container.removeAll();
                        container.add(grid);
                        
                        getCpMaster().removeAll();
                        getCpMaster().add(container);
                        getCpMaster().layout();
                        cpBaixa.removeAll();
                        if (list.getCount() == 0) {
                            MessageBox.alert("Resultado", "A pesquisa nao encontrou resultado.", null);
                        }
                        //layout();
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void povoaPagamento(int ctp_nr_id) {

        lan_lancamentoDao.consultarTodosPagamentosCTP(ctp_nr_id);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Lan_lancamentoTGWT> list = lan_lancamentoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = cpBaixa.getItems();
                    if (lista.size() > 0) {
                        cpBaixa.removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configsbaixa);

                    Grid<Lan_lancamentoTGWT> gridbaixa = new Grid<Lan_lancamentoTGWT>(list, cm);
                    gridbaixa.setLoadMask(true);
                    gridbaixa.setBorders(false);

                    gridbaixa.setStyleAttribute("borderTop", "none");
                    gridbaixa.setBorders(true);
                    gridbaixa.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    cpBaixa.add(gridbaixa);
                    cpBaixa.layout();

                }
            }
        };
        timer.schedule(500);
    }

    public void createColumbaixa() {

        SummaryColumnConfig<Integer> columnData = new SummaryColumnConfig<Integer>("lan_dt_lancamento", "Dt. Pagto.", 100);
        columnData.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        configsbaixa.add(columnData);

        SummaryColumnConfig<Double> columnValor = new SummaryColumnConfig<Double>("lan_valor", "Valor", 100);
        columnValor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        columnValor.setAlignment(HorizontalAlignment.RIGHT);
        configsbaixa.add(columnValor);

        SummaryColumnConfig<Double> columnobs = new SummaryColumnConfig<Double>("lan_tx_historico", "Observação", 500);
        configsbaixa.add(columnobs);

        SummaryColumnConfig<Integer> columnExcluirbaixa = new SummaryColumnConfig<Integer>();
        columnExcluirbaixa.setId("imgEditarExtorno");
        columnExcluirbaixa.setWidth(30);
        columnExcluirbaixa.setAlignment(HorizontalAlignment.CENTER);
        columnExcluirbaixa.setRenderer(getExcluirbaixaRender());
        configsbaixa.add(columnExcluirbaixa);
    }

    private GridCellRenderer<Lan_lancamentoTGWT> getExcluirbaixaRender() {
        return new GridCellRenderer<Lan_lancamentoTGWT>() {

            private boolean init;

            public Object render(final Lan_lancamentoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Lan_lancamentoTGWT> store, Grid<Lan_lancamentoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Lan_lancamentoTGWT>>() {

                        public void handleEvent(GridEvent<Lan_lancamentoTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Extornarbaixa(model.getLan_nr_id(), model.getLan_valor());
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Extornar Pgto.");
                b.setIcon(ICONS.delete());

                return b;
            }
        };
    }

    public void Extornarbaixa(int id, float valor) {

        lan_lancamentoT.setLan_nr_id(id);
        lan_lancamentoT.setLan_valor(valor);
        lan_lancamentoT.setCtp_nr_id(id_ctp);
        ctp_conta_pagarDao.extorna_pag(lan_lancamentoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = ctp_conta_pagarDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", "Extorno realzado com sucesso");
                        load();

                    }
                }
            }
        };
        timer.schedule(500);

    }
}
