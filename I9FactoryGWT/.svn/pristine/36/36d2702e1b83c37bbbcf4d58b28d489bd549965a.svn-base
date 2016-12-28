package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Par_parametroTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Par_parametroDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/par_parametro/par_parametroInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/par_parametro/par_parametroConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/par_parametro/par_parametroUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Par_parametroTGWT par_parametroT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Par_parametroTGWT par_parametroT) {
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
        param.put("par_parametroT.par_tx_nome", par_parametroT.getPar_tx_nome());
        param.put("par_parametroT.par_tx_valor", par_parametroT.getPar_tx_valor());
        param.put("par_parametroT.par_tx_descricao", par_parametroT.getPar_tx_descricao());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Par_parametroTGWT par_parametroT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("par_parametro").isObject();
                    Par_parametroDAOGWT.this.par_parametroT = lerRegistroJson(registro);
                }
            }
        };
        this.par_parametroT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("par_parametroT.par_nr_id", par_parametroT.getPar_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Par_parametroTGWT par_parametroT) {
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
        param.put("par_parametroT.par_nr_id", par_parametroT.getPar_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Par_parametroTGWT par_parametroT) {
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
        param.put("par_parametroT.par_nr_id", par_parametroT.getPar_nr_id() + "");
        param.put("par_parametroT.par_tx_nome", par_parametroT.getPar_tx_nome());
        param.put("par_parametroT.par_tx_valor", par_parametroT.getPar_tx_valor());
        param.put("par_parametroT.par_tx_descricao", par_parametroT.getPar_tx_descricao());


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Par_parametroTGWT> lista = new ListStore<Par_parametroTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Par_parametroTGWT par_parametroT = lerRegistroJson(registro);
                lista.add(par_parametroT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Par_parametroTGWT lerRegistroJson(JSONObject registro) {
        Par_parametroTGWT par_parametroTGWT = new Par_parametroTGWT();
        Integer par_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("par_nr_id").toString()));
        par_parametroTGWT.setPar_nr_id(par_nr_id);

        String par_tx_nome = EasyContainer.clearAspas(registro.get("par_tx_nome").toString());
        par_parametroTGWT.setPar_tx_nome(par_tx_nome);

        String par_tx_valor = EasyContainer.clearAspas(registro.get("par_tx_valor").toString());
        par_parametroTGWT.setPar_tx_valor(par_tx_valor);

        String par_tx_descricao = EasyContainer.clearAspas(registro.get("par_tx_descricao").toString());
        par_parametroTGWT.setPar_tx_descricao(par_tx_descricao);


        return par_parametroTGWT;
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
     * @return the par_parametroT
     */
    public Par_parametroTGWT getPar_parametroT() {
        return par_parametroT;
    }

    /**
     * @param par_parametroTGWT the par_parametroTGWT to set
     */
    public void setPar_parametroTGWT(Par_parametroTGWT par_parametroT) {
        this.par_parametroT = par_parametroT;
    }
}
