/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.i9factory.client.Constantes;
import com.extjs.gxt.ui.client.Style;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */
public class Decima_segunda_parcGWT extends RelatorioBaseGWT {

    public Decima_segunda_parcGWT() {
        
        getToolBarMaster().setAlignment(Style.HorizontalAlignment.CENTER);
        addBtnFiltrar();
        addBtnExportar();
        
    }

    public String getURL() {
        return "i9factory/factory/relatorios/decima_segunda_parc.jsp?op=imprimir";
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW;
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
        //Window.alert(url);
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
}
