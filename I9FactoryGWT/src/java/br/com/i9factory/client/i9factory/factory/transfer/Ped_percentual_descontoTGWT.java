
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
public class Ped_percentual_descontoTGWT extends BaseModel {
  public Ped_percentual_descontoTGWT() {
  }

  public int getPed_nr_id() {
    return  ((Integer)get("ped_nr_id")).intValue();
  }

  public void setPed_nr_id(int ped_nr_id) {
    set("ped_nr_id", ped_nr_id);
  }

  public int getPed_nr_parcela() {
    return  ((Integer)get("ped_nr_parcela")).intValue();
  }

  public void setPed_nr_parcela(int ped_nr_parcela) {
    set("ped_nr_parcela", ped_nr_parcela);
  }

  public float getPed_nr_desconto() {
    return  ((Float)get("ped_nr_desconto")).floatValue();
  }

  public void setPed_nr_desconto(float ped_nr_desconto) {
    set("ped_nr_desconto", ped_nr_desconto);
  }



}

