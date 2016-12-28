package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Res_restricaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Res_restricaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/res_restricao/res_restricaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/res_restricao/res_restricaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/res_restricao/res_restricaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Res_restricaoTGWT res_restricaoT;

    public void consultarTodos(Cli_clienteTGWT cli_clienteTGWT) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("res_restricaoT.cli_nr_id", cli_clienteTGWT.getCli_nr_id() + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("todos", "true");
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void inserir(Res_restricaoTGWT res_restricaoT) {
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
        param.put("res_restricaoT.res_tx_nome", res_restricaoT.getRes_tx_nome());
        param.put("res_restricaoT.cli_nr_id", res_restricaoT.getCli_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Res_restricaoTGWT res_restricaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("res_restricao").isObject();
                    Res_restricaoDAOGWT.this.res_restricaoT = lerRegistroJson(registro);
                }
            }
        };
        this.res_restricaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("res_restricaoT.res_nr_id", res_restricaoT.getRes_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Res_restricaoTGWT res_restricaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
//                    String result = jsonObject.get("resultado").toString();
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();

//                    msg = result;
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");
        param.put("res_restricaoT.res_nr_id", res_restricaoT.getRes_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Res_restricaoTGWT res_restricaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
//                    String result = jsonObject.get("resultado").toString();
//                    msg = result;
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("res_restricaoT.res_nr_id", res_restricaoT.getRes_nr_id() + "");
        param.put("res_restricaoT.res_tx_nome", res_restricaoT.getRes_tx_nome());
        param.put("res_restricaoT.cli_nr_id", res_restricaoT.getCli_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Res_restricaoTGWT> lista = new ListStore<Res_restricaoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Res_restricaoTGWT res_restricaoT = lerRegistroJson(registro);
                lista.add(res_restricaoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Res_restricaoTGWT lerRegistroJson(JSONObject registro) {
        Res_restricaoTGWT res_restricaoTGWT = new Res_restricaoTGWT();
        Integer res_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("res_nr_id").toString()));
        res_restricaoTGWT.setRes_nr_id(res_nr_id);

        String res_tx_nome = EasyContainer.clearAspas(registro.get("res_tx_nome").toString());
        res_restricaoTGWT.setRes_tx_nome(res_tx_nome);

        String cli_tx_nome = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
        res_restricaoTGWT.setCli_tx_nome(cli_tx_nome);

        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        res_restricaoTGWT.setCli_nr_id(cli_nr_id);


        return res_restricaoTGWT;
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
     * @return the res_restricaoT
     */
    public Res_restricaoTGWT getRes_restricaoT() {
        return res_restricaoT;
    }

    /**
     * @param res_restricaoTGWT the res_restricaoTGWT to set
     */
    public void setRes_restricaoTGWT(Res_restricaoTGWT res_restricaoT) {
        this.res_restricaoT = res_restricaoT;
    }
}
