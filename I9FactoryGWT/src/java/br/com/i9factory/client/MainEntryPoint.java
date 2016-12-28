/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easyportal.gwt.client.AuthenticationGWT;
import br.com.easyportal.gwt.client.accordionModel.PortalAccordionGWT;
import br.com.i9.portal.client.AdminPortalAccordion;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

/**
 * Main entry point.
 *
 * @author geoleite
 */
public class MainEntryPoint implements EntryPoint {
    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
        
    }

    /** 
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */

    public void onModuleLoad() {
        EasyAccessURL.setNrMaxTentativas(0);
        EasyAccessURL.setTimeMaxWait(100000000);
        
/*
        br.com.easyportal.gwt.client.Constantes.URL = Constantes.URL;
        AdminHandCopyAccordion adminMenuAccordion = new AdminHandCopyAccordion();
        
        PortalAccordionGWT portal = new PortalAccordionHandCopyGWT(70);
        portal.checkSession(1800000);//10 minutos
        portal.addMenuHandler(adminMenuAccordion);
        AuthenticationGWT authentication = new AuthenticationGWT();
        authentication.setPortal(portal);
        authentication.setVisible(true);
        portal.setHeight(portal.getHeight() - 60);
 */

//98469540

        br.com.easyportal.gwt.client.Constantes.URL = Constantes.URL;
        br.com.i9.portal.client.Constantes.URL = Constantes.URL;

        AdminPortalAccordion adminMenuPortal = new AdminPortalAccordion();
        AdminI9FactoryAccordion adminMenu = new AdminI9FactoryAccordion();
        PortalAccordionGWT portal = new PortalAccordionI9FactoryGWT("images/topo.png", 30);
        //portal.checkSession(5500001);//10 minutos

        portal.addMenuHandler(adminMenu);
        portal.addMenuHandler(adminMenuPortal);
        AuthenticationGWT authentication = new AuthenticationGWT();
        authentication.setPortal(portal);
        authentication.setVisible(true);

//        portal.setHeight(portal.getHeight() - 60);
    }
}
