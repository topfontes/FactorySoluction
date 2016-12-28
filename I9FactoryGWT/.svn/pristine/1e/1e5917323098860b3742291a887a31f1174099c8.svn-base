/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class Clientes_dois_orgaos extends RelatorioBaseGWT{

    public Clientes_dois_orgaos() {
        getToolBarMaster().setAlignment(Style.HorizontalAlignment.CENTER);
        addBtnFiltrar();
        addBtnExportar();
    }
    
    
   @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW;
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
        //Window.alert(url);
        getCpREL().setUrl(url);
        getCpREL().layout();
        layout();
    }
    

    @Override
    public void exportarPDF() {
        download(Constantes.URL + getURL() + TIPO_PDF);
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL + getURL() + TIPO_XLS );
    }

    public String getURL() {
        return "i9factory/factory/relatorios/cliente_dois_orgaos.jsp?op=imprimir";
    }

}
