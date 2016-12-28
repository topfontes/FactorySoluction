/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easynet.gwt.client.EasyPagingToolBar;
import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.i9factory.factory.dao.Cor_corretoraDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Emp_emprestimoDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cor_corretoraTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Emp_emprestimoTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marcos
 */
public class ComissaoCorretorGWT extends RelatorioBaseGWT {

    Cor_corretoraDAOGWT corDao = new Cor_corretoraDAOGWT();
    ComboBox<Cor_corretoraTGWT> cbCorretor = new ComboBox<Cor_corretoraTGWT>();
    Emp_emprestimoDAOGWT empDao = new Emp_emprestimoDAOGWT();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private NumberField percComissao = new NumberField();
    private NumberFormat format = NumberFormat.getFormat("#,##0.00");
    private RadioGroup rdgTipo = new RadioGroup();
    private Radio rdMensalidade = new Radio();
    private Radio rdEmprestimo = new Radio();
    private PagingToolBar pagingToolBar = new PagingToolBar(40);

    public ComissaoCorretorGWT() {
        corDao.consultarTodos();

        getCpREL().setBottomComponent(pagingToolBar);

        rdMensalidade.setBoxLabel("Mensalidades");
        rdMensalidade.setValue(true);
        rdEmprestimo.setBoxLabel("Emprestimos");
        rdgTipo.add(rdEmprestimo);
        rdgTipo.add(rdMensalidade);

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (corDao.getList() == null) {
                    schedule(500);
                } else {
                    addPeriodo();
                    addRadioGroup();
                    addComboCorretor();
                    getToolBarMaster().add(cbCorretor);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new LabelToolItem("Percentual Comissão:"));
                    percComissao.setWidth(50);
                    percComissao.setEmptyText("%");
                    getToolBarMaster().add(percComissao);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());

                    addBtnFiltrar();
                    addBtnExportar();
                    getCpREL().setLayout(new FillLayout());
                    getCpREL().layout();
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addComboCorretor() {
        cbCorretor.setStore(corDao.getList());
        cbCorretor.setDisplayField("cor_tx_nomefantasia");
        cbCorretor.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbCorretor.setWidth(250);
        layout();
    }

    @Override
    public void exportarPDF() {
        download(Constantes.URL + getURL() + TIPO_PDF);
    }

    @Override
    public void exportarXLS() {

        download(Constantes.URL + getURL() + TIPO_XLS);
    }

    public void addRadioGroup() {
        getToolBarMaster().add(rdgTipo);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
    }

    public String getURL() {
        String tipo = rdgTipo.getValue().getBoxLabel().equalsIgnoreCase("Mensalidades") ? "M" : "E";// M = mensalidades e E= seguros;
        String emprestimo = "&percComissao=" + percComissao.getValue().floatValue() + "&tipoFiltro=" + tipo;
        if (cbCorretor.getValue() != null) {
            emprestimo += "&emp_emprestimoT.cor_nr_id=" + cbCorretor.getValue().getCor_nr_id();
        }
        return "i9factory/factory/relatorios/comissao.jsp?op=imprimir&dtInicio=" + dtfDate.format(getDtInicio().getValue()) + "&dtFim=" + dtfDate.format(getDtFim().getValue()) + emprestimo;
    }

    @Override
    public void filtrar() {
        int cor_nr_id = 0;
        if (cbCorretor.getValue() != null) {
            cor_nr_id = cbCorretor.getValue().getCor_nr_id();
        }
        String tipo = rdgTipo.getValue().getBoxLabel().equalsIgnoreCase("Mensalidades") ? "M" : "E";// M = mensalidades e E = seguros;
        empDao.consultarComissaoCorretor(getDtInicio().getValue(), getDtFim().getValue(), cor_nr_id, percComissao.getValue().floatValue(), tipo);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Emp_emprestimoTGWT> list = empDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    getCpREL().removeAll();

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
                    loader.setRemoteSort(true);

                    GroupingStore<Emp_emprestimoTGWT> store = new GroupingStore<Emp_emprestimoTGWT>(loader);
                    store.add(list.getModels());
                    store.groupBy("cor_tx_nome");

                    
                    pagingToolBar.setPageSize(40);
                    pagingToolBar.bind(loader);
                    loader.load(0, 40);

                    ColumnModel cm = createColumn();

                    AggregationRowConfig<Emp_emprestimoTGWT> rowConfig = new AggregationRowConfig<Emp_emprestimoTGWT>();

                    rowConfig.setSummaryFormat("comissao", format);
                    rowConfig.setSummaryType("comissao", SummaryType.SUM);
                    cm.addAggregationRow(rowConfig);

                    GroupSummaryView view = new GroupSummaryView();
                    view.setShowGroupedColumn(false);
                    view.setForceFit(true);

                    Grid<Emp_emprestimoTGWT> grid = new Grid<Emp_emprestimoTGWT>(store, cm);
                    grid.setView(view);
                    grid.getView().setShowDirtyCells(false);
                    getCpREL().add(grid);

                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public ColumnModel createColumn() {

        configs.clear();

        SummaryColumnConfig column = null;

        column = new SummaryColumnConfig<Double>();
        column.setId("cor_tx_nome");
        column.setHeader("Corretor(a)");
        column.setHidden(true);
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Integer>();
        column.setId("cli_tx_nome");
        column.setHeader("Cliente");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setSummaryRenderer(new SummaryRenderer() {

            public String render(Number value, Map<String, Number> data) {
                return "Total por Corretor";
            }
        });
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("cli_tx_cpf");
        column.setHeader("CPF - cliente");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("emp_dt_emprestimo");
        column.setHeader("Dt. Emprestimo");
        column.setWidth(90);
        column.setDateTimeFormat(dtfDate);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("emp_nr_proposta");
        column.setHeader("Proposta");
        column.setNumberFormat(NumberFormat.getFormat("00000"));
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("emp_nr_valor_afin_liquido");
        column.setHeader("Valor");
        column.setNumberFormat(format);
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("perc");
        column.setHeader("Percentual");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setRenderer(new GridCellRenderer() {

            public Object render(ModelData model, String property, ColumnData config, int rowIndex, int colIndex, ListStore store, Grid grid) {
                return format.format(percComissao.getValue()) + "%";
            }
        });

        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("comissao");
        column.setHeader("Comissão");
        column.setWidth(70);

        //mudança da cor da coluna
        column.setRenderer(new GridCellRenderer<Emp_emprestimoTGWT>() {

            public String render(Emp_emprestimoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Emp_emprestimoTGWT> store, Grid<Emp_emprestimoTGWT> grid) {
                config.style = "background-color: #F1F2F4;";
                return format.format(model.getComissao());
            }
        });

        column.setSummaryFormat(format);
        column.setSummaryType(SummaryType.SUM);
        column.setAlignment(HorizontalAlignment.RIGHT);

        configs.add(column);

        ColumnModel cm = new ColumnModel(configs);
        return cm;

    }
}
//atualizado 03/11/2011 - marcos
