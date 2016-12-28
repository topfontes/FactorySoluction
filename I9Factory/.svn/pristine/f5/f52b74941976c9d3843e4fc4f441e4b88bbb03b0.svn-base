/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.cliente_novos;

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
public class ClientesNovos extends RelatorioBase implements INotSecurity {

    private List<Cli_clienteT> list = new ArrayList<Cli_clienteT>();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {

            Cli_clienteDAO cdao = getCli_clienteDAO();
            list = cdao.getByCli_dt_cadastro(format.parse(getDtInicio()), format.parse(getDtFim()));
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = ClientesNovos.class.getResourceAsStream("clientes.jasper");
            } else {
                url = ClientesNovos.class.getResource("clientes.jasper");
            }

            print("ClienteNovos", "Clientes Novos - Périodo de " + getDtInicio() + " a " + getDtFim());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }


    }
}
