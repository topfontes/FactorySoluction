/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.i9factory.relatorio.fornecedor;

import br.com.easynet.gwt.i9factory.dao.For_fornecedorDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.For_fornecedorT;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Fornecedor extends RelatorioBase{

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        For_fornecedorDAO cdao = null;
        List<For_fornecedorT> list = new ArrayList<For_fornecedorT>();
        try {
            cdao = getFor_fornecedorDAO();
            list = cdao.getAll();

            jRDataSource = new JRBeanCollectionDataSource(list);
            if(!getTipo().equalsIgnoreCase("XLS")){
                is = Fornecedor.class.getResourceAsStream("fornecedores.jasper");
            }else{
                url = Fornecedor.class.getResource("fornecedores.jasper");
            }
            print("Forcedores", "Relação dos Fornecedores");

        } catch (Exception e) {
        } finally {
            cdao.close();
        }
    }

}
