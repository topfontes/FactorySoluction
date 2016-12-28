/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client;

import br.com.i9factory.client.i9factory.factory.relatorio.RelatorioBaseGWT;
import com.extjs.gxt.ui.client.Style;

/**
 *
 * @author marcos
 */
public class DecimaSegundparcelaGWT extends RelatorioBaseGWT{

    public DecimaSegundparcelaGWT() {
        getToolBarMaster().setAlignment(Style.HorizontalAlignment.CENTER);
        addBtnFiltrar();
        addBtnExportar();
        layout();
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
