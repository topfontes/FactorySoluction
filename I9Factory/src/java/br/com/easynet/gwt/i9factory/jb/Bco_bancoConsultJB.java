package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Bco_bancoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Bco_bancoT bco_bancoT = new Bco_bancoT();

  public void setBco_bancoT(Bco_bancoT bco_bancoT) {
    this.bco_bancoT = bco_bancoT;
  }

  public Bco_bancoT getBco_bancoT() {	
    return bco_bancoT;
  }

  private List<Bco_bancoT> list;

  public List<Bco_bancoT> getList() {
    return list;
  }
  
  public void setList(List<Bco_bancoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
      list = bco_bancoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
      bco_bancoDAO.delete(bco_bancoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      bco_bancoT = new Bco_bancoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "bco_bancoInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
