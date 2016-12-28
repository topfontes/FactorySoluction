
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
public class Dep_dependenteTGWT extends BaseModel {
  public Dep_dependenteTGWT() {
  }

  public int getDep_nr_id() {
    return  ((Integer)get("dep_nr_id")).intValue();
//    return get("dep_nr_id");
  }

  public void setDep_nr_id(int dep_nr_id) {
    set("dep_nr_id", dep_nr_id);
  }

  public int getCli_nr_id() {
    return  ((Integer)get("cli_nr_id")).intValue();
//    return get("cli_nr_id");
  }

  public void setCli_nr_id(int cli_nr_id) {
    set("cli_nr_id", cli_nr_id);
  }

  public String getDep_tx_nome() {
    return  get("dep_tx_nome");
//    return get("dep_tx_nome");
  }

  public void setDep_tx_nome(String dep_tx_nome) {
    set("dep_tx_nome", dep_tx_nome);
  }

  public Date getDep_dt_nascimento() {
    return  (Date)get("dep_dt_nascimento");
//    return get("dep_dt_nascimento");
  }

  public void setDep_dt_nascimento(Date dep_dt_nascimento) {
    set("dep_dt_nascimento", dep_dt_nascimento);
  }

  public String getDep_tx_grauparentesco() {
    return  get("dep_tx_grauparentesco");
//    return get("dep_tx_grauparentesco");
  }

  public void setDep_tx_grauparentesco(String dep_tx_grauparentesco) {
    set("dep_tx_grauparentesco", dep_tx_grauparentesco);
  }



}

