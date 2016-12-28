
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
public class Eqp_equipeTGWT extends BaseModel {
  public Eqp_equipeTGWT() {
  }

  public int getEqp_nr_id() {
    return  ((Integer)get("eqp_nr_id")).intValue();
//    return get("eqp_nr_id");
  }

  public void setEqp_nr_id(int eqp_nr_id) {
    set("eqp_nr_id", eqp_nr_id);
  }

  public String getEqp_tx_nome() {
    return  get("eqp_tx_nome");
//    return get("eqp_tx_nome");
  }

  public void setEqp_tx_nome(String eqp_tx_nome) {
    set("eqp_tx_nome", eqp_tx_nome);
  }

  public String getEqp_tx_descricao() {
    return  get("eqp_tx_descricao");
//    return get("eqp_tx_descricao");
  }

  public void setEqp_tx_descricao(String eqp_tx_descricao) {
    set("eqp_tx_descricao", eqp_tx_descricao);
  }

  public int getCor_nr_id() {
    return  ((Integer)get("cor_nr_id")).intValue();
//    return get("cor_nr_id");
  }

  public void setCor_nr_id(int cor_nr_id) {
    set("cor_nr_id", cor_nr_id);
  }

  public String getCor_tx_nome() {
    return  get("cor_tx_nome");
//    return get("eqp_tx_nome");
  }

  public void setCor_tx_nome(String cor_tx_nome) {
    set("cor_tx_nome", cor_tx_nome);
  }

}

