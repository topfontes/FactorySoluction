/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.lan_lancamento;

import br.com.easynet.gwt.client.icons.Icones;
import br.com.i9factory.client.i9factory.factory.ctp_conta_pagar.Ctp_conta_pagarConsultGWT;
import br.com.i9factory.client.i9factory.factory.dao.Ctp_conta_pagarDAOGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Ctp_conta_pagarTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.datepicker.client.DatePicker;
import java.util.Date;

/**
 *
 * @author marcos
 */
public class BaixaTitulosGWT extends Window {

    private Ctp_conta_pagarTGWT ctp_conta_pagarTGWT = new Ctp_conta_pagarTGWT();
    private ContentPanel cpCtp = new ContentPanel();
    private ContentPanel cpBaixa = new ContentPanel();
    private NumberField nfValor = new NumberField();
    private DateField dtPag = new DateField();
    private SimpleComboBox<String> comboBaixa = new SimpleComboBox<String>();
    private Button btnbaixar = new Button("Baixar");
    private TextField<String> historico = new TextField<String>();
    private Ctp_conta_pagarConsultGWT ctp_conta_pagarConsult;
    NumberFormat format ;

    public BaixaTitulosGWT() {
        this.setHeading("Baixa do Contas A Pagar");
        this.setSize(420, 400);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        cpCtp.setLayout(layout);
        cpCtp.setHeaderVisible(false);
        ToolBar bar = new ToolBar();
        bar.setAlignment(HorizontalAlignment.CENTER);
        bar.add(new LabelToolItem("Título"));
        cpCtp.setTopComponent(bar);
        this.setFrame(true);

        btnbaixar.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                baixarTitulo();
            }
        });
        format = NumberFormat.getFormat("#,##0.00");
        nfValor.setFormat(format);

    }

    public boolean pagamentoValido() {
        
        try {
            boolean res = true;
            if (nfValor.getValue().floatValue() <= 0) {
                MessageBox.alert("IMPORTANTE", "O valor pago não pode ser menor que zero!", null);
                res = false;
            } else if (nfValor.getValue().floatValue() > ctp_conta_pagarTGWT.getCtp_saldo()) {
                MessageBox.alert("IMPORTANTE", "O valor pago não pode ser maior que o saldo (" + format.format(ctp_conta_pagarTGWT.getCtp_valor()) + ") !", null);
                res = false;
            }
            return res;
        } catch (Exception e) {
            return false;
        }

    }

    public void baixarTitulo() {

        if (pagamentoValido()) {
            ctp_conta_pagarTGWT.setCtp_vl_pago(ctp_conta_pagarTGWT.getCtp_vl_pago() + nfValor.getValue().floatValue());
            ctp_conta_pagarTGWT.setCtp_saldo(ctp_conta_pagarTGWT.getCtp_saldo() - nfValor.getValue().floatValue());
            ctp_conta_pagarTGWT.setCtp_tx_pago(ctp_conta_pagarTGWT.getCtp_saldo() == 0 ? "T" : "F");

            if (ctp_conta_pagarTGWT.getCtp_saldo() <= 0) {
                ctp_conta_pagarTGWT.setCtp_dt_pagamento(dtPag.getValue());
            }
            final Ctp_conta_pagarDAOGWT ctp_conta_pagarDao = new Ctp_conta_pagarDAOGWT();
            int id_conta = 0;//ultilizar apenas qd estiver usuando módulo finaceiro
            ctp_conta_pagarDao.baixar(ctp_conta_pagarTGWT, id_conta, nfValor.getValue().floatValue(), historico.getValue(), DateTimeFormat.getFormat("dd/MM/yyyy").format(dtPag.getValue()));
            Timer timer = new Timer() {

                public void run() {
                    String msg = ctp_conta_pagarDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            historico.setValue("");
                            ctp_conta_pagarConsult.load();
                            setVisible(false);
                            close();
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void load(Ctp_conta_pagarTGWT ctp_conta_pagarTGWT, Ctp_conta_pagarConsultGWT ctp_conta_pagarConsultGWT) {

        this.ctp_conta_pagarTGWT = ctp_conta_pagarTGWT;
        this.ctp_conta_pagarConsult = ctp_conta_pagarConsultGWT;
        cpCtp.add(new LabelField("Fornecedor:"));
        TextField<String> fornec = new TextField<String>();
        fornec.setWidth(300);
        fornec.setValue(ctp_conta_pagarTGWT.getFor_tx_nome());
        cpCtp.add(fornec);
        fornec.setEnabled(false);

        cpCtp.add(new LabelField("Tipo Despesa:"));
        TextField<String> tipo = new TextField<String>();
        tipo.setValue(ctp_conta_pagarTGWT.getTid_tx_nome());
        tipo.setEnabled(false);
        cpCtp.add(tipo);

        cpCtp.add(new LabelField("Documento:"));
        TextField<String> documento = new TextField<String>();
        documento.setValue(ctp_conta_pagarTGWT.getCtp_nr_doc() + "");
        documento.setEnabled(false);
        cpCtp.add(documento);

        cpCtp.add(new LabelField("Vencimento:"));
        TextField<String> venc = new TextField<String>();
        venc.setValue(DateTimeFormat.getFormat("dd/MM/yyyy").format(ctp_conta_pagarTGWT.getCtp_dt_vencimento()));
        venc.setEnabled(false);
        cpCtp.add(venc);


        TextField<String> valor = new TextField<String>();
        valor.setValue(NumberFormat.getFormat("#,##0.00").format(ctp_conta_pagarTGWT.getCtp_valor()));
        valor.setEnabled(false);
        cpCtp.add(new LabelField("Valor:"));
        cpCtp.add(valor);

        cpCtp.add(new LabelField("Obs:"));
        TextField<String> obs = new TextField<String>();
        obs.setWidth(300);
        obs.setValue(ctp_conta_pagarTGWT.getCtp_tx_obs());
        obs.setEnabled(false);
        cpCtp.add(obs);

        this.add(cpCtp, new RowData(1, 1, new Margins(4, 4, 4, 4)));

        ToolBar bar = new ToolBar();
        bar.add(new LabelToolItem("Baixa do Título"));
        bar.setAlignment(HorizontalAlignment.CENTER);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);

        cpBaixa.setLayout(layout);
        cpBaixa.setHeaderVisible(false);
        cpBaixa.setTopComponent(bar);
        cpBaixa.add(new LabelField("Dt. Baixa:"));
        dtPag.setValue(new Date());
        dtPag.getPropertyEditor().setFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        cpBaixa.add(dtPag);

        cpBaixa.add(new LabelField("Conta:"));
        comboBaixa.setWidth(250);
        comboBaixa.setEmptyText("Caixa");
        cpBaixa.add(comboBaixa);

        cpBaixa.add(new LabelField("Valor Pago:"));
        nfValor.setValue(ctp_conta_pagarTGWT.getCtp_saldo());
        nfValor.setFormat(NumberFormat.getFormat("#,##0.00"));
        cpBaixa.add(nfValor);

        cpBaixa.add(new LabelField("Obs:"));
        historico.setWidth(300);
        cpBaixa.add(historico);
        historico.setEmptyText("Se necessário digite uma observação");
        this.add(cpBaixa, new RowData(1, 1, new Margins(4, 4, 4, 4)));

        ToolBar barbaixa = new ToolBar();
        barbaixa.setAlignment(HorizontalAlignment.CENTER);
        btnbaixar.setIcon(Icones.ICONS.aplicar());
        barbaixa.add(btnbaixar);

        this.setBottomComponent(barbaixa);

    }
}
