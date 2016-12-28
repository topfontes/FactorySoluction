package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Bco_bancoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Bco_bancoT bco_bancoT = new Bco_bancoT();

  public void setBco_bancoT(Bco_bancoT bco_bancoT) {
    this.bco_bancoT = bco_bancoT;
  }

  public Bco_bancoT getBco_bancoT() {	
    return bco_bancoT;
  }

	
  private List<Bco_bancoT> list;

  public List<Bco_bancoT> getList() {
    return list;
  }
  
  public void setList(List<Bco_bancoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      bco_bancoT = new Bco_bancoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
        bco_bancoDAO.delete(bco_bancoT);	 
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
      Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
      List<Bco_bancoT> listTemp  = bco_bancoDAO.getByPK( bco_bancoT);	 

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
        Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
        bco_bancoDAO.update(bco_bancoT);	 
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
      Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
      List<Bco_bancoT> listTemp  = bco_bancoDAO.getByPK( bco_bancoT);	 

      bco_bancoT= listTemp.size()>0?listTemp.get(0):new Bco_bancoT();
      
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
	  String page = "bco_bancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "bco_bancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
