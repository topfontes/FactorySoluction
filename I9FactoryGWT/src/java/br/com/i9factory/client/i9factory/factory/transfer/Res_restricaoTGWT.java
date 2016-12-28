
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
public class Res_restricaoTGWT extends BaseModel {
  public Res_restricaoTGWT() {
  }

  public int getRes_nr_id() {
    return  ((Integer)get("res_nr_id")).intValue();
//    return get("res_nr_id");
  }

  public void setRes_nr_id(int res_nr_id) {
    set("res_nr_id", res_nr_id);
  }

  public String getRes_tx_nome() {
    return  get("res_tx_nome");
//    return get("res_tx_nome");
  }

  public void setRes_tx_nome(String res_tx_nome) {
    set("res_tx_nome", res_tx_nome);
  }

  public int getCli_nr_id() {
    return  ((Integer)get("cli_nr_id")).intValue();
//    return get("cli_nr_id");
  }

  public void setCli_nr_id(int cli_nr_id) {
    set("cli_nr_id", cli_nr_id);
  }

  public void setCli_tx_nome(String cli_tx_nome){
      set("cli_tx_nome", cli_tx_nome);
  }
  
  public String getCli_tx_nome(){
      return get("cli_tx_nome");
  }


}

