package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_despesaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Tid_tipo_despesaT tid_tipo_despesaT = new Tid_tipo_despesaT();

  public void setTid_tipo_despesaT(Tid_tipo_despesaT tid_tipo_despesaT) {
    this.tid_tipo_despesaT = tid_tipo_despesaT;
  }

  public Tid_tipo_despesaT getTid_tipo_despesaT() {	
    return tid_tipo_despesaT;
  }

	
  private List<Tid_tipo_despesaT> list;

  public List<Tid_tipo_despesaT> getList() {
    return list;
  }
  
  public void setList(List<Tid_tipo_despesaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      tid_tipo_despesaT = new Tid_tipo_despesaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
        tid_tipo_despesaDAO.delete(tid_tipo_despesaT);	 
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
      Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
      List<Tid_tipo_despesaT> listTemp  = tid_tipo_despesaDAO.getByPK( tid_tipo_despesaT);	 

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
        Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
        tid_tipo_despesaDAO.update(tid_tipo_despesaT);	 
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
      Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
      List<Tid_tipo_despesaT> listTemp  = tid_tipo_despesaDAO.getByPK( tid_tipo_despesaT);	 

      tid_tipo_despesaT= listTemp.size()>0?listTemp.get(0):new Tid_tipo_despesaT();
      
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
	  String page = "tid_tipo_despesaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tid_tipo_despesaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
