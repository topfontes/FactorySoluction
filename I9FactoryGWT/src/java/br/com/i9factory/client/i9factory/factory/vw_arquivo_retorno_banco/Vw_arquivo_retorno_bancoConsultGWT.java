/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.vw_arquivo_retorno_banco;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;


import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Vw_arquivo_retorno_bancoConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Vw_arquivo_retorno_bancoDAOGWT vw_arquivo_retorno_bancoDao = new Vw_arquivo_retorno_bancoDAOGWT();
    private DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    private NumberFormat nf = NumberFormat.getFormat("#,##0.00");
    private Button btnFiltrar = new Button("Filtrar", ICONS.filter());
    private DateField dtEmissao = new DateField();

    public Vw_arquivo_retorno_bancoConsultGWT() {
        setHeaderVisible(false);
        btnFiltrar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                load();
            }
        });

        dtEmissao.setAllowBlank(false);
        dtEmissao.getPropertyEditor().setFormat(dtf);
        getBtnNovoSuper().setVisible(false);
        getToolBarMaster().add(dtEmissao);
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(new SeparatorToolItem());
        getToolBarMaster().add(btnFiltrar);

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Vw_arquivo_retorno_bancoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Vw_arquivo_retorno_bancoTGWT>>(currency);


        GridCellRenderer<Vw_arquivo_retorno_bancoTGWT> gridStatus = new GridCellRenderer<Vw_arquivo_retorno_bancoTGWT>() {

            public Object render(Vw_arquivo_retorno_bancoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_arquivo_retorno_bancoTGWT> store, Grid<Vw_arquivo_retorno_bancoTGWT> grid) {
                return getRetorno(model.getTeb_tx_status());
            }
        };

        GridCellRenderer<Vw_arquivo_retorno_bancoTGWT> gridOperacao = new GridCellRenderer<Vw_arquivo_retorno_bancoTGWT>() {

            public Object render(Vw_arquivo_retorno_bancoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Vw_arquivo_retorno_bancoTGWT> store, Grid<Vw_arquivo_retorno_bancoTGWT> grid) {
                return getOperacao(model.getTeb_tx_operacao());
            }
        };

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("teb_nr_id");
        column.setHeader("Cód. Registro");
        column.setWidth(200);
        column.setHidden(true);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("teb_dt_envio");
        column.setHeader("Data Envio");
        column.setWidth(80);
        column.setDateTimeFormat(dtf);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

