/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.tmp_tipomensalidade;

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
public class Tmp_tipomensalidadeConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Tmp_tipomensalidadeDAOGWT tmp_tipomensalidadeDao = new Tmp_tipomensalidadeDAOGWT();
    public Tmp_tipomensalidadeConsultGWT() {
        this.setHeaderVisible(false);
        
            this.setSize("500", "400");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("#,##0.00");
            final NumberCellRenderer<Grid<Tmp_tipomensalidadeTGWT>> numberRenderer = new NumberCellRenderer<Grid<Tmp_tipomensalidadeTGWT>>(currency);

            getToolBarMaster().setHeight(26);

            ColumnConfig column = null;

	    column = new ColumnConfig();
            column.setId("tmp_tx_nome");
            column.setHeader("Tipo da Mensalidade");
            column.setWidth(300);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("tmp_tx_descricao");
            column.setHeader("Descrição");
            column.setWidth(300);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("tmp_nr_valor");
            column.setHeader("Taxa");
            column.setNumberFormat(number);
            column.setWidth(60);
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
        Tmp_tipomensalidadeInsertGWT tmp_tipomensalidadeInsertGWT = new Tmp_tipomensalidadeInsertGWT();
        tmp_tipomensalidadeInsertGWT.setTmp_tipomensalidadeConsult(this);
        tmp_tipomensalidadeInsertGWT.setModal(true);
        tmp_tipomensalidadeInsertGWT.show();
    }
    
    private GridCellRenderer<Tmp_tipomensalidadeTGWT> getEditarRender() {
        return new GridCellRenderer<Tmp_tipomensalidadeTGWT>() {

            private boolean init;

            public Object render(final Tmp_tipomensalidadeTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tmp_tipomensalidadeTGWT> store, Grid<Tmp_tipomensalidadeTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Tmp_tipomensalidadeTGWT>>() {

                        public void handleEvent(GridEvent<Tmp_tipomensalidadeTGWT> be) {
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
                        Tmp_tipomensalidadeUpdateDeleteGWT tmp_tipomensalidadeUpdateDeleteGWT = new Tmp_tipomensalidadeUpdateDeleteGWT();
                        tmp_tipomensalidadeUpdateDeleteGWT.setTmp_tipomensalidadeConsult(Tmp_tipomensalidadeConsultGWT.this);
                        tmp_tipomensalidadeUpdateDeleteGWT.load(model);
                        tmp_tipomensalidadeUpdateDeleteGWT.show();
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
    tmp_tipomensalidadeDao.consultarTodos();
    Timer timer = new Timer() {
            public void run() {
                ListStore<Tmp_tipomensalidadeTGWT> list = tmp_tipomensalidadeDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Tmp_tipomensalidadeTGWT> grid = new Grid<Tmp_tipomensalidadeTGWT>(list, cm);
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

