/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 *
 * @author marcos
 */
public class CarteiraGWT extends RelatorioBaseGWT {

    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");

    public CarteiraGWT() {
        addPeriodo();
        addBtnFiltrar();
        addBtnExportar();
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW ;
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
        return "i9factory/factory/relatorios/carteira.jsp?op=imprimir&dtInicio=" + dtfDate.format(getDtInicio().getValue()) + "&dtFim=" + dtfDate.format(getDtFim().getValue());
    }
}
