
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
public class Lan_lancamentoTGWT extends BaseModel {
  public Lan_lancamentoTGWT() {
  }

  public int getLan_nr_id() {
    return  ((Integer)get("lan_nr_id")).intValue();
//    return get("lan_nr_id");
  }

  public void setLan_nr_id(int lan_nr_id) {
    set("lan_nr_id", lan_nr_id);
  }

  public int getCtr_nr_id() {
    return  ((Integer)get("ctr_nr_id")).intValue();
//    return get("ctr_nr_id");
  }

  public void setCtr_nr_id(int ctr_nr_id) {
    set("ctr_nr_id", ctr_nr_id);
  }

  public int getCtp_nr_id() {
    return  ((Integer)get("ctp_nr_id")).intValue();
//    return get("ctp_nr_id");
  }

  public void setCtp_nr_id(int ctp_nr_id) {
    set("ctp_nr_id", ctp_nr_id);
  }

  public int getLan_plc_nr_id_deb() {
    return  ((Integer)get("lan_plc_nr_id_deb")).intValue();
//    return get("lan_plc_nr_id_deb");
  }

  public void setLan_plc_nr_id_deb(int lan_plc_nr_id_deb) {
    set("lan_plc_nr_id_deb", lan_plc_nr_id_deb);
  }

  public int getLan_plc_nr_id_cred() {
    return  ((Integer)get("lan_plc_nr_id_cred")).intValue();
//    return get("lan_plc_nr_id_cred");
  }

  public void setLan_plc_nr_id_cred(int lan_plc_nr_id_cred) {
    set("lan_plc_nr_id_cred", lan_plc_nr_id_cred);
  }

  public Date getLan_dt_lancamento() {
    return  (Date)get("lan_dt_lancamento");
//    return get("lan_dt_lancamento");
  }

  public void setLan_dt_lancamento(Date lan_dt_lancamento) {
    set("lan_dt_lancamento", lan_dt_lancamento);
  }

  public String getLan_tx_historico() {
    return  get("lan_tx_historico");
//    return get("lan_tx_historico");
  }

  public void setLan_tx_historico(String lan_tx_historico) {
    set("lan_tx_historico", lan_tx_historico);
  }

  public float getLan_valor() {
    return  ((Float)get("lan_valor")).floatValue();
//    return get("lan_valor");
  }

  public void setLan_valor(float lan_valor) {
    set("lan_valor", lan_valor);
  }

  public float getLan_nr_id_super() {
    return  ((Float)get("lan_nr_id_super")).floatValue();
//    return get("lan_nr_id_super");
  }

  public void setLan_nr_id_super(float lan_nr_id_super) {
    set("lan_nr_id_super", lan_nr_id_super);
  }



}

