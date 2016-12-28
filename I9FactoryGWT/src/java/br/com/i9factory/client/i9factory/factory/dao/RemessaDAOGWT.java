/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9factory.client.i9factory.factory.dao;
import br.com.i9factory.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9factory.client.i9factory.factory.transfer.Bco_bancoTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.RemessaTGWT;
import br.com.i9factory.client.i9factory.factory.transfer.Vw_parcelasTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.HashMap;
import java.util.TreeMap;
/**
 *
 * @author geoleite
 */
public class RemessaDAOGWT implements IListenetResponse  {
    public static final String PAGE_CONSULTAR = "i9factory/factory/remessa/remessa.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;

    public void consultarByOrgaoVencimentoBanco(Vw_parcelasTGWT vw_parcelasTGWT) {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "gerarArquivoPeriodo");
        param.put("vw_parcelasT.ple_dt_vencimento", "30/06/2011");
        param.put("vw_parcelasT.org_nr_id", "1");
        param.put("vw_parcelasT.bco_nr_id", "1");

        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<RemessaTGWT> lista = new ListStore<RemessaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                RemessaTGWT remessaT = lerRegistroJson(registro);
                lista.add(remessaT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conteúdo json
     */
    private RemessaTGWT lerRegistroJson(JSONObject registro) {
        RemessaTGWT remessaTGWT = new RemessaTGWT();

        String linha = registro.get("linha").isString().stringValue();
        remessaTGWT.setLinha(linha);
        return remessaTGWT;
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
}
