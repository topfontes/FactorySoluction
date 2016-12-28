/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.emp_emprestimo;

import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9.portal.client.portal.portal.dao.Usu_usuarioDAOGWT;
import br.com.i9.portal.client.portal.portal.transfer.Usu_usuarioTGWT;
import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.ConsultaGWTHeight;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.i9factory.client.i9factory.factory.iconsAll.Icones;
import br.com.i9factory.client.i9factory.factory.ple_parcelaemprestimo.Ple_parcelaemprestimoInsertGWT;
import br.com.i9factory.client.i9factory.factory.ple_parcelaemprestimo.Ple_parcelaemprestimoUpdateDeleteGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.GridViewConfig;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Emp_emprestimoConsultGWT extends ConsultaGWTHeight {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Emp_emprestimoDAOGWT emp_emprestimoDao = new Emp_emprestimoDAOGWT();
    private ToolBar toolbarFilter = new ToolBar();
    private Button filtrar = new Button("Filtrar");
    private Button imprimir = new Button("Download");
    private Cli_clienteDAOGWT cli_clienteDAOGWT = new Cli_clienteDAOGWT();
    private Cor_corretoraDAOGWT cor_corretoraDAOGWT = new Cor_corretoraDAOGWT();
    private Usu_usuarioDAOGWT usu_usuarioDAOGWT = new Usu_usuarioDAOGWT();
    private Ple_parcelaemprestimoDAOGWT parcelaDAO = new Ple_parcelaemprestimoDAOGWT();
    private Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();
    private Radio rbAberto = new Radio();
    private Radio rbQuitado = new Radio();
    private Radio rbTodos = new Radio();
    private Radio rbCorretor = new Radio();
    private Radio rbGeral = new Radio();
    private Radio rbOrgao = new Radio();
    private Radio rbCliente = new Radio();
    private Radio rbUsuario = new Radio();
    private RadioGroup radioGroupOP = new RadioGroup();
    private RadioGroup radioGroup = new RadioGroup();
    private DateField dfIinicio = new DateField();
    private DateField dfFim = new DateField();
    private ContentPanel cpOp = new ContentPanel();
    private ContentPanel cpCombo = new ContentPanel();
    private String tipo_Agrupamento;
    private ComboBox<Cli_clienteTGWT> comboCli = new ComboBox<Cli_clienteTGWT>();
    private ComboBox<Org_orgaoTGWT> comboOrgao = new ComboBox<Org_orgaoTGWT>();
    private ComboBox<Cor_corretoraTGWT> comboCorretor = new ComboBox<Cor_corretoraTGWT>();
    private ComboBox<Usu_usuarioTGWT> comboUsuario = new ComboBox<Usu_usuarioTGWT>();
    private Grid<Emp_emprestimoTGWT> grid;
    private int id_emp;
    private NumberFormat format;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private List<ColumnConfig> configsParcelas = new ArrayList<ColumnConfig>();
    private ContentPanel cpParcelas = new ContentPanel();
    private TextField<String> tfFind = new TextField<String>();
    private GridCellRenderer rendererRow;
    private ContentPanel container = new ContentPanel(new FitLayout());
    private Emp_emprestimoTGWT emp_emprestimoTGWT;
    private final String PAGE_DOWNLOAD = "i9factory/factory/relatorios/extrato.jsp";
    private String url_download;
    private CheckBox chkExtrato = new CheckBox();
    private int id_usuario;
    private ListStore<br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT> listaPer;
    private final String USUARIO_ADM = "ADMINISTRADOR";
    private final String USUARIO_GERENTE = "GERENTE";
    private final String USUARIO_ATENDENTE = "ATENDENTE";
    private boolean administrador;
    private Button btnnew = new Button("Novo", Icones.ICONS.add2());
    private GridCellRenderer<Emp_emprestimoTGWT> getRederStatus;
    private TextArea tx_obs_emp = new TextArea();

    public Emp_emprestimoConsultGWT() {

        btnnew.setEnabled(false);
        listaPer = PortalAccordionGWT.getListPer();
        administrador = locatePerfil(USUARIO_ADM);

        container.setHeaderVisible(false);
        container.setBottomComponent(cpParcelas);

        format = NumberFormat.getFormat("#,##0.00");
        tfFind.setEnabled(false);
        tfFind.setWidth(150);
        ToolBar bar = new ToolBar();
        bar.add(new LabelToolItem("Selecione:"));
        bar.add(tfFind);
        cpCombo.setTopComponent(bar);
        cpCombo.setHeight(60);

        this.setHeaderVisible(false);
        getDataNORTH().setSize(26);
        getDataWEST().setHidden(true);
        getDataEAST().setSize(280);
        getCpRight().setWidth(280);
        getDataEAST().setHidden(false);
        getCpRight().setHeading("Operações");

        FillLayout flay = new FillLayout();
        getCpRight().setLayout(flay);

        rendererRow = new GridCellRenderer<Ple_parcelaemprestimoTGWT>() {

            public Object render(Ple_parcelaemprestimoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ple_parcelaemprestimoTGWT> store, Grid<Ple_parcelaemprestimoTGWT> grid) {
                String color = model.get("ple_dt_pagamento") != null ? "<span style='color:green'>" : "<span style='color:red'>";
                String res = "";
                //String res = color;
                if (property.equalsIgnoreCase("ple_nr_valorparcela")) {
                    res = color + format.format(model.getPle_nr_valorparcela()) + "</span>";
                } else if (property.equalsIgnoreCase("ple_dt_vencimento")) {
                    res = color + dtfDate.format(model.getPle_dt_vencimento()) + "</span>";
                } else if (property.equalsIgnoreCase("ple_nr_valordesconto")) {
                    res = color + format.format(model.getPle_nr_valordesconto()) + "</span>";
                } else {
                    res = color + model.get(property) + "</span>";
                }
                return res;
            }
        };

        KeyListener kl = new KeyListener() {

            public void componentKeyUp(ComponentEvent event) {
                if (event.getKeyCode() == 13) {
                    if (tipo_Agrupamento.equalsIgnoreCase("C")) {
                        loadClientes();
                    } else if (tipo_Agrupamento.equalsIgnoreCase("O")) {
                        loadOrgao();
                    } else if (tipo_Agrupamento.equalsIgnoreCase("U")) {
                        loadusuario();
                    } else {
                        loadCorretor();
                    }
                }
            }
        };

        tfFind.addKeyListener(kl);

        montarTelaOP();
        filtrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });

        imprimir.setIcon(ICONS.download());
        imprimir.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                download();
            }
        });

        rbGeral.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addGeral();
            }
        });

        rbCliente.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addComboCliente();
            }
        });

        rbOrgao.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addComboOrgao();
            }
        });

        rbCorretor.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addComboCorretor();
            }
        });

        rbUsuario.setBoxLabel("Atendente");
        rbUsuario.addListener(Events.OnClick, new Listener<FieldEvent>() {

            public void handleEvent(FieldEvent be) {
                addComboUsuario();
            }
        });

        getRederStatus = new GridCellRenderer<Emp_emprestimoTGWT>() {

            public String render(Emp_emprestimoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Emp_emprestimoTGWT> store, Grid<Emp_emprestimoTGWT> grid) {
                String style = model.getEmp_tx_status().equalsIgnoreCase("P") ? "green" : "red";
                String status = model.getEmp_tx_status().equalsIgnoreCase("P") ? "Quitado" : "Aberto";
                return "<span style='color:" + style + "'>" + status + "</span>";
            }
        };

