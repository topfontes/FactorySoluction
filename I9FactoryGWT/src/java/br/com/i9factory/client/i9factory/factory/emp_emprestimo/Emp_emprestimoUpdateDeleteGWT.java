package br.com.i9factory.client.i9factory.factory.emp_emprestimo;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9factory.client.i9factory.factory.cli_cliente.Locate_ClienteGWT;
import br.com.i9factory.client.i9factory.factory.iconsAll.Icones;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.grid.filters.GridFilters;
import com.extjs.gxt.ui.client.widget.grid.filters.ListFilter;
import com.extjs.gxt.ui.client.widget.grid.filters.NumericFilter;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Emp_emprestimoUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Emp_emprestimoConsultGWT emp_emprestimoConsultGWT;
    private Emp_emprestimoConsultGWT emp_emprestimoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDia = DateTimeFormat.getFormat("dd");
    private DateTimeFormat dtfMes = DateTimeFormat.getFormat("MM");
    private DateTimeFormat dtfAno = DateTimeFormat.getFormat("yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Emp_emprestimoDAOGWT emp_emprestimoDao = new Emp_emprestimoDAOGWT();
    private TextField<String> emp_nr_id = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> age_nr_id = new TextField<String>();
    private TextField<String> cor_nr_id = new TextField<String>();
    private int idc_nr_id;
    private int org_nr_id;
    private DateField emp_dt_emprestimo = new DateField();
    private TextField<String> emp_nr_valor = new TextField<String>();
    private TextField<String> emp_tx_status = new TextField<String>();
    private TextArea emp_tx_observacoes = new TextArea();
    private DateField emp_dt_aprovacao = new DateField();
    private DateField emp_dt_liberacao = new DateField();
    private DateField emp_dt_quitacao = new DateField();
    private DateField emp_dt_enviobanco = new DateField();
    private DateField emp_dt_retornobanco = new DateField();
    private TextField<String> emp_tx_cdlancamentobanco = new TextField<String>();
    private TextField<String> emp_tx_cdlancamentopendente = new TextField<String>();
    private TextField<String> emp_tx_numerocheque = new TextField<String>();
    private RadioGroup radioGroup = new RadioGroup();
    private TextField<String> tx_locate = new TextField<String>();
    private ContentPanel mainCpMaster = new ContentPanel();
    private Button btnLoc = new Button("");
    private Button btnNew = new Button("Novo");
    private TextField<String> cli_tx_nome = new TextField<String>();
    private TextField<String> cli_tx_cpf = new TextField<String>();
    private TextField<String> cli_tx_matricula = new TextField<String>();
    private TextField<String> bco_tx_nome = new TextField<String>();
    private TextField<String> org_tx_nome = new TextField<String>();
    private Cor_corretoraDAOGWT cor_corretoraDAOGWT = new Cor_corretoraDAOGWT();
    private ComboBox<Cor_corretoraTGWT> comboCorretor = new ComboBox<Cor_corretoraTGWT>();
    private Idc_indiceDAOGWT idc_indiceDAOGWT = new Idc_indiceDAOGWT();
    private DateField dataIndice = new DateField();
    private DateField dataAverbacao = new DateField();
    private LabelField lblIndex = new LabelField();
    private NumberFormat formatReal = NumberFormat.getFormat("#,##0.00");
    private NumberField menSocial = new NumberField();
    private NumberField numParcMenSocial = new NumberField();
    private NumberField valorParcelaMenSocial = new NumberField();
    private NumberField valorAfin = new NumberField();
    private NumberField numParcValorAfin = new NumberField();
    private NumberField valorParcelaAFIN = new NumberField();
    private NumberField valorAFIN_Bruto = new NumberField();
    private NumberField valorAFIN_Liquido = new NumberField();
    private NumberField valorParcelaAFIN_Anterior = new NumberField();
    private NumberField valorDescParcelaAFIN_Anterior = new NumberField();
    private NumberField numeroProposta = new NumberField();
    private float indice;
    private ContentPanel cpParcela = new ContentPanel(new FillLayout());
    private Button btnGeraParcela = new Button("Gera Parcela Emprestimo");
    private Grid<Idc_indiceTGWT> gridIndx;
    private TabItem tbiParcelas = new TabItem("Parcelas Pendentes");
    private TabPanel tpProposta = new TabPanel();
    private ListStore<Ple_parcelaemprestimoTGWT> storeParcelasAberto;// = new ListStore<Ple_parcelaemprestimoTGWT>();
    private ContentPanel cpParcelasAberto = new ContentPanel(new FillLayout());
    private List<ColumnConfig> configsParcelaAberto = new ArrayList<ColumnConfig>();
    private ColumnModel cmParcelaAberto = new ColumnModel(configsParcelaAberto);
    private int id_emprestimoBaixa = 0;
    private TabItem tbiProposta = new TabItem("Proposta");
    private Emp_emprestimoTGWT emp_emprestimoTGWT;
    private Ple_parcelaemprestimoDAOGWT ple_parcelaemprestimoDAOGWT = new Ple_parcelaemprestimoDAOGWT();
    private CheckBox chkRenovacao = new CheckBox();
    private final String USUARIO_ADM = "ADMINISTRADOR";
    private final String USUARIO_GERENTE = "GERENTE";
    private final String USUARIO_ATENDENTE = "ATENDENTE";
    private ListStore<br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT> listaPer;
    private String perfil = "";
    private ContentPanel cp = new ContentPanel();
    private TabItem tbiCredito = new TabItem("Tipo de crédito");
    private ComboBox<Tic_tipo_creditoTGWT> cbTipocred = new ComboBox<Tic_tipo_creditoTGWT>();
    private ContentPanel cpCredito = new ContentPanel();
    private CheckBox chkCompensado = new CheckBox();
    private Button btnCompensado = new Button("Atualizar", Icones.ICONS.upload());

    private ComboBox<Car_cartaoTGWT> cbCartao = new ComboBox<Car_cartaoTGWT>();
    private ComboBox<Tac_taxa_cartaoTGWT> cbTaxaCartao = new ComboBox<Tac_taxa_cartaoTGWT>();
    private ListStore<Ple_parcelaemprestimoTGWT> store = new ListStore<Ple_parcelaemprestimoTGWT>();
    private boolean loadUpdate = false;

    private CheckBox chkCartao = new CheckBox();
    private Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT;
    private Grid grid = null;

    public Emp_emprestimoUpdateDeleteGWT() {

        listaPer = PortalAccordionGWT.getListPer();
        idc_indiceDAOGWT.consultarTodos();
        cor_corretoraDAOGWT.consultarTodos();

        cpParcelasAberto.setHeaderVisible(false);
        cpParcelasAberto.setBodyBorder(false);

        btnLoc.setIcon(ICONS.find());
        btnNew.setIcon(ICONS.novo());
        this.setHeading("Alteração AFIN.");
        this.setSize(800, 640);

        mainCpMaster.setHeaderVisible(false);
        mainCpMaster.setBodyBorder(false);

        lblIndex.setStyleName("font20-Negrito");

        //dataAverbacao.setValue(new Date());
        menSocial.setFormat(formatReal);
        valorParcelaAFIN.setFormat(formatReal);
        //valorParcelaAFIN.setReadOnly(true);
        valorParcelaAFIN.setStyleName("background-readOnly");

        valorAfin.setFormat(formatReal);
        valorParcelaMenSocial.setFormat(formatReal);
        valorParcelaMenSocial.setReadOnly(true);
        valorParcelaMenSocial.setStyleName("background-readOnly");

        valorAFIN_Bruto.setReadOnly(true);
        valorAFIN_Bruto.setStyleName("background-readOnly");

        valorAFIN_Liquido.setReadOnly(true);
        valorAFIN_Liquido.setStyleName("background-readOnly");

        menSocial.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                calcularMenSocial();
            }
        });

        numParcMenSocial.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                calcularMenSocial();
            }
        });

        valorAfin.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                calcularValorAFIN();
            }
        });

        numParcValorAfin.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                indice = 0;
                calcularValorAFIN();
            }
        });

        valorParcelaAFIN_Anterior.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                calcularValorAFIN();
            }
        });

        valorDescParcelaAFIN_Anterior.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                calcularValorAFIN();
            }
        });

        valorParcelaAFIN.addListener(Events.OnChange, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                indice = 0;
                calcularValorAFIN();
            }
        });

        dataAverbacao.getPropertyEditor().setFormat(dtfDate);

        tx_locate.addListener(Events.OnKeyPress, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                if (be.getEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
                    locateCliente();
                }
            }
        });

        btnLoc.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                locateCliente();
            }
        });

        final DatePicker datePicker = dataAverbacao.getDatePicker();
        datePicker.addListener(Events.Select, new Listener<ComponentEvent>() {

            public void handleEvent(ComponentEvent be) {
                calcularValorAFIN();
            }
        });

        btnGeraParcela.setIcon(ICONS.importation());
        btnGeraParcela.setEnabled(false);
        btnGeraParcela.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                gerarParcela();
            }
        });
        final MessageBox mb = new MessageBox();

        tpProposta.addListener(Events.Select, new Listener<TabPanelEvent>() {

            public void handleEvent(TabPanelEvent be) {
                if (be.getItem().getText().equalsIgnoreCase("Parcelas Pendentes")) {
                    if (storeParcelasAberto == null) {
                        if (cli_nr_id.getValue() != null) {
                            if (valorAfin.getValue() != null) {
                                //consultarParcelasAberto();
                            } else {
                                tpProposta.setSelection(tbiProposta);
                                mb.alert("IMPORTANTE", "Informe primeiro o valor do emprestimo", null);
                            }
                        } else {
                            tpProposta.setTabIndex(0);
                            mb.alert("IMPORTANTE", "Localize primeiro o cliente", null);
                        }
                    }
                } else {
                    setValorParcelasPendentes();
                }
            }
        });

        btnCompensado.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                emp_emprestimoTGWT.setEmp_tx_compensado(chkCompensado.getValue().booleanValue() ? "S" : "N");
                emp_emprestimoDao.updateCompensado(emp_emprestimoTGWT);
                Timer timer = new Timer() {

                    @Override
                    public void run() {
                        if (emp_emprestimoDao.getMsg() == null) {
                            schedule(300);
                        } else {
                            if (emp_emprestimoDao.getMsg().indexOf("sucesso") > -1) {
                                Info.display("ATENÇÃO", "Operação realizada com sucesso");
                            }
                        }
                    }
                };
                timer.schedule(200);
            }
        });

        createColumnParcelaAberto();
        povoaCartao();
        chkCartao.addListener(Events.OnChange, new Listener<FieldEvent>() {
            public void handleEvent(FieldEvent be) {
                cbCartao.setVisible(chkCartao.getValue().booleanValue());
                cbTaxaCartao.setVisible(chkCartao.getValue().booleanValue());
                if (chkCartao.getValue().booleanValue() == false) {
                    cbCartao.setValue(null);
                    cbTaxaCartao.setValue(null);
                    calcularVlLiqCartao(null);
                }

            }
        });
