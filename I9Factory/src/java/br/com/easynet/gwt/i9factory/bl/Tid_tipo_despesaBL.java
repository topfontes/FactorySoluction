package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_despesaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tid_tipo_despesaDAO tid_tipo_despesaDAO =  getTid_tipo_despesaDAO();
      tid_tipo_despesaDAO.insert(tid_tipo_despesaT);	 
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
  public List<Tid_tipo_despesaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
      return tid_tipo_despesaDAO.getAll();	 
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
  public boolean delete(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tid_tipo_despesaT)) {
        Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
        tid_tipo_despesaDAO.delete(tid_tipo_despesaT);	 
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
  public boolean exist(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception {
   try {
	
      Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
      List<Tid_tipo_despesaT> listTemp  = tid_tipo_despesaDAO.getByPK(tid_tipo_despesaT);	 

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
  public boolean update(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tid_tipo_despesaT)) {
        Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
        tid_tipo_despesaDAO.update(tid_tipo_despesaT);	 
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
  public Tid_tipo_despesaT findbyid(Tid_tipo_despesaT tid_tipo_despesaT) throws Exception {
    try {
      Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
      List<Tid_tipo_despesaT> listTemp  = tid_tipo_despesaDAO.getByPK( tid_tipo_despesaT);	 

      return listTemp.size()>0?listTemp.get(0):new Tid_tipo_despesaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
