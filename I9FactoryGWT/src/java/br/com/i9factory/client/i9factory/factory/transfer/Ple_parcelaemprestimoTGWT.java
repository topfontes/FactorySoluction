
/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Ple_parcelaemprestimoTGWT extends BaseModel {

    public Ple_parcelaemprestimoTGWT() {
    }

    public int getPle_nr_id() {
        return ((Integer) get("ple_nr_id")).intValue();
//    return get("ple_nr_id");
    }

    public void setPle_nr_id(int ple_nr_id) {
        set("ple_nr_id", ple_nr_id);
    }

    public int getEmp_nr_id() {
        return ((Integer) get("emp_nr_id")).intValue();
//    return get("emp_nr_id");
    }

    public void setEmp_nr_id(int emp_nr_id) {
        set("emp_nr_id", emp_nr_id);
    }

    public Date getPle_dt_vencimento() {
        return (Date) get("ple_dt_vencimento");
//    return get("ple_dt_vencimento");
    }

    public void setPle_dt_vencimento(Date ple_dt_vencimento) {
        set("ple_dt_vencimento", ple_dt_vencimento);
    }

    public Date getPle_dt_pagamento() {
        return (Date) get("ple_dt_pagamento");
//    return get("ple_dt_pagamento");
    }

    public void setPle_dt_pagamento(Date ple_dt_pagamento) {
        set("ple_dt_pagamento", ple_dt_pagamento);
    }

    public float getPle_nr_valorparcela() {
        return ((Float) get("ple_nr_valorparcela")).floatValue();
//    return get("ple_nr_valorparcela");
    }

    public void setPle_nr_valorparcela(float ple_nr_valorparcela) {
        set("ple_nr_valorparcela", ple_nr_valorparcela);
    }

    public float getPle_nr_valordesconto() {
        return ((Float) get("ple_nr_valordesconto")).floatValue();
    }

    public void setPle_nr_valordesconto(float ple_nr_valordesconto) {
        set("ple_nr_valordesconto", ple_nr_valordesconto);
    }

    public int getPle_nr_cdformapagto() {
        return ((Integer) get("ple_nr_cdformapagto")).intValue();
//    return get("ple_nr_cdformapagto");
    }

    public void setPle_nr_cdformapagto(int ple_nr_cdformapagto) {
        set("ple_nr_cdformapagto", ple_nr_cdformapagto);
    }

    public String getPle_tx_parcela() {
        return get("ple_tx_parcela");
//    return get("emp_tx_status");
    }

    public void setPle_tx_parcela(String ple_tx_parcela) {
        set("ple_tx_parcela", ple_tx_parcela);
    }

    public String getCli_tx_nome() {
        return get("cli_tx_nome");
    }

    public void setCli_tx_nome(String cli_tx_nome) {
        set("cli_tx_nome", cli_tx_nome);
    }

    public String getPle_tx_tipo() {
        return get("ple_tx_tipo");
    }

    public void setPle_tx_tipo(String ple_tx_tipo) {
        set("ple_tx_tipo", ple_tx_tipo);
    }

    public String getPle_tx_historico() {
        return get("ple_tx_historico");
    }

    public void setPle_tx_historico(String ple_tx_historico) {
        set("ple_tx_historico", ple_tx_historico);
    }

    public double getPle_nr_Percdesconto() {
        return ((Double) get("ple_nr_Percdesconto")).floatValue();
    }

    public void setPle_nr_Percdesconto(double ple_nr_Percdesconto) {
        set("ple_nr_Percdesconto", ple_nr_Percdesconto);
    }

    public int getPle_nr_id_vinculo() {
        return ((Integer) get("ple_nr_id_vinculo")).intValue();
//    return get("ple_nr_id");
    }

    public void setPle_nr_id_vinculo(int ple_nr_id_vinculo) {
        set("ple_nr_id_vinculo", ple_nr_id_vinculo);
    }

    public boolean isPle_bl_suspenso() {
        return ((Boolean) get("ple_bl_suspenso")).booleanValue();
//    return get("ple_nr_id");
    }

    public void setPle_bl_suspenso(boolean ple_bl_suspenso) {
        set("ple_bl_suspenso", ple_bl_suspenso);
    }
    //ple_bl_suspenso

    public int getPle_nr_seq_boleto() {
        return ((Integer) get("ple_nr_seq_boleto")).intValue();
    }

    public void setPle_nr_seq_boleto(int ple_nr_seq_boleto) {
        set("ple_nr_seq_boleto", ple_nr_seq_boleto);
    }

    public float getPle_nr_valorLiqCartao() {
        return ((Float) get("ple_nr_valorLiqCartao")).floatValue();
    }

    public void setPle_nr_valorLiqCartao(float ple_nr_valorLiqCartao) {
        set("ple_nr_valorLiqCartao", ple_nr_valorLiqCartao);
    }
    public float getTac_nr_taxa() {
        return ((Float) get("tac_nr_taxa")).floatValue();
    }

    public void setTac_nr_taxa(float tac_nr_taxa) {
        set("tac_nr_taxa", tac_nr_taxa);
    }
}
