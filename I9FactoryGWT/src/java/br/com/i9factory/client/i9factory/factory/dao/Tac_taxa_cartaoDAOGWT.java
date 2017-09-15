/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9factory.client.i9factory.factory.dao;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.Constantes;
import static br.com.i9factory.client.i9factory.factory.dao.Car_cartaoDAOGWT.PAGE_ALTERAR_EXCLUIR;
import static br.com.i9factory.client.i9factory.factory.dao.Car_cartaoDAOGWT.PAGE_CONSULTAR;
import static br.com.i9factory.client.i9factory.factory.dao.Car_cartaoDAOGWT.PAGE_INSERIR;
import br.com.i9factory.client.i9factory.factory.transfer.Car_cartaoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Tac_taxa_cartaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;

/**
 *
 * @author topfontes
 */
public class Tac_taxa_cartaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/tac_taxa_cartao/tac_taxa_cartaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/tac_taxa_cartao/tac_taxa_cartaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/tac_taxa_cartao/tac_taxa_cartaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Tac_taxa_cartaoTGWT tac_taxa_cartaoT;

    public void insert(Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT, String array) {
        setMsg(null);
        setList(null);
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").isString().stringValue();
                    setMsg(result);
                }
            }
        };

        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
        param.put("tac_taxa_cartaoT.tac_tx_nome", tac_taxa_cartaoTGWT.getTac_tx_nome() + "");
        param.put("tac_taxa_cartaoT.car_nr_id", tac_taxa_cartaoTGWT.getCar_nr_id() + "");
        param.put("array", array);
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void update(Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    setMsg(result.get("msg").isString().stringValue());
                }
            }
        };
        setMsg(null);
        setList(null);
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("tac_taxa_cartaoT.tac_nr_id", tac_taxa_cartaoTGWT.getTac_nr_id() + "");
        param.put("tac_taxa_cartaoT.tac_tx_nome", tac_taxa_cartaoTGWT.getTac_tx_nome() + "");
        param.put("tac_taxa_cartaoT.tac_nr_taxa", tac_taxa_cartaoTGWT.getTac_nr_taxa() + "");
        param.put("tac_taxa_cartaoT.car_nr_id", tac_taxa_cartaoTGWT.getCar_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void delete(Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
//                    String result = jsonObject.get("resultado").toString();
                    JSONObject result = jsonObject.get("resultado").isObject();
                    setMsg(result.get("msg").isString().stringValue());
                }
            }
        };

        setList(null);
        setMsg(null);
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");
        param.put("tac_taxa_cartaoT.tac_nr_id", tac_taxa_cartaoTGWT.getTac_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void consult(Car_cartaoTGWT car_cartaoTGWT) {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("car_cartaoT.car_nr_id", car_cartaoTGWT.getCar_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        setList(null);
        setMsg(null);
    }

    public void findId(int tac_nr_id) {

        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                setMsg("passou");
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    
                        JSONArray resultado = jsonObject.get("resultado").isArray();
                        ListStore<Tac_taxa_cartaoTGWT> lista = new ListStore<Tac_taxa_cartaoTGWT>();
                        for (int i = 1; i < resultado.size(); i++) {
                            JSONObject registro = resultado.get(i).isObject();
                            setTac_taxa_cartaoT(lerRegistroJson(registro));
                            //tree.put(bco_bancoT.getBco_nr_id(), bco_bancoT);
                        }
                        
                    

                }
            }
        };
        
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findById");
        param.put("tac_taxa_cartaoT.tac_nr_id", tac_nr_id + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        setList(null);
        setMsg(null);
        tac_taxa_cartaoT= null;
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        //tree = new TreeMap<Integer, Bco_bancoTGWT>();

        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Tac_taxa_cartaoTGWT> lista = new ListStore<Tac_taxa_cartaoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT = lerRegistroJson(registro);
                lista.add(tac_taxa_cartaoTGWT);
                //tree.put(bco_bancoT.getBco_nr_id(), bco_bancoT);
            }
            setList(lista);
        }

    }

    private Tac_taxa_cartaoTGWT lerRegistroJson(JSONObject registro) {
        Tac_taxa_cartaoTGWT tac_taxa_cartaoTGWT = new Tac_taxa_cartaoTGWT();
        Integer car_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("car_nr_id").toString()));
        tac_taxa_cartaoTGWT.setCar_nr_id(car_nr_id);

        Integer tac_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tac_nr_id").toString()));
        tac_taxa_cartaoTGWT.setTac_nr_id(tac_nr_id);
        //Window.alert(tac_nr_id+"");

        String tac_tx_nome = EasyContainer.clearAspas(registro.get("tac_tx_nome").toString());
        tac_taxa_cartaoTGWT.setTac_tx_nome(tac_tx_nome);

        Float tac_nr_taxa = Float.parseFloat(EasyContainer.clearAspas(registro.get("tac_nr_taxa").toString()));
        tac_taxa_cartaoTGWT.setTac_nr_taxa(tac_nr_taxa);

        return tac_taxa_cartaoTGWT;
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
     * @return the tac_taxa_cartaoT
     */
    public Tac_taxa_cartaoTGWT getTac_taxa_cartaoT() {
        return tac_taxa_cartaoT;
    }

    /**
     * @param tac_taxa_cartaoT the tac_taxa_cartaoT to set
     */
    public void setTac_taxa_cartaoT(Tac_taxa_cartaoTGWT tac_taxa_cartaoT) {
        this.tac_taxa_cartaoT = tac_taxa_cartaoT;
    }

}
