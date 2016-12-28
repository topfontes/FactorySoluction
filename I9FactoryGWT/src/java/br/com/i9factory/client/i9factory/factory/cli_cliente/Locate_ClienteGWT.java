/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.cli_cliente;

import br.com.easynet.gwt.client.icons.Icones;
import br.com.i9factory.client.i9factory.factory.cco_contacorrente.Cco_contacorrenteUpdateDeleteGWT;
import br.com.i9factory.client.i9factory.factory.dao.Cli_clienteDAOGWT;
import br.com.i9factory.client.i9factory.factory.emp_emprestimo.Emp_emprestimoInsertGWT;
import br.com.i9factory.client.i9factory.factory.emp_emprestimo.Emp_emprestimoUpdateDeleteGWT;
import br.com.i9factory.client.i9factory.factory.orcl_orgao_cliente.Orcl_orgao_clienteInsertGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cco_contacorrenteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.MaxPropostaTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Org_orgaoTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.Timer;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class Locate_ClienteGWT extends Window {

    private String key;
    private String campoFiltro;
    private Cli_clienteDAOGWT cli_clienteDAOGWT = new Cli_clienteDAOGWT();
    private List<ColumnConfig> configs = new Vector();
    private ListStore<Cli_clienteTGWT> store;
    private ContentPanel cp = new ContentPanel(new FillLayout());
    private ContentPanel cpLeft = new ContentPanel(new FillLayout());
    private FormBinding formBinding;
    private FormBinding formBindingConta;
    private FormPanel panelBainding = new FormPanel();
    private FormPanel panelBaindingConta = new FormPanel();
    private ContentPanel cpConta = new ContentPanel(new FillLayout());
    private List<ColumnConfig> configsOrgao = new Vector();
    private Button btnConf = new Button("Confirma");
    private Button btnCancel = new Button("Cancelar");
    private Cli_clienteTGWT cli_clienteTGWT;
    private Cco_contacorrenteTGWT cco_contacorrenteTGWT;
    public TextField<String> bco_tx_nome = new TextField<String>();
    public TextField<String> cco_tx_nragencia = new TextField<String>();
    public TextField<String> cco_tx_nrcontacorrente = new TextField<String>();
    private ListStore<Cco_contacorrenteTGWT> storeOrg;
    private Grid<Cco_contacorrenteTGWT> gridOrg;
    private Emp_emprestimoInsertGWT emp_emprestimoInsertGWT;
    private MaxPropostaTGWT maxPropostaTGWT = new MaxPropostaTGWT();
    private Button btncadOrgao = new Button("Novo orgão", Icones.ICONS.novo());
    private Emp_emprestimoUpdateDeleteGWT emp_emprestimoUpdateDeleteGWT;

    public Locate_ClienteGWT(Emp_emprestimoInsertGWT emp_emprestimoInsertGWT, Emp_emprestimoUpdateDeleteGWT emp_emprestimoUpdateDeleteGWT, String campoFiltro, String key) {
        this.emp_emprestimoInsertGWT = emp_emprestimoInsertGWT;
        this.emp_emprestimoUpdateDeleteGWT = emp_emprestimoUpdateDeleteGWT;
        this.key = key;
        this.campoFiltro = campoFiltro;
        this.setHeading("Localização de clientes");
        this.setSize(705, 290);
        cli_clienteDAOGWT.consultarTodosFiltro(campoFiltro, key, true);
        layout();
        cp.setHeaderVisible(false);
        cp.setFrame(false);
        cp.setBodyBorder(true);
        this.setLayout(new FillLayout());
        btncadOrgao.setEnabled(false);

        cpConta.setHeaderVisible(false);
        ToolBar bar = new ToolBar();
        //bar.add(new LabelToolItem("Orgão"));
        bar.add(btncadOrgao);
        btncadOrgao.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                Orcl_orgao_clienteInsertGWT orcl_orgao_clienteInsertGWT = new Orcl_orgao_clienteInsertGWT(cli_clienteTGWT);
                orcl_orgao_clienteInsertGWT.setLocate_ClienteGWT(Locate_ClienteGWT.this);
                orcl_orgao_clienteInsertGWT.show();
            }
        });


        cpConta.setTopComponent(bar);
        cpConta.setFrame(false);

        ContentPanel cpMain = new ContentPanel(new RowLayout(Orientation.VERTICAL));
        cpMain.setHeaderVisible(false);
        cpMain.setFrame(false);
        cpMain.setBodyBorder(false);
        cpMain.setHeight(130);

        this.setLayout(new RowLayout(Orientation.HORIZONTAL));
        this.add(cpMain, new RowData(.67, 1, new Margins(3)));
        this.add(cpConta, new RowData(.33, 1, new Margins(3)));

        cpMain.add(cp, new RowData(1, .5, new Margins(3)));
        cpMain.add(panelBainding, new RowData(1, .5, new Margins(3)));

