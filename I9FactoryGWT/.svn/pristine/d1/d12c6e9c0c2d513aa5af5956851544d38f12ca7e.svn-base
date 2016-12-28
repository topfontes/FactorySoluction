/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.i9factory.client.Constantes;
import com.extjs.gxt.ui.client.Style;

/**
 *
 * @author marcos
 */
public class AniversariantesGWT1 extends RelatorioBaseGWT{
    
    public AniversariantesGWT1() {
        getToolBarMaster().setAlignment(Style.HorizontalAlignment.CENTER);
        addBtnFiltrar();
        addBtnExportar();
    }

    public String getURL() {
        return "i9factory/factory/relatorios/aniversariantes.jsp?op=imprimir";
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
