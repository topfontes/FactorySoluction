package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Dep_dependenteBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Dep_dependenteT dep_dependenteT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Dep_dependenteDAO dep_dependenteDAO =  getDep_dependenteDAO();
      dep_dependenteDAO.insert(dep_dependenteT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Dep_dependenteT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
      return dep_dependenteDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  /**
   * Deletar um registro
   */	
  public boolean delete(Dep_dependenteT dep_dependenteT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(dep_dependenteT)) {
        Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
        dep_dependenteDAO.delete(dep_dependenteT);	 
        return true;
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Verifica se o objeto existe na base
   */
  public boolean exist(Dep_dependenteT dep_dependenteT) throws Exception {
   try {
	
      Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
      List<Dep_dependenteT> listTemp  = dep_dependenteDAO.getByPK(dep_dependenteT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alteracao na tabela
   */	
  public boolean update(Dep_dependenteT dep_dependenteT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(dep_dependenteT)) {
        Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
        dep_dependenteDAO.update(dep_dependenteT);	 
	return true;        
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }   

  /**
   * Obtem os dados de um registro
   */	
  public Dep_dependenteT findbyid(Dep_dependenteT dep_dependenteT) throws Exception {
    try {
      Dep_dependenteDAO dep_dependenteDAO = getDep_dependenteDAO();
      List<Dep_dependenteT> listTemp  = dep_dependenteDAO.getByPK( dep_dependenteT);	 

      return listTemp.size()>0?listTemp.get(0):new Dep_dependenteT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
