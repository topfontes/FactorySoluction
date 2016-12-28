package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Par_parametroUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Par_parametroT par_parametroT = new Par_parametroT();

  public void setPar_parametroT(Par_parametroT par_parametroT) {
    this.par_parametroT = par_parametroT;
  }

  public Par_parametroT getPar_parametroT() {	
    return par_parametroT;
  }

	
  private List<Par_parametroT> list;

  public List<Par_parametroT> getList() {
    return list;
  }
  
  public void setList(List<Par_parametroT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      par_parametroT = new Par_parametroT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Par_parametroDAO par_parametroDAO = getPar_parametroDAOLocal();
        par_parametroDAO.delete(par_parametroT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Par_parametroDAO par_parametroDAO = getPar_parametroDAOLocal();
      List<Par_parametroT> listTemp  = par_parametroDAO.getByPK( par_parametroT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Par_parametroDAO par_parametroDAO = getPar_parametroDAOLocal();
        par_parametroDAO.update(par_parametroT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Par_parametroDAO par_parametroDAO = getPar_parametroDAOLocal();
      List<Par_parametroT> listTemp  = par_parametroDAO.getByPK( par_parametroT);	 

      par_parametroT= listTemp.size()>0?listTemp.get(0):new Par_parametroT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p?gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "par_parametroConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "par_parametroConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
