/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.cco_contacorrente;

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
public class Cco_contacorrenteConsultGWT extends ConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Cco_contacorrenteDAOGWT cco_contacorrenteDao = new Cco_contacorrenteDAOGWT();
    private Cli_clienteTGWT cli_clienteTGWT;
    private Org_orgaoTGWT org_orgaoTGWT;

    public Cco_contacorrenteConsultGWT(Cli_clienteTGWT cli_clienteTGWT, Org_orgaoTGWT org_orgaoTGWT) {
        this.cli_clienteTGWT = cli_clienteTGWT;
        this.org_orgaoTGWT = org_orgaoTGWT;
        
        getToolBarMaster().setHeight(26);
        getCpMaster().setHeaderVisible(false);
        this.setSize("500", "200");
        this.setHeading("Consulta Conta Correte - " + cli_clienteTGWT.getCli_tx_nome()+", Orgão "+org_orgaoTGWT.getOrg_tx_nomefantasia());

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("cco_nr_id");
        column.setHeader("Código");
        column.setHidden(true);
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("bco_tx_nome");
        column.setHeader("Banco");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cco_tx_nragencia");
        column.setHeader("N. Agência");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cco_tx_nrcontacorrente");
        column.setHeader("N. Conta Corrente");
        column.setWidth(115);
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
        Cco_contacorrenteInsertGWT cco_contacorrenteInsertGWT = new Cco_contacorrenteInsertGWT(cli_clienteTGWT,org_orgaoTGWT);
        cco_contacorrenteInsertGWT.setCco_contacorrenteConsult(this);
        cco_contacorrenteInsertGWT.setModal(true);
        cco_contacorrenteInsertGWT.show();

    }

    private GridCellRenderer<Cco_contacorrenteTGWT> getEditarRender() {
        return new GridCellRenderer<Cco_contacorrenteTGWT>() {

            private boolean init;

            public Object render(final Cco_contacorrenteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Cco_contacorrenteTGWT> store, Grid<Cco_contacorrenteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cco_contacorrenteTGWT>>() {

                        public void handleEvent(GridEvent<Cco_contacorrenteTGWT> be) {
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
                        Cco_contacorrenteUpdateDeleteGWT cco_contacorrenteUpdateDeleteGWT = new Cco_contacorrenteUpdateDeleteGWT(cli_clienteTGWT,org_orgaoTGWT);
                        cco_contacorrenteUpdateDeleteGWT.setCco_contacorrenteConsult(Cco_contacorrenteConsultGWT.this);
                        cco_contacorrenteUpdateDeleteGWT.load(model);
                        cco_contacorrenteUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());
                return b;
            }
        };
    }

    public void load() {
        cco_contacorrenteDao.consultarTodos(cli_clienteTGWT,org_orgaoTGWT);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Cco_contacorrenteTGWT> list = cco_contacorrenteDao.getList();
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

                    ListStore<Cco_contacorrenteTGWT> store = new ListStore<Cco_contacorrenteTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Cco_contacorrenteTGWT> grid = new Grid<Cco_contacorrenteTGWT>(store, cm);
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
