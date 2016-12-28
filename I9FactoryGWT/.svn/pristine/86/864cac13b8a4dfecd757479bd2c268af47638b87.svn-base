package br.com.i9factory.client.i9factory.factory.tic_tipo_credito;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.Dialog;

/**
 *
 * @author geoleite
 */
public class Tic_tipo_creditoUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Tic_tipo_creditoConsultGWT tic_tipo_creditoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tic_tipo_creditoDAOGWT tic_tipo_creditoDao = new Tic_tipo_creditoDAOGWT();
    private Tic_tipo_creditoTGWT tic_tipo_creditoT;
    private EasyTextField<String> tic_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tic_tx_nome = new EasyTextField<String>();

    public Tic_tipo_creditoUpdateDeleteGWT() {
        this.setSize("350", "150");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(4);
        getCpMaster().setLayout(layout);
        LabelField lftic_tx_nome = new LabelField("Nome:");
        lftic_tx_nome.setId("lftic_tx_nome");
        getCpMaster().add(lftic_tx_nome);
        tic_tx_nome.setWidth(320);
        tic_tx_nome.setId("tic_tx_nome");
        tic_tx_nome.setMaxLength(100);
        getCpMaster().add(tic_tx_nome);


    }

    public void load(Tic_tipo_creditoTGWT tic_tipo_creditoT) {
        this.tic_tipo_creditoT = tic_tipo_creditoT;
        tic_tx_nome.setValue(tic_tipo_creditoT.getTic_tx_nome());

    }

    public void btnUpdateAction(ButtonEvent ce) {
        tic_tipo_creditoT.setTic_tx_nome(tic_tx_nome.getValue());

        tic_tipo_creditoDao.alterar(tic_tipo_creditoT);
        Timer timer = new Timer() {
            public void run() {
                String msg = tic_tipo_creditoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        tic_tipo_creditoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        MessageBox.confirm("Aviso", "Tem certeza que deseja excluir registro?", new Listener<MessageBoxEvent>() {
            public void handleEvent(MessageBoxEvent be) {

                if (new Dialog().yesText.equalsIgnoreCase(be.getButtonClicked().getText())) {
                    tic_tipo_creditoDao.excluir(tic_tipo_creditoT);
                    Timer timer = new Timer() {
                        public void run() {
                            String msg = tic_tipo_creditoDao.getMsg();
                            if (msg == null) {
                                schedule(500);
                            } else {
                                if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                                    MessageBox.alert("Problemas", msg, null);
                                } else {
                                    Info.display("Resultado", msg);
                                    tic_tipo_creditoConsult.load();
                                    setVisible(false);
                                }
                            }
                        }
                    };
                    timer.schedule(500);
                }
            }
        });
    }

    /**
     * @return the tic_tipo_creditoConsult
     */
    public Tic_tipo_creditoConsultGWT getTic_tipo_creditoConsult() {
        return tic_tipo_creditoConsult;
    }

    /**
     * @param tic_tipo_creditoConsult the tic_tipo_creditoConsult to set
     */
    public void setTic_tipo_creditoConsult(Tic_tipo_creditoConsultGWT tic_tipo_creditoConsult) {
        this.tic_tipo_creditoConsult = tic_tipo_creditoConsult;
    }
}
