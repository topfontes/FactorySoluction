package br.com.i9factory.client.i9factory.factory.dao;

import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Ctp_conta_pagarTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Lan_lancamentoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Ctp_conta_pagarDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9factory/factory/ctp_conta_pagar/ctp_conta_pagarInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Ctp_conta_pagarTGWT ctp_conta_pagarT;

    public void consultarTodos(String status, Date inicio, Date fim, int fornecedor, int tipo, String grupo) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("status", status);
        param.put("dt_inicio", dtfDate.format(inicio));
        param.put("dt_fim", dtfDate.format(fim));
        param.put("agrupamento", grupo);
        if (fornecedor > 0) {
            param.put("id_fornecedor", fornecedor + "");
        } else if (tipo > 0) {
            param.put("id_tipoDesp", tipo + "");
        }

        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultarTodosSemData(String status, int fornecedor, int tipo, String grupo) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("status", status);
        param.put("agrupamento", grupo);
        if (fornecedor > 0) {
            param.put("id_fornecedor", fornecedor + "");
        } else if (tipo > 0) {
            param.put("id_tipoDesp", tipo + "");
        }

        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }

    public void consultarAVencerHoje() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("avencer", "true");
        param.put("ctp_conta_pagarT.ctp_dt_vencimento", dtfDate.format(new Date()));
        eaurl.accessJSonMapNoMessage(Constantes.URL + PAGE_CONSULTAR, param);
        list = null;
        msg = null;
    }


    public void inserir(Ctp_conta_pagarTGWT ctp_conta_pagarT) {
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
        param.put("ctp_conta_pagarT.ctp_nr_doc", ctp_conta_pagarT.getCtp_nr_doc() + "");
        param.put("ctp_conta_pagarT.ctp_dt_emissao", dtfDate.format(ctp_conta_pagarT.getCtp_dt_emissao()));
        param.put("ctp_conta_pagarT.ctp_dt_vencimento", dtfDate.format(ctp_conta_pagarT.getCtp_dt_vencimento()));
        param.put("ctp_conta_pagarT.ctp_tx_pago", ctp_conta_pagarT.getCtp_tx_pago());
        param.put("ctp_conta_pagarT.ctp_tx_parcela", ctp_conta_pagarT.getCtp_tx_parcela());
        param.put("ctp_conta_pagarT.ctp_valor", ctp_conta_pagarT.getCtp_valor() + "");
        if (ctp_conta_pagarT.getCtp_dt_pagamento() != null) {
            param.put("ctp_conta_pagarT.ctp_dt_pagamento", dtfDate.format(ctp_conta_pagarT.getCtp_dt_pagamento()));
        }
        if (ctp_conta_pagarT.getCtp_vl_pago() > 0) {
            param.put("ctp_conta_pagarT.ctp_vl_pago", ctp_conta_pagarT.getCtp_vl_pago() + "");
        }

        if (ctp_conta_pagarT.getCtp_saldo() > 0) {
            param.put("ctp_conta_pagarT.ctp_saldo", ctp_conta_pagarT.getCtp_saldo() + "");
        }
        param.put("ctp_conta_pagarT.for_nr_id", ctp_conta_pagarT.getFor_nr_id() + "");
        param.put("ctp_conta_pagarT.tid_nr_id", ctp_conta_pagarT.getTid_nr_id() + "");
        if (ctp_conta_pagarT.getCtp_tx_obs() != null) {
            param.put("ctp_conta_pagarT.ctp_tx_obs", ctp_conta_pagarT.getCtp_tx_obs());
        }

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Ctp_conta_pagarTGWT ctp_conta_pagarT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("ctp_conta_pagar").isObject();
                    Ctp_conta_pagarDAOGWT.this.ctp_conta_pagarT = lerRegistroJson(registro);
                }
            }
        };
        this.ctp_conta_pagarT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("ctp_conta_pagarT.ctp_nr_id", ctp_conta_pagarT.getCtp_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Ctp_conta_pagarTGWT ctp_conta_pagarT) {
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
        param.put("ctp_conta_pagarT.ctp_nr_id", ctp_conta_pagarT.getCtp_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Ctp_conta_pagarTGWT ctp_conta_pagarT) {
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
        param.put("ctp_conta_pagarT.ctp_nr_id", ctp_conta_pagarT.getCtp_nr_id() + "");
        param.put("ctp_conta_pagarT.ctp_nr_doc", ctp_conta_pagarT.getCtp_nr_doc() + "");
        param.put("ctp_conta_pagarT.ctp_dt_emissao", dtfDate.format(ctp_conta_pagarT.getCtp_dt_emissao()));
        param.put("ctp_conta_pagarT.ctp_dt_vencimento", dtfDate.format(ctp_conta_pagarT.getCtp_dt_vencimento()));
        param.put("ctp_conta_pagarT.ctp_tx_pago", ctp_conta_pagarT.getCtp_tx_pago());
        param.put("ctp_conta_pagarT.ctp_tx_parcela", ctp_conta_pagarT.getCtp_tx_parcela());
        param.put("ctp_conta_pagarT.ctp_valor", ctp_conta_pagarT.getCtp_valor() + "");
        if (ctp_conta_pagarT.getCtp_dt_pagamento() != null) {
            param.put("ctp_conta_pagarT.ctp_dt_pagamento", dtfDate.format(ctp_conta_pagarT.getCtp_dt_pagamento()));
        }
        if (ctp_conta_pagarT.getCtp_vl_pago() > 0) {
            param.put("ctp_conta_pagarT.ctp_vl_pago", ctp_conta_pagarT.getCtp_vl_pago() + "");
        }

        if (ctp_conta_pagarT.getCtp_saldo() > 0) {
            param.put("ctp_conta_pagarT.ctp_saldo", ctp_conta_pagarT.getCtp_saldo() + "");
        }
        param.put("ctp_conta_pagarT.for_nr_id", ctp_conta_pagarT.getFor_nr_id() + "");
        param.put("ctp_conta_pagarT.tid_nr_id", ctp_conta_pagarT.getTid_nr_id() + "");
        if (ctp_conta_pagarT.getCtp_tx_obs() != null) {
            param.put("ctp_conta_pagarT.ctp_tx_obs", ctp_conta_pagarT.getCtp_tx_obs());
        }


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void baixar(Ctp_conta_pagarTGWT ctp_conta_pagarT, int id_conta, float valor_pago, String historico, String dataLancamento) {
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
        param.put("op", "baixar");
        param.put("ctp_conta_pagarT.ctp_nr_id", ctp_conta_pagarT.getCtp_nr_id() + "");
        param.put("ctp_conta_pagarT.ctp_nr_doc", ctp_conta_pagarT.getCtp_nr_doc() + "");
        param.put("ctp_conta_pagarT.ctp_dt_emissao", dtfDate.format(ctp_conta_pagarT.getCtp_dt_emissao()));
        param.put("ctp_conta_pagarT.ctp_dt_vencimento", dtfDate.format(ctp_conta_pagarT.getCtp_dt_vencimento()));
        param.put("ctp_conta_pagarT.ctp_tx_pago", ctp_conta_pagarT.getCtp_tx_pago());
        param.put("ctp_conta_pagarT.ctp_tx_parcela", ctp_conta_pagarT.getCtp_tx_parcela());
        param.put("ctp_conta_pagarT.ctp_valor", ctp_conta_pagarT.getCtp_valor() + "");
        if (ctp_conta_pagarT.getCtp_dt_pagamento() != null) {
            param.put("ctp_conta_pagarT.ctp_dt_pagamento", dtfDate.format(ctp_conta_pagarT.getCtp_dt_pagamento()));
        }
        if (ctp_conta_pagarT.getCtp_vl_pago() > 0) {
            param.put("ctp_conta_pagarT.ctp_vl_pago", ctp_conta_pagarT.getCtp_vl_pago() + "");
        }

        param.put("ctp_conta_pagarT.ctp_saldo", ctp_conta_pagarT.getCtp_saldo() + "");

        param.put("ctp_conta_pagarT.for_nr_id", ctp_conta_pagarT.getFor_nr_id() + "");
        param.put("ctp_conta_pagarT.tid_nr_id", ctp_conta_pagarT.getTid_nr_id() + "");
        param.put("id_conta", id_conta + "");
        param.put("valor_pago", valor_pago + "");
        param.put("dataLancamento", dataLancamento);

        if (historico != null) {
            param.put("historico", historico);
        }
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void extorna_pag(Lan_lancamentoTGWT lan_lancamentoT) {

        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    msg = jsonObject.toString();
                }
            }
        };
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "extornar_pag");
        param.put("lan_lancamentoT.lan_nr_id", lan_lancamentoT.getLan_nr_id() + "");
        param.put("lan_lancamentoT.lan_valor", lan_lancamentoT.getLan_valor() + "");
        param.put("lan_lancamentoT.ctp_nr_id", lan_lancamentoT.getCtp_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
        //i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsultGWT.jsp?op=extornar_pag&lan_lancamentoT.lan_nr_id=11&lan_lancamentoT.lan_valor=20&lan_lancamentoT.ctp_nr_id=1
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Ctp_conta_pagarTGWT> lista = new ListStore<Ctp_conta_pagarTGWT>();
            msg = resultado.get(0).isObject().get("registro").isString().stringValue();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Ctp_conta_pagarTGWT ctp_conta_pagarT = lerRegistroJson(registro);
                lista.add(ctp_conta_pagarT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json 
     */
    private Ctp_conta_pagarTGWT lerRegistroJson(JSONObject registro) {
        Ctp_conta_pagarTGWT ctp_conta_pagarTGWT = new Ctp_conta_pagarTGWT();
        Integer ctp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_id").toString()));
        ctp_conta_pagarTGWT.setCtp_nr_id(ctp_nr_id);

        Integer ctp_nr_doc = Integer.parseInt(EasyContainer.clearAspas(registro.get("ctp_nr_doc").toString()));
        ctp_conta_pagarTGWT.setCtp_nr_doc(ctp_nr_doc);

        Date ctp_dt_emissao = dtfDate.parse(EasyContainer.clearAspas(registro.get("ctp_dt_emissao").toString()));
        ctp_conta_pagarTGWT.setCtp_dt_emissao(ctp_dt_emissao);

        Date ctp_dt_vencimento = dtfDate.parse(EasyContainer.clearAspas(registro.get("ctp_dt_vencimento").toString()));
        ctp_conta_pagarTGWT.setCtp_dt_vencimento(ctp_dt_vencimento);

        String ctp_tx_pago = EasyContainer.clearAspas(registro.get("ctp_tx_pago").toString());
        ctp_conta_pagarTGWT.setCtp_tx_pago(ctp_tx_pago);

        String ctp_tx_parcela = EasyContainer.clearAspas(registro.get("ctp_tx_parcela").toString());
        ctp_conta_pagarTGWT.setCtp_tx_parcela(ctp_tx_parcela);

        float ctp_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_valor").toString()));
        ctp_conta_pagarTGWT.setCtp_valor(ctp_valor);
        if (EasyContainer.clearAspas(registro.get("ctp_dt_pagamento").toString()).trim().length() > 0) {
            Date ctp_dt_pagamento = dtfDate.parse(EasyContainer.clearAspas(registro.get("ctp_dt_pagamento").toString()));
            ctp_conta_pagarTGWT.setCtp_dt_pagamento(ctp_dt_pagamento);
        }

        float ctp_vl_pago = Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_vl_pago").toString()));
        ctp_conta_pagarTGWT.setCtp_vl_pago(ctp_vl_pago);

        float ctp_saldo = Float.parseFloat(EasyContainer.clearAspas(registro.get("ctp_saldo").toString()));
        ctp_conta_pagarTGWT.setCtp_saldo(ctp_saldo);

        Integer for_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("for_nr_id").toString()));
        ctp_conta_pagarTGWT.setFor_nr_id(for_nr_id);

        Integer tid_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tid_nr_id").toString()));
        ctp_conta_pagarTGWT.setTid_nr_id(tid_nr_id);

        String ctp_tx_obs = EasyContainer.clearAspas(registro.get("ctp_tx_obs").toString());
        ctp_conta_pagarTGWT.setCtp_tx_obs(ctp_tx_obs);

        String for_tx_nome = EasyContainer.clearAspas(registro.get("for_tx_nome").toString());
        ctp_conta_pagarTGWT.setFor_tx_nome(for_tx_nome);

        String tid_tx_nome = EasyContainer.clearAspas(registro.get("tid_tx_nome").toString());
        ctp_conta_pagarTGWT.setTid_tx_nome(tid_tx_nome);


        return ctp_conta_pagarTGWT;
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
     * @return the ctp_conta_pagarT
     */
    public Ctp_conta_pagarTGWT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }

    /**
     * @param ctp_conta_pagarTGWT the ctp_conta_pagarTGWT to set
     */
    public void setCtp_conta_pagarTGWT(Ctp_conta_pagarTGWT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
    }
}
