package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cor_corretoraBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cor_corretoraT cor_corretoraT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cor_corretoraDAO cor_corretoraDAO =  getCor_corretoraDAO();
      cor_corretoraDAO.insert(cor_corretoraT);	 
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
  public List<Cor_corretoraT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
      return cor_corretoraDAO.getAll();	 
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
  public boolean delete(Cor_corretoraT cor_corretoraT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cor_corretoraT)) {
        Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
        cor_corretoraDAO.delete(cor_corretoraT);	 
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
  public boolean exist(Cor_corretoraT cor_corretoraT) throws Exception {
   try {
	
      Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
      List<Cor_corretoraT> listTemp  = cor_corretoraDAO.getByPK(cor_corretoraT);	 

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
  public boolean update(Cor_corretoraT cor_corretoraT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cor_corretoraT)) {
        Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
        cor_corretoraDAO.update(cor_corretoraT);	 
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
  public Cor_corretoraT findbyid(Cor_corretoraT cor_corretoraT) throws Exception {
    try {
      Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
      List<Cor_corretoraT> listTemp  = cor_corretoraDAO.getByPK( cor_corretoraT);	 

      return listTemp.size()>0?listTemp.get(0):new Cor_corretoraT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
