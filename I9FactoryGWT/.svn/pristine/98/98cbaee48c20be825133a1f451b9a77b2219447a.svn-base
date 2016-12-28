/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.vw_parcelas;

import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.i9factory.client.ConsultaGWTHeight;
import br.com.i9factory.client.i9factory.factory.iconsAll.Icones;
import br.com.i9factory.client.i9factory.factory.ple_parcelaemprestimo.Ple_parcelaemprestimoUpdateDeleteGWT;
import br.com.i9factory.client.i9factory.factory.vw_arquivo_retorno_banco.Vw_arquivo_retorno_bancoConsultGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Vw_parcelasConsultGWT extends ConsultaGWTHeight {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Vw_parcelasDAOGWT vw_parcelasDao = new Vw_parcelasDAOGWT();
    private ToolBar toolbarFilter = new ToolBar();
    private Button filtrar = new Button("Filtrar");
    private Button Im = new Button("Filtrar");
    private Radio rbPagas = new Radio();
    private Radio rbAPagar = new Radio();
    private Radio rbGeral = new Radio();
    private Radio rbTipoDes = new Radio();
    private Radio rbFornecedor = new Radio();
    private Radio rbSuspenso = new Radio();
    private RadioGroup radioGroupOP = new RadioGroup();
    private RadioGroup radioGroup = new RadioGroup();
    private DateField dfIinicio = new DateField();
    private DateField dfFim = new DateField();
    private ContentPanel cpOp = new ContentPanel();
    private ContentPanel cpCliente = new ContentPanel();
    private FormBinding formBinding;
    private Grid<Ctp_conta_pagarTGWT> grid;
    private String tipo_Consulta;
    private ContentPanel cpBaixa = new ContentPanel();
    private int cli_nr_id;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private ComboBox<Cli_clienteTGWT> combo = new ComboBox<Cli_clienteTGWT>();
    private Cli_clienteDAOGWT cli_clienteDAOGWT = new Cli_clienteDAOGWT();
    private com.extjs.gxt.ui.client.widget.Window winBaixa = new com.extjs.gxt.ui.client.widget.Window();
    public DateField dtbaixa = new DateField();
    private NumberField valorDesc = new NumberField();
    private Button btnBaixa = new Button("Confirmar a baixa");
    private Ple_parcelaemprestimoDAOGWT ple_parcelaemprestimoDAOGWT = new Ple_parcelaemprestimoDAOGWT();
    private Vw_parcelasTGWT vw_parcelasTGWT = new Vw_parcelasTGWT();
    private MessageBox mb = new MessageBox();
    private LabelField lbfvalorParcela = new LabelField();
    private NumberFormat numberFormat = NumberFormat.getFormat("#,##0.00");
    private TextField<String> tfFindCliente = new TextField<String>();
    private CheckBox boxTodas = new CheckBox();
    private TextArea txObs = new TextArea();
    private EasyNumberField nfPercentual_desc = new EasyNumberField();
    private boolean validoChange = false;
    private ContentPanel cpMaster = new ContentPanel(new FillLayout());
    private ContentPanel cpbotton = new ContentPanel(new RowLayout(Orientation.HORIZONTAL));
    private TextArea txObsConsult = new TextArea();
    private Vw_arquivo_retorno_bancoDAOGWT aOGWT = new Vw_arquivo_retorno_bancoDAOGWT();
    private ContentPanel cpGrid = new ContentPanel(new FillLayout());
    private Status stpago = new Status();
    private Status stdesconto = new Status();
    private Status stTotal = new Status();
    private Status status = new Status();
    private final String USUARIO_ADM = "ADMINISTRADOR";
    private boolean administrador;
    private ListStore<br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT> listaPer;

    public boolean locatePerfil(String perfil) {
        boolean res = false;
        for (br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT per_perfilTGWT : listaPer.getModels()) {
            if (per_perfilTGWT.getPer_tx_nome().equalsIgnoreCase(perfil)) {
                res = true;
            }
        }
        return res;
    }

    public Vw_parcelasConsultGWT() {
        createLayoutBottonCpMaster();
        getCpMaster().add(cpMaster);
        status.setWidth(140);

        listaPer = PortalAccordionGWT.getListPer();
        administrador = locatePerfil(USUARIO_ADM);

        stTotal.setText("Total Parcelas: " + numberFormat.format(0));

        stTotal.setBox(true);
        stTotal.setWidth(140);


        stdesconto.setText("Total Desconto: " + numberFormat.format(0));
        stdesconto.setBox(true);
        stdesconto.setWidth(140);

        stpago.setText("Total Pago: " + numberFormat.format(0));
        stpago.setBox(true);
        stpago.setWidth(140);

        getToolBarPage().add(stdesconto);

        getToolBarPage().add(new FillToolItem());
        getToolBarPage().add(new LabelToolItem("  "));
        getToolBarPage().add(stTotal);
        getToolBarPage().add(new LabelToolItem("  "));
        getToolBarPage().add(stpago);
        getToolBarPage().add(new LabelToolItem("  "));
        getToolBarPage().add(status);

        getCpTop().setVisible(false);
        this.setHeaderVisible(false);
        getDataNORTH().setSize(26);
        getDataWEST().setHidden(true);
        getDataEAST().setSize(230);
        getCpRight().setWidth(230);
        getDataEAST().setHidden(false);
        getCpRight().setHeading("Operações");

        FillLayout flay = new FillLayout();
        getCpRight().setLayout(flay);

        filtrar.setIcon(ICONS.filter());
        toolbarFilter.setAlignment(HorizontalAlignment.CENTER);
        toolbarFilter.setBorders(true);

        toolbarFilter.add(filtrar);
        getCpRight().setBottomComponent(toolbarFilter);

        winBaixa.setSize(500, 270);
        winBaixa.setPlain(true);
        winBaixa.setModal(true);
        winBaixa.setBlinkModal(true);
        winBaixa.setHeading("Baixa do Título");


        ContentPanel cpvalor = new ContentPanel();
        TableLayout layoutvalor = new TableLayout(3);
        layoutvalor.setCellPadding(4);
        cpvalor.setLayout(layoutvalor);
        cpvalor.setHeaderVisible(false);
        cpvalor.setFrame(false);
        cpvalor.setBodyBorder(false);
        //winBaixa.setLayout(layout);
        cpvalor.add(new LabelField("Valor Título:"));
        cpvalor.add(lbfvalorParcela);
        boxTodas.setBoxLabel("Baixar todos os Títulos deste cliente");
        cpvalor.add(boxTodas);
        cpvalor.setHeight(28);
        winBaixa.add(cpvalor);

        TableLayout layout = new TableLayout(6);
        layout.setCellPadding(4);
        ContentPanel cpbaixa = new ContentPanel();
        cpbaixa.setFrame(false);
        cpbaixa.setHeaderVisible(false);
        cpbaixa.setBodyBorder(false);
        cpbaixa.setLayout(layout);
        cpbaixa.add(new LabelField("Data baixa:"));
        dtbaixa.setWidth(110);
        dtbaixa.getPropertyEditor().setFormat(dtfDate);
        dtbaixa.setValue(new Date());
        cpbaixa.add(dtbaixa);

        cpbaixa.add(new LabelField("%"));
        nfPercentual_desc.setWidth(40);
        cpbaixa.add(nfPercentual_desc);

        cpbaixa.add(new LabelField("valor Desconto:"));
        valorDesc.setWidth(100);
        cpbaixa.add(valorDesc);
        valorDesc.setFormat(numberFormat);
        nfPercentual_desc.setFormat(numberFormat);

        winBaixa.add(cpbaixa);
        winBaixa.add(new LabelField("Obs:"));
        txObs.setHeight(100);
        txObs.setWidth(470);
        winBaixa.add(txObs);
        winBaixa.setButtonAlign(HorizontalAlignment.RIGHT);
        winBaixa.addButton(btnBaixa);

        winBaixa.layout();


        nfPercentual_desc.addListener(Events.Change, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                validoChange = true;
                calcularValor();
            }
        });

        valorDesc.addListener(Events.Change, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                validoChange = true;
                calcularPercentual();
            }
        });



        montarTelaOP();
        filtrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });

        btnBaixa.setIcon(ICONS.aplicar());
        btnBaixa.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                baixarParcela();
            }
        });

        dfIinicio.getPropertyEditor().setFormat(dtfDate);
        dfFim.getPropertyEditor().setFormat(dtfDate);

        radioGroup.setOrientation(Orientation.VERTICAL);
        rbAPagar.setBoxLabel("A Pagar");
        rbAPagar.setValue(true);
        rbPagas.setBoxLabel("Pagas");
        radioGroup.add(rbAPagar);
        radioGroup.add(rbPagas);
        rbSuspenso.setBoxLabel("suspenso");
        radioGroup.add(rbSuspenso);

        layout();
    }

    public void createLayoutBottonCpMaster() {

        cpMaster.setHeaderVisible(false);
        cpMaster.setBodyBorder(false);
        cpbotton.setHeight(100);

        cpGrid.setBodyBorder(false);
        cpGrid.setHeaderVisible(false);

        cpbotton.add(cpGrid, new RowData(.5, 1, new Margins(2)));
        cpbotton.add(txObsConsult, new RowData(.5, 1, new Margins(2)));
        createGridArquivo(new ListStore<Vw_arquivo_retorno_bancoTGWT>());

        cpbotton.setHeaderVisible(false);
        cpbotton.setBodyBorder(false);
        cpMaster.setBottomComponent(cpbotton);
        txObsConsult.setReadOnly(true);
        //cpbotton.setVisible(false);
    }

    public void calcularValor() {

        if (nfPercentual_desc.getValue() != null & nfPercentual_desc.getValue().floatValue() != 0 & validoChange) {
            validoChange = false;
            valorDesc.setValue(nfPercentual_desc.getValue().floatValue() * vw_parcelasTGWT.getPle_nr_valorparcela() / 100);
            validoChange = true;
        }

    }

    public void calcularPercentual() {
        if (valorDesc.getValue() != null & valorDesc.getValue().floatValue() != 0 & validoChange) {
            validoChange = false;
            nfPercentual_desc.setValue(valorDesc.getValue().floatValue() / vw_parcelasTGWT.getPle_nr_valorparcela() * 100);
            validoChange = true;
        }
    }

    public void createColumn() {
        configs.clear();

        SummaryColumnConfig<Double> column = null;

        column = new SummaryColumnConfig<Double>();
        column.setId("ple_nr_id");
        column.setHeader("ID Parcela");
        column.setHidden(true);
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("emp_nr_id");
        column.setHeader("ID emprestimo");
        column.setHidden(true);
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("cli_tx_nome");
        column.setHeader("Cliente");
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("ple_tx_parcela");
        column.setHeader("Parcela");
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("ple_dt_vencimento");
        column.setHeader("Vencimento");
        column.setDateTimeFormat(dtfDate);
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("ple_nr_valorparcela");
        column.setHeader("Valor");
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        column.setWidth(100);
        column.setSummaryType(SummaryType.SUM);
        column.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("ple_dt_pagamento");
        column.setHeader("Dt. Pagamento");
        column.setDateTimeFormat(dtfDate);
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("ple_nr_valordesconto");
        column.setHeader("Vl. Desconto");
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setSummaryType(SummaryType.SUM);
        column.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("ple_nr_saldo");
        column.setHeader("Vl. Pago");
        column.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setSummaryType(SummaryType.SUM);
        column.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));
        configs.add(column);


        column = new SummaryColumnConfig<Double>();
        column.setId("emp_nr_proposta");
        column.setHeader("Proposta");
        column.setNumberFormat(NumberFormat.getFormat("000"));
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("cli_tx_cpf");
        column.setHeader("CPF - cliente");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("imgbaixa");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        configs.add(column);

        if (radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Pagas")) {
            column.setRenderer(getExtornoRender());
        } else {
            column.setRenderer(getEditarRender());
            column = new SummaryColumnConfig<Double>("img", "", 40);
            column.setRenderer(getRendereEditValor());
            configs.add(column);
        }

        if (administrador) {
            if (radioGroup.getValue() == rbAPagar || radioGroup.getValue() == rbSuspenso) {
                column = new SummaryColumnConfig<Double>();
                column.setId("imgsuspenso");
                column.setWidth(30);
                column.setAlignment(HorizontalAlignment.CENTER);
                column.setRenderer(getRendereSuspenso());
                configs.add(column);
            }
        }



    }

    public GridCellRenderer<Vw_parcelasTGWT> getRendereSuspenso() {
        return new GridCellRenderer<Vw_parcelasTGWT>() {

            public Object render(final Vw_parcelasTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_parcelasTGWT> store, Grid<Vw_parcelasTGWT> grid) {
                Button button = new Button("", Icones.ICONS.cancel());
                final String tooltip = radioGroup.getValue() == rbAPagar ? "Suspender Título" : "Extornar suspensão";
                button.setToolTip(tooltip);
                button.addSelectionListener(new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {

                        Listener<MessageBoxEvent> listener = new Listener<MessageBoxEvent>() {

                            public void handleEvent(MessageBoxEvent be) {
                                if (be.getButtonClicked().getText().equalsIgnoreCase("yes") || be.getButtonClicked().getText().equalsIgnoreCase("sim")) {
                                    desabilitarHabilitar(model);
                                }
                            }
                        };
                        MessageBox.confirm("ATENÇÃO", tooltip, listener);
                    }
                });
                return button;
            }
        };
    }

    public void desabilitarHabilitar(Vw_parcelasTGWT vw_parcelasT) {
        Ple_parcelaemprestimoTGWT ple_parcelaemprestimoTGWT = new Ple_parcelaemprestimoTGWT();
        ple_parcelaemprestimoTGWT.setPle_nr_id(vw_parcelasT.getPle_nr_id());
        boolean valor = radioGroup.getValue() == rbAPagar;
        ple_parcelaemprestimoTGWT.setPle_bl_suspenso(valor);
        ple_parcelaemprestimoDAOGWT.suspender(ple_parcelaemprestimoTGWT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                String msg = ple_parcelaemprestimoDAOGWT.getMsg();
                if (msg == null) {
                    schedule(300);
                } else {
                    if (msg.indexOf("sucesso") > -1) {
                        Info.display("IMPORTANTE", msg);
                        load();
                    } else {
                        MessageBox.alert("ATENÇÃO", msg, null);
                    }
                }
            }
        };
        timer.schedule(300);
    }

    public GridCellRenderer<Vw_parcelasTGWT> getRendereEditValor() {
        return new GridCellRenderer<Vw_parcelasTGWT>() {

            public Object render(final Vw_parcelasTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_parcelasTGWT> store, Grid<Vw_parcelasTGWT> grid) {
                Button b = new Button("");
                b.setIcon(Icones.ICONS.edit());

                b.addSelectionListener(new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT = new Ple_parcelaemprestimoTGWT();

                        ple_parcelaemprestimoT.setEmp_nr_id(model.getEmp_nr_id());
                        ple_parcelaemprestimoT.setPle_dt_vencimento(model.getPle_dt_vencimento());
                        ple_parcelaemprestimoT.setPle_nr_id(model.getPle_nr_id());
                        ple_parcelaemprestimoT.setPle_nr_valorparcela(model.getPle_nr_valorparcela());
                        ple_parcelaemprestimoT.setPle_tx_historico(model.getPle_tx_historico());
                        ple_parcelaemprestimoT.setPle_tx_parcela(model.getPle_tx_parcela());
                        ple_parcelaemprestimoT.setPle_tx_tipo(model.getPle_tx_tipo());
                        ple_parcelaemprestimoT.setPle_nr_id_vinculo(model.getPle_nr_id_vinculo());

                        Ple_parcelaemprestimoUpdateDeleteGWT ple_parcelaemprestimoUpdateDeleteGWT = new Ple_parcelaemprestimoUpdateDeleteGWT();
                        ple_parcelaemprestimoUpdateDeleteGWT.setVw_parcelasConsultGWT(Vw_parcelasConsultGWT.this);
                        ple_parcelaemprestimoUpdateDeleteGWT.load(ple_parcelaemprestimoT, model.getPle_tx_tipo().equalsIgnoreCase("M") ? model.getCli_nr_id() : 0);
                        ple_parcelaemprestimoUpdateDeleteGWT.show();
                    }
                });

                b.setToolTip("Alterar Parcela");
                return b;
            }
        };
    }

    public void addCombo() {
        combo.setWidth(200);
        combo.setDisplayField("cli_tx_nome");
//        combo.setItemSelector("div.search-item");
//        combo.setTemplate(getTemplate());        
        combo.setTriggerAction(ComboBox.TriggerAction.ALL);
        //combo.setHideTrigger(true);
        //combo.setPageSize(10);
        combo.setAllowBlank(true);
        cpCliente.add(combo);
        cpCliente.layout();
        layout();
    }

    public boolean baixaValida() {
        boolean res = true;
        if (valorDesc.getValue() != null) {
            if (valorDesc.getValue().floatValue() > vw_parcelasTGWT.getPle_nr_valorparcela()) {
                res = false;
                mb.alert("ATENÇÃO", "O valor do desconto esta maior que o valor da parcela", null);
            }
        }
        return res;
    }

    private void extornoParcela() {
        Ple_parcelaemprestimoTGWT ple_parcelaemprestimoTGWT = new Ple_parcelaemprestimoTGWT();
//        ple_parcelaemprestimoTGWT.setPle_dt_pagamento(dtbaixa.getValue());
        ple_parcelaemprestimoTGWT.setEmp_nr_id(vw_parcelasTGWT.getEmp_nr_id());
        ple_parcelaemprestimoTGWT.setPle_dt_vencimento(vw_parcelasTGWT.getPle_dt_vencimento());
        ple_parcelaemprestimoTGWT.setPle_nr_valorparcela(vw_parcelasTGWT.getPle_nr_valorparcela());
        ple_parcelaemprestimoTGWT.setPle_nr_cdformapagto(0);
        ple_parcelaemprestimoTGWT.setPle_nr_id(vw_parcelasTGWT.getPle_nr_id());
        ple_parcelaemprestimoTGWT.setPle_nr_valordesconto(0);
        ple_parcelaemprestimoTGWT.setPle_tx_parcela(vw_parcelasTGWT.getPle_tx_parcela());
        ple_parcelaemprestimoTGWT.setPle_tx_tipo(vw_parcelasTGWT.getPle_tx_tipo());
        ple_parcelaemprestimoTGWT.setPle_tx_historico("");
        ple_parcelaemprestimoTGWT.setPle_nr_id_vinculo(0);
        ple_parcelaemprestimoDAOGWT.alterar(ple_parcelaemprestimoTGWT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (ple_parcelaemprestimoDAOGWT.getMsg() == null) {
                    schedule(500);
                } else {
                    if (ple_parcelaemprestimoDAOGWT.getMsg().indexOf("sucesso") > - 1) {
                        winBaixa.setVisible(false);
                        mb.alert("ATENÇÃO", "Extorno realizado com sucesso!", null);
                        load();
                        layout();
                    } else {
                        mb.alert("ATENÇÃO", ple_parcelaemprestimoDAOGWT.getMsg(), null);
                    }
                }
            }
        };
        timer.schedule(500);

    }

    public String getIds() {
        String ids = "0";
        for (Vw_parcelasTGWT parcelaGWT : (List<Vw_parcelasTGWT>) vw_parcelasDao.getList().getModels()) {
            ids += "," + parcelaGWT.getPle_nr_id();
        }
        //Window.alert(ids);
        return ids;
    }

    public void baixarParcela() {
        if (baixaValida()) {
            Ple_parcelaemprestimoTGWT ple_parcelaemprestimoTGWT = new Ple_parcelaemprestimoTGWT();
            ple_parcelaemprestimoTGWT.setPle_dt_pagamento(dtbaixa.getValue());
            ple_parcelaemprestimoTGWT.setEmp_nr_id(vw_parcelasTGWT.getEmp_nr_id());
            ple_parcelaemprestimoTGWT.setPle_dt_vencimento(vw_parcelasTGWT.getPle_dt_vencimento());
            ple_parcelaemprestimoTGWT.setPle_nr_valorparcela(vw_parcelasTGWT.getPle_nr_valorparcela());
            ple_parcelaemprestimoTGWT.setPle_nr_cdformapagto(0);
            ple_parcelaemprestimoTGWT.setPle_nr_id(vw_parcelasTGWT.getPle_nr_id());
            ple_parcelaemprestimoTGWT.setPle_nr_valordesconto(valorDesc.getValue() != null ? valorDesc.getValue().floatValue() : 0);
            ple_parcelaemprestimoTGWT.setPle_tx_parcela(vw_parcelasTGWT.getPle_tx_parcela());
            ple_parcelaemprestimoTGWT.setPle_tx_tipo(vw_parcelasTGWT.getPle_tx_tipo());
            ple_parcelaemprestimoTGWT.setPle_tx_historico(txObs.getValue() != null ? txObs.getValue() : "");
            ple_parcelaemprestimoTGWT.setPle_nr_id_vinculo(0);
            if (!boxTodas.getValue().booleanValue()) {
                ple_parcelaemprestimoDAOGWT.alterar(ple_parcelaemprestimoTGWT);
            } else {
                ple_parcelaemprestimoDAOGWT.alterarAll(ple_parcelaemprestimoTGWT, getIds());
            }
            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (ple_parcelaemprestimoDAOGWT.getMsg() == null) {
                        schedule(500);
                    } else {
                        if (ple_parcelaemprestimoDAOGWT.getMsg().indexOf("sucesso") > - 1) {
                            winBaixa.setVisible(false);
                            mb.alert("ATENÇÃO", "Baixa efetuada com sucesso", null);
                            load();
                            layout();
                        } else {
                            mb.alert("ATENÇÃO", ple_parcelaemprestimoDAOGWT.getMsg(), null);
                        }
                    }
                }
            };
            timer.schedule(500);
        }

    }

    public void montarTelaOP() {

        rbGeral.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addGeral();
            }
        });

        rbFornecedor.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addParcela();
            }
        });

        rbTipoDes.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addMensalidade();
            }
        });

        ContentPanel cpopMaster = new ContentPanel();
        cpopMaster.setHeaderVisible(false);
        cpopMaster.setBodyBorder(false);

        ToolBar toolStatus = new ToolBar();
        toolStatus.setBorders(true);
        toolStatus.add(new LabelToolItem("Status"));

        toolStatus.add(new SeparatorToolItem());
        //toolStatus.add(new SeparatorToolItem());
        //toolStatus.add(new SeparatorToolItem());

        toolStatus.add(radioGroup);
        //toolStatus.setBorders(true);
        cpopMaster.setTopComponent(toolStatus);
        cpopMaster.add(addCpSeparador());

        cpOp.setHeaderVisible(false);
        ToolBar toolBarOp = new ToolBar();
        toolBarOp.add(new LabelToolItem("Tipo dos Títulos"));
        cpOp.setTopComponent(toolBarOp);
        rbGeral.setBoxLabel("Geral");
        rbGeral.setValue(true);
        rbFornecedor.setBoxLabel("Parcelas");
        rbTipoDes.setBoxLabel("Mensalidades");
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

        cpCliente.setLayout(layoutCombo);
        cpCliente.setHeaderVisible(false);
        cpCliente.setBodyBorder(true);
        cpCliente.setHeight(60);
        ToolBar barCli = new ToolBar();
        barCli.add(new LabelToolItem("Sel. cliente"));
        barCli.add(new SeparatorToolItem());
        tfFindCliente.setEmptyText("Pesq.  Cliente");
        tfFindCliente.setToolTip("Para pesquisar pressione 'Enter'.");
        tfFindCliente.setWidth(120);
        KeyListener kl = new KeyListener() {

            public void componentKeyUp(ComponentEvent event) {
                if (event.getKeyCode() == 13) {
                    loadClientes();
                }
            }
        };
        tfFindCliente.addKeyListener(kl);
        barCli.add(tfFindCliente);

        cpCliente.setTopComponent(barCli);
        addGeral();

        cpopMaster.add(cpOp);
        cpopMaster.add(addCpSeparador());
        addCombo();
        cpopMaster.add(cpCliente);
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

        getCpRight().add(cpopMaster, new RowData(1, 1, new Margins(4, 4, 4, 4)));

        getCpRight().layout();
        layout();

    }

    public void loadClientes() {
        cli_clienteDAOGWT.consultByNome(tfFindCliente.getValue());
        combo.setValue(null);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Cli_clienteTGWT> list = cli_clienteDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    combo.setStore(list);
                    combo.getView().refresh();
                    if (list.getCount() == 1) {
                        combo.setValue(list.getAt(0));
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public ContentPanel addCpSeparador() {
        ContentPanel panel = new ContentPanel();
        panel.setHeaderVisible(false);
        panel.setHeight(4);
        panel.setBodyBorder(false);
        return panel;
    }

    public void addParcela() {
        tipo_Consulta = "P";
        layout();
    }

    public void addMensalidade() {
        tipo_Consulta = "M";
        layout();
    }

    public void addGeral() {
        tipo_Consulta = "G";
        layout();
    }

    public void btnNovoAction(ButtonEvent be) {
        Vw_parcelasInsertGWT vw_parcelasInsertGWT = new Vw_parcelasInsertGWT();
        vw_parcelasInsertGWT.setVw_parcelasConsult(this);
        vw_parcelasInsertGWT.setModal(true);
        vw_parcelasInsertGWT.show();

    }

    private GridCellRenderer<Vw_parcelasTGWT> getEditarRender() {
        return new GridCellRenderer<Vw_parcelasTGWT>() {

            public Object render(final Vw_parcelasTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_parcelasTGWT> store, Grid<Vw_parcelasTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        vw_parcelasTGWT = model;
                        lbfvalorParcela.setText(numberFormat.format(vw_parcelasTGWT.getPle_nr_valorparcela()));
                        winBaixa.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Baixar título");
                b.setIcon(Icones.ICONS.money_1());
                return b;
            }
        };
    }

    private GridCellRenderer<Vw_parcelasTGWT> getExtornoRender() {
        return new GridCellRenderer<Vw_parcelasTGWT>() {

            private boolean init;

            public Object render(final Vw_parcelasTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Vw_parcelasTGWT> store, Grid<Vw_parcelasTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Vw_parcelasTGWT>>() {

                        public void handleEvent(GridEvent<Vw_parcelasTGWT> be) {
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
                        vw_parcelasTGWT = model;
                        mb = MessageBox.confirm("Aviso", "Deseja extornar este título?", new Listener<MessageBoxEvent>() {

                            public void handleEvent(MessageBoxEvent be) {
                                if ("yes".equalsIgnoreCase(be.getButtonClicked().getText()) || "Sim".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                    extornoParcela();
                                }
                            }
                        });
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Extornar título");
                b.setIcon(Icones.ICONS.go_back());

                return b;
            }
        };
    }

    public void load() {
        String status = radioGroup.getValue() == rbPagas ? "P" : radioGroup.getValue() == rbAPagar ? "A" : "S";
        Date dtInicio = dtfDate.parse("01/01/1900");
        Date dtFinal = dtfDate.parse("01/01/3000");
        if (dfIinicio.getValue() != null) {
            dtInicio = dfIinicio.getValue();
        }

        if (dfFim.getValue() != null) {
            dtFinal = dfFim.getValue();
        }
        int cli = 0;
        if (combo.getValue() != null) {
            cli = combo.getValue().getCli_nr_id();
        }

        vw_parcelasDao.consultarParcelasCliente(tipo_Consulta, dtfDate.format(dtInicio), dtfDate.format(dtFinal), cli, status);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Vw_parcelasTGWT> list = vw_parcelasDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
                    loader.setRemoteSort(true);

                    GroupingStore<Vw_parcelasTGWT> store = new GroupingStore<Vw_parcelasTGWT>(loader);
                    store.groupBy("cli_tx_nome");
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    createColumn();
                    ColumnModel cm = new ColumnModel(configs);

                    AggregationRowConfig<Vw_parcelasTGWT> rowConfig = new AggregationRowConfig<Vw_parcelasTGWT>();

                    rowConfig.setSummaryFormat("ple_nr_valorparcela", numberFormat);
                    rowConfig.setSummaryType("ple_nr_valorparcela", SummaryType.SUM);

                    rowConfig.setSummaryFormat("ple_nr_valordesconto", numberFormat);
                    rowConfig.setSummaryType("ple_nr_valordesconto", SummaryType.SUM);

                    rowConfig.setSummaryFormat("ple_nr_saldo", numberFormat);
                    rowConfig.setSummaryType("ple_nr_saldo", SummaryType.SUM);

                    cm.addAggregationRow(rowConfig);

                    Grid<Vw_parcelasTGWT> grid = new Grid<Vw_parcelasTGWT>(store, cm);
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    grid.setStripeRows(true);
                    grid.getView().setEmptyText("Não existe itens para este cliente no périodo");

                    GroupSummaryView view = new GroupSummaryView();
                    view.setForceFit(true);
                    view.setShowGroupedColumn(false);
                    grid.setView(view);
                    grid.getView().setShowDirtyCells(false);
                    grid.setStripeRows(true);

                    grid.getSelectionModel().addListener(Events.SelectionChange,
                            new Listener<SelectionChangedEvent<Vw_parcelasTGWT>>() {

                                public void handleEvent(SelectionChangedEvent<Vw_parcelasTGWT> be) {
                                    if (be.getSelection().size() > 0) {
                                        povoGridConsult(be.getSelectedItem());
                                    }
                                }
                            });
                    double total = 0;
                    double totaldesc = 0;
                    double totalpago = 0;
                    for (Vw_parcelasTGWT vtgwt : list.getModels()) {
                        total += vtgwt.getPle_nr_valorparcela();
                        totaldesc += vtgwt.getPle_nr_valordesconto();
                        totalpago += vtgwt.getPle_nr_saldo();
                    }
                    cpMaster.removeAll();
                    cpMaster.add(grid);
                    cpMaster.layout();

                    stTotal.setText("Total Parcelas: " + numberFormat.format(total));

                    stTotal.setBox(true);
                    stTotal.setWidth(150);

                    stdesconto.setText("Total Desconto: " + numberFormat.format(totaldesc));
                    stdesconto.setBox(true);
                    stdesconto.setWidth(150);

                    stpago.setText("Total Pago: " + numberFormat.format(totalpago));
                    stpago.setBox(true);
                    stpago.setWidth(150);

//                    status.setWidth(150);



                    layout();
                    //MessageBox.alert("", totalpago + "XX", null);

                    txObsConsult.setValue("");
                }
            }
        };
        timer.schedule(500);
    }

    public void createGridArquivo(ListStore<Vw_arquivo_retorno_bancoTGWT> listStore) {
        ColumnModel cm = new ColumnModel(getColumnshistorico());
        Grid<Vw_arquivo_retorno_bancoTGWT> grid = new Grid<Vw_arquivo_retorno_bancoTGWT>(listStore, cm);
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        grid.getView().setEmptyText("Não existe Itens");
        grid.getView().refresh(true);
        grid.setBorders(true);
        //grid.setHeight(50);
        cpGrid.removeAll();
        cpGrid.add(grid);
        cpGrid.layout();
    }

    public List<ColumnConfig> getColumnshistorico() {

        final Vw_arquivo_retorno_bancoConsultGWT vw_arquivo = new Vw_arquivo_retorno_bancoConsultGWT();
        GridCellRenderer<Vw_arquivo_retorno_bancoTGWT> gridStatus = new GridCellRenderer<Vw_arquivo_retorno_bancoTGWT>() {

            public Object render(Vw_arquivo_retorno_bancoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_arquivo_retorno_bancoTGWT> store, Grid<Vw_arquivo_retorno_bancoTGWT> grid) {
                return vw_arquivo.getRetorno(model.getTeb_tx_status());
            }
        };

        List<ColumnConfig> lis = new Vector<ColumnConfig>();
        ColumnConfig config = new ColumnConfig("teb_dt_envio", "Dt.. Envio", 80);
        config.setDateTimeFormat(dtfDate);
        lis.add(config);

        config = new ColumnConfig("teb_dt_retorno", "Dt. Retorno", 80);
        config.setDateTimeFormat(dtfDate);
        lis.add(config);

        config = new ColumnConfig("status", "Status", 230);
        config.setRenderer(gridStatus);
        lis.add(config);
        return lis;
    }

    public void povoGridConsult(Vw_parcelasTGWT parcelasT) {
        txObsConsult.setValue(parcelasT.getPle_tx_historico().toUpperCase());
        aOGWT.consultarHistoricoParcela(parcelasT.getPle_nr_id());
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Vw_arquivo_retorno_bancoTGWT> list = aOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    createGridArquivo(list);
                }
            }
        };
        timer.schedule(500);

    }
}
