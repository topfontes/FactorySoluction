/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.welcome;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.i9factory.factory.dao.Ctp_conta_pagarDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Emp_emprestimoDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Ple_parcelaemprestimoDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Res_restricaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Vw_parcelasDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Ctp_conta_pagarTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Emp_emprestimoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Ple_parcelaemprestimoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Res_restricaoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Vw_parcelasTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class WelCome extends LayoutContainer {

    private Portlet portletCtp = new Portlet(new FitLayout());
    private Portlet portletRestricao = new Portlet(new FitLayout());
    private Portlet portletAtrazo = new Portlet(new FitLayout());
    private Portlet portletUtimosEmp = new Portlet(new FitLayout());
    private Portlet portlet11Mensalidades = new Portlet(new FitLayout());
    private Ctp_conta_pagarDAOGWT ctp_conta_pagarDAOGWT = new Ctp_conta_pagarDAOGWT();
    private Res_restricaoDAOGWT res_restricaoDAOGWT = new Res_restricaoDAOGWT();
    private Ple_parcelaemprestimoDAOGWT ple_parcelaemprestimoDAOGWT = new Ple_parcelaemprestimoDAOGWT();
    private Vw_parcelasDAOGWT vw_parcelasDAOGWT = new Vw_parcelasDAOGWT();
    private Emp_emprestimoDAOGWT emp_emprestimoDAOGWT = new Emp_emprestimoDAOGWT();
    private boolean primeiraVez = true;
    private int height;
    private Portal portal = new Portal(3);
    private Grid<Vw_parcelasTGWT> grid12Men;
    private MessageBox box = new MessageBox();

    public WelCome() {
        setBorders(false);

        portal.setBorders(true);
        portal.setStyleAttribute("backgroundColor", "white");
        portal.setColumnWidth(0, .33);
        portal.setColumnWidth(1, .33);
        portal.setColumnWidth(2, .33);

        portletCtp.setAnimCollapse(true);
        portletRestricao.setAnimCollapse(true);
        portletAtrazo.setAnimCollapse(true);

        portletCtp.setHeading("Títulos com vencimentos hoje");
        configPanel(portletCtp);
        portletCtp.setHeight(250);
        portal.add(portletCtp, 0);

        portletRestricao.setHeading("Clientes com restrições");
        configPanel(portletRestricao);
        portletRestricao.setHeight(250);
        portal.add(portletRestricao, 0);

        portletAtrazo.setHeading("Clientes inadimplentes");
        configPanel(portletAtrazo);
        portletAtrazo.setHeight(250);
        portal.add(portletAtrazo, 1);

        portletUtimosEmp.setHeading("Ultimos emprestimos/propostas");
        configPanel(portletUtimosEmp);
        portletUtimosEmp.setHeight(250);
        portal.add(portletUtimosEmp, 1);

        portlet11Mensalidades.setHeading("Clientes na décima primeira mensalidade");
        configPanel(portlet11Mensalidades);
        portlet11Mensalidades.setHeight(250);
        portal.add(portlet11Mensalidades, 2);

        add(portal, new RowData(1, 1, new Margins(1)));


//        thread();
        povoaResultado();
    }

//    public void thread() {
//        Timer timer = new Timer() {
//
//            @Override
//            public void run() {
//                povoaResultado();
//            }
//        };
//        timer.scheduleRepeating(1000 * 60 * 30); // atualiza a cada 5 minutos
//    }
    public void povoaResultado() {
        ctp_conta_pagarDAOGWT.consultarAVencerHoje();
        emp_emprestimoDAOGWT.consultarUltimos();
        res_restricaoDAOGWT.consultarTodos();
        ple_parcelaemprestimoDAOGWT.consultarParcelasAtrazo();
        vw_parcelasDAOGWT.consultarTodos12Mensalidade();

        Timer timer = new Timer() {
            @Override
            public void run() {
                if (ctp_conta_pagarDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    addPortletCTP();
                    Timer timerEmp = new Timer() {
                        @Override
                        public void run() {
                            if (emp_emprestimoDAOGWT.getList() == null) {
                                schedule(200);
                            } else {
                                addUltimosEmprestimos();
                                Timer timer = new Timer() {
                                    @Override
                                    public void run() {
                                        if (res_restricaoDAOGWT.getList() == null) {
                                            schedule(100);
                                        } else {
                                            addRestricao();
                                            Timer timer = new Timer() {
                                                @Override
                                                public void run() {
                                                    if (ple_parcelaemprestimoDAOGWT.getList() == null) {
                                                        schedule(50);
                                                    } else {
                                                        addParcelasAtrazo();
                                                        Timer timer = new Timer() {
                                                            @Override
                                                            public void run() {
                                                                if (vw_parcelasDAOGWT.getList() == null) {
                                                                    schedule(100);
                                                                } else {
                                                                    add11Mesalidade();
                                                                }
                                                            }
                                                        };
                                                        timer.schedule(50);
                                                    }
                                                    portletCtp.setHeight((getHeight() / 2) - 18);
                                                    portlet11Mensalidades.setHeight(getHeight() - 50 / 2);
                                                    portletAtrazo.setHeight((getHeight() / 2) - 18);
                                                    portletRestricao.setHeight((getHeight() / 2) - 18);
                                                    portletUtimosEmp.setHeight((getHeight() / 2) - 18);
                                                    layout();
                                                }
                                            };
                                            timer.schedule(50);
                                        }
                                    }
                                };
                                timer.schedule(100);
                            }
                        }
                    };
                    timerEmp.schedule(200);
                }
            }
        };
        timer.schedule(500);
    }

    public void addRestricao() {

        List<ColumnConfig> configs = new Vector();
        SummaryColumnConfig<Double> cli = new SummaryColumnConfig<Double>("cli_tx_nome", "Cliente", 230);
        SummaryColumnConfig<Double> restricao = new SummaryColumnConfig<Double>("res_tx_nome", "Restrições", 80);

        configs.clear();
        configs.add(cli);
        configs.add(restricao);
        ColumnModel cm = new ColumnModel(configs);

        GroupingStore<Res_restricaoTGWT> store = new GroupingStore<Res_restricaoTGWT>();
        store.add((List<Res_restricaoTGWT>) res_restricaoDAOGWT.getList().getModels());
        store.groupBy("cli_tx_nome");

        GroupingView view = new GroupSummaryView();
        view.setForceFit(true);
        view.setShowGroupedColumn(false);

        Grid<Res_restricaoTGWT> grid = new Grid<Res_restricaoTGWT>(store, cm);
        grid.setView(view);
        grid.setBorders(true);
        grid.setStripeRows(true);

        GridSelectionModel gsm = grid.getSelectionModel();
        gsm.setSelectionMode(SelectionMode.SINGLE);
        grid.setSelectionModel(gsm);

        portletRestricao.removeAll();
        portletRestricao.add(grid);
        layout();

    }

    public void addParcelasAtrazo() {

        List<ColumnConfig> configs = new Vector();
        SummaryColumnConfig<Double> cli = new SummaryColumnConfig<Double>("cli_tx_nome", "Cliente", 230);
        SummaryColumnConfig<Double> parcela = new SummaryColumnConfig<Double>("ple_tx_parcela", "Parcela", 80);
        parcela.setSummaryRenderer(new SummaryRenderer() {
            public String render(Number value, Map<String, Number> data) {
                return "Sub-Total:";
            }
        });

        SummaryColumnConfig<Double> vencimento = new SummaryColumnConfig<Double>("ple_dt_vencimento", "Vencimento", 80);
        vencimento.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("ple_nr_valorparcela", "Valor", 80);
        valor.setAlignment(HorizontalAlignment.RIGHT);
        valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setSummaryType(SummaryType.SUM);
        valor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));

        configs.clear();
        configs.add(cli);
        configs.add(parcela);
        configs.add(vencimento);
        configs.add(valor);

        ColumnModel cm = new ColumnModel(configs);

        List<Ple_parcelaemprestimoTGWT> list = (List<Ple_parcelaemprestimoTGWT>) ple_parcelaemprestimoDAOGWT.getList().getModels();
        PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list);
        PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
        loader.setRemoteSort(true);

