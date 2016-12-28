/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.i9factory.factory.dao.For_fornecedorDAOGWT;
import br.com.i9factory.client.i9factory.factory.dao.Tid_tipo_despesaDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.For_fornecedorTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Tid_tipo_despesaTGWT;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboValue;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class ContaAPagar_PagasRelGWT extends RelatorioBaseGWT {

    private SimpleComboBox<String> comboAgrupamento = new SimpleComboBox<String>();
    private ComboBox<For_fornecedorTGWT> comboFor = new ComboBox<For_fornecedorTGWT>();
    private ComboBox<Tid_tipo_despesaTGWT> comboTid = new ComboBox<Tid_tipo_despesaTGWT>();
    private For_fornecedorDAOGWT for_fornecedorDAOGWT = new For_fornecedorDAOGWT();
    private Tid_tipo_despesaDAOGWT tid_tipo_despesaDAOGWT = new Tid_tipo_despesaDAOGWT();
    private ListStore<For_fornecedorTGWT> listFor = new ListStore<For_fornecedorTGWT>();
    private ListStore<Tid_tipo_despesaTGWT> listTid = new ListStore<Tid_tipo_despesaTGWT>();
    ContentPanel cp = new ContentPanel();
    private String agrupamento ;

    public ContaAPagar_PagasRelGWT() {
        for_fornecedorDAOGWT.consultarTodos();
        tid_tipo_despesaDAOGWT.consultarTodos();
        cp.setSize(250, 22);
        cp.setLayout(new FillLayout());
        cp.add(new LabelField("          Todos os Títulos"));
        cp.setHeaderVisible(false);
        agrupamento="G";

        //cp.setBodyBorder(false);
        //cp.setFrame(true);

        comboAgrupamento.addSelectionChangedListener(new SelectionChangedListener<SimpleComboValue<String>>() {

            @Override
            public void selectionChanged(SelectionChangedEvent<SimpleComboValue<String>> se) {
                if (se.getSelection().get(0).getValue().equalsIgnoreCase("Geral")) {
                    cp.removeAll();
                    cp.add(new LabelField("         Todos os Títulos"));
                    comboFor.setValue(null);
                    comboTid.setValue(null);
                } else if (se.getSelection().get(0).getValue().equalsIgnoreCase("Fornecedor")) {
                    cp.removeAll();
                    cp.add(comboFor);
                    agrupamento ="F";
                    comboTid.setValue(null);
                    layout();
                } else {
                    cp.removeAll();
                    cp.add(comboTid);
                    agrupamento ="D";
                    comboTid.setValue(null);
                    layout();
                }
                cp.layout();
            }
        });
        montarTela();
    }
    public void addComboFor(){
        comboFor.setStore(listFor);
        comboFor.setDisplayField("for_tx_nome");
        comboFor.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void addComboTid(){
        comboTid.setStore(listTid);
        comboTid.setDisplayField("tid_tx_nome");
        comboTid.setTriggerAction(ComboBox.TriggerAction.ALL);
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                listFor = for_fornecedorDAOGWT.getList();
                listTid = tid_tipo_despesaDAOGWT.getList();
                if (listFor == null || listTid == null) {
                    schedule(500);
                } else {

                    addStatus();
                    addPeriodo();

                    List<String> list = new Vector<String>();
                    list.add("Geral");
                    list.add("Fornecedor");
                    list.add("Tipo Despesa");

                    comboAgrupamento.add(list);
                    comboAgrupamento.setTriggerAction(ComboBox.TriggerAction.ALL);

                    getToolBarMaster().add(new LabelField("Agrupamento"));
                    getToolBarMaster().add(comboAgrupamento);
                    comboAgrupamento.setWidth(120);
                    getToolBarMaster().add(comboAgrupamento);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());

                    addComboFor();
                    addComboTid();
                    
                    getToolBarMaster().add(cp);
                    getToolBarMaster().add(new SeparatorToolItem());
                    getToolBarMaster().add(new SeparatorToolItem());
                    addBtnFiltrar();
                    addBtnExportar();
                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public String getURL() {

        String filtro="";
        if(!agrupamento.equalsIgnoreCase("G")){
            if(comboFor.getValue() != null){
                filtro ="&id_fornecedor"+comboFor.getValue().getFor_nr_id();
            }else{
                if(comboTid.getValue()!= null){
                    filtro = "&id_tipoDesp"+comboTid.getValue().getTid_nr_id();
                }
            }
        }

        String status = getRadioGroup().getValue().getBoxLabel().equalsIgnoreCase("Pagas") ? "T" : "F";
        String dtIni = getDtfDate().format(getDtInicio().getValue());
        String dtFin = getDtfDate().format(getDtFim().getValue());

        return "i9factory/factory/relatorios/contaAPagar_Pagas.jsp?op=imprimir&status=" + status + "&dtInicio=" + dtIni + "&dtFim=" + dtFin + "&agrupamento=" + agrupamento+filtro;
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
        download(Constantes.URL+getURL()+TIPO_PDF);
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL+getURL()+TIPO_XLS);
    }
    
}
