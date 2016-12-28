package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Idc_indiceUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Idc_indiceT idc_indiceT = new Idc_indiceT();

  public void setIdc_indiceT(Idc_indiceT idc_indiceT) {
    this.idc_indiceT = idc_indiceT;
  }

  public Idc_indiceT getIdc_indiceT() {	
    return idc_indiceT;
  }

	
  private List<Idc_indiceT> list;

  public List<Idc_indiceT> getList() {
    return list;
  }
  
  public void setList(List<Idc_indiceT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      idc_indiceT = new Idc_indiceT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
        idc_indiceDAO.delete(idc_indiceT);	 
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
      Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
      List<Idc_indiceT> listTemp  = idc_indiceDAO.getByPK( idc_indiceT);	 

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
        Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
        idc_indiceDAO.update(idc_indiceT);	 
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
      Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
      List<Idc_indiceT> listTemp  = idc_indiceDAO.getByPK( idc_indiceT);	 

      idc_indiceT= listTemp.size()>0?listTemp.get(0):new Idc_indiceT();
      
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
	  String page = "idc_indiceConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "idc_indiceConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
