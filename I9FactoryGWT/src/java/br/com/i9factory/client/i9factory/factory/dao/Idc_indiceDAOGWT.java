package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Idc_indiceTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Idc_indiceDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/idc_indice/idc_indiceInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/idc_indice/idc_indiceConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/idc_indice/idc_indiceUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Idc_indiceTGWT idc_indiceT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Idc_indiceTGWT idc_indiceT) {
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
        param.put("idc_indiceT.idc_nr_diainicial", idc_indiceT.getIdc_nr_diainicial() + "");
        param.put("idc_indiceT.idc_nr_diafinal", idc_indiceT.getIdc_nr_diafinal() + "");
        param.put("idc_indiceT.idc_nr_qtdparcelas", idc_indiceT.getIdc_nr_qtdparcelas() + "");
        param.put("idc_indiceT.idc_nr_valor", idc_indiceT.getIdc_nr_valor() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Idc_indiceTGWT idc_indiceT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("idc_indice").isObject();
                    Idc_indiceDAOGWT.this.idc_indiceT = lerRegistroJson(registro);
                }
            }
        };
        this.idc_indiceT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("idc_indiceT.idc_nr_id", idc_indiceT.getIdc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Idc_indiceTGWT idc_indiceT) {
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
        param.put("idc_indiceT.idc_nr_id", idc_indiceT.getIdc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Idc_indiceTGWT idc_indiceT) {
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
        param.put("idc_indiceT.idc_nr_id", idc_indiceT.getIdc_nr_id() + "");
        param.put("idc_indiceT.idc_nr_diainicial", idc_indiceT.getIdc_nr_diainicial() + "");
        param.put("idc_indiceT.idc_nr_diafinal", idc_indiceT.getIdc_nr_diafinal() + "");
        param.put("idc_indiceT.idc_nr_qtdparcelas", idc_indiceT.getIdc_nr_qtdparcelas() + "");
        param.put("idc_indiceT.idc_nr_valor", idc_indiceT.getIdc_nr_valor() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Idc_indiceTGWT> lista = new ListStore<Idc_indiceTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Idc_indiceTGWT idc_indiceT = lerRegistroJson(registro);
                lista.add(idc_indiceT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Idc_indiceTGWT lerRegistroJson(JSONObject registro) {
        Idc_indiceTGWT idc_indiceTGWT = new Idc_indiceTGWT();
        Integer idc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("idc_nr_id").toString()));
        idc_indiceTGWT.setIdc_nr_id(idc_nr_id);

        Integer idc_nr_diainicial = Integer.parseInt(EasyContainer.clearAspas(registro.get("idc_nr_diainicial").toString()));
        idc_indiceTGWT.setIdc_nr_diainicial(idc_nr_diainicial);

        Integer idc_nr_diafinal = Integer.parseInt(EasyContainer.clearAspas(registro.get("idc_nr_diafinal").toString()));
        idc_indiceTGWT.setIdc_nr_diafinal(idc_nr_diafinal);

        Integer idc_nr_qtdparcelas = Integer.parseInt(EasyContainer.clearAspas(registro.get("idc_nr_qtdparcelas").toString()));
        idc_indiceTGWT.setIdc_nr_qtdparcelas(idc_nr_qtdparcelas);

        float idc_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("idc_nr_valor").toString()));
        idc_indiceTGWT.setIdc_nr_valor(idc_nr_valor);


        return idc_indiceTGWT;
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
     * @return the idc_indiceT
     */
    public Idc_indiceTGWT getIdc_indiceT() {
        return idc_indiceT;
    }

    /**
     * @param idc_indiceTGWT the idc_indiceTGWT to set
     */
    public void setIdc_indiceTGWT(Idc_indiceTGWT idc_indiceT) {
        this.idc_indiceT = idc_indiceT;
    }
}
