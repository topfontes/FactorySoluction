
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
public class Emp_emprestimoTGWT extends BaseModel {

    public Emp_emprestimoTGWT() {
    }

    public int getEmp_nr_id() {
        return ((Integer) get("emp_nr_id")).intValue();
//    return get("emp_nr_id");
    }

    public void setEmp_nr_id(int emp_nr_id) {
        set("emp_nr_id", emp_nr_id);
    }

    public int getCli_nr_id() {
        return ((Integer) get("cli_nr_id")).intValue();
//    return get("cli_nr_id");
    }

    public void setCli_nr_id(int cli_nr_id) {
        set("cli_nr_id", cli_nr_id);
    }

    public int getAge_nr_id() {
        return ((Integer) get("age_nr_id")).intValue();
//    return get("age_nr_id");
    }

    public void setAge_nr_id(int age_nr_id) {
        set("age_nr_id", age_nr_id);
    }

    public int getIdc_nr_id() {
        return ((Integer) get("idc_nr_id")).intValue();
//    return get("idc_nr_id");
    }

    public void setIdc_nr_id(int idc_nr_id) {
        set("idc_nr_id", idc_nr_id);
    }

    public Date getEmp_dt_emprestimo() {
        return (Date) get("emp_dt_emprestimo");
//    return get("emp_dt_emprestimo");
    }

    public void setEmp_dt_emprestimo(Date emp_dt_emprestimo) {
        set("emp_dt_emprestimo", emp_dt_emprestimo);
    }

    public float getEmp_nr_valor() {
        return ((Float) get("emp_nr_valor")).floatValue();
//    return get("emp_nr_valor");
    }

    public void setEmp_nr_valor(float emp_nr_valor) {
        set("emp_nr_valor", emp_nr_valor);
    }

    public String getEmp_tx_status() {
        return get("emp_tx_status");
//    return get("emp_tx_status");
    }

    public void setEmp_tx_status(String emp_tx_status) {
        set("emp_tx_status", emp_tx_status);
    }

    public String getEmp_tx_observacoes() {
        return get("emp_tx_observacoes");
//    return get("emp_tx_observacoes");
    }

    public void setEmp_tx_observacoes(String emp_tx_observacoes) {
        set("emp_tx_observacoes", emp_tx_observacoes);
    }

    public Date getEmp_dt_aprovacao() {
        return (Date) get("emp_dt_aprovacao");
//    return get("emp_dt_aprovacao");
    }

    public void setEmp_dt_aprovacao(Date emp_dt_aprovacao) {
        set("emp_dt_aprovacao", emp_dt_aprovacao);
    }

    public Date getEmp_dt_liberacao() {
        return (Date) get("emp_dt_liberacao");
//    return get("emp_dt_liberacao");
    }

    public void setEmp_dt_liberacao(Date emp_dt_liberacao) {
        set("emp_dt_liberacao", emp_dt_liberacao);
    }

    public Date getEmp_dt_quitacao() {
        return (Date) get("emp_dt_quitacao");
//    return get("emp_dt_quitacao");
    }

    public void setEmp_dt_quitacao(Date emp_dt_quitacao) {
        set("emp_dt_quitacao", emp_dt_quitacao);
    }

    public Date getEmp_dt_enviobanco() {
        return (Date) get("emp_dt_enviobanco");
//    return get("emp_dt_enviobanco");
    }

    public void setEmp_dt_enviobanco(Date emp_dt_enviobanco) {
        set("emp_dt_enviobanco", emp_dt_enviobanco);
    }

    public Date getEmp_dt_retornobanco() {
        return (Date) get("emp_dt_retornobanco");
//    return get("emp_dt_retornobanco");
    }

    public void setEmp_dt_retornobanco(Date emp_dt_retornobanco) {
        set("emp_dt_retornobanco", emp_dt_retornobanco);
    }

    public String getEmp_tx_cdlancamentobanco() {
        return get("emp_tx_cdlancamentobanco");
//    return get("emp_tx_cdlancamentobanco");
    }

    public void setEmp_tx_cdlancamentobanco(String emp_tx_cdlancamentobanco) {
        set("emp_tx_cdlancamentobanco", emp_tx_cdlancamentobanco);
    }

    public String getEmp_tx_cdlancamentopendente() {
        return get("emp_tx_cdlancamentopendente");
//    return get("emp_tx_cdlancamentopendente");
    }

    public void setEmp_tx_cdlancamentopendente(String emp_tx_cdlancamentopendente) {
        set("emp_tx_cdlancamentopendente", emp_tx_cdlancamentopendente);
    }

    public String getEmp_tx_numerocheque() {
        return get("emp_tx_numerocheque");
//    return get("emp_tx_numerocheque");
    }

    public void setEmp_tx_numerocheque(String emp_tx_numerocheque) {
        set("emp_tx_numerocheque", emp_tx_numerocheque);
    }

    public int getCor_nr_id() {
        return ((Integer) get("cor_nr_id")).intValue();
//    return get("emp_nr_id");
    }

    public void setCor_nr_id(int cor_nr_id) {
        set("cor_nr_id", cor_nr_id);
    }

