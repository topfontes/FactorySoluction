package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Tmp_tipomensalidadeTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Tmp_tipomensalidadeDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT;
    private TreeMap<Integer, Tmp_tipomensalidadeTGWT> tree = new TreeMap<Integer, Tmp_tipomensalidadeTGWT>();
    private List<Tmp_tipomensalidadeTGWT> listTmp;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String,String> param = new HashMap<String, String>();
        param.put("op", "consult");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }

    public void inserir(Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT) {
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
        param.put("tmp_tipomensalidadeT.tmp_tx_nome", tmp_tipomensalidadeT.getTmp_tx_nome());
        param.put("tmp_tipomensalidadeT.tmp_tx_descricao", tmp_tipomensalidadeT.getTmp_tx_descricao());
        param.put("tmp_tipomensalidadeT.tmp_nr_valor", tmp_tipomensalidadeT.getTmp_nr_valor() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tmp_tipomensalidade").isObject();
                    Tmp_tipomensalidadeDAOGWT.this.tmp_tipomensalidadeT = lerRegistroJson(registro);
                }
            }
        };
        this.tmp_tipomensalidadeT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("tmp_tipomensalidadeT.tmp_nr_id", tmp_tipomensalidadeT.getTmp_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT) {
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
        param.put("tmp_tipomensalidadeT.tmp_nr_id", tmp_tipomensalidadeT.getTmp_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT) {
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
        param.put("tmp_tipomensalidadeT.tmp_nr_id", tmp_tipomensalidadeT.getTmp_nr_id() + "");
        param.put("tmp_tipomensalidadeT.tmp_tx_nome", tmp_tipomensalidadeT.getTmp_tx_nome());
        param.put("tmp_tipomensalidadeT.tmp_tx_descricao", tmp_tipomensalidadeT.getTmp_tx_descricao());
        param.put("tmp_tipomensalidadeT.tmp_nr_valor", tmp_tipomensalidadeT.getTmp_nr_valor() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            listTmp = new ArrayList<Tmp_tipomensalidadeTGWT>();
            ListStore<Tmp_tipomensalidadeTGWT> lista = new ListStore<Tmp_tipomensalidadeTGWT>();
            setTree(new TreeMap<Integer, Tmp_tipomensalidadeTGWT>());
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT = lerRegistroJson(registro);
                lista.add(tmp_tipomensalidadeT);
                getTree().put(tmp_tipomensalidadeT.getTmp_nr_id(), tmp_tipomensalidadeT);
                listTmp.add(tmp_tipomensalidadeT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Tmp_tipomensalidadeTGWT lerRegistroJson(JSONObject registro) {
        Tmp_tipomensalidadeTGWT tmp_tipomensalidadeTGWT = new Tmp_tipomensalidadeTGWT();
        Integer tmp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tmp_nr_id").toString()));
        tmp_tipomensalidadeTGWT.setTmp_nr_id(tmp_nr_id);

        String tmp_tx_nome = EasyContainer.clearAspas(registro.get("tmp_tx_nome").toString());
        tmp_tipomensalidadeTGWT.setTmp_tx_nome(tmp_tx_nome);

        String tmp_tx_descricao = EasyContainer.clearAspas(registro.get("tmp_tx_descricao").toString());
        tmp_tipomensalidadeTGWT.setTmp_tx_descricao(tmp_tx_descricao);

        float tmp_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("tmp_nr_valor").toString()));
        tmp_tipomensalidadeTGWT.setTmp_nr_valor(tmp_nr_valor);


        return tmp_tipomensalidadeTGWT;
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
     * @return the tmp_tipomensalidadeT
     */
    public Tmp_tipomensalidadeTGWT getTmp_tipomensalidadeT() {
        return tmp_tipomensalidadeT;
    }

    /**
     * @param tmp_tipomensalidadeTGWT the tmp_tipomensalidadeTGWT to set
     */
    public void setTmp_tipomensalidadeTGWT(Tmp_tipomensalidadeTGWT tmp_tipomensalidadeT) {
        this.tmp_tipomensalidadeT = tmp_tipomensalidadeT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Tmp_tipomensalidadeTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Tmp_tipomensalidadeTGWT> tree) {
        this.tree = tree;
    }

    /**
     * @return the listTmp
     */
    public List<Tmp_tipomensalidadeTGWT> getListTmp() {
        return listTmp;
    }

    /**
     * @param listTmp the listTmp to set
     */
    public void setListTmp(List<Tmp_tipomensalidadeTGWT> listTmp) {
        this.listTmp = listTmp;
    }
}
