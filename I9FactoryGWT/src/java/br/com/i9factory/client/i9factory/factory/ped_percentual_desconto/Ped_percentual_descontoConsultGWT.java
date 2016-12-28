/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.ped_percentual_desconto;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
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
public class Ped_percentual_descontoConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Ped_percentual_descontoDAOGWT ped_percentual_descontoDao = new Ped_percentual_descontoDAOGWT();

    public Ped_percentual_descontoConsultGWT() {

        this.setHeaderVisible(false);
        
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Ped_percentual_descontoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ped_percentual_descontoTGWT>>(currency);

        ColumnConfig column = null;


        column = new ColumnConfig();
        column.setId("ped_nr_parcela");
        column.setHeader("Número de Parcelas");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ped_nr_desconto");
        column.setHeader("% Descontto");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("colEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        load();
    }

    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Ped_percentual_descontoInsertGWT ped_percentual_descontoInsertGWT = new Ped_percentual_descontoInsertGWT();
        ped_percentual_descontoInsertGWT.setPed_percentual_descontoConsult(this);
        ped_percentual_descontoInsertGWT.setModal(true);
        ped_percentual_descontoInsertGWT.show();

    }

    private GridCellRenderer<Ped_percentual_descontoTGWT> getEditarRender() {
        return new GridCellRenderer<Ped_percentual_descontoTGWT>() {

            public Object render(final Ped_percentual_descontoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Ped_percentual_descontoTGWT> store, Grid<Ped_percentual_descontoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Ped_percentual_descontoUpdateDeleteGWT ped_percentual_descontoUpdateDeleteGWT = new Ped_percentual_descontoUpdateDeleteGWT();
                        ped_percentual_descontoUpdateDeleteGWT.setPed_percentual_descontoConsult(Ped_percentual_descontoConsultGWT.this);
                        ped_percentual_descontoUpdateDeleteGWT.load(model);
                        ped_percentual_descontoUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());
                b.setId("btnEditar");

                return b;
            }
        };
    }

    public void load() {
        ped_percentual_descontoDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Ped_percentual_descontoTGWT> list = ped_percentual_descontoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Ped_percentual_descontoTGWT>> loader = new BasePagingLoader<PagingLoadResult<Ped_percentual_descontoTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);
                    ListStore<Ped_percentual_descontoTGWT> store = new ListStore<Ped_percentual_descontoTGWT>(loader);
                    store.add(list.getModels());


                    Grid<Ped_percentual_descontoTGWT> grid = new Grid<Ped_percentual_descontoTGWT>(store, cm);
                    grid.setId("grid");
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
