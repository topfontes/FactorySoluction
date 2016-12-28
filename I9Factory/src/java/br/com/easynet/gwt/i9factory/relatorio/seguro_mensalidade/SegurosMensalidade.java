/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.seguro_mensalidade;

import br.com.easynet.gwt.i9factory.dao.Vw_parcelasDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Vw_parcelasT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class SegurosMensalidade extends RelatorioBase {

    private List<Vw_parcelasT> list = new ArrayList<Vw_parcelasT>();
    private Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private int cli_nr_id;
    private String tx_tipo;
    private String status;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
            Vw_parcelasDAO vdao = getVw_parcelasDAO();
            if (tx_tipo.equalsIgnoreCase("T")) {
                list = vdao.getAllReport(format.parse(getDtInicio()), format.parse(getDtFim()), status, cli_nr_id);
            } else {
                list = vdao.getAllReport(format.parse(getDtInicio()), format.parse(getDtFim()), status, tx_tipo, cli_nr_id);
            }
            calcularValorPago();
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = SegurosMensalidade.class.getResourceAsStream("seguro_mensalidade.jasper");
            } else {
                url = SegurosMensalidade.class.getResource("seguro_mensalidade.jasper");
            }
            String destTipo = tx_tipo.equalsIgnoreCase("T") ? "Todos" : tx_tipo.equalsIgnoreCase("P") ? "Parcelas" : "Mensalidades";
            print("SeguroMensalidade", destTipo+" no Périodo de " + getDtInicio() + " a " + getDtFim());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void calcularValorPago() {
        if (status.equalsIgnoreCase("P")) {
            for (Vw_parcelasT vw_parcelasT : list) {
                vw_parcelasT.setEmp_nr_valor_pago(vw_parcelasT.getPle_nr_valorparcela() - vw_parcelasT.getPle_nr_valordesconto());

            }
        }
    }

    /**
     * @return the tx_tipo
     */
    public String getTx_tipo() {
        return tx_tipo;
    }

    /**
     * @param tx_tipo the tx_tipo to set
     */
    public void setTx_tipo(String tx_tipo) {
        this.tx_tipo = tx_tipo;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the cli_nr_id
     */
    public int getCli_nr_id() {
        return cli_nr_id;
    }

    /**
     * @param cli_nr_id the cli_nr_id to set
     */
    public void setCli_nr_id(int cli_nr_id) {
        this.cli_nr_id = cli_nr_id;
    }
}
