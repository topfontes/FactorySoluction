/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client;

import br.com.easyportal.gwt.client.webModel.AMenuHandler;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class AdminI9FactoryWeb extends AMenuHandler {

    private HashMap<String, TabItem> itens = new HashMap<String, TabItem>();

    public AdminI9FactoryWeb() {
        setSystem("I9FACTORY");
    }

    public void actionEventMenu(Object me, String acao, String teste) {
        TabItem tabItem = null;
        tabItem = itens.get(acao);
        if (tabItem == null) {
            tabItem = new TabItem();
            tabItem.setClosable(true);
            tabItem.setLayout(new FitLayout());
            ContentPanel cp = new ContentPanel();
            cp.setFrame(false);
            cp.setBorders(false);
            cp.setHeaderVisible(false);
            cp.setBodyBorder(false);
            cp.setLayout(new FitLayout());
            if ("I9FACTORY.tela".equalsIgnoreCase(acao)) {
                tabItem.setText("Setores");
                cp.add(getSetores());
            } else {
                MessageBox.alert("Opcão ainda não implementada", "Em breve esta opção estará disponível!", null);
            }
            tabItem.add(cp);
            //Adiciona o tabitem se não existir no tabPanel
            getPortalWebGWT().getTabPanel().add(tabItem);
            itens.put(acao, tabItem);
        } else {
            TabItem tabTemp = getPortalWebGWT().getTabPanel().getItemByItemId(acao);
            if (tabTemp == null) {
                getPortalWebGWT().getTabPanel().add(tabItem);
            }
        }
        getPortalWebGWT().getTabPanel().setSelection(tabItem);
        getPortalWebGWT().layout();
    }

    private ContentPanel getSetores() {
        return null;
    }

    @Override
    public void actionEventMenu(Object me, String acao) {
        actionEventMenu(me,acao,"");
    }
}
