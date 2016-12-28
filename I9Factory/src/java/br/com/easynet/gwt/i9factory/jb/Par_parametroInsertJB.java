package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Par_parametroInsertJB extends SystemBase {

  // Atributos e propriedades
    private Par_parametroT par_parametroT = new Par_parametroT();

  public void setPar_parametroT(Par_parametroT par_parametroT) {
    this.par_parametroT = par_parametroT;
  }

  public Par_parametroT getPar_parametroT() {	
    return par_parametroT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Par_parametroDAO par_parametroDAO =  getPar_parametroDAOLocal();
      par_parametroDAO.insert(par_parametroT);	 
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
    
      par_parametroT = new Par_parametroT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "par_parametroConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
