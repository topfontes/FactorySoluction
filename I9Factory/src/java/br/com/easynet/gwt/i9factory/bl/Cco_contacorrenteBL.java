package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cco_contacorrenteBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cco_contacorrenteDAO cco_contacorrenteDAO =  getCco_contacorrenteDAO();
      cco_contacorrenteDAO.insert(cco_contacorrenteT);	 
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
  public List<Cco_contacorrenteT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
      return cco_contacorrenteDAO.getAll();	 
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
  public boolean delete(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cco_contacorrenteT)) {
        Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
        cco_contacorrenteDAO.delete(cco_contacorrenteT);	 
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
  public boolean exist(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
   try {
	
      Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
      List<Cco_contacorrenteT> listTemp  = cco_contacorrenteDAO.getByPK(cco_contacorrenteT);	 

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
  public boolean update(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cco_contacorrenteT)) {
        Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
        cco_contacorrenteDAO.update(cco_contacorrenteT);	 
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
  public Cco_contacorrenteT findbyid(Cco_contacorrenteT cco_contacorrenteT) throws Exception {
    try {
      Cco_contacorrenteDAO cco_contacorrenteDAO = getCco_contacorrenteDAO();
      List<Cco_contacorrenteT> listTemp  = cco_contacorrenteDAO.getByPK( cco_contacorrenteT);	 

      return listTemp.size()>0?listTemp.get(0):new Cco_contacorrenteT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
