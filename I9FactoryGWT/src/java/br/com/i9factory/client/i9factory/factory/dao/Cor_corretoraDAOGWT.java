package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Cor_corretoraTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Cor_corretoraDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/cor_corretora/cor_corretoraInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/cor_corretora/cor_corretoraConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/cor_corretora/cor_corretoraUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Cor_corretoraTGWT cor_corretoraT;
    private TreeMap<Integer, Cor_corretoraTGWT> map = new TreeMap<Integer, Cor_corretoraTGWT>();

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String,String> param = new HashMap<String, String>();
        param.put("op", "consult");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR,param);
        list = null;
        msg = null;
    }
    public void consultByNome(String nome) {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByNome");
        param.put("cor_corretoraT.cor_tx_nomefantasia", nome);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Cor_corretoraTGWT cor_corretoraT) {
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
        param.put("cor_corretoraT.cor_tx_cnpj", cor_corretoraT.getCor_tx_cnpj()+"");
        param.put("cor_corretoraT.cor_tx_razaosocial", cor_corretoraT.getCor_tx_razaosocial()+"");
        param.put("cor_corretoraT.cor_tx_nomefantasia", cor_corretoraT.getCor_tx_nomefantasia()+"");
        param.put("cor_corretoraT.cor_tx_inscestadual", cor_corretoraT.getCor_tx_inscestadual()+"");
        param.put("cor_corretoraT.cor_tx_responsavel", cor_corretoraT.getCor_tx_responsavel()+"");
        param.put("cor_corretoraT.cor_tx_tipologradouro", cor_corretoraT.getCor_tx_tipologradouro()+"");
        param.put("cor_corretoraT.cor_tx_logradouro", cor_corretoraT.getCor_tx_logradouro() + "");
        param.put("cor_corretoraT.cor_tx_numero", cor_corretoraT.getCor_tx_numero() + "");
        param.put("cor_corretoraT.cor_tx_cep", cor_corretoraT.getCor_tx_cep()+"");
        if (cor_corretoraT.getCor_tx_complemento() != null) {
            param.put("cor_corretoraT.cor_tx_complemento", cor_corretoraT.getCor_tx_complemento() + "");
        }
        param.put("cor_corretoraT.cor_tx_bairro", cor_corretoraT.getCor_tx_bairro()+"");
        param.put("cor_corretoraT.cor_tx_municipio", cor_corretoraT.getCor_tx_municipio()+"");
        param.put("cor_corretoraT.cor_tx_uf", cor_corretoraT.getCor_tx_uf()+"");
        param.put("cor_corretoraT.cor_tx_telefone1", cor_corretoraT.getCor_tx_telefone1()+"");
        if (cor_corretoraT.getCor_tx_telefone2() != null) {
            param.put("cor_corretoraT.cor_tx_telefone2", cor_corretoraT.getCor_tx_telefone2() + "");
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Cor_corretoraTGWT cor_corretoraT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("cor_corretora").isObject();
                    Cor_corretoraDAOGWT.this.cor_corretoraT = lerRegistroJson(registro);
                }
            }
        };
        this.cor_corretoraT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("cor_corretoraT.cor_nr_id", cor_corretoraT.getCor_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Cor_corretoraTGWT cor_corretoraT) {
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
        param.put("cor_corretoraT.cor_nr_id", cor_corretoraT.getCor_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Cor_corretoraTGWT cor_corretoraT) {
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
        param.put("cor_corretoraT.cor_nr_id", cor_corretoraT.getCor_nr_id()+"");
        param.put("cor_corretoraT.cor_tx_cnpj", cor_corretoraT.getCor_tx_cnpj()+"");
        param.put("cor_corretoraT.cor_tx_razaosocial", cor_corretoraT.getCor_tx_razaosocial()+"");
        param.put("cor_corretoraT.cor_tx_nomefantasia", cor_corretoraT.getCor_tx_nomefantasia()+"");
        param.put("cor_corretoraT.cor_tx_inscestadual", cor_corretoraT.getCor_tx_inscestadual()+"");
        param.put("cor_corretoraT.cor_tx_responsavel", cor_corretoraT.getCor_tx_responsavel()+"");
        param.put("cor_corretoraT.cor_tx_tipologradouro", cor_corretoraT.getCor_tx_tipologradouro()+"");
        param.put("cor_corretoraT.cor_tx_logradouro", cor_corretoraT.getCor_tx_logradouro()+"");
        param.put("cor_corretoraT.cor_tx_numero", cor_corretoraT.getCor_tx_numero()+"");
        param.put("cor_corretoraT.cor_tx_cep", cor_corretoraT.getCor_tx_cep()+"");
        if (cor_corretoraT.getCor_tx_complemento() != null) {
            param.put("cor_corretoraT.cor_tx_complemento", cor_corretoraT.getCor_tx_complemento()+"");
        }
        param.put("cor_corretoraT.cor_tx_bairro", cor_corretoraT.getCor_tx_bairro()+"");
        param.put("cor_corretoraT.cor_tx_municipio", cor_corretoraT.getCor_tx_municipio()+"");
        param.put("cor_corretoraT.cor_tx_uf", cor_corretoraT.getCor_tx_uf()+"");
        param.put("cor_corretoraT.cor_tx_telefone1", cor_corretoraT.getCor_tx_telefone1()+"");
        if (cor_corretoraT.getCor_tx_telefone2() != null) {
            param.put("cor_corretoraT.cor_tx_telefone2", cor_corretoraT.getCor_tx_telefone2()+"");
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Cor_corretoraTGWT> lista = new ListStore<Cor_corretoraTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Cor_corretoraTGWT cor_corretoraT = lerRegistroJson(registro);
                map.put(cor_corretoraT.getCor_nr_id(), cor_corretoraT);
                lista.add(cor_corretoraT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Cor_corretoraTGWT lerRegistroJson(JSONObject registro) {
        Cor_corretoraTGWT cor_corretoraTGWT = new Cor_corretoraTGWT();
        Integer cor_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_id").toString()));
        cor_corretoraTGWT.setCor_nr_id(cor_nr_id);

        String cor_tx_cnpj = EasyContainer.clearAspas(registro.get("cor_tx_cnpj").toString());
        cor_corretoraTGWT.setCor_tx_cnpj(cor_tx_cnpj);

        String cor_tx_razaosocial = EasyContainer.clearAspas(registro.get("cor_tx_razaosocial").toString());
        cor_corretoraTGWT.setCor_tx_razaosocial(cor_tx_razaosocial);

        String cor_tx_nomefantasia = EasyContainer.clearAspas(registro.get("cor_tx_nomefantasia").toString());
        cor_corretoraTGWT.setCor_tx_nomefantasia(cor_tx_nomefantasia);

        String cor_tx_inscestadual = EasyContainer.clearAspas(registro.get("cor_tx_inscestadual").toString());
        cor_corretoraTGWT.setCor_tx_inscestadual(cor_tx_inscestadual);

        String cor_tx_responsavel = EasyContainer.clearAspas(registro.get("cor_tx_responsavel").toString());
        cor_corretoraTGWT.setCor_tx_responsavel(cor_tx_responsavel);

        String cor_tx_tipologradouro = EasyContainer.clearAspas(registro.get("cor_tx_tipologradouro").toString());
        cor_corretoraTGWT.setCor_tx_tipologradouro(cor_tx_tipologradouro);

        String cor_tx_logradouro = EasyContainer.clearAspas(registro.get("cor_tx_logradouro").toString());
        cor_corretoraTGWT.setCor_tx_logradouro(cor_tx_logradouro);

        String cor_tx_numero = EasyContainer.clearAspas(registro.get("cor_tx_numero").toString());
        cor_corretoraTGWT.setCor_tx_numero(cor_tx_numero);

        String cor_tx_cep = EasyContainer.clearAspas(registro.get("cor_tx_cep").toString());
        cor_corretoraTGWT.setCor_tx_cep(cor_tx_cep);

        String cor_tx_complemento = EasyContainer.clearAspas(registro.get("cor_tx_complemento").toString());
        cor_corretoraTGWT.setCor_tx_complemento(cor_tx_complemento);

        String cor_tx_bairro = EasyContainer.clearAspas(registro.get("cor_tx_bairro").toString());
        cor_corretoraTGWT.setCor_tx_bairro(cor_tx_bairro.equalsIgnoreCase("null")?"":cor_tx_bairro);

        String cor_tx_municipio = EasyContainer.clearAspas(registro.get("cor_tx_municipio").toString());
        cor_corretoraTGWT.setCor_tx_municipio(cor_tx_municipio);

        String cor_tx_uf = EasyContainer.clearAspas(registro.get("cor_tx_uf").toString());
        cor_corretoraTGWT.setCor_tx_uf(cor_tx_uf);

        String cor_tx_telefone1 = EasyContainer.clearAspas(registro.get("cor_tx_telefone1").toString());
        cor_corretoraTGWT.setCor_tx_telefone1(cor_tx_telefone1.equalsIgnoreCase("null")?"":cor_tx_telefone1);

        String cor_tx_telefone2 = EasyContainer.clearAspas(registro.get("cor_tx_telefone2").toString());
        cor_corretoraTGWT.setCor_tx_telefone2(cor_tx_telefone2.equalsIgnoreCase("null")?"":cor_tx_telefone2);

        return cor_corretoraTGWT;
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
     * @return the cor_corretoraT
     */
    public Cor_corretoraTGWT getCor_corretoraT() {
        return cor_corretoraT;
    }

    /**
     * @param cor_corretoraTGWT the cor_corretoraTGWT to set
     */
    public void setCor_corretoraTGWT(Cor_corretoraTGWT cor_corretoraT) {
        this.cor_corretoraT = cor_corretoraT;
    }

    /**
     * @return the map
     */
    public TreeMap<Integer, Cor_corretoraTGWT> getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(TreeMap<Integer, Cor_corretoraTGWT> map) {
        this.map = map;
    }
}
