package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Tic_tipo_creditoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Tic_tipo_creditoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/tic_tipo_credito/tic_tipo_creditoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/tic_tipo_credito/tic_tipo_creditoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/tic_tipo_credito/tic_tipo_creditoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Tic_tipo_creditoTGWT tic_tipo_creditoT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Tic_tipo_creditoTGWT tic_tipo_creditoT) {
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
        param.put("tic_tipo_creditoT.tic_tx_nome", tic_tipo_creditoT.getTic_tx_nome() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Tic_tipo_creditoTGWT tic_tipo_creditoT) {
        IListenetResponse listener = new IListenetResponse() {
            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tic_tipo_credito").isObject();
                    Tic_tipo_creditoDAOGWT.this.tic_tipo_creditoT = lerRegistroJson(registro);
                }
            }
        };
        this.tic_tipo_creditoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("tic_tipo_creditoT.tic_nr_id", tic_tipo_creditoT.getTic_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Tic_tipo_creditoTGWT tic_tipo_creditoT) {
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
        param.put("tic_tipo_creditoT.tic_nr_id", tic_tipo_creditoT.getTic_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Tic_tipo_creditoTGWT tic_tipo_creditoT) {
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
        param.put("tic_tipo_creditoT.tic_nr_id", tic_tipo_creditoT.getTic_nr_id() + "");
        param.put("tic_tipo_creditoT.tic_tx_nome", tic_tipo_creditoT.getTic_tx_nome() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Tic_tipo_creditoTGWT> lista = new ListStore<Tic_tipo_creditoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Tic_tipo_creditoTGWT tic_tipo_creditoT = lerRegistroJson(registro);
                lista.add(tic_tipo_creditoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json
     */
    private Tic_tipo_creditoTGWT lerRegistroJson(JSONObject registro) {
        Tic_tipo_creditoTGWT tic_tipo_creditoTGWT = new Tic_tipo_creditoTGWT();
        Integer tic_nr_id = Integer.parseInt(registro.get("tic_nr_id").isString().stringValue());
        tic_tipo_creditoTGWT.setTic_nr_id(tic_nr_id);

        String tic_tx_nome = registro.get("tic_tx_nome").isString().stringValue();
        tic_tipo_creditoTGWT.setTic_tx_nome(tic_tx_nome);


        return tic_tipo_creditoTGWT;
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
     * @return the tic_tipo_creditoT
     */
    public Tic_tipo_creditoTGWT getTic_tipo_creditoT() {
        return tic_tipo_creditoT;
    }

    /**
     * @param tic_tipo_creditoTGWT the tic_tipo_creditoTGWT to set
     */
    public void setTic_tipo_creditoTGWT(Tic_tipo_creditoTGWT tic_tipo_creditoT) {
        this.tic_tipo_creditoT = tic_tipo_creditoT;
    }
}
