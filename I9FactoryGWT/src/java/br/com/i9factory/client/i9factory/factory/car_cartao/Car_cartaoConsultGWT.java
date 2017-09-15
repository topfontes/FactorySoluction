/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.car_cartao;

import static br.com.easynet.gwt.client.CPBaseGWT.ICONS;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.i9factory.factory.bco_banco.Bco_bancoConsultGWT;
import br.com.i9factory.client.i9factory.factory.bco_banco.Bco_bancoUpdateDeleteGWT;
import br.com.i9factory.client.i9factory.factory.dao.Car_cartaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.CarteiraGWT;
import br.com.i9factory.client.i9factory.factory.tac_taxa_cartao.Tac_taxa_cartaoConsultaGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Bco_bancoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Car_cartaoTGWT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Car_cartaoConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Car_cartaoDAOGWT car_cartaoDAOGWT = new Car_cartaoDAOGWT();

    public Car_cartaoConsultGWT() {
        getCpTop().setHeight(27);
        getToolBarMaster().setHeight(26);
        this.setHeaderVisible(false);

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Bco_bancoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Bco_bancoTGWT>>(currency);

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("car_tx_nome");
        column.setHeader("Nome");
        column.setWidth(300);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(Style.HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);
        layout();
        
        column = new ColumnConfig();
        column.setId("taxas");
        column.setWidth(30);
        column.setAlignment(Style.HorizontalAlignment.CENTER);
        column.setRenderer(getTaxaRender());
        configs.add(column);
        layout();

        load();
    }

    private GridCellRenderer<Car_cartaoTGWT> getTaxaRender() {
        return new GridCellRenderer<Car_cartaoTGWT>() {

            public Object render(final Car_cartaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Car_cartaoTGWT> store, Grid<Car_cartaoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Tac_taxa_cartaoConsultaGWT consultaGWT = new Tac_taxa_cartaoConsultaGWT(model);
                        Window w = new Window();
                        w.setHeading(model.getCar_tx_nome());
                        w.setLayout(new FillLayout());
                        w.setSize(300, 400);
                        w.add(consultaGWT);
                        w.show();
                        
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Taxas");
                b.setIcon(ICONS.connect());

                return b;
            }
        };
    }
    private GridCellRenderer<Car_cartaoTGWT> getEditarRender() {
        return new GridCellRenderer<Car_cartaoTGWT>() {

            public Object render(final Car_cartaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Car_cartaoTGWT> store, Grid<Car_cartaoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Car_cartaoUpdateDeleteGWT car_cartaoUpdateDeleteGWT = new Car_cartaoUpdateDeleteGWT();
                        car_cartaoUpdateDeleteGWT.setCar_cartaoConsultGWT(Car_cartaoConsultGWT.this);
                        car_cartaoUpdateDeleteGWT.load(model);
                        car_cartaoUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    @Override
    public void btnNovoAction(ButtonEvent be) {
        Car_cartaoInsertGWT car_cartaoInsertGWT = new Car_cartaoInsertGWT();
        car_cartaoInsertGWT.setCar_cartaoConsultGWT(Car_cartaoConsultGWT.this);
        car_cartaoInsertGWT.show();
    }

    @Override
    public void load() {
        car_cartaoDAOGWT.consult();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Car_cartaoTGWT> list = car_cartaoDAOGWT.getList();
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

                    ListStore<Car_cartaoTGWT> store = new ListStore<Car_cartaoTGWT>(loader);
                    store.add(list.getModels());
                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Car_cartaoTGWT> grid = new Grid<Car_cartaoTGWT>(store, cm);
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(Style.SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }

}
