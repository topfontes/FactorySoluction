package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.For_fornecedorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class For_fornecedorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/for_fornecedor/for_fornecedorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/for_fornecedor/for_fornecedorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/for_fornecedor/for_fornecedorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private For_fornecedorTGWT for_fornecedorT;
    private TreeMap<Integer,For_fornecedorTGWT> tree= new TreeMap<Integer, For_fornecedorTGWT>();

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(For_fornecedorTGWT for_fornecedorT) {
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
        param.put("for_fornecedorT.for_tx_nome", for_fornecedorT.getFor_tx_nome() + "");
        if (for_fornecedorT.getFor_tx_endereco() != null) {
            param.put("for_fornecedorT.for_tx_endereco", for_fornecedorT.getFor_tx_endereco() + "");
        }
        if (for_fornecedorT.getFor_tx_cpf_cnpj() != null) {
            param.put("for_fornecedorT.for_tx_cpf_cnpj", for_fornecedorT.getFor_tx_cpf_cnpj() + "");
        }
        if (for_fornecedorT.getFor_tx_rg_inscricao() != null) {
            param.put("for_fornecedorT.for_tx_rg_inscricao", for_fornecedorT.getFor_tx_rg_inscricao() + "");
        }
        if (for_fornecedorT.getFor_tx_cep() > 0 ) {
            param.put("for_fornecedorT.for_tx_cep", for_fornecedorT.getFor_tx_cep() + "");
        }
        if (for_fornecedorT.getFor_tx_cidade() != null) {
            param.put("for_fornecedorT.for_tx_cidade", for_fornecedorT.getFor_tx_cidade() + "");
        }
        if (for_fornecedorT.getFor_tx_estado() != null) {
            param.put("for_fornecedorT.for_tx_estado", for_fornecedorT.getFor_tx_estado() + "");
        }
        if (for_fornecedorT.getFor_tx_bairro() != null) {
            param.put("for_fornecedorT.for_tx_bairro", for_fornecedorT.getFor_tx_bairro() + "");
        }
        if (for_fornecedorT.getFor_tx_email() != null) {
            param.put("for_fornecedorT.for_tx_email", for_fornecedorT.getFor_tx_email() + "");
        }
        if (for_fornecedorT.getFor_tx_home_page() != null) {
            param.put("for_fornecedorT.for_tx_home_page", for_fornecedorT.getFor_tx_home_page() + "");
        }
        if (for_fornecedorT.getFor_tx_contato() != null) {
            param.put("for_fornecedorT.for_tx_contato", for_fornecedorT.getFor_tx_contato() + "");
        }
        if (for_fornecedorT.getFor_tx_status() != null) {
            param.put("for_fornecedorT.for_tx_status", for_fornecedorT.getFor_tx_status() + "");
        }
        if (for_fornecedorT.getFor_tx_telefone1() != null) {
            param.put("for_fornecedorT.for_tx_telefone1", for_fornecedorT.getFor_tx_telefone1() + "");
        }
        if (for_fornecedorT.getFor_tx_telefone2() != null) {
            param.put("for_fornecedorT.for_tx_telefone2", for_fornecedorT.getFor_tx_telefone2() + "");
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(For_fornecedorTGWT for_fornecedorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("for_fornecedor").isObject();
                    For_fornecedorDAOGWT.this.for_fornecedorT = lerRegistroJson(registro);
                }
            }
        };
        this.for_fornecedorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("for_fornecedorT.for_nr_id", for_fornecedorT.getFor_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(For_fornecedorTGWT for_fornecedorT) {
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
        param.put("for_fornecedorT.for_nr_id", for_fornecedorT.getFor_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(For_fornecedorTGWT for_fornecedorT) {
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
        param.put("for_fornecedorT.for_nr_id", for_fornecedorT.getFor_nr_id() + "");
        param.put("for_fornecedorT.for_tx_nome", for_fornecedorT.getFor_tx_nome() + "");
        if (for_fornecedorT.getFor_tx_endereco() != null) {
            param.put("for_fornecedorT.for_tx_endereco", for_fornecedorT.getFor_tx_endereco() + "");
        }
        if (for_fornecedorT.getFor_tx_cpf_cnpj() != null) {
            param.put("for_fornecedorT.for_tx_cpf_cnpj", for_fornecedorT.getFor_tx_cpf_cnpj() + "");
        }
        if (for_fornecedorT.getFor_tx_rg_inscricao() != null) {
            param.put("for_fornecedorT.for_tx_rg_inscricao", for_fornecedorT.getFor_tx_rg_inscricao() + "");
        }
        if (for_fornecedorT.getFor_tx_cep() > 0) {
            param.put("for_fornecedorT.for_tx_cep", for_fornecedorT.getFor_tx_cep() + "");
        }
        if (for_fornecedorT.getFor_tx_cidade() != null) {
            param.put("for_fornecedorT.for_tx_cidade", for_fornecedorT.getFor_tx_cidade() + "");
        }
        if (for_fornecedorT.getFor_tx_estado() != null) {
            param.put("for_fornecedorT.for_tx_estado", for_fornecedorT.getFor_tx_estado() + "");
        }
        if (for_fornecedorT.getFor_tx_bairro() != null) {
            param.put("for_fornecedorT.for_tx_bairro", for_fornecedorT.getFor_tx_bairro() + "");
        }
        if (for_fornecedorT.getFor_tx_email() != null) {
            param.put("for_fornecedorT.for_tx_email", for_fornecedorT.getFor_tx_email() + "");
        }
        if (for_fornecedorT.getFor_tx_home_page() != null) {
            param.put("for_fornecedorT.for_tx_home_page", for_fornecedorT.getFor_tx_home_page() + "");
        }
        if (for_fornecedorT.getFor_tx_contato() != null) {
            param.put("for_fornecedorT.for_tx_contato", for_fornecedorT.getFor_tx_contato() + "");
        }
        if (for_fornecedorT.getFor_tx_status() != null) {
            param.put("for_fornecedorT.for_tx_status", for_fornecedorT.getFor_tx_status() + "");
        }
        if (for_fornecedorT.getFor_tx_telefone1() != null) {
            param.put("for_fornecedorT.for_tx_telefone1", for_fornecedorT.getFor_tx_telefone1() + "");
        }
        if (for_fornecedorT.getFor_tx_telefone2() != null) {
            param.put("for_fornecedorT.for_tx_telefone2", for_fornecedorT.getFor_tx_telefone2() + "");
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<For_fornecedorTGWT> lista = new ListStore<For_fornecedorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                For_fornecedorTGWT for_fornecedorT = lerRegistroJson(registro);
                lista.add(for_fornecedorT);
                getTree().put(for_fornecedorT.getFor_nr_id(), for_fornecedorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private For_fornecedorTGWT lerRegistroJson(JSONObject registro) {
        For_fornecedorTGWT for_fornecedorTGWT = new For_fornecedorTGWT();
        Integer for_nr_id = Integer.parseInt(registro.get("for_nr_id").isString().stringValue());
        for_fornecedorTGWT.setFor_nr_id(for_nr_id);

        String for_tx_nome = EasyContainer.clearAspas(registro.get("for_tx_nome").toString());
        for_fornecedorTGWT.setFor_tx_nome(for_tx_nome);

        String for_tx_endereco = EasyContainer.clearAspas(registro.get("for_tx_endereco").toString());
        for_fornecedorTGWT.setFor_tx_endereco(for_tx_endereco);

        String for_tx_cpf_cnpj = EasyContainer.clearAspas(registro.get("for_tx_cpf_cnpj").toString());
        for_fornecedorTGWT.setFor_tx_cpf_cnpj(for_tx_cpf_cnpj);

        String for_tx_rg_inscricao = EasyContainer.clearAspas(registro.get("for_tx_rg_inscricao").toString());
        for_fornecedorTGWT.setFor_tx_rg_inscricao(for_tx_rg_inscricao);

        Integer for_tx_cep = Integer.parseInt(EasyContainer.clearAspas(registro.get("for_tx_cep").toString()));
        for_fornecedorTGWT.setFor_tx_cep(for_tx_cep);

        String for_tx_cidade = EasyContainer.clearAspas(registro.get("for_tx_cidade").toString());
        for_fornecedorTGWT.setFor_tx_cidade(for_tx_cidade);

        String for_tx_estado = EasyContainer.clearAspas(registro.get("for_tx_estado").toString());
        for_fornecedorTGWT.setFor_tx_estado(for_tx_estado);

        String for_tx_bairro = EasyContainer.clearAspas(registro.get("for_tx_bairro").toString());
        for_fornecedorTGWT.setFor_tx_bairro(for_tx_bairro);

        String for_tx_email = EasyContainer.clearAspas(registro.get("for_tx_email").toString());
        for_fornecedorTGWT.setFor_tx_email(for_tx_email);

        String for_tx_home_page = EasyContainer.clearAspas(registro.get("for_tx_home_page").toString());
        for_fornecedorTGWT.setFor_tx_home_page(for_tx_home_page);

        String for_tx_contato = EasyContainer.clearAspas(registro.get("for_tx_contato").toString());
        for_fornecedorTGWT.setFor_tx_contato(for_tx_contato);

        String for_tx_status = EasyContainer.clearAspas(registro.get("for_tx_status").toString());
        for_fornecedorTGWT.setFor_tx_status(for_tx_status);

        String for_tx_telefone1 = EasyContainer.clearAspas(registro.get("for_tx_telefone1").toString());
        for_fornecedorTGWT.setFor_tx_telefone1(for_tx_telefone1);
        
        String for_tx_telefone2 = EasyContainer.clearAspas(registro.get("for_tx_telefone2").toString());
        for_fornecedorTGWT.setFor_tx_telefone2(for_tx_telefone2);

        return for_fornecedorTGWT;
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
     * @return the for_fornecedorT
     */
    public For_fornecedorTGWT getFor_fornecedorT() {
        return for_fornecedorT;
    }

    /**
     * @param for_fornecedorTGWT the for_fornecedorTGWT to set
     */
    public void setFor_fornecedorTGWT(For_fornecedorTGWT for_fornecedorT) {
        this.for_fornecedorT = for_fornecedorT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, For_fornecedorTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, For_fornecedorTGWT> tree) {
        this.tree = tree;
    }
}
