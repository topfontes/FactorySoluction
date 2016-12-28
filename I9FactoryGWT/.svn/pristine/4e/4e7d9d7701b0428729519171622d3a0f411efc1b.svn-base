/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.bco_banco;

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
public class Bco_bancoConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Bco_bancoDAOGWT bco_bancoDao = new Bco_bancoDAOGWT();

    public Bco_bancoConsultGWT() {
        getCpTop().setHeight(27);
        getToolBarMaster().setHeight(26);
        this.setHeaderVisible(false);

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Bco_bancoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Bco_bancoTGWT>>(currency);


        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("bco_tx_codigo");
        column.setHeader("Código");
        column.setWidth(60);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("bco_tx_nome");
        column.setHeader("Nome");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("bco_tx_telefone1");
        column.setHeader("Telefone 1");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("bco_tx_telefone2");
        column.setHeader("Telefone 2 ");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("bco_tx_nomecontato");
        column.setHeader("Contato");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);
        layout();

        load();
    }

    public void btnNovoAction(ButtonEvent be) {
        Bco_bancoInsertGWT bco_bancoInsertGWT = new Bco_bancoInsertGWT();
        bco_bancoInsertGWT.setBco_bancoConsult(this);
        bco_bancoInsertGWT.setModal(true);
        bco_bancoInsertGWT.setVisible(true);
    }

    private GridCellRenderer<Bco_bancoTGWT> getEditarRender() {
        return new GridCellRenderer<Bco_bancoTGWT>() {

            public Object render(final Bco_bancoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Bco_bancoTGWT> store, Grid<Bco_bancoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Bco_bancoUpdateDeleteGWT bco_bancoUpdateDeleteGWT = new Bco_bancoUpdateDeleteGWT();
                        bco_bancoUpdateDeleteGWT.setBco_bancoConsult(Bco_bancoConsultGWT.this);
                        bco_bancoUpdateDeleteGWT.load(model);
                        bco_bancoUpdateDeleteGWT.show();
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
        bco_bancoDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Bco_bancoTGWT> list = bco_bancoDao.getList();
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

                    ListStore<Bco_bancoTGWT> store = new ListStore<Bco_bancoTGWT>(loader);
                    store.add(list.getModels());
                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Bco_bancoTGWT> grid = new Grid<Bco_bancoTGWT>(store, cm);
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
