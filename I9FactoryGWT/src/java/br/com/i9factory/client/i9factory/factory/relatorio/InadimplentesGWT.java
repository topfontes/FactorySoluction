/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author marcos
 */

public class InadimplentesGWT extends RelatorioBaseGWT {

    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private Radio rTodos = new Radio();
    private Radio rMen = new Radio();
    private Radio rPar = new Radio();
    private RadioGroup rgStatus = new RadioGroup();

    public InadimplentesGWT() {
        getToolBarMaster().setAlignment(HorizontalAlignment.CENTER);
        addPeriodo();
        addRadio();
        addCbCorretor();
        addCbOrgao();

        Timer timer = new Timer() {
            @Override
            public void run() {
                if (getCbOrgao().getStore() == null || getCbCorretor().getStore() == null) {
                    schedule(100);
                } else {
                    addBtnFiltrar();
                    addBtnExportar();
                    layout();

                }
            }
        };
        timer.schedule(10);
    }
    public void addRadio(){
        rTodos.setBoxLabel("Todos");
        rPar.setBoxLabel("Parcelas");
        rMen.setBoxLabel("Mensalidades");
        rgStatus.add(rTodos);
        rgStatus.add(rPar);
        rgStatus.add(rMen);
        rgStatus.setValue(rTodos);
        rTodos.setValue(true);
        getToolBarMaster().add(rgStatus);
    }
    
    public String getValueStatus(){
        String status ="";
        if(rgStatus.getValue() == rTodos){
            status ="&ple_tx_tipo=T";
        }else if(rgStatus.getValue() == rPar){
            status="&ple_tx_tipo=P";
        }else{
            status = "&ple_tx_tipo=M";
        }
        return status;
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
        download(Constantes.URL + getURL() + TIPO_PDF + getValueStatus());
    }

    @Override
    public void exportarXLS() {
        download(Constantes.URL + getURL() + TIPO_XLS + getValueStatus());
    }

    public String getURL() {
        return "i9factory/factory/relatorios/inadiplentes.jsp?op=imprimir" + getParamDate() + getParamCorretor()+getParamOrgao()+getValueStatus();
    }
}
