/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.dep_dependente;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Dep_dependenteConsultGWT extends ConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Dep_dependenteDAOGWT dep_dependenteDao = new Dep_dependenteDAOGWT();
    private Cli_clienteTGWT cli_clienteTGWT;

    public Dep_dependenteConsultGWT(Cli_clienteTGWT cli_clienteTGWT) {

        getToolBarMaster().setHeight(26);

        this.cli_clienteTGWT = cli_clienteTGWT;
        this.setHeading("Consulta Dependentes - " + cli_clienteTGWT.getCli_tx_nome());

        this.setSize(550, 300);
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Dep_dependenteTGWT>> numberRenderer = new NumberCellRenderer<Grid<Dep_dependenteTGWT>>(currency);

        ColumnConfig column = null;

        column = new ColumnConfig();

        column = new ColumnConfig();
        column.setId("dep_tx_nome");
        column.setHeader("Nome");
        column.setWidth(250);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("dep_dt_nascimento");
        column.setHeader("Dt. Nascimento");
        column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("dep_tx_grauparentesco");
        column.setHeader("Parentesco");
        column.setRenderer(getParentescoRender());
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        load();

    }

    public void btnNovoAction(ButtonEvent be) {
        Dep_dependenteInsertGWT dep_dependenteInsertGWT = new Dep_dependenteInsertGWT(cli_clienteTGWT);
        dep_dependenteInsertGWT.setDep_dependenteConsult(this);
        dep_dependenteInsertGWT.setModal(true);
        dep_dependenteInsertGWT.show();

    }

    private GridCellRenderer<Dep_dependenteTGWT> getEditarRender() {
        return new GridCellRenderer<Dep_dependenteTGWT>() {

            private boolean init;

            public Object render(final Dep_dependenteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Dep_dependenteTGWT> store, Grid<Dep_dependenteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Dep_dependenteTGWT>>() {

                        public void handleEvent(GridEvent<Dep_dependenteTGWT> be) {
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
                        Dep_dependenteUpdateDeleteGWT dep_dependenteUpdateDeleteGWT = new Dep_dependenteUpdateDeleteGWT(cli_clienteTGWT);
                        dep_dependenteUpdateDeleteGWT.setDep_dependenteConsult(Dep_dependenteConsultGWT.this);
                        dep_dependenteUpdateDeleteGWT.load(model);
                        dep_dependenteUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());
                return b;
            }
        };
    }

    private GridCellRenderer<Dep_dependenteTGWT> getParentescoRender() {
        return new GridCellRenderer<Dep_dependenteTGWT>() {

            private boolean init;

            public Object render(final Dep_dependenteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Dep_dependenteTGWT> store, Grid<Dep_dependenteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Dep_dependenteTGWT>>() {

                        public void handleEvent(GridEvent<Dep_dependenteTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                LabelField parentenco = new LabelField();
                if (model.getDep_tx_grauparentesco().equalsIgnoreCase("N")) {
                    parentenco.setText("Nenhum");
                } else if (model.getDep_tx_grauparentesco().equalsIgnoreCase("P")) {
                    parentenco.setText("Pai/Mãe");
                } else if (model.getDep_tx_grauparentesco().equalsIgnoreCase("I")) {
                    parentenco.setText("irmão(ã)");
                } else if (model.getDep_tx_grauparentesco().equalsIgnoreCase("F")) {
                    parentenco.setText("Filho(a)");
                } else if (model.getDep_tx_grauparentesco().equalsIgnoreCase("E")) {
                    parentenco.setText("Esposo(a)");
                } else {
                    parentenco.setText("Outros");
                }
                return parentenco;
            }
        };
    }

    public void load() {
        dep_dependenteDao.consultarTodos(cli_clienteTGWT);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Dep_dependenteTGWT> list = dep_dependenteDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Dep_dependenteTGWT> store = new ListStore<Dep_dependenteTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Dep_dependenteTGWT> grid = new Grid<Dep_dependenteTGWT>(store, cm);
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the cli_clienteTGWT
     */
    public Cli_clienteTGWT getCli_clienteTGWT() {
        return cli_clienteTGWT;
    }

    /**
     * @param cli_clienteTGWT the cli_clienteTGWT to set
     */
    public void setCli_clienteTGWT(Cli_clienteTGWT cli_clienteTGWT) {
        this.cli_clienteTGWT = cli_clienteTGWT;
    }
}