//        AggregationRowConfig<Emp_emprestimoTGWT> soma = new AggregationRowConfig<Emp_emprestimoTGWT>();
//        soma.setSummaryFormat("ple_nr_valorparcela", NumberFormat.getFormat("#,##0.00"));
//        soma.setSummaryType("ple_nr_valorparcela", SummaryType.SUM);
//        cm.addAggregationRow(soma);

        GroupingStore<Ple_parcelaemprestimoTGWT> store = new GroupingStore<Ple_parcelaemprestimoTGWT>(loader);
        store.add(list);
        store.groupBy("cli_tx_nome");

        PagingToolBar toolBarPage = new PagingToolBar(3);
        toolBarPage.setPageSize(15);
        toolBarPage.bind(loader);
        loader.load(0, 15);


        GroupSummaryView view = new GroupSummaryView();
        view.setForceFit(true);
        view.setShowGroupedColumn(false);

        Grid<Ple_parcelaemprestimoTGWT> grid = new Grid<Ple_parcelaemprestimoTGWT>(store, cm);
        grid.setBorders(true);
        grid.setView(view);
        grid.getView().setShowDirtyCells(false);
        grid.setStripeRows(true);

//        GridSelectionModel gsm = grid.getSelectionModel();
//        gsm.setSelectionMode(SelectionMode.SINGLE);
//        grid.setSelectionModel(gsm);
        ContentPanel cp = new ContentPanel(new FillLayout());
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);
        cp.setBottomComponent(toolBarPage);
        cp.add(grid);

        portletAtrazo.setFrame(true);
        portletAtrazo.removeAll();
        portletAtrazo.add(cp);
        layout();

    }

    public void addUltimosEmprestimos() {

        List<ColumnConfig> configs = new Vector();
        SummaryColumnConfig<Double> cli = new SummaryColumnConfig<Double>("cli_tx_nome", "Cliente", 230);
        SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("emp_nr_valor", "Valor", 80);
        valor.setAlignment(HorizontalAlignment.RIGHT);
        valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));

        configs.clear();
        configs.add(cli);
        configs.add(valor);
        ColumnModel cm = new ColumnModel(configs);
