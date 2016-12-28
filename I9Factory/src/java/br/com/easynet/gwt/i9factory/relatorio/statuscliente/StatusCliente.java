/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.statuscliente;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Cli_clienteDAO;
import br.com.easynet.gwt.i9factory.dao.Vw_parcelasDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.relatorio.carteira.Carteira;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author topfontes
 */
public class StatusCliente extends RelatorioBase implements INotSecurity {

    private String tipo_parcela;
    private String quitado;

    //http://localhost:8080/i9factory/i9factory/factory/relatorios/statuscliente.jsp?op=imprimir&dtinicio=01/01/2016&dtfim=01/10/2016&tipo=P&quitado=N
    @Override
    public void pageLoad() throws Exception {
        super.pageLoad(); //To change body of generated methods, choose Tools | Templates.
    }

    public void imprimir() {
        try {

            boolean inadimplentes = quitado.equalsIgnoreCase("N");
            Date dtIni = format.parse(getDtInicio());
            Date dtFim = format.parse(getDtFim());

            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            List<Cli_clienteT> list = cli_clienteDAO.getSituacaoFinanceira(new java.sql.Date(dtIni.getTime()), new java.sql.Date(dtFim.getTime()), inadimplentes, getTipo_parcela());
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = StatusCliente.class.getResourceAsStream("statusclientes.jasper");
            } else {
                url = StatusCliente.class.getResource("statusclientes.jasper");
            }
            String titulo = inadimplentes ? "Clientes Inadimplentes no " : "Clientes Adimplentes no ";
            print("StatusClientes", titulo + "Périodo de " + getDtInicio() + " a " + getDtFim());
            System.out.println("Passou...................");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * @return the tipo
     */
    public String getTipo_parcela() {
        return tipo_parcela;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo_parcela(String tipo) {
        this.tipo_parcela = tipo;
    }

    /**
     * @return the quitado
     */
    public String getQuitado() {
        return quitado;
    }

    /**
     * @param quitado the quitado to set
     */
    public void setQuitado(String quitado) {
        this.quitado = quitado;
    }

}
