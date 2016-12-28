package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Cco_contacorrenteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Org_orgaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Cco_contacorrenteDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/cco_contacorrente/cco_contacorrenteInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/cco_contacorrente/cco_contacorrenteConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Cco_contacorrenteTGWT cco_contacorrenteT;

    public void consultarTodos(Cli_clienteTGWT cli_clienteTGWT, Org_orgaoTGWT org_orgaoTGWT) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("cco_contacorrenteT.cli_nr_id", cli_clienteTGWT.getCli_nr_id() + "");
        param.put("cco_contacorrenteT.org_nr_id", org_orgaoTGWT.getOrg_nr_id() + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }

    public void inserir(Cco_contacorrenteTGWT cco_contacorrenteT) {
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
        param.put("cco_contacorrenteT.cco_tx_nragencia", cco_contacorrenteT.getCco_tx_nragencia());
        param.put("cco_contacorrenteT.cco_tx_nrcontacorrente", cco_contacorrenteT.getCco_tx_nrcontacorrente());
        param.put("cco_contacorrenteT.cco_tx_nomecorrentista", cco_contacorrenteT.getCco_tx_nomecorrentista());
        param.put("cco_contacorrenteT.bco_nr_id", cco_contacorrenteT.getBco_nr_id() + "");
        param.put("cco_contacorrenteT.cli_nr_id", cco_contacorrenteT.getCli_nr_id() + "");
        param.put("cco_contacorrenteT.org_nr_id", cco_contacorrenteT.getOrg_nr_id() + "");
        param.put("cco_contacorrenteT.cor_nr_id", cco_contacorrenteT.getCor_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Cco_contacorrenteTGWT cco_contacorrenteT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("cco_contacorrente").isObject();
                    Cco_contacorrenteDAOGWT.this.cco_contacorrenteT = lerRegistroJson(registro);
                }
            }
        };
        this.cco_contacorrenteT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("cco_contacorrenteT.cco_nr_id", cco_contacorrenteT.getCco_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Cco_contacorrenteTGWT cco_contacorrenteT) {
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
        param.put("cco_contacorrenteT.cco_nr_id", cco_contacorrenteT.getCco_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Cco_contacorrenteTGWT cco_contacorrenteT) {
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
        param.put("cco_contacorrenteT.cco_nr_id", cco_contacorrenteT.getCco_nr_id() + "");
        param.put("cco_contacorrenteT.cco_tx_nragencia", cco_contacorrenteT.getCco_tx_nragencia());
        param.put("cco_contacorrenteT.cco_tx_nrcontacorrente", cco_contacorrenteT.getCco_tx_nrcontacorrente());
        param.put("cco_contacorrenteT.cco_tx_nomecorrentista", cco_contacorrenteT.getCco_tx_nomecorrentista());
        param.put("cco_contacorrenteT.bco_nr_id", cco_contacorrenteT.getBco_nr_id() + "");
        param.put("cco_contacorrenteT.cli_nr_id", cco_contacorrenteT.getCli_nr_id() + "");
        param.put("cco_contacorrenteT.org_nr_id", cco_contacorrenteT.getOrg_nr_id() + "");
        param.put("cco_contacorrenteT.cor_nr_id", cco_contacorrenteT.getCor_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Cco_contacorrenteTGWT> lista = new ListStore<Cco_contacorrenteTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Cco_contacorrenteTGWT cco_contacorrenteT = lerRegistroJson(registro);
                lista.add(cco_contacorrenteT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Cco_contacorrenteTGWT lerRegistroJson(JSONObject registro) {
        Cco_contacorrenteTGWT cco_contacorrenteTGWT = new Cco_contacorrenteTGWT();
        Integer cco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cco_nr_id").toString()));
        cco_contacorrenteTGWT.setCco_nr_id(cco_nr_id);

        String cco_tx_nragencia = EasyContainer.clearAspas(registro.get("cco_tx_nragencia").toString());
        cco_contacorrenteTGWT.setCco_tx_nragencia(cco_tx_nragencia);

        String cco_tx_nrcontacorrente = EasyContainer.clearAspas(registro.get("cco_tx_nrcontacorrente").toString());
        cco_contacorrenteTGWT.setCco_tx_nrcontacorrente(cco_tx_nrcontacorrente);

        String cco_tx_nomecorrentista = EasyContainer.clearAspas(registro.get("cco_tx_nomecorrentista").toString());
        cco_contacorrenteTGWT.setCco_tx_nomecorrentista(cco_tx_nomecorrentista);

        Integer bco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("bco_nr_id").toString()));
        cco_contacorrenteTGWT.setBco_nr_id(bco_nr_id);

        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        cco_contacorrenteTGWT.setCli_nr_id(cli_nr_id);

        Integer org_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("org_nr_id").toString()));
        cco_contacorrenteTGWT.setOrg_nr_id(org_nr_id);

//        Integer age_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("age_nr_id").toString()));
//        cco_contacorrenteTGWT.setAge_nr_id(age_nr_id);

        String ban_tx_nome = EasyContainer.clearAspas(registro.get("bco_tx_nome").toString());
        cco_contacorrenteTGWT.setBco_tx_nome(ban_tx_nome);


        return cco_contacorrenteTGWT;
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
     * @return the cco_contacorrenteT
     */
    public Cco_contacorrenteTGWT getCco_contacorrenteT() {
        return cco_contacorrenteT;
    }

    /**
     * @param cco_contacorrenteTGWT the cco_contacorrenteTGWT to set
     */
    public void setCco_contacorrenteTGWT(Cco_contacorrenteTGWT cco_contacorrenteT) {
        this.cco_contacorrenteT = cco_contacorrenteT;
    }
}
