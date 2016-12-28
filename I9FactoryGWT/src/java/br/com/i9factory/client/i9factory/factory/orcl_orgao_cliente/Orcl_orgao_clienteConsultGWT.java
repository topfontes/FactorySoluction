/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.orcl_orgao_cliente;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9factory.client.i9factory.factory.cco_contacorrente.Cco_contacorrenteConsultGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
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
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Orcl_orgao_clienteConsultGWT extends ConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Orcl_orgao_clienteDAOGWT orcl_orgao_clienteDao = new Orcl_orgao_clienteDAOGWT();
    private Cli_clienteTGWT cli_clienteTGWT;

    public Orcl_orgao_clienteConsultGWT(Cli_clienteTGWT cli_clienteTGWT) {
        this.cli_clienteTGWT = cli_clienteTGWT;
        this.setHeading("Consulta Orgãos Cliente - " + cli_clienteTGWT.getCli_tx_nome());

        getToolBarMaster().setHeight(26);
        this.setSize(400, 200);
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Orcl_orgao_clienteTGWT>> numberRenderer = new NumberCellRenderer<Grid<Orcl_orgao_clienteTGWT>>(currency);

        ColumnConfig column = null;

        column = new ColumnConfig();
        column = new ColumnConfig();
        column.setId("orgao");
        column.setHeader("Nome");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgCC");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getContaCorrRender());
        configs.add(column);

        load();

    }

    public void btnNovoAction(ButtonEvent be) {
        Orcl_orgao_clienteInsertGWT orcl_orgao_clienteInsertGWT = new Orcl_orgao_clienteInsertGWT(cli_clienteTGWT);
        orcl_orgao_clienteInsertGWT.setOrcl_orgao_clienteConsult(this);
        orcl_orgao_clienteInsertGWT.setModal(true);
        orcl_orgao_clienteInsertGWT.show();
    }

    private GridCellRenderer<Orcl_orgao_clienteTGWT> getEditarRender() {
        return new GridCellRenderer<Orcl_orgao_clienteTGWT>() {

            private boolean init;

            public Object render(final Orcl_orgao_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Orcl_orgao_clienteTGWT> store, Grid<Orcl_orgao_clienteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Orcl_orgao_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Orcl_orgao_clienteTGWT> be) {
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
                        Orcl_orgao_clienteUpdateDeleteGWT orcl_orgao_clienteUpdateDeleteGWT = new Orcl_orgao_clienteUpdateDeleteGWT(cli_clienteTGWT);
                        orcl_orgao_clienteUpdateDeleteGWT.setOrcl_orgao_clienteConsult(Orcl_orgao_clienteConsultGWT.this);
                        orcl_orgao_clienteUpdateDeleteGWT.load(model);
                        orcl_orgao_clienteUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Orcl_orgao_clienteTGWT> getContaCorrRender() {
        return new GridCellRenderer<Orcl_orgao_clienteTGWT>() {

            private boolean init;

            public Object render(final Orcl_orgao_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Orcl_orgao_clienteTGWT> store, Grid<Orcl_orgao_clienteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Orcl_orgao_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Orcl_orgao_clienteTGWT> be) {
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
                        Org_orgaoTGWT org_orgaoTGWT = new Org_orgaoTGWT();
                        org_orgaoTGWT.setOrg_nr_id(model.getOrg_nr_id());
                        org_orgaoTGWT.setOrg_tx_nomefantasia(model.getOrgao());
                        Cco_contacorrenteConsultGWT cco_contacorrenteConsultGWT = new Cco_contacorrenteConsultGWT(cli_clienteTGWT, org_orgaoTGWT);
                        cco_contacorrenteConsultGWT.setModal(true);
                        cco_contacorrenteConsultGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Conta Corrente");
                b.setIcon(ICONS.add32());

                return b;
            }
        };
    }


    public void load() {
        orcl_orgao_clienteDao.consultarTodos(cli_clienteTGWT);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Orcl_orgao_clienteTGWT> list = orcl_orgao_clienteDao.getList();
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

                    ListStore<Orcl_orgao_clienteTGWT> store = new ListStore<Orcl_orgao_clienteTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);


                    Grid<Orcl_orgao_clienteTGWT> grid = new Grid<Orcl_orgao_clienteTGWT>(store, cm);
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
}
