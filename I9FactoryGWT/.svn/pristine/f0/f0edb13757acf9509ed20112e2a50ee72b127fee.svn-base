/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.relatorio;


import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.TextArea;
import java.util.TreeMap;

/**
 *
 * @author marcos
 */
public class DisplayEmailGWT extends com.extjs.gxt.ui.client.widget.Window {

    private TextField<String> tx_origem = new TextField<String>();
    private TextField<String> tx_destino = new TextField<String>();
    private TextField<String> tx_assunto = new TextField<String>();
    private HtmlEditor conteudo = new HtmlEditor();
    public Button btnviewDestino = new Button("");
    public Button btnEnviar = new Button("Enviar");
    private Button btnAnexo = new Button("anexo");
    public TextArea tx_Viewdestino = new TextArea();
    private com.extjs.gxt.ui.client.widget.Window viewDestino = new com.extjs.gxt.ui.client.widget.Window();
    private ToolBar bar = new ToolBar();
    private ContentPanel containerAnexo = new ContentPanel();
    private ContentPanel cpConteudo = new ContentPanel();
    private TreeMap<Integer, FileUploadField> treUpload = new TreeMap<Integer, FileUploadField>();
//    private ContentPanel cpMaster = new ContentPanel(new FillLayout());
    private com.extjs.gxt.ui.client.widget.form.FormPanel formPanel = new com.extjs.gxt.ui.client.widget.form.FormPanel();
    private MessageBox mb;
    private String urlServico;
    private HiddenField hiddenField_OP = new HiddenField();
    private HiddenField hiddenField_ORIGEM = new HiddenField();
    private HiddenField hiddenField_DESTINO = new HiddenField();
    private HiddenField hiddenField_ASSUNTO = new HiddenField();
    private HiddenField hiddenField_MSG = new HiddenField();
    private HiddenField hiddenField_NAME_FILE = new HiddenField();
    private FileUploadField upload;
    private String metodo;

