/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.i9factory.factory.util.ListMes_AnoGWT;
import br.com.i9factory.client.i9factory.factory.util.Meses;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.store.ListStore;


/**
 *
 * @author marcos
 */
public class AniversariantesGWT extends RelatorioBaseGWT{
    private ComboBox<Meses> cbMes = new ComboBox<Meses>();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    
    public AniversariantesGWT() {
        getToolBarMaster().setAlignment(Style.HorizontalAlignment.CENTER);
        addMes();
        addBtnFiltrar();
        addBtnExportar();
    }
    
    public void addMes(){
        getToolBarMaster().add(cbMes);
        cbMes.setDisplayField("display");
        cbMes.setTriggerAction(ComboBox.TriggerAction.ALL);
        cbMes.setEmptyText("Selecione o mês");
        cbMes.setAllowBlank(false);
        ListStore<Meses> store = new ListStore<Meses>();
        store.add(listMes_AnoGWT.getMeses());
        cbMes.setStore(store);
        
    }

    public String getURL() {
        return "i9factory/factory/relatorios/aniversariantes.jsp?op=imprimir&mes="+cbMes.getValue().getValue();
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
