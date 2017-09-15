/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.car_cartao;

import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyTextField;
import br.com.i9factory.client.i9factory.factory.dao.Car_cartaoDAOGWT;
import br.com.i9factory.client.i9factory.factory.relatorio.CarteiraGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Bco_bancoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Car_cartaoTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author topfontes
 */
public class Car_cartaoUpdateDeleteGWT extends AlterarExcluirBaseGWT{
    private Car_cartaoConsultGWT car_cartaoConsultGWT;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Car_cartaoDAOGWT car_cartaoDAOGWT = new Car_cartaoDAOGWT();
    private Car_cartaoTGWT car_cartaoT;
    protected EasyTextField<String> car_tx_nome = new EasyTextField<String>();

    public Car_cartaoUpdateDeleteGWT() {
        this.setSize("470", "240");
        this.setHeading("Cadastro de Bancos");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);

        getCpMaster().setHeaderVisible(false);
        getCpMaster().setLayout(layout);

        car_tx_nome.setAllowBlank(false);
        car_tx_nome.setWidth(300);
        getCpMaster().add(new LabelField("Nome:"));
        car_tx_nome.setMaxLength(100);
        getCpMaster().add(car_tx_nome);
    }
    
    
    public void load(Car_cartaoTGWT car_cartaoTGWT) {
        this.car_cartaoT = car_cartaoTGWT;
        car_tx_nome.setValue(car_cartaoTGWT.getCar_tx_nome());
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        if (!car_tx_nome.validate()) {
            MessageBox.alert("Problemas na validação", "Os campos: Nome e Codigo, são obrigatórios.", null);
        } else { 
            car_cartaoT.setCar_tx_nome(car_tx_nome.getValue());
            car_cartaoDAOGWT.update(car_cartaoT);
            Timer timer = new Timer() {

                public void run() {
                    String msg = car_cartaoDAOGWT.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            getCar_cartaoConsultGWT().load();
                            setVisible(false);
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        car_cartaoDAOGWT.delete(car_cartaoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = car_cartaoDAOGWT.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        getCar_cartaoConsultGWT().load();
                        setVisible(false);
                        close();
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the car_cartaoConsultGWT
     */
    public Car_cartaoConsultGWT getCar_cartaoConsultGWT() {
        return car_cartaoConsultGWT;
    }

    /**
     * @param car_cartaoConsultGWT the car_cartaoConsultGWT to set
     */
    public void setCar_cartaoConsultGWT(Car_cartaoConsultGWT car_cartaoConsultGWT) {
        this.car_cartaoConsultGWT = car_cartaoConsultGWT;
    }
    
    
}
