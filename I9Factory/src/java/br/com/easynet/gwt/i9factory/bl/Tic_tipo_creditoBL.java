package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_creditoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tic_tipo_creditoDAO tic_tipo_creditoDAO =  getTic_tipo_creditoDAO();
      tic_tipo_creditoDAO.insert(tic_tipo_creditoT);	 
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
  public List<Tic_tipo_creditoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
      return tic_tipo_creditoDAO.getAll();	 
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
  public boolean delete(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tic_tipo_creditoT)) {
        Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
        tic_tipo_creditoDAO.delete(tic_tipo_creditoT);	 
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
  public boolean exist(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception {
   try {
	
      Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
      List<Tic_tipo_creditoT> listTemp  = tic_tipo_creditoDAO.getByPK(tic_tipo_creditoT);	 

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
  public boolean update(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tic_tipo_creditoT)) {
        Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
        tic_tipo_creditoDAO.update(tic_tipo_creditoT);	 
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
  public Tic_tipo_creditoT findbyid(Tic_tipo_creditoT tic_tipo_creditoT) throws Exception {
    try {
      Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
      List<Tic_tipo_creditoT> listTemp  = tic_tipo_creditoDAO.getByPK( tic_tipo_creditoT);	 

      return listTemp.size()>0?listTemp.get(0):new Tic_tipo_creditoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
