package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Age_agenciadorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Age_agenciadorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/age_agenciador/age_agenciadorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/age_agenciador/age_agenciadorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/age_agenciador/age_agenciadorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Age_agenciadorTGWT age_agenciadorT;
    private TreeMap<Integer, Age_agenciadorTGWT> tree = new TreeMap<Integer, Age_agenciadorTGWT>();

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Age_agenciadorTGWT age_agenciadorT) {
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
        param.put("age_agenciadorT.age_tx_cpf", age_agenciadorT.getAge_tx_cpf() + "");
        param.put("age_agenciadorT.age_tx_nome", age_agenciadorT.getAge_tx_nome()+ "");
        param.put("age_agenciadorT.age_dt_nascimento", dtfDate.format(age_agenciadorT.getAge_dt_nascimento())+ "");
        param.put("age_agenciadorT.eqp_nr_id", age_agenciadorT.getEqp_nr_id() + "");
        param.put("age_agenciadorT.age_tx_tipologradouro", age_agenciadorT.getAge_tx_tipologradouro()+ "");
        param.put("age_agenciadorT.age_tx_logradouro", age_agenciadorT.getAge_tx_logradouro()+ "");
        param.put("age_agenciadorT.age_tx_numero", age_agenciadorT.getAge_tx_numero()+ "");
        param.put("age_agenciadorT.age_tx_cep", age_agenciadorT.getAge_tx_cep()+ "");
        
        if (age_agenciadorT.getAge_tx_complemento() != null) {
            param.put("age_agenciadorT.age_tx_complemento", age_agenciadorT.getAge_tx_complemento()+ "");
        }
        
        param.put("age_agenciadorT.age_tx_bairro", age_agenciadorT.getAge_tx_bairro()+ "");
        param.put("age_agenciadorT.age_tx_municipio", age_agenciadorT.getAge_tx_municipio()+ "");
        param.put("age_agenciadorT.age_tx_uf", age_agenciadorT.getAge_tx_uf()+ "");
        param.put("age_agenciadorT.age_tx_telefone2", age_agenciadorT.getAge_tx_telefone2()+ "");
        if (age_agenciadorT.getAge_tx_telefone2_1() != null) {
            param.put("age_agenciadorT.age_tx_telefone2_1", age_agenciadorT.getAge_tx_telefone2_1()+ "");
        }
        if (age_agenciadorT.getAge_tx_celular() != null) {
            param.put("age_agenciadorT.age_tx_celular", age_agenciadorT.getAge_tx_celular()+ "");
        }
        if (age_agenciadorT.getAge_tx_email() != null) {
            param.put("age_agenciadorT.age_tx_email", age_agenciadorT.getAge_tx_email()+ "");
        }
        param.put("age_agenciadorT.age_nr_taxaemprestimo", age_agenciadorT.getAge_nr_taxaemprestimo() + "");
        param.put("age_agenciadorT.age_nr_taxamensalidade", age_agenciadorT.getAge_nr_taxamensalidade() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Age_agenciadorTGWT age_agenciadorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("age_agenciador").isObject();
                    Age_agenciadorDAOGWT.this.age_agenciadorT = lerRegistroJson(registro);
                }
            }
        };
        this.age_agenciadorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("age_agenciadorT.age_nr_id", age_agenciadorT.getAge_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Age_agenciadorTGWT age_agenciadorT) {
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
        param.put("age_agenciadorT.age_nr_id", age_agenciadorT.getAge_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Age_agenciadorTGWT age_agenciadorT) {
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
        param.put("age_agenciadorT.age_nr_id", age_agenciadorT.getAge_nr_id()+"");
        param.put("age_agenciadorT.age_tx_cpf", age_agenciadorT.getAge_tx_cpf()+"");
        param.put("age_agenciadorT.age_tx_nome", age_agenciadorT.getAge_tx_nome()+"");
        param.put("age_agenciadorT.age_dt_nascimento", dtfDate.format(age_agenciadorT.getAge_dt_nascimento())+"");
        param.put("age_agenciadorT.eqp_nr_id", age_agenciadorT.getEqp_nr_id() + "");
        param.put("age_agenciadorT.age_tx_tipologradouro", age_agenciadorT.getAge_tx_tipologradouro()+"");
        param.put("age_agenciadorT.age_tx_logradouro", age_agenciadorT.getAge_tx_logradouro()+"");
        param.put("age_agenciadorT.age_tx_numero", age_agenciadorT.getAge_tx_numero()+"");
        param.put("age_agenciadorT.age_tx_cep", age_agenciadorT.getAge_tx_cep()+"");

        if (age_agenciadorT.getAge_tx_complemento() != null) {
            param.put("age_agenciadorT.age_tx_complemento", age_agenciadorT.getAge_tx_complemento()+"");
        }

        param.put("age_agenciadorT.age_tx_bairro", age_agenciadorT.getAge_tx_bairro()+"");
        param.put("age_agenciadorT.age_tx_municipio", age_agenciadorT.getAge_tx_municipio()+"");
        param.put("age_agenciadorT.age_tx_uf", age_agenciadorT.getAge_tx_uf()+"");
        param.put("age_agenciadorT.age_tx_telefone2", age_agenciadorT.getAge_tx_telefone2()+"");
        if (age_agenciadorT.getAge_tx_telefone2_1() != null) {
            param.put("age_agenciadorT.age_tx_telefone2_1", age_agenciadorT.getAge_tx_telefone2_1()+"");
        }
        if (age_agenciadorT.getAge_tx_celular() != null) {
            param.put("age_agenciadorT.age_tx_celular", age_agenciadorT.getAge_tx_celular()+"");
        }
        if (age_agenciadorT.getAge_tx_email() != null) {
            param.put("age_agenciadorT.age_tx_email", age_agenciadorT.getAge_tx_email()+"");
        }
        param.put("age_agenciadorT.age_nr_taxaemprestimo", age_agenciadorT.getAge_nr_taxaemprestimo() + "");
        param.put("age_agenciadorT.age_nr_taxamensalidade", age_agenciadorT.getAge_nr_taxamensalidade() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Age_agenciadorTGWT> lista = new ListStore<Age_agenciadorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Age_agenciadorTGWT age_agenciadorT = lerRegistroJson(registro);
                lista.add(age_agenciadorT);
                tree.put(age_agenciadorT.getAge_nr_id(), age_agenciadorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Age_agenciadorTGWT lerRegistroJson(JSONObject registro) {
        Age_agenciadorTGWT age_agenciadorTGWT = new Age_agenciadorTGWT();
        Integer age_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("age_nr_id").toString()));
        age_agenciadorTGWT.setAge_nr_id(age_nr_id);

        String age_tx_cpf = EasyContainer.clearAspas(registro.get("age_tx_cpf").toString());
        age_agenciadorTGWT.setAge_tx_cpf(age_tx_cpf);

        String age_tx_nome = EasyContainer.clearAspas(registro.get("age_tx_nome").toString());
        age_agenciadorTGWT.setAge_tx_nome(age_tx_nome);

        Date age_dt_cadastro = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("age_dt_cadastro").toString()));
        age_agenciadorTGWT.setAge_dt_cadastro(age_dt_cadastro);

        Date age_dt_nascimento = dtfDate.parse(EasyContainer.clearAspas(registro.get("age_dt_nascimento").toString()));
        age_agenciadorTGWT.setAge_dt_nascimento(age_dt_nascimento);

        Integer eqp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eqp_nr_id").toString()));
        age_agenciadorTGWT.setEqp_nr_id(eqp_nr_id);

        String age_tx_tipologradouro = EasyContainer.clearAspas(registro.get("age_tx_tipologradouro").toString());
        age_agenciadorTGWT.setAge_tx_tipologradouro(age_tx_tipologradouro);

        String age_tx_logradouro = EasyContainer.clearAspas(registro.get("age_tx_logradouro").toString());
        age_agenciadorTGWT.setAge_tx_logradouro(age_tx_logradouro);

        String age_tx_numero = EasyContainer.clearAspas(registro.get("age_tx_numero").toString());
        age_agenciadorTGWT.setAge_tx_numero(age_tx_numero);

        String age_tx_cep = EasyContainer.clearAspas(registro.get("age_tx_cep").toString());
        age_agenciadorTGWT.setAge_tx_cep(age_tx_cep);

        String age_tx_complemento = EasyContainer.clearAspas(registro.get("age_tx_complemento").toString());
        age_agenciadorTGWT.setAge_tx_complemento(age_tx_complemento);

        String age_tx_bairro = EasyContainer.clearAspas(registro.get("age_tx_bairro").toString());
        age_agenciadorTGWT.setAge_tx_bairro(age_tx_bairro);

        String age_tx_municipio = EasyContainer.clearAspas(registro.get("age_tx_municipio").toString());
        age_agenciadorTGWT.setAge_tx_municipio(age_tx_municipio);

        String age_tx_uf = EasyContainer.clearAspas(registro.get("age_tx_uf").toString());
        age_agenciadorTGWT.setAge_tx_uf(age_tx_uf);

        String age_tx_telefone2 = EasyContainer.clearAspas(registro.get("age_tx_telefone2").toString());
        age_agenciadorTGWT.setAge_tx_telefone2(age_tx_telefone2);

        String age_tx_telefone2_1 = EasyContainer.clearAspas(registro.get("age_tx_telefone2_1").toString());
        age_agenciadorTGWT.setAge_tx_telefone2_1(age_tx_telefone2_1);

        String age_tx_celular = EasyContainer.clearAspas(registro.get("age_tx_celular").toString());
        age_agenciadorTGWT.setAge_tx_celular(age_tx_celular);

        String age_tx_email = EasyContainer.clearAspas(registro.get("age_tx_email").toString());
        age_agenciadorTGWT.setAge_tx_email(age_tx_email);

        float age_nr_taxaemprestimo = Float.parseFloat(EasyContainer.clearAspas(registro.get("age_nr_taxaemprestimo").toString()));
        age_agenciadorTGWT.setAge_nr_taxaemprestimo(age_nr_taxaemprestimo);

        float age_nr_taxamensalidade = Float.parseFloat(EasyContainer.clearAspas(registro.get("age_nr_taxamensalidade").toString()));
        age_agenciadorTGWT.setAge_nr_taxamensalidade(age_nr_taxamensalidade);
        String eqp_tx_nome = EasyContainer.clearAspas(registro.get("eqp_tx_nome").toString());
        age_agenciadorTGWT.setEqp_tx_nome(eqp_tx_nome);
        return age_agenciadorTGWT;
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
     * @return the age_agenciadorT
     */
    public Age_agenciadorTGWT getAge_agenciadorT() {
        return age_agenciadorT;
    }

    /**
     * @param age_agenciadorTGWT the age_agenciadorTGWT to set
     */
    public void setAge_agenciadorTGWT(Age_agenciadorTGWT age_agenciadorT) {
        this.age_agenciadorT = age_agenciadorT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Age_agenciadorTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Age_agenciadorTGWT> tree) {
        this.tree = tree;
    }
}
