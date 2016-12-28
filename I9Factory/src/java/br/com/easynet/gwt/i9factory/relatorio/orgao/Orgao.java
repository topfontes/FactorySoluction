/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.i9factory.relatorio.orgao;

import br.com.easynet.gwt.i9factory.dao.Org_orgaoDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Org_orgaoT;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Orgao extends RelatorioBase{

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }
    public void imprimir() {
        Org_orgaoDAO cdao = null;
        List<Org_orgaoT> list = new ArrayList<Org_orgaoT>();
        try {
            cdao = getOrg_orgaoDAO();
            list = cdao.getAll();

            jRDataSource = new JRBeanCollectionDataSource(list);
            if(!getTipo().equalsIgnoreCase("XLS")){
                is = Orgao.class.getResourceAsStream("orgaos.jasper");
            }else{
                url = Orgao.class.getResource("orgaos.jasper");
            }
            print("Orgao", "Relação dos Orgãos");

        } catch (Exception e) {
        } finally {
            close();
        }
    }


}
