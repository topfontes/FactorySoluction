package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Arb_arquivobancoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Arb_arquivobancoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/arb_arquivobanco/arb_arquivobancoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/arb_arquivobanco/arb_arquivobancoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Arb_arquivobancoTGWT arb_arquivobancoT;

    public void consultarTodos() {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
    }

    public void consultarRemessa() {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarRemessa");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultarRetorno() {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarRetorno");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Arb_arquivobancoTGWT arb_arquivobancoT) {
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
        param.put("arb_arquivobancoT.arb_dt_data", dtfDateTime.format(arb_arquivobancoT.getArb_dt_data()));
        param.put("arb_arquivobancoT.arb_tx_tipo", arb_arquivobancoT.getArb_tx_tipo() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Arb_arquivobancoTGWT arb_arquivobancoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("arb_arquivobanco").isObject();
                    Arb_arquivobancoDAOGWT.this.arb_arquivobancoT = lerRegistroJson(registro);
                }
            }
        };
        this.arb_arquivobancoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Arb_arquivobancoTGWT arb_arquivobancoT) {
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

    public void alterar(Arb_arquivobancoTGWT arb_arquivobancoT) {
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
        param.put("arb_arquivobancoT.arb_nr_id", arb_arquivobancoT.getArb_nr_id() + "");
        param.put("arb_arquivobancoT.arb_dt_data", dtfDateTime.format(arb_arquivobancoT.getArb_dt_data()));
        param.put("arb_arquivobancoT.arb_tx_tipo", arb_arquivobancoT.getArb_tx_tipo() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Arb_arquivobancoTGWT> lista = new ListStore<Arb_arquivobancoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Arb_arquivobancoTGWT arb_arquivobancoT = lerRegistroJson(registro);
                lista.add(arb_arquivobancoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Arb_arquivobancoTGWT lerRegistroJson(JSONObject registro) {
        Arb_arquivobancoTGWT arb_arquivobancoTGWT = new Arb_arquivobancoTGWT();
        Integer arb_nr_id = Integer.parseInt(registro.get("arb_nr_id").isString().stringValue());
        arb_arquivobancoTGWT.setArb_nr_id(arb_nr_id);

        Date arb_dt_data = dtfDateTime.parse(registro.get("arb_dt_data").isString().stringValue());
        arb_arquivobancoTGWT.setArb_dt_data(arb_dt_data);

        String arb_tx_tipo = registro.get("arb_tx_tipo").isString().stringValue();
        arb_arquivobancoTGWT.setArb_tx_tipo(arb_tx_tipo);

        int arb_nr_seq = Integer.parseInt(registro.get("arb_nr_seq").isString().stringValue());
        arb_arquivobancoTGWT.setArb_nr_seq(arb_nr_seq);


        return arb_arquivobancoTGWT;
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
     * @return the arb_arquivobancoT
     */
    public Arb_arquivobancoTGWT getArb_arquivobancoT() {
        return arb_arquivobancoT;
    }

    /**
     * @param arb_arquivobancoTGWT the arb_arquivobancoTGWT to set
     */
    public void setArb_arquivobancoTGWT(Arb_arquivobancoTGWT arb_arquivobancoT) {
        this.arb_arquivobancoT = arb_arquivobancoT;
    }
}
