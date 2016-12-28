package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_parcelasUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_parcelasT vw_parcelasT = new Vw_parcelasT();

  public void setVw_parcelasT(Vw_parcelasT vw_parcelasT) {
    this.vw_parcelasT = vw_parcelasT;
  }

  public Vw_parcelasT getVw_parcelasT() {	
    return vw_parcelasT;
  }

	
  private List<Vw_parcelasT> list;

  public List<Vw_parcelasT> getList() {
    return list;
  }
  
  public void setList(List<Vw_parcelasT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_parcelasT = new Vw_parcelasT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_parcelasDAO vw_parcelasDAO = getVw_parcelasDAO();
        vw_parcelasDAO.delete(vw_parcelasT);	 
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
      Vw_parcelasDAO vw_parcelasDAO = getVw_parcelasDAO();
      List<Vw_parcelasT> listTemp  = vw_parcelasDAO.getByPK( vw_parcelasT);	 

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
        Vw_parcelasDAO vw_parcelasDAO = getVw_parcelasDAO();
        vw_parcelasDAO.update(vw_parcelasT);	 
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


  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Vw_parcelasDAO vw_parcelasDAO = getVw_parcelasDAO();
      List<Vw_parcelasT> listTemp  = vw_parcelasDAO.getByPK( vw_parcelasT);	 

      vw_parcelasT= listTemp.size()>0?listTemp.get(0):new Vw_parcelasT();
      
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
	  String page = "vw_parcelasConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_parcelasConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
