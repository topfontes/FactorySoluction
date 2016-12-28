/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.inadimplentes;

import br.com.easynet.gwt.i9factory.dao.Vw_parcelasDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Vw_parcelasT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Inadiplentes extends RelatorioBase {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private List<Vw_parcelasT> list = new ArrayList<Vw_parcelasT>();
    private String data_inicio;
    private String data_fim;
    private int corretor;
    private int orgao;
    private String ple_tx_tipo;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
            String tipo = "";
            if (ple_tx_tipo.equalsIgnoreCase("P")) {
                tipo = " ple_tx_tipo ='P' and ";
            } else if (ple_tx_tipo.equalsIgnoreCase("M")) {
                tipo = " ple_tx_tipo ='M' and ";
            }
            Vw_parcelasDAO vw_parcelasDAO = getVw_parcelasDAO();
            list = vw_parcelasDAO.getAllWithCorretor(format.parse(data_inicio), format.parse(data_fim), "A", 0, corretor, tipo, orgao);
            jRDataSource = new JRBeanCollectionDataSource(list);

            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Inadiplentes.class.getResourceAsStream("inadiplentes.jasper");
            } else {
                url = Inadiplentes.class.getResource("inadiplentes.jasper");
            }

            if (orgao > 0 & list.size() > 0) {
                String orgaoStr = "";
                getParameters().put("orgao", list.get(0).getOrg_tx_nome());
            }
            print("ClienteInadimplentes", "Clientes Inadimplentes - Périodo de " + data_inicio + " a " + data_fim);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    /**
     * @return the data_inicio
     */
    public String getData_inicio() {
        return data_inicio;
    }

    /**
     * @param data_inicio the data_inicio to set
     */
    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * @return the data_fim
     */
    public String getData_fim() {
        return data_fim;
    }

    /**
     * @param data_fim the data_fim to set
     */
    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    /**
     * @return the corretor
     */
    public int getCorretor() {
        return corretor;
    }

    /**
     * @param corretor the corretor to set
     */
    public void setCorretor(int corretor) {
        this.corretor = corretor;
    }

    /**
     * @return the ple_tx_tipo
     */
    public String getPle_tx_tipo() {
        return ple_tx_tipo;
    }

    /**
     * @param ple_tx_tipo the ple_tx_tipo to set
     */
    public void setPle_tx_tipo(String ple_tx_tipo) {
        this.ple_tx_tipo = ple_tx_tipo;
    }

    /**
     * @return the orgao
     */
    public int getOrgao() {
        return orgao;
    }

    /**
     * @param orgao the orgao to set
     */
    public void setOrgao(int orgao) {
        this.orgao = orgao;
    }
}
