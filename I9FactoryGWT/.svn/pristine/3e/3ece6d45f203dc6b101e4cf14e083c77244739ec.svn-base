/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.eqp_equipe;

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
public class Eqp_equipeConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Eqp_equipeDAOGWT eqp_equipeDao = new Eqp_equipeDAOGWT();

    public Eqp_equipeConsultGWT() {

        //this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Eqp_equipeTGWT>> numberRenderer = new NumberCellRenderer<Grid<Eqp_equipeTGWT>>(currency);

        getToolBarMaster().setHeight(26);

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("eqp_tx_nome");
        column.setHeader("Equipe");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("eqp_tx_descricao");
        column.setHeader("Descrição");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cor_tx_nome");
        column.setHeader("Corretora");
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
        Eqp_equipeInsertGWT eqp_equipeInsertGWT = new Eqp_equipeInsertGWT();
        eqp_equipeInsertGWT.setEqp_equipeConsult(this);
        eqp_equipeInsertGWT.setModal(true);
        eqp_equipeInsertGWT.show();

    }

    private GridCellRenderer<Eqp_equipeTGWT> getEditarRender() {
        return new GridCellRenderer<Eqp_equipeTGWT>() {

            private boolean init;

            public Object render(final Eqp_equipeTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eqp_equipeTGWT> store, Grid<Eqp_equipeTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Eqp_equipeTGWT>>() {

                        public void handleEvent(GridEvent<Eqp_equipeTGWT> be) {
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
                        Eqp_equipeUpdateDeleteGWT eqp_equipeUpdateDeleteGWT = new Eqp_equipeUpdateDeleteGWT();
                        eqp_equipeUpdateDeleteGWT.setEqp_equipeConsult(Eqp_equipeConsultGWT.this);
                        eqp_equipeUpdateDeleteGWT.load(model);
                        eqp_equipeUpdateDeleteGWT.show();
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
        eqp_equipeDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Eqp_equipeTGWT> list = eqp_equipeDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    final ColumnModel cm = new ColumnModel(configs);
                    
                    GroupingStore<Eqp_equipeTGWT> store = new GroupingStore<Eqp_equipeTGWT>();

                    store.add(list.getModels());

                    store.groupBy("cor_tx_nome");

                    GroupingView view = new GroupingView();
                    view.setShowGroupedColumn(false);
                    view.setForceFit(true);

                    view.setGroupRenderer(new GridGroupRenderer() {

                        public String render(GroupColumnData data) {
                            String f = cm.getColumnById(data.field).getHeader();
                            String l = data.models.size() == 1 ? "Item" : "Items";
                            return f + ": " + data.group + " (" + data.models.size() + " " + l + ")";
                        }
                    });

                    Grid<Eqp_equipeTGWT> grid = new Grid<Eqp_equipeTGWT>(store, cm);
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
