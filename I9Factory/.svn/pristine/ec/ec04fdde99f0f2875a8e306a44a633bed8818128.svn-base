/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.i9factory.relatorio.maladireta;

import br.com.easynet.gwt.i9factory.dao.Cli_clienteDAO;
import br.com.easynet.gwt.i9factory.jb.Funcoes;
import br.com.easynet.gwt.i9factory.relatorio.RelatorioBase;
import br.com.easynet.gwt.i9factory.transfer.Cli_clienteT;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Maladireta extends RelatorioBase {

    private String testo;
    private String parcelas;
    private String ativo;
    private String estadocivil;
    private String sexo;
    private String cancelamento;
    private String orgao;
    private String banco;
    private String status;
///i9factory/viewer.jsp?url=./i9factory/factory/relatorios/maladireta.jsp|op=imprimir$testo= inserir testo$ativo=true$estadocivil=C$sexo=M$cancelamento=3$orgao=12$banco=47$status=V$tipo=PDF

    public void imprimir() {
        try { 
            String criterios = montarCriteriosFiltro();
            Cli_clienteDAO cdao = getCli_clienteDAO();
            List<Cli_clienteT> list = null;

//            if (parcelas.equalsIgnoreCase("true")) {
//                list = cdao.getAllMalaDiretaParcelas();
//            } else {
//                list = cdao.getAllMalaDireta();
//            }

            list = cdao.getCamposCriterios(montarCriteriosFiltro());
            
            
            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Maladireta.class.getResourceAsStream("maladireta.jasper");
            } else {
                url = Maladireta.class.getResource("maladireta.jasper");
            }

            testo = "Desenvolvemos uma nova parceria, onde o BANESE está negociando a dívida que o Sr. tem com a CASSERP. E nesta parceria além de negociar o prazo lhe sobrará uma parte em dinheiro, para isto precisamos que o senhor venha aqui na CASSERP para lhe ofertamos a melhor proposta, e podermos assim regularizar a vossa situação.\n";
            getParameters().put("testo", testo);
            getParameters().put("pathlogo", application.getRealPath("images/Casserp.png"));

            SimpleDateFormat formatdia = new SimpleDateFormat("dd");
            SimpleDateFormat formatmes = new SimpleDateFormat("MM");
            SimpleDateFormat formatano = new SimpleDateFormat("yyyy");

            String dia = formatdia.format(new Date());
            String mes = formatmes.format(new Date());
            String ano = formatano.format(new Date());
            String data = "Aracaju,SE " + Funcoes.formatarFloat("00", Integer.parseInt(dia));
            data += " de " + getMesExtenso(Integer.parseInt(mes));
            data += " de " + ano;

            getParameters().put("data", data);

            print("MalaDireta", "maladireta");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    private String montarCriteriosFiltro() {
        String criterios = " cli_nr_id >-1 ";
        if (sexo != null) {
            criterios += " and cli_tx_sexo ='" + sexo + "'";
        }
        if (estadocivil != null) {
            criterios += " and cli_tx_estadocivil='" + estadocivil + "'";
        }
        if (ativo != null) {
            criterios += " and cli_tx_socio ='" + ativo + "'";
        }
        if (cancelamento != null) {
            criterios += " and mtc_nr_id ='" + cancelamento + "'";
        }
        if (orgao != null) {
            criterios += " and cli_nr_id in( select cli_nr_id from factory.orcl_orgao_cliente where org_nr_id =" + orgao+")";
        }
        if (banco != null) {
            criterios += " and cli_nr_id in(select cli_nr_id from factory.cco_contacorrente where bco_nr_id=" + banco+")";
        }
        if (status != null) {
            String hoje = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
            
            if (status.equalsIgnoreCase("A")) {
                criterios += "  and cli_nr_id in(select distinct cli_nr_id from factory.vw_parcelas_resumo where ple_dt_vencimento > ? and ple_dt_pagamento is null)";
            }else if(status.equalsIgnoreCase("V")){
                criterios += " and cli_nr_id in(select distinct cli_nr_id from factory.vw_parcelas_resumo where ple_dt_vencimento < ? and ple_dt_pagamento is null) ";
            }else{
                criterios +=" and cli_nr_id not in(select distinct cli_nr_id from factory.vw_parcelas_resumo where ple_dt_pagamento is null)";
            }
            //criterios += " and cli_nr_id in(select distinct cl_nr_id from factory.vw_parcelas_resumo where ";
            
        }
        //System.out.println(criterios);
        return criterios;
    }

    public String getMesExtenso(int mes) {
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
            default:
                return "null";
        }
        return strmes;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * @return the parcelas
     */
    public String getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the estadocivil
     */
    public String getEstadocivil() {
        return estadocivil;
    }

    /**
     * @param estadocivil the estadocivil to set
     */
    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the cancelamento
     */
    public String getCancelamento() {
        return cancelamento;
    }

    /**
     * @param cancelamento the cancelamento to set
     */
    public void setCancelamento(String cancelamento) {
        this.cancelamento = cancelamento;
    }

    /**
     * @return the orgao
     */
    public String getOrgao() {
        return orgao;
    }

    /**
     * @param orgao the orgao to set
     */
    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the inadimplentes
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param inadimplentes the inadimplentes to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
