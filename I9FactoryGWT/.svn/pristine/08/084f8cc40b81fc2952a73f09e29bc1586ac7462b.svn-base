/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.cli_cliente;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.i9factory.client.i9factory.factory.dep_dependente.Dep_dependenteConsultGWT;
import br.com.i9factory.client.i9factory.factory.orcl_orgao_cliente.Orcl_orgao_clienteConsultGWT;
import br.com.i9factory.client.i9factory.factory.ref_referencia.Ref_referenciaConsultGWT;
import br.com.i9factory.client.i9factory.factory.res_restricao.Res_restricaoConsultGWT;

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
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
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
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Cli_clienteConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Cli_clienteDAOGWT cli_clienteDao = new Cli_clienteDAOGWT();
    private Cli_clienteTGWT cli_clienteTGWT = new Cli_clienteTGWT();
    private TextField<String> conteudo = new TextField<String>();
    private Button btnNome = new Button("Pesquisar");
    private RadioGroup radioGroup = new RadioGroup();
    private String campoFiltro;
    private Radio rgCPF = new Radio();
    private Radio rgNome = new Radio();
    private Radio rgMatricula = new Radio();

    public Cli_clienteConsultGWT() {
        getToolBarMaster().setHeight(26);
        getCpMaster().setHeaderVisible(false);
        this.setHeaderVisible(false);
        getToolBarMaster().setHeight(26);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());

        rgNome.setBoxLabel("Nome");


        rgCPF.setBoxLabel("CPF");


        rgMatricula.setBoxLabel("Matricula");

        radioGroup.add(rgMatricula);
        radioGroup.add(rgNome);
        radioGroup.add(rgCPF);
        radioGroup.setValue(rgMatricula);

        KeyListener kl = new KeyListener() {

            public void componentKeyUp(ComponentEvent event) {
                if (event.getKeyCode() == 13) {
                    setCampoFiltro(radioGroup.getValue() == rgNome ?  "nome" : radioGroup.getValue() == rgCPF ? "CPF" : "MATRICULA");
                    load(getCampoFiltro());
                }
            }
        };
        conteudo.addKeyListener(kl);

        getToolBarMaster().add(new LabelField("Localizar por:"));

        getToolBarMaster().add(radioGroup);
        getToolBarMaster().add(conteudo);
        btnNome.setIcon(ICONS.filter());
        getToolBarMaster().add(btnNome);

        btnNome.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                setCampoFiltro(radioGroup.getValue() == rgNome ?  "nome" : radioGroup.getValue() == rgCPF ? "CPF" : "MATRICULA");
                load(getCampoFiltro());
            }
        });

        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Cli_clienteTGWT>> numberRenderer = new NumberCellRenderer<Grid<Cli_clienteTGWT>>(currency);

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("cli_tx_matricula");
        column.setHeader("Matrícula");
        column.setWidth(80);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_nome");
        column.setHeader("Nome");
        column.setWidth(250);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_cpf");
        column.setHeader("CPF");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_rg");
        column.setHeader("RG");
        column.setWidth(80);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_telefone1");
        column.setHeader("Telefone(1)");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_telefone2");
        column.setHeader("Telefone(2)");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_celular");
        column.setHeader("Celular");
        column.setWidth(100);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgDep");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getDependenteRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgRestricao");
        column.setWidth(35);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getRestricaoRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgRef");
        column.setWidth(35);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getReferenciaRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgOrg");
        column.setWidth(35);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getOrgaoRender());
        configs.add(column);
        //load();

    }

    public void btnNovoAction(ButtonEvent be) {
        Cli_clienteInsertGWT cli_clienteInsertGWT = new Cli_clienteInsertGWT();
        cli_clienteInsertGWT.setCli_clienteConsult(this);
        cli_clienteInsertGWT.setModal(true);
        cli_clienteInsertGWT.show();

    }

    private GridCellRenderer<Cli_clienteTGWT> getEditarRender() {
        return new GridCellRenderer<Cli_clienteTGWT>() {

            private boolean init;

            public Object render(final Cli_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Cli_clienteTGWT> store, Grid<Cli_clienteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cli_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
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
                        Cli_clienteUpdateDeleteGWT cli_clienteUpdateDeleteGWT = new Cli_clienteUpdateDeleteGWT();
                        cli_clienteUpdateDeleteGWT.setCli_clienteConsult(Cli_clienteConsultGWT.this);
                        cli_clienteUpdateDeleteGWT.setCampoFiltro(campoFiltro);
                        cli_clienteUpdateDeleteGWT.load(model);
                        cli_clienteUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Cli_clienteTGWT> getDependenteRender() {
        return new GridCellRenderer<Cli_clienteTGWT>() {

            private boolean init;

            public Object render(final Cli_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Cli_clienteTGWT> store, Grid<Cli_clienteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cli_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
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
                        Dep_dependenteConsultGWT consultGWT = new Dep_dependenteConsultGWT(model);
                        consultGWT.setModal(true);
                        consultGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Dependentes");
                b.setIcon(ICONS.user_add());

                return b;
            }
        };
    }

    private GridCellRenderer<Cli_clienteTGWT> getRestricaoRender() {
        return new GridCellRenderer<Cli_clienteTGWT>() {

            private boolean init;

            public Object render(final Cli_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Cli_clienteTGWT> store, Grid<Cli_clienteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cli_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
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
                        Res_restricaoConsultGWT consultGWT = new Res_restricaoConsultGWT(model);
                        consultGWT.setModal(true);
                        consultGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Restrições");
                b.setIcon(ICONS.noImage());
                return b;
            }
        };
    }

    private GridCellRenderer<Cli_clienteTGWT> getReferenciaRender() {
        return new GridCellRenderer<Cli_clienteTGWT>() {

            private boolean init;

            public Object render(final Cli_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Cli_clienteTGWT> store, Grid<Cli_clienteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cli_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
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
                        Ref_referenciaConsultGWT consultGWT = new Ref_referenciaConsultGWT(model);
                        consultGWT.setModal(true);
                        consultGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Referências");
                b.setIcon(ICONS.plugin());
                return b;
            }
        };
    }

    private GridCellRenderer<Cli_clienteTGWT> getOrgaoRender() {
        return new GridCellRenderer<Cli_clienteTGWT>() {

            private boolean init;

            public Object render(final Cli_clienteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Cli_clienteTGWT> store, Grid<Cli_clienteTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Cli_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
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
                        Orcl_orgao_clienteConsultGWT consultGWT = new Orcl_orgao_clienteConsultGWT(model);
                        consultGWT.setModal(true);
                        consultGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Orgãos");
                b.setIcon(ICONS.list());
                return b;
            }
        };
    }

    public void load(String campoFiltro) {

        cli_clienteDao.consultarTodosFiltro(campoFiltro, conteudo.getValue().trim(), false);

        Timer timer = new Timer() {

            public void run() {

                ListStore<Cli_clienteTGWT> list = cli_clienteDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);
                    loader.setRemoteSort(true);


                    ListStore<Cli_clienteTGWT> store = new ListStore<Cli_clienteTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(16);
                    getToolBarPage().bind(loader);
                    loader.load(0, 16);

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Cli_clienteTGWT> grid = new Grid<Cli_clienteTGWT>(store, cm);
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
