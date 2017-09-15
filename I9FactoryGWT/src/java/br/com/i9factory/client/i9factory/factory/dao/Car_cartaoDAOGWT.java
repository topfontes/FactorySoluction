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
import br.com.i9factory.client.i9factory.factory.transfer.Car_cartaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author topfontes
 */
public class Car_cartaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/car_cartao/car_cartaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/car_cartao/car_cartaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/car_cartao/car_cartaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Car_cartaoTGWT car_cartaoT;
//i9factory/factory/car_cartao/car_cartaoUpdateDeleteGWT.jsp?op=update&car_cartaoT.car_nr_id=1&car_cartaoT.car_tx_nome=abc
    
    public void insert(Car_cartaoTGWT car_cartaoTGWT) {
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
        param.put("car_cartaoT.car_tx_nome", car_cartaoTGWT.getCar_tx_nome() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void update(Car_cartaoTGWT car_cartaoTGWT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;

                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    
                    
                    setMsg(result.get("msg").isString().stringValue());

//                    String result = jsonObject.get("resultado").toString();
//                    msg = result;
                }
            }
        };
        setMsg(null);
        setList(null);
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("car_cartaoT.car_nr_id", car_cartaoTGWT.getCar_nr_id() + "");
        param.put("car_cartaoT.car_tx_nome", car_cartaoTGWT.getCar_tx_nome() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void delete(Car_cartaoTGWT car_cartaoTGWT) {
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
        param.put("car_cartaoT.car_nr_id", car_cartaoTGWT.getCar_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void consult() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR+"?op=consult");
        
        setList(null);
        setMsg(null);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        //tree = new TreeMap<Integer, Bco_bancoTGWT>();
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Car_cartaoTGWT> lista = new ListStore<Car_cartaoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Car_cartaoTGWT car_cartaoTGWT = lerRegistroJson(registro);
                lista.add(car_cartaoTGWT);
                //tree.put(bco_bancoT.getBco_nr_id(), bco_bancoT);
            }
            setList(lista);
        }

    }

    private Car_cartaoTGWT lerRegistroJson(JSONObject registro) {
        Car_cartaoTGWT car_cartaoTGWT = new Car_cartaoTGWT();
        //Window.alert("1");
        Integer car_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("car_nr_id").toString()));
        car_cartaoTGWT.setCar_nr_id(car_nr_id);
        //Window.alert("2");
        String car_tx_nome = EasyContainer.clearAspas(registro.get("car_tx_nome").toString());
        car_cartaoTGWT.setCar_tx_nome(car_tx_nome);
        return car_cartaoTGWT;
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
}
