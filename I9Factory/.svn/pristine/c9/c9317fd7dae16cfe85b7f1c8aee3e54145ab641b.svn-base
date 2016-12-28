package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_creditoUpdateDeleteJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Tic_tipo_creditoT tic_tipo_creditoT = new Tic_tipo_creditoT();

  public void setTic_tipo_creditoT(Tic_tipo_creditoT tic_tipo_creditoT) {
    this.tic_tipo_creditoT = tic_tipo_creditoT;
  }

  public Tic_tipo_creditoT getTic_tipo_creditoT() {	
    return tic_tipo_creditoT;
  }

	
  private List<Tic_tipo_creditoT> list;

  public List<Tic_tipo_creditoT> getList() {
    return list;
  }
  
  public void setList(List<Tic_tipo_creditoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      tic_tipo_creditoT = new Tic_tipo_creditoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
        tic_tipo_creditoDAO.delete(tic_tipo_creditoT);	 
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
      Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
      List<Tic_tipo_creditoT> listTemp  = tic_tipo_creditoDAO.getByPK( tic_tipo_creditoT);	 

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
        Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
        tic_tipo_creditoDAO.update(tic_tipo_creditoT);	 
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


  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
      List<Tic_tipo_creditoT> listTemp  = tic_tipo_creditoDAO.getByPK( tic_tipo_creditoT);	 

      tic_tipo_creditoT= listTemp.size()>0?listTemp.get(0):new Tic_tipo_creditoT();
      
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
	  String page = "tic_tipo_creditoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tic_tipo_creditoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
