/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.par_parametro;

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
public class Par_parametroConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Par_parametroDAOGWT par_parametroDao = new Par_parametroDAOGWT();

    public Par_parametroConsultGWT() {

        setHeaderVisible(false);
        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Par_parametroTGWT>> numberRenderer = new NumberCellRenderer<Grid<Par_parametroTGWT>>(currency);
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
        column.setId("par_tx_nome");
        column.setHeader("Nome");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("par_tx_valor");
        column.setHeader("Valor");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

//	    column = new ColumnConfig();
//            column.setId("par_tx_descricao");
//            column.setHeader("Par_tx_descricao");
//            column.setWidth(200);
//            column.setAlignment(HorizontalAlignment.LEFT);
//            configs.add(column);


        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);
        load();
    }

    public void btnNovoAction(ButtonEvent be) {
        Par_parametroInsertGWT par_parametroInsertGWT = new Par_parametroInsertGWT();
        par_parametroInsertGWT.setPar_parametroConsult(this);
        par_parametroInsertGWT.setModal(true);
        par_parametroInsertGWT.setVisible(true);
    }

    private GridCellRenderer<Par_parametroTGWT> getEditarRender() {
        return new GridCellRenderer<Par_parametroTGWT>() {

            public Object render(final Par_parametroTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Par_parametroTGWT> store, Grid<Par_parametroTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Par_parametroUpdateDeleteGWT par_parametroUpdateDeleteGWT = new Par_parametroUpdateDeleteGWT();
                        par_parametroUpdateDeleteGWT.setPar_parametroConsult(Par_parametroConsultGWT.this);
                        par_parametroUpdateDeleteGWT.load(model);
                        par_parametroUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados dos parametros.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    public void load() {
        par_parametroDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Par_parametroTGWT> list = par_parametroDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Par_parametroTGWT> grid = new Grid<Par_parametroTGWT>(list, cm);
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
