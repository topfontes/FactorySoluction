package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Ple_parcelaemprestimoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;

import java.util.*;

public class Ple_parcelaemprestimoDAOGWT implements IListenetResponse {
    
    public static final String PAGE_INSERIR = "i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT;
    
    public void consultarTodos(int emp_nr_id) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("ple_parcelaemprestimoT.emp_nr_id", emp_nr_id + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }
    
    public void consultarTodosCliente(int cli_nr_id, String tipo) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("ple_parcelaemprestimoT.ple_tx_tipo", tipo);
        param.put("cli_nr_id", cli_nr_id + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }
    
    public void consultarTodosClienteVencidas(int cli_nr_id, String tipo) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("ple_parcelaemprestimoT.ple_tx_tipo", tipo);
        param.put("cli_nr_id", cli_nr_id + "");
        param.put("vencidas", "true");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }
    
    public void consultarTodos_do_cliente_orgao(int cli_nr_id, String tipo, int org_nr_id) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("org_nr_id", org_nr_id + "");
        param.put("ple_parcelaemprestimoT.ple_tx_tipo", tipo);
        param.put("cli_nr_id", cli_nr_id + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }
    
    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("todos", "true");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }
    
    public void consultarParcelasAtrazo() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("todos", "true");
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }
    
    public void inserir(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT) {
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
        param.put("ple_parcelaemprestimoT.emp_nr_id", ple_parcelaemprestimoT.getEmp_nr_id() + "");
        param.put("ple_parcelaemprestimoT.ple_dt_vencimento", dtfDate.format(ple_parcelaemprestimoT.getPle_dt_vencimento()));
        param.put("ple_parcelaemprestimoT.ple_nr_valorparcela", ple_parcelaemprestimoT.getPle_nr_valorparcela() + "");
        param.put("ple_parcelaemprestimoT.ple_nr_valordesconto", "0");
        param.put("ple_parcelaemprestimoT.ple_tx_tipo", ple_parcelaemprestimoT.getPle_tx_tipo());
        param.put("ple_parcelaemprestimoT.ple_tx_parcela", ple_parcelaemprestimoT.getPle_tx_parcela());
        param.put("ple_parcelaemprestimoT.ple_tx_historico", ple_parcelaemprestimoT.getPle_tx_historico());
        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void pesquisar(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT) {
        IListenetResponse listener = new IListenetResponse() {
            
            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("ple_parcelaemprestimo").isObject();
                    Ple_parcelaemprestimoDAOGWT.this.ple_parcelaemprestimoT = lerRegistroJson(registro);
                }
            }
        };
        this.ple_parcelaemprestimoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("ple_parcelaemprestimoT.ple_nr_id", ple_parcelaemprestimoT.getPle_nr_id() + "");
        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
        
    }
    
    public void excluir(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT) {
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
        param.put("ple_parcelaemprestimoT.ple_nr_id", ple_parcelaemprestimoT.getPle_nr_id() + "");
        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void suspender(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT) {
        
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
        param.put("ple_parcelaemprestimoT.ple_nr_id", ple_parcelaemprestimoT.getPle_nr_id() + "");
        param.put("ple_parcelaemprestimoT.ple_bl_suspenso", ple_parcelaemprestimoT.isPle_bl_suspenso() + "");
        param.put("suspenso", "true");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
        
    }
    
    public void alterar(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT) {
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
        
        param.put("ple_parcelaemprestimoT.ple_nr_id", ple_parcelaemprestimoT.getPle_nr_id() + "");
        
        param.put("ple_parcelaemprestimoT.emp_nr_id", ple_parcelaemprestimoT.getEmp_nr_id() + "");
        
        param.put("ple_parcelaemprestimoT.ple_dt_vencimento", dtfDate.format(ple_parcelaemprestimoT.getPle_dt_vencimento()));
        
        if (ple_parcelaemprestimoT.getPle_dt_pagamento() != null) {
            param.put("ple_parcelaemprestimoT.ple_dt_pagamento", dtfDate.format(ple_parcelaemprestimoT.getPle_dt_pagamento()));
        }
        
        param.put("ple_parcelaemprestimoT.ple_nr_valorparcela", ple_parcelaemprestimoT.getPle_nr_valorparcela() + "");
        
        param.put("ple_parcelaemprestimoT.ple_nr_valordesconto", ple_parcelaemprestimoT.getPle_nr_valordesconto() + "");
//        param.put("ple_parcelaemprestimoT.ple_nr_cdformapagto", ple_parcelaemprestimoT.getPle_nr_cdformapagto() + "");

        param.put("ple_parcelaemprestimoT.ple_tx_tipo", ple_parcelaemprestimoT.getPle_tx_tipo());
        param.put("ple_parcelaemprestimoT.ple_tx_historico", ple_parcelaemprestimoT.getPle_tx_historico());
        
        param.put("ple_parcelaemprestimoT.ple_nr_id_vinculo", ple_parcelaemprestimoT.getPle_nr_id_vinculo() + "");
//        Window.alert("l");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
//        Window.alert(param.toString());
        eaurl.accessJSonMap(url, param);
    }
    
    public void alterarAll(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT, String ids) {
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
        param.put("op", "updateAll");
        param.put("ple_parcelaemprestimoT.ple_dt_pagamento", dtfDate.format(ple_parcelaemprestimoT.getPle_dt_pagamento()));
        param.put("ple_parcelaemprestimoT.ple_tx_historico", ple_parcelaemprestimoT.getPle_tx_historico());
        param.put("ple_parcelaemprestimoT.ple_nr_valordesconto", ple_parcelaemprestimoT.getPle_nr_valordesconto() + "");
        param.put("ple_parcelaemprestimoT.emp_nr_id", ple_parcelaemprestimoT.getEmp_nr_id() + "");
        param.put("ids", ids);
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            
            ListStore<Ple_parcelaemprestimoTGWT> lista = new ListStore<Ple_parcelaemprestimoTGWT>();
            
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT = lerRegistroJson(registro);
                lista.add(ple_parcelaemprestimoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json
     */
    private Ple_parcelaemprestimoTGWT lerRegistroJson(JSONObject registro) {
        Ple_parcelaemprestimoTGWT ple_parcelaemprestimoTGWT = new Ple_parcelaemprestimoTGWT();
        Integer ple_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ple_nr_id").toString()));
        ple_parcelaemprestimoTGWT.setPle_nr_id(ple_nr_id);
        
        Integer emp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_id").toString()));
        ple_parcelaemprestimoTGWT.setEmp_nr_id(emp_nr_id);
        
        Date ple_dt_vencimento = dtfDate.parse(EasyContainer.clearAspas(registro.get("ple_dt_vencimento").toString()));
        ple_parcelaemprestimoTGWT.setPle_dt_vencimento(ple_dt_vencimento);
        
        if (!EasyContainer.clearAspas(registro.get("ple_dt_pagamento").toString()).isEmpty()) {
            Date ple_dt_pagamento = dtfDate.parse(EasyContainer.clearAspas(registro.get("ple_dt_pagamento").toString()));
            ple_parcelaemprestimoTGWT.setPle_dt_pagamento(ple_dt_pagamento);
        }
        
        float ple_nr_valorparcela = Float.parseFloat(EasyContainer.clearAspas(registro.get("ple_nr_valorparcela").toString()));
        ple_parcelaemprestimoTGWT.setPle_nr_valorparcela(ple_nr_valorparcela);
        
        float ple_nr_valordesconto = Float.parseFloat(EasyContainer.clearAspas(registro.get("ple_nr_valordesconto").toString()));
        ple_parcelaemprestimoTGWT.setPle_nr_valordesconto(ple_nr_valordesconto);
        
        Integer ple_nr_cdformapagto = Integer.parseInt(EasyContainer.clearAspas(registro.get("ple_nr_cdformapagto").toString()));
        ple_parcelaemprestimoTGWT.setPle_nr_cdformapagto(ple_nr_cdformapagto);
        
        String ple_tx_parcela = EasyContainer.clearAspas(registro.get("ple_tx_parcela").toString());
        ple_parcelaemprestimoTGWT.setPle_tx_parcela(ple_tx_parcela);
        
        String ple_tx_tipo = EasyContainer.clearAspas(registro.get("ple_tx_tipo").toString());
        ple_parcelaemprestimoTGWT.setPle_tx_tipo(ple_tx_tipo);
        
        String ple_tx_historico = EasyContainer.clearAspas(registro.get("ple_tx_historico").toString());
        ple_parcelaemprestimoTGWT.setPle_tx_historico(ple_tx_historico);
        
        String cli_tx_nome = EasyContainer.clearAspas(registro.get("cli_tx_nome").toString());
        ple_parcelaemprestimoTGWT.setCli_tx_nome(cli_tx_nome);
        
        Integer ple_nr_id_vinculo = Integer.parseInt(EasyContainer.clearAspas(registro.get("ple_nr_id_vinculo").toString()));
        ple_parcelaemprestimoTGWT.setPle_nr_id_vinculo(ple_nr_id_vinculo);
        
        String vls = EasyContainer.clearAspas(registro.get("ple_nr_seq_boleto").toString());
        
        try {
            if (!vls.trim().isEmpty()) {
                Integer ple_nr_seq_boleto = Integer.parseInt(EasyContainer.clearAspas(registro.get("ple_nr_seq_boleto").toString()));
                ple_parcelaemprestimoTGWT.setPle_nr_seq_boleto(ple_nr_seq_boleto);
            }
        } catch (Exception e) {
        }

        //ple_nr_id_vinculo
        return ple_parcelaemprestimoTGWT;
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
     * @return the ple_parcelaemprestimoT
     */
    public Ple_parcelaemprestimoTGWT getPle_parcelaemprestimoT() {
        return ple_parcelaemprestimoT;
    }

    /**
     * @param ple_parcelaemprestimoTGWT the ple_parcelaemprestimoTGWT to set
     */
    public void setPle_parcelaemprestimoTGWT(Ple_parcelaemprestimoTGWT ple_parcelaemprestimoT) {
        this.ple_parcelaemprestimoT = ple_parcelaemprestimoT;
    }
}
