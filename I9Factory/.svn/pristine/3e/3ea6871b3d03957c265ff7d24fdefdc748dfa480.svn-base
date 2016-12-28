/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.cliente_mas_de_um_orgao;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.relatorio.cliente_por_orgao.Cliente_orgao;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Clientes_mas_de_um_orgao extends RelatorioBase implements INotSecurity{ 

    public Clientes_mas_de_um_orgao() {
        
    }
    
    public void imprimir(){
        try {

            List<Cli_clienteT> list = new ArrayList<Cli_clienteT>();
            list = getCli_clienteDAO().getAllMasDeUmOrgao();
            jRDataSource = new JRBeanCollectionDataSource(list);
            
           jRDataSource = new JRBeanCollectionDataSource(list);
            if(!getTipo().equalsIgnoreCase("XLS")){
                is = Clientes_mas_de_um_orgao.class.getResourceAsStream("cliente_mas_de_um_orgao.jasper");
            }else{
                System.out.println(Clientes_mas_de_um_orgao.class.getResource("cliente_mas_de_um_orgao.jasper").getPath());
                        
                url = Clientes_mas_de_um_orgao.class.getResource("cliente_mas_de_um_orgao.jasper");
            }
            print("ClienteMaisOrgao", "Relação dos Clientes com mas de um orgão");
            
        } catch (Exception e) {
            close();
        }        
    }
    
}
