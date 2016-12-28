/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.aniversariantes;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.i9factory.dao.Emp_emprestimoDAO;
import br.com.easynet.gwt.i9factory.jb.Funcoes;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.relatorio.comissao.Comissao;
import br.com.easynet.gwt.i9factory.tmp.ComissaoTMP;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import br.com.easynet.gwt.i9factory.transfer.Emp_emprestimoT;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Aniversariantes extends RelatorioBase {

    private List<Cli_clienteT> list = new ArrayList<Cli_clienteT>();
    SimpleDateFormat format = new SimpleDateFormat("MM");
    private int mes;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() throws Exception {
        try {
            
            list = getCli_clienteDAO().getAniversariantes(mes);

            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Aniversariantes.class.getResourceAsStream("aniversariantes.jasper");
            } else {
                url = Aniversariantes.class.getResource("aniversariantes.jasper");
            }

            String strmes = getMes(mes);
            getParameters().put("pathmarcadagua", application.getRealPath("/images/logomarca.jpg"));
            print("aniversariantes-" + strmes, "Aniversariantes do mês de " + strmes);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getMes(int mes) {
        String strmes = "";
        switch (mes) {
            case 1:
                strmes = "Janeiro";
                break;
            case 2:
                strmes = "Fevereiro";
                break;
            case 3:
                strmes = "Março";
                break;
            case 4:
                strmes = "Abril";
                break;
            case 5:
                strmes = "Maio";
                break;
            case 6:
                strmes = "Junho";
                break;
            case 7:
                strmes = "Julho";
                break;
            case 8:
                strmes = "Agosto";
                break;
            case 9:
                strmes = "Setembro";
                break;
            case 10:
                strmes = "Outubro";
                break;
            case 11:
                strmes = "Novembro";
                break;
            case 12:
                strmes = "Dezembro";
                break;
        }
        return strmes;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
}
