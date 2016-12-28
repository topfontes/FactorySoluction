/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.contaAPagar_Pagas;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.i9factory.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.tmp.Ctp_conta_pagarTMP;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */

public class ContasAPagar_Pagas extends RelatorioBase {

    private int id_fornecedor;
    private int id_tipoDesp;
    private String agrupamento;
    private DataSet ds;
    private List<Ctp_conta_pagarTMP> list;

    public void imprimir() {
        try {
            Date dtini = format.parse(getDtInicio());
            Date dtfinal = format.parse(getDtFim());

            getParameters().put("periodo", "Periódo de " + getDtInicio() + " a " + getDtFim());

            String descdata = "Dt. Pgto.";
            String nome = "Pagas";
            if (getStatus().equalsIgnoreCase("F")) {
                nome = "A Pagar";
                descdata = "Vencimento";
            }

            getParameters().put("descData", descdata);

            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ds = ctp_conta_pagarDAO.getAll(getStatus(), dtini, dtfinal, getId_fornecedor(), getId_tipoDesp(), getAgrupamento());
            povoaLista();

            String arquivo = getAgrupamento().equalsIgnoreCase("G") ? "ContasAPagar_Pagas.jasper" : "ContasAPagar_PagasGroup.jasper";
            getParameters().put("descricao", getAgrupamento().equalsIgnoreCase("F") ? "Tipo Despesa" : "Fornecedor");

            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = ContasAPagar_Pagas.class.getResourceAsStream(arquivo);
            } else {
                url = ContasAPagar_Pagas.class.getResource(arquivo);
            }

            print("Contas " + nome, "Contas " + nome);

        } catch (Throwable e) {
            e.printStackTrace();
        }finally{ 
            close();
        }
    }

    public void povoaLista() {

        list = new ArrayList<Ctp_conta_pagarTMP>();
        for (int i = 0; i < ds.getList().size(); i++) {
            Ctp_conta_pagarTMP tMP = new Ctp_conta_pagarTMP();
            tMP.setCtp_nr_doc(Integer.parseInt(ds.getList().get(i).getColumn("ctp_nr_doc").toString()));
            tMP.setCtp_dt_emissao(format.format(ds.getList().get(i).getColumn("ctp_dt_emissao")));
            tMP.setDt_vencimento(format.format(ds.getList().get(i).getColumn("ctp_dt_vencimento")));
            tMP.setCtp_tx_parcela((ds.getList().get(i).getColumn("ctp_tx_parcela").toString()));
            tMP.setCtp_valor(Float.parseFloat(ds.getList().get(i).getColumn("ctp_valor").toString()));
            if (ds.getList().get(i).getColumn("ctp_dt_pagamento") != null) {
                tMP.setDt_pagamento(format.format(ds.getList().get(i).getColumn("ctp_dt_pagamento").toString()));
            }
            tMP.setCtp_valor(Float.parseFloat(ds.getList().get(i).getColumn("ctp_vl_pago").toString()));
            tMP.setCtp_saldo(Float.parseFloat(ds.getList().get(i).getColumn("ctp_saldo").toString()));
            tMP.setFor_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("for_nr_id").toString()));
            if (ds.getList().get(i).getColumn("ctp_tx_obs") != null) {
                tMP.setCtp_tx_obs(ds.getList().get(i).getColumn("ctp_tx_obs").toString());
            }
            tMP.setTid_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("tid_nr_id").toString()));
            if (getAgrupamento().equalsIgnoreCase("F")) {
                tMP.setGrupo(ds.getList().get(i).getColumn("for_tx_nome").toString());
                tMP.setDescricao(ds.getList().get(i).getColumn("tid_tx_nome").toString());
            } else {
                tMP.setGrupo(ds.getList().get(i).getColumn("tid_tx_nome").toString());
                tMP.setDescricao(ds.getList().get(i).getColumn("for_tx_nome").toString());
            }
            list.add(tMP);
        }
    }

    /**
     * @return the id_fornecedor
     */
    public int getId_fornecedor() {
        return id_fornecedor;
    }

    /**
     * @param id_fornecedor the id_fornecedor to set
     */
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    /**
     * @return the id_tipoDesp
     */
    public int getId_tipoDesp() {
        return id_tipoDesp;
    }

    /**
     * @param id_tipoDesp the id_tipoDesp to set
     */
    public void setId_tipoDesp(int id_tipoDesp) {
        this.id_tipoDesp = id_tipoDesp;
    }

    /**
     * @return the agrupamento
     */
    public String getAgrupamento() {
        return agrupamento;
    }

    /**
     * @param agrupamento the agrupamento to set
     */
    public void setAgrupamento(String agrupamento) {
        this.agrupamento = agrupamento;
    }
}
