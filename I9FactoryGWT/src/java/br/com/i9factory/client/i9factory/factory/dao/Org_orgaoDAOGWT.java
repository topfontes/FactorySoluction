package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Org_orgaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Org_orgaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/org_orgao/org_orgaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/org_orgao/org_orgaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/org_orgao/org_orgaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Org_orgaoTGWT org_orgaoT;
    private TreeMap<Integer, Org_orgaoTGWT> tree = new TreeMap<Integer, Org_orgaoTGWT>();

    public void consultarTodos() {
          list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
      
    }

    public void consultByNome(String nome) {
  list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByNome");
        param.put("org_orgaoT.org_tx_nomefantasia", nome);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
   
    }

    public void consultarTodosFiltro(String campoFiltro, String conteudo) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("campoFiltro", campoFiltro);
        if (campoFiltro.equalsIgnoreCase("CNPJ")) {
            param.put("org_orgaoT.org_tx_cnpj", conteudo);
        } else {
            param.put("org_orgaoT.org_tx_nomefantasia", conteudo);
        }
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void inserir(Org_orgaoTGWT org_orgaoT) {
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
        param.put("org_orgaoT.org_tx_cnpj", org_orgaoT.getOrg_tx_cnpj() + "");
        param.put("org_orgaoT.org_tx_razaosocial", org_orgaoT.getOrg_tx_razaosocial() + "");
        param.put("org_orgaoT.org_tx_nomefantasia", org_orgaoT.getOrg_tx_nomefantasia() + "");
        param.put("org_orgaoT.org_tx_inscestadual", org_orgaoT.getOrg_tx_inscestadual() + "");
        param.put("org_orgaoT.org_tx_tipologradouro", org_orgaoT.getOrg_tx_tipologradouro() + "");
        param.put("org_orgaoT.org_tx_logradouro", org_orgaoT.getOrg_tx_logradouro() + "");
        param.put("org_orgaoT.org_tx_numero", org_orgaoT.getOrg_tx_numero() + "");
        param.put("org_orgaoT.org_tx_cep", org_orgaoT.getOrg_tx_cep() + "");
        if (org_orgaoT.getOrg_tx_complemento() != null) {
            param.put("org_orgaoT.org_tx_complemento", org_orgaoT.getOrg_tx_complemento() + "");
        }
        param.put("org_orgaoT.org_tx_bairro", org_orgaoT.getOrg_tx_bairro() + "");
        param.put("org_orgaoT.org_tx_municipio", org_orgaoT.getOrg_tx_municipio() + "");
        param.put("org_orgaoT.org_tx_uf", org_orgaoT.getOrg_tx_uf() + "");
        param.put("org_orgaoT.org_tx_telefone1", org_orgaoT.getOrg_tx_telefone1() + "");
        if (org_orgaoT.getOrg_tx_telefone2() != null) {
            param.put("org_orgaoT.org_tx_telefone2", org_orgaoT.getOrg_tx_telefone2() + "");
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Org_orgaoTGWT org_orgaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("org_orgao").isObject();
                    Org_orgaoDAOGWT.this.org_orgaoT = lerRegistroJson(registro);
                }
            }
        };
        this.org_orgaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("org_orgaoT.org_nr_id", org_orgaoT.getOrg_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void excluir(Org_orgaoTGWT org_orgaoT) {
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
        param.put("org_orgaoT.org_nr_id", org_orgaoT.getOrg_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Org_orgaoTGWT org_orgaoT) {
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
        param.put("org_orgaoT.org_nr_id", org_orgaoT.getOrg_nr_id() + "");
        param.put("org_orgaoT.org_tx_cnpj", org_orgaoT.getOrg_tx_cnpj() + "");
        param.put("org_orgaoT.org_tx_razaosocial", org_orgaoT.getOrg_tx_razaosocial() + "");
        param.put("org_orgaoT.org_tx_nomefantasia", org_orgaoT.getOrg_tx_nomefantasia() + "");
        param.put("org_orgaoT.org_tx_inscestadual", org_orgaoT.getOrg_tx_inscestadual() + "");
        param.put("org_orgaoT.org_tx_tipologradouro", org_orgaoT.getOrg_tx_tipologradouro() + "");
        param.put("org_orgaoT.org_tx_logradouro", org_orgaoT.getOrg_tx_logradouro() + "");
        param.put("org_orgaoT.org_tx_numero", org_orgaoT.getOrg_tx_numero() + "");
        param.put("org_orgaoT.org_tx_cep", org_orgaoT.getOrg_tx_cep() + "");
        if (org_orgaoT.getOrg_tx_complemento() != null) {
            param.put("org_orgaoT.org_tx_complemento", org_orgaoT.getOrg_tx_complemento() + "");
        }
        param.put("org_orgaoT.org_tx_bairro", org_orgaoT.getOrg_tx_bairro() + "");
        param.put("org_orgaoT.org_tx_municipio", org_orgaoT.getOrg_tx_municipio() + "");
        param.put("org_orgaoT.org_tx_uf", org_orgaoT.getOrg_tx_uf() + "");
        param.put("org_orgaoT.org_tx_telefone1", org_orgaoT.getOrg_tx_telefone1() + "");
        if (org_orgaoT.getOrg_tx_telefone2() != null) {
            param.put("org_orgaoT.org_tx_telefone2", org_orgaoT.getOrg_tx_telefone2() + "");
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Org_orgaoTGWT> lista = new ListStore<Org_orgaoTGWT>();

            tree = new TreeMap<Integer, Org_orgaoTGWT>();
            for (int i = 0; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Org_orgaoTGWT org_orgaoT = lerRegistroJson(registro);
                lista.add(org_orgaoT);
                tree.put(org_orgaoT.getOrg_nr_id(), org_orgaoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json
     */
    private Org_orgaoTGWT lerRegistroJson(JSONObject registro) {
        Org_orgaoTGWT org_orgaoTGWT = new Org_orgaoTGWT();
        Integer org_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("org_nr_id").toString()));
        org_orgaoTGWT.setOrg_nr_id(org_nr_id);

        String org_tx_cnpj = EasyContainer.clearAspas(registro.get("org_tx_cnpj").toString());
        org_orgaoTGWT.setOrg_tx_cnpj(org_tx_cnpj);

        String org_tx_razaosocial = EasyContainer.clearAspas(registro.get("org_tx_razaosocial").toString());
        org_orgaoTGWT.setOrg_tx_razaosocial(org_tx_razaosocial);

        String org_tx_nomefantasia = EasyContainer.clearAspas(registro.get("org_tx_nomefantasia").toString());
        org_orgaoTGWT.setOrg_tx_nomefantasia(org_tx_nomefantasia);

        String org_tx_inscestadual = EasyContainer.clearAspas(registro.get("org_tx_inscestadual").toString());
        org_orgaoTGWT.setOrg_tx_inscestadual(org_tx_inscestadual);

        String org_tx_tipologradouro = EasyContainer.clearAspas(registro.get("org_tx_tipologradouro").toString());
        org_orgaoTGWT.setOrg_tx_tipologradouro(org_tx_tipologradouro);

        String org_tx_logradouro = EasyContainer.clearAspas(registro.get("org_tx_logradouro").toString());
        org_orgaoTGWT.setOrg_tx_logradouro(org_tx_logradouro);

        String org_tx_numero = EasyContainer.clearAspas(registro.get("org_tx_numero").toString());
        org_orgaoTGWT.setOrg_tx_numero(org_tx_numero);

        String org_tx_cep = EasyContainer.clearAspas(registro.get("org_tx_cep").toString());
        org_orgaoTGWT.setOrg_tx_cep(org_tx_cep);

        String org_tx_complemento = EasyContainer.clearAspas(registro.get("org_tx_complemento").toString());
        org_orgaoTGWT.setOrg_tx_complemento(org_tx_complemento);

        String org_tx_bairro = EasyContainer.clearAspas(registro.get("org_tx_bairro").toString());
        org_orgaoTGWT.setOrg_tx_bairro(org_tx_bairro);

        String org_tx_municipio = EasyContainer.clearAspas(registro.get("org_tx_municipio").toString());
        org_orgaoTGWT.setOrg_tx_municipio(org_tx_municipio);

        String org_tx_uf = EasyContainer.clearAspas(registro.get("org_tx_uf").toString());
        org_orgaoTGWT.setOrg_tx_uf(org_tx_uf);

        String org_tx_telefone1 = EasyContainer.clearAspas(registro.get("org_tx_telefone1").toString());
        org_orgaoTGWT.setOrg_tx_telefone1(org_tx_telefone1);

        String org_tx_telefone2 = EasyContainer.clearAspas(registro.get("org_tx_telefone2").toString());
        org_orgaoTGWT.setOrg_tx_telefone2(org_tx_telefone2);

        org_orgaoTGWT.setCodigoNome(org_nr_id + "-" + org_tx_nomefantasia);
        return org_orgaoTGWT;
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
     * @return the org_orgaoT
     */
    public Org_orgaoTGWT getOrg_orgaoT() {
        return org_orgaoT;
    }

    /**
     * @param org_orgaoTGWT the org_orgaoTGWT to set
     */
    public void setOrg_orgaoTGWT(Org_orgaoTGWT org_orgaoT) {
        this.org_orgaoT = org_orgaoT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Org_orgaoTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Org_orgaoTGWT> tree) {
        this.tree = tree;
    }
}
