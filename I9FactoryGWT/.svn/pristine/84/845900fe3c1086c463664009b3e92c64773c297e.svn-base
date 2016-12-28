package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Eqp_equipeTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Eqp_equipeDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/eqp_equipe/eqp_equipeInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/eqp_equipe/eqp_equipeConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/eqp_equipe/eqp_equipeUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Eqp_equipeTGWT eqp_equipeT;
    private TreeMap<Integer,Eqp_equipeTGWT> tree = new TreeMap<Integer, Eqp_equipeTGWT>();

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Eqp_equipeTGWT eqp_equipeT) {
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
        param.put("eqp_equipeT.eqp_tx_nome", eqp_equipeT.getEqp_tx_nome() + "");
        param.put("eqp_equipeT.eqp_tx_descricao", eqp_equipeT.getEqp_tx_descricao()+ "");
        param.put("eqp_equipeT.cor_nr_id", eqp_equipeT.getCor_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Eqp_equipeTGWT eqp_equipeT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("eqp_equipe").isObject();
                    Eqp_equipeDAOGWT.this.eqp_equipeT = lerRegistroJson(registro);
                }
            }
        };
        this.eqp_equipeT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("eqp_equipeT.eqp_nr_id", eqp_equipeT.getEqp_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Eqp_equipeTGWT eqp_equipeT) {
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
        param.put("eqp_equipeT.eqp_nr_id", eqp_equipeT.getEqp_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Eqp_equipeTGWT eqp_equipeT) {
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
        param.put("eqp_equipeT.eqp_nr_id", eqp_equipeT.getEqp_nr_id() + "");
        param.put("eqp_equipeT.eqp_tx_nome", eqp_equipeT.getEqp_tx_nome()+ "");
        param.put("eqp_equipeT.eqp_tx_descricao", eqp_equipeT.getEqp_tx_descricao()+ "");
        param.put("eqp_equipeT.cor_nr_id", eqp_equipeT.getCor_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        tree = new TreeMap<Integer, Eqp_equipeTGWT>();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Eqp_equipeTGWT> lista = new ListStore<Eqp_equipeTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Eqp_equipeTGWT eqp_equipeT = lerRegistroJson(registro);
                lista.add(eqp_equipeT);
                tree.put(eqp_equipeT.getEqp_nr_id(), eqp_equipeT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Eqp_equipeTGWT lerRegistroJson(JSONObject registro) {
        Eqp_equipeTGWT eqp_equipeTGWT = new Eqp_equipeTGWT();
        Integer eqp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eqp_nr_id").toString()));
        eqp_equipeTGWT.setEqp_nr_id(eqp_nr_id);

        String eqp_tx_nome = EasyContainer.clearAspas(registro.get("eqp_tx_nome").toString());
        eqp_equipeTGWT.setEqp_tx_nome(eqp_tx_nome);

        String eqp_tx_descricao = EasyContainer.clearAspas(registro.get("eqp_tx_descricao").toString());
        eqp_equipeTGWT.setEqp_tx_descricao(eqp_tx_descricao);

        String cor_tx_nome = EasyContainer.clearAspas(registro.get("cor_tx_nome").toString());
        eqp_equipeTGWT.setCor_tx_nome(cor_tx_nome);

        Integer cor_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_id").toString()));
        eqp_equipeTGWT.setCor_nr_id(cor_nr_id);


        return eqp_equipeTGWT;
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
     * @return the eqp_equipeT
     */
    public Eqp_equipeTGWT getEqp_equipeT() {
        return eqp_equipeT;
    }

    /**
     * @param eqp_equipeTGWT the eqp_equipeTGWT to set
     */
    public void setEqp_equipeTGWT(Eqp_equipeTGWT eqp_equipeT) {
        this.eqp_equipeT = eqp_equipeT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Eqp_equipeTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Eqp_equipeTGWT> tree) {
        this.tree = tree;
    }
}