//        montarTela();
        layout();
    }

    public void getTipoCredito() {
        final Tic_tipo_creditoDAOGWT dAOGWT = new Tic_tipo_creditoDAOGWT();
        dAOGWT.consultarTodos();
        Timer timer = new Timer() {
            @Override
            public void run() {
                ListStore<Tic_tipo_creditoTGWT> list = dAOGWT.getList();
                if (list == null) {
                    schedule(300);
                    Info.display("", "");
                } else {

                    cbTipocred.setStore(list);
                    cbTipocred.setDisplayField("tic_tx_nome");
                    cbTipocred.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbTipocred.getView().refresh();
                    if (emp_emprestimoTGWT.getTic_nr_id() > 0) {
                        cbTipocred.setValue(cbTipocred.getStore().findModel("tic_nr_id", emp_emprestimoTGWT.getTic_nr_id()));
                    }
                }
            }
        };
        timer.schedule(100);
    }

    public ContentPanel getFieldsCredito() {
        tbiCredito.setLayout(new FillLayout());

        TableLayout layout = new TableLayout(4);
        layout.setCellPadding(4);
        cpCredito.setLayout(layout);
        cpCredito.add(new LabelField("Tipo crédito Emprestimo:"));
        cpCredito.add(cbTipocred);
        cpCredito.add(new LabelField("Documento:"));
        cpCredito.add(emp_tx_numerocheque);
        emp_tx_numerocheque.setValue(emp_emprestimoTGWT.getEmp_tx_numerocheque());
        chkCompensado.setBoxLabel("Emprestimo creditado");
        cpCredito.add(chkCompensado);
        cpCredito.add(btnCompensado);
        chkCompensado.setValue(emp_emprestimoTGWT.getEmp_tx_compensado().equalsIgnoreCase("S"));

        return cpCredito;
    }

    public void setValorParcelasPendentes() {
        float valorDesc = 0;
        float PercDesc = 0;
        float valor = 0;

        for (int i = 0; i < storeParcelasAberto.getModels().size(); i++) {
            valorDesc += Float.parseFloat(storeParcelasAberto.getAt(i).get("ple_nr_valordesconto").toString());
            valor += Float.parseFloat(storeParcelasAberto.getAt(i).get("ple_nr_valorparcela").toString());
        }

        valorParcelaAFIN_Anterior.setValue(valor);
        valorDescParcelaAFIN_Anterior.setValue(valorDesc);
        valorAFIN_Bruto.setValue(valorAfin.getValue().floatValue() - valor);
        valorAFIN_Liquido.setValue((valorAfin.getValue().floatValue() - valor) + valorDesc);
    }

    public ColumnModel getColumnModel() {
        List<ColumnConfig> list = new ArrayList<ColumnConfig>();
        ColumnConfig column = new ColumnConfig("idc_nr_valor", "Indice", 50);
        column.setRenderer(new GridCellRenderer<Idc_indiceTGWT>() {

            public String render(Idc_indiceTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Idc_indiceTGWT> store, Grid<Idc_indiceTGWT> grid) {
                NumberFormat format = NumberFormat.getFormat("0.00");
                return "<span style='color:green'>" + format.format(model.getIdc_nr_valor()) + "% </span>";
            }
        });

        column.setStyle("background-color:#DFE8F6");
        list.add(column);
        column = new ColumnConfig("idc_nr_diainicial", "Início", 38);
        list.add(column);
        column = new ColumnConfig("idc_nr_diafinal", "Fim", 38);
        list.add(column);
        column = new ColumnConfig("idc_nr_qtdparcelas", "N. Parc", 57);
        column.setAlignment(HorizontalAlignment.RIGHT);
        list.add(column);
        ColumnModel cm = new ColumnModel(list);
        return cm;
    }

    public void createColumnParcelaAberto() {

        ColumnConfig cfParcela = new ColumnConfig("ple_tx_parcela", "Parc.", 50);

        ColumnConfig cfvenc = new ColumnConfig("ple_dt_vencimento", "Vencimento", 100);
        cfvenc.setDateTimeFormat(dtfDate);
        ColumnConfig cfvalor = new ColumnConfig("ple_nr_valorparcela", "Valor", 100);
        cfvalor.setNumberFormat(formatReal);
        cfvalor.setAlignment(HorizontalAlignment.RIGHT);

        final ColumnConfig cfpercentual = new ColumnConfig("ple_nr_Percdesconto", "% Desconto", 100);
        cfpercentual.setNumberFormat(formatReal);

        final ColumnConfig cfvalorDesc = new ColumnConfig("ple_nr_valordesconto", "Valor Desc. (R$)", 100);
        cfvalorDesc.setNumberFormat(formatReal);

        cfpercentual.setRenderer(new GridCellRenderer<Ple_parcelaemprestimoTGWT>() {

            public Object render(Ple_parcelaemprestimoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ple_parcelaemprestimoTGWT> store, Grid<Ple_parcelaemprestimoTGWT> grid) {
                final Ple_parcelaemprestimoTGWT temp = (Ple_parcelaemprestimoTGWT) model;
                NumberField nf = new NumberField();
                nf.setFormat(formatReal);
                CellEditor ce = new CellEditor(nf);
                cfpercentual.setEditor(ce);
                nf.addListener(Events.Change, new Listener<FieldEvent>() {

                    public void handleEvent(FieldEvent be) {
                        changeList("%");
                    }
                });
                return model.get("ple_nr_Percdesconto") != null ? formatReal.format(Double.parseDouble(model.get("ple_nr_Percdesconto").toString())) + "%" : model.get(property);
            }
        });

        cfvalorDesc.setRenderer(new GridCellRenderer<Ple_parcelaemprestimoTGWT>() {

            public Object render(Ple_parcelaemprestimoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ple_parcelaemprestimoTGWT> store, Grid<Ple_parcelaemprestimoTGWT> grid) {
                final Ple_parcelaemprestimoTGWT temp = (Ple_parcelaemprestimoTGWT) model;
                NumberField nf = new NumberField();
                nf.setFormat(formatReal);
                CellEditor ce = new CellEditor(nf);
                cfvalorDesc.setEditor(ce);
                nf.addListener(Events.Change, new Listener<FieldEvent>() {

                    public void handleEvent(FieldEvent be) {
                        changeList("$");
                    }
                });
                return model.get("ple_nr_valordesconto") != null ? formatReal.format(Double.parseDouble(model.get("ple_nr_valordesconto").toString())) : model.get(property);
            }
        });

        configsParcelaAberto.add(cfParcela);
        configsParcelaAberto.add(cfvenc);
        configsParcelaAberto.add(cfvalor);
        configsParcelaAberto.add(cfpercentual);
        configsParcelaAberto.add(cfvalorDesc);

        cmParcelaAberto = new ColumnModel(configsParcelaAberto);
        AggregationRowConfig<Ple_parcelaemprestimoTGWT> rowConfig = new AggregationRowConfig<Ple_parcelaemprestimoTGWT>();
        rowConfig.setSummaryFormat("ple_nr_valorparcela", formatReal);
        rowConfig.setSummaryType("ple_nr_valorparcela", SummaryType.SUM);
        cmParcelaAberto.addAggregationRow(rowConfig);
    }

    public void changeList(String tipo) {
        try {
            List<Record> list = storeParcelasAberto.getModifiedRecords();
            double valor = 0;
            for (Record record : list) {
                if (tipo.equalsIgnoreCase("%")) {
                    if (record.get("ple_nr_Percdesconto") != null) {
                        valor = Double.parseDouble(record.get("ple_nr_Percdesconto").toString()) * Double.parseDouble(record.get("ple_nr_valorparcela").toString()) / 100;
                        record.beginEdit();
                        record.set("ple_nr_valordesconto", valor);
                        record.endEdit();
                        record.commit(true);
                    }
                } else {
                    if (record.get("ple_nr_valordesconto") != null) {
                        double dif = Double.parseDouble(record.get("ple_nr_valorparcela").toString()) - Double.parseDouble(record.get("ple_nr_valordesconto").toString());
                        valor = 100 - (dif * 100 / Float.parseFloat(record.get("ple_nr_valorparcela").toString()));
                        record.beginEdit();
                        record.set("ple_nr_Percdesconto", valor);
                        record.endEdit();
                        record.commit(true);

                    }
                }
            }

            storeParcelasAberto.commitChanges();

            String q = "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createGridParcela(ListStore<Ple_parcelaemprestimoTGWT> store) {

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        ColumnConfig cfParcela = new ColumnConfig("ple_tx_parcela", "Parc.", 50);
        ColumnConfig cfvenc = new ColumnConfig("ple_dt_vencimento", "Vencimento", 88);
        cfvenc.setDateTimeFormat(dtfDate);

        ColumnConfig cfvalor = new ColumnConfig("ple_nr_valorparcela", "Valor", 80);
        cfvalor.setNumberFormat(formatReal);
        cfvalor.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig cftaxa = new ColumnConfig("tac_nr_taxa", "Taxa", 33);
        cftaxa.setNumberFormat(formatReal);
        cftaxa.setAlignment(HorizontalAlignment.RIGHT);

        ColumnConfig cfvalorLiqcartao = new ColumnConfig("ple_nr_valorLiqCartao", "Vl. liq. Cartão", 72);
        cfvalorLiqcartao.setNumberFormat(formatReal);
        cfvalorLiqcartao.setAlignment(HorizontalAlignment.RIGHT);

        configs.add(cfParcela);
        configs.add(cfvenc);
        configs.add(cfvalor);
        configs.add(cftaxa);
        configs.add(cfvalorLiqcartao);

        ColumnModel cm = new ColumnModel(configs);
        AggregationRowConfig<Ple_parcelaemprestimoTGWT> rowConfig = new AggregationRowConfig<Ple_parcelaemprestimoTGWT>();
        rowConfig.setSummaryFormat("ple_nr_valorparcela", formatReal);
        rowConfig.setSummaryType("ple_nr_valorparcela", SummaryType.SUM);
        cm.addAggregationRow(rowConfig);
        grid = new Grid(store, cm);

        grid.setLoadMask(true);
        grid.setStyleAttribute("borderTop", "none");
        grid.setBorders(true);
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        cpParcela.removeAll();
        cpParcela.add(grid);
        cpParcela.layout();
        //layout();

    }

    public void gerarParcela() {

        NumberFormat formatInt = NumberFormat.getFormat("00");
        List<Ple_parcelaemprestimoTGWT> list = new ArrayList<Ple_parcelaemprestimoTGWT>();
        CalendarUtil calendarUtil = new CalendarUtil();
        int mes = Integer.parseInt(dtfMes.format(dataAverbacao.getValue()));
        int ano = Integer.parseInt(dtfAno.format(dataAverbacao.getValue()));
        int dia = Integer.parseInt(dtfDia.format(dataAverbacao.getValue()));

        for (int i = 0; i < numParcValorAfin.getValue().intValue(); i++) {
            Ple_parcelaemprestimoTGWT parcela = new Ple_parcelaemprestimoTGWT();
            parcela.setPle_nr_valorparcela(valorParcelaAFIN.getValue().floatValue());
            parcela.setPle_tx_parcela(formatInt.format(i + 1) + "/" + formatInt.format(numParcValorAfin.getValue().intValue()));
            Date vencimento = new Date();
            vencimento = dtfDate.parse(dia + "/" + mes + "/" + ano);
            parcela.setPle_dt_vencimento(vencimento);
            mes++;
            if (mes == 13) {
                ano++;
                mes = 1;
            }
            list.add(parcela);
        }
        ListStore<Ple_parcelaemprestimoTGWT> store = new ListStore<Ple_parcelaemprestimoTGWT>();
        store.add(list);
        createGridParcela(store);
        calcularVlLiqCartao(cbTaxaCartao.getValue());
        layout();
    }

    public void calcularMenSocial() {
        if (menSocial.getValue() != null & numParcMenSocial.getValue() != null) {
            float total = menSocial.getValue().floatValue() * numParcMenSocial.getValue().floatValue();
            valorParcelaMenSocial.setValue(total);
        }
    }

    public boolean locatePerfil(String perfil) {
        boolean res = false;
        for (br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT per_perfilTGWT : listaPer.getModels()) {
            if (per_perfilTGWT.getPer_tx_nome().equalsIgnoreCase(perfil)) {
                res = true;
            }
        }
        return res;
    }

    public void calcularValorAFIN() {
        boolean administrador = locatePerfil(USUARIO_ADM);
        if ((valorAfin.getValue() != null & numParcValorAfin.getValue() != null & indice > 0) || administrador) {
            float vlParcela = valorAfin.getValue().floatValue() * indice;
            if (indice > 0) {
                valorParcelaAFIN.setValue(vlParcela);
            }
            float valorParcelas = 0;
            if (valorParcelaAFIN_Anterior.getValue() != null) {
                valorAFIN_Bruto.setValue(valorAfin.getValue().floatValue() - valorParcelaAFIN_Anterior.getValue().floatValue());
                valorParcelas = valorParcelaAFIN_Anterior.getValue().floatValue();
            } else {
                valorAFIN_Bruto.setValue(valorAfin.getValue().floatValue());
            }
            if (valorDescParcelaAFIN_Anterior.getValue() != null) {
                valorAFIN_Liquido.setValue(valorAfin.getValue().floatValue() - valorParcelas + valorDescParcelaAFIN_Anterior.getValue().floatValue());
            } else {
                valorAFIN_Liquido.setValue(valorAfin.getValue().floatValue() - valorParcelas);
            }

            layout();

            numParcValorAfin.setEditable(administrador);
            valorParcelaAFIN.setEditable(administrador);

            gerarParcela();
        } else {
            btnGeraParcela.setEnabled(false);
            if (indice == 0) {
                MessageBox.alert("ATENÇÃO", "Selecione um indice para continuar a operação!!", null);
            }
        }
    }

    public void addComboCorretor() {
        comboCorretor.setStore(cor_corretoraDAOGWT.getList());
        comboCorretor.setAllowBlank(false);
        comboCorretor.setTriggerAction(ComboBox.TriggerAction.ALL);
        //cor_tx_nomefantasia ,cor_tx_razaosocial
        comboCorretor.setDisplayField("cor_tx_razaosocial");
        comboCorretor.getView().refresh();
        comboCorretor.setValue(cor_corretoraDAOGWT.getMap().get(emp_emprestimoTGWT.getCor_nr_id()));
        //cp.add(comboCorretor);
        layout();

    }

    public void calcularIndiceDia() {
        int dia = Integer.parseInt(dtfDia.format(new Date()));
        for (Idc_indiceTGWT idc_indiceTGWT : (List<Idc_indiceTGWT>) idc_indiceDAOGWT.getList().getModels()) {
            if (dia >= idc_indiceTGWT.getIdc_nr_diainicial() & dia <= idc_indiceTGWT.getIdc_nr_diafinal()) {
                lblIndex.setValue(NumberFormat.getFormat("#,##0.00").format(idc_indiceTGWT.getIdc_nr_valor()) + "%");
                indice = idc_indiceTGWT.getIdc_nr_valor();
                idc_nr_id = idc_indiceTGWT.getIdc_nr_id();
                calcularValorAFIN();
                break;
            }
        }
    }

    public void montarTela() {

        dataIndice.setValue(new Date());
        String dia = dtfDia.format(dataIndice.getValue());
        TabPanel tpLocalisa = new TabPanel();
        tpLocalisa.setBodyBorder(true);
        tpLocalisa.setHeight(200);
        TabItem tabItem = new TabItem("Localização");
        tabItem.setLayout(new RowLayout(Orientation.VERTICAL));
        tpLocalisa.add(tabItem);

        ToolBar bar = new ToolBar();
        Radio rdMatricula = new Radio();
        rdMatricula.setBoxLabel("Matrícula");
        rdMatricula.setValue(true);

        Radio rdCPF = new Radio();
        rdCPF.setBoxLabel("CPF");

        Radio rdNome = new Radio();
        rdNome.setBoxLabel("Nome");
        radioGroup.add(rdMatricula);
        radioGroup.add(rdCPF);
        radioGroup.add(rdNome);

        ContentPanel cpMainDados = new ContentPanel(new RowLayout(Orientation.HORIZONTAL));
        cpMainDados.setHeaderVisible(false);
        cpMainDados.setBodyBorder(false);

        bar.add(radioGroup);
        bar.add(new SeparatorToolItem());
        tx_locate.setWidth(180);
        bar.add(tx_locate);
        bar.add(btnLoc);
        bar.add(new SeparatorToolItem());
        bar.add(new SeparatorToolItem());
        bar.add(btnNew);

        ContentPanel cpDadosCli = new ContentPanel();
        cpDadosCli.setHeaderVisible(false);
        cpDadosCli.setBodyBorder(false);
        TableLayout layoutDadosCli = new TableLayout(2);
        layoutDadosCli.setCellPadding(2);
        cpDadosCli.setLayout(layoutDadosCli);

        cpDadosCli.setTopComponent(bar);

        cpDadosCli.add(addLabelTopico("Matrícula:"));
        cli_tx_matricula.setWidth(70);
        cli_tx_matricula.setReadOnly(true);
        ContentPanel cpMatricula = new ContentPanel();
        cpMatricula.setHeaderVisible(false);
        cpMatricula.setBodyBorder(false);
        TableLayout layoutMat = new TableLayout(3);
        layoutMat.setCellPadding(2);
        cpMatricula.setLayout(layoutMat);
        cpMatricula.add(cli_tx_matricula);
        cpMatricula.add(addLabelTopico("N. Proposta:"));
        numeroProposta.setAllowBlank(false);
        cpMatricula.add(numeroProposta);
        cpDadosCli.add(cpMatricula);

        cpDadosCli.add(addLabelTopico("Nome:"));
        cli_tx_nome.setWidth(400);
        cli_tx_nome.setReadOnly(true);
        cpDadosCli.add(cli_tx_nome);

        cpDadosCli.add(addLabelTopico("CPF:"));
        cli_tx_cpf.setReadOnly(true);
        cpDadosCli.add(cli_tx_cpf);

        cpDadosCli.add(addLabelTopico("Banco:"));
        bco_tx_nome.setWidth(400);
        bco_tx_nome.setReadOnly(true);
        cpDadosCli.add(bco_tx_nome);

        cpDadosCli.add(addLabelTopico("Orgão:"));
        org_tx_nome.setWidth(400);
        org_tx_nome.setReadOnly(true);
        cpDadosCli.add(org_tx_nome);

        //ContentPanel cpIndex = new ContentPanel(new RowLayout());
        ContentPanel cpIndex = new ContentPanel(new FillLayout());
        cpIndex.setHeaderVisible(false);
        cpIndex.setBodyBorder(true);
        cpIndex.setFrame(false);
        ToolBar barIndex = new ToolBar();

        barIndex.setBorders(true);
        barIndex.add(new LabelToolItem("Tabela de Indices"));
        cpIndex.setTopComponent(barIndex);

        TableLayout layoutIndex = new TableLayout(2);
        layoutIndex.setCellPadding(4);
        ContentPanel cpdata = new ContentPanel(layoutIndex);
        cpdata.setHeaderVisible(false);
        cpdata.setBodyBorder(true);

        gridIndx = new Grid<Idc_indiceTGWT>(idc_indiceDAOGWT.getList(), getColumnModel());
        gridIndx.setStripeRows(true);
        gridIndx.setStyleAttribute("borderTop", "none");
        gridIndx.setBorders(true);
        gridIndx.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridIndx.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<Idc_indiceTGWT>>() {

            public void handleEvent(SelectionChangedEvent<Idc_indiceTGWT> be) {

                indice = be.getSelection().get(0).getIdc_nr_valor();
                idc_nr_id = be.getSelection().get(0).getIdc_nr_id();
                calcularValorAFIN();
                
            }
        });

        NumericFilter indx = new NumericFilter("idc_nr_valor");
        NumericFilter inicio = new NumericFilter("idc_nr_diainicial");
        NumericFilter fim = new NumericFilter("idc_nr_diafinal");
        NumericFilter qtde = new NumericFilter("idc_nr_qtdparcelas");
        ListStore<Idc_indiceTGWT> listStore = new ListStore<Idc_indiceTGWT>();
        listStore.add((List<Idc_indiceTGWT>) idc_indiceDAOGWT.getList().getModels());
        ListFilter listFilter = new ListFilter("idc_nr_valor", listStore);
        listFilter.setDisplayProperty("idc_nr_valor");

        GridFilters filters = new GridFilters();
        filters.setLocal(true);
        filters.addFilter(indx);
        filters.addFilter(inicio);
        filters.addFilter(fim);
        filters.addFilter(qtde);
        filters.addFilter(listFilter);
        gridIndx.addPlugin(filters);
        gridIndx.setColumnLines(true);
        gridIndx.getView().setForceFit(true);

        cpIndex.add(gridIndx);

        cpMainDados.add(cpDadosCli, new RowData(.70, 1, new Margins(2)));
        cpMainDados.add(cpIndex, new RowData(.30, 1, new Margins(2)));

        tabItem.add(cpMainDados, new RowData(1, 1, new Margins(2)));

        tpProposta.setBodyBorder(true);
        tpProposta.setHeight(350);
        tpProposta.add(tbiProposta);
        tpProposta.add(tbiParcelas);
        tbiParcelas.setLayout(new FillLayout());
        tbiParcelas.add(cpParcelasAberto);

        tpProposta.add(tbiCredito);
        tbiCredito.add(getFieldsCredito());
        getTipoCredito();

        mainCpMaster.add(tpLocalisa);
        mainCpMaster.add(tpProposta);

        TableLayout layoutProposta = new TableLayout(8);
        layoutProposta.setCellPadding(3);
        ContentPanel cpProposta = new ContentPanel(layoutProposta);
        cpProposta.setHeaderVisible(false);
        cpProposta.setBodyBorder(false);
        cpProposta.add(addLabelTopico("Men. Social:"));
        menSocial.setWidth(90);
        cpProposta.add(menSocial);
        cpProposta.add(addLabelTopico("Número Parcelas:"));
        numParcMenSocial.setWidth(90);
        cpProposta.add(numParcMenSocial);
        cpProposta.add(addLabelTopico("Total Geral:"));
        valorParcelaMenSocial.setWidth(90);
        cpProposta.add(valorParcelaMenSocial);

        LabelField lb1 = new LabelField("..");
        lb1.setVisible(false);

        LabelField lb2 = new LabelField("..");
        lb1.setVisible(false);
        lb2.setVisible(false);
        cpProposta.add(lb1);
        chkRenovacao.setBoxLabel("Renovação");
        cpProposta.add(chkRenovacao);

        cpProposta.add(addLabelTopico("Dt. Averbação:"));
        dataAverbacao.setWidth(90);
        cpProposta.add(dataAverbacao);

        cpProposta.add(addLabelTopico("Valor AFIN Total:"));
        valorAfin.setWidth(90);
        valorAfin.setFormat(formatReal);
        cpProposta.add(valorAfin);

        cpProposta.add(addLabelTopico("Número Parcelas:"));
        numParcValorAfin.setWidth(90);
        cpProposta.add(numParcValorAfin);

        cpProposta.add(addLabelTopico("Valor da Parcela:"));
        valorParcelaAFIN.setWidth(90);
        valorParcelaAFIN.setFormat(formatReal);
        cpProposta.add(valorParcelaAFIN);

        cpProposta.add(addLabelTopico("Vl. Parcelas Pendentes:"));
        valorParcelaAFIN_Anterior.setWidth(90);
        valorParcelaAFIN_Anterior.setFormat(formatReal);
        cpProposta.add(valorParcelaAFIN_Anterior);

        cpProposta.add(addLabelTopico("Valor AFIN:"));
        valorAFIN_Bruto.setWidth(90);
        valorAFIN_Bruto.setFormat(formatReal);
        cpProposta.add(valorAFIN_Bruto);

        cpProposta.add(addLabelTopico("Valor Desc. Parcelas:"));
        valorDescParcelaAFIN_Anterior.setWidth(90);
        valorDescParcelaAFIN_Anterior.setFormat(formatReal);
        cpProposta.add(valorDescParcelaAFIN_Anterior);

        cpProposta.add(addLabelTopico("Valor Cheque Liberado:"));
        valorAFIN_Liquido.setWidth(90);
        valorAFIN_Liquido.setFormat(formatReal);
        cpProposta.add(valorAFIN_Liquido);

        ContentPanel cpFechamento = new ContentPanel(new FillLayout());

        cpFechamento.setHeaderVisible(false);
        cpFechamento.setBodyBorder(false);

        ContentPanel cpObs = new ContentPanel();
        cpObs.setHeaderVisible(false);
        cpObs.setBodyBorder(false);
        TableLayout layoutObs = new TableLayout(2);
        layoutObs.setCellPadding(4);
        cpObs.setLayout(layoutObs);
        cpObs.add(addLabelTopico("Corretor..........:"));
        //addComboCorretor();

        comboCorretor.setWidth(300);
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);
        cpObs.add(comboCorretor);

        cpObs.add(addLabelTopico("Obs.................:"));
        emp_tx_observacoes.setWidth(300);
        emp_tx_observacoes.setPreventScrollbars(true);
        emp_tx_observacoes.setHeight(70);
        cpObs.add(emp_tx_observacoes);
        cpFechamento.add(cpObs);

        ContentPanel cpCartao = new ContentPanel();
        TableLayout layoutcartao = new TableLayout(3);
        layoutcartao.setCellPadding(4);
        cpCartao.setHeight(60);
        cpCartao.setHeaderVisible(false);
        cpCartao.setBodyBorder(false);
        cpCartao.setLayout(layoutcartao);
        cpFechamento.setBottomComponent(cpCartao);
        chkCartao.setBoxLabel("Cartão");
        cpCartao.add(chkCartao);
        cpCartao.add(cbCartao);
        cpCartao.add(cbTaxaCartao);
