/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.carteira;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Vw_parcelasDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Vw_parcelasT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Carteira extends RelatorioBase implements INotSecurity{

    private List<Vw_parcelasT> list = new ArrayList<Vw_parcelasT>();
    private Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    } 

    public void imprimir() {
        try {
            Vw_parcelasDAO vdao = getVw_parcelasDAO();
            list = vdao.getAll(format.parse(getDtInicio()), format.parse(getDtFim()), "P", 0);
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Carteira.class.getResourceAsStream("carteira.jasper");
            } else {
                url = Carteira.class.getResource("carteira.jasper");
            }

            print("Carteira", "Carteira -  Périodo de " + getDtInicio() + " a " + getDtFim());
            System.out.println("Passou...................");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }


    }

    /**
     * @return the list
     */
    public List<Vw_parcelasT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Vw_parcelasT> list) {
        this.list = list;
    }

    /**
     * @return the vw_parcelasT
     */
    public Vw_parcelasT getVw_parcelasT() {
        return vw_parcelasT;
    }

    /**
     * @param vw_parcelasT the vw_parcelasT to set
     */
    public void setVw_parcelasT(Vw_parcelasT vw_parcelasT) {
        this.vw_parcelasT = vw_parcelasT;
    }
}
