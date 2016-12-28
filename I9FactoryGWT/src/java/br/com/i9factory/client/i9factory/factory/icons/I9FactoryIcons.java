/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9factory.client.i9factory.factory.icons;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;

/**
 *
 * @author geoleite
 */
public interface I9FactoryIcons extends ImageBundle {
    
    @Resource("raio.png")
    AbstractImagePrototype raio();

    @Resource("checkall.png")
    AbstractImagePrototype checkall();

    @Resource("excluir.png")
    AbstractImagePrototype excluir();

    @Resource("visualizar.png")
    AbstractImagePrototype visualizar();

}