//

        ContentPanel cpMainFechamento = new ContentPanel(new RowLayout(Orientation.HORIZONTAL));
        cpMainFechamento.setHeight(185);
        cpMainFechamento.setHeaderVisible(false);
        cpMainFechamento.setBodyBorder(false);

        cpMainFechamento.add(cpFechamento, new RowData(.50, 1, new Margins(3)));
        cpParcela.setHeaderVisible(false);
        cpMainFechamento.add(cpParcela, new RowData(.50, 1, new Margins(3)));

        tbiProposta.add(cpProposta);
        tbiProposta.add(cpMainFechamento);

        getCpMaster().add(mainCpMaster);

        preencherDadosPropsta();
        layout();

    }

    public void povoaCartao() {
        cbCartao.setDisplayField("car_tx_nome");
        cbCartao.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbCartao.setEmptyText("Cartão");
        cbCartao.setWidth(120);
        cbCartao.setVisible(false);
        final Car_cartaoDAOGWT car_cartaoDAOGWT = new Car_cartaoDAOGWT();
        car_cartaoDAOGWT.consult();
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Car_cartaoTGWT> list = car_cartaoDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    cbCartao.setStore(list);
                    cbCartao.getListView().refresh();
                }

            }
        };
        timer.schedule(100);
        cbCartao.addSelectionChangedListener(new SelectionChangedListener<Car_cartaoTGWT>() {

            @Override
            public void selectionChanged(SelectionChangedEvent<Car_cartaoTGWT> se) {
                if (se.getSelectedItem() != null) {
                    povoarTaxaCartao(se.getSelectedItem());
                }
            }
        });

        cbTaxaCartao.setDisplayField("tac_tx_nome");
        cbTaxaCartao.setEmptyText("Taxa");
        cbTaxaCartao.setWidth(120);
        cbTaxaCartao.setVisible(false);

        cbTaxaCartao.setTriggerAction(ComboBox.TriggerAction.ALL);
        ListStore<Tac_taxa_cartaoTGWT> listStore = new ListStore<Tac_taxa_cartaoTGWT>();

        cbTaxaCartao.setStore(listStore);
        cbTaxaCartao.getListView().refresh();
        cbTaxaCartao.addSelectionChangedListener(new SelectionChangedListener<Tac_taxa_cartaoTGWT>() {

            @Override
            public void selectionChanged(SelectionChangedEvent<Tac_taxa_cartaoTGWT> se) {
                if (se.getSelectedItem() != null) {
                    calcularVlLiqCartao(se.getSelectedItem());
                }
            }
        });
    }

    public void calcularVlLiqCartao(Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT) {
        float vl_liquido = 0;
        if (tac_taxa_cartaoTGWT != null) {
            vl_liquido = valorParcelaAFIN.getValue().floatValue() - (tac_taxa_cartaoTGWT.getTac_nr_taxa() * valorParcelaAFIN.getValue().floatValue());
        }
        store = grid.getStore();
        for (Ple_parcelaemprestimoTGWT parcelaT : store.getModels()) {
            if (vl_liquido > 0) {
                parcelaT.setPle_nr_valorLiqCartao(vl_liquido);
                parcelaT.setTac_nr_taxa(tac_taxa_cartaoTGWT.getTac_nr_taxa());
                store.update(parcelaT);
            } else {
                parcelaT.setPle_nr_valorLiqCartao(valorParcelaAFIN.getValue().floatValue());
                parcelaT.setTac_nr_taxa(0);
                store.update(parcelaT);
            }
        }
    }

    public void calcularVlLiqCartaoReverso() {
        float vl_liquido = 0;

        store = (ListStore<Ple_parcelaemprestimoTGWT>) grid.getStore();
        tac_taxa_cartaoTGWT = cbTaxaCartao.getValue();
        for (Ple_parcelaemprestimoTGWT parcelaT : store.getModels()) {
            //if (parcelaT.getPle_tx_tipo().equalsIgnoreCase("P")) {
                parcelaT.setPle_nr_valorLiqCartao(valorParcelaAFIN.getValue().floatValue() - (tac_taxa_cartaoTGWT.getTac_nr_taxa() * valorParcelaAFIN.getValue().floatValue()));
                //parcelaT.setPle_nr_valorparcela(valorParcelaAFIN.getValue().floatValue());
                parcelaT.setTac_nr_taxa(tac_taxa_cartaoTGWT.getTac_nr_taxa());
                store.update(parcelaT);
            //}

        }
    }

    public void povoarTaxaCartao(Car_cartaoTGWT car_cartaoTGWT) {

        final Tac_taxa_cartaoDAOGWT tac_taxa_cartaoDAOGWT = new Tac_taxa_cartaoDAOGWT();
        tac_taxa_cartaoDAOGWT.consult(car_cartaoTGWT);

        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Tac_taxa_cartaoTGWT> list = tac_taxa_cartaoDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {

                    cbTaxaCartao.setStore(list);
                    //cbTaxaCartao.getStore().add(list.getModels()); 
                    //cbTaxaCartao.getListView().getStore().add(list.getModels());
                    cbTaxaCartao.getListView().refresh();
                    if (!loadUpdate) {
                        cbTaxaCartao.setValue(cbTaxaCartao.getStore().findModel("tac_nr_id", tac_taxa_cartaoTGWT.getTac_nr_id()));
                        loadUpdate = true;
                        if (tac_taxa_cartaoTGWT != null) {
                            Idc_indiceTGWT idc_indiceTGWT = gridIndx.getStore().findModel("idc_nr_id", emp_emprestimoTGWT.getIdc_nr_id());
                            indice = idc_indiceTGWT.getIdc_nr_valor();
                            idc_nr_id = idc_indiceTGWT.getIdc_nr_id();
                            calcularValorAFIN();

                        }

                        calcularVlLiqCartaoReverso();
                    }
                    //layout();
                }
            }
        };
        timer.schedule(200);
    }

    public LabelField addLabelTopico(String text) {
        LabelField field = new LabelField(text);
        field.setStyleName("font09-Negrito");
        return field;
    }

    public void locateCliente() {
        String campoFiltro = "";
        if (radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Matrícula")) {
            campoFiltro = "matricula";
        } else if (radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Nome")) {
            campoFiltro = "Nome";
        } else {
            campoFiltro = "CPF";
        }

        Locate_ClienteGWT locate_ClienteGWT = new Locate_ClienteGWT(null, Emp_emprestimoUpdateDeleteGWT.this, campoFiltro, tx_locate.getValue());
        locate_ClienteGWT.setModal(true);
        locate_ClienteGWT.show();
    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (propostaValida()) {
            Emp_emprestimoTGWT emp_emprestimoT = new Emp_emprestimoTGWT();
            emp_emprestimoT.setEmp_nr_id(emp_emprestimoTGWT.getEmp_nr_id());
            emp_emprestimoT.setCli_nr_id(Integer.parseInt(getCli_nr_id().getValue()));
            emp_emprestimoT.setCor_nr_id(comboCorretor.getValue().getCor_nr_id());
            emp_emprestimoT.setIdc_nr_id(idc_nr_id);
            emp_emprestimoT.setOrg_nr_id(org_nr_id);
            emp_emprestimoT.setEmp_dt_emprestimo(emp_emprestimoTGWT.getEmp_dt_emprestimo());
            emp_emprestimoT.setEmp_nr_valor(valorAfin.getValue().floatValue());
            emp_emprestimoT.setEmp_tx_status("A");
            if (emp_tx_observacoes.getValue() != null) {
                emp_emprestimoT.setEmp_tx_observacoes(emp_tx_observacoes.getValue());
            }
            emp_emprestimoT.setEmp_dt_aprovacao(new Date());
            emp_emprestimoT.setEmp_dt_liberacao(dataAverbacao.getValue());
            emp_emprestimoT.setEmp_nr_valor_afin_bruto(valorAFIN_Bruto.getValue() != null ? valorAFIN_Bruto.getValue().floatValue() : 0);
            emp_emprestimoT.setEmp_nr_valor_afin_liquido(valorAFIN_Liquido.getValue() != null ? valorAFIN_Liquido.getValue().floatValue() : 0);
            emp_emprestimoT.setEmp_nr_valor_parcelas_anterior(valorParcelaAFIN_Anterior.getValue() != null ? valorParcelaAFIN_Anterior.getValue().floatValue() : 0);
            emp_emprestimoT.setEmp_nr_valor_desc_parcela_anterior(valorDescParcelaAFIN_Anterior.getValue() != null ? valorDescParcelaAFIN_Anterior.getValue().floatValue() : 0);

            emp_emprestimoT.setEmp_nr_proposta(numeroProposta.getValue().intValue());

            emp_emprestimoT.setTic_nr_id(cbTipocred.getValue().getTic_nr_id());
            emp_emprestimoT.setEmp_tx_numerocheque(emp_tx_numerocheque.getValue() == null ? "" : emp_tx_numerocheque.getValue());
            emp_emprestimoT.setEmp_tx_compensado(chkCompensado.getValue().booleanValue() ? "S" : "N");
            //Window.alert(emp_tx_numerocheque.getValue());

            int a = numParcValorAfin.getValue().intValue();
            float b = valorParcelaAFIN.getValue().floatValue();
            float c = menSocial.getValue().floatValue();
            int d = numParcMenSocial.getValue().intValue();
            int e = numParcMenSocial.getValue().intValue();
            String f = getParamDesconto();
            String dt = dtfDate.format(dataAverbacao.getValue());
            int g = id_emprestimoBaixa;

            float tac_nr_taxa =0;
            emp_emprestimoT.setTac_nr_id(0);
            
            if(cbTaxaCartao.getValue() != null){
                
                tac_nr_taxa = cbTaxaCartao.getValue().getTac_nr_taxa();
                
                emp_emprestimoT.setTac_nr_id(cbTaxaCartao.getValue().getTac_nr_id());
                
            }
            emp_emprestimoDao.alterar(emp_emprestimoT, numParcValorAfin.getValue().intValue(), valorParcelaAFIN.getValue().floatValue(), menSocial.getValue().floatValue(), numParcMenSocial.getValue().intValue(), getParamDesconto(), dtfDate.format(dataAverbacao.getValue()), id_emprestimoBaixa, tac_nr_taxa);
            Timer timer = new Timer() {

                public void run() {
                    String msg = emp_emprestimoDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            btnLimpartAction(null);
                            emp_emprestimoConsult.load();
                            setVisible(false);
                            if (msg.indexOf("quitadas") > -1) {
                                MessageBox.alert("IMPORTANTE", "Emprestimo alterado com sucesso, porém as parcelas não foram alteradas por existir parcelas quitadas", null);
                            }
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void btnLimpartAction(ButtonEvent ce) {
        cli_tx_matricula.setValue("");
        cli_tx_cpf.setValue("");
        cli_tx_nome.setValue("");
        bco_tx_nome.setValue("");
        org_tx_nome.setValue("");
        dataIndice.setValue(new Date());

        menSocial.setValue(null);
        numParcMenSocial.setValue(null);
        valorParcelaMenSocial.setValue(null);
        valorAfin.setValue(null);
        numParcValorAfin.setValue(null);
        valorParcelaAFIN.setValue(null);
        dataAverbacao.setValue(null);
        comboCorretor.setValue(null);

        valorAFIN_Bruto.setValue(null);
        valorAFIN_Liquido.setValue(null);
        valorParcelaAFIN_Anterior.setValue(null);
        valorDescParcelaAFIN_Anterior.setValue(null);
        numeroProposta.setValue(null);
        emp_tx_observacoes.setValue("");
        cpParcela.removeAll();
        tx_locate.focus();

    }

    public void btnDeltAction(ButtonEvent ce) {

        emp_emprestimoDao.excluir(emp_emprestimoTGWT);
        Timer timer = new Timer() {

            public void run() {
                String msg = emp_emprestimoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        MessageBox.alert("ATENÇAO", msg, null);
                        Info.display("Resultado", msg);
                        emp_emprestimoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void consultarParcelasAberto() {
        try {
            final Ple_parcelaemprestimoDAOGWT pdaogwt = new Ple_parcelaemprestimoDAOGWT();
            pdaogwt.consultarTodosCliente(Integer.parseInt(cli_nr_id.getValue()), "P");
            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (pdaogwt.getList() == null) {
                        schedule(500);
                    } else {
                        cpParcelasAberto.removeAll();
                        storeParcelasAberto = new ListStore<Ple_parcelaemprestimoTGWT>();
                        storeParcelasAberto.add((List<Ple_parcelaemprestimoTGWT>) pdaogwt.getList().getModels());
                        EditorGrid<Ple_parcelaemprestimoTGWT> gridParAberto = new EditorGrid<Ple_parcelaemprestimoTGWT>(storeParcelasAberto, cmParcelaAberto);
                        gridParAberto.setStripeRows(true);
                        gridParAberto.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                        gridParAberto.setBorders(true);
                        gridParAberto.getView().setEmptyText("Não existe parcelas pendentes para este cliente!!!!");
                        cpParcelasAberto.add(gridParAberto);
                        layout();
                    }
                }
            };
            timer.schedule(500);
            layout();

        } catch (Exception e) {
        }
    }

    public void load(Emp_emprestimoTGWT emp_emprestimoTGWT) {

        this.emp_emprestimoTGWT = emp_emprestimoTGWT;
        ple_parcelaemprestimoDAOGWT.consultarTodos(emp_emprestimoTGWT.getEmp_nr_id());
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (ple_parcelaemprestimoDAOGWT.getList() == null || cor_corretoraDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    montarTela();
                }
            }
        };

        timer.schedule(500);
        layout();

    }

    public void preencherDadosPropsta() {
        try {
            cli_nr_id.setValue(emp_emprestimoTGWT.getCli_nr_id() + "");
            org_nr_id = emp_emprestimoTGWT.getOrg_nr_id();
            idc_nr_id = emp_emprestimoTGWT.getIdc_nr_id();
            dataAverbacao.setValue(emp_emprestimoTGWT.getEmp_dt_liberacao());

            cli_tx_nome.setValue(emp_emprestimoTGWT.getCli_tx_nome());
            cli_tx_cpf.setValue(emp_emprestimoTGWT.getCli_tx_cpf());
            cli_tx_matricula.setValue(emp_emprestimoTGWT.getCli_tx_matricula());
            bco_tx_nome.setValue(emp_emprestimoTGWT.getBco_tx_nome());
            org_tx_nome.setValue(emp_emprestimoTGWT.getOrg_tx_nome());

            valorAfin.setValue(emp_emprestimoTGWT.getEmp_nr_valor());
            //dataAverbacao.setValue(emp_emprestimoTGWT.getEmp_dt_aprovacao());
            if (emp_emprestimoTGWT.get("emp_nr_valor_parcelas_anterior") != null) {
                valorParcelaAFIN_Anterior.setValue(emp_emprestimoTGWT.getEmp_nr_valor_parcelas_anterior());
            }
            if (emp_emprestimoTGWT.get("emp_nr_valor_afin_bruto") != null) {
                valorAFIN_Bruto.setValue(emp_emprestimoTGWT.getEmp_nr_valor_afin_bruto());
            }
            if (emp_emprestimoTGWT.get("emp_nr_valor_desc_parcela_anterior") != null) {
                valorDescParcelaAFIN_Anterior.setValue(emp_emprestimoTGWT.getEmp_nr_valor_desc_parcela_anterior());
            }
            if (emp_emprestimoTGWT.get("emp_nr_valor_afin_liquido") != null) {
                valorAFIN_Liquido.setValue(emp_emprestimoTGWT.getEmp_nr_valor_afin_liquido());
            }
            dataAverbacao.setValue(emp_emprestimoTGWT.getEmp_dt_liberacao());
            numeroProposta.setValue(emp_emprestimoTGWT.getEmp_nr_proposta());
            emp_tx_observacoes.setValue(emp_emprestimoTGWT.getEmp_tx_observacoes());

            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (cor_corretoraDAOGWT.getList() == null || idc_indiceDAOGWT.getList() == null) {
                        schedule(500);
                    } else {
                        preencherFieldsCalculados();
                        addComboCorretor();
                        layout();
                    }
                }
            };
            timer.schedule(500);
            if (this.emp_emprestimoTGWT.getTac_nr_id() > 0) {
                chkCartao.setValue(true);
                cbCartao.setVisible(true);
                cbTaxaCartao.setVisible(true);

                final Tac_taxa_cartaoDAOGWT tdaogwt = new Tac_taxa_cartaoDAOGWT();
                tdaogwt.findId(this.emp_emprestimoTGWT.getTac_nr_id());
                Timer timer1 = new Timer() {

                    @Override
                    public void run() {
                        if (tdaogwt.getMsg() == null) {
                            schedule(500);
                        } else {
                            tac_taxa_cartaoTGWT = tdaogwt.getTac_taxa_cartaoT();
                            cbCartao.setValue(cbCartao.getStore().findModel("car_nr_id", tac_taxa_cartaoTGWT.getCar_nr_id()));
                            layout();
                        }
                    }
                };
                timer1.schedule(300);

            }

            //doLayout();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void preencherFieldsCalculados() {
        int qtdMen = 0;
        int qtdParcela = 0;
        float valor_parcelaMen = 0;
        float totalMen = 0;
        float valorParcelaAfin = 0;

        for (Ple_parcelaemprestimoTGWT parcela : (List<Ple_parcelaemprestimoTGWT>) ple_parcelaemprestimoDAOGWT.getList().getModels()) {
            if (parcela.getPle_tx_tipo().equalsIgnoreCase("P")) {
                qtdParcela++;

                valorParcelaAfin = parcela.getPle_nr_valorparcela();

            } else {
                qtdMen++;
                totalMen += parcela.getPle_nr_valorparcela();
                valor_parcelaMen = parcela.getPle_nr_valorparcela();
            }
        }

        menSocial.setValue(valor_parcelaMen);
        numParcMenSocial.setValue(qtdMen);
        valorParcelaMenSocial.setValue(totalMen);

        numParcValorAfin.setValue(qtdParcela);
        valorParcelaAFIN.setValue(valorParcelaAfin);

        createGridParcela(ple_parcelaemprestimoDAOGWT.getList());

    }

    /**
     * @return the emp_emprestimoConsult
     */
    public Emp_emprestimoConsultGWT getEmp_emprestimoConsult() {
        return emp_emprestimoConsult;
    }

    /**
     * @param emp_emprestimoConsult the emp_emprestimoConsult to set
     */
    public void setEmp_emprestimoConsult(Emp_emprestimoConsultGWT emp_emprestimoConsult) {
        this.emp_emprestimoConsult = emp_emprestimoConsult;
    }

    /**
     * @return the cli_tx_nome
     */
    public TextField<String> getCli_tx_nome() {
        return cli_tx_nome;
    }

    /**
     * @param cli_tx_nome the cli_tx_nome to set
     */
    public void setCli_tx_nome(TextField<String> cli_tx_nome) {
        this.cli_tx_nome = cli_tx_nome;
    }

    /**
     * @return the cli_tx_cpf
     */
    public TextField<String> getCli_tx_cpf() {
        return cli_tx_cpf;
    }

    /**
     * @param cli_tx_cpf the cli_tx_cpf to set
     */
    public void setCli_tx_cpf(TextField<String> cli_tx_cpf) {
        this.cli_tx_cpf = cli_tx_cpf;
    }

    /**
     * @return the cli_tx_matricula
     */
    public TextField<String> getCli_tx_matricula() {
        return cli_tx_matricula;
    }

    /**
     * @param cli_tx_matricula the cli_tx_matricula to set
     */
    public void setCli_tx_matricula(TextField<String> cli_tx_matricula) {
        this.cli_tx_matricula = cli_tx_matricula;
    }

    /**
     * @return the bco_tx_nome
     */
    public TextField<String> getBco_tx_nome() {
        return bco_tx_nome;
    }

    /**
     * @param bco_tx_nome the bco_tx_nome to set
     */
    public void setBco_tx_nome(TextField<String> bco_tx_nome) {
        this.bco_tx_nome = bco_tx_nome;
    }

    /**
     * @return the org_tx_nome
     */
    public TextField<String> getOrg_tx_nome() {
        return org_tx_nome;
    }

    /**
     * @param org_tx_nome the org_tx_nome to set
     */
    public void setOrg_tx_nome(TextField<String> org_tx_nome) {
        this.org_tx_nome = org_tx_nome;
    }

    /**
     * @return the cli_nr_id
     */
    public TextField<String> getCli_nr_id() {
        return cli_nr_id;
    }

    /**
     * @param cli_nr_id the cli_nr_id to set
     */
    public void setCli_nr_id(TextField<String> cli_nr_id) {
        this.cli_nr_id = cli_nr_id;
    }

    /**
     * @return the age_nr_id
     */
    public TextField<String> getAge_nr_id() {
        return age_nr_id;
    }

    /**
     * @param age_nr_id the age_nr_id to set
     */
    public void setAge_nr_id(TextField<String> age_nr_id) {
        this.age_nr_id = age_nr_id;
    }

    /**
     * @return the cor_nr_id
     */
    public TextField<String> getCor_nr_id() {
        return cor_nr_id;
    }

    /**
     * @param cor_nr_id the cor_nr_id to set
     */
    public void setCor_nr_id(TextField<String> cor_nr_id) {
        this.cor_nr_id = cor_nr_id;
    }

    /**
     * @return the org_nr_id
     */
    public int getOrg_nr_id() {
        return org_nr_id;
    }

    /**
     * @param org_nr_id the org_nr_id to set
     */
    public void setOrg_nr_id(int org_nr_id) {
        this.org_nr_id = org_nr_id;
    }

    public boolean propostaValida() {
        MessageBox mb = new MessageBox();
        boolean resposta = true;
        if (numeroProposta.getValue() == null) {
            resposta = false;
            mb.alert("IMPORTANTE", "Os campos número da proposta tem preenchimento obrigatório!", null);
        } else if (cli_nr_id.getValue() == null) {
            resposta = false;
            mb.alert("IMPORTANTE", "Os campos dados do cliente preenchimento obrigatório!", null);
        } else if (menSocial.getValue() == null || menSocial.getValue().floatValue() == 0) {
            resposta = false;
            mb.alert("IMPORTANTE", "O campo valor da mensalidade tem preenchimento obrigatório!", null);
            menSocial.focus();
        } else if (numParcMenSocial.getValue() == null || numParcMenSocial.getValue().floatValue() == 0) {
            resposta = false;
            mb.alert("IMPMORTANTE", "O campo número de parcelas da mensalidade tem preenchimento obrigatório!", null);
            numParcMenSocial.focus();
        } else if (valorAfin.getValue() == null || valorAfin.getValue().floatValue() == 0) {
            resposta = false;
            mb.alert("IMPMORTANTE", "O campo valor AFIN tem preenchimento obrigatório!", null);
            valorAfin.focus();
        } else if (numParcValorAfin.getValue() == null || numParcValorAfin.getValue().floatValue() == 0) {
            resposta = false;
            mb.alert("IMPMORTANTE", "O campo numero parcelas AFIN tem preenchimento obrigatório!", null);
            numParcValorAfin.focus();
        } else if (!valorParcelasAnteriorValida()) {
            resposta = false;
            mb.alert("IMPMORTANTE", "A soma das parcelas pendentes está diferente do valor informado!", null);
            valorParcelaAFIN_Anterior.focus();
        } else if (!valorDescontoValido()) {
            resposta = false;
            mb.alert("IMPMORTANTE", "A soma dos descontos das parcelas está diferente do valor informado!", null);
            valorDescParcelaAFIN_Anterior.focus();
        } else if (cbTipocred.getValue() == null) {
            resposta = false;
            mb.alert("IMPMORTANTE", "O campo Tipo de crédito tem preenchimento obrigatório!", null);
        } else if (cbTipocred.getValue().getTic_nr_id() > 0 && emp_tx_numerocheque.getValue() == null) {
            resposta = false;
            mb.alert("IMPMORTANTE", "O campo Número do crédito tem preenchimento obrigatório!", null);
        } else if (comboCorretor.getValue() == null) {
            resposta = false;
            mb.alert("IMPMORTANTE", "O campo corretor tem preenchimento obrigatório!", null);
        }
        return resposta;
    }

    public boolean valorParcelasAnteriorValida() {
        boolean resultado = true;
        float valorParcela = valorParcelasPendente();
        if (valorParcela > 0) {
            if (valorParcelaAFIN_Anterior.getValue() == null) {
                resultado = false;
            } else if (valorParcelaAFIN_Anterior.getValue().floatValue() != valorParcela) {
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean valorDescontoValido() {
        float valorDesconto = valorDesconto();
        boolean resultado = true;
        float valorParcela = valorParcelasPendente();
        if (valorParcela > 0) {
            if (valorDescParcelaAFIN_Anterior.getValue() == null) {
                resultado = false;
            } else if (valorDescParcelaAFIN_Anterior.getValue().floatValue() != valorDesconto) {
                resultado = false;
            }
        }
        return resultado;
    }

    public float valorParcelasPendente() {
        float valor = 0;
        try {
            for (int i = 0; i < storeParcelasAberto.getModels().size(); i++) {
                valor += Float.parseFloat(storeParcelasAberto.getModels().get(i).get("ple_nr_valorparcela").toString());
            }
        } catch (Exception e) {
            return 0;
        }

        return valor;
    }

    public float valorDesconto() {
        float valor = 0;
        try {
            id_emprestimoBaixa = 0;
            for (int i = 0; i < storeParcelasAberto.getModels().size(); i++) {
                valor += Float.parseFloat(storeParcelasAberto.getModels().get(i).get("ple_nr_valordesconto").toString());
                id_emprestimoBaixa = Integer.parseInt(storeParcelasAberto.getModels().get(i).get("emp_nr_id").toString());
            }
        } catch (Exception e) {
            return 0;
        }
        return valor;
    }

    public String getParamDesconto() {
        String valor = "";
        if (storeParcelasAberto != null) {
            for (int i = 0; i < storeParcelasAberto.getModels().size(); i++) {
                valor += "&vetIdParcelas=" + storeParcelasAberto.getModels().get(i).get("ple_nr_id").toString() + "&vetDesconto=" + storeParcelasAberto.getModels().get(i).get("ple_nr_valordesconto").toString();
            }
        }
        return valor;
    }
}
