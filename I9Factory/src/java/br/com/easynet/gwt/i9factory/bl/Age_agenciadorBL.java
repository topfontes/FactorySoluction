package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.database.DataSet;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Age_agenciadorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Age_agenciadorT age_agenciadorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Age_agenciadorDAO age_agenciadorDAO =  getAge_agenciadorDAO();
      age_agenciadorDAO.insert(age_agenciadorT);	 
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
  public DataSet consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
      return age_agenciadorDAO.getAll();	 
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
  public boolean delete(Age_agenciadorT age_agenciadorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(age_agenciadorT)) {
        Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
        age_agenciadorDAO.delete(age_agenciadorT);	 
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
  public boolean exist(Age_agenciadorT age_agenciadorT) throws Exception {
   try {
	
      Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
      List<Age_agenciadorT> listTemp  = age_agenciadorDAO.getByPK(age_agenciadorT);	 

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
  public boolean update(Age_agenciadorT age_agenciadorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(age_agenciadorT)) {
        Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
        age_agenciadorDAO.update(age_agenciadorT);	 
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
  public Age_agenciadorT findbyid(Age_agenciadorT age_agenciadorT) throws Exception {
    try {
      Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
      List<Age_agenciadorT> listTemp  = age_agenciadorDAO.getByPK( age_agenciadorT);	 

      return listTemp.size()>0?listTemp.get(0):new Age_agenciadorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
