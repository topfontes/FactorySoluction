/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.i9factory.relatorio.corretor;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Cli_clienteDAO;
import br.com.easynet.gwt.i9factory.dao.Cor_corretoraDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.relatorio.fornecedor.Fornecedor;
import br.com.easynet.gwt.i9factory.transfer.Cor_corretoraT;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */

public class Corretor extends RelatorioBase implements INotSecurity{
    DataSet ds ;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

   public void imprimir() {
        Cor_corretoraDAO cdao = null;
        List<Cor_corretoraT> list = new ArrayList<Cor_corretoraT>();
        try {
            cdao = getCor_corretoraDAO();
            list = cdao.getAll();

            jRDataSource = new JRBeanCollectionDataSource(list);
            if(!getTipo().equalsIgnoreCase("XLS")){
                is = Corretor.class.getResourceAsStream("corretor.jasper");
            }else{
                url = Corretor.class.getResource("corretor.jasper");
            }
            print("Coorretores", "Relação dos Corretores");

        } catch (Exception e) {
        } finally {
            close();
        }
    }

}
