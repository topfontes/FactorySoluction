/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.emp_emprestimo;

import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.i9factory.factory.relatorio.RelatorioBaseGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Emp_emprestimoTGWT;
import com.extjs.gxt.ui.client.widget.Window;

/**
 *
 * @author marcoa
 */
public class PrintEmprestimoGWT extends RelatorioBaseGWT {
    private Emp_emprestimoTGWT emp_emprestimoTGWT;

    public PrintEmprestimoGWT(Emp_emprestimoTGWT emp_emprestimoTGWT) {
        this.emp_emprestimoTGWT = emp_emprestimoTGWT;
        //filtrar();
    }
    

    public String getURL() {
        return "i9factory/factory/relatorios/print_emprestimo.jsp?op=imprimir&emp_emprestimoT.emp_nr_id=" + this.emp_emprestimoTGWT.getEmp_nr_id();
    }

    @Override
    public void filtrar() {
        String url = br.com.easyportal.gwt.client.Constantes.URL + JSP_VIEW;
        url += convertCaracterURL(getURL(), TIPO_HTML);
        url += TIPO_HTML;
        //com.google.gwt.user.client.Window.alert(url);
        getCpREL().setUrl(url);
    }


}
