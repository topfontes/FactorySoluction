
/*
 * EasyNet JDragon
 */
package br.com.i9factory.client.i9factory.factory.transfer;
import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Bco_bancoTGWT extends BaseModel {
    
  public Bco_bancoTGWT() {
  }

  public int getBco_nr_id() {
    return  ((Integer)get("bco_nr_id")).intValue();
//    return get("bco_nr_id");
  }

  public void setBco_nr_id(int bco_nr_id) {
    set("bco_nr_id", bco_nr_id);
  }

  public String getBco_tx_nome() {
    return  get("bco_tx_nome");
//    return get("bco_tx_nome");
  }


  public void setBco_tx_nome(String bco_tx_nome) {
    set("bco_tx_nome", bco_tx_nome);
  }

   public String getBco_tx_codigo() {
    return  get("bco_tx_codigo");
//    return get("bco_tx_nome");
  }


  public void setBco_tx_codigo(String bco_tx_codigo) {
    set("bco_tx_codigo", bco_tx_codigo);
  }

  public String getBco_tx_telefone1() {
    return  get("bco_tx_telefone1");
  }

  public void setBco_tx_telefone1(String bco_tx_telefone1) {
    set("bco_tx_telefone1", bco_tx_telefone1);
  }

  public String getBco_tx_telefone2() {
    return  get("bco_tx_telefone2");
  }

  public void setBco_tx_telefone2(String bco_tx_telefone2) {
    set("bco_tx_telefone2", bco_tx_telefone2);
  }

  public String getBco_tx_nomecontato() {
    return  get("bco_tx_nomecontato");

  }

  public void setBco_tx_nomecontato(String bco_tx_nomecontato) {
    set("bco_tx_nomecontato", bco_tx_nomecontato);
  }

}

