package br.com.i9factory.client.i9factory.factory.dao;
import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Tid_tipo_despesaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Tid_tipo_despesaDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9factory/factory/tid_tipo_despesa/tid_tipo_despesaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/tid_tipo_despesa/tid_tipo_despesaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/tid_tipo_despesa/tid_tipo_despesaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Tid_tipo_despesaTGWT tid_tipo_despesaT;
    private TreeMap<Integer,Tid_tipo_despesaTGWT> tree = new TreeMap<Integer, Tid_tipo_despesaTGWT>();
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Tid_tipo_despesaTGWT tid_tipo_despesaT) {
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
	param.put("tid_tipo_despesaT.tid_tx_nome" , tid_tipo_despesaT.getTid_tx_nome());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Tid_tipo_despesaTGWT tid_tipo_despesaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tid_tipo_despesa").isObject();
                    Tid_tipo_despesaDAOGWT.this.tid_tipo_despesaT = lerRegistroJson(registro);
                }
            }
        };
	this.tid_tipo_despesaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("tid_tipo_despesaT.tid_nr_id" , tid_tipo_despesaT.getTid_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Tid_tipo_despesaTGWT tid_tipo_despesaT) {
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
        param.put("tid_tipo_despesaT.tid_nr_id" , tid_tipo_despesaT.getTid_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Tid_tipo_despesaTGWT tid_tipo_despesaT) {
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
	param.put("tid_tipo_despesaT.tid_nr_id" , tid_tipo_despesaT.getTid_nr_id() + "");
param.put("tid_tipo_despesaT.tid_tx_nome" , tid_tipo_despesaT.getTid_tx_nome());

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Tid_tipo_despesaTGWT> lista = new ListStore<Tid_tipo_despesaTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Tid_tipo_despesaTGWT tid_tipo_despesaT = lerRegistroJson(registro);
                lista.add(tid_tipo_despesaT);
                tree.put(tid_tipo_despesaT.getTid_nr_id(), tid_tipo_despesaT);
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */	
    private Tid_tipo_despesaTGWT lerRegistroJson(JSONObject registro) {
	Tid_tipo_despesaTGWT tid_tipo_despesaTGWT = new Tid_tipo_despesaTGWT();
	                Integer tid_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("tid_nr_id").toString()));
                tid_tipo_despesaTGWT.setTid_nr_id(tid_nr_id);

                String tid_tx_nome=EasyContainer.clearAspas(registro.get("tid_tx_nome").toString());
                tid_tipo_despesaTGWT.setTid_tx_nome(tid_tx_nome);


	return tid_tipo_despesaTGWT;
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
     * @return the tid_tipo_despesaT
     */
    public Tid_tipo_despesaTGWT getTid_tipo_despesaT() {
        return tid_tipo_despesaT;
    }

    /**
     * @param tid_tipo_despesaTGWT the tid_tipo_despesaTGWT to set
     */
    public void setTid_tipo_despesaTGWT(Tid_tipo_despesaTGWT tid_tipo_despesaT) {
        this.tid_tipo_despesaT = tid_tipo_despesaT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Tid_tipo_despesaTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Tid_tipo_despesaTGWT> tree) {
        this.tree = tree;
    }
}