//        this.add(cpMain);

        panelBainding.setHeaderVisible(false);
        panelBainding.setBodyBorder(false);
        createFieldsClientes();

        formBinding = new FormBinding(panelBainding, true);
        formBindingConta = new FormBinding(panelBaindingConta, true);

        btnConf.setIcon(Icones.ICONS.aplicar());
        btnConf.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                confirma();
            }
        });

        btnCancel.setIcon(Icones.ICONS.noImage());
        btnCancel.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                cancel();
            }
        });

        ToolBar toolBar = new ToolBar();
        toolBar.setAlignment(HorizontalAlignment.CENTER);
        toolBar.add(btnConf);
        toolBar.add(new SeparatorToolItem());
        toolBar.add(new SeparatorToolItem());
        toolBar.add(new SeparatorToolItem());
        toolBar.add(btnCancel);
        cpConta.setBottomComponent(toolBar);

        montarTela();
    }

    public void cancel() {
        emp_emprestimoInsertGWT.btnLimpartAction(null);
        close();
    }

    public void verificarQtdeOrgao() {
        if (storeOrg.getCount() > 1) {
            gridOrg.focus();
        } else if (storeOrg != null) {
            confirma();
        } else {
            MessageBox mb = new MessageBox();
            mb.alert("IMPORTANTE", "Não Existe Orgão para este cliente, favar ir no cadastro ao clientes e associar o orgão", null);
        }
    }

    public void confirma() {
        if (emp_emprestimoInsertGWT != null) {
            maxPropostaTGWT = cli_clienteDAOGWT.getTreeProposta().get(cli_clienteTGWT.getCli_nr_id());

            emp_emprestimoInsertGWT.getNumeroProposta().setValue(maxPropostaTGWT.getUltimaProposta() + 1);
            emp_emprestimoInsertGWT.getCli_tx_matricula().setValue(cli_clienteTGWT.getCli_tx_matricula());
            emp_emprestimoInsertGWT.getCli_tx_cpf().setValue(cli_clienteTGWT.getCli_tx_cpf());
            emp_emprestimoInsertGWT.getCli_tx_nome().setValue(cli_clienteTGWT.getCli_tx_nome());
            emp_emprestimoInsertGWT.getBco_tx_nome().setValue(getCco_contacorrenteTGWT().getBco_tx_nome());
            emp_emprestimoInsertGWT.getOrg_tx_nome().setValue(getCco_contacorrenteTGWT().getOrg_tx_nome());
            emp_emprestimoInsertGWT.getCli_nr_id().setValue(cli_clienteTGWT.getCli_nr_id() + "");
            emp_emprestimoInsertGWT.setOrg_nr_id(getCco_contacorrenteTGWT().getOrg_nr_id());
            emp_emprestimoInsertGWT.consultarParcelasAberto();
        } else {
            //emp_emprestimoUpdateDeleteGWT.getNumeroProposta().setValue(maxPropostaTGWT.getUltimaProposta() + 1);
            emp_emprestimoUpdateDeleteGWT.getCli_tx_matricula().setValue(cli_clienteTGWT.getCli_tx_matricula());
            emp_emprestimoUpdateDeleteGWT.getCli_tx_cpf().setValue(cli_clienteTGWT.getCli_tx_cpf());
            emp_emprestimoUpdateDeleteGWT.getCli_tx_nome().setValue(cli_clienteTGWT.getCli_tx_nome());
            emp_emprestimoUpdateDeleteGWT.getBco_tx_nome().setValue(getCco_contacorrenteTGWT().getBco_tx_nome());
            emp_emprestimoUpdateDeleteGWT.getOrg_tx_nome().setValue(getCco_contacorrenteTGWT().getOrg_tx_nome());
            emp_emprestimoUpdateDeleteGWT.getCli_nr_id().setValue(cli_clienteTGWT.getCli_nr_id() + "");
            emp_emprestimoUpdateDeleteGWT.setOrg_nr_id(getCco_contacorrenteTGWT().getOrg_nr_id());
            //emp_emprestimoUpdateDeleteGWT.consultarParcelasAberto();
        }
        close();

    }

    public void createFieldsClientes() {

        panelBainding.setLayout(new FillLayout());
        panelBainding.setFrame(false);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);

        TableLayout layoutCep = new TableLayout(3);
        layoutCep.setCellPadding(3);
        ContentPanel cpCep = new ContentPanel(layoutCep);
        cpCep.setHeaderVisible(false);
        cpCep.setBodyBorder(false);

        TextField<String> cli_tx_cep = new TextField<String>();
        cpCep.add(new LabelField("End......:"));

        TextField<String> cli_tx_tipologradouro = new TextField<String>();
        cli_tx_tipologradouro.setReadOnly(true);
        cli_tx_tipologradouro.setName("cli_tx_tipologradouro");
        cli_tx_tipologradouro.setWidth(53);
        cpCep.add(cli_tx_tipologradouro);

        TextField<String> cli_tx_logradouro = new TextField<String>();
        cli_tx_logradouro.setReadOnly(true);
        cli_tx_logradouro.setName("cli_tx_logradouro");
        cli_tx_logradouro.setWidth(314);
        cpCep.add(cli_tx_logradouro);
        panelBainding.add(cpCep);

        TableLayout layoutNumero = new TableLayout(3);
        layoutNumero.setCellPadding(3);
        ContentPanel cpNumero = new ContentPanel(layoutNumero);
        cpNumero.setHeaderVisible(false);
        cpNumero.setBodyBorder(false);

        TextField<String> cli_tx_numero = new TextField<String>();
        cli_tx_numero.setReadOnly(true);
        cli_tx_numero.setName("cli_tx_numero");
        cli_tx_numero.setWidth(40);
        cpNumero.add(new LabelField("Número:"));
        cpNumero.add(cli_tx_numero);

        TextField<String> cli_tx_complemento = new TextField<String>();
        cli_tx_complemento.setReadOnly(true);
        cli_tx_complemento.setName("cli_tx_complemento");
        cli_tx_complemento.setWidth(326);
        cpNumero.add(cli_tx_complemento);
        panelBainding.add(cpNumero);

        TableLayout layoutBairro = new TableLayout(4);
        layoutBairro.setCellPadding(3);
        ContentPanel cpBairro = new ContentPanel(layoutBairro);

        cpBairro.setHeaderVisible(false);
        cpBairro.setBodyBorder(false);

        TextField<String> cli_tx_bairro = new TextField<String>();
        cli_tx_bairro.setReadOnly(true);
        cli_tx_bairro.setName("cli_tx_bairro");
        cpBairro.add(new LabelField("Bairro...:"));
        cli_tx_bairro.setWidth(160);
        cpBairro.add(cli_tx_bairro);

        TextField<String> cli_tx_municipio = new TextField<String>();
        cli_tx_municipio.setReadOnly(true);
        cli_tx_municipio.setName("cli_tx_municipio");
        cli_tx_municipio.setWidth(170);
        cpBairro.add(cli_tx_municipio);

        TextField<String> cli_tx_uf = new TextField<String>();
        cli_tx_uf.setReadOnly(true);
        cli_tx_uf.setName("cli_tx_uf");
        cli_tx_uf.setWidth(30);
        cpBairro.add(cli_tx_uf);
        panelBainding.add(cpBairro);

    }

    public void montarTela() {

        createColumnOrgao();

        ColumnConfig nome = new ColumnConfig("cli_tx_nome", "Nome", 250);
        ColumnConfig cpf = new ColumnConfig("cli_tx_cpf", "CPF", 90);
        ColumnConfig matricula = new ColumnConfig("cli_tx_matricula", "Matrícula", 60);
        if (campoFiltro.equalsIgnoreCase("nome")) {
            configs.add(nome);
            configs.add(cpf);
            configs.add(matricula);
        } else if (campoFiltro.equalsIgnoreCase("CPF")) {
            configs.add(cpf);
            configs.add(nome);
            configs.add(matricula);
        } else {
            configs.add(matricula);
            configs.add(nome);
            configs.add(cpf);
        }


        Timer timer = new Timer() {

            @Override
            public void run() {
                store = cli_clienteDAOGWT.getList();
                if (store == null) {
                    schedule(500);
                } else {
                    store.setMonitorChanges(true);
                    ColumnModel cm = new ColumnModel(configs);
                    Grid<Cli_clienteTGWT> grid = new Grid<Cli_clienteTGWT>(store, cm);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    grid.getSelectionModel().addListener(Events.SelectionChange,
                            new Listener<SelectionChangedEvent<Cli_clienteTGWT>>() {

                                public void handleEvent(SelectionChangedEvent<Cli_clienteTGWT> be) {
                                    if (be.getSelection().size() > 0) {
                                        cli_clienteTGWT = be.getSelection().get(0);
                                        btncadOrgao.setEnabled(true);
                                        formBinding.bind((ModelData) be.getSelection().get(0));
                                        montarConta(be.getSelection().get(0));
                                    } else {
                                        formBinding.unbind();
                                    }
                                }
                            });

                    grid.getView().setEmptyText("Nenhum cliente encontrado com as informações especificadas!");

                    grid.addListener(Events.OnKeyPress, new Listener<GridEvent<Cli_clienteTGWT>>() {

                        public void handleEvent(GridEvent<Cli_clienteTGWT> be) {
                            if (be.getEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
                                verificarQtdeOrgao();
                            }
                        }
                    });

                    grid.setBorders(false);
                    cp.removeAll();
                    cp.add(grid);
                    layout();
                    grid.focus();
                }
            }
        };
        timer.schedule(500);

        layout();
    }

    public void createColumnOrgao() {
        GridCellRenderer<Cco_contacorrenteTGWT> gcr = new GridCellRenderer<Cco_contacorrenteTGWT>() {

            public Object render(final Cco_contacorrenteTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Cco_contacorrenteTGWT> store, Grid<Cco_contacorrenteTGWT> grid) {
                Button b = new Button("", Icones.ICONS.edit());
                b.addSelectionListener(new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        Cco_contacorrenteTGWT cco_contacorrenteTGWT = new Cco_contacorrenteTGWT();
                        cco_contacorrenteTGWT.setBco_nr_id(model.getBco_nr_id());
                        cco_contacorrenteTGWT.setCco_nr_id(model.getCco_nr_id());
                        cco_contacorrenteTGWT.setCco_tx_nragencia(model.getCco_tx_nragencia());
                        cco_contacorrenteTGWT.setCco_tx_nrcontacorrente(model.getCco_tx_nrcontacorrente());
                        cco_contacorrenteTGWT.setCco_tx_nomecorrentista(cli_clienteTGWT.getCli_tx_nome());
                        Org_orgaoTGWT org_orgaoTGWT = new Org_orgaoTGWT();
                        org_orgaoTGWT.setOrg_nr_id(model.getOrg_nr_id());
                        Cco_contacorrenteUpdateDeleteGWT updateDeleteGWT = new Cco_contacorrenteUpdateDeleteGWT(cli_clienteTGWT, org_orgaoTGWT);
                        updateDeleteGWT.setLocate_ClienteGWT(Locate_ClienteGWT.this);
                        updateDeleteGWT.load(cco_contacorrenteTGWT);
                        updateDeleteGWT.show();
                    }
                });
                return b;
            }
        };


        ColumnConfig column = new ColumnConfig("edit", "", 35);
        configsOrgao.add(column);
        column.setRenderer(gcr);
        column = new ColumnConfig("org_tx_nome", "Orgão", 185);
        configsOrgao.add(column);
    }

    public void montarConta(Cli_clienteTGWT cli_clienteTGWT) {
        cpConta.removeAll();
        setCco_contacorrenteTGWT(null);


        bco_tx_nome.setValue(null);
        cco_tx_nragencia.setValue(null);
        cco_tx_nrcontacorrente.setValue(null);

        storeOrg = new ListStore<Cco_contacorrenteTGWT>();
        List<Cco_contacorrenteTGWT> list = cli_clienteDAOGWT.getTreeConta().get(cli_clienteTGWT.getCli_nr_id());
        storeOrg.add(list);
        ColumnModel cm = new ColumnModel(configsOrgao);
        gridOrg = new Grid<Cco_contacorrenteTGWT>(storeOrg, cm);
        gridOrg.setBorders(true);

        gridOrg.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridOrg.getSelectionModel().addListener(Events.SelectionChange,
                new Listener<SelectionChangedEvent<Cco_contacorrenteTGWT>>() {

                    public void handleEvent(SelectionChangedEvent<Cco_contacorrenteTGWT> be) {
                        if (be.getSelection().size() > 0) {
                            formBindingConta.bind((ModelData) be.getSelection().get(0));
                            setCco_contacorrenteTGWT(be.getSelection().get(0));
                            bco_tx_nome.setValue(getCco_contacorrenteTGWT().getBco_tx_nome());
                            cco_tx_nragencia.setValue(getCco_contacorrenteTGWT().getCco_tx_nragencia());
                            cco_tx_nrcontacorrente.setValue(getCco_contacorrenteTGWT().getCco_tx_nrcontacorrente());

                        } else {
                            formBindingConta.unbind();
                        }
                    }
                });
        gridOrg.addListener(Events.KeyPress, new Listener<GridEvent<Cco_contacorrenteTGWT>>() {

            public void handleEvent(GridEvent<Cco_contacorrenteTGWT> be) {
                Info.display("1", "");
                if (be.getEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
                    com.google.gwt.user.client.Window.alert("ss");
                }
            }
        });

        cpConta.add(gridOrg);
        cpConta.add(createBaindigClonta());
        gridOrg.getView().setEmptyText("Nenhum Orgão");
        layout();

    }

    public FormPanel createBaindigClonta() {

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(2);
        ContentPanel panel = new ContentPanel(layout);
        panel.setHeaderVisible(false);
        panel.setBodyBorder(false);
        panel.setFrame(false);

        panelBaindingConta = new FormPanel();
        panelBaindingConta.setHeight(100);
        panelBaindingConta.setHeaderVisible(false);
        panelBaindingConta.setFrame(false);

        panelBaindingConta.setLayout(new FillLayout());

        panel.add(new LabelField("BC."));
        bco_tx_nome.setReadOnly(true);
        bco_tx_nome.setName("bco_tx_nome");
        bco_tx_nome.setWidth(170);
        panel.add(bco_tx_nome);

        panel.add(new LabelField("AG."));
        cco_tx_nragencia.setReadOnly(true);
        cco_tx_nragencia.setName("cco_tx_nragencia");
        cco_tx_nragencia.setWidth(170);
        panel.add(cco_tx_nragencia);

        panel.add(new LabelField("CC."));
        cco_tx_nrcontacorrente.setReadOnly(true);
        cco_tx_nrcontacorrente.setName("cco_tx_nrcontacorrente");
        cco_tx_nrcontacorrente.setWidth(170);
        panel.add(cco_tx_nrcontacorrente);
        panelBaindingConta.add(panel);

        return panelBaindingConta;
    }

    /**
     * @return the btnConf
     */
    public Button getBtnConf() {
        return btnConf;
    }

    /**
     * @param btnConf the btnConf to set
     */
    public void setBtnConf(Button btnConf) {
        this.btnConf = btnConf;
    }

    /**
     * @return the cco_contacorrenteTGWT
     */
    public Cco_contacorrenteTGWT getCco_contacorrenteTGWT() {
        return cco_contacorrenteTGWT;
    }

    /**
     * @param cco_contacorrenteTGWT the cco_contacorrenteTGWT to set
     */
    public void setCco_contacorrenteTGWT(Cco_contacorrenteTGWT cco_contacorrenteTGWT) {
        this.cco_contacorrenteTGWT = cco_contacorrenteTGWT;
    }
}
