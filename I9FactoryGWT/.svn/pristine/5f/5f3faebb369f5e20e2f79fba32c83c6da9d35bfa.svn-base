/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.arb_arquivobanco;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9factory.client.i9factory.factory.retorno.RetornoInsertGWT;

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
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
//import com.google.gwt.dev.Link;
import com.google.gwt.dom.client.LinkElement;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Arb_arquivobancoConsultGWT extends CPConsultarBaseGWT {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Arb_arquivobancoDAOGWT arb_arquivobancoDao = new Arb_arquivobancoDAOGWT();

    public Arb_arquivobancoConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Arb_arquivobancoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Arb_arquivobancoTGWT>>(currency);
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

        getBtnNovoSuper().setText("Registrar Arq. Retorno");
        getBtnNovoSuper().setTitle("Inserir o arquivo de retorno dos bancos no sistema.");
        ColumnConfig column = null;

//        column = new ColumnConfig();
//        column.setId("arb_nr_id");
//        column.setHeader("Download");
//        column.setWidth(150);
//        column.setRenderer(getDownloadRender());
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);

        column = new ColumnConfig();
        column.setId("arb_nr_seq");
        column.setHeader("Sequencial");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("arb_dt_data");
        column.setHeader("Data");
        column.setWidth(200);
        column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("arb_tx_tipo");
        column.setHeader("Tipo");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);



//        column = new ColumnConfig();
//        column.setId("colEditar");
//        column.setWidth(30);
//        column.setAlignment(HorizontalAlignment.CENTER);
//        column.setRenderer(getEditarRender());
//        configs.add(column);

        load();

    }

    public void btnNovoAction(ButtonEvent be) {
        RetornoInsertGWT retornoInsertGWT = new RetornoInsertGWT();
        retornoInsertGWT.setModal(true);
        retornoInsertGWT.setArb_arquivobancoConsultGWT(this);
        retornoInsertGWT.setVisible(true);
        //Arb_arquivobancoInsertGWT arb_arquivobancoInsertGWT = new Arb_arquivobancoInsertGWT();
        //arb_arquivobancoInsertGWT.setArb_arquivobancoConsult(this);
        //arb_arquivobancoInsertGWT.setModal(true);
        //arb_arquivobancoInsertGWT.show();

    }

    public native static void downloadArquivo()/*-{
            return window.event.clientX;
    }-*/;

    private GridCellRenderer<Arb_arquivobancoTGWT> getDownloadRender() {
        return new GridCellRenderer<Arb_arquivobancoTGWT>() {

            public Object render(final Arb_arquivobancoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Arb_arquivobancoTGWT> store, Grid<Arb_arquivobancoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {

                        Window.open(Constantes.URL + arb_arquivobancoDao.PAGE_ALTERAR_EXCLUIR+"?op=downloadImage&arb_arquivobancoT.arb_nr_id=" + model.getArb_nr_id(), "download" + model.getArb_nr_seq(), "status=no,scrollbars=no,location=no,toolbar=no,menubar=no");
//                        Arb_arquivobancoUpdateDeleteGWT arb_arquivobancoUpdateDeleteGWT = new Arb_arquivobancoUpdateDeleteGWT();
//                        arb_arquivobancoUpdateDeleteGWT.setArb_arquivobancoConsult(Arb_arquivobancoConsultGWT.this);
//                        arb_arquivobancoUpdateDeleteGWT.load(model);
//                        arb_arquivobancoUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Download arquivo.");
                b.setIcon(ICONS.download());
                b.setId("btnDownload");

                return b;
            }
        };
    }

    private GridCellRenderer<Arb_arquivobancoTGWT> getEditarRender() {
        return new GridCellRenderer<Arb_arquivobancoTGWT>() {

            public Object render(final Arb_arquivobancoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Arb_arquivobancoTGWT> store, Grid<Arb_arquivobancoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Arb_arquivobancoUpdateDeleteGWT arb_arquivobancoUpdateDeleteGWT = new Arb_arquivobancoUpdateDeleteGWT();
                        arb_arquivobancoUpdateDeleteGWT.setArb_arquivobancoConsult(Arb_arquivobancoConsultGWT.this);
                        arb_arquivobancoUpdateDeleteGWT.load(model);
                        arb_arquivobancoUpdateDeleteGWT.setVisible(true);
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
        arb_arquivobancoDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Arb_arquivobancoTGWT> list = arb_arquivobancoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {

                    getCpMaster().removeAll();

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
                    loader.setRemoteSort(true);

                    GroupingStore<Arb_arquivobancoTGWT> store = new GroupingStore<Arb_arquivobancoTGWT>(loader);
                    store.add(list.getModels());
                    store.groupBy("arb_tx_tipo");

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);


                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Arb_arquivobancoTGWT> grid = new Grid<Arb_arquivobancoTGWT>(store, cm);
                    grid.setLoadMask(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    grid.getView().setEmptyText("Não existe itens");

                    GroupingView view = new GroupingView();
                    view.setForceFit(true);
                    view.setShowGroupedColumn(false);
                    
                    grid.setView(view);
                    grid.getView().setShowDirtyCells(false);
                    grid.setStripeRows(true);
                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }
}
