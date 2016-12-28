/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.ui.Label;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;

/**
 *
 * @author marcoas
 */
public class ClientesIdadesAcimaGWT extends RelatorioBaseGWT {

    private NumberField idade = new NumberField();

    public ClientesIdadesAcimaGWT() {
        
        idade.setWidth(50);
        
        getToolBarMaster().setAlignment(Style.HorizontalAlignment.CENTER);
        getToolBarMaster().add(new LabelToolItem("Clientes com idade acima de :"));
        getToolBarMaster().add(idade);
        addBtnFiltrar();
        addBtnExportar();
        layout();
      
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
        return "i9factory/factory/relatorios/clientes_idade_acima.jsp?op=imprimir&idade=" + idade.getValue().intValue();
    }

}
