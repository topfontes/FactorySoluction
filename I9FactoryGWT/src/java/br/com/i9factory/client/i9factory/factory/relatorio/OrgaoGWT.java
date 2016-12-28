/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;

/**
 *
 * @author marcos
 */
public class OrgaoGWT extends br.com.i9factory.client.i9factory.factory.relatorio.RelatorioBaseGWT{

    public OrgaoGWT() {
        getToolBarMaster().setAlignment(HorizontalAlignment.CENTER);
        addBtnFiltrar();
        addBtnExportar();
    }
    
    public String getURL() {
        return "i9factory/factory/relatorios/orgao.jsp?op=imprimir";
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
