package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Lan_lancamentoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Lan_lancamentoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/lan_lancamento/lan_lancamentoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/lan_lancamento/lan_lancamentoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/lan_lancamento/lan_lancamentoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Lan_lancamentoTGWT lan_lancamentoT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultarTodosPagamentosCTP(int ctp_nr_id) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String,String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("lan_lancamentoT.ctp_nr_id", ctp_nr_id+"");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }

    public void inserir(Lan_lancamentoTGWT lan_lancamentoT) {
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
        param.put("lan_lancamentoT.ctr_nr_id", lan_lancamentoT.getCtr_nr_id() + "");
        param.put("lan_lancamentoT.ctp_nr_id", lan_lancamentoT.getCtp_nr_id() + "");
        param.put("lan_lancamentoT.lan_plc_nr_id_deb", lan_lancamentoT.getLan_plc_nr_id_deb() + "");
        param.put("lan_lancamentoT.lan_plc_nr_id_cred", lan_lancamentoT.getLan_plc_nr_id_cred() + "");
        param.put("lan_lancamentoT.lan_dt_lancamento", dtfDate.format(lan_lancamentoT.getLan_dt_lancamento()));
        param.put("lan_lancamentoT.lan_tx_historico", lan_lancamentoT.getLan_tx_historico());
        param.put("lan_lancamentoT.lan_valor", lan_lancamentoT.getLan_valor() + "");
        param.put("lan_lancamentoT.lan_nr_id_super", lan_lancamentoT.getLan_nr_id_super() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Lan_lancamentoTGWT lan_lancamentoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("lan_lancamento").isObject();
                    Lan_lancamentoDAOGWT.this.lan_lancamentoT = lerRegistroJson(registro);
                }
            }
        };
        this.lan_lancamentoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("lan_lancamentoT.lan_nr_id", lan_lancamentoT.getLan_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Lan_lancamentoTGWT lan_lancamentoT) {
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
        param.put("lan_lancamentoT.lan_nr_id", lan_lancamentoT.getLan_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Lan_lancamentoTGWT lan_lancamentoT) {
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
        param.put("lan_lancamentoT.lan_nr_id", lan_lancamentoT.getLan_nr_id() + "");
        param.put("lan_lancamentoT.ctr_nr_id", lan_lancamentoT.getCtr_nr_id() + "");
        param.put("lan_lancamentoT.ctp_nr_id", lan_lancamentoT.getCtp_nr_id() + "");
        param.put("lan_lancamentoT.lan_plc_nr_id_deb", lan_lancamentoT.getLan_plc_nr_id_deb() + "");
        param.put("lan_lancamentoT.lan_plc_nr_id_cred", lan_lancamentoT.getLan_plc_nr_id_cred() + "");
        param.put("lan_lancamentoT.lan_dt_lancamento", dtfDate.format(lan_lancamentoT.getLan_dt_lancamento()));
        param.put("lan_lancamentoT.lan_tx_historico", lan_lancamentoT.getLan_tx_historico());
        param.put("lan_lancamentoT.lan_valor", lan_lancamentoT.getLan_valor() + "");
        param.put("lan_lancamentoT.lan_nr_id_super", lan_lancamentoT.getLan_nr_id_super() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Lan_lancamentoTGWT> lista = new ListStore<Lan_lancamentoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Lan_lancamentoTGWT lan_lancamentoT = lerRegistroJson(registro);
                lista.add(lan_lancamentoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Lan_lancamentoTGWT lerRegistroJson(JSONObject registro) {
        Lan_lancamentoTGWT lan_lancamentoTGWT = new Lan_lancamentoTGWT();
        Integer lan_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("lan_nr_id").toString()));
        lan_lancamentoTGWT.setLan_nr_id(lan_nr_id);

        Integer ctr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctr_nr_id").toString()));
        lan_lancamentoTGWT.setCtr_nr_id(ctr_nr_id);

        Integer ctp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
        lan_lancamentoTGWT.setCtp_nr_id(ctp_nr_id);

        Integer lan_plc_nr_id_deb = Integer.parseInt(EasyContainer.clearAspas(registro.get("lan_plc_nr_id_deb").toString()));
        lan_lancamentoTGWT.setLan_plc_nr_id_deb(lan_plc_nr_id_deb);

        Integer lan_plc_nr_id_cred = Integer.parseInt(EasyContainer.clearAspas(registro.get("lan_plc_nr_id_cred").toString()));
        lan_lancamentoTGWT.setLan_plc_nr_id_cred(lan_plc_nr_id_cred);

        Date lan_dt_lancamento = dtfDate.parse(EasyContainer.clearAspas(registro.get("lan_dt_lancamento").toString()));
        lan_lancamentoTGWT.setLan_dt_lancamento(lan_dt_lancamento);

        String lan_tx_historico = EasyContainer.clearAspas(registro.get("lan_tx_historico").toString());
        lan_lancamentoTGWT.setLan_tx_historico(lan_tx_historico);

        float lan_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("lan_valor").toString()));
        lan_lancamentoTGWT.setLan_valor(lan_valor);

        float lan_nr_id_super = Float.parseFloat(EasyContainer.clearAspas(registro.get("lan_nr_id_super").toString()));
        lan_lancamentoTGWT.setLan_nr_id_super(lan_nr_id_super);


        return lan_lancamentoTGWT;
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
     * @return the lan_lancamentoT
     */
    public Lan_lancamentoTGWT getLan_lancamentoT() {
        return lan_lancamentoT;
    }

    /**
     * @param lan_lancamentoTGWT the lan_lancamentoTGWT to set
     */
    public void setLan_lancamentoTGWT(Lan_lancamentoTGWT lan_lancamentoT) {
        this.lan_lancamentoT = lan_lancamentoT;
    }
}