    public DisplayEmailGWT(String urlServico, String metodo) {
        formPanel.setLayout(new FillLayout());
        this.urlServico = urlServico;
        this.metodo = metodo;
        setResizable(false);
        this.setSize(600, 450);
        this.setLayout(new FillLayout());
        this.add(formPanel);
        btnviewDestino.setToolTip("Ampliar a visualização");
        btnviewDestino.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                tx_Viewdestino.setValue(getTx_destino().getValue());
                viewDestino.setVisible(true);
            }
        });

        cpConteudo.setHeaderVisible(false);
        cpConteudo.setBodyBorder(false);
        cpConteudo.setBorders(false);
        cpConteudo.setHeight(280);

        viewDestino.setSize(500, 100);
        viewDestino.setHeading("Destinatários");
        viewDestino.setLayout(new FillLayout());
        viewDestino.add(tx_Viewdestino);
        viewDestino.setModal(true);

        btnEnviar.setToolTip("Enviar email");
        btnEnviar.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                enviarEmail();
            }
        });

        btnAnexo.setToolTip("Anexar arquivos");
        btnAnexo.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                addAnexo();
            }
        });
        configurePanel();

        formPanel.setAction(urlServico);
        formPanel.setMethod(com.extjs.gxt.ui.client.widget.form.FormPanel.Method.POST);
        formPanel.setEncoding(FormPanel.Encoding.MULTIPART);
        formPanel.addListener(Events.Submit, new Listener<FormEvent>() {
            @Override
            protected void finalize() throws Throwable {
                super.finalize(); //To change body of generated methods, choose Tools | Templates.
                if (mb != null) {
                    mb.close();
                }
            }

            public void handleEvent(FormEvent be) {
                String result = be.getResultHtml();
                result = result.trim();
                mb.close();
                getResult(result);

            }
        });
    }

    public void getResult(String result) {
        if (result.indexOf("sucesso") > -1) {
            Info.display("IMPORTANTE", result);
            setVisible(false);
        } else {
            MessageBox.alert("IMPORTANTE", "Problema ao executar a operação, favor tente novamente ", null);
        }

    }

    public void mountHiddenField() {

        hiddenField_OP.setName("op");
        hiddenField_DESTINO.setName("emailDestimo");
        hiddenField_ORIGEM.setName("emailOrigen");
        hiddenField_ASSUNTO.setName("assunto");
        hiddenField_MSG.setName("msg_email");
        hiddenField_NAME_FILE.setName("anexoT.file_name");


        formPanel.add(hiddenField_OP);
        formPanel.add(hiddenField_ORIGEM);
        formPanel.add(hiddenField_DESTINO);
        formPanel.add(hiddenField_ASSUNTO);
        formPanel.add(hiddenField_MSG);
        formPanel.add(hiddenField_NAME_FILE);
    }

    public void setValueHiddenField() {

        hiddenField_OP.setValue(this.metodo);
        hiddenField_ORIGEM.setValue(getTx_origem().getValue());
        hiddenField_ASSUNTO.setValue(getTx_assunto().getValue());
        hiddenField_DESTINO.setValue(getTx_destino().getValue() + ",");
        hiddenField_MSG.setValue(getConteudo().getRawValue());
        hiddenField_NAME_FILE.setValue(null);

        if (upload != null) {
            hiddenField_NAME_FILE.setValue(upload.getValue());
        }
    }

    public void enviarEmail() {
        mb = MessageBox.wait("Enviando email", " Aguarde", "");
        mountHiddenField();
        setValueHiddenField();
        formPanel.layout();
        formPanel.submit();
    }

    public void addAnexo() {
        if (upload == null) {
            upload = new FileUploadField();
            upload.setName("anexoT.arrayByte");
            upload.setWidth(400);
            formPanel.add(upload);
            final Button btnRemove = new Button("");
            btnRemove.addSelectionListener(new SelectionListener<ButtonEvent>() {
                @Override
                public void componentSelected(ButtonEvent ce) {
                    formPanel.remove(upload);
                    formPanel.layout();
                    formPanel.remove(btnRemove);
                    upload = null;
                    getBtnAnexo().setEnabled(true);
                    formPanel.layout();
                    layout();
                }
            });
            getBtnAnexo().setEnabled(false);
            btnRemove.setSize(23, 23);
            formPanel.add(btnRemove);
            formPanel.layout();
        }
    }

    public void configurePanel() {
        formPanel.setHeaderVisible(false);
        formPanel.setBodyBorder(false);
        formPanel.setBorders(false);
        formPanel.setFrame(true);

        getTx_origem().setWidth(400);
        getTx_destino().setWidth(400);
        getTx_assunto().setWidth(400);

        TableLayout layout = new TableLayout(3);
        layout.setCellSpacing(5);
        ContentPanel cp = new ContentPanel();
        cp.setLayout(layout);

        cpConteudo.setLayout(new RowLayout());
        cp.setHeaderVisible(false);

        layout = new TableLayout(2);
        layout.setCellSpacing(5);
        formPanel.setLayout(layout);

//        cp.add(new LabelField("De:"));
//        cp.add(getTx_origem());
//        cp.add(new LabelField(" "));

        cp.add(new LabelField("Para:"));
        cp.add(getTx_destino());
        cp.add(btnviewDestino);

        cp.add(new LabelField("Assunto:"));
        cp.add(getTx_assunto());
        cp.add(new LabelField(""));

        cpConteudo.setHeight(330);

        cpConteudo.setTopComponent(cp);

        cpConteudo.add(conteudo, new RowData(1, 1));

        formPanel.setTopComponent(cpConteudo);

        containerAnexo.setScrollMode(Style.Scroll.AUTO);
        containerAnexo.setHeaderVisible(false);
        containerAnexo.setBodyBorder(false);
        containerAnexo.setHeight(50);
        TableLayout layoutAnexo = new TableLayout(3);
        layoutAnexo.setCellPadding(5);
        containerAnexo.setLayout(layoutAnexo);
//        cpConteudo.setBottomComponent(containerAnexo);


        bar.add(getBtnAnexo());
        bar.setAlignment(Style.HorizontalAlignment.CENTER);
        bar.add(btnEnviar);
        bar.add(new FillToolItem());

        this.setBottomComponent(bar);
        layout();


    }

    /**
     * @return the tx_origem
     */
    public TextField<String> getTx_origem() {
        return tx_origem;
    }

    /**
     * @param tx_origem the tx_origem to set
     */
    public void setTx_origem(TextField<String> tx_origem) {
        this.tx_origem = tx_origem;
    }

    /**
     * @return the tx_destino
     */
    public TextField<String> getTx_destino() {
        return tx_destino;
    }

    /**
     * @param tx_destino the tx_destino to set
     */
    public void setTx_destino(TextField<String> tx_destino) {
        this.tx_destino = tx_destino;
    }

    /**
     * @return the tx_assunto
     */
    public TextField<String> getTx_assunto() {
        return tx_assunto;
    }

    /**
     * @param tx_assunto the tx_assunto to set
     */
    public void setTx_assunto(TextField<String> tx_assunto) {
        this.tx_assunto = tx_assunto;
    }

    /**
     * @return the conteudo
     */
    public HtmlEditor getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(HtmlEditor conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return the btnAnexo
     */
    public Button getBtnAnexo() {
        return btnAnexo;
    }

    /**
     * @param btnAnexo the btnAnexo to set
     */
    public void setBtnAnexo(Button btnAnexo) {
        this.btnAnexo = btnAnexo;
    }
}
