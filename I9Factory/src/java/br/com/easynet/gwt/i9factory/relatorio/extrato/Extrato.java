/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.extrato;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.i9factory.dao.Cli_clienteDAO;
import br.com.easynet.gwt.i9factory.dao.Emp_emprestimoDAO;
import br.com.easynet.gwt.i9factory.dao.Org_orgaoDAO;
import br.com.easynet.gwt.i9factory.dao.Vw_parcelasDAO;
import br.com.easynet.gwt.i9factory.jb.Emp_emprestimoConsultJB;
import br.com.easynet.gwt.i9factory.jb.Funcoes;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.relatorio.print_emprestimo.Print_emprestimo;
import br.com.easynet.gwt.i9factory.tmp.EmprestimoGrupoTMP;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import br.com.easynet.gwt.i9factory.transfer.Emp_emprestimoT;
import br.com.easynet.gwt.i9factory.transfer.Org_orgaoT;
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
public class Extrato extends RelatorioBase implements INotSecurity {

    private Vw_parcelasT vw_parcelasT = new Vw_parcelasT();
    private List<Vw_parcelasT> list = new ArrayList<Vw_parcelasT>();
    private Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
    private String tipo_Agrupamento;
    private boolean extrato;
    private String status;
    private double vlpago, vlapagar;
    private Emp_emprestimoConsultJB emp_emprestimoConsultJB = new Emp_emprestimoConsultJB();
    private List<EmprestimoGrupoTMP> listEmp = new ArrayList<EmprestimoGrupoTMP>();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void setParam() throws Exception {
        try {

            Emp_emprestimoT emp_emprestimoT = new Emp_emprestimoT();
            emp_emprestimoT.setEmp_nr_id(vw_parcelasT.getEmp_nr_id());
            Emp_emprestimoDAO edao = getEmp_emprestimoDAO();
            emp_emprestimoT = edao.getByEmp_nr_id(emp_emprestimoT).get(0);
            System.out.println(emp_emprestimoT.getEmp_nr_proposta());
            getParameters().put("proposta", Funcoes.formatarFloat("00000", emp_emprestimoT.getEmp_nr_proposta()));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            getParameters().put("data_emprestimo", sdf.format(emp_emprestimoT.getEmp_dt_emprestimo()));
            getParameters().put("valor", Funcoes.FormatoMoedaBR(emp_emprestimoT.getEmp_nr_valor()));

            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(emp_emprestimoT.getCli_nr_id());
            Cli_clienteDAO cdao = getCli_clienteDAO();
            cli_clienteT = cdao.getByCli_nr_id(cli_clienteT).get(0);

            getParameters().put("cliente", cli_clienteT.getCli_tx_nome());
            getParameters().put("endereco", cli_clienteT.getCli_tx_logradouro() + ", " + cli_clienteT.getCli_tx_numero() + ", " + cli_clienteT.getCli_tx_tipologradouro());
            getParameters().put("bairro", cli_clienteT.getCli_tx_bairro());
            getParameters().put("cidade", cli_clienteT.getCli_tx_cep() + " - " + cli_clienteT.getCli_tx_municipio() + "/" + cli_clienteT.getCli_tx_uf());

            
            url = Print_emprestimo.class.getResource("logomarca.jpg");
            getParameters().put("pathlogoSistema", url.toString());            
            
            Org_orgaoT org_orgaoT = new Org_orgaoT();
            org_orgaoT.setOrg_nr_id(emp_emprestimoT.getOrg_nr_id());
            Org_orgaoDAO odao = getOrg_orgaoDAO();
            org_orgaoT = odao.getByOrg_nr_id(org_orgaoT).get(0);

            getParameters().put("orgao", org_orgaoT.getOrg_tx_razaosocial());
            setVlPago();

        } catch (Exception e) {
            throw e;

        } finally {
            close();
        }

    }

    public void setFieldEmprestimmo() throws Exception {
        try {

            emp_emprestimoConsultJB.setPage(page);
            emp_emprestimoConsultJB.setAgrupamento(tipo_Agrupamento);
            emp_emprestimoConsultJB.setStatus(getStatus());
            emp_emprestimoConsultJB.setDtInicio(getDtInicio());
            emp_emprestimoConsultJB.setDtFinal(getDtFim());

            emp_emprestimoConsultJB.getEmp_emprestimoT().setCli_nr_id(emp_emprestimoT.getCli_nr_id());
            emp_emprestimoConsultJB.getEmp_emprestimoT().setCor_nr_id(emp_emprestimoT.getCor_nr_id());
            emp_emprestimoConsultJB.getEmp_emprestimoT().setOrg_nr_id(emp_emprestimoT.getOrg_nr_id());
        } catch (Exception e) {
            close();
        }

    }

    public void setVlPago() {
        vlpago = 0;
        for (Vw_parcelasT parcela : list) {
            if (parcela.getPle_dt_pagamento() != null) {
                vlpago += parcela.getPle_nr_valorparcela() - parcela.getPle_nr_valordesconto();
            }
            vlapagar += parcela.getPle_nr_valorparcela();
        }

        vlapagar = vlapagar - vlpago;
        getParameters().put("vlpago", vlpago);
        getParameters().put("vlapagar", vlapagar);
        getParameters().put("proposta", Funcoes.formatarFloat("00000", list.get(0).getEmp_nr_proposta()));
    }

