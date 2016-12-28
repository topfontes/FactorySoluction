/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.i9factory.client.Constantes;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;

import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;

/**
 *
 * @author marcos
 */
public class MalaDireta extends RelatorioBaseGWT {

    private Button button = new Button("Mensagem");
    private Window cpConteudo = new Window();
    private HtmlEditor conteudo = new HtmlEditor();
    private CheckBox chkClientes = new CheckBox();
    private String criteirios;

    public MalaDireta() {
        //getToolBarMaster().add(button);
        chkClientes.setBoxLabel("Clientes com parcelas vencidas e a vencer");
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        //getToolBarMaster().add(chkClientes);
        addBtnFiltrar();
        addBtnExportar();

        FormPanel panel = new FormPanel();
        panel.setLayout(new FillLayout());
        panel.setBorders(false);
        panel.setBodyBorder(false);
        panel.setLabelWidth(55);
        panel.setPadding(5);
        panel.setHeaderVisible(false);
        cpConteudo.add(panel);

        //conteudo.setHideLabel(true);
        cpConteudo.setSize(550, 500);
        cpConteudo.setLayout(new FillLayout());
        panel.add(conteudo);

        button.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                cpConteudo.show();
                //DisplayEmailGWT degwt = new DisplayEmailGWT("", "");
                //degwt.show();
            }
        });
        layout();
    }

    public String getURL() {
        return "i9factory/factory/relatorios/maladireta.jsp?op=imprimir&testo=" + " inserir testo" + criteirios;
    }

    @Override
    public void filtrar() {
        CamposCriteriosGWT camposCriteriosGWT = new CamposCriteriosGWT(this, 1);
        camposCriteriosGWT.show();
    }

    public void filtrarCriterios() {
        String url = Constantes.URL + JSP_VIEW;
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
        com.google.gwt.user.client.Window.alert(url);
        getCpREL().setUrl(url);
    }

    public void exportarPDFCriterios() {
        download(Constantes.URL + getURL() + TIPO_PDF);
    }

    @Override
    public void exportarPDF() {
       CamposCriteriosGWT camposCriteriosGWT = new CamposCriteriosGWT(this, 2);
        camposCriteriosGWT.show();
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL + getURL() + TIPO_XLS);
    }

    /**
     * @return the conteudo
     */
    public HtmlEditor getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(HtmlEditor conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return the criteirios
     */
    public String getCriteirios() {
        return criteirios;
    }

    /**
     * @param criteirios the criteirios to set
     */
    public void setCriteirios(String criteirios) {
        this.criteirios = criteirios;
    }
}
