package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Cco_contacorrenteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Orcl_orgao_clienteTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Orcl_orgao_clienteDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Orcl_orgao_clienteTGWT orcl_orgao_clienteT;

    public void consultarTodos(Cli_clienteTGWT cli_clienteTGWT) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String,String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("orcl_orgao_clienteT.cli_nr_id", cli_clienteTGWT.getCli_nr_id()+"");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }

    public void inserir(Orcl_orgao_clienteTGWT orcl_orgao_clienteT, Cco_contacorrenteTGWT cco_contacorrenteT) {
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
        param.put("orcl_orgao_clienteT.cli_nr_id", orcl_orgao_clienteT.getCli_nr_id() + "");
        param.put("orcl_orgao_clienteT.org_nr_id", orcl_orgao_clienteT.getOrg_nr_id() + "");


        param.put("cco_contacorrenteT.cco_tx_nragencia", cco_contacorrenteT.getCco_tx_nragencia());
        param.put("cco_contacorrenteT.cco_tx_nrcontacorrente", cco_contacorrenteT.getCco_tx_nrcontacorrente());
        param.put("cco_contacorrenteT.cco_tx_nomecorrentista", cco_contacorrenteT.getCco_tx_nomecorrentista());
        param.put("cco_contacorrenteT.bco_nr_id", cco_contacorrenteT.getBco_nr_id() + "");
        param.put("cco_contacorrenteT.cli_nr_id", cco_contacorrenteT.getCli_nr_id() + "");
        param.put("cco_contacorrenteT.org_nr_id", cco_contacorrenteT.getOrg_nr_id() + "");
        param.put("cco_contacorrenteT.cor_nr_id",  "0");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Orcl_orgao_clienteTGWT orcl_orgao_clienteT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                Window.alert(jsonValue.toString());
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("orcl_orgao_cliente").isObject();
                    Orcl_orgao_clienteDAOGWT.this.orcl_orgao_clienteT = lerRegistroJson(registro);
                }
            }
        };
        this.orcl_orgao_clienteT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("orcl_orgao_clienteT.orcl_nr_id", orcl_orgao_clienteT.getOrcl_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Orcl_orgao_clienteTGWT orcl_orgao_clienteT) {
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
        param.put("orcl_orgao_clienteT.orcl_nr_id", orcl_orgao_clienteT.getOrcl_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Orcl_orgao_clienteTGWT orcl_orgao_clienteT) {
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
        param.put("orcl_orgao_clienteT.orcl_nr_id", orcl_orgao_clienteT.getOrcl_nr_id() + "");
        param.put("orcl_orgao_clienteT.cli_nr_id", orcl_orgao_clienteT.getCli_nr_id() + "");
        param.put("orcl_orgao_clienteT.org_nr_id", orcl_orgao_clienteT.getOrg_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Orcl_orgao_clienteTGWT> lista = new ListStore<Orcl_orgao_clienteTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Orcl_orgao_clienteTGWT orcl_orgao_clienteT = lerRegistroJson(registro);
                lista.add(orcl_orgao_clienteT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Orcl_orgao_clienteTGWT lerRegistroJson(JSONObject registro) {
        Orcl_orgao_clienteTGWT orcl_orgao_clienteTGWT = new Orcl_orgao_clienteTGWT();
        Integer orcl_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("orcl_nr_id").toString()));
        orcl_orgao_clienteTGWT.setOrcl_nr_id(orcl_nr_id);

        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        orcl_orgao_clienteTGWT.setCli_nr_id(cli_nr_id);

        Integer org_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("org_nr_id").toString()));
        orcl_orgao_clienteTGWT.setOrg_nr_id(org_nr_id);

        String orgao = EasyContainer.clearAspas(registro.get("orgao").toString());
        orcl_orgao_clienteTGWT.setOrgao(orgao);

        return orcl_orgao_clienteTGWT;
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
     * @return the orcl_orgao_clienteT
     */
    public Orcl_orgao_clienteTGWT getOrcl_orgao_clienteT() {
        return orcl_orgao_clienteT;
    }

    /**
     * @param orcl_orgao_clienteTGWT the orcl_orgao_clienteTGWT to set
     */
    public void setOrcl_orgao_clienteTGWT(Orcl_orgao_clienteTGWT orcl_orgao_clienteT) {
        this.orcl_orgao_clienteT = orcl_orgao_clienteT;
    }
}
