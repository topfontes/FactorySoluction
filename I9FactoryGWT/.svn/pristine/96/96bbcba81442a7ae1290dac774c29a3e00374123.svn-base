/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.age_agenciador;

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
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Age_agenciadorConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Age_agenciadorDAOGWT age_agenciadorDao = new Age_agenciadorDAOGWT();
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");

    public Age_agenciadorConsultGWT() {

        getToolBarMaster().setHeight(26);
        this.setSize("500", "400");
        this.setHeaderVisible(false);
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("#,##0.00");
        final NumberCellRenderer<Grid<Age_agenciadorTGWT>> numberRenderer = new NumberCellRenderer<Grid<Age_agenciadorTGWT>>(currency);
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
        column.setId("eqp_tx_nome");
        column.setHeader("Equipe");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("age_tx_nome");
        column.setHeader("Nome");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("age_tx_cpf");
        column.setHeader("CPF");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("age_dt_cadastro");
        column.setHeader("Dt. Cadastro");
        column.setDateTimeFormat(dtfDate);
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("age_tx_telefone2_1");
        column.setHeader("Telefone");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("age_tx_celular");
        column.setHeader("Celular");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("age_nr_taxaemprestimo");
        column.setHeader("Taxa Imprestimo");
        column.setNumberFormat(number);
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("age_nr_taxamensalidade");
        column.setHeader("Taxa Mensalidade");
        column.setNumberFormat(number);
        column.setWidth(100);
        
//        column.setRenderer(new GridCellRenderer<Age_agenciadorTGWT>() {
//
//            public String render(Age_agenciadorTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Age_agenciadorTGWT> store, Grid<Age_agenciadorTGWT> grid) {
//                NumberFormat format = NumberFormat.getFormat("0.00");
//                return "<span style='color:green'>" + format.format(model.getAge_nr_taxamensalidade()) + "% </span>";
//            }
//        });
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
        Age_agenciadorInsertGWT age_agenciadorInsertGWT = new Age_agenciadorInsertGWT();
        age_agenciadorInsertGWT.setAge_agenciadorConsult(this);
        age_agenciadorInsertGWT.setModal(true);
        age_agenciadorInsertGWT.show();

    }

    private GridCellRenderer<Age_agenciadorTGWT> getEditarRender() {
        return new GridCellRenderer<Age_agenciadorTGWT>() {

            private boolean init;

            public Object render(final Age_agenciadorTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Age_agenciadorTGWT> store, Grid<Age_agenciadorTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Age_agenciadorTGWT>>() {

                        public void handleEvent(GridEvent<Age_agenciadorTGWT> be) {
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
                        Age_agenciadorUpdateDeleteGWT age_agenciadorUpdateDeleteGWT = new Age_agenciadorUpdateDeleteGWT();
                        age_agenciadorUpdateDeleteGWT.setAge_agenciadorConsult(Age_agenciadorConsultGWT.this);
                        age_agenciadorUpdateDeleteGWT.load(model);
                        age_agenciadorUpdateDeleteGWT.show();
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
        age_agenciadorDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Age_agenciadorTGWT> list = age_agenciadorDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }
                    final ColumnModel cm = new ColumnModel(configs);
                    GroupingStore<Age_agenciadorTGWT> store = new GroupingStore<Age_agenciadorTGWT>();
                    store.add(list.getModels());
                    store.groupBy("eqp_tx_nome");

                    GroupingView view = new GroupingView();
                    view.setShowGroupedColumn(false);
                    view.setForceFit(true);

//                    view.setGroupRenderer(new GridGroupRenderer() {
//
//                        public String render(GroupColumnData data) {
//                            String f = cm.getColumnById(data.field).getHeader();
//                            String l = data.models.size() == 1 ? "Item" : "Items";
//                            return f + ": " + data.group + " (" + data.models.size() + " " + l + ")";
//                        }
//                    });

                    Grid<Age_agenciadorTGWT> grid = new Grid<Age_agenciadorTGWT>(store, cm);
                    grid.setLoadMask(true);
                    grid.setView(view);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }
}
