/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.comissao;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Emp_emprestimoDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.tmp.ComissaoTMP;
import br.com.easynet.gwt.i9factory.transfer.Emp_emprestimoT;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.Soundbank;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Comissao extends RelatorioBase implements INotSecurity {

    private List<ComissaoTMP> list = new ArrayList<ComissaoTMP>();
    private DataSet ds;
    private Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formatDs = new SimpleDateFormat("yyyy/MM/dd");
    private float percComissao;
    private String tipoFiltro;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
            Emp_emprestimoDAO edao = getEmp_emprestimoDAO();
            java.util.Date dtini = format.parse(getDtInicio());
            java.util.Date dtfi = format.parse(getDtFim());
            java.sql.Date inicio = new Date(dtini.getTime());
            java.sql.Date fim = new Date(dtfi.getTime());
            
            if (tipoFiltro.equalsIgnoreCase("E")) {
                ds = edao.getAllComissao(emp_emprestimoT, inicio, fim);
            } else {
                ds = edao.getAllComissaoMensalidades(emp_emprestimoT, inicio, fim);

            }
            povoaList();
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Comissao.class.getResourceAsStream("comissao.jasper");
            } else {
                url = Comissao.class.getResource("comissao.jasper");
            }

            print("Comissao", "Comissão  de Corretor -  Período de " + getDtInicio() + " a " + getDtFim());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void povoaList() throws Exception {
        if (ds != null) {
            for (int i = 0; i < ds.getList().size(); i++) {
                ComissaoTMP comissaoTMP = new ComissaoTMP();
                comissaoTMP.setCli_tx_cpf(ds.getList().get(i).getColumn("cli_tx_cpf").toString());
                comissaoTMP.setCli_tx_nome(ds.getList().get(i).getColumn("cli_tx_nome").toString());
                comissaoTMP.setCor_tx_nome(ds.getList().get(i).getColumn("cor_tx_nome").toString());
                comissaoTMP.setProposta(Integer.parseInt(ds.getList().get(i).getColumn("emp_nr_proposta").toString()));
                String data = ds.getList().get(i).getColumn("emp_dt_emprestimo").toString().replace("-", "/");
                
                String dt = format.format(formatDs.parse(data));
                comissaoTMP.setDt_emprestimo(format.parse(dt));
                comissaoTMP.setValor(Float.parseFloat(ds.getList().get(i).getColumn("emp_nr_valor_afin_liquido").toString()));
                comissaoTMP.setPercentual(percComissao);
                
                comissaoTMP.setVlBruto(Float.parseFloat(ds.getList().get(i).getColumn("emp_nr_valor").toString()));
              
                comissaoTMP.setSaldo(comissaoTMP.getVlBruto() - comissaoTMP.getValor());
                float vlcome = (comissaoTMP.getValor() * comissaoTMP.getPercentual()) / 100;
                comissaoTMP.setComissao(vlcome);
                list.add(comissaoTMP);
            }
        }
    }

    /**
     * @return the percentual
     */
    public float getPercComissao() {
        return percComissao;
    }

    /**
     * @param percentual the percentual to set
     */
    public void setPercComissao(float percComissao) {
        this.percComissao = percComissao;
    }

    /**
     * @return the emp_emprestimoT
     */
    public Emp_emprestimoT getEmp_emprestimoT() {
        return emp_emprestimoT;
    }

    /**
     * @param emp_emprestimoT the emp_emprestimoT to set
     */
    public void setEmp_emprestimoT(Emp_emprestimoT emp_emprestimoT) {
        this.emp_emprestimoT = emp_emprestimoT;
    }

    /**
     * @return the tipo
     */
    public String getTipoFiltro() {
        return tipoFiltro;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }
}
