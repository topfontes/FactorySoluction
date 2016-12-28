package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Vw_arquivo_retorno_bancoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Vw_arquivo_retorno_bancoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT;

    public void consultarTodos(String data) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("vw_arquivo_retorno_bancoT.teb_dt_envio",data);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }

    public void consultarHistoricoParcela(int ple_nr_id) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "historico_par");
        param.put("vw_arquivo_retorno_bancoT.teb_nr_id",ple_nr_id+"");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }

    public void inserir(Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").isString().stringValue();
                    msg = result;
                }
            }
        };
        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
        param.put("vw_arquivo_retorno_bancoT.teb_nr_id", vw_arquivo_retorno_bancoT.getTeb_nr_id() + "");
        param.put("vw_arquivo_retorno_bancoT.teb_dt_envio", dtfDate.format(vw_arquivo_retorno_bancoT.getTeb_dt_envio()));
        param.put("vw_arquivo_retorno_bancoT.teb_dt_retorno", dtfDate.format(vw_arquivo_retorno_bancoT.getTeb_dt_retorno()));
        param.put("vw_arquivo_retorno_bancoT.teb_tx_status", vw_arquivo_retorno_bancoT.getTeb_tx_status() + "");
        param.put("vw_arquivo_retorno_bancoT.teb_tx_operacao", vw_arquivo_retorno_bancoT.getTeb_tx_operacao() + "");
        param.put("vw_arquivo_retorno_bancoT.ple_dt_vencimento", dtfDate.format(vw_arquivo_retorno_bancoT.getPle_dt_vencimento()));
        param.put("vw_arquivo_retorno_bancoT.ple_tx_parcela", vw_arquivo_retorno_bancoT.getPle_tx_parcela() + "");
        param.put("vw_arquivo_retorno_bancoT.ple_nr_valorparcela", vw_arquivo_retorno_bancoT.getPle_nr_valorparcela() + "");
        param.put("vw_arquivo_retorno_bancoT.emp_nr_proposta", vw_arquivo_retorno_bancoT.getEmp_nr_proposta() + "");
        param.put("vw_arquivo_retorno_bancoT.cli_tx_nome", vw_arquivo_retorno_bancoT.getCli_tx_nome() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("vw_arquivo_retorno_banco").isObject();
                    Vw_arquivo_retorno_bancoDAOGWT.this.vw_arquivo_retorno_bancoT = lerRegistroJson(registro);
                }
            }
        };
        this.vw_arquivo_retorno_bancoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("vw_arquivo_retorno_bancoT.teb_nr_id", vw_arquivo_retorno_bancoT.getTeb_nr_id() + "");
        param.put("vw_arquivo_retorno_bancoT.teb_dt_envio", dtfDate.format(vw_arquivo_retorno_bancoT.getTeb_dt_envio()));
        param.put("vw_arquivo_retorno_bancoT.teb_dt_retorno", dtfDate.format(vw_arquivo_retorno_bancoT.getTeb_dt_retorno()));
        param.put("vw_arquivo_retorno_bancoT.teb_tx_status", vw_arquivo_retorno_bancoT.getTeb_tx_status() + "");
        param.put("vw_arquivo_retorno_bancoT.teb_tx_operacao", vw_arquivo_retorno_bancoT.getTeb_tx_operacao() + "");
        param.put("vw_arquivo_retorno_bancoT.ple_dt_vencimento", dtfDate.format(vw_arquivo_retorno_bancoT.getPle_dt_vencimento()));
        param.put("vw_arquivo_retorno_bancoT.ple_tx_parcela", vw_arquivo_retorno_bancoT.getPle_tx_parcela() + "");
        param.put("vw_arquivo_retorno_bancoT.ple_nr_valorparcela", vw_arquivo_retorno_bancoT.getPle_nr_valorparcela() + "");
        param.put("vw_arquivo_retorno_bancoT.emp_nr_proposta", vw_arquivo_retorno_bancoT.getEmp_nr_proposta() + "");
        param.put("vw_arquivo_retorno_bancoT.cli_tx_nome", vw_arquivo_retorno_bancoT.getCli_tx_nome() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Vw_arquivo_retorno_bancoTGWT> lista = new ListStore<Vw_arquivo_retorno_bancoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT = lerRegistroJson(registro);
                lista.add(vw_arquivo_retorno_bancoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Vw_arquivo_retorno_bancoTGWT lerRegistroJson(JSONObject registro) {
        Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoTGWT = new Vw_arquivo_retorno_bancoTGWT();
        Integer teb_nr_id = Integer.parseInt(registro.get("teb_nr_id").isString().stringValue());
        vw_arquivo_retorno_bancoTGWT.setTeb_nr_id(teb_nr_id);

        Date teb_dt_envio = dtfDate.parse(registro.get("teb_dt_envio").isString().stringValue());
        vw_arquivo_retorno_bancoTGWT.setTeb_dt_envio(teb_dt_envio);


//        Date teb_dt_retorno = dtfDate.parse(registro.get("teb_dt_retorno").isString().stringValue());
//        vw_arquivo_retorno_bancoTGWT.setTeb_dt_retorno(teb_dt_retorno);

        String teb_tx_status = registro.get("teb_tx_status").isString().stringValue();
        vw_arquivo_retorno_bancoTGWT.setTeb_tx_status(teb_tx_status);

        String teb_tx_operacao = registro.get("teb_tx_operacao").isString().stringValue();
        vw_arquivo_retorno_bancoTGWT.setTeb_tx_operacao(teb_tx_operacao);

        Date ple_dt_vencimento = dtfDate.parse(registro.get("ple_dt_vencimento").isString().stringValue());
        vw_arquivo_retorno_bancoTGWT.setPle_dt_vencimento(ple_dt_vencimento);

        String ple_tx_parcela = registro.get("ple_tx_parcela").isString().stringValue();
        vw_arquivo_retorno_bancoTGWT.setPle_tx_parcela(ple_tx_parcela);

        float ple_nr_valorparcela = Float.parseFloat(registro.get("ple_nr_valorparcela").isString().stringValue());
        vw_arquivo_retorno_bancoTGWT.setPle_nr_valorparcela(ple_nr_valorparcela);

        Integer emp_nr_proposta = Integer.parseInt(registro.get("emp_nr_proposta").isString().stringValue());
        vw_arquivo_retorno_bancoTGWT.setEmp_nr_proposta(emp_nr_proposta);

        String cli_tx_nome = registro.get("cli_tx_nome").isString().stringValue();
        vw_arquivo_retorno_bancoTGWT.setCli_tx_nome(cli_tx_nome);


        return vw_arquivo_retorno_bancoTGWT;
    }

    /**
     * @return the list
     */
    public ListStore getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ListStore list) {
        this.list = list;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the vw_arquivo_retorno_bancoT
     */
    public Vw_arquivo_retorno_bancoTGWT getVw_arquivo_retorno_bancoT() {
        return vw_arquivo_retorno_bancoT;
    }

    /**
     * @param vw_arquivo_retorno_bancoTGWT the vw_arquivo_retorno_bancoTGWT to set
     */
    public void setVw_arquivo_retorno_bancoTGWT(Vw_arquivo_retorno_bancoTGWT vw_arquivo_retorno_bancoT) {
        this.vw_arquivo_retorno_bancoT = vw_arquivo_retorno_bancoT;
    }
}
