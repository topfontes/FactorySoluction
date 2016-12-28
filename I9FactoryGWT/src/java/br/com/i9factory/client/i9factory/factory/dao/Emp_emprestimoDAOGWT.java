package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Emp_emprestimoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Emp_emprestimoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/emp_emprestimo/emp_emprestimoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/emp_emprestimo/emp_emprestimoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Emp_emprestimoTGWT emp_emprestimoT;
    private float perComissao = 0;

    public void consultarTodos(String status, Date inicio, Date fim, int cliente, int corretor, int orgao, int usuario, String grupo) {

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("status", status);
        param.put("dtInicio", dtfDate.format(inicio));
        param.put("dtFinal", dtfDate.format(fim));
        param.put("agrupamento", grupo);

        //http://localhost:8084/i9factory/i9factory/factory/emp_emprestimo/emp_emprestimoConsultGWT.jsp?op=consult&status=A&dtInicio=01/01/2001&dtFinal=01/01/2019&agrupamento=G&
        if (cliente > 0) {
            param.put("emp_emprestimoT.cli_nr_id", cliente + "");
        } else if (corretor > 0) {
            param.put("emp_emprestimoT.cor_nr_id", corretor + "");
        } else if (orgao > 0) {
            param.put("emp_emprestimoT.org_nr_id", orgao + "");
        } else if (usuario > 0) {
            param.put("emp_emprestimoT.usu_nr_id", usuario + "");
        }

        list = null;
        msg = null;

        IListenetResponse response = new IListenetResponse() {
            public void read(JSONValue jsonValue) {
                //Window.alert(jsonValue.toString());
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONArray resultado = jsonObject.get("resultado").isArray();
                    ListStore<Emp_emprestimoTGWT> lista = new ListStore<Emp_emprestimoTGWT>();
                    for (int i = 1; i < resultado.size(); i++) {
                        JSONObject registro = resultado.get(i).isObject();
                        Emp_emprestimoTGWT emp_emprestimoT = lerRegistroJson(registro);
                        lista.add(emp_emprestimoT);
                    }
                    list = lista;
                }
            }
        };

        EasyAccessURL eaurl = new EasyAccessURL(this);
        //Window.alert(Constantes.URL + PAGE_CONSULTAR+" = "+param.toString());
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultarComissaoCorretor(Date inicio, Date fim, int corretor, float percComissao, String tipo) {
        this.perComissao = percComissao;

        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarComissao");
        param.put("dtInicio", dtfDate.format(inicio));
        param.put("dtFinal", dtfDate.format(fim));
        param.put("percComissao", percComissao + "");
        param.put("tipo", tipo);
        //dtInicio=01/07/2011&dtFinal=01/08/2011&percComissao=2&tipo=M&emp_emprestimoT.cor_nr_id=1

        param.put("emp_emprestimoT.cor_nr_id", corretor + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultarUltimos() {
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("ultimos", "true");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
        //i9factory/i9factory/factory/emp_emprestimo/emp_emprestimoConsultGWT.jsp?op=consult&ultimos=true
        list = null;
        msg = null;
    }

    public void inserir(Emp_emprestimoTGWT emp_emprestimoT, int numeroParAFIN, float valorParcAfin, float valorMensalidade, int numeroParcMensalidade, String paramDesconto, String dataAverbacao, int id_emprestimoBaixa) {
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

        param.put("numeroParAFIN", numeroParAFIN + "");
        param.put("valorParcAfin", valorParcAfin + "");
        param.put("valorMensalidade", valorMensalidade + "");
        param.put("numeroParcMensalidade", numeroParcMensalidade + "");
        param.put("emp_emprestimoT.emp_nr_proposta", emp_emprestimoT.getEmp_nr_proposta() + "");
        param.put("emp_emprestimoT.cli_nr_id", emp_emprestimoT.getCli_nr_id() + "");
        param.put("emp_emprestimoT.org_nr_id", emp_emprestimoT.getOrg_nr_id() + "");
        param.put("emp_emprestimoT.cor_nr_id", emp_emprestimoT.getCor_nr_id() + "");
        
        param.put("emp_emprestimoT.idc_nr_id", emp_emprestimoT.getIdc_nr_id() + "");
        
        param.put("emp_emprestimoT.emp_dt_emprestimo", dtfDate.format(emp_emprestimoT.getEmp_dt_emprestimo()));
        param.put("emp_emprestimoT.emp_nr_valor", emp_emprestimoT.getEmp_nr_valor() + "");
        param.put("emp_emprestimoT.emp_tx_status", emp_emprestimoT.getEmp_tx_status());
        if (emp_emprestimoT.getEmp_tx_observacoes() != null) {
            param.put("emp_emprestimoT.emp_tx_observacoes", emp_emprestimoT.getEmp_tx_observacoes());
        }

        param.put("emp_emprestimoT.emp_dt_aprovacao", dtfDate.format(emp_emprestimoT.getEmp_dt_aprovacao()));
        param.put("emp_emprestimoT.emp_dt_liberacao", dataAverbacao);

        param.put("emp_emprestimoT.emp_nr_valor_afin_bruto", emp_emprestimoT.getEmp_nr_valor_afin_bruto() + "");
        param.put("emp_emprestimoT.emp_nr_valor_afin_liquido", emp_emprestimoT.getEmp_nr_valor_afin_liquido() + "");
        
        param.put("emp_emprestimoT.emp_nr_valor_parcelas_anterior", emp_emprestimoT.getEmp_nr_valor_parcelas_anterior() + "");
        
        param.put("emp_emprestimoT.emp_nr_valor_desc_parcela_anterior", emp_emprestimoT.getEmp_nr_valor_desc_parcela_anterior() + "");
        
        param.put("emp_emprestimoT.tic_nr_id", emp_emprestimoT.getTic_nr_id() + "");
        
        param.put("emp_emprestimoT.emp_tx_numerocheque", emp_emprestimoT.getEmp_tx_numerocheque() + "");
        
        param.put("emp_emprestimoT.emp_tx_acordo", emp_emprestimoT.getEmp_tx_acordo() + "");
        param.put("emp_emprestimoT.emp_seq_nr_boletobb", emp_emprestimoT.getEmp_seq_nr_boletobb() + "");
//        param.put("emp_emprestimoT.emp_nr_proposta", emp_emprestimoT.getEmp_nr_proposta()+"");
        param.put("paramDesconto", "ok" + paramDesconto);
        param.put("dataAverbacao", dataAverbacao);
        param.put("id_emprestimoBaixa", id_emprestimoBaixa + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Emp_emprestimoTGWT emp_emprestimoT) {
        IListenetResponse listener = new IListenetResponse() {
            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("emp_emprestimo").isObject();
                    Emp_emprestimoDAOGWT.this.emp_emprestimoT = lerRegistroJson(registro);
                }
            }
        };
        this.emp_emprestimoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("emp_emprestimoT.emp_nr_id", emp_emprestimoT.getEmp_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Emp_emprestimoTGWT emp_emprestimoT) {
        IListenetResponse listener = new IListenetResponse() {
            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").toString();
                    msg = EasyContainer.clearAspas(result.toString());
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");
        param.put("emp_emprestimoT.emp_nr_id", emp_emprestimoT.getEmp_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void updateCompensado(Emp_emprestimoTGWT emp_emprestimoT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {
            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").toString();
                    msg = EasyContainer.clearAspas(result.toString());
                }
            }
        };

        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "updatecompensado");
        param.put("emp_emprestimoT.emp_tx_compensado", emp_emprestimoT.getEmp_tx_compensado() + "");
        param.put("emp_emprestimoT.emp_nr_id", emp_emprestimoT.getEmp_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        //Window.alert(url + param);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Emp_emprestimoTGWT emp_emprestimoT, int numeroParAFIN, float valorParcAfin, float valorMensalidade, int numeroParcMensalidade, String paramDesconto, String dataAverbacao, int id_emprestimoBaixa) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {
            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").toString();
                    msg = EasyContainer.clearAspas(result.toString());
                }
            }
        };

        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");

        param.put("numeroParAFIN", numeroParAFIN + "");
        param.put("valorParcAfin", valorParcAfin + "");
        param.put("valorMensalidade", valorMensalidade + "");
        param.put("numeroParcMensalidade", numeroParcMensalidade + "");
        param.put("emp_emprestimoT.emp_nr_proposta", emp_emprestimoT.getEmp_nr_proposta() + "");
        param.put("emp_emprestimoT.emp_nr_id", emp_emprestimoT.getEmp_nr_id() + "");
        param.put("emp_emprestimoT.cli_nr_id", emp_emprestimoT.getCli_nr_id() + "");
        param.put("emp_emprestimoT.org_nr_id", emp_emprestimoT.getOrg_nr_id() + "");
        param.put("emp_emprestimoT.cor_nr_id", emp_emprestimoT.getCor_nr_id() + "");
        param.put("emp_emprestimoT.idc_nr_id", emp_emprestimoT.getIdc_nr_id() + "");
        param.put("emp_emprestimoT.emp_dt_emprestimo", dtfDate.format(emp_emprestimoT.getEmp_dt_emprestimo()));
        param.put("emp_emprestimoT.emp_nr_valor", emp_emprestimoT.getEmp_nr_valor() + "");
        param.put("emp_emprestimoT.emp_tx_status", emp_emprestimoT.getEmp_tx_status());
        if (emp_emprestimoT.getEmp_tx_observacoes() != null) {
            param.put("emp_emprestimoT.emp_tx_observacoes", emp_emprestimoT.getEmp_tx_observacoes());
        }

        param.put("emp_emprestimoT.emp_dt_aprovacao", dtfDate.format(emp_emprestimoT.getEmp_dt_aprovacao()));
        param.put("emp_emprestimoT.emp_dt_liberacao", dataAverbacao);

        param.put("emp_emprestimoT.emp_nr_valor_afin_bruto", emp_emprestimoT.getEmp_nr_valor_afin_bruto() + "");
        param.put("emp_emprestimoT.emp_nr_valor_afin_liquido", emp_emprestimoT.getEmp_nr_valor_afin_liquido() + "");
        param.put("emp_emprestimoT.emp_nr_valor_parcelas_anterior", emp_emprestimoT.getEmp_nr_valor_parcelas_anterior() + "");
        param.put("emp_emprestimoT.emp_nr_valor_desc_parcela_anterior", emp_emprestimoT.getEmp_nr_valor_desc_parcela_anterior() + "");

        param.put("emp_emprestimoT.tic_nr_id", emp_emprestimoT.getTic_nr_id() + "");
        param.put("emp_emprestimoT.emp_tx_numerocheque", emp_emprestimoT.getEmp_tx_numerocheque() + "");
        param.put("emp_emprestimoT.emp_tx_compensado", emp_emprestimoT.getEmp_tx_compensado() + "");
//        param.put("emp_emprestimoT.emp_nr_proposta", emp_emprestimoT.getEmp_nr_proposta()+"");
        param.put("paramDesconto", "ok" + paramDesconto);
        param.put("dataAverbacao", dataAverbacao);
        param.put("id_emprestimoBaixa", id_emprestimoBaixa + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {

        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Emp_emprestimoTGWT> lista = new ListStore<Emp_emprestimoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Emp_emprestimoTGWT emp_emprestimoT = lerRegistroJson(registro);
                lista.add(emp_emprestimoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json
     */
    private Emp_emprestimoTGWT lerRegistroJson(JSONObject registro) {
        Emp_emprestimoTGWT emp_emprestimoTGWT = new Emp_emprestimoTGWT();
        Integer emp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_id").toString()));
        emp_emprestimoTGWT.setEmp_nr_id(emp_nr_id);

        Integer cli_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cli_nr_id").toString()));
        emp_emprestimoTGWT.setCli_nr_id(cli_nr_id);

        if (!EasyContainer.clearAspas(registro.get("age_nr_id").toString()).isEmpty()) {
            Integer age_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("age_nr_id").toString()));
            emp_emprestimoTGWT.setAge_nr_id(age_nr_id);
        }

        Integer idc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("idc_nr_id").toString()));
        emp_emprestimoTGWT.setIdc_nr_id(idc_nr_id);

        Integer cor_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_id").toString()));
        emp_emprestimoTGWT.setCor_nr_id(cor_nr_id);

        Integer org_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("org_nr_id").toString()));
        emp_emprestimoTGWT.setOrg_nr_id(org_nr_id);

        Date emp_dt_emprestimo = dtfDate.parse(EasyContainer.clearAspas(registro.get("emp_dt_emprestimo").toString()));
        emp_emprestimoTGWT.setEmp_dt_emprestimo(emp_dt_emprestimo);

        float emp_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("emp_nr_valor").toString()));
        emp_emprestimoTGWT.setEmp_nr_valor(emp_nr_valor);

        String emp_tx_status = EasyContainer.clearAspas(registro.get("emp_tx_status").toString());
        emp_emprestimoTGWT.setEmp_tx_status(emp_tx_status);

        String emp_tx_observacoes = EasyContainer.clearAspas(registro.get("emp_tx_observacoes").toString());
        emp_emprestimoTGWT.setEmp_tx_observacoes(emp_tx_observacoes);

        Date emp_dt_aprovacao = dtfDate.parse(EasyContainer.clearAspas(registro.get("emp_dt_aprovacao").toString()));
        emp_emprestimoTGWT.setEmp_dt_aprovacao(emp_dt_aprovacao);

        Date emp_dt_liberacao = dtfDate.parse(EasyContainer.clearAspas(registro.get("emp_dt_liberacao").toString()));
        emp_emprestimoTGWT.setEmp_dt_liberacao(emp_dt_liberacao);

        if (!EasyContainer.clearAspas(registro.get("emp_dt_quitacao").toString()).isEmpty()) {
            Date emp_dt_quitacao = dtfDate.parse(EasyContainer.clearAspas(registro.get("emp_dt_quitacao").toString()));
            emp_emprestimoTGWT.setEmp_dt_quitacao(emp_dt_quitacao);
        }
        if (!EasyContainer.clearAspas(registro.get("emp_dt_enviobanco").toString()).isEmpty()) {
            Date emp_dt_enviobanco = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("emp_dt_enviobanco").toString()));
            emp_emprestimoTGWT.setEmp_dt_enviobanco(emp_dt_enviobanco);
        }

        if (!EasyContainer.clearAspas(registro.get("emp_dt_retornobanco").toString()).isEmpty()) {
            Date emp_dt_retornobanco = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("emp_dt_retornobanco").toString()));
            emp_emprestimoTGWT.setEmp_dt_retornobanco(emp_dt_retornobanco);
        }

        String emp_tx_cdlancamentobanco = EasyContainer.clearAspas(registro.get("emp_tx_cdlancamentobanco").toString());
        emp_emprestimoTGWT.setEmp_tx_cdlancamentobanco(emp_tx_cdlancamentobanco);

        String emp_tx_cdlancamentopendente = EasyContainer.clearAspas(registro.get("emp_tx_cdlancamentopendente").toString());
        emp_emprestimoTGWT.setEmp_tx_cdlancamentopendente(emp_tx_cdlancamentopendente);

        String emp_tx_numerocheque = EasyContainer.clearAspas(registro.get("emp_tx_numerocheque").toString());
        emp_emprestimoTGWT.setEmp_tx_numerocheque(emp_tx_numerocheque);

        String cli_tx_nome = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
        emp_emprestimoTGWT.setCli_tx_nome(cli_tx_nome);

        String org_tx_nome = EasyContainer.clearAspas(registro.get("org_tx_nome").toString());
        emp_emprestimoTGWT.setOrg_tx_nome(org_tx_nome);

        String cor_tx_nome = EasyContainer.clearAspas(registro.get("cor_tx_nome").toString());
        emp_emprestimoTGWT.setCor_tx_nome(cor_tx_nome);

        String cli_tx_cpf = EasyContainer.clearAspas(registro.get("cli_tx_cpf").toString());
        emp_emprestimoTGWT.setCli_tx_cpf(cli_tx_cpf);

        String cli_tx_matricula = EasyContainer.clearAspas(registro.get("cli_tx_matricula").toString());
        emp_emprestimoTGWT.setCli_tx_matricula(cli_tx_matricula);

        String bco_tx_nome = EasyContainer.clearAspas(registro.get("bco_tx_nome").toString());
        emp_emprestimoTGWT.setBco_tx_nome(bco_tx_nome);

        String a = registro.get("emp_nr_valor_afin_bruto").toString();
        if (!EasyContainer.clearAspas(registro.get("emp_nr_valor_afin_bruto").toString()).isEmpty()) {
            float emp_nr_valor_afin_bruto = Float.parseFloat(EasyContainer.clearAspas(registro.get("emp_nr_valor_afin_bruto").toString()));
            emp_emprestimoTGWT.setEmp_nr_valor_afin_bruto(emp_nr_valor_afin_bruto);
        }

        if (!EasyContainer.clearAspas(registro.get("emp_nr_valor_afin_liquido").toString()).isEmpty()) {
            float emp_nr_valor_afin_liquido = Float.parseFloat(EasyContainer.clearAspas(registro.get("emp_nr_valor_afin_liquido").toString()));
            emp_emprestimoTGWT.setEmp_nr_valor_afin_liquido(emp_nr_valor_afin_liquido);
        }

        if (!EasyContainer.clearAspas(registro.get("emp_nr_valor_parcelas_anterior").toString()).isEmpty()) {
            float emp_nr_valor_parcelas_anterior = Float.parseFloat(EasyContainer.clearAspas(registro.get("emp_nr_valor_parcelas_anterior").toString()));
            emp_emprestimoTGWT.setEmp_nr_valor_parcelas_anterior(emp_nr_valor_parcelas_anterior);
        }

        String wa = EasyContainer.clearAspas(registro.get("emp_nr_valor_desc_parcela_anterior").toString());
        if (!EasyContainer.clearAspas(registro.get("emp_nr_valor_desc_parcela_anterior").toString()).isEmpty()) {
            float emp_nr_valor_descparcelas_anterior = Float.parseFloat(EasyContainer.clearAspas(registro.get("emp_nr_valor_desc_parcela_anterior").toString()));
            emp_emprestimoTGWT.setEmp_nr_valor_desc_parcela_anterior(emp_nr_valor_descparcelas_anterior);
        }

        if (!EasyContainer.clearAspas(registro.get("emp_nr_proposta").toString()).isEmpty()) {
            int emp_nr_proposta = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_proposta").toString()));
            emp_emprestimoTGWT.setEmp_nr_proposta(emp_nr_proposta);
        }
        if (perComissao > 0) {
            emp_emprestimoTGWT.setComissao(perComissao * emp_emprestimoTGWT.getEmp_nr_valor_afin_liquido() / 100);
        }

        String usu_tx_nome = EasyContainer.clearAspas(registro.get("usu_tx_nome").toString());
        emp_emprestimoTGWT.setUsu_tx_nome(usu_tx_nome);

        String emp_tx_compensado = EasyContainer.clearAspas(registro.get("emp_tx_compensado").toString());
        emp_emprestimoTGWT.setEmp_tx_compensado(emp_tx_compensado);

        String emp_tx_acordo = EasyContainer.clearAspas(registro.get("emp_tx_acordo").toString());
        emp_emprestimoTGWT.setEmp_tx_acordo(emp_tx_acordo);

        if (!EasyContainer.clearAspas(registro.get("emp_seq_nr_boletobb").toString()).isEmpty()) {
            Integer seq = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_seq_nr_boletobb").toString()));
            emp_emprestimoTGWT.setEmp_seq_nr_boletobb(seq);
        }
        if (!EasyContainer.clearAspas(registro.get("tic_nr_id").toString()).isEmpty()) {
            Integer tic_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tic_nr_id").toString()));
            emp_emprestimoTGWT.setTic_nr_id(tic_nr_id);
        }


        
        return emp_emprestimoTGWT;
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
     * @return the emp_emprestimoT
     */
    public Emp_emprestimoTGWT getEmp_emprestimoT() {
        return emp_emprestimoT;
    }

    /**
     * @param emp_emprestimoTGWT the emp_emprestimoTGWT to set
     */
    public void setEmp_emprestimoTGWT(Emp_emprestimoTGWT emp_emprestimoT) {
        this.emp_emprestimoT = emp_emprestimoT;
    }
}
