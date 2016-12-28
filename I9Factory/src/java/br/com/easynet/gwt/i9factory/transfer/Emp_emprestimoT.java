package br.com.easynet.gwt.i9factory.transfer;

import br.com.easynet.annotation.Conversion;

public class Emp_emprestimoT {

    private int emp_nr_id;
    private int cli_nr_id;
    private int cor_nr_id;
    private int idc_nr_id;
    private int org_nr_id;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date emp_dt_emprestimo;
    private double emp_nr_valor;
    private String emp_tx_status;
    private String emp_tx_observacoes;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date emp_dt_aprovacao;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date emp_dt_liberacao;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date emp_dt_quitacao;
    @Conversion(classe = "br.com.easynet.convesion.ConvertTimestamp", format = "dd/MM/yyyy HH:mm")
    private java.sql.Timestamp emp_dt_enviobanco;
    @Conversion(classe = "br.com.easynet.convesion.ConvertTimestamp", format = "dd/MM/yyyy HH:mm")
    private java.sql.Timestamp emp_dt_retornobanco;
    private String emp_tx_cdlancamentobanco;
    private String emp_tx_cdlancamentopendente;
    private String emp_tx_numerocheque;
//    emp_nr_valor_parcelas_anterior=?,emp_nr_valor_desc_parcela_anterior=?,emp_nr_valor_afin_bruto=?,emp_nr_valor_afin_liquido=?,emp_nr_proposta=?
    private double emp_nr_valor_parcelas_anterior;
    private double emp_nr_valor_desc_parcela_anterior;
    private double emp_nr_valor_afin_bruto;
    private double emp_nr_valor_afin_liquido;
    private int emp_nr_proposta;
    private int usu_nr_id;
    private int tic_nr_id;
    private String emp_tx_compensado;
    private String emp_tx_acordo;
    private int emp_seq_nr_boletobb;

    public void setEmp_nr_id(int emp_nr_id) {
        this.emp_nr_id = emp_nr_id;
    }

    public int getEmp_nr_id() {
        return emp_nr_id;
    }

    public void setCli_nr_id(int cli_nr_id) {
        this.cli_nr_id = cli_nr_id;
    }

    public int getCli_nr_id() {
        return cli_nr_id;
    }

    public void setIdc_nr_id(int idc_nr_id) {
        this.idc_nr_id = idc_nr_id;
    }

    public int getIdc_nr_id() {
        return idc_nr_id;
    }

    public void setEmp_dt_emprestimo(java.util.Date emp_dt_emprestimo) {
        this.emp_dt_emprestimo = emp_dt_emprestimo;
    }

    public java.util.Date getEmp_dt_emprestimo() {
        return emp_dt_emprestimo;
    }

    public void setEmp_nr_valor(double emp_nr_valor) {
        this.emp_nr_valor = emp_nr_valor;
    }

    public double getEmp_nr_valor() {
        return emp_nr_valor;
    }

    public void setEmp_tx_status(String emp_tx_status) {
        this.emp_tx_status = emp_tx_status;
    }

    public String getEmp_tx_status() {
        return emp_tx_status;
    }

    public void setEmp_tx_observacoes(String emp_tx_observacoes) {
        this.emp_tx_observacoes = emp_tx_observacoes;
    }

    public String getEmp_tx_observacoes() {
        return emp_tx_observacoes;
    }

    public void setEmp_dt_aprovacao(java.util.Date emp_dt_aprovacao) {
        this.emp_dt_aprovacao = emp_dt_aprovacao;
    }

    public java.util.Date getEmp_dt_aprovacao() {
        return emp_dt_aprovacao;
    }

    public void setEmp_dt_liberacao(java.util.Date emp_dt_liberacao) {
        this.emp_dt_liberacao = emp_dt_liberacao;
    }

    public java.util.Date getEmp_dt_liberacao() {
        return emp_dt_liberacao;
    }

    public void setEmp_dt_quitacao(java.util.Date emp_dt_quitacao) {
        this.emp_dt_quitacao = emp_dt_quitacao;
    }

    public java.util.Date getEmp_dt_quitacao() {
        return emp_dt_quitacao;
    }

    public void setEmp_dt_enviobanco(java.sql.Timestamp emp_dt_enviobanco) {
        this.emp_dt_enviobanco = emp_dt_enviobanco;
    }

    public java.sql.Timestamp getEmp_dt_enviobanco() {
        return emp_dt_enviobanco;
    }

    public void setEmp_dt_retornobanco(java.sql.Timestamp emp_dt_retornobanco) {
        this.emp_dt_retornobanco = emp_dt_retornobanco;
    }

    public java.sql.Timestamp getEmp_dt_retornobanco() {
        return emp_dt_retornobanco;
    }

    public void setEmp_tx_cdlancamentobanco(String emp_tx_cdlancamentobanco) {
        this.emp_tx_cdlancamentobanco = emp_tx_cdlancamentobanco;
    }

    public String getEmp_tx_cdlancamentobanco() {
        return emp_tx_cdlancamentobanco;
    }

    public void setEmp_tx_cdlancamentopendente(String emp_tx_cdlancamentopendente) {
        this.emp_tx_cdlancamentopendente = emp_tx_cdlancamentopendente;
    }

