/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;

import br.com.i9factory.client.Constantes;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author topfontes
 */
public class SituacaofinanceiraGWT extends br.com.i9factory.client.i9factory.factory.relatorio.RelatorioBaseGWT {

    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private NumberFormat format = NumberFormat.getFormat("#,##0.00");
    private RadioGroup rdgTipo = new RadioGroup();
    private Radio rdMensalidade = new Radio();
    private Radio rdEmprestimo = new Radio();

    private RadioGroup rdgSituacao = new RadioGroup();
    private Radio rdAdimplentes = new Radio();
    private Radio rdInadimplentes = new Radio();

    public SituacaofinanceiraGWT() {

        rdMensalidade.setBoxLabel("Mensalidades");
        rdMensalidade.setValue(true);
        rdEmprestimo.setBoxLabel("Parcelas");
        rdgTipo.add(rdEmprestimo);
        rdgTipo.add(rdMensalidade);

        rdAdimplentes.setBoxLabel("Adimplentes");
        rdInadimplentes.setBoxLabel("Inadimplentes");
        rdgSituacao.add(rdAdimplentes);
        rdgSituacao.add(rdInadimplentes);

        addPeriodo();
        addRadioGroup();
        addSituacao();
        addCbOrgao();

        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());

        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!carregouOrgao) {
                    schedule(1000);
                } else {
                    addBtnFiltrar();
                    addBtnExportar();
                    Info.display("carregou", "");
                }
            }
        };

        timer.schedule(1000);
        getCpREL().setLayout(new FillLayout());
        getCpREL().layout();
        layout();
    }

    public void addRadioGroup() {
        getToolBarMaster().add(rdgTipo);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
    }

    public void addSituacao() {
        getToolBarMaster().add(rdgSituacao);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
    }

    @Override
    public void exportarPDF() {
        download(Constantes.URL + getURL() + TIPO_PDF);
    }

    @Override
    public void exportarXLS() {

        download(Constantes.URL + getURL() + TIPO_XLS);
    }

    @Override
    public void filtrar() {
        String url = br.com.easyportal.gwt.client.Constantes.URL + JSP_VIEW;
        url += convertCaracterURL(getURL(), TIPO_HTML); 
        url += TIPO_HTML;
        
        getCpREL().setUrl(url);
    }

    public String getURL() {
        String tipo = rdgTipo.getValue().getBoxLabel().equalsIgnoreCase("Mensalidades") ? "M" : "P";// M = mensalidades e P= parcelas;
        String quitado = rdgSituacao.getValue() == rdAdimplentes ? "S" : "N";
        String orgao = "&orgao=";
        orgao += getCbOrgao().getValue() == null ? "0" : "" + getCbOrgao().getValue().getOrg_nr_id();
        String param = "&tipo_parcela=" + tipo + "&quitado=" + quitado + orgao;

        return "i9factory/factory/relatorios/statuscliente.jsp?op=imprimir&dtInicio=" + dtfDate.format(getDtInicio().getValue()) + "&dtFim=" + dtfDate.format(getDtFim().getValue()) + param;
    }
}
