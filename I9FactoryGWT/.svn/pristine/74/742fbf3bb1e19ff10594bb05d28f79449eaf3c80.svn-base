package br.com.i9factory.client.i9factory.factory.vw_arquivo_retorno_banco;

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
public class Vw_arquivo_retorno_bancoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Vw_arquivo_retorno_bancoConsultGWT vw_arquivo_retorno_bancoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Vw_arquivo_retorno_bancoDAOGWT vw_arquivo_retorno_bancoDao = new Vw_arquivo_retorno_bancoDAOGWT();
    private Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT;

    private EasyTextField<String> teb_nr_id = new EasyTextField<String>();
    private DateField teb_dt_envio = new DateField();
    private DateField teb_dt_retorno = new DateField();
    private EasyTextField<String> teb_tx_status = new EasyTextField<String>();
    private EasyTextField<String> teb_tx_operacao = new EasyTextField<String>();
    private DateField ple_dt_vencimento = new DateField();
    private EasyTextField<String> ple_tx_parcela = new EasyTextField<String>();
    private EasyTextField<String> ple_nr_valorparcela = new EasyTextField<String>();
    private EasyTextField<String> emp_nr_proposta = new EasyTextField<String>();
    private EasyTextField<String> cli_tx_nome = new EasyTextField<String>();


    public Vw_arquivo_retorno_bancoUpdateDeleteGWT() {
        this.setSize("500", "400");
	
        getCpMaster().setLayout(new TableLayout(2));
	LabelField lfteb_nr_id = new LabelField("teb_nr_id:");
        lfteb_nr_id.setId("lfteb_nr_id");
	getCpMaster().add(lfteb_nr_id);
        teb_nr_id.setId("teb_nr_id");
        teb_nr_id.setMaxLength(10);
        getCpMaster().add(teb_nr_id);

	LabelField lfteb_dt_envio = new LabelField("teb_dt_envio:");
        lfteb_dt_envio.setId("lfteb_dt_envio");
	getCpMaster().add(lfteb_dt_envio);
        teb_dt_envio.setId("teb_dt_envio");
        teb_dt_envio.setMaxLength(13);
        getCpMaster().add(teb_dt_envio);

	LabelField lfteb_dt_retorno = new LabelField("teb_dt_retorno:");
        lfteb_dt_retorno.setId("lfteb_dt_retorno");
	getCpMaster().add(lfteb_dt_retorno);
        teb_dt_retorno.setId("teb_dt_retorno");
        teb_dt_retorno.setMaxLength(13);
        getCpMaster().add(teb_dt_retorno);

	LabelField lfteb_tx_status = new LabelField("teb_tx_status:");
        lfteb_tx_status.setId("lfteb_tx_status");
	getCpMaster().add(lfteb_tx_status);
        teb_tx_status.setId("teb_tx_status");
        teb_tx_status.setMaxLength(100);
        getCpMaster().add(teb_tx_status);

	LabelField lfteb_tx_operacao = new LabelField("teb_tx_operacao:");
        lfteb_tx_operacao.setId("lfteb_tx_operacao");
	getCpMaster().add(lfteb_tx_operacao);
        teb_tx_operacao.setId("teb_tx_operacao");
        teb_tx_operacao.setMaxLength(1);
        getCpMaster().add(teb_tx_operacao);

	LabelField lfple_dt_vencimento = new LabelField("ple_dt_vencimento:");
        lfple_dt_vencimento.setId("lfple_dt_vencimento");
	getCpMaster().add(lfple_dt_vencimento);
        ple_dt_vencimento.setId("ple_dt_vencimento");
        ple_dt_vencimento.setMaxLength(13);
        getCpMaster().add(ple_dt_vencimento);

	LabelField lfple_tx_parcela = new LabelField("ple_tx_parcela:");
        lfple_tx_parcela.setId("lfple_tx_parcela");
	getCpMaster().add(lfple_tx_parcela);
        ple_tx_parcela.setId("ple_tx_parcela");
        ple_tx_parcela.setMaxLength(10);
        getCpMaster().add(ple_tx_parcela);

	LabelField lfple_nr_valorparcela = new LabelField("ple_nr_valorparcela:");
        lfple_nr_valorparcela.setId("lfple_nr_valorparcela");
	getCpMaster().add(lfple_nr_valorparcela);
        ple_nr_valorparcela.setId("ple_nr_valorparcela");
        ple_nr_valorparcela.setMaxLength(10);
        getCpMaster().add(ple_nr_valorparcela);

	LabelField lfemp_nr_proposta = new LabelField("emp_nr_proposta:");
        lfemp_nr_proposta.setId("lfemp_nr_proposta");
	getCpMaster().add(lfemp_nr_proposta);
        emp_nr_proposta.setId("emp_nr_proposta");
        emp_nr_proposta.setMaxLength(10);
        getCpMaster().add(emp_nr_proposta);

	LabelField lfcli_tx_nome = new LabelField("cli_tx_nome:");
        lfcli_tx_nome.setId("lfcli_tx_nome");
	getCpMaster().add(lfcli_tx_nome);
        cli_tx_nome.setId("cli_tx_nome");
        cli_tx_nome.setMaxLength(100);
        getCpMaster().add(cli_tx_nome);


    }

    public void load(Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT) {
	this.vw_arquivo_retorno_bancoT = vw_arquivo_retorno_bancoT;
		teb_nr_id.setValue(vw_arquivo_retorno_bancoT.getTeb_nr_id() + "");
		teb_dt_envio.setValue(vw_arquivo_retorno_bancoT.getTeb_dt_envio());
		teb_dt_retorno.setValue(vw_arquivo_retorno_bancoT.getTeb_dt_retorno());
		teb_tx_status.setValue(vw_arquivo_retorno_bancoT.getTeb_tx_status());
		teb_tx_operacao.setValue(vw_arquivo_retorno_bancoT.getTeb_tx_operacao());
		ple_dt_vencimento.setValue(vw_arquivo_retorno_bancoT.getPle_dt_vencimento());
		ple_tx_parcela.setValue(vw_arquivo_retorno_bancoT.getPle_tx_parcela());
		ple_nr_valorparcela.setValue(vw_arquivo_retorno_bancoT.getPle_nr_valorparcela() + "");
		emp_nr_proposta.setValue(vw_arquivo_retorno_bancoT.getEmp_nr_proposta() + "");
		cli_tx_nome.setValue(vw_arquivo_retorno_bancoT.getCli_tx_nome());

    }
    public void btnUpdateAction(ButtonEvent ce) {
		vw_arquivo_retorno_bancoT.setTeb_nr_id( Integer.parseInt(teb_nr_id.getValue()));
		vw_arquivo_retorno_bancoT.setTeb_dt_envio(teb_dt_envio.getValue());
		vw_arquivo_retorno_bancoT.setTeb_dt_retorno(teb_dt_retorno.getValue());
		vw_arquivo_retorno_bancoT.setTeb_tx_status(teb_tx_status.getValue());
		vw_arquivo_retorno_bancoT.setTeb_tx_operacao(teb_tx_operacao.getValue());
		vw_arquivo_retorno_bancoT.setPle_dt_vencimento(ple_dt_vencimento.getValue());
		vw_arquivo_retorno_bancoT.setPle_tx_parcela(ple_tx_parcela.getValue());
		vw_arquivo_retorno_bancoT.setPle_nr_valorparcela( Float.parseFloat(ple_nr_valorparcela.getValue()));
		vw_arquivo_retorno_bancoT.setEmp_nr_proposta( Integer.parseInt(emp_nr_proposta.getValue()));
		vw_arquivo_retorno_bancoT.setCli_tx_nome(cli_tx_nome.getValue());

	vw_arquivo_retorno_bancoDao.alterar(vw_arquivo_retorno_bancoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = vw_arquivo_retorno_bancoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  vw_arquivo_retorno_bancoConsult.load();
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
		  vw_arquivo_retorno_bancoDao.excluir(vw_arquivo_retorno_bancoT);
		  Timer timer = new Timer() {
	   	    public void run() {
 	     		String msg = vw_arquivo_retorno_bancoDao.getMsg();
 	     		if (msg == null) {
			  schedule(500);
	     		} else {
			  if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  		MessageBox.alert("Problemas", msg, null);
			  } else {
		  		Info.display("Resultado", msg);
		  		vw_arquivo_retorno_bancoConsult.load();
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
     * @return the vw_arquivo_retorno_bancoConsult
     */
    public Vw_arquivo_retorno_bancoConsultGWT getVw_arquivo_retorno_bancoConsult() {
        return vw_arquivo_retorno_bancoConsult;
    }

    /**
     * @param vw_arquivo_retorno_bancoConsult the vw_arquivo_retorno_bancoConsult to set
     */
    public void setVw_arquivo_retorno_bancoConsult(Vw_arquivo_retorno_bancoConsultGWT vw_arquivo_retorno_bancoConsult) {
        this.vw_arquivo_retorno_bancoConsult = vw_arquivo_retorno_bancoConsult;
    }

}

