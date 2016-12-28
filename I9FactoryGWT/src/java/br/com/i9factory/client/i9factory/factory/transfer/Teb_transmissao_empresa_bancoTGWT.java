
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
public class Teb_transmissao_empresa_bancoTGWT extends BaseModel {
  public Teb_transmissao_empresa_bancoTGWT() {
  }

  public int getTeb_nr_id() {
    return  ((Integer)get("teb_nr_id")).intValue();
  }

  public void setTeb_nr_id(int teb_nr_id) {
    set("teb_nr_id", teb_nr_id);
  }

  public Date getTeb_dt_envio() {
    return  (Date)get("teb_dt_envio");
  }

  public void setTeb_dt_envio(Date teb_dt_envio) {
    set("teb_dt_envio", teb_dt_envio);
  }

  public Date getTeb_dt_retorno() {
    return  (Date)get("teb_dt_retorno");
  }

  public void setTeb_dt_retorno(Date teb_dt_retorno) {
    set("teb_dt_retorno", teb_dt_retorno);
  }

  public String getTeb_tx_status() {
    return  get("teb_tx_status");
  }

  public void setTeb_tx_status(String teb_tx_status) {
    set("teb_tx_status", teb_tx_status);
  }

  public String getTeb_tx_operacao() {
    return  get("teb_tx_operacao");
  }

  public void setTeb_tx_operacao(String teb_tx_operacao) {
    set("teb_tx_operacao", teb_tx_operacao);
  }

}

