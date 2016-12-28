package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Res_restricaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Res_restricaoT res_restricaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Res_restricaoDAO res_restricaoDAO =  getRes_restricaoDAO();
      res_restricaoDAO.insert(res_restricaoT);	 
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
  public List<Res_restricaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
      return null;
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
  public boolean delete(Res_restricaoT res_restricaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(res_restricaoT)) {
        Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
        res_restricaoDAO.delete(res_restricaoT);	 
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
  public boolean exist(Res_restricaoT res_restricaoT) throws Exception {
   try {
	
      Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
      List<Res_restricaoT> listTemp  = res_restricaoDAO.getByPK(res_restricaoT);	 

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
  public boolean update(Res_restricaoT res_restricaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(res_restricaoT)) {
        Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
        res_restricaoDAO.update(res_restricaoT);	 
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
  public Res_restricaoT findbyid(Res_restricaoT res_restricaoT) throws Exception {
    try {
      Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
      List<Res_restricaoT> listTemp  = res_restricaoDAO.getByPK( res_restricaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Res_restricaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
