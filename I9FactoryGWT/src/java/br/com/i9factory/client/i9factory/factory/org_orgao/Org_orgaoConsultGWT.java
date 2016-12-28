/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.org_orgao;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;

import com.extjs.gxt.ui.client.Style.SelectionMode;
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
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Org_orgaoConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Org_orgaoDAOGWT org_orgaoDao = new Org_orgaoDAOGWT();
    private TextField<String> conteudo = new TextField<String>();
    private Button btnNome = new Button("Pesquisar");
    private RadioGroup radioGroup = new RadioGroup();
    private String campoFiltro;
    private Radio rgTodos = new Radio();
    private Radio rgNome = new Radio();
    private Radio rgCPF = new Radio();

    public Org_orgaoConsultGWT() {

        this.setHeaderVisible(false);
        getCpMaster().setHeaderVisible(false);

        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Org_orgaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Org_orgaoTGWT>>(currency);

        getToolBarMaster().setHeight(26);

        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());


        rgTodos.setValue(true);
        rgTodos.setBoxLabel("Todos");
        conteudo.setEmptyText("Todos");


        rgNome.setBoxLabel("Nome Fantasia");


        rgCPF.setBoxLabel("CNPJ");

        radioGroup.add(rgTodos);
        radioGroup.add(rgNome);
        radioGroup.add(rgCPF);

        getToolBarMaster().add(new LabelField("Localizar por:"));

        getToolBarMaster().add(radioGroup);
        getToolBarMaster().add(conteudo);
        btnNome.setIcon(ICONS.filter());
        getToolBarMaster().add(btnNome);

        btnNome.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                campoFiltro = radioGroup.getValue() == rgNome ? "NOME" : radioGroup.getValue() == rgCPF ? "CNPJ" : "TODOS";
                load();
            }
        });

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("org_tx_nomefantasia");
        column.setHeader("Orgão");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("org_tx_cnpj");
        column.setHeader("CNPJ");
        column.setWidth(120);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("org_tx_inscestadual");
        column.setHeader("Insc. Estadual");
        column.setWidth(120);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("org_tx_telefone1");
        column.setHeader("Telefone(01)");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("org_tx_telefone2");
        column.setHeader("Telefone(02)");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        //load();

    }

    public void btnNovoAction(ButtonEvent be) {
        Org_orgaoInsertGWT org_orgaoInsertGWT = new Org_orgaoInsertGWT();
        org_orgaoInsertGWT.setOrg_orgaoConsult(this);
        org_orgaoInsertGWT.setModal(true);
        org_orgaoInsertGWT.show();

    }

    private GridCellRenderer<Org_orgaoTGWT> getEditarRender() {
        return new GridCellRenderer<Org_orgaoTGWT>() {

            private boolean init;

            public Object render(final Org_orgaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Org_orgaoTGWT> store, Grid<Org_orgaoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Org_orgaoTGWT>>() {

                        public void handleEvent(GridEvent<Org_orgaoTGWT> be) {
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
                        Org_orgaoUpdateDeleteGWT org_orgaoUpdateDeleteGWT = new Org_orgaoUpdateDeleteGWT();
                        org_orgaoUpdateDeleteGWT.setOrg_orgaoConsult(Org_orgaoConsultGWT.this);
                        org_orgaoUpdateDeleteGWT.load(model);
                        org_orgaoUpdateDeleteGWT.show();
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
        if (radioGroup.getValue() == rgTodos) {
            org_orgaoDao.consultarTodos();
        } else {
            org_orgaoDao.consultarTodosFiltro(campoFiltro, conteudo.getValue().trim());
        }
        Timer timer = new Timer() {

            public void run() {
                ListStore<Org_orgaoTGWT> list = org_orgaoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
//                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
//                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
                    loader.setRemoteSort(true);


                    ListStore<Org_orgaoTGWT> store = new ListStore<Org_orgaoTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(20);
                    getToolBarPage().bind(loader);
                    loader.load(0, 20);

                    Grid<Org_orgaoTGWT> grid = new Grid<Org_orgaoTGWT>(store, cm);
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the campoFiltro
     */
    public String getCampoFiltro() {
        return campoFiltro;
    }

    /**
     * @param campoFiltro the campoFiltro to set
     */
    public void setCampoFiltro(String campoFiltro) {
        this.campoFiltro = campoFiltro;
    }
}
