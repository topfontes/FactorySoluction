/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.cliente_por_orgao;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.relatorio.clientes.Clientes;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Cliente_orgao extends RelatorioBase implements INotSecurity{
    private int org_nr_id ;
    private String nome_orgao;

    public void imprimir() {
        try {

            List<Cli_clienteT> list = new ArrayList<Cli_clienteT>();
            list = getCli_clienteDAO().getAllOrgao(org_nr_id);
            jRDataSource = new JRBeanCollectionDataSource(list);
            
           jRDataSource = new JRBeanCollectionDataSource(list);
            if(!getTipo().equalsIgnoreCase("XLS")){
                is = Cliente_orgao.class.getResourceAsStream("clientes_por_orgao.jasper");
            }else{
                url = Cliente_orgao.class.getResource("clientes_por_orgao.jasper");
            }
            print("ClienteOrgao", "Relação dos Clientes do Orgão "+nome_orgao);
            
        } catch (Exception e) {
            close();
        }

    }

    /**
     * @return the org_nr_id
     */
    public int getOrg_nr_id() {
        return org_nr_id;
    }

    /**
     * @param org_nr_id the org_nr_id to set
     */
    public void setOrg_nr_id(int org_nr_id) {
        this.org_nr_id = org_nr_id;
    }

    /**
     * @return the nome_orgao
     */
    public String getNome_orgao() {
        return nome_orgao;
    }

    /**
     * @param nome_orgao the nome_orgao to set
     */
    public void setNome_orgao(String nome_orgao) {
        this.nome_orgao = nome_orgao;
    }
}
