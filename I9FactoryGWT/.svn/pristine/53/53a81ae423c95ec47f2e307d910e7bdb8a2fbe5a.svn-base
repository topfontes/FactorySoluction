/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.teb_transmissao_empresa_banco;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.ConsultarBaseGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.i18n.client.DateTimeFormat;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
//import org.apache.james.mime4j.field.DateTimeField;

/**
 *
 * @author geoleite
 */
public class Teb_transmissao_empresa_bancoConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Teb_transmissao_empresa_bancoDAOGWT teb_transmissao_empresa_bancoDao = new Teb_transmissao_empresa_bancoDAOGWT();
    public Teb_transmissao_empresa_bancoConsultGWT() {
        setHeaderVisible(false);
        this.setSize("500", "400");
        getBtnNovoSuper().setVisible(false);
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Teb_transmissao_empresa_bancoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Teb_transmissao_empresa_bancoTGWT>>(currency);

        GridCellRenderer<Teb_transmissao_empresa_bancoTGWT> gridStatus = new GridCellRenderer<Teb_transmissao_empresa_bancoTGWT>() {

            public Object render(Teb_transmissao_empresa_bancoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Teb_transmissao_empresa_bancoTGWT> store, Grid<Teb_transmissao_empresa_bancoTGWT> grid) {
                return getRetorno(model.getTeb_tx_status());
            }
        };
        GridCellRenderer<Teb_transmissao_empresa_bancoTGWT> gridOperacao = new GridCellRenderer<Teb_transmissao_empresa_bancoTGWT>() {

            public Object render(Teb_transmissao_empresa_bancoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Teb_transmissao_empresa_bancoTGWT> store, Grid<Teb_transmissao_empresa_bancoTGWT> grid) {
                return getOperacao(model.getTeb_tx_operacao());
            }
        };

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("teb_nr_id");
        column.setHeader("Cod Parcela");
        column.setWidth(80);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("teb_dt_envio");
        column.setHeader("Dt Envio");
        column.setWidth(100);
        column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("teb_dt_retorno");
        column.setHeader("Dt Retorno");
        column.setWidth(100);
        column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("teb_tx_status");
        column.setHeader("Status");
        column.setWidth(350);
        column.setRenderer(gridStatus);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("teb_tx_operacao");
        column.setHeader("Operacao");
        column.setWidth(150);
        column.setRenderer(gridOperacao);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        load();
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
    
    private String getRetorno(String codRetorno) {
        String msg = "Codigo nao conhecido:" + codRetorno;
        if ("00".equals(codRetorno)) {
            msg = "<div style='color:green'>Debito efetuado</div>";
        } else if ("E".equals(codRetorno)) {
            msg = "<div style='color:gray'>Enviado</div>";
        } else if ("01".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Insuficiencia de fundos</div>";
        } else if ("02".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Conta nao cadastrada</div>";
        } else if ("04".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Outras restricoes</div>";
        } else if ("05".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado – valor do debito excede valor limite aprovado.</div>";
        } else if ("10".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Agencia em regime de encerramento</div>";
        } else if ("12".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Valor invalido</div>";
        } else if ("13".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Data de lançamento invalida</div>";
        } else if ("14".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Agencia invalida</div>";
        } else if ("15".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - conta invalida</div>";
        } else if ("18".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Data do debito anterior a do processamento</div>";
        } else if ("19".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado – Agencia/Conta nao pertence ao CPF/CNPJ informado</div>";
        } else if ("20".equals(codRetorno)) {
            msg = "<div style='color:red'>Dwbito nao efetuado – conta conjunta nao solidaria</div>";
        } else if ("30".equals(codRetorno)) {
            msg = "<div style='color:red'>Debito nao efetuado - Sem contrato de debito automatico</div>";
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

    public void btnNovoAction(ButtonEvent be) {

    }

    private GridCellRenderer<Teb_transmissao_empresa_bancoTGWT> getEditarRender() {
        return new GridCellRenderer<Teb_transmissao_empresa_bancoTGWT>() {

            public Object render(final Teb_transmissao_empresa_bancoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Teb_transmissao_empresa_bancoTGWT> store, Grid<Teb_transmissao_empresa_bancoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Teb_transmissao_empresa_bancoUpdateDeleteGWT teb_transmissao_empresa_bancoUpdateDeleteGWT = new Teb_transmissao_empresa_bancoUpdateDeleteGWT();
                        teb_transmissao_empresa_bancoUpdateDeleteGWT.setTeb_transmissao_empresa_bancoConsult(Teb_transmissao_empresa_bancoConsultGWT.this);
                        teb_transmissao_empresa_bancoUpdateDeleteGWT.load(model);
                        teb_transmissao_empresa_bancoUpdateDeleteGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());
                b.setId("btnEditar");

                return b;
            }
        };
    }

    public void load() {
        teb_transmissao_empresa_bancoDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Teb_transmissao_empresa_bancoTGWT> list = teb_transmissao_empresa_bancoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Teb_transmissao_empresa_bancoTGWT> grid = new Grid<Teb_transmissao_empresa_bancoTGWT>(list, cm);
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
