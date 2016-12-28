package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cor_corretoraUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Cor_corretoraT cor_corretoraT = new Cor_corretoraT();

  public void setCor_corretoraT(Cor_corretoraT cor_corretoraT) {
    this.cor_corretoraT = cor_corretoraT;
  }

  public Cor_corretoraT getCor_corretoraT() {	
    return cor_corretoraT;
  }

	
  private List<Cor_corretoraT> list;

  public List<Cor_corretoraT> getList() {
    return list;
  }
  
  public void setList(List<Cor_corretoraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      cor_corretoraT = new Cor_corretoraT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
        cor_corretoraDAO.delete(cor_corretoraT);	 
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
      Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
      List<Cor_corretoraT> listTemp  = cor_corretoraDAO.getByPK( cor_corretoraT);	 

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
        Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
        cor_corretoraDAO.update(cor_corretoraT);	 
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
      Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
      List<Cor_corretoraT> listTemp  = cor_corretoraDAO.getByPK( cor_corretoraT);	 

      cor_corretoraT= listTemp.size()>0?listTemp.get(0):new Cor_corretoraT();
      
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
	  String page = "cor_corretoraConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cor_corretoraConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
