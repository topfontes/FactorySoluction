/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.tid_tipo_despesa;

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
public class Tid_tipo_despesaConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Tid_tipo_despesaDAOGWT tid_tipo_despesaDao = new Tid_tipo_despesaDAOGWT();

    public Tid_tipo_despesaConsultGWT() {

        //this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Tid_tipo_despesaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Tid_tipo_despesaTGWT>>(currency);

        getToolBarMaster().setHeight(26);
        this.setHeaderVisible(false);


        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("tid_tx_nome");
        column.setHeader("Despesa");
        column.setWidth(300);
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
        Tid_tipo_despesaInsertGWT tid_tipo_despesaInsertGWT = new Tid_tipo_despesaInsertGWT();
        tid_tipo_despesaInsertGWT.setTid_tipo_despesaConsult(this);
        tid_tipo_despesaInsertGWT.setModal(true);
        tid_tipo_despesaInsertGWT.show();

    }

    private GridCellRenderer<Tid_tipo_despesaTGWT> getEditarRender() {
        return new GridCellRenderer<Tid_tipo_despesaTGWT>() {

            private boolean init;

            public Object render(final Tid_tipo_despesaTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tid_tipo_despesaTGWT> store, Grid<Tid_tipo_despesaTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Tid_tipo_despesaTGWT>>() {

                        public void handleEvent(GridEvent<Tid_tipo_despesaTGWT> be) {
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
                        Tid_tipo_despesaUpdateDeleteGWT tid_tipo_despesaUpdateDeleteGWT = new Tid_tipo_despesaUpdateDeleteGWT();
                        tid_tipo_despesaUpdateDeleteGWT.setTid_tipo_despesaConsult(Tid_tipo_despesaConsultGWT.this);
                        tid_tipo_despesaUpdateDeleteGWT.load(model);
                        tid_tipo_despesaUpdateDeleteGWT.show();
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
        tid_tipo_despesaDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Tid_tipo_despesaTGWT> list = tid_tipo_despesaDao.getList();
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

                    ListStore<Tid_tipo_despesaTGWT> store = new ListStore<Tid_tipo_despesaTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Tid_tipo_despesaTGWT> grid = new Grid<Tid_tipo_despesaTGWT>(store, cm);
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
