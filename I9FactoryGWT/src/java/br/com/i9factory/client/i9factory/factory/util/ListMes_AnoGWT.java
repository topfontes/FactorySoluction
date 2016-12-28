/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9factory.client.i9factory.factory.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class ListMes_AnoGWT {

    private List<Meses> meses;
    private TreeMap<Integer,Meses> treeMeses = new TreeMap<Integer, Meses>();

    public ListMes_AnoGWT() {
        meses = new ArrayList<Meses>();
        for (int i = 1; i < 13; i++) {
            Meses mes = new Meses();
            switch(i){
                case 1:mes.setValue(i); mes.setDisplay("Janeiro");break;
                case 2:mes.setValue(i); mes.setDisplay("Fevereiro");break;
                case 3:mes.setValue(i); mes.setDisplay("Março");break;
                case 4:mes.setValue(i); mes.setDisplay("Abril");break;
                case 5:mes.setValue(i); mes.setDisplay("Maio");break;
                case 6:mes.setValue(i); mes.setDisplay("Junho");break;
                case 7:mes.setValue(i); mes.setDisplay("Julho");break;
                case 8:mes.setValue(i); mes.setDisplay("Agosto");break;
                case 9:mes.setValue(i); mes.setDisplay("Setembro");break;
                case 10:mes.setValue(i); mes.setDisplay("Outubro");break;
                case 11:mes.setValue(i); mes.setDisplay("Novembro");break;
                case 12:mes.setValue(i); mes.setDisplay("Dezembro");break;
            }
            meses.add(mes);
            treeMeses.put(mes.getValue(), mes);
        }

    }

    /**
     * @return the meses
     */
    public List<Meses> getMeses() {
        return meses;
    }

    /**
     * @param meses the meses to set
     */
    public void setMeses(List<Meses> meses) {
        this.meses = meses;
    }


    /**
     * @return the treeMeses
     */
    public TreeMap<Integer, Meses> getTreeMeses() {
        return treeMeses;
    }

    /**
     * @param treeMeses the treeMeses to set
     */
    public void setTreeMeses(TreeMap<Integer, Meses> treeMeses) {
        this.treeMeses = treeMeses;
    }


}
