/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.easyportal.gwt.client.Constantes;
import br.com.i9factory.client.i9factory.factory.dao.Org_orgaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Org_orgaoTGWT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author marcos
 */
public class Clientes_orgaos extends RelatorioBaseGWT {

    private Org_orgaoDAOGWT org_orgaoDAOGWT = new Org_orgaoDAOGWT();
    private ComboBox<Org_orgaoTGWT> comboOrgao = new ComboBox<Org_orgaoTGWT>();

    public Clientes_orgaos() {
        getToolBarMaster().setAlignment(Style.HorizontalAlignment.CENTER);
        org_orgaoDAOGWT.consultarTodos();

        getOrgaos();
    }

    public void getOrgaos() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (org_orgaoDAOGWT.getList() == null) {
                    schedule(500);
                } else {
                    comboOrgao.setDisplayField("org_tx_nomefantasia");
                    comboOrgao.setAllowBlank(false);
                    comboOrgao.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboOrgao.setWidth(250);
                    comboOrgao.setStore(org_orgaoDAOGWT.getList());
                    comboOrgao.getView().refresh();
                    getToolBarMaster().add(comboOrgao);
                    addBtnFiltrar();
                    addBtnExportar();
                    layout();
                }
            }
        };
        timer.schedule(500);
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
        download(Constantes.URL + getURL() + TIPO_XLS);
    }

    public String getURL() {
        return "i9factory/factory/relatorios/cliente_orgao.jsp?op=imprimir" + getParamorOrgao();
    }

    public String getParamorOrgao() {
        String orgao = comboOrgao.getValue().getOrg_nr_id() + "";
        return "&org_nr_id=" + orgao + "&nome_orgao=" + comboOrgao.getValue().getOrg_tx_nomefantasia();
    }
}
