package br.com.i9factory.client.i9factory.factory.bco_banco;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyTextField;

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

/**
 *
 * @author geoleite
 */
public class Bco_bancoUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Bco_bancoConsultGWT bco_bancoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Bco_bancoDAOGWT bco_bancoDao = new Bco_bancoDAOGWT();
    private Bco_bancoTGWT bco_bancoT;
    private EasyTextField<String> bco_nr_id = new EasyTextField<String>();
    private EasyTextField<String> bco_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> bco_tx_telefone1 = new EasyTextField<String>();
    private EasyTextField<String> bco_tx_telefone2 = new EasyTextField<String>();
    private EasyTextField<String> bco_tx_nomecontato = new EasyTextField<String>();
    private EasyTextField<String> bco_tx_codigo = new EasyTextField<String>();

    public Bco_bancoUpdateDeleteGWT() {
        this.setSize("470", "240");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setHeaderVisible(false);
        getCpMaster().setLayout(layout);

        bco_tx_nome.setAllowBlank(false);
        bco_tx_codigo.setAllowBlank(false);
        bco_tx_nome.setWidth(300);
        getCpMaster().add(new LabelField("Nome:"));
        bco_tx_nome.setMaxLength(100);
        getCpMaster().add(bco_tx_nome);

        getCpMaster().add(new LabelField("Codigo:"));
        bco_tx_codigo.setMaxLength(3);
        getCpMaster().add(bco_tx_codigo);

        getCpMaster().add(new LabelField("Telefone(1):"));
        bco_tx_telefone1.setMaxLength(20);
        getCpMaster().add(bco_tx_telefone1);

        getCpMaster().add(new LabelField("telefone(2):"));
        bco_tx_telefone2.setMaxLength(20);
        getCpMaster().add(bco_tx_telefone2);

        bco_tx_nomecontato.setWidth(300);
        getCpMaster().add(new LabelField("Contatos:"));
        bco_tx_nomecontato.setMaxLength(100);
        getCpMaster().add(bco_tx_nomecontato);


    }

    public void load(Bco_bancoTGWT bco_bancoT) {
        this.bco_bancoT = bco_bancoT;
        bco_nr_id.setValue(bco_bancoT.getBco_nr_id() + "");
        bco_tx_nome.setValue(bco_bancoT.getBco_tx_nome());
        bco_tx_telefone1.setValue(bco_bancoT.getBco_tx_telefone1());
        bco_tx_telefone2.setValue(bco_bancoT.getBco_tx_telefone2());
        bco_tx_nomecontato.setValue(bco_bancoT.getBco_tx_nomecontato());
        bco_tx_codigo.setValue(bco_bancoT.getBco_tx_codigo());
    }

    public void btnUpdateAction(ButtonEvent ce) {
        if (!bco_tx_nome.validate() || !bco_tx_codigo.validate()) {
            MessageBox.alert("Problemas na validação", "Os campos: Nome e Codigo, são obrigatórios.", null);
        } else {

            bco_bancoT.setBco_nr_id(Integer.parseInt(bco_nr_id.getValue()));
            bco_bancoT.setBco_tx_nome(bco_tx_nome.getValue());
            bco_bancoT.setBco_tx_telefone1(bco_tx_telefone1.getValue());
            bco_bancoT.setBco_tx_telefone2(bco_tx_telefone2.getValue());
            bco_bancoT.setBco_tx_nomecontato(bco_tx_nomecontato.getValue());
            bco_bancoT.setBco_tx_codigo(bco_tx_codigo.getValue());

            bco_bancoDao.alterar(bco_bancoT);
            Timer timer = new Timer() {

                public void run() {
                    String msg = bco_bancoDao.getMsg();
                    if (msg == null) {
                        schedule(500);
                    } else {
                        if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                            MessageBox.alert("Problemas", msg, null);
                        } else {
                            Info.display("Resultado", msg);
                            bco_bancoConsult.load();
                            setVisible(false);
                        }
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void btnDeltAction(ButtonEvent ce) {

        bco_bancoDao.excluir(bco_bancoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = bco_bancoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        bco_bancoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the bco_bancoConsult
     */
    public Bco_bancoConsultGWT getBco_bancoConsult() {
        return bco_bancoConsult;
    }

    /**
     * @param bco_bancoConsult the bco_bancoConsult to set
     */
    public void setBco_bancoConsult(Bco_bancoConsultGWT bco_bancoConsult) {
        this.bco_bancoConsult = bco_bancoConsult;
    }
}
