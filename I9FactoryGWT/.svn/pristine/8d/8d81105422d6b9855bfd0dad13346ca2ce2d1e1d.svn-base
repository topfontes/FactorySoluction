package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Ped_percentual_descontoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Ped_percentual_descontoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/ped_percentual_desconto/ped_percentual_descontoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/ped_percentual_desconto/ped_percentual_descontoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/ped_percentual_desconto/ped_percentual_descontoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Ped_percentual_descontoTGWT ped_percentual_descontoT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultarDesconto(int qt_parcela) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult_desconto");
        param.put("ped_percentual_descontoT.ped_nr_parcela", qt_parcela+"");
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }

    public void inserir(Ped_percentual_descontoTGWT ped_percentual_descontoT) {
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
        param.put("ped_percentual_descontoT.ped_nr_parcela", ped_percentual_descontoT.getPed_nr_parcela() + "");
        param.put("ped_percentual_descontoT.ped_nr_desconto", ped_percentual_descontoT.getPed_nr_desconto() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Ped_percentual_descontoTGWT ped_percentual_descontoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("ped_percentual_desconto").isObject();
                    Ped_percentual_descontoDAOGWT.this.ped_percentual_descontoT = lerRegistroJson(registro);
                }
            }
        };
        this.ped_percentual_descontoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("ped_percentual_descontoT.ped_nr_id", ped_percentual_descontoT.getPed_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Ped_percentual_descontoTGWT ped_percentual_descontoT) {
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
        param.put("ped_percentual_descontoT.ped_nr_id", ped_percentual_descontoT.getPed_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Ped_percentual_descontoTGWT ped_percentual_descontoT) {
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
        param.put("ped_percentual_descontoT.ped_nr_id", ped_percentual_descontoT.getPed_nr_id() + "");
        param.put("ped_percentual_descontoT.ped_nr_parcela", ped_percentual_descontoT.getPed_nr_parcela() + "");
        param.put("ped_percentual_descontoT.ped_nr_desconto", ped_percentual_descontoT.getPed_nr_desconto() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Ped_percentual_descontoTGWT> lista = new ListStore<Ped_percentual_descontoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Ped_percentual_descontoTGWT ped_percentual_descontoT = lerRegistroJson(registro);
                lista.add(ped_percentual_descontoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Ped_percentual_descontoTGWT lerRegistroJson(JSONObject registro) {
        Ped_percentual_descontoTGWT ped_percentual_descontoTGWT = new Ped_percentual_descontoTGWT();
        Integer ped_nr_id = Integer.parseInt(registro.get("ped_nr_id").isString().stringValue());
        ped_percentual_descontoTGWT.setPed_nr_id(ped_nr_id);

        Integer ped_nr_parcela = Integer.parseInt(registro.get("ped_nr_parcela").isString().stringValue());
        ped_percentual_descontoTGWT.setPed_nr_parcela(ped_nr_parcela);

        float ped_nr_desconto = Float.parseFloat(registro.get("ped_nr_desconto").isString().stringValue());
        ped_percentual_descontoTGWT.setPed_nr_desconto(ped_nr_desconto);


        return ped_percentual_descontoTGWT;
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
     * @return the ped_percentual_descontoT
     */
    public Ped_percentual_descontoTGWT getPed_percentual_descontoT() {
        return ped_percentual_descontoT;
    }

    /**
     * @param ped_percentual_descontoTGWT the ped_percentual_descontoTGWT to set
     */
    public void setPed_percentual_descontoTGWT(Ped_percentual_descontoTGWT ped_percentual_descontoT) {
        this.ped_percentual_descontoT = ped_percentual_descontoT;
    }
}
