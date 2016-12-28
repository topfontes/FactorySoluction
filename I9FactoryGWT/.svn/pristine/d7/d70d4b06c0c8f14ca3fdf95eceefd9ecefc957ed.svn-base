/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import br.com.i9factory.client.i9factory.factory.dao.Cli_clienteDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class SeguroMensalidadeGWT extends RelatorioBaseGWT {

    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private RadioGroup radio = new RadioGroup();
    private RadioGroup radioStatus = new RadioGroup();
    private Radio rdAberto = new Radio();
    private Radio rdQuitado = new Radio();
    private ComboBox<Cli_clienteTGWT> combo = new ComboBox<Cli_clienteTGWT>();
    private TextField<String> tfFindCliente = new TextField<String>();
    private Cli_clienteDAOGWT cli_clienteDAOGWT = new Cli_clienteDAOGWT();

    public SeguroMensalidadeGWT() {
        addPeriodo();
        addRadio();
        addFindCli();
        addCombo();
        addBtnFiltrar();
        addBtnExportar();
    }

    public void addFindCli() {
        tfFindCliente.setEmptyText("Cliente");
        tfFindCliente.setToolTip("Para pesquisar pressione 'Enter'.");
        tfFindCliente.setWidth(80);
        KeyListener kl = new KeyListener() {
            public void componentKeyUp(ComponentEvent event) {
                if (event.getKeyCode() == 13) {
                    loadClientes();
                }
            }
        };
        tfFindCliente.addKeyListener(kl);
        getToolBarMaster().add(tfFindCliente);
    }
    
    public void loadClientes() {
        cli_clienteDAOGWT.consultByNome(tfFindCliente.getValue());
        combo.setValue(null);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Cli_clienteTGWT> list = cli_clienteDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    combo.setStore(list);
                    combo.getView().refresh();
                    if (list.getCount() == 1) {
                        combo.setValue(list.getAt(0));
                    }
                }
            }
        };
        timer.schedule(500);
    }
    

    public void addCombo() {
        combo.setWidth(200);
        combo.setDisplayField("cli_tx_nome");
//        combo.setItemSelector("div.search-item");
//        combo.setTemplate(getTemplate());        
        combo.setTriggerAction(ComboBox.TriggerAction.ALL);
        //combo.setHideTrigger(true);
        //combo.setPageSize(10);
        combo.setAllowBlank(true);
        getToolBarMaster().add(combo);
        layout();
    }

    public void addRadio() {
        Radio todos = new Radio();
        todos.setBoxLabel("Todos");
        todos.setValue(true);

        Radio seguro = new Radio();
        seguro.setBoxLabel("Mensalidades");


        Radio mensalidade = new Radio();
        mensalidade.setBoxLabel("Parcelas");

        radio.add(todos);
        radio.add(seguro);
        radio.add(mensalidade);
        getToolBarMaster().add(radio);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());

        getToolBarMaster().add(new LabelToolItem("Status:"));
        getToolBarMaster().add(new SeparatorToolItem());
        rdAberto.setBoxLabel("A pagar");
        rdQuitado.setBoxLabel("Pagos");
        radioStatus.add(rdAberto);
        radioStatus.add(rdQuitado);
        radioStatus.setValue(rdAberto);
        getToolBarMaster().add(radioStatus);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());


    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW;
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
        getCpREL().setUrl(url);
    }

    @Override
    public void exportarPDF() {
        download(Constantes.URL + getURL() + TIPO_PDF);
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL + getURL() + TIPO_XLS);
    }

    public String getURL() {
        String cli = "";
        if (combo.getValue()!= null){
            cli="&cli_nr_id="+combo.getValue().getCli_nr_id();
        }
        
        String param = "&tx_tipo=";
        param += radio.getValue().getBoxLabel().equals("Todos") ? "T" : radio.getValue().getBoxLabel().equals("Mensalidades") ? "M" : "P";
        String status = radioStatus.getValue() == rdAberto ? "A" : "P";
        param += "&status=" + status;
        param +=cli;
        return "i9factory/factory/relatorios/seguros_mensalidades.jsp?op=imprimir&dtInicio=" + dtfDate.format(getDtInicio().getValue()) + "&dtFim=" + dtfDate.format(getDtFim().getValue()) + param;
    }
}