//        AggregationRowConfig<Emp_emprestimoTGWT> soma = new AggregationRowConfig<Emp_emprestimoTGWT>();
//        soma.setSummaryFormat("emp_nr_valor", NumberFormat.getFormat("#,##0.00"));
//        soma.setSummaryType("emp_nr_valor", SummaryType.SUM);
//        cm.addAggregationRow(soma);

        Grid<Emp_emprestimoTGWT> grid = new Grid<Emp_emprestimoTGWT>(emp_emprestimoDAOGWT.getList(), cm);
        grid.setBorders(true);
        GridSelectionModel gsm = grid.getSelectionModel();
        gsm.setSelectionMode(SelectionMode.SINGLE);
        grid.setSelectionModel(gsm);
        grid.setStripeRows(true);

        portletUtimosEmp.removeAll();
        portletUtimosEmp.add(grid);
        layout();
    }

    public void addPortletCTP() {

        List<ColumnConfig> configs = new Vector();
        SummaryColumnConfig<Double> fornec = new SummaryColumnConfig<Double>("for_tx_nome", "Fornecedor", 200);
        SummaryColumnConfig<Double> vencimento = new SummaryColumnConfig<Double>("ctp_dt_vencimento", "Vencimento", 65);
        SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("ctp_valor", "Valor", 80);
        valor.setAlignment(HorizontalAlignment.RIGHT);
        valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        SummaryColumnConfig<Double> parcela = new SummaryColumnConfig<Double>("ctp_tx_parcela", "Parcela", 50);

        configs.clear();
        configs.add(fornec);
        configs.add(parcela);
        configs.add(valor);
        ColumnModel cm = new ColumnModel(configs);
        AggregationRowConfig<Ctp_conta_pagarTGWT> soma = new AggregationRowConfig<Ctp_conta_pagarTGWT>();
        soma.setSummaryFormat("ctp_valor", NumberFormat.getFormat("#,##0.00"));
        soma.setSummaryType("ctp_valor", SummaryType.SUM);
        cm.addAggregationRow(soma);

        Grid<Ctp_conta_pagarTGWT> grid = new Grid<Ctp_conta_pagarTGWT>(ctp_conta_pagarDAOGWT.getList(), cm);
        grid.setBorders(true);
        GridSelectionModel gsm = grid.getSelectionModel();
        gsm.setSelectionMode(SelectionMode.SINGLE);
        grid.setSelectionModel(gsm);
        grid.setStripeRows(true);

        portletCtp.removeAll();
        portletCtp.add(grid);
        layout();
    }

    public void add11Mesalidade() {

        List<ColumnConfig> configs = new Vector();
        SummaryColumnConfig<Double> cli = new SummaryColumnConfig<Double>("cli_tx_nome", "Cliente", 230);
        SummaryColumnConfig<Double> parcela = new SummaryColumnConfig<Double>("ple_tx_parcela", "Parcela", 80);
        parcela.setSummaryRenderer(new SummaryRenderer() {
            public String render(Number value, Map<String, Number> data) {
                return "Sub-Total:";
            }
        });

        SummaryColumnConfig<Double> vencimento = new SummaryColumnConfig<Double>("ple_dt_vencimento", "Vencimento", 80);
        vencimento.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        SummaryColumnConfig<Double> valor = new SummaryColumnConfig<Double>("ple_nr_valorparcela", "Valor", 80);
        valor.setAlignment(HorizontalAlignment.RIGHT);
        valor.setNumberFormat(NumberFormat.getFormat("#,##0.00"));
        valor.setSummaryType(SummaryType.SUM);
        valor.setSummaryFormat(NumberFormat.getFormat("#,##0.00"));

        configs.clear();
        configs.add(cli);
        configs.add(parcela);
        configs.add(vencimento);
        configs.add(valor);

        ColumnModel cm = new ColumnModel(configs);

        AggregationRowConfig<Vw_parcelasTGWT> soma = new AggregationRowConfig<Vw_parcelasTGWT>();
        soma.setSummaryFormat("ple_nr_valorparcela", NumberFormat.getFormat("#,##0.00"));
        soma.setSummaryType("ple_nr_valorparcela", SummaryType.SUM);
        cm.addAggregationRow(soma);

        GroupingStore<Vw_parcelasTGWT> store = new GroupingStore<Vw_parcelasTGWT>();
        store.add((List<Vw_parcelasTGWT>) vw_parcelasDAOGWT.getList().getModels());
        store.groupBy("cli_tx_nome");

        GroupSummaryView view = new GroupSummaryView();
        view.setForceFit(true);
        view.setShowGroupedColumn(false);

        grid12Men = new Grid<Vw_parcelasTGWT>(store, cm);
        grid12Men.setBorders(true);
        grid12Men.setView(view);
        grid12Men.getView().setShowDirtyCells(false);
        grid12Men.setStripeRows(true);

        portlet11Mensalidades.setFrame(true);
        portlet11Mensalidades.removeAll();


        Button btn = new Button("Gerar Parcelas");
        Button btreflesh = new Button("Atualizar");
        ToolBar bar = new ToolBar();
        bar.setBorders(true);
        bar.setAlignment(HorizontalAlignment.CENTER);
//        bar.add(btn);


        ContentPanel cp = new ContentPanel(new FillLayout());
        cp.setHeaderVisible(false);
        cp.setBodyBorder(false);

        cp.setTopComponent(bar);
        portlet11Mensalidades.layout();

        btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                EasyAccessURL url = new EasyAccessURL(new Resposta());
                StringBuffer buffer = new StringBuffer();
                buffer.append(Constantes.URL + Ple_parcelaemprestimoDAOGWT.PAGE_INSERIR);
                buffer.append("?op=gerarNovasMensalidade");
                url.accessJSon(buffer.toString());
            }
        });


        btreflesh.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                refresh();
            }
        });

        cp.add(grid12Men);
        portlet11Mensalidades.add(cp);
        layout();
    }

    public void refresh() {
        vw_parcelasDAOGWT.consultarTodos12Mensalidade();
        Timer t = new Timer() {
            @Override
            public void run() {
                ListStore<Vw_parcelasTGWT> list = vw_parcelasDAOGWT.getList();
                if (list != null) {
                    grid12Men.getStore().removeAll();
                    grid12Men.getStore().add(list.getModels());
                    grid12Men.getView().refresh(true);
                }
            }
        };
        t.schedule(100);
    }

    private void configPanel(final ContentPanel panel) {
        panel.setCollapsible(true);
        panel.setAnimCollapse(false);
        panel.getHeader().addTool(new ToolButton("x-tool-gear"));
        panel.getHeader().addTool(new ToolButton("x-tool-close", new SelectionListener<IconButtonEvent>() {
            @Override
            public void componentSelected(IconButtonEvent ce) {
                panel.removeFromParent();
            }
        }));
    }

    public class Resposta implements IListenetResponse {

        public void read(JSONValue jsonValue) {
                    
//            if (jsonValue.toString().indexOf("sucesso") > -1) {
                box.close();
                refresh();
                box = MessageBox.alert("ATENÇÃO",jsonValue.toString(), null);
//            } else {
//                box = MessageBox.alert("ATENÇÃO", "Não foi possivel gerar as parcelas", null);
//            }
        }
    };
}
