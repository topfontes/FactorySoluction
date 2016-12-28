package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_arquivo_retorno_bancoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT = new Vw_arquivo_retorno_bancoT();

  public void setVw_arquivo_retorno_bancoT(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) {
    this.vw_arquivo_retorno_bancoT = vw_arquivo_retorno_bancoT;
  }

  public Vw_arquivo_retorno_bancoT getVw_arquivo_retorno_bancoT() {	
    return vw_arquivo_retorno_bancoT;
  }

	
  private List<Vw_arquivo_retorno_bancoT> list;

  public List<Vw_arquivo_retorno_bancoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_arquivo_retorno_bancoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      vw_arquivo_retorno_bancoT = new Vw_arquivo_retorno_bancoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO = getVw_arquivo_retorno_bancoDAO();
        vw_arquivo_retorno_bancoDAO.delete(vw_arquivo_retorno_bancoT);	 
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
      Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO = getVw_arquivo_retorno_bancoDAO();
      List<Vw_arquivo_retorno_bancoT> listTemp  = vw_arquivo_retorno_bancoDAO.getByPK( vw_arquivo_retorno_bancoT);	 

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
        Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO = getVw_arquivo_retorno_bancoDAO();
        vw_arquivo_retorno_bancoDAO.update(vw_arquivo_retorno_bancoT);	 
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
      Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO = getVw_arquivo_retorno_bancoDAO();
      List<Vw_arquivo_retorno_bancoT> listTemp  = vw_arquivo_retorno_bancoDAO.getByPK( vw_arquivo_retorno_bancoT);	 

      vw_arquivo_retorno_bancoT= listTemp.size()>0?listTemp.get(0):new Vw_arquivo_retorno_bancoT();
      
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
	  String page = "vw_arquivo_retorno_bancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_arquivo_retorno_bancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
