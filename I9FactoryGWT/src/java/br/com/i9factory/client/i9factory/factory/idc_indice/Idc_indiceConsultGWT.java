/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.idc_indice;

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
public class Idc_indiceConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Idc_indiceDAOGWT idc_indiceDao = new Idc_indiceDAOGWT();

    public Idc_indiceConsultGWT() {

        getToolBarMaster().setHeight(26);
        this.setHeaderVisible(false);
        this.getCpTop().setHeight(27);
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.000");
        final NumberCellRenderer<Grid<Idc_indiceTGWT>> numberRenderer = new NumberCellRenderer<Grid<Idc_indiceTGWT>>(currency);
        /*
        GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
        public String render(Stock model, String property, ColumnData config, int rowIndex,
        int colIndex, ListStore<Stock> store) {
        double val = (Double) model.get(property);
        String style = val < 0 ? "red" : "green";
        return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
        }
        };
        GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
        public String render(Stock model, String property, ColumnData config, int rowIndex,
        int colIndex, ListStore<Stock> store) {
        return numberRenderer.render(null, property, model.get(property));
        }
        };
         */

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("idc_nr_diainicial");
        column.setHeader("Dia Inícial");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("idc_nr_diafinal");
        column.setHeader("Dia Final");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("idc_nr_qtdparcelas");
        column.setHeader("N. Parcelas");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("idc_nr_valor");
        column.setHeader("Indice");
        column.setWidth(100);
        column.setRenderer(new GridCellRenderer<Idc_indiceTGWT>() {

            public String render(Idc_indiceTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Idc_indiceTGWT> store, Grid<Idc_indiceTGWT> grid) {
                NumberFormat format = NumberFormat.getFormat("0.00000");
                return "<span style='color:green'>" + format.format(model.getIdc_nr_valor()) + "% </span>";
            }
        });
        column.setAlignment(HorizontalAlignment.RIGHT);
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
        Idc_indiceInsertGWT idc_indiceInsertGWT = new Idc_indiceInsertGWT();
        idc_indiceInsertGWT.setIdc_indiceConsult(this);
        idc_indiceInsertGWT.setModal(true);
        idc_indiceInsertGWT.show();

    }

    private GridCellRenderer<Idc_indiceTGWT> getEditarRender() {
        return new GridCellRenderer<Idc_indiceTGWT>() {

            private boolean init;

            public Object render(final Idc_indiceTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Idc_indiceTGWT> store, Grid<Idc_indiceTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Idc_indiceTGWT>>() {

                        public void handleEvent(GridEvent<Idc_indiceTGWT> be) {
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
                        Idc_indiceUpdateDeleteGWT idc_indiceUpdateDeleteGWT = new Idc_indiceUpdateDeleteGWT();
                        idc_indiceUpdateDeleteGWT.setIdc_indiceConsult(Idc_indiceConsultGWT.this);
                        idc_indiceUpdateDeleteGWT.load(model);
                        idc_indiceUpdateDeleteGWT.show();
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
        idc_indiceDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Idc_indiceTGWT> list = idc_indiceDao.getList();
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

                    ListStore<Idc_indiceTGWT> store = new ListStore<Idc_indiceTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Idc_indiceTGWT> grid = new Grid<Idc_indiceTGWT>(list, cm);
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
