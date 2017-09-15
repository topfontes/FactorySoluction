package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Org_orgaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Org_orgaoT org_orgaoT = new Org_orgaoT();

  public void setOrg_orgaoT(Org_orgaoT org_orgaoT) {
    this.org_orgaoT = org_orgaoT;
  }

  public Org_orgaoT getOrg_orgaoT() {	
    return org_orgaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodo de Eventos
  public void insert() throws Exception {   
    try {
      Org_orgaoDAO org_orgaoDAO =  getOrg_orgaoDAO();
      org_orgaoDAO.insert(org_orgaoT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      org_orgaoT = new Org_orgaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "org_orgaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
