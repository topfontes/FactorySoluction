/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.dep_dependente;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.i9factory.client.i9factory.factory.transfer.*;
import br.com.i9factory.client.i9factory.factory.dao.*;
import br.com.easynet.gwt.client.CadastrarBaseGWT;

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
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Dep_dependenteInsertGWT extends CadastrarBaseGWT {

    private Dep_dependenteConsultGWT dep_dependenteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Dep_dependenteDAOGWT dep_dependenteDao = new Dep_dependenteDAOGWT();
    private TextField<String> dep_nr_id = new TextField<String>();
    private TextField<String> cli_nr_id = new TextField<String>();
    private TextField<String> dep_tx_nome = new TextField<String>();
    private DateField dep_dt_nascimento = new DateField();
    private TextField<String> dep_tx_grauparentesco = new TextField<String>();
    private Cli_clienteTGWT cli_clienteTGWT;
    private RadioGroup radioGroup = new RadioGroup();

    public Dep_dependenteInsertGWT(Cli_clienteTGWT cli_clienteTGWT) {
        this.cli_clienteTGWT = cli_clienteTGWT;
        this.setHeading("Cadastro de Dependentes -" + cli_clienteTGWT.getCli_tx_nome());

        this.setSize(560, 190);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);

        getCpMaster().add(new LabelField("Nome:"));
        dep_tx_nome.setWidth(400);
        dep_tx_nome.setMaxLength(200);
        dep_tx_nome.setAllowBlank(false);
        getCpMaster().add(dep_tx_nome);

        getCpMaster().add(new LabelField("Dt. Nascimento:"));
        dep_dt_nascimento.getPropertyEditor().setFormat(dtfDate);
        dep_dt_nascimento.setAllowBlank(false);
        getCpMaster().add(dep_dt_nascimento);

        getCpMaster().add(new LabelField("Parentesco:"));

        Radio nenhum = new Radio();
        nenhum.setValue(true);
        nenhum.setBoxLabel("Nenhum");

        Radio filho = new Radio();
        filho.setBoxLabel("Filho(a)");

        Radio irmao = new Radio();
        irmao.setBoxLabel("irmão(ã)");

        Radio esposo = new Radio();
        esposo.setBoxLabel("Esposo(a)");

        Radio outros = new Radio();
        outros.setBoxLabel("Outros");

        Radio pai = new Radio();
        pai.setBoxLabel("Pai/Mãe");


        radioGroup.add(nenhum);
        radioGroup.add(pai);
        radioGroup.add(irmao);
        radioGroup.add(filho);
        radioGroup.add(esposo);
        radioGroup.add(outros);

        getCpMaster().add(radioGroup);
    }

    public void btnInsertAction(ButtonEvent ce) {
        Dep_dependenteTGWT dep_dependenteT = new Dep_dependenteTGWT();
        dep_dependenteT.setCli_nr_id(cli_clienteTGWT.getCli_nr_id());
        dep_dependenteT.setDep_tx_nome(dep_tx_nome.getValue());
        dep_dependenteT.setDep_dt_nascimento(dep_dt_nascimento.getValue());
        String parentesco = "";
        if(radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Nenhum")){
            parentesco ="N";
        }else  if(radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Pai/Mãe")){
            parentesco ="P";
        }else if(radioGroup.getValue().getBoxLabel().equalsIgnoreCase("irmão(ã)")){
            parentesco ="I";
        }else  if(radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Filho(a)")){
            parentesco ="F";
        }else  if(radioGroup.getValue().getBoxLabel().equalsIgnoreCase("Esposo(a)")){
            parentesco ="E";
        }else{
           parentesco ="O";
        }

        dep_dependenteT.setDep_tx_grauparentesco(parentesco);

        dep_dependenteDao.inserir(dep_dependenteT);
        Timer timer = new Timer() {

            public void run() {
                String msg = dep_dependenteDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        dep_dependenteConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        dep_nr_id.setValue("");
        cli_nr_id.setValue("");
        dep_tx_nome.setValue("");
        dep_dt_nascimento.setValue(null);
        dep_tx_grauparentesco.setValue("");

    }

    /**
     * @return the dep_dependenteConsult
     */
    public Dep_dependenteConsultGWT getDep_dependenteConsult() {
        return dep_dependenteConsult;
    }

    /**
     * @param dep_dependenteConsult the dep_dependenteConsult to set
     */
    public void setDep_dependenteConsult(Dep_dependenteConsultGWT dep_dependenteConsult) {
        this.dep_dependenteConsult = dep_dependenteConsult;
    }
}
