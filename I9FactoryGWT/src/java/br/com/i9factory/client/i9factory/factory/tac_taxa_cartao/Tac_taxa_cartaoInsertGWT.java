/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.tac_taxa_cartao;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.i9factory.factory.dao.Tac_taxa_cartaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Car_cartaoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Tac_taxa_cartaoTGWT;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.SwallowEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoInsertGWT extends CadastrarBaseGWT {

    private Tac_taxa_cartaoConsultaGWT tac_taxa_cartaoConsultaGWT;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tac_taxa_cartaoDAOGWT tac_taxa_cartaoDAOGWT = new Tac_taxa_cartaoDAOGWT();
    protected EasyTextField<String> tac_tx_nome = new EasyTextField<String>();
    protected EasyNumberField tac_nr_taxa = new EasyNumberField();
    private Car_cartaoTGWT car_cartaoT;
    private ContentPanel cp;
    private Grid<Tac_taxa_cartaoTGWT> grid;
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Button btnADD = new Button("Add", ICONS.add());

    public Tac_taxa_cartaoInsertGWT(final Car_cartaoTGWT car_cartaoT) {

        this.car_cartaoT = car_cartaoT;
        this.setSize("370", "300");
        this.setHeading("Cadastro de Taxas");
        TableLayout layout = new TableLayout(3);
        layout.setCellPadding(3);
        getCpMaster().setTopComponent(new LabelField(car_cartaoT.getCar_tx_nome()));

        getCpMaster().setHeaderVisible(false);
        getCpMaster().setLayout(layout);

        tac_tx_nome.setAllowBlank(false);
        tac_tx_nome.setWidth(220);
        getCpMaster().add(new LabelField("Nome:"));
        tac_tx_nome.setMaxLength(100);
        getCpMaster().add(tac_tx_nome);
        getCpMaster().add(new Label(" "));

        tac_nr_taxa.setAllowBlank(false);
        tac_nr_taxa.setWidth(70);
        getCpMaster().add(new LabelField("% Taxa:"));
        tac_nr_taxa.setMaxLength(100);
        getCpMaster().add(tac_nr_taxa);
        getCpMaster().add(btnADD);
        configGrid();

        btnADD.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT = new Tac_taxa_cartaoTGWT();
                tac_taxa_cartaoTGWT.setCar_nr_id(car_cartaoT.getCar_nr_id());
                tac_taxa_cartaoTGWT.setTac_tx_nome(tac_tx_nome.getValue());
                tac_taxa_cartaoTGWT.setTac_nr_taxa(tac_nr_taxa.getValue().floatValue());
                grid.getStore().insert(tac_taxa_cartaoTGWT,grid.getStore().getCount());
                grid.getView().refresh(true);
            }
        });
        layout();
    }

    public void configGrid() {
        cp = new ContentPanel(new FillLayout());
        cp.setHeaderVisible(false);
        cp.setHeight(300);
        getCpMaster().setBottomComponent(cp);

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("tac_tx_nome");
        column.setHeader("Nome");
        column.setWidth(200);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("tac_nr_taxa");
        column.setHeader("%taxa");
        column.setWidth(70);
        column.setAlignment(Style.HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(Style.HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);
        ColumnModel cm = new ColumnModel(configs);

        grid = new Grid(new ListStore<Tac_taxa_cartaoTGWT>(), cm);
        cp.add(grid);
        cp.layout();

    }

    private GridCellRenderer<Tac_taxa_cartaoTGWT> getEditarRender() {
        return new GridCellRenderer<Tac_taxa_cartaoTGWT>() {

            public Object render(final Tac_taxa_cartaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tac_taxa_cartaoTGWT> store, final Grid<Tac_taxa_cartaoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        grid.getStore().remove(model);
                        grid.getView().refresh(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Remover");
                b.setIcon(ICONS.del());

                return b;
            }
        };
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        String array = "";
        for (Tac_taxa_cartaoTGWT taxa : grid.getStore().getModels()) {
            array+=taxa.getTac_tx_nome()+"|"+taxa.getTac_nr_taxa()+"$";
        }
        Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT = new Tac_taxa_cartaoTGWT();
        tac_taxa_cartaoTGWT.setCar_nr_id(car_cartaoT.getCar_nr_id());
        
        tac_taxa_cartaoDAOGWT.insert(tac_taxa_cartaoTGWT,array);
        Timer timer = new Timer() {

            @Override
            public void run() {
                String msg = tac_taxa_cartaoDAOGWT.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            btnLimpartAction(null);
                            tac_tx_nome.setValue("");
                            tac_nr_taxa.setValue(null);
                            grid.getStore().removeAll();
                            grid.getView().refresh(true);
                            tac_taxa_cartaoConsultaGWT.load();
                            setVisible(false);
                            close();
                        }
                    }
            }
        };
        timer.schedule(1000);
        
    }

    /**
     * @return the tac_taxa_cartaoConsultaGWT
     */
    public Tac_taxa_cartaoConsultaGWT getTac_taxa_cartaoConsultaGWT() {
        return tac_taxa_cartaoConsultaGWT;
    }

    /**
     * @param tac_taxa_cartaoConsultaGWT the tac_taxa_cartaoConsultaGWT to set
     */
    public void setTac_taxa_cartaoConsultaGWT(Tac_taxa_cartaoConsultaGWT tac_taxa_cartaoConsultaGWT) {
        this.tac_taxa_cartaoConsultaGWT = tac_taxa_cartaoConsultaGWT;
    }

}
