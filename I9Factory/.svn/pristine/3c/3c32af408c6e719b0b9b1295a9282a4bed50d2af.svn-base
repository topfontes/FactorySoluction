package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ref_referenciaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ref_referenciaT ref_referenciaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ref_referenciaDAO ref_referenciaDAO =  getRef_referenciaDAO();
      ref_referenciaDAO.insert(ref_referenciaT);	 
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
  public List<Ref_referenciaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
      return ref_referenciaDAO.getAll();	 
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
  public boolean delete(Ref_referenciaT ref_referenciaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ref_referenciaT)) {
        Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
        ref_referenciaDAO.delete(ref_referenciaT);	 
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
  public boolean exist(Ref_referenciaT ref_referenciaT) throws Exception {
   try {
	
      Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
      List<Ref_referenciaT> listTemp  = ref_referenciaDAO.getByPK(ref_referenciaT);	 

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
  public boolean update(Ref_referenciaT ref_referenciaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ref_referenciaT)) {
        Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
        ref_referenciaDAO.update(ref_referenciaT);	 
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
  public Ref_referenciaT findbyid(Ref_referenciaT ref_referenciaT) throws Exception {
    try {
      Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
      List<Ref_referenciaT> listTemp  = ref_referenciaDAO.getByPK( ref_referenciaT);	 

      return listTemp.size()>0?listTemp.get(0):new Ref_referenciaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
