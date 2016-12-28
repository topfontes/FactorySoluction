/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client;

import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;

/**
 *
 * @author geoleite
 */
public class PortalAccordionI9FactoryGWT extends PortalAccordionGWT {

    public PortalAccordionI9FactoryGWT() {
        //tabPanel.add(tiWelcome);
        this(0);
    }

    public PortalAccordionI9FactoryGWT(String urlImageHeader, int altura) {
        super(urlImageHeader, altura);
    }

    public PortalAccordionI9FactoryGWT(int alturaBanner) {
        super(alturaBanner);
        //tabPanel.add(tiWelcome);
        getTabPanel().remove(getTiWelcome());
    }

    public void createMenu() {
        super.createMenu();
        AdminI9FactoryAccordion menuHandler = (AdminI9FactoryAccordion) getMenuHandler().get(0);
        menuHandler.actionEventMenu(null, "I9FACTORY.potlet");
    }
}
