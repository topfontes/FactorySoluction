/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.tac_taxa_cartao;

import static br.com.easynet.gwt.client.CPBaseGWT.ICONS;
import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.i9factory.factory.dao.Tac_taxa_cartaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Bco_bancoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Car_cartaoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Tac_taxa_cartaoTGWT;
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
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoConsultaGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Tac_taxa_cartaoDAOGWT tac_taxa_cartaoDAOGWT = new Tac_taxa_cartaoDAOGWT();
    private Car_cartaoTGWT car_cartaoTGWT;
    private NumberFormat formatReal = NumberFormat.getFormat("#,##0.00");

    public Tac_taxa_cartaoConsultaGWT(Car_cartaoTGWT car_cartaoTGWT) {
        getCpTop().setHeight(27);
        getToolBarMaster().setHeight(26);
        this.car_cartaoTGWT = car_cartaoTGWT;
        this.setHeaderVisible(false);

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Bco_bancoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Bco_bancoTGWT>>(currency);

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("tac_tx_nome");
        column.setHeader("Nome");
        column.setWidth(150);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("tac_nr_taxa");
        column.setHeader("%taxa");
        column.setWidth(50);
        column.setNumberFormat(formatReal);
        column.setAlignment(Style.HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(Style.HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);
        layout();
        load();
    }

    private GridCellRenderer<Tac_taxa_cartaoTGWT> getEditarRender() {
        return new GridCellRenderer<Tac_taxa_cartaoTGWT>() {

            public Object render(final Tac_taxa_cartaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tac_taxa_cartaoTGWT> store, Grid<Tac_taxa_cartaoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Tac_taxa_cartaoUpdateDeleteGWT tac_taxa_cartaoUpdateDeleteGWT = new Tac_taxa_cartaoUpdateDeleteGWT();
                        tac_taxa_cartaoUpdateDeleteGWT.setConsultaGWT(Tac_taxa_cartaoConsultaGWT.this);
                        tac_taxa_cartaoUpdateDeleteGWT.load(model);
                        tac_taxa_cartaoUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    @Override
    public void load() {
        tac_taxa_cartaoDAOGWT.consult(car_cartaoTGWT);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Tac_taxa_cartaoTGWT> list = tac_taxa_cartaoDAOGWT.getList();
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

                    ListStore<Tac_taxa_cartaoTGWT> store = new ListStore<Tac_taxa_cartaoTGWT>(loader);
                    store.add(list.getModels());
                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Tac_taxa_cartaoTGWT> grid = new Grid<Tac_taxa_cartaoTGWT>(store, cm);
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
    @Override
    public void btnNovoAction(ButtonEvent be) {
        Tac_taxa_cartaoInsertGWT tac_taxa_cartaoInsertGWT = new Tac_taxa_cartaoInsertGWT(car_cartaoTGWT);
        tac_taxa_cartaoInsertGWT.setTac_taxa_cartaoConsultaGWT(Tac_taxa_cartaoConsultaGWT.this);
        tac_taxa_cartaoInsertGWT.show();
    }

    @Override
    public void btnAtualizarAction(ButtonEvent be) {
        super.btnAtualizarAction(be); //To change body of generated methods, choose Tools | Templates.
    }

}
