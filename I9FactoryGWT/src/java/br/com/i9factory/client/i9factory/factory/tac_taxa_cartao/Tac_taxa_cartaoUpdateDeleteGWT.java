/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.tac_taxa_cartao;

import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.i9factory.factory.dao.Tac_taxa_cartaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Car_cartaoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Tac_taxa_cartaoTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Tac_taxa_cartaoConsultaGWT consultaGWT;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tac_taxa_cartaoDAOGWT tac_taxa_cartaoDAOGWT = new Tac_taxa_cartaoDAOGWT();
    protected EasyTextField<String> tac_tx_nome = new EasyTextField<String>();
    protected EasyNumberField tac_nr_taxa = new EasyNumberField();
    private Car_cartaoTGWT car_cartaoT;
    private ContentPanel cp;
    private Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT;

    public Tac_taxa_cartaoUpdateDeleteGWT() {

        this.setSize("370", "300");
        this.setHeading("Alterar Taxa");
        TableLayout layout = new TableLayout(3);
        layout.setCellPadding(3);

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

    }

    public void load(Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT) {
        this.tac_taxa_cartaoTGWT = tac_taxa_cartaoTGWT;
        tac_tx_nome.setValue(tac_taxa_cartaoTGWT.getTac_tx_nome());
        tac_nr_taxa.setValue(tac_taxa_cartaoTGWT.getTac_nr_taxa());
        layout();
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        final Tac_taxa_cartaoDAOGWT tac_taxa_cartaoDAOGWT = new Tac_taxa_cartaoDAOGWT();
        tac_taxa_cartaoDAOGWT.delete(tac_taxa_cartaoTGWT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (tac_taxa_cartaoDAOGWT.getMsg() != null) {
                    if (tac_taxa_cartaoDAOGWT.getMsg().indexOf("sucesso") > -1) {
                        consultaGWT.load();
                        setVisible(false);
                        close();
                    }
                } else {
                    schedule(500);
                }
            }
        };
        timer.schedule(300);

    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        //super.btnUpdateAction(ce); //To change body of generated methods, choose Tools | Templates.
        final Tac_taxa_cartaoDAOGWT tac_taxa_cartaoDAOGWT = new Tac_taxa_cartaoDAOGWT();
        tac_taxa_cartaoTGWT.setTac_nr_taxa(tac_nr_taxa.getValue().floatValue());
        tac_taxa_cartaoTGWT.setTac_tx_nome(tac_tx_nome.getValue());
        tac_taxa_cartaoDAOGWT.update(tac_taxa_cartaoTGWT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (tac_taxa_cartaoDAOGWT.getMsg() != null) {
                    if (tac_taxa_cartaoDAOGWT.getMsg().indexOf("sucesso") > -1) {
                        consultaGWT.load();
                        setVisible(false);
                        close();
                    }
                } else {
                    schedule(500);
                }
            }
        };
        timer.schedule(300);
    }

    /**
     * @return the consultaGWT
     */
    public Tac_taxa_cartaoConsultaGWT getConsultaGWT() {
        return consultaGWT;
    }

    /**
     * @param consultaGWT the consultaGWT to set
     */
    public void setConsultaGWT(Tac_taxa_cartaoConsultaGWT consultaGWT) {
        this.consultaGWT = consultaGWT;
    }

}
