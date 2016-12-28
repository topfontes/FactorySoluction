/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.retorno;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.Constantes;
import br.com.i9factory.client.i9factory.factory.arb_arquivobanco.Arb_arquivobancoConsultGWT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.FileUpload;

/**
 *
 * @author geoleite
 */
public class RetornoInsertGWT extends CadastrarBaseGWT implements IListenetResponse{

    private FormPanel fpRetorno = new FormPanel();
    private FileUploadField fileUpload = new FileUploadField();
    private Arb_arquivobancoConsultGWT arb_arquivobancoConsultGWT;
    private MessageBox mb;

    public RetornoInsertGWT() {
        fpRetorno.setHeaderVisible(false);
        setHeading("Upload arquivo retorno");
        setSize(370, 140);
        getCpMaster().add(fpRetorno);
        fpRetorno.setMethod(FormPanel.Method.POST);
        fpRetorno.setAction(Constantes.URL + "i9factory/factory/retorno/retorno.jsp");
        fpRetorno.setEncoding(FormPanel.Encoding.MULTIPART);
        HiddenField hfOp = new HiddenField();
        hfOp.setName("op");
        hfOp.setValue("registrarBaixa");
        fpRetorno.add(hfOp);
        fileUpload.setName("arquivo");
        fileUpload.setFieldLabel("Arquivo Retorno");
        fpRetorno.add(fileUpload);

        fpRetorno.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                mb = MessageBox.progress("Leitura do arquivo retorno", "Aguarde!!!", "Requisitando o servidor");
                JSONValue jsonValue = JSONParser.parse(be.getResultHtml());
                read(jsonValue);
            }
        });
    }

    public void btnInsertAction(ButtonEvent ce) {
        fpRetorno.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                Info.display("Resutado", "Upload efetuao com sucesso.");
                RetornoInsertGWT.this.setVisible(false);
                if (arb_arquivobancoConsultGWT != null) {
                    arb_arquivobancoConsultGWT.load();
                }
            }
        });
        fpRetorno.submit();

    }

    /**
     * @return the arb_arquivobancoConsultGWT
     */
    public Arb_arquivobancoConsultGWT getArb_arquivobancoConsultGWT() {
        return arb_arquivobancoConsultGWT;
    }

    /**
     * @param arb_arquivobancoConsultGWT the arb_arquivobancoConsultGWT to set
     */
    public void setArb_arquivobancoConsultGWT(Arb_arquivobancoConsultGWT arb_arquivobancoConsultGWT) {
        this.arb_arquivobancoConsultGWT = arb_arquivobancoConsultGWT;
    }

    public void read(JSONValue jsonValue) {
        mb.close();
    }
}