    public int getOrg_nr_id() {
        return ((Integer) get("org_nr_id")).intValue();
//    return get("emp_nr_id");
    }

    public void setOrg_nr_id(int org_nr_id) {
        set("org_nr_id", org_nr_id);
    }

    public String getCli_tx_nome() {
        return get("cli_tx_nome");
//    return get("emp_tx_numerocheque");
    }

    public void setCli_tx_nome(String cli_tx_nome) {
        set("cli_tx_nome", cli_tx_nome);
    }

    public String getOrg_tx_nome() {
        return get("org_tx_nome");
//    return get("emp_tx_numerocheque");
    }

    public void setOrg_tx_nome(String org_tx_nome) {
        set("org_tx_nome", org_tx_nome);
    }

    public String getCo_tx_nome() {
        return get("cor_tx_nome");
//    return get("emp_tx_numerocheque");
    }

    public void setCor_tx_nome(String cor_tx_nome) {
        set("cor_tx_nome", cor_tx_nome);
    }

    public float getEmp_nr_valor_parcelas_anterior() {
        return ((Float) get("emp_nr_valor_parcelas_anterior")).floatValue();
    }

    public void setEmp_nr_valor_parcelas_anterior(float emp_nr_valor_parcelas_anterior) {
        set("emp_nr_valor_parcelas_anterior", emp_nr_valor_parcelas_anterior);
    }

    public float getEmp_nr_valor_desc_parcela_anterior() {
        return ((Float) get("emp_nr_valor_desc_parcela_anterior")).floatValue();
    }

    public void setEmp_nr_valor_desc_parcela_anterior(float emp_nr_valor_desc_parcela_anterior) {
        set("emp_nr_valor_desc_parcela_anterior", emp_nr_valor_desc_parcela_anterior);
    }

    public float getEmp_nr_valor_afin_bruto() {
        return ((Float) get("emp_nr_valor_afin_bruto")).floatValue();
    }

    public void setEmp_nr_valor_afin_bruto(float emp_nr_valor_afin_bruto) {
        set("emp_nr_valor_afin_bruto", emp_nr_valor_afin_bruto);
    }

    public float getEmp_nr_valor_afin_liquido() {
        return ((Float) get("emp_nr_valor_afin_liquido")).floatValue();
    }

    public void setEmp_nr_valor_afin_liquido(float emp_nr_valor_afin_liquido) {
        set("emp_nr_valor_afin_liquido", emp_nr_valor_afin_liquido);
    }

    public int getEmp_nr_proposta() {
        return ((Integer) get("emp_nr_proposta")).intValue();
    }

    public void setEmp_nr_proposta(int emp_nr_proposta) {
        set("emp_nr_proposta", emp_nr_proposta);
    }

    public String getCli_tx_cpf() {
        return get("cli_tx_cpf");
    }

    public void setCli_tx_cpf(String cli_tx_cpf) {
        set("cli_tx_cpf", cli_tx_cpf);
    }

    public String getCli_tx_matricula() {
        return get("cli_tx_matricula");
    }

    public void setCli_tx_matricula(String cli_tx_matricula) {
        set("cli_tx_matricula", cli_tx_matricula);
    }

    public String getBco_tx_nome() {
        return get("bco_tx_nome");
    }

    public void setBco_tx_nome(String bco_tx_nome) {
        set("bco_tx_nome", bco_tx_nome);
    }

    public float getComissao() {
        return ((Float) get("comissao")).floatValue();
    }

    public void setComissao(float comissao) {
        set("comissao", comissao);
    }

    public String getUsu_tx_nome() {
        return get("usu_tx_nome");
//    return get("emp_tx_status");
    }

    public void setUsu_tx_nome(String usu_tx_nome) {
        set("usu_tx_nome", usu_tx_nome);
    }

    public int getTic_nr_id() {
        return ((Integer) get("tic_nr_id")).intValue();
//    return get("emp_nr_id");
    }

    public void setTic_nr_id(int tic_nr_id) {
        set("tic_nr_id", tic_nr_id);
    }

    public String getEmp_tx_compensado() {
        return get("emp_tx_compensado");
    }

    public void setEmp_tx_compensado(String emp_tx_compensado) {
        set("emp_tx_compensado", emp_tx_compensado);
    }

    public String getEmp_tx_acordo() {
        return get("emp_tx_acordo");
    }

    public void setEmp_tx_acordo(String emp_tx_acordo) {
        set("emp_tx_acordo", emp_tx_acordo);
    }

    public int getEmp_seq_nr_boletobb() {
        return ((Integer) get("emp_seq_nr_boletobb")).intValue();
//    return get("emp_nr_id");
    }

    public void setEmp_seq_nr_boletobb(int emp_seq_nr_boletobb) {
        set("emp_seq_nr_boletobb", emp_seq_nr_boletobb);
    }
    public int getTac_nr_id() {
        return ((Integer) get("tac_nr_id")).intValue();
//    return get("emp_nr_id");
    }

    public void setTac_nr_id(int tac_nr_id) {
        set("tac_nr_id", tac_nr_id);
    }

}
