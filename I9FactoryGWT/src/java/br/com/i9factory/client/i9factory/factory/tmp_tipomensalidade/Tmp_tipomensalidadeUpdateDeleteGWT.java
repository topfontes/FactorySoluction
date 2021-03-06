package br.com.i9factory.client.i9factory.factory.tmp_tipomensalidade;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.easynet.gwt.client.component.EasyNumberField;
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
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Tmp_tipomensalidadeUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Tmp_tipomensalidadeConsultGWT tmp_tipomensalidadeConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tmp_tipomensalidadeDAOGWT tmp_tipomensalidadeDao = new Tmp_tipomensalidadeDAOGWT();
    private Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT;
    private EasyTextField<String> tmp_nr_id = new EasyTextField<String>();
    private EasyTextField<String> tmp_tx_nome = new EasyTextField<String>();
    private EasyTextField<String> tmp_tx_descricao = new EasyTextField<String>();
    private EasyNumberField tmp_nr_valor = new EasyNumberField();

    public Tmp_tipomensalidadeUpdateDeleteGWT() {
        this.setSize("470", "170");
        this.setHeading("Alterar Tipo de Mensalidade");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        tmp_tx_nome.setAllowBlank(false);
        tmp_tx_nome.setWidth(300);
        getCpMaster().add(new LabelField("Nome:"));
        tmp_tx_nome.setMaxLength(100);
        getCpMaster().add(tmp_tx_nome);

        tmp_tx_descricao.setAllowBlank(false);
        tmp_tx_descricao.setWidth(300);
        getCpMaster().add(new LabelField("Descrição:"));
        tmp_tx_descricao.setMaxLength(250);
        getCpMaster().add(tmp_tx_descricao);

        tmp_nr_valor.setAllowBlank(false);
        getCpMaster().add(new LabelField("Taxa %:"));
        tmp_nr_valor.setMaxLength(10);
        getCpMaster().add(tmp_nr_valor);

    }

    public void load(Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT) {
        this.tmp_tipomensalidadeT = tmp_tipomensalidadeT;
        tmp_nr_id.setValue(tmp_tipomensalidadeT.getTmp_nr_id() + "");
        tmp_tx_nome.setValue(tmp_tipomensalidadeT.getTmp_tx_nome());
        tmp_tx_descricao.setValue(tmp_tipomensalidadeT.getTmp_tx_descricao());
        tmp_nr_valor.setValue(tmp_tipomensalidadeT.getTmp_nr_valor());

    }

    public void btnUpdateAction(ButtonEvent ce) {
        tmp_tipomensalidadeT.setTmp_nr_id(Integer.parseInt(tmp_nr_id.getValue()));
        tmp_tipomensalidadeT.setTmp_tx_nome(tmp_tx_nome.getValue());
        tmp_tipomensalidadeT.setTmp_tx_descricao(tmp_tx_descricao.getValue());
        tmp_tipomensalidadeT.setTmp_nr_valor(tmp_nr_valor.getValue().floatValue());

        tmp_tipomensalidadeDao.alterar(tmp_tipomensalidadeT);
        Timer timer = new Timer() {

            public void run() {
                String msg = tmp_tipomensalidadeDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        tmp_tipomensalidadeConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        tmp_tipomensalidadeDao.excluir(tmp_tipomensalidadeT);
        Timer timer = new Timer() {

            public void run() {
                String msg = tmp_tipomensalidadeDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        tmp_tipomensalidadeConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the tmp_tipomensalidadeConsult
     */
    public Tmp_tipomensalidadeConsultGWT getTmp_tipomensalidadeConsult() {
        return tmp_tipomensalidadeConsult;
    }

    /**
     * @param tmp_tipomensalidadeConsult the tmp_tipomensalidadeConsult to set
     */
    public void setTmp_tipomensalidadeConsult(Tmp_tipomensalidadeConsultGWT tmp_tipomensalidadeConsult) {
        this.tmp_tipomensalidadeConsult = tmp_tipomensalidadeConsult;
    }
}
