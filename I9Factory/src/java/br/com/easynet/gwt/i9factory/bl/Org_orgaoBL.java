package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Org_orgaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Org_orgaoT org_orgaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Org_orgaoDAO org_orgaoDAO =  getOrg_orgaoDAO();
      org_orgaoDAO.insert(org_orgaoT);	 
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
  public List<Org_orgaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
      return org_orgaoDAO.getAll();	 
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
  public boolean delete(Org_orgaoT org_orgaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(org_orgaoT)) {
        Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
        org_orgaoDAO.delete(org_orgaoT);	 
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
  public boolean exist(Org_orgaoT org_orgaoT) throws Exception {
   try {
	
      Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
      List<Org_orgaoT> listTemp  = org_orgaoDAO.getByPK(org_orgaoT);	 

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
  public boolean update(Org_orgaoT org_orgaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(org_orgaoT)) {
        Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
        org_orgaoDAO.update(org_orgaoT);	 
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
  public Org_orgaoT findbyid(Org_orgaoT org_orgaoT) throws Exception {
    try {
      Org_orgaoDAO org_orgaoDAO = getOrg_orgaoDAO();
      List<Org_orgaoT> listTemp  = org_orgaoDAO.getByPK( org_orgaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Org_orgaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
