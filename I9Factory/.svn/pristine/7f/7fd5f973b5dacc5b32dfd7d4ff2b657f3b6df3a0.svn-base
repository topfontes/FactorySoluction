package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;
import br.com.easynet.database.DataSet;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqp_equipeBL  extends SystemBusinessBase {

 private DataSet ds = new DataSet();
  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Eqp_equipeT eqp_equipeT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eqp_equipeDAO eqp_equipeDAO =  getEqp_equipeDAO();
      eqp_equipeDAO.insert(eqp_equipeT);	 
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
      Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
      return eqp_equipeDAO.getAll();	 
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
  public boolean delete(Eqp_equipeT eqp_equipeT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eqp_equipeT)) {
        Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
        eqp_equipeDAO.delete(eqp_equipeT);	 
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
  public boolean exist(Eqp_equipeT eqp_equipeT) throws Exception {
   try {
	
      Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
      List<Eqp_equipeT> listTemp  = eqp_equipeDAO.getByPK(eqp_equipeT);	 

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
  public boolean update(Eqp_equipeT eqp_equipeT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eqp_equipeT)) {
        Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
        eqp_equipeDAO.update(eqp_equipeT);	 
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
  public Eqp_equipeT findbyid(Eqp_equipeT eqp_equipeT) throws Exception {
    try {
      Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
      List<Eqp_equipeT> listTemp  = eqp_equipeDAO.getByPK( eqp_equipeT);	 

      return listTemp.size()>0?listTemp.get(0):new Eqp_equipeT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