//        createColumn();
        createColumParcela();
    }

    public boolean locatePerfil(String perfil) {
        boolean res = false;
        for (br.com.easyportal.gwt.client.admin.portal.portal.transfer.Per_perfilTGWT per_perfilTGWT : listaPer.getModels()) {
            if (per_perfilTGWT.getPer_tx_nome().equalsIgnoreCase(perfil)) {
                res = true;
            }
        }
        return res;
    }

    public void loadClientes() {
        cli_clienteDAOGWT.consultByNome(tfFind.getValue());
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Cli_clienteTGWT> list = cli_clienteDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    comboCli.setStore(list);
                    comboCli.getView().refresh();
                    if (list.getCount() == 1) {
                        comboCli.setValue(list.getAt(0));
                    } else {
                        comboCli.focus();
                    }
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void loadusuario() {
        Usu_usuarioTGWT usu_usuarioTGWT = new Usu_usuarioTGWT();
        usu_usuarioTGWT.setUsu_tx_nome(tfFind.getValue());
        usu_usuarioDAOGWT.consultByNome(usu_usuarioTGWT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Usu_usuarioTGWT> store = usu_usuarioDAOGWT.getList();
                if (store == null) {
                    schedule(500);
                } else {
                    comboUsuario.setStore(store);
                    comboUsuario.getView().setStore(store);
                    comboUsuario.getView().refresh();
                    if (store.getCount() == 1) {
                        comboUsuario.setValue(store.getAt(0));
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void loadCorretor() {
        cor_corretoraDAOGWT.consultByNome(tfFind.getValue());
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Cor_corretoraTGWT> list = cor_corretoraDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    comboCorretor.setStore(list);
                    comboCorretor.getView().refresh();
                    if (list.getCount() == 1) {
                        comboCorretor.setValue(list.getAt(0));
                    }
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void loadOrgao() {
        org_orgaoDAOGWT.consultByNome(tfFind.getValue());
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Org_orgaoTGWT> list = org_orgaoDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    comboOrgao.setStore(list);
                    comboOrgao.getView().refresh();
                    if (list.getCount() == 1) {
                        comboOrgao.setValue(list.getAt(0));
                    }
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public boolean dowloadvalido() {
        boolean res = true;

        if (chkExtrato.getValue().booleanValue()) {
            if (emp_emprestimoTGWT == null) {
                res = false;
            }
        }
        return res;
    }

    public void download() {
        if (dowloadvalido()) {
            //final MessageBox mb = MessageBox.wait("Requisição", "Gerando Arquivo....", "Aguarde.......!!!");
            if (chkExtrato.getValue().booleanValue()) {
                url_download = Constantes.URL + PAGE_DOWNLOAD + "?op=imprimir&tipo=PDF&vw_parcelasT.emp_nr_id=" + emp_emprestimoTGWT.getEmp_nr_id() + "&extrato=true";
            } else {
                url_download = Constantes.URL + PAGE_DOWNLOAD + "?op=imprimir&tipo=PDF&dtInicio=" + dtfDate.format(dfIinicio.getValue()) + "&dtFim=" + dtfDate.format(dfFim.getValue());
                if (comboCli.getValue() != null) {
                    url_download += "emp_emprestimoT.cli_nr_id=" + comboCli.getValue().getCli_nr_id();
                } else if (comboCorretor.getValue() != null) {
                    url_download += "emp_emprestimoT.cor_nr_id=" + comboCorretor.getValue().getCor_nr_id();
                } else if (comboOrgao.getValue() != null) {
                    url_download += "emp_emprestimoT.org_nr_id=" + comboOrgao.getValue().getOrg_nr_id();
                }
                String status = radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Em Aberto") ? "A" : "P";
                url_download += "&tipo_Agrupamento=" + tipo_Agrupamento + "&status=" + status;
            }

//            Timer timer = new Timer() {
//
//                @Override
//                public void run() {
            //final 
            com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
            winDownload.setHeading("Extrato");
            winDownload.setSize(700, 700);
            winDownload.addText("Aguarde....!");
            //
            //winDownload.setResizable(false);
            winDownload.show();
            winDownload.layout();
            layout();
            winDownload.setUrl(url_download);

//                    Timer t = new Timer() {
//
//                        @Override
//                        public void run() {
//                            //winDownload.setVisible(false);
//                            mb.close();
//                        }
//                    };
//                    t.schedule(5000);
//                }
////            };
//            timer.schedule(100);// espera 10 segundos para poder exibir a janela para download do arquivo
        } else {
            MessageBox.alert("ATENÇÃO", "Selecione a proprosta", null);
        }
    }

    public void montarTelaOP() {
        ContentPanel cpopMaster = new ContentPanel();
        cpopMaster.setHeaderVisible(false);
        cpopMaster.setBodyBorder(false);

        filtrar.setIcon(ICONS.filter());
        toolbarFilter.setAlignment(HorizontalAlignment.CENTER);
        toolbarFilter.setBorders(true);

        toolbarFilter.add(filtrar);
        toolbarFilter.add(new SeparatorToolItem());
        toolbarFilter.add(new SeparatorToolItem());
        chkExtrato.setBoxLabel("Extrato");
        toolbarFilter.add(chkExtrato);
        toolbarFilter.add(new SeparatorToolItem());
        toolbarFilter.add(new SeparatorToolItem());
        toolbarFilter.add(imprimir);

        rbAberto.setBoxLabel("Em Aberto");
        rbQuitado.setBoxLabel("Quitado");
        rbTodos.setBoxLabel("Todos");
        rbTodos.setValue(true);
        radioGroup.add(rbTodos);
        radioGroup.add(rbAberto);
        radioGroup.add(rbQuitado);
        radioGroup.setOrientation(Orientation.VERTICAL);
        ToolBar toolStatus = new ToolBar();
        toolStatus.setBorders(true);
        toolStatus.add(new LabelToolItem("Status"));

        toolStatus.add(new SeparatorToolItem());
        toolStatus.add(new SeparatorToolItem());
        toolStatus.add(new SeparatorToolItem());

        toolStatus.add(radioGroup);
        //toolStatus.setBorders(true);
        cpopMaster.setTopComponent(toolStatus);
        cpopMaster.add(addCpSeparador());

        cpOp.setHeaderVisible(false);
        ToolBar toolBarOp = new ToolBar();
        toolBarOp.add(new LabelToolItem("Tipo de Agrupamento"));
        cpOp.setTopComponent(toolBarOp);
        rbGeral.setBoxLabel("Geral");
        rbGeral.setValue(true);
        rbCliente.setBoxLabel("Cliente");
        rbCorretor.setBoxLabel("Corretor");
        rbOrgao.setBoxLabel("Orgão");

        TableLayout layoutRg = new TableLayout(2);
        radioGroupOP.setLayoutData(layoutRg);

        radioGroupOP.add(rbGeral);
        radioGroupOP.add(rbCliente);
        radioGroupOP.add(rbCorretor);
        radioGroupOP.add(rbOrgao);
        radioGroupOP.add(rbUsuario);
        radioGroupOP.setBorders(false);
        radioGroupOP.setSpacing(2);

        radioGroupOP.setOrientation(Orientation.VERTICAL);
        ContentPanel panel = new ContentPanel();
        panel.setHeaderVisible(false);
        panel.setBodyBorder(false);
        TableLayout lay = new TableLayout(1);
        lay.setCellPadding(4);
        panel.setLayout(lay);
        panel.add(radioGroupOP);
        cpOp.add(panel);
        TableLayout layoutCombo = new TableLayout(1);
        layoutCombo.setCellPadding(3);
        cpCombo.setLayout(layoutCombo);
        cpCombo.setHeaderVisible(false);
        cpCombo.setBodyBorder(false);
        cpCombo.setHeight(56);
        addGeral();
        cpOp.add(cpCombo);

        cpopMaster.add(cpOp);
        cpopMaster.add(addCpSeparador());

        ContentPanel cpPeriodo = new ContentPanel();
        TableLayout layout = new TableLayout(4);
        cpPeriodo.setLayout(layout);
        cpPeriodo.setHeaderVisible(false);
        ToolBar toolPeriodo = new ToolBar();
        toolPeriodo.add(new LabelToolItem("Período"));
        toolPeriodo.setBorders(true);

        cpPeriodo.setTopComponent(toolPeriodo);
        cpPeriodo.setBottomComponent(toolbarFilter);
        layout.setCellPadding(3);
        cpPeriodo.setHeaderVisible(false);
        cpPeriodo.setBodyBorder(true);
        cpPeriodo.add(new LabelField("De:"));
        dfIinicio.setWidth(95);
        dfIinicio.getPropertyEditor().setFormat(dtfDate);
        cpPeriodo.add(dfIinicio);
        dfFim.setWidth(95);
        dfFim.getPropertyEditor().setFormat(dtfDate);
        cpPeriodo.add(new LabelField(" a "));
        cpPeriodo.add(dfFim);
        cpopMaster.add(cpPeriodo);
        BorderLayoutData bl = new BorderLayoutData(LayoutRegion.CENTER);

        FillLayout layoutBaixa = new FillLayout();
        cpParcelas.setLayout(layoutBaixa);
        cpParcelas.setHeaderVisible(false);
        cpParcelas.setBodyBorder(false);
        cpParcelas.setFrame(false);
        ToolBar barBaixa = new ToolBar();
        barBaixa.setBorders(true);

        btnnew.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
//                if (administrador) {
                insertParcela();
//                }
            }
        });

//        if (administrador) {
        barBaixa.add(btnnew);
//        }
        barBaixa.add(new LabelToolItem("Parcelas/Mensalidades"));
        cpParcelas.setTopComponent(barBaixa);

        cpopMaster.add(addCpSeparador());

        cpParcelas.setHeight(160);
//        cpopMaster.add(cpParcelas);
        getCpRight().add(cpopMaster, new RowData(1, 1, new Margins(4, 4, 4, 4)));

        getCpRight().layout();
        layout();

        getCpRight().layout();
        layout();

    }

    public void addComboCliente() {
        tfFind.setEnabled(true);
        tfFind.setValue("");
        tfFind.setEmptyText("Cliente");
        cpCombo.removeAll();
        comboCli.setStore(cli_clienteDAOGWT.getList());
        comboCli.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboCli.setDisplayField("cli_tx_nome");
        comboCli.setEmptyText("Selecione o cliente");
        comboCli.setWidth(200);
        cpCombo.add(comboCli);
        tipo_Agrupamento = "C";
        comboOrgao.setValue(null);
        comboCorretor.setValue(null);
        comboUsuario.setValue(null);
        layout();
    }

    public void addComboOrgao() {
        tfFind.setEnabled(true);
        tfFind.setValue("");
        tfFind.setEmptyText("Orgão");
        cpCombo.removeAll();
        comboOrgao.setStore(new ListStore<Org_orgaoTGWT>());
        comboOrgao.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboOrgao.setDisplayField("org_tx_nomefantasia");
        comboOrgao.setEmptyText("Selecione o orgão.");
        comboOrgao.setWidth(200);
        cpCombo.add(comboOrgao);
        tipo_Agrupamento = "O";
        comboCli.setValue(null);
        comboUsuario.setValue(null);
        comboCorretor.setValue(null);
        layout();
    }

    public void addComboCorretor() {
        tfFind.setEnabled(true);
        tfFind.setValue("");
        tfFind.setEmptyText("Corretor");
        cpCombo.removeAll();
        comboCorretor.setStore(cor_corretoraDAOGWT.getList());
        comboCorretor.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboCorretor.setDisplayField("cor_tx_nomefantasia");
        comboCorretor.setEmptyText("Selecione o corretor(a)");
        comboCorretor.setWidth(200);
        cpCombo.add(comboCorretor);
        tipo_Agrupamento = "R";
        comboCli.setValue(null);
        comboOrgao.setValue(null);
        comboUsuario.setValue(null);
        layout();
    }

    public void addComboUsuario() {
        tfFind.setEnabled(true);
        tfFind.setValue("");
        tfFind.setEmptyText("Usuário");
        cpCombo.removeAll();
        comboUsuario.setStore(cor_corretoraDAOGWT.getList());
        comboUsuario.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboUsuario.setDisplayField("usu_tx_nome");
        comboUsuario.setEmptyText("Selecione o(a) Atendente");
        comboUsuario.setWidth(200);
        cpCombo.add(comboUsuario);
        tipo_Agrupamento = "U";
        comboCli.setValue(null);
        comboOrgao.setValue(null);
        comboCorretor.setValue(null);
        layout();
    }

    public void addGeral() {
        tfFind.setValue("");
        tfFind.setEnabled(false);
        cpCombo.removeAll();
        cpCombo.add(new LabelField("Todos os itens no período!"));
        tipo_Agrupamento = "G";
        comboCli.setValue(null);
        comboCorretor.setValue(null);
        comboOrgao.setValue(null);
        comboUsuario.setValue(null);
        layout();
    }

    public ContentPanel addCpSeparador() {
        ContentPanel panel = new ContentPanel();
        panel.setHeaderVisible(false);
        panel.setHeight(4);
        panel.setBodyBorder(false);

        return panel;

    }

    public void createColumn(String status) {
        configs.clear();
        SummaryColumnConfig<Double> column = null;

        column = new SummaryColumnConfig<Double>();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("imgImp");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getRendererImprimir());
        configs.add(column);
        //getRendererImprimir

        column = new SummaryColumnConfig<Double>();
        column.setId("emp_tx_status");
        column.setHeader("Status");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.LEFT);
        column.setRenderer(getRederStatus);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("cli_tx_nome");
        column.setHeader("Cliente");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("org_tx_nome");
        column.setHeader("Orgão");
        column.setWidth(150);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("cor_tx_nome");
        column.setHeader("Corretor");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("emp_nr_proposta");
        column.setHeader("Proposta");
        column.setNumberFormat(NumberFormat.getFormat("00000"));
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);
        
        column = new SummaryColumnConfig<Double>();
        column.setId("emp_seq_nr_boletobb");
        column.setHeader("Seq");
        //column.setNumberFormat(NumberFormat.getFormat("0"));
        column.setWidth(40);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        if (status.equalsIgnoreCase("Q")) {
            column = new SummaryColumnConfig<Double>();
            column.setId("emp_dt_quitacao");
            column.setHeader("Dt. Quitação");
            column.setDateTimeFormat(dtfDate);
            column.setWidth(90);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);
        } else {
            column = new SummaryColumnConfig<Double>();
            column.setId("emp_dt_emprestimo");
            column.setHeader("Dt. Emprestimo");
            column.setWidth(90);
            column.setDateTimeFormat(dtfDate);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);
        }

        column = new SummaryColumnConfig<Double>();
        column.setId("emp_nr_valor");
        column.setHeader("Valor");
        column.setNumberFormat(format);
        column.setSummaryType(SummaryType.SUM);
        column.setSummaryFormat(format);
        column.setWidth(80);
        column.setAlignment(HorizontalAlignment.RIGHT);
        configs.add(column);

        column = new SummaryColumnConfig<Double>();
        column.setId("usu_tx_nome");
        column.setHeader("Atendente");
        column.setWidth(70);
        configs.add(column);

    }

    public void btnNovoAction(ButtonEvent be) {
        Emp_emprestimoInsertGWT emp_emprestimoInsertGWT = new Emp_emprestimoInsertGWT();
        emp_emprestimoInsertGWT.setEmp_emprestimoConsult(this);
        emp_emprestimoInsertGWT.setModal(true);
        emp_emprestimoInsertGWT.show();
    }

    public void insertParcela() {
        Ple_parcelaemprestimoInsertGWT insertGWT = new Ple_parcelaemprestimoInsertGWT(grid.getSelectionModel().getSelectedItem().getEmp_nr_id(), Emp_emprestimoConsultGWT.this);
        insertGWT.show();
    }

    private GridCellRenderer<Emp_emprestimoTGWT> getRendererImprimir() {
        return new GridCellRenderer<Emp_emprestimoTGWT>() {

            private boolean init;

            public Object render(final Emp_emprestimoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Emp_emprestimoTGWT> store, Grid<Emp_emprestimoTGWT> grid) {

                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Emp_emprestimoTGWT>>() {

                        public void handleEvent(GridEvent<Emp_emprestimoTGWT> be) {
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
                        com.extjs.gxt.ui.client.widget.Window window = new com.extjs.gxt.ui.client.widget.Window();
                        window.setHeading("Emprestimo");
                        window.setSize(700, 600);
                        window.setLayout(new FillLayout());
                        PrintEmprestimoGWT emprestimoGWT = new PrintEmprestimoGWT(model);
                        window.add(emprestimoGWT);
                        window.show();
                        emprestimoGWT.filtrar();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Imprimir proposta");
                b.setIcon(ICONS.printer());

                return b;
            }
        };
    }

    private GridCellRenderer<Emp_emprestimoTGWT> getEditarRender() {
        return new GridCellRenderer<Emp_emprestimoTGWT>() {

            private boolean init;

            public Object render(final Emp_emprestimoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Emp_emprestimoTGWT> store, Grid<Emp_emprestimoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Emp_emprestimoTGWT>>() {

                        public void handleEvent(GridEvent<Emp_emprestimoTGWT> be) {
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
                        Emp_emprestimoUpdateDeleteGWT emp_emprestimoUpdateDeleteGWT = new Emp_emprestimoUpdateDeleteGWT();
                        emp_emprestimoUpdateDeleteGWT.setEmp_emprestimoConsult(Emp_emprestimoConsultGWT.this);
                        emp_emprestimoUpdateDeleteGWT.load(model);
                        emp_emprestimoUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Emp_emprestimoTGWT> getExcluirRender() {
        return new GridCellRenderer<Emp_emprestimoTGWT>() {

            private boolean init;

            public Object render(final Emp_emprestimoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Emp_emprestimoTGWT> store, Grid<Emp_emprestimoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Emp_emprestimoTGWT>>() {

                        public void handleEvent(GridEvent<Emp_emprestimoTGWT> be) {
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
                        emp_emprestimoDao.excluir(model);
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

        btnnew.setEnabled(false);
        emp_emprestimoTGWT = null;
        String status = radioGroup.getValue() == rbTodos ? "T" : radioGroup.getValue() == rbAberto ? "A" : "P";

        int id_Cli = 0;
        int id_Orgao = 0;
        int id_Corretor = 0;
        int id_usuario = 0;
        if (comboCli.getValue() != null) {
            id_Cli = comboCli.getValue().getCli_nr_id();
        }

        if (comboCorretor.getValue() != null) {
            id_Corretor = comboCorretor.getValue().getCor_nr_id();
        }

        if (comboOrgao.getValue() != null) {
            id_Orgao = comboOrgao.getValue().getOrg_nr_id();
        }
        if (comboUsuario.getValue() != null) {
            id_usuario = comboUsuario.getValue().getUsu_nr_id();
        }

        createColumn(status);

        Date dtInicio = dtfDate.parse("01/01/1900");
        Date dtFinal = new Date();

        if (tipo_Agrupamento.equalsIgnoreCase("G")) {
            dtInicio = new Date();
            dtFinal = new Date();
        }
        if (dfIinicio.getValue() != null) {
            dtInicio = dfIinicio.getValue();
        }
        if (dfFim.getValue() != null) {
            dtFinal = dfFim.getValue();
        }

        emp_emprestimoDao.consultarTodos(status, dtInicio, dtFinal, id_Cli, id_Corretor, id_Orgao, id_usuario, tipo_Agrupamento);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Emp_emprestimoTGWT> list = emp_emprestimoDao.getList();
                if (list == null) {
                    schedule(500);
                    Info.display("", "");
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    GroupSummaryView view = null;
                    GroupingStore<Emp_emprestimoTGWT> store = new GroupingStore<Emp_emprestimoTGWT>();
                    AggregationRowConfig<Emp_emprestimoTGWT> agRowConfig = null;
                    if (!tipo_Agrupamento.equalsIgnoreCase("G")) {
                        agRowConfig = new AggregationRowConfig<Emp_emprestimoTGWT>();
                        agRowConfig.setSummaryFormat("emp_nr_valor", NumberFormat.getFormat("#,##0.00"));
                        agRowConfig.setSummaryType("emp_nr_valor", SummaryType.SUM);
                        cm.addAggregationRow(agRowConfig);
                        store.add(list.getModels());
                        view = new GroupSummaryView();
                        view.setShowGroupedColumn(false);
                        view.setForceFit(true);
                        if (tipo_Agrupamento.equalsIgnoreCase("C")) {
                            store.groupBy("cli_tx_nome");
                        } else if (tipo_Agrupamento.equalsIgnoreCase("O")) {
                            store.groupBy("org_tx_nome");
                        } else if (tipo_Agrupamento.equalsIgnoreCase("R")) {
                            store.groupBy("cor_tx_nome");
                        } else {
                            store.groupBy("usu_tx_nome");
                        }
                    }

                    if (!tipo_Agrupamento.equalsIgnoreCase("G")) {
                        grid = new Grid<Emp_emprestimoTGWT>(store, cm);
                    } else {
                        grid = new Grid<Emp_emprestimoTGWT>(list, cm);
                    }

                    if (!tipo_Agrupamento.equalsIgnoreCase("G")) {
                        grid.setView(view);
                        grid.getView().setShowDirtyCells(false);
                        grid.getView().setForceFit(true);
                        grid.getView().setShowDirtyCells(false);
                    }
                    GridViewConfig viewConf = new GridViewConfig() {

                        @Override
                        public String getRowStyle(ModelData model, int rowIndex, ListStore<ModelData> ds) {
                            if (model.get("emp_tx_acordo").toString().equalsIgnoreCase("S")) {
                                return "row-acordo";
                            }else{
                            return "row-normal";
                        }
                        }   

                    };
                    grid.getView().setViewConfig(viewConf);

                    grid.setLoadMask(true);
                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    //grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    GridSelectionModel gsm = grid.getSelectionModel();
                    gsm.setSelectionMode(SelectionMode.SINGLE);
                    grid.setSelectionModel(gsm);

                    grid.getSelectionModel().addListener(Events.SelectionChange,
                            new Listener<SelectionChangedEvent<Emp_emprestimoTGWT>>() {

                                public void handleEvent(SelectionChangedEvent<Emp_emprestimoTGWT> be) {
                                    if (be.getSelection().size() > 0) {
                                        id_emp = be.getSelection().get(0).getEmp_nr_id();
                                        emp_emprestimoTGWT = be.getSelection().get(0);
                                        btnnew.setEnabled(true);
                                        povoaParcela(id_emp);
                                    }
                                }
                            });

                    container.removeAll();
                    container.add(grid);
                    getCpMaster().removeAll();
                    getCpMaster().add(container);
                    getCpMaster().layout();
                    cpParcelas.removeAll();
                    //layout();
                }
            }
        };
        timer.schedule(500);

    }

    public void povoaParcela(int id) {

        parcelaDAO.consultarTodos(id);
        Timer timer = new Timer() {

            public void run() {
                ListStore<Ple_parcelaemprestimoTGWT> list = parcelaDAO.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = cpParcelas.getItems();
                    if (lista.size() > 0) {
                        cpParcelas.removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configsParcelas);

                    Grid<Ple_parcelaemprestimoTGWT> gridbaixa = new Grid<Ple_parcelaemprestimoTGWT>(list, cm);
                    gridbaixa.setLoadMask(true);
                    gridbaixa.setBorders(false);
                    gridbaixa.setAutoExpandColumn("ple_tx_historico");

                    gridbaixa.setStripeRows(true);
                    gridbaixa.setStyleAttribute("borderTop", "none");
                    gridbaixa.setBorders(true);
                    gridbaixa.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    cpParcelas.add(gridbaixa);

                    AggregationRowConfig<Ple_parcelaemprestimoTGWT> rowConfig = new AggregationRowConfig<Ple_parcelaemprestimoTGWT>();
                    rowConfig.setSummaryFormat("ple_nr_valorparcela", format);
                    rowConfig.setSummaryType("ple_nr_valorparcela", SummaryType.SUM);
                    cm.addAggregationRow(rowConfig);
                    cpParcelas.layout();

                }
            }
        };
        timer.schedule(500);
    }

    public void createColumParcela() {

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

        SummaryColumnConfig<Double> cfParcela = new SummaryColumnConfig<Double>("ple_tx_parcela", "Parc.", 40);
        cfParcela.setRenderer(rendererRow);
        SummaryColumnConfig<Double> cfvenc = new SummaryColumnConfig<Double>("ple_dt_vencimento", "Vencimento", 70);
        cfvenc.setRenderer(rendererRow);

        SummaryColumnConfig<Double> cfvalor = new SummaryColumnConfig<Double>("ple_nr_valorparcela", "Valor", 65);
        cfvalor.setAlignment(HorizontalAlignment.RIGHT);

        cfvalor.setRenderer(rendererRow);

        SummaryColumnConfig<Double> cfvalorDesc = new SummaryColumnConfig<Double>("ple_nr_valordesconto", "Desconto", 65);
        cfvalorDesc.setAlignment(HorizontalAlignment.RIGHT);
        cfvalorDesc.setRenderer(rendererRow);

        SummaryColumnConfig<Double> cfvalorObsc = new SummaryColumnConfig<Double>("ple_tx_historico", "Observação", 450);
        SummaryColumnConfig<Double> seqboleto = new SummaryColumnConfig<Double>("ple_nr_seq_boleto", "Seq.", 50);
        SummaryColumnConfig<Double> cfedit = new SummaryColumnConfig<Double>("", "", 30);
        cfedit.setRenderer(getRendereEditValor());

        configsParcelas.add(cfParcela);
        configsParcelas.add(cfvenc);
        configsParcelas.add(cfvalor);
        configsParcelas.add(cfvalorDesc);
        configsParcelas.add(seqboleto);
        configsParcelas.add(cfedit);
        configsParcelas.add(cfvalorObsc);

    }

    public GridCellRenderer<Ple_parcelaemprestimoTGWT> getRendereEditValor() {
        return new GridCellRenderer<Ple_parcelaemprestimoTGWT>() {

            public Object render(final Ple_parcelaemprestimoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Ple_parcelaemprestimoTGWT> store, Grid<Ple_parcelaemprestimoTGWT> grid) {
                Button b = new Button("");
                b.setIcon(Icones.ICONS.edit());

                b.addSelectionListener(new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
//                        if (administrador) {
                        Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT = new Ple_parcelaemprestimoTGWT();
                        ple_parcelaemprestimoT.setEmp_nr_id(model.getEmp_nr_id());
                        ple_parcelaemprestimoT.setPle_dt_vencimento(model.getPle_dt_vencimento());
                        ple_parcelaemprestimoT.setPle_nr_id(model.getPle_nr_id());
                        ple_parcelaemprestimoT.setPle_nr_valorparcela(model.getPle_nr_valorparcela());
                        ple_parcelaemprestimoT.setPle_tx_historico(model.getPle_tx_historico());
                        ple_parcelaemprestimoT.setPle_tx_parcela(model.getPle_tx_parcela());
                        ple_parcelaemprestimoT.setPle_tx_tipo(model.getPle_tx_tipo());
                        ple_parcelaemprestimoT.setPle_nr_id_vinculo(model.getPle_nr_id_vinculo());

                        Ple_parcelaemprestimoUpdateDeleteGWT ple_parcelaemprestimoUpdateDeleteGWT = new Ple_parcelaemprestimoUpdateDeleteGWT();
                        ple_parcelaemprestimoUpdateDeleteGWT.setEmp_emprestimoConsultGWT(Emp_emprestimoConsultGWT.this);
                        ple_parcelaemprestimoUpdateDeleteGWT.load(ple_parcelaemprestimoT, model.getPle_tx_tipo().equalsIgnoreCase("M") ? 0 : 0);
                        ple_parcelaemprestimoUpdateDeleteGWT.show();
//                        }
                    }
                });

                b.setToolTip("Alterar Parcela");
                return b;
            }
        };
    }
}
