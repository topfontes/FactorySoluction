package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Teb_transmissao_empresa_bancoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Teb_transmissao_empresa_bancoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT) {
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
        param.put("teb_transmissao_empresa_bancoT.teb_nr_id", teb_transmissao_empresa_bancoT.getTeb_nr_id() + "");
        param.put("teb_transmissao_empresa_bancoT.teb_dt_envio", dtfDate.format(teb_transmissao_empresa_bancoT.getTeb_dt_envio()));
        param.put("teb_transmissao_empresa_bancoT.teb_dt_retorno", dtfDate.format(teb_transmissao_empresa_bancoT.getTeb_dt_retorno()));
        param.put("teb_transmissao_empresa_bancoT.teb_tx_status", teb_transmissao_empresa_bancoT.getTeb_tx_status() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("teb_transmissao_empresa_banco").isObject();
                    Teb_transmissao_empresa_bancoDAOGWT.this.teb_transmissao_empresa_bancoT = lerRegistroJson(registro);
                }
            }
        };
        this.teb_transmissao_empresa_bancoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("teb_transmissao_empresa_bancoT.teb_dt_envio", dtfDate.format(teb_transmissao_empresa_bancoT.getTeb_dt_envio()));


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT) {
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
        param.put("teb_transmissao_empresa_bancoT.teb_dt_envio", dtfDate.format(teb_transmissao_empresa_bancoT.getTeb_dt_envio()));


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT) {
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
        param.put("teb_transmissao_empresa_bancoT.teb_nr_id", teb_transmissao_empresa_bancoT.getTeb_nr_id() + "");
        param.put("teb_transmissao_empresa_bancoT.teb_dt_envio", dtfDate.format(teb_transmissao_empresa_bancoT.getTeb_dt_envio()));
        param.put("teb_transmissao_empresa_bancoT.teb_dt_retorno", dtfDate.format(teb_transmissao_empresa_bancoT.getTeb_dt_retorno()));
        param.put("teb_transmissao_empresa_bancoT.teb_tx_status", teb_transmissao_empresa_bancoT.getTeb_tx_status() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Teb_transmissao_empresa_bancoTGWT> lista = new ListStore<Teb_transmissao_empresa_bancoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT = lerRegistroJson(registro);
                lista.add(teb_transmissao_empresa_bancoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Teb_transmissao_empresa_bancoTGWT lerRegistroJson(JSONObject registro) {
        Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoTGWT = new Teb_transmissao_empresa_bancoTGWT();
        Integer teb_nr_id = Integer.parseInt(registro.get("teb_nr_id").isString().stringValue());
        teb_transmissao_empresa_bancoTGWT.setTeb_nr_id(teb_nr_id);

        Date teb_dt_envio = dtfDate.parse(registro.get("teb_dt_envio").isString().stringValue());
        teb_transmissao_empresa_bancoTGWT.setTeb_dt_envio(teb_dt_envio);

        String tebDtRetorno = registro.get("teb_dt_retorno").isString().stringValue();
        if (tebDtRetorno != null && tebDtRetorno.trim().length() > 0) {
            Date teb_dt_retorno = dtfDate.parse(tebDtRetorno);
            teb_transmissao_empresa_bancoTGWT.setTeb_dt_retorno(teb_dt_retorno);
        }

        String teb_tx_status = registro.get("teb_tx_status").isString().stringValue();
        teb_transmissao_empresa_bancoTGWT.setTeb_tx_status(teb_tx_status);

        String teb_tx_operacao = registro.get("teb_tx_operacao").isString().stringValue();
        teb_transmissao_empresa_bancoTGWT.setTeb_tx_operacao(teb_tx_operacao);

        return teb_transmissao_empresa_bancoTGWT;
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
     * @return the teb_transmissao_empresa_bancoT
     */
    public Teb_transmissao_empresa_bancoTGWT getTeb_transmissao_empresa_bancoT() {
        return teb_transmissao_empresa_bancoT;
    }

    /**
     * @param teb_transmissao_empresa_bancoTGWT the teb_transmissao_empresa_bancoTGWT to set
     */
    public void setTeb_transmissao_empresa_bancoTGWT(Teb_transmissao_empresa_bancoTGWT teb_transmissao_empresa_bancoT) {
        this.teb_transmissao_empresa_bancoT = teb_transmissao_empresa_bancoT;
    }
}
