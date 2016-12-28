/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.decima_prim_par;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Vw_parcelasDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.relatorio.seguro_mensalidade.SegurosMensalidade;
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
public class DecimaPrimParc extends RelatorioBase implements INotSecurity{

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

    public void imprimir() throws Exception {
        try {
            Vw_parcelasDAO vdao = getVw_parcelasDAO();
            vw_parcelasT.setPle_tx_parcela("12/12");
            list = vdao.getByPle_tx_parcela(vw_parcelasT);
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = DecimaPrimParc.class.getResourceAsStream("decima_prim_parc.jasper");
            } else {
                url = DecimaPrimParc.class.getResource("decima_prim_parc.jasper");
            }
            SimpleDateFormat format = new SimpleDateFormat("MM");
            String mes = getMes(Integer.parseInt(format.format(new Date())));
            print("decima-primeira-parc", "Décima Segunda Parcela - mês " + mes);

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
}
