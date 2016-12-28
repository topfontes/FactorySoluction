package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Dep_dependenteTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Dep_dependenteDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/dep_dependente/dep_dependenteInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/dep_dependente/dep_dependenteConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/dep_dependente/dep_dependenteUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Dep_dependenteTGWT dep_dependenteT;

    public void consultarTodos(Cli_clienteTGWT cli_clienteTGWT) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("dep_dependenteT.cli_nr_id", cli_clienteTGWT.getCli_nr_id() + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void inserir(Dep_dependenteTGWT dep_dependenteT) {
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
        param.put("dep_dependenteT.cli_nr_id", dep_dependenteT.getCli_nr_id() + "");
        param.put("dep_dependenteT.dep_tx_nome", dep_dependenteT.getDep_tx_nome());
        param.put("dep_dependenteT.dep_dt_nascimento", dtfDate.format(dep_dependenteT.getDep_dt_nascimento()));
        param.put("dep_dependenteT.dep_tx_grauparentesco", dep_dependenteT.getDep_tx_grauparentesco());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Dep_dependenteTGWT dep_dependenteT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("dep_dependente").isObject();
                    Dep_dependenteDAOGWT.this.dep_dependenteT = lerRegistroJson(registro);
                }
            }
        };
        this.dep_dependenteT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("dep_dependenteT.dep_nr_id", dep_dependenteT.getDep_nr_id() + "");
        param.put("dep_dependenteT.cli_nr_id", dep_dependenteT.getCli_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Dep_dependenteTGWT dep_dependenteT) {
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
        param.put("dep_dependenteT.dep_nr_id", dep_dependenteT.getDep_nr_id() + "");
        param.put("dep_dependenteT.cli_nr_id", dep_dependenteT.getCli_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Dep_dependenteTGWT dep_dependenteT) {
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
        param.put("dep_dependenteT.dep_nr_id", dep_dependenteT.getDep_nr_id() + "");
        param.put("dep_dependenteT.cli_nr_id", dep_dependenteT.getCli_nr_id() + "");
        param.put("dep_dependenteT.dep_tx_nome", dep_dependenteT.getDep_tx_nome());
        param.put("dep_dependenteT.dep_dt_nascimento", dtfDate.format(dep_dependenteT.getDep_dt_nascimento()));
        param.put("dep_dependenteT.dep_tx_grauparentesco", dep_dependenteT.getDep_tx_grauparentesco());


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Dep_dependenteTGWT> lista = new ListStore<Dep_dependenteTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Dep_dependenteTGWT dep_dependenteT = lerRegistroJson(registro);
                lista.add(dep_dependenteT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Dep_dependenteTGWT lerRegistroJson(JSONObject registro) {
        Dep_dependenteTGWT dep_dependenteTGWT = new Dep_dependenteTGWT();
        Integer dep_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("dep_nr_id").toString()));
        dep_dependenteTGWT.setDep_nr_id(dep_nr_id);

        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        dep_dependenteTGWT.setCli_nr_id(cli_nr_id);

        String dep_tx_nome = EasyContainer.clearAspas(registro.get("dep_tx_nome").toString());
        dep_dependenteTGWT.setDep_tx_nome(dep_tx_nome);

        Date dep_dt_nascimento = dtfDate.parse(EasyContainer.clearAspas(registro.get("dep_dt_nascimento").toString()));
        dep_dependenteTGWT.setDep_dt_nascimento(dep_dt_nascimento);

        String dep_tx_grauparentesco = EasyContainer.clearAspas(registro.get("dep_tx_grauparentesco").toString());
        dep_dependenteTGWT.setDep_tx_grauparentesco(dep_tx_grauparentesco);


        return dep_dependenteTGWT;
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
     * @return the dep_dependenteT
     */
    public Dep_dependenteTGWT getDep_dependenteT() {
        return dep_dependenteT;
    }

    /**
     * @param dep_dependenteTGWT the dep_dependenteTGWT to set
     */
    public void setDep_dependenteTGWT(Dep_dependenteTGWT dep_dependenteT) {
        this.dep_dependenteT = dep_dependenteT;
    }
}