//        column = new ColumnConfig();
//        column.setId("teb_dt_retorno");
//        column.setHeader("Dt. Retorno");
//        column.setWidth(200);
//        column.setDateTimeFormat(dtf);
//        column.setAlignment(HorizontalAlignment.LEFT);
//        configs.add(column);

        column = new ColumnConfig();
        column.setId("teb_tx_status");
        column.setHeader("Status");
        column.setRenderer(gridStatus);
        column.setWidth(250);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("teb_tx_operacao");
        column.setHeader("Operação");
        column.setWidth(80);
        column.setRenderer(gridOperacao);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ple_dt_vencimento");
        column.setHeader("Vcto. Parc.   ");
        column.setWidth(90);
        column.setDateTimeFormat(dtf);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ple_tx_parcela");
        column.setHeader("Parcela");
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("ple_nr_valorparcela");
        column.setHeader("Vl. Parcela");
        column.setWidth(90);
        column.setAlignment(HorizontalAlignment.RIGHT);
        column.setNumberFormat(nf);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("emp_nr_proposta");
        column.setHeader("Proposta");
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("cli_tx_nome");
        column.setHeader("Cliente");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

    }


    private String getOperacao(String codOperacao) {
        String msg =  "";
        if ("E".equals(codOperacao)) {
            msg = "Debito";
        } else if ("R".equals(codOperacao)) {
            msg = "Retornado";
        } else if ("C".equals(codOperacao)) {
            msg = "Cad Enviado";
        } else if ("O".equals(codOperacao)) {
            msg = "Cad Confirmado";
        }
        return msg;
    }

    public String getRetorno(String codRetorno) {
        String msg = "Codigo nao conhecido:" + codRetorno;
        if ("00".equals(codRetorno)) {
            msg = "<div style='color:green'>Debito efetuado</div>";
        } else if ("E".equals(codRetorno)) {
            msg = "<div style='color:gray'>Enviado</div>";
        } else if ("01".equals(codRetorno)) {
            msg = "<div style='color:red'>Insuficiencia de fundos</div>";
        } else if ("02".equals(codRetorno)) {
            msg = "<div style='color:red'>Conta nao cadastrada</div>";
        } else if ("04".equals(codRetorno)) {
            msg = "<div style='color:red'>Outras restricoes</div>";
        } else if ("05".equals(codRetorno)) {
            msg = "<div style='color:red'>valor do debito excede valor limite aprovado.</div>";
        } else if ("10".equals(codRetorno)) {
            msg = "<div style='color:red'>Agencia em regime de encerramento</div>";
        } else if ("12".equals(codRetorno)) {
            msg = "<div style='color:red'>Valor invalido</div>";
        } else if ("13".equals(codRetorno)) {
            msg = "<div style='color:red'>Data de lançamento invalida</div>";
        } else if ("14".equals(codRetorno)) {
            msg = "<div style='color:red'>Agencia invalida</div>";
        } else if ("15".equals(codRetorno)) {
            msg = "<div style='color:red'>conta invalida</div>";
        } else if ("18".equals(codRetorno)) {
            msg = "<div style='color:red'>Data do debito anterior a do processamento</div>";
        } else if ("19".equals(codRetorno)) {
            msg = "<div style='color:red'>Agencia/Conta nao pertence ao CPF/CNPJ informado</div>";
        } else if ("20".equals(codRetorno)) {
            msg = "<div style='color:red'>conta conjunta nao solidaria</div>";
        } else if ("30".equals(codRetorno)) {
            msg = "<div style='color:red'>Sem contrato de debito automatico</div>";
        } else if ("31".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito efetuado em data diferente da data informada – feriado na praca de debito</div>";
        } else if ("96".equals(codRetorno)) {
            msg = "<div style='color:red'>Manutencao do Cadastro</div>";
        } else if ("97".equals(codRetorno)) {
            msg = "<div style='color:red'>Cancelamento - Nao encontrado</div>";
        } else if ("98".equals(codRetorno)) {
            msg = "<div style='color:red'>Cancelamento - Nao efetuado, fora do tempo habil</div>";
        } else if ("99".equals(codRetorno)) {
            msg = "<div style='color:red'>Cancelamento - cancelado conforme solicitacao</div>";
        }
        return msg;
    }


    public void load() {
        vw_arquivo_retorno_bancoDao.consultarTodos(dtf.format(dtEmissao.getValue()));
        Timer timer = new Timer() {

            public void run() {
                ListStore<Vw_arquivo_retorno_bancoTGWT> list = vw_arquivo_retorno_bancoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list.getModels());
                    PagingLoader<PagingLoadResult<Vw_arquivo_retorno_bancoTGWT>> loader = new BasePagingLoader<PagingLoadResult<Vw_arquivo_retorno_bancoTGWT>>(proxy);
                    loader.setRemoteSort(true);

                    ListStore<Vw_arquivo_retorno_bancoTGWT> store = new ListStore<Vw_arquivo_retorno_bancoTGWT>(loader);
                    store.add(list.getModels());

                    getToolBarPage().setPageSize(30);
                    getToolBarPage().bind(loader);
                    loader.load(0, 30);

                    Grid<Vw_arquivo_retorno_bancoTGWT> grid = new Grid<Vw_arquivo_retorno_bancoTGWT>(store, cm);
                    grid.setId("grid");
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }
}
