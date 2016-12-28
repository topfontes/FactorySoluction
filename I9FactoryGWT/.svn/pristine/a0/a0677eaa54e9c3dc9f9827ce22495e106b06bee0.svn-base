package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Bco_bancoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Bco_bancoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/bco_banco/bco_bancoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/bco_banco/bco_bancoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/bco_banco/bco_bancoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Bco_bancoTGWT bco_bancoT;
    private TreeMap<Integer,Bco_bancoTGWT> tree = new TreeMap<Integer, Bco_bancoTGWT>();

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Bco_bancoTGWT bco_bancoT) {
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
        param.put("bco_bancoT.bco_tx_nome", bco_bancoT.getBco_tx_nome() + "");
        param.put("bco_bancoT.bco_tx_telefone1", bco_bancoT.getBco_tx_telefone1() + "");
        param.put("bco_bancoT.bco_tx_telefone2", bco_bancoT.getBco_tx_telefone2() + "");
        param.put("bco_bancoT.bco_tx_nomecontato", bco_bancoT.getBco_tx_nomecontato() + "");
        param.put("bco_bancoT.bco_tx_codigo", bco_bancoT.getBco_tx_codigo() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Bco_bancoTGWT bco_bancoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("bco_banco").isObject();
                    Bco_bancoDAOGWT.this.bco_bancoT = lerRegistroJson(registro);
                }
            }
        };
        this.bco_bancoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("bco_bancoT.bco_nr_id", bco_bancoT.getBco_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Bco_bancoTGWT bco_bancoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
//                    String result = jsonObject.get("resultado").toString();
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
        param.put("bco_bancoT.bco_nr_id", bco_bancoT.getBco_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Bco_bancoTGWT bco_bancoT) {
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
        param.put("bco_bancoT.bco_nr_id", bco_bancoT.getBco_nr_id() + "");
        param.put("bco_bancoT.bco_tx_nome", bco_bancoT.getBco_tx_nome() + "");
        param.put("bco_bancoT.bco_tx_telefone1", bco_bancoT.getBco_tx_telefone1() + "");
        param.put("bco_bancoT.bco_tx_telefone2", bco_bancoT.getBco_tx_telefone2() + "");
        param.put("bco_bancoT.bco_tx_nomecontato", bco_bancoT.getBco_tx_nomecontato() + "");
        param.put("bco_bancoT.bco_tx_codigo", bco_bancoT.getBco_tx_codigo() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        tree = new TreeMap<Integer, Bco_bancoTGWT>();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Bco_bancoTGWT> lista = new ListStore<Bco_bancoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Bco_bancoTGWT bco_bancoT = lerRegistroJson(registro);
                lista.add(bco_bancoT);
                tree.put(bco_bancoT.getBco_nr_id(), bco_bancoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Bco_bancoTGWT lerRegistroJson(JSONObject registro) {
        Bco_bancoTGWT bco_bancoTGWT = new Bco_bancoTGWT();
        Integer bco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("bco_nr_id").toString()));
        bco_bancoTGWT.setBco_nr_id(bco_nr_id);

        String bco_tx_nome = EasyContainer.clearAspas(registro.get("bco_tx_nome").toString());
        bco_bancoTGWT.setBco_tx_nome(bco_tx_nome);

        String bco_tx_codigo = EasyContainer.clearAspas(registro.get("bco_tx_codigo").toString());
        bco_bancoTGWT.setBco_tx_codigo(bco_tx_codigo);

        String bco_tx_telefone1 = EasyContainer.clearAspas(registro.get("bco_tx_telefone1").toString());
        bco_bancoTGWT.setBco_tx_telefone1(bco_tx_telefone1);

        String bco_tx_telefone2 = EasyContainer.clearAspas(registro.get("bco_tx_telefone2").toString());
        bco_bancoTGWT.setBco_tx_telefone2(bco_tx_telefone2);

        String bco_tx_nomecontato = EasyContainer.clearAspas(registro.get("bco_tx_nomecontato").toString());
        bco_bancoTGWT.setBco_tx_nomecontato(bco_tx_nomecontato);


        return bco_bancoTGWT;
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
     * @return the bco_bancoT
     */
    public Bco_bancoTGWT getBco_bancoT() {
        return bco_bancoT;
    }

    /**
     * @param bco_bancoTGWT the bco_bancoTGWT to set
     */
    public void setBco_bancoTGWT(Bco_bancoTGWT bco_bancoT) {
        this.bco_bancoT = bco_bancoT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Bco_bancoTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Bco_bancoTGWT> tree) {
        this.tree = tree;
    }
}
