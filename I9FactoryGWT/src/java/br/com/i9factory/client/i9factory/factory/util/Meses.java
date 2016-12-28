/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9factory.client.i9factory.factory.util;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 *
 * @author marcos
 */


public class Meses extends BaseModel {
    
    public void setValue(int value){
        set("value", value);
    }
    public int getValue(){
        return ((Integer)get("value")).intValue();
    }
    public void setDisplay(String display){
        set("display", display);
    }

    public String getDisplay(){
        return get("display");
    }

}
