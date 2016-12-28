package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Par_parametroBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Par_parametroT par_parametroT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Par_parametroDAO par_parametroDAO =  getPar_parametroDAO();
      par_parametroDAO.insert(par_parametroT);	 
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
  public List<Par_parametroT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Par_parametroDAO par_parametroDAO = getPar_parametroDAO();
      return par_parametroDAO.getAll();	 
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
  public boolean delete(Par_parametroT par_parametroT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(par_parametroT)) {
        Par_parametroDAO par_parametroDAO = getPar_parametroDAO();
        par_parametroDAO.delete(par_parametroT);	 
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
  public boolean exist(Par_parametroT par_parametroT) throws Exception {
   try {
	
      Par_parametroDAO par_parametroDAO = getPar_parametroDAO();
      List<Par_parametroT> listTemp  = par_parametroDAO.getByPK(par_parametroT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alterac?o na tabela
   */	
  public boolean update(Par_parametroT par_parametroT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(par_parametroT)) {
        Par_parametroDAO par_parametroDAO = getPar_parametroDAO();
        par_parametroDAO.update(par_parametroT);	 
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
   * Obt?m os dados de um registro
   */	
  public Par_parametroT findbyid(Par_parametroT par_parametroT) throws Exception {
    try {
      Par_parametroDAO par_parametroDAO = getPar_parametroDAO();
      List<Par_parametroT> listTemp  = par_parametroDAO.getByPK( par_parametroT);	 

      return listTemp.size()>0?listTemp.get(0):new Par_parametroT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
