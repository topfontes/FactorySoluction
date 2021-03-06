/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.clientes_idade_acima;

import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import java.util.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.text.SimpleDateFormat;

/**
 *
 * @author marcoa
 */
public class ClientesIdadeAcima extends RelatorioBase {

    private int idade;

    public void imprimir() {
        try {

            List<Cli_clienteT> list = new ArrayList();
            list = getCli_clienteDAO().getClienteIdadeAcima(idade);
            
            getcalIdade(list);
            
            
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = ClientesIdadeAcima.class.getResourceAsStream("clientes_idade_acima.jasper");
            } else {
                url = ClientesIdadeAcima.class.getResource("clientes_idade_acima.jasper");
            }

            print("Clientes acima de "+idade, "Clientes Acima de " + idade+" anos");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    private void getcalIdade(List<Cli_clienteT> list) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        int ano_nasc;
        int ano_atual = Integer.parseInt(format.format(new Date()));
        for (Cli_clienteT cli : list) {
          ano_nasc = Integer.parseInt(format.format(cli.getCli_dt_nascimento()));    
          cli.setCli_tx_ramal((ano_atual - ano_nasc)+"");
        }
    }

}
