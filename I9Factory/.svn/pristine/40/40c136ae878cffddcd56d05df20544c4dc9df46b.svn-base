package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ped_percentual_descontoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ped_percentual_descontoT ped_percentual_descontoT = new Ped_percentual_descontoT();

  public void setPed_percentual_descontoT(Ped_percentual_descontoT ped_percentual_descontoT) {
    this.ped_percentual_descontoT = ped_percentual_descontoT;
  }

  public Ped_percentual_descontoT getPed_percentual_descontoT() {	
    return ped_percentual_descontoT;
  }

	
  private List<Ped_percentual_descontoT> list;

  public List<Ped_percentual_descontoT> getList() {
    return list;
  }
  
  public void setList(List<Ped_percentual_descontoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      ped_percentual_descontoT = new Ped_percentual_descontoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
        ped_percentual_descontoDAO.delete(ped_percentual_descontoT);	 
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
      Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
      List<Ped_percentual_descontoT> listTemp  = ped_percentual_descontoDAO.getByPK( ped_percentual_descontoT);	 

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
        Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
        ped_percentual_descontoDAO.update(ped_percentual_descontoT);	 
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
      Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
      List<Ped_percentual_descontoT> listTemp  = ped_percentual_descontoDAO.getByPK( ped_percentual_descontoT);	 

      ped_percentual_descontoT= listTemp.size()>0?listTemp.get(0):new Ped_percentual_descontoT();
      
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
	  String page = "ped_percentual_descontoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ped_percentual_descontoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
