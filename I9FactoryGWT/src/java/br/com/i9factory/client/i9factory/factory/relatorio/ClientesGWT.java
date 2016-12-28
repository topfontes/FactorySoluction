/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */
public class ClientesGWT extends br.com.i9factory.client.i9factory.factory.relatorio.RelatorioBaseGWT {

    public ClientesGWT() {
        getToolBarMaster().setAlignment(HorizontalAlignment.CENTER);
        
        //addCbCorretor();

//        Timer timer = new Timer() {
//            @Override
//            public void run() {
//                if (getCbCorretor().getStore() == null) {
//                    schedule(100);
//                } else {
                    addBtnFiltrar();
                    addBtnExportar();
                    layout();
                    //getCbCorretor().setVisible(false);

//                }
//            }
//        };
//        timer.schedule(10);        
        
///i9factory/viewer.jsp?url=./i9factory/factory/relatorios/clientes.jsp|op=imprimir$tipo=PDF


    } 

    public String getURL() {
        return "i9factory/factory/relatorios/clientes.jsp?op=imprimir"+getParamCorretor();
    }

    @Override
    public void filtrar() {
        String url = Constantes.URL + JSP_VIEW ;
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
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
        download(Constantes.URL + getURL() + TIPO_XLS);
    }
}
