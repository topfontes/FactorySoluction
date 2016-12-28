package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Ref_referenciaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Ref_referenciaDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/ref_referencia/ref_referenciaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/ref_referencia/ref_referenciaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/ref_referencia/ref_referenciaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Ref_referenciaTGWT ref_referenciaT;

    public void consultarTodos(Cli_clienteTGWT cli_clienteTGWT) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("ref_referenciaT.cli_nr_id", cli_clienteTGWT.getCli_nr_id() + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void inserir(Ref_referenciaTGWT ref_referenciaT) {
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
        param.put("ref_referenciaT.cli_nr_id", ref_referenciaT.getCli_nr_id() + "");
        param.put("ref_referenciaT.ref_tx_nome", ref_referenciaT.getRef_tx_nome());
        param.put("ref_referenciaT.ref_tx_telefone", ref_referenciaT.getRef_tx_telefone());
        if (ref_referenciaT.getRef_tx_celular() != null) {
            param.put("ref_referenciaT.ref_tx_celular", ref_referenciaT.getRef_tx_celular());
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Ref_referenciaTGWT ref_referenciaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("ref_referencia").isObject();
                    Ref_referenciaDAOGWT.this.ref_referenciaT = lerRegistroJson(registro);
                }
            }
        };
        this.ref_referenciaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("ref_referenciaT.ref_nr_id", ref_referenciaT.getRef_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Ref_referenciaTGWT ref_referenciaT) {
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
        param.put("ref_referenciaT.ref_nr_id", ref_referenciaT.getRef_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Ref_referenciaTGWT ref_referenciaT) {
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
        param.put("ref_referenciaT.ref_nr_id", ref_referenciaT.getRef_nr_id() + "");
        param.put("ref_referenciaT.cli_nr_id", ref_referenciaT.getCli_nr_id() + "");
        param.put("ref_referenciaT.ref_tx_nome", ref_referenciaT.getRef_tx_nome());
        param.put("ref_referenciaT.ref_tx_telefone", ref_referenciaT.getRef_tx_telefone());
        if (ref_referenciaT.getRef_tx_celular() != null) {
            param.put("ref_referenciaT.ref_tx_celular", ref_referenciaT.getRef_tx_celular());
        }


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Ref_referenciaTGWT> lista = new ListStore<Ref_referenciaTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Ref_referenciaTGWT ref_referenciaT = lerRegistroJson(registro);
                lista.add(ref_referenciaT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Ref_referenciaTGWT lerRegistroJson(JSONObject registro) {
        Ref_referenciaTGWT ref_referenciaTGWT = new Ref_referenciaTGWT();
        Integer ref_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ref_nr_id").toString()));
        ref_referenciaTGWT.setRef_nr_id(ref_nr_id);

        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        ref_referenciaTGWT.setCli_nr_id(cli_nr_id);

        String ref_tx_nome = EasyContainer.clearAspas(registro.get("ref_tx_nome").toString());
        ref_referenciaTGWT.setRef_tx_nome(ref_tx_nome);

        String ref_tx_telefone = EasyContainer.clearAspas(registro.get("ref_tx_telefone").toString());
        ref_referenciaTGWT.setRef_tx_telefone(ref_tx_telefone);

        String ref_tx_celular = EasyContainer.clearAspas(registro.get("ref_tx_celular").toString());
        ref_referenciaTGWT.setRef_tx_celular(ref_tx_celular);


        return ref_referenciaTGWT;
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
     * @return the ref_referenciaT
     */
    public Ref_referenciaTGWT getRef_referenciaT() {
        return ref_referenciaT;
    }

    /**
     * @param ref_referenciaTGWT the ref_referenciaTGWT to set
     */
    public void setRef_referenciaTGWT(Ref_referenciaTGWT ref_referenciaT) {
        this.ref_referenciaT = ref_referenciaT;
    }
}