    public String getEmp_tx_cdlancamentopendente() {
        return emp_tx_cdlancamentopendente;
    }

    public void setEmp_tx_numerocheque(String emp_tx_numerocheque) {
        this.emp_tx_numerocheque = emp_tx_numerocheque;
    }

    public String getEmp_tx_numerocheque() {
        return emp_tx_numerocheque;
    }

    /**
     * @return the org_nr_id
     */
    public int getOrg_nr_id() {
        return org_nr_id;
    }

    /**
     * @param org_nr_id the org_nr_id to set
     */
    public void setOrg_nr_id(int org_nr_id) {
        this.org_nr_id = org_nr_id;
    }

    /**
     * @return the cor_nr_id
     */
    public int getCor_nr_id() {
        return cor_nr_id;
    }

    /**
     * @param cor_nr_id the cor_nr_id to set
     */
    public void setCor_nr_id(int cor_nr_id) {
        this.cor_nr_id = cor_nr_id;
    }

    /**
     * @return the emp_nr_valor_parcelas_anterior
     */
    public double getEmp_nr_valor_parcelas_anterior() {
        return emp_nr_valor_parcelas_anterior;
    }

    /**
     * @param emp_nr_valor_parcelas_anterior the emp_nr_valor_parcelas_anterior to set
     */
    public void setEmp_nr_valor_parcelas_anterior(double emp_nr_valor_parcelas_anterior) {
        this.emp_nr_valor_parcelas_anterior = emp_nr_valor_parcelas_anterior;
    }

    /**
     * @return the emp_nr_valor_desc_parcela_anterior
     */
    public double getEmp_nr_valor_desc_parcela_anterior() {
        return emp_nr_valor_desc_parcela_anterior;
    }

    /**
     * @param emp_nr_valor_desc_parcela_anterior the emp_nr_valor_desc_parcela_anterior to set
     */
    public void setEmp_nr_valor_desc_parcela_anterior(double emp_nr_valor_desc_parcela_anterior) {
        this.emp_nr_valor_desc_parcela_anterior = emp_nr_valor_desc_parcela_anterior;
    }

    /**
     * @return the emp_nr_valor_afin_bruto
     */
    public double getEmp_nr_valor_afin_bruto() {
        return emp_nr_valor_afin_bruto;
    }

    /**
     * @param emp_nr_valor_afin_bruto the emp_nr_valor_afin_bruto to set
     */
    public void setEmp_nr_valor_afin_bruto(double emp_nr_valor_afin_bruto) {
        this.emp_nr_valor_afin_bruto = emp_nr_valor_afin_bruto;
    }

    /**
     * @return the emp_nr_valor_afin_liquido
     */
    public double getEmp_nr_valor_afin_liquido() {
        return emp_nr_valor_afin_liquido;
    }

    /**
     * @param emp_nr_valor_afin_liquido the emp_nr_valor_afin_liquido to set
     */
    public void setEmp_nr_valor_afin_liquido(double emp_nr_valor_afin_liquido) {
        this.emp_nr_valor_afin_liquido = emp_nr_valor_afin_liquido;
    }

    /**
     * @return the emp_nr_proposta
     */
    public int getEmp_nr_proposta() {
        return emp_nr_proposta;
    }

    /**
     * @param emp_nr_proposta the emp_nr_proposta to set
     */
    public void setEmp_nr_proposta(int emp_nr_proposta) {
        this.emp_nr_proposta = emp_nr_proposta;
    }

    /**
     * @return the usu_nr_id
     */
    public int getUsu_nr_id() {
        return usu_nr_id;
    }

    /**
     * @param usu_nr_id the usu_nr_id to set
     */
    public void setUsu_nr_id(int usu_nr_id) {
        this.usu_nr_id = usu_nr_id;
    }

    /**
     * @return the tic_nr_id
     */
    public int getTic_nr_id() {
        return tic_nr_id;
    }

    /**
     * @param tic_nr_id the tic_nr_id to set
     */
    public void setTic_nr_id(int tic_nr_id) {
        this.tic_nr_id = tic_nr_id;
    }

    /**
     * @return the emp_tx_compensado
     */
    public String getEmp_tx_compensado() {
        return emp_tx_compensado;
    }

    /**
     * @param emp_tx_compensado the emp_tx_compensado to set
     */
    public void setEmp_tx_compensado(String emp_tx_compensado) {
        this.emp_tx_compensado = emp_tx_compensado;
    }

    /**
     * @return the emp_tx_acordo
     */
    public String getEmp_tx_acordo() {
        return emp_tx_acordo;
    }

    /**
     * @param emp_tx_acordo the emp_tx_acordo to set
     */
    public void setEmp_tx_acordo(String emp_tx_acordo) {
        this.emp_tx_acordo = emp_tx_acordo;
    }

    /**
     * @return the emp_seq_nr_boletobb
     */
    public int getEmp_seq_nr_boletobb() {
        return emp_seq_nr_boletobb;
    }

    /**
     * @param emp_seq_nr_boletobb the emp_seq_nr_boletobb to set
     */
    public void setEmp_seq_nr_boletobb(int emp_seq_nr_boletobb) {
        this.emp_seq_nr_boletobb = emp_seq_nr_boletobb;
    }
}