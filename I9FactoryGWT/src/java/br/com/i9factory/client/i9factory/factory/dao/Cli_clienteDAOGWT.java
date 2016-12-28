package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.relatorio.ContaAPagar_PagasRelGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cco_contacorrenteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Cli_clienteTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.MaxPropostaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Cli_clienteDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/cli_cliente/cli_clienteInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/cli_cliente/cli_clienteConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/cli_cliente/cli_clienteUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Cli_clienteTGWT cli_clienteT;
    private TreeMap<Integer, Cli_clienteTGWT> tree = new TreeMap<Integer, Cli_clienteTGWT>();
    private TreeMap<Integer, List<Cco_contacorrenteTGWT>> treeConta = new TreeMap<Integer, List<Cco_contacorrenteTGWT>>();
    private TreeMap<Integer, MaxPropostaTGWT> treeProposta = new TreeMap<Integer, MaxPropostaTGWT>();

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultarTodosFiltro(String campoFiltro, String conteudo, boolean filtrarOrgao) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("filtrarOrgao", filtrarOrgao + "");
        if (campoFiltro == null) {
            campoFiltro = "TODOS";
        }
        param.put("campoFiltro", campoFiltro);
        if (campoFiltro.equalsIgnoreCase("CPF")) {
            param.put("cli_clienteT.cli_tx_cpf", conteudo);
        } else if (campoFiltro.equalsIgnoreCase("nome")) {
            param.put("cli_clienteT.cli_tx_nome", conteudo);
        } else if (campoFiltro.equalsIgnoreCase("cli_nr_id")) {
            param.put("cli_clienteT.cli_nr_id", conteudo);
        } else {
            param.put("cli_clienteT.cli_tx_matricula", conteudo);
        }

        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultByNome(String nome) {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByNome");
        param.put("cli_clienteT.cli_tx_nome", nome);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Cli_clienteTGWT cli_clienteT) {
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
        param.put("cli_clienteT.cli_tx_nome", cli_clienteT.getCli_tx_nome());
        param.put("cli_clienteT.cli_tx_cpf", cli_clienteT.getCli_tx_cpf());
        param.put("cli_clienteT.cli_tx_rg", cli_clienteT.getCli_tx_rg());
        param.put("cli_clienteT.cli_tx_matricula", cli_clienteT.getCli_tx_matricula());
        param.put("cli_clienteT.cli_tx_sexo", cli_clienteT.getCli_tx_sexo());
        param.put("cli_clienteT.cli_tx_estadocivil", cli_clienteT.getCli_tx_estadocivil());
        param.put("cli_clienteT.cli_tx_tipologradouro", cli_clienteT.getCli_tx_tipologradouro());
        param.put("cli_clienteT.cli_tx_logradouro", cli_clienteT.getCli_tx_logradouro());
        param.put("cli_clienteT.cli_tx_numero", cli_clienteT.getCli_tx_numero());
        param.put("cli_clienteT.cli_tx_cep", cli_clienteT.getCli_tx_cep());
        param.put("cli_clienteT.cli_tx_complemento", cli_clienteT.getCli_tx_complemento());
        param.put("cli_clienteT.cli_tx_bairro", cli_clienteT.getCli_tx_bairro());
        param.put("cli_clienteT.cli_tx_municipio", cli_clienteT.getCli_tx_municipio());
        param.put("cli_clienteT.cli_tx_uf", cli_clienteT.getCli_tx_uf());
        param.put("cli_clienteT.cli_tx_email", cli_clienteT.getCli_tx_email());
        param.put("cli_clienteT.cli_tx_telefone1", cli_clienteT.getCli_tx_telefone1());
        param.put("cli_clienteT.cli_tx_telefone2", cli_clienteT.getCli_tx_telefone2());
        param.put("cli_clienteT.cli_tx_celular", cli_clienteT.getCli_tx_celular());
        param.put("cli_clienteT.cli_tx_ramal", cli_clienteT.getCli_tx_ramal());
        param.put("cli_clienteT.cli_dt_nascimento", dtfDate.format(cli_clienteT.getCli_dt_nascimento()));
        param.put("cli_clienteT.cli_dt_cadastro", dtfDateTime.format(cli_clienteT.getCli_dt_cadastro()));
        param.put("cli_clienteT.cli_tx_socio", cli_clienteT.getCli_tx_socio());
        param.put("cli_clienteT.cli_tx_salario_minimo", cli_clienteT.getCli_tx_salario_minimo());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Cli_clienteTGWT cli_clienteT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("cli_cliente").isObject();
                    Cli_clienteDAOGWT.this.cli_clienteT = lerRegistroJson(registro);
                }
            }
        };
        this.cli_clienteT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("cli_clienteT.cli_nr_id", cli_clienteT.getCli_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Cli_clienteTGWT cli_clienteT) {
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
        param.put("cli_clienteT.cli_nr_id", cli_clienteT.getCli_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Cli_clienteTGWT cli_clienteT) {
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
        param.put("cli_clienteT.cli_nr_id", cli_clienteT.getCli_nr_id() + "");
        param.put("cli_clienteT.cli_tx_nome", cli_clienteT.getCli_tx_nome());
        param.put("cli_clienteT.cli_tx_cpf", cli_clienteT.getCli_tx_cpf());
        param.put("cli_clienteT.cli_tx_rg", cli_clienteT.getCli_tx_rg());
        param.put("cli_clienteT.cli_tx_matricula", cli_clienteT.getCli_tx_matricula());
        param.put("cli_clienteT.cli_tx_sexo", cli_clienteT.getCli_tx_sexo());
        param.put("cli_clienteT.cli_tx_estadocivil", cli_clienteT.getCli_tx_estadocivil());
        param.put("cli_clienteT.cli_tx_tipologradouro", cli_clienteT.getCli_tx_tipologradouro());
        param.put("cli_clienteT.cli_tx_logradouro", cli_clienteT.getCli_tx_logradouro());
        param.put("cli_clienteT.cli_tx_numero", cli_clienteT.getCli_tx_numero());
        param.put("cli_clienteT.cli_tx_cep", cli_clienteT.getCli_tx_cep());
        param.put("cli_clienteT.cli_tx_complemento", cli_clienteT.getCli_tx_complemento());
        param.put("cli_clienteT.cli_tx_bairro", cli_clienteT.getCli_tx_bairro());
        param.put("cli_clienteT.cli_tx_municipio", cli_clienteT.getCli_tx_municipio());
        param.put("cli_clienteT.cli_tx_uf", cli_clienteT.getCli_tx_uf());
        param.put("cli_clienteT.cli_tx_email", cli_clienteT.getCli_tx_email());
        param.put("cli_clienteT.cli_tx_telefone1", cli_clienteT.getCli_tx_telefone1());
        param.put("cli_clienteT.cli_tx_telefone2", cli_clienteT.getCli_tx_telefone2());
        param.put("cli_clienteT.cli_tx_celular", cli_clienteT.getCli_tx_celular());
        param.put("cli_clienteT.cli_tx_ramal", cli_clienteT.getCli_tx_ramal());
        param.put("cli_clienteT.cli_dt_nascimento", dtfDate.format(cli_clienteT.getCli_dt_nascimento()));
        param.put("cli_clienteT.cli_dt_cadastro", dtfDateTime.format(cli_clienteT.getCli_dt_cadastro()));
        param.put("cli_clienteT.cli_tx_socio", cli_clienteT.getCli_tx_socio());
        param.put("cli_clienteT.cli_tx_salario_minimo", cli_clienteT.getCli_tx_salario_minimo());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Cli_clienteTGWT> lista = new ListStore<Cli_clienteTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Cli_clienteTGWT cli_clienteT = lerRegistroJson(registro);
                lista.add(cli_clienteT);
                getTree().put(cli_clienteT.getCli_nr_id(), cli_clienteT);
            }
            list = lista;

            //povoar treeMap de Contas de Cliente;
            JSONArray contas = jsonObject.get("contas").isArray();
            for (int i = 1; i < contas.size(); i++) {
                JSONObject registro = contas.get(i).isObject();
                Cco_contacorrenteTGWT conta = lerRegistroJsonContas(registro);
                if (treeConta.get(conta.getCli_nr_id()) == null) {
                    List<Cco_contacorrenteTGWT> list = new ArrayList<Cco_contacorrenteTGWT>();
                    list.add(conta);
                    treeConta.put(conta.getCli_nr_id(), list);
                } else {
                    treeConta.get(conta.getCli_nr_id()).add(conta);
                }
            }

            //povoar a ultima proposta do cliente
            JSONArray poposta = jsonObject.get("proposta").isArray();
            for (int i = 1; i < poposta.size(); i++) {
                JSONObject registro = poposta.get(i).isObject();
                MaxPropostaTGWT maxPropostaTGWT = lerRegistroJsonProposta(registro);
                treeProposta.put(maxPropostaTGWT.getCli_nr_id(), maxPropostaTGWT);
            }

        }
    }

    public MaxPropostaTGWT lerRegistroJsonProposta(JSONObject registro) {
        MaxPropostaTGWT maxPropostaTGWT = new MaxPropostaTGWT();
        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        maxPropostaTGWT.setCli_nr_id(cli_nr_id);

        maxPropostaTGWT.setUltimaProposta(0);
        if (!EasyContainer.clearAspas(registro.get("proposta").toString()).isEmpty()) {
            Integer ultimaProposta = Integer.parseInt(EasyContainer.clearAspas(registro.get("proposta").toString()));
            maxPropostaTGWT.setUltimaProposta(ultimaProposta);;
        }
        return maxPropostaTGWT;
    }

    /**
     * Ler os dados o conteúdo json
     */
    private Cli_clienteTGWT lerRegistroJson(JSONObject registro) {
        Cli_clienteTGWT cli_clienteTGWT = new Cli_clienteTGWT();
        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        cli_clienteTGWT.setCli_nr_id(cli_nr_id);

        String cli_tx_nome = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
        cli_clienteTGWT.setCli_tx_nome(cli_tx_nome);

        String cli_tx_cpf = EasyContainer.clearAspas(registro.get("cli_tx_cpf").toString());
        cli_clienteTGWT.setCli_tx_cpf(cli_tx_cpf);

        String cli_tx_rg = EasyContainer.clearAspas(registro.get("cli_tx_rg").toString());
        cli_clienteTGWT.setCli_tx_rg(cli_tx_rg.equalsIgnoreCase("null") ? "" : cli_tx_rg);

        String cli_tx_matricula = EasyContainer.clearAspas(registro.get("cli_tx_matricula").toString());
        cli_clienteTGWT.setCli_tx_matricula(cli_tx_matricula);

        String cli_tx_sexo = EasyContainer.clearAspas(registro.get("cli_tx_sexo").toString());
        cli_clienteTGWT.setCli_tx_sexo(cli_tx_sexo);

        String cli_tx_estadocivil = EasyContainer.clearAspas(registro.get("cli_tx_estadocivil").toString());
        cli_clienteTGWT.setCli_tx_estadocivil(cli_tx_estadocivil);

        String cli_tx_tipologradouro = EasyContainer.clearAspas(registro.get("cli_tx_tipologradouro").toString());
        cli_clienteTGWT.setCli_tx_tipologradouro(cli_tx_tipologradouro);

        String cli_tx_logradouro = EasyContainer.clearAspas(registro.get("cli_tx_logradouro").toString());
        cli_clienteTGWT.setCli_tx_logradouro(cli_tx_logradouro);

        String cli_tx_numero = EasyContainer.clearAspas(registro.get("cli_tx_numero").toString());
        cli_clienteTGWT.setCli_tx_numero(cli_tx_numero);

        String cli_tx_cep = EasyContainer.clearAspas(registro.get("cli_tx_cep").toString());
        cli_clienteTGWT.setCli_tx_cep(cli_tx_cep);

        String cli_tx_complemento = EasyContainer.clearAspas(registro.get("cli_tx_complemento").toString());
        cli_clienteTGWT.setCli_tx_complemento(cli_tx_complemento);

        String cli_tx_bairro = EasyContainer.clearAspas(registro.get("cli_tx_bairro").toString());
        cli_clienteTGWT.setCli_tx_bairro(cli_tx_bairro);

        String cli_tx_municipio = EasyContainer.clearAspas(registro.get("cli_tx_municipio").toString());
        cli_clienteTGWT.setCli_tx_municipio(cli_tx_municipio);

        String cli_tx_uf = EasyContainer.clearAspas(registro.get("cli_tx_uf").toString());
        cli_clienteTGWT.setCli_tx_uf(cli_tx_uf);

        String cli_tx_email = EasyContainer.clearAspas(registro.get("cli_tx_email").toString());
        cli_clienteTGWT.setCli_tx_email(cli_tx_email);

        String cli_tx_telefone1 = EasyContainer.clearAspas(registro.get("cli_tx_telefone1").toString());
        cli_clienteTGWT.setCli_tx_telefone1(cli_tx_telefone1.equals("null") ? "" : cli_tx_telefone1);

        String cli_tx_telefone2 = EasyContainer.clearAspas(registro.get("cli_tx_telefone2").toString());
        cli_clienteTGWT.setCli_tx_telefone2(cli_tx_telefone2.equalsIgnoreCase("null") ? "" : cli_tx_telefone2);

        String cli_tx_celular = EasyContainer.clearAspas(registro.get("cli_tx_celular").toString());
        cli_clienteTGWT.setCli_tx_celular(cli_tx_celular.equalsIgnoreCase("null") ? "" : cli_tx_celular);

        String cli_tx_ramal = EasyContainer.clearAspas(registro.get("cli_tx_ramal").toString());
        cli_clienteTGWT.setCli_tx_ramal(cli_tx_ramal);

        Date cli_dt_nascimento = dtfDate.parse(EasyContainer.clearAspas(registro.get("cli_dt_nascimento").toString()));
        cli_clienteTGWT.setCli_dt_nascimento(cli_dt_nascimento);

        Date cli_dt_cadastro = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("cli_dt_cadastro").toString()));
        cli_clienteTGWT.setCli_dt_cadastro(cli_dt_cadastro);

        String cli_tx_socio = EasyContainer.clearAspas(registro.get("cli_tx_socio").toString());
        cli_clienteTGWT.setCli_tx_socio(cli_tx_socio);

        Integer mtc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("mtc_nr_id").toString()));
        cli_clienteTGWT.setMtc_nr_id(mtc_nr_id);
        
        String cli_tx_salario_minimo = EasyContainer.clearAspas(registro.get("cli_tx_salario_minimo").toString());
        cli_clienteTGWT.setCli_tx_salario_minimo(cli_tx_salario_minimo);
        

        return cli_clienteTGWT;
    }

    private Cco_contacorrenteTGWT lerRegistroJsonContas(JSONObject registro) {

        Cco_contacorrenteTGWT conta = new Cco_contacorrenteTGWT();
        Integer cco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cco_nr_id").toString()));
        conta.setCco_nr_id(cco_nr_id);

        int cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        conta.setCli_nr_id(cli_nr_id);

        String cco_tx_nragencia = EasyContainer.clearAspas(registro.get("cco_tx_nragencia").toString());
        conta.setCco_tx_nragencia(cco_tx_nragencia);

        String cco_tx_nrcontacorrente = EasyContainer.clearAspas(registro.get("cco_tx_nrcontacorrente").toString());
        conta.setCco_tx_nrcontacorrente(cco_tx_nrcontacorrente);

        int bco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("bco_nr_id").toString()));
        conta.setBco_nr_id(bco_nr_id);

        int org_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("org_nr_id").toString()));
        conta.setOrg_nr_id(org_nr_id);

        String bco_tx_nome = EasyContainer.clearAspas(registro.get("bco_tx_nome").toString());
        conta.setBco_tx_nome(bco_tx_nome);

        String org_tx_nome = EasyContainer.clearAspas(registro.get("org_tx_nome").toString());
        conta.setOrg_tx_nome(org_tx_nome);

        return conta;
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
     * @return the cli_clienteT
     */
    public Cli_clienteTGWT getCli_clienteT() {
        return cli_clienteT;
    }

    /**
     * @param cli_clienteTGWT the cli_clienteTGWT to set
     */
    public void setCli_clienteTGWT(Cli_clienteTGWT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Cli_clienteTGWT> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Cli_clienteTGWT> tree) {
        this.tree = tree;
    }

    /**
     * @return the treeConta
     */
    public TreeMap<Integer, List<Cco_contacorrenteTGWT>> getTreeConta() {
        return treeConta;
    }

    /**
     * @param treeConta the treeConta to set
     */
    public void setTreeConta(TreeMap<Integer, List<Cco_contacorrenteTGWT>> treeConta) {
        this.treeConta = treeConta;
    }

    /**
     * @return the treeProposta
     */
    public TreeMap<Integer, MaxPropostaTGWT> getTreeProposta() {
        return treeProposta;
    }

    /**
     * @param treeProposta the treeProposta to set
     */
    public void setTreeProposta(TreeMap<Integer, MaxPropostaTGWT> treeProposta) {
        this.treeProposta = treeProposta;
    }
}
