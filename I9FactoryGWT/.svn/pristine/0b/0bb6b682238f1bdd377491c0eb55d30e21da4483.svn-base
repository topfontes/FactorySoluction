/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.tic_tipo_credito;



import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
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
import com.extjs.gxt.ui.client.store.ListStore;
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
public class Tic_tipo_creditoConsultGWT extends ConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Tic_tipo_creditoDAOGWT tic_tipo_creditoDao = new Tic_tipo_creditoDAOGWT();
    public Tic_tipo_creditoConsultGWT() {
        this.setHeaderVisible(false);
            this.setSize("500", "400");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Tic_tipo_creditoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Tic_tipo_creditoTGWT>>(currency);
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
            column.setId("tic_tx_nome");
            column.setHeader("Nome");
            column.setWidth(200);
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

    public void btnAtualizarAction(ButtonEvent be){
        super.btnAtualizarAction(be);
    }

    public void btnNovoAction(ButtonEvent be) {
        Tic_tipo_creditoInsertGWT tic_tipo_creditoInsertGWT = new Tic_tipo_creditoInsertGWT();
        tic_tipo_creditoInsertGWT.setTic_tipo_creditoConsult(this);
        tic_tipo_creditoInsertGWT.setModal(true);
        tic_tipo_creditoInsertGWT.show();

    }
    private GridCellRenderer<Tic_tipo_creditoTGWT> getEditarRender() {
        return new GridCellRenderer<Tic_tipo_creditoTGWT>() {


            public Object render(final Tic_tipo_creditoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tic_tipo_creditoTGWT> store, Grid<Tic_tipo_creditoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Tic_tipo_creditoUpdateDeleteGWT tic_tipo_creditoUpdateDeleteGWT = new Tic_tipo_creditoUpdateDeleteGWT();
                        tic_tipo_creditoUpdateDeleteGWT.setTic_tipo_creditoConsult(Tic_tipo_creditoConsultGWT.this);
                        tic_tipo_creditoUpdateDeleteGWT.load(model);
                        tic_tipo_creditoUpdateDeleteGWT.setVisible(true);
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
    tic_tipo_creditoDao.consultarTodos();
    Timer timer = new Timer() {
            public void run() {
                ListStore<Tic_tipo_creditoTGWT> list = tic_tipo_creditoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

        	    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Tic_tipo_creditoTGWT>> loader = new BasePagingLoader<PagingLoadResult<Tic_tipo_creditoTGWT>>(proxy);
        	    loader.setRemoteSort(true);

        	    getToolBarPage().setPageSize(20);
        	    getToolBarPage().bind(loader);
        	    loader.load(0, 20);
        	    ListStore<Tic_tipo_creditoTGWT> store = new ListStore<Tic_tipo_creditoTGWT>(loader);
        	    store.add(list.getModels());


                    Grid<Tic_tipo_creditoTGWT> grid = new Grid<Tic_tipo_creditoTGWT>(store, cm);
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