    public void imprimir() {
        try {

            String titulo = "";
            String fileName = "";
            Vw_parcelasDAO vdao = getVw_parcelasDAO();

            if (extrato) {
                titulo = "EXTRATO";
                //getVw_parcelasT().setPle_tx_tipo("P");
                list = vdao.getByExtrato(getVw_parcelasT());
                setParam();
                jRDataSource = new JRBeanCollectionDataSource(list);
                if (!getTipo().equalsIgnoreCase("XLS")) {
                    is = Extrato.class.getResourceAsStream("extrato.jasper");
                } else {
                    url = Extrato.class.getResource("extrato.jasper");
                }
                fileName = "extrato";
            } else {
                setFieldEmprestimmo();
                emp_emprestimoConsultJB.consult();
                povoaDataSet();

                if (tipo_Agrupamento.equalsIgnoreCase("C")) {
                    getParameters().put("column01", "Corretor");
                    getParameters().put("column02", "Orgão");
                } else if (tipo_Agrupamento.equalsIgnoreCase("O")) {
                    getParameters().put("column01", "Cliente");
                    getParameters().put("column02", "Corretor");
                } else {
                    getParameters().put("column01", "Cliente");
                    getParameters().put("column02", "Orgão");
                }
                fileName = "emprestimo";

                jRDataSource = new JRBeanCollectionDataSource(listEmp);

                if (tipo_Agrupamento.equalsIgnoreCase("G")) {
                    is = Extrato.class.getResourceAsStream("emprestimo.jasper");
                } else {
                    is = Extrato.class.getResourceAsStream("emprestimoGroup.jasper");
                    titulo = tipo_Agrupamento.equalsIgnoreCase("C") ? "EMPRESTIMO POR CLIENTE" : tipo_Agrupamento.equalsIgnoreCase("R") ? "EMPRESTIMO POR CORRETOR" : "EMPRESTIMO POR ORGÃO";
                }
                titulo += "  - de " + getDtInicio() + " a " + getDtFim();
            }
            print(fileName, titulo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void povoaDataSet() {
        DataSet ds = emp_emprestimoConsultJB.getDs();
        for (int i = 0; i < ds.getList().size(); i++) {
            EmprestimoGrupoTMP grupoTMP = new EmprestimoGrupoTMP();
            if (tipo_Agrupamento.equalsIgnoreCase("G") || tipo_Agrupamento.equalsIgnoreCase("C")) {
                grupoTMP.setGrupo(ds.getList().get(i).getColumn("cli_tx_nome").toString());
                grupoTMP.setCampo1(ds.getList().get(i).getColumn("cor_tx_nome").toString());
                grupoTMP.setCampo2(ds.getList().get(i).getColumn("org_tx_nome").toString());
            } else if (tipo_Agrupamento.equalsIgnoreCase("C")) {
                grupoTMP.setGrupo(ds.getList().get(i).getColumn("cor_tx_nome").toString());
                grupoTMP.setCampo1(ds.getList().get(i).getColumn("cli_tx_nome").toString());
                grupoTMP.setCampo2(ds.getList().get(i).getColumn("org_tx_nome").toString());
            } else if (tipo_Agrupamento.equalsIgnoreCase("R")) {
                grupoTMP.setGrupo(ds.getList().get(i).getColumn("cor_tx_nome").toString());
                grupoTMP.setCampo1(ds.getList().get(i).getColumn("cli_tx_nome").toString());
                grupoTMP.setCampo2(ds.getList().get(i).getColumn("org_tx_nome").toString());
            } else {
                grupoTMP.setGrupo(ds.getList().get(i).getColumn("org_tx_nome").toString());
                grupoTMP.setCampo1(ds.getList().get(i).getColumn("cli_tx_nome").toString());
                grupoTMP.setCampo2(ds.getList().get(i).getColumn("cor_tx_nome").toString());
            }
            grupoTMP.setDataProposta((Date) ds.getList().get(i).getColumn("emp_dt_emprestimo"));
            grupoTMP.setProposta(Integer.parseInt(ds.getList().get(i).getColumn("emp_nr_proposta").toString()));
            grupoTMP.setValor(Float.parseFloat(ds.getList().get(i).getColumn("emp_nr_valor").toString()));
            listEmp.add(grupoTMP);
        }

    }

    /**
     * @return the vw_parcelasT
     */
    public Vw_parcelasT getVw_parcelasT() {
        return vw_parcelasT;
    }

    /**
     * @param vw_parcelasT the vw_parcelasT to set
     */
    public void setVw_parcelasT(Vw_parcelasT vw_parcelasT) {
        this.vw_parcelasT = vw_parcelasT;
    }

    /**
     * @return the tipo_Agrupamento
     */
    public String getTipo_Agrupamento() {
        return tipo_Agrupamento;
    }

    /**
     * @param tipo_Agrupamento the tipo_Agrupamento to set
     */
    public void setTipo_Agrupamento(String tipo_Agrupamento) {
        this.tipo_Agrupamento = tipo_Agrupamento;
    }

    /**
     * @return the extrato
     */
    public boolean isExtrato() {
        return extrato;
    }

    /**
     * @param extrato the extrato to set
     */
    public void setExtrato(boolean extrato) {
        this.extrato = extrato;
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
}
