/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easynet.gwt.client.icons.Icones;
import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.i9factory.factory.dao.Cor_corretoraDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Org_orgaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cor_corretoraTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Org_orgaoTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import java.util.Date;

/**
 *
 * @author marcos -3
 */
public class RelatorioBaseGWT extends ContentPanel {

    private Cor_corretoraDAOGWT corDao = new Cor_corretoraDAOGWT();
    private Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();
    private ContentPanel cpMaster = new ContentPanel();
    private ToolBar toolBarMaster = new ToolBar();
    protected Button btnFiltrar = new Button("Visualizar");
    private Button btnExportar = new Button("Exportar");
    private Radio rbPagas = new Radio();
    private Radio rbAPagar = new Radio();
    private RadioGroup radioGroup = new RadioGroup();
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateField dtInicio = new DateField();
    private DateField dtFim = new DateField();
    private ComboBox<Cor_corretoraTGWT> cbCorretor = new ComboBox<Cor_corretoraTGWT>();
    private ComboBox<Org_orgaoTGWT> cbOrgao = new ComboBox<Org_orgaoTGWT>();
    private Menu menu = new Menu();
    private String paramBase;
    public final String TIPO_HTML = "$tipo=PDF";
    public final String TIPO_XLS = "&tipo=XLS";
    public final String TIPO_PDF = "&tipo=PDF";
    public final String JSP_VIEW = "viewer.jsp?url=./";
    public final String JSP_DOWNLOAD = "download.jsp?link=.";
    private MessageBox mb = new MessageBox();
    private ContentPanel cpREL = new ContentPanel(new FillLayout());

    public RelatorioBaseGWT() {

        this.setHeaderVisible(false);
        this.setBodyBorder(false);
        cpREL.setBodyBorder(false);
        cpMaster.setBodyBorder(false);
        cpMaster.setHeaderVisible(false);

        dtInicio.setWidth(90);
        dtFim.setWidth(90);
        dtInicio.getPropertyEditor().setFormat(dtfDate);
        dtFim.getPropertyEditor().setFormat(dtfDate);

        rbAPagar.setBoxLabel("A Pagar");
        rbAPagar.setValue(true);
        rbPagas.setBoxLabel("Pagas");
        radioGroup.add(rbAPagar);
        radioGroup.add(rbPagas);
        cpREL.setHeaderVisible(false);

        setLayout(new FillLayout());

        cpMaster.setHeaderVisible(false);
        FillLayout layout = new FillLayout();
        cpMaster.setLayout(layout);

//        this.setMaximizable(true);
        btnFiltrar.setIcon(br.com.i9factory.client.i9factory.factory.iconsAll.Icones.ICONS.visualizar());
        btnExportar.setIcon(Icones.ICONS.download());
        btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                filtrar();
            }
        });

        cpMaster.setTopComponent(toolBarMaster);
        getCpMaster().add(cpREL);

        montarMenu();
        btnExportar.setMenu(menu);
        add(cpMaster);
        layout();
    }

    @Override
    protected void onShow() {
        super.onShow();
//        maximize();
    }

    public void addStatus() {
        toolBarMaster.add(new LabelToolItem("Status"));
        toolBarMaster.add(getRadioGroup());
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
    }

    public void addPeriodo() {
        toolBarMaster.add(new LabelToolItem("De:"));
        toolBarMaster.add(getDtInicio());
        toolBarMaster.add(new LabelToolItem(" a "));
        toolBarMaster.add(getDtFim());
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
    }

    public void addBtnFiltrar() {
        toolBarMaster.add(btnFiltrar);
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
    }

    public void addCbCorretor() {

        corDao.consultarTodos();
        Timer timer = new Timer() {
            @Override
            public void run() {
                ListStore<Cor_corretoraTGWT> list = corDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    cbCorretor.setEmptyText("Selecione o corretor");
                    cbCorretor.setStore(list);
                    cbCorretor.setDisplayField("cor_tx_nomefantasia");
                    cbCorretor.setTriggerAction(ComboBox.TriggerAction.ALL);
                    cbCorretor.getListView().refresh();

                    toolBarMaster.add(cbCorretor);
                    toolBarMaster.add(new SeparatorToolItem());
                    toolBarMaster.add(new SeparatorToolItem());
                    cbCorretor.setWidth(180);
                    layout();
                }
            }
        };
        timer.schedule(500);

        layout();
    }

    public void addCbOrgao() {

        org_orgaoDAOGWT.consultarTodos();
        Timer timer = new Timer() {
            @Override
            public void run() {
                ListStore<Org_orgaoTGWT> list = org_orgaoDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    getCbOrgao().setEmptyText("Selecione o orgão");
                    getCbOrgao().setStore(list);
                    getCbOrgao().setDisplayField("org_tx_nomefantasia");
                    getCbOrgao().setTriggerAction(ComboBox.TriggerAction.ALL);
                    getCbOrgao().getListView().refresh();

                    toolBarMaster.add(getCbOrgao());
                    toolBarMaster.add(new SeparatorToolItem());
                    toolBarMaster.add(new SeparatorToolItem());
                    getCbOrgao().setWidth(200);
                    layout();
                }
            }
        };
        timer.schedule(500);

        layout();
    }

    public String getParamDate() {
        String dataIni = "01/01/1900";
        String datafim = dtfDate.format(new Date());
        if (getDtInicio().getValue() != null) {
            dataIni = dtfDate.format(getDtInicio().getValue());
        }
        if (getDtFim().getValue() != null) {
            datafim = dtfDate.format(getDtFim().getValue());
        }

        return "&data_inicio=" + dataIni + "&data_fim=" + datafim;
    }

    public String getParamCorretor() {
        String corretor = "0";
        if (cbCorretor.getValue() != null) {
            corretor = cbCorretor.getValue().getCor_nr_id() + "";
        }
        return "&corretor=" + corretor;
    }

    public String getParamOrgao() {
        String orgao = "0";
        if (cbOrgao.getValue() != null) {
            orgao = cbOrgao.getValue().getOrg_nr_id() + "";
        }
        return "&orgao=" + orgao;
    }    
    
    public void addBtnExportar() {
        toolBarMaster.add(getBtnExportar());
        toolBarMaster.add(new SeparatorToolItem());
        toolBarMaster.add(new SeparatorToolItem());
    }

    public void montarMenu() {
        MenuItem itemPDF = new MenuItem("PDF");
        itemPDF.addSelectionListener(new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                exportarPDF();
            }
        });

        MenuItem itemXLS = new MenuItem("XLS");
        itemXLS.addSelectionListener(new SelectionListener<MenuEvent>() {
            @Override
            public void componentSelected(MenuEvent ce) {
                exportarXLS();
            }
        });
        getMenu().add(itemXLS);
        getMenu().add(itemPDF);
    }

    public void filtrar() {
    }

    public void exportarPDF() {
    }

    public void exportarXLS() {
    }

    public void download(String url_download) {
        url_download = url_download.replace("?", "|");
        url_download = url_download.substring(10, url_download.length());
        final String url = url_download.replace("&", ";");
        Timer timer = new Timer() {
            @Override
            public void run() {
                final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                winDownload.setVisible(true);
                winDownload.setHeading("Download do arquivo ");
                LabelField txtDownload = new LabelField("AGUARDE!....");
                winDownload.setUrl(Constantes.URL + JSP_DOWNLOAD + url);
                winDownload.setSize(500, 200);
            }
        };
        timer.schedule(50);// espera 1 segundos para poder exibir a janela para download do arquivo
    }

    /**
     * @return the cpMaster
     */
    public ContentPanel getCpMaster() {
        return cpMaster;
    }

    /**
     * @param cpMaster the cpMaster to set
     */
    public void setCpMaster(ContentPanel cpMaster) {
        this.cpMaster = cpMaster;
    }

    /**
     * @return the toolBarMaster
     */
    public ToolBar getToolBarMaster() {
        return toolBarMaster;
    }

    /**
     * @param toolBarMaster the toolBarMaster to set
     */
    public void setToolBarMaster(ToolBar toolBarMaster) {
        this.toolBarMaster = toolBarMaster;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String convertCaracterURL(String url, String tipo) {
        String newUrl = "";
        if (tipo.equalsIgnoreCase(TIPO_HTML)) {
            newUrl = url.replace("?", "|");
            newUrl = newUrl.replace("&", "$");
        }
        newUrl = newUrl.replace("$$", "$");
        return newUrl;
    }

    /**
     * @param paramBase the paramBase to set
     */
    public void setParamBase(String paramBase) {
        this.paramBase = paramBase;
    }

    /**
     * @return the btnExportar
     */
    public Button getBtnExportar() {
        return btnExportar;
    }

    /**
     * @param btnExportar the btnExportar to set
     */
    public void setBtnExportar(Button btnExportar) {
        this.btnExportar = btnExportar;
    }

    /**
     * @return the radioGroup
     */
    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    /**
     * @param radioGroup the radioGroup to set
     */
    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    /**
     * @param dtfDate the dtfDate to set
     */
    public void setDtfDate(DateTimeFormat dtfDate) {
        this.dtfDate = dtfDate;
    }

    /**
     * @return the dtInicio
     */
    public DateField getDtInicio() {
        return dtInicio;
    }

    /**
     * @param dtInicio the dtInicio to set
     */
    public void setDtInicio(DateField dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return the dtFim
     */
    public DateField getDtFim() {
        return dtFim;
    }

    /**
     * @param dtFim the dtFim to set
     */
    public void setDtFim(DateField dtFim) {
        this.dtFim = dtFim;
    }

    /**
     * @return the dtfDate
     */
    public DateTimeFormat getDtfDate() {
        return dtfDate;
    }

    /**
     * @return the cpREL
     */
    public ContentPanel getCpREL() {
        return cpREL;
    }

    /**
     * @param cpREL the cpREL to set
     */
    public void setCpREL(ContentPanel cpREL) {
        this.cpREL = cpREL;
    }

    /**
     * @return the cbCorretor
     */
    public ComboBox<Cor_corretoraTGWT> getCbCorretor() {
        return cbCorretor;
    }

    /**
     * @param cbCorretor the cbCorretor to set
     */
    public void setCbCorretor(ComboBox<Cor_corretoraTGWT> cbCorretor) {
        this.cbCorretor = cbCorretor;
    }

    /**
     * @return the cbOrgao
     */
    public ComboBox<Org_orgaoTGWT> getCbOrgao() {
        return cbOrgao;
    }

    /**
     * @param cbOrgao the cbOrgao to set
     */
    public void setCbOrgao(ComboBox<Org_orgaoTGWT> cbOrgao) {
        this.cbOrgao = cbOrgao;
    }
}