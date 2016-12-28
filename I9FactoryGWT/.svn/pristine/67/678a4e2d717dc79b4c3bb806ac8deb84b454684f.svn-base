/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import java.util.TreeMap;

/**
 * 99510546
 * @author marcos 
 */
public class ListTipoLogradouroGWT {
    private ListStore<TipoLogradouroTGWT> list ;
    private TreeMap<String, TipoLogradouroTGWT> tree;

    public ListTipoLogradouroGWT() {
        tree  = new TreeMap<String, TipoLogradouroTGWT>();
        list = new ListStore<TipoLogradouroTGWT>();
        
        TipoLogradouroTGWT tipo = new TipoLogradouroTGWT();
        tipo.setValue("Rua");
        tipo.setDisplay("Rua");
        list.add(tipo);
        tree.put("Rua", tipo);

        tipo = new TipoLogradouroTGWT();
        tipo.setValue("Avenida");
        tipo.setDisplay("Avenida");
        list.add(tipo);
        tree.put("Avenida", tipo);

        tipo = new TipoLogradouroTGWT();
        tipo.setValue("Travessa");
        tipo.setDisplay("Travessa");
        list.add(tipo);
        tree.put("Travessa", tipo);

        tipo = new TipoLogradouroTGWT();
        tipo.setValue("Largo");
        tipo.setDisplay("Largo");
        list.add(tipo);
        tree.put("Largo", tipo);
    }

    /**
     * @return the list
     */
    public ListStore<TipoLogradouroTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ListStore<TipoLogradouroTGWT> list) {
        this.list = list;
    }

    /**
     * @return the tree
     */
    public TreeMap<String, TipoLogradouroTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<String, TipoLogradouroTGWT> tree) {
        this.tree = tree;
    }
}
