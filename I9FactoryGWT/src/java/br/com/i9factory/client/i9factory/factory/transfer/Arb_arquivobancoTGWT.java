
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
public class Arb_arquivobancoTGWT extends BaseModel {
  public Arb_arquivobancoTGWT() {
  }

  public int getArb_nr_id() {
    return  ((Integer)get("arb_nr_id")).intValue();
  }

  public void setArb_nr_id(int arb_nr_id) {
    set("arb_nr_id", arb_nr_id);
  }

  public int getArb_nr_seq() {
    return  ((Integer)get("arb_nr_seq")).intValue();
  }

  public void setArb_nr_seq(int arb_nr_seq) {
    set("arb_nr_seq", arb_nr_seq);
  }

  public Date getArb_dt_data() {
    return  (Date)get("arb_dt_data");
  }

  public void setArb_dt_data(Date arb_dt_data) {
    set("arb_dt_data", arb_dt_data);
  }

  public String getArb_tx_tipo() {
    return  get("arb_tx_tipo");
  }

  public void setArb_tx_tipo(String arb_tx_tipo) {
    set("arb_tx_tipo", arb_tx_tipo);
  }



}

