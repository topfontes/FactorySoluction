package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Org_orgaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Org_orgaoT org_orgaoT = new Org_orgaoT();

  public void setOrg_orgaoT(Org_orgaoT org_orgaoT) {
    this.org_orgaoT = org_orgaoT;
  }

  public Org_orgaoT getOrg_orgaoT() {	
    return org_orgaoT;
  }

	
  private List<Org_orgaoT> list;

  public List<Org_orgaoT> getList() {
    return list;
  }
  
  public void setList(List<Org_orgaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      org_orgaoT = new Org_orgaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
        org_orgaoDAO.delete(org_orgaoT);	 
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
      Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
      List<Org_orgaoT> listTemp  = org_orgaoDAO.getByPK( org_orgaoT);	 

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
        Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
        org_orgaoDAO.update(org_orgaoT);	 
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


  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
      List<Org_orgaoT> listTemp  = org_orgaoDAO.getByPK( org_orgaoT);	 

      org_orgaoT= listTemp.size()>0?listTemp.get(0):new Org_orgaoT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a pagina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "org_orgaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "org_orgaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
