/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.clientes;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Cli_clienteDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Clientes extends RelatorioBase implements INotSecurity{

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        Cli_clienteDAO cdao = null;
        List<Cli_clienteT> list = new ArrayList<Cli_clienteT>();
        try {
            cdao = getCli_clienteDAO();
            list = cdao.getAllRelCLi();

            jRDataSource = new JRBeanCollectionDataSource(list);
            if(!getTipo().equalsIgnoreCase("XLS")){
                is = Clientes.class.getResourceAsStream("clientes.jasper");
            }else{
                url = Clientes.class.getResource("clientes.jasper");
            }
            getParameters().put("totalItens", list.size());
            print("Cliente", "Relação dos Clientes");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
