package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Arb_arquivobancoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Arb_arquivobancoDAO arb_arquivobancoDAO =  getArb_arquivobancoDAO();
      arb_arquivobancoDAO.insert(arb_arquivobancoT);	 
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
  public List<Arb_arquivobancoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      return arb_arquivobancoDAO.getAll();	 
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
  public boolean delete(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(arb_arquivobancoT)) {
        Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
        arb_arquivobancoDAO.delete(arb_arquivobancoT);	 
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
  public boolean exist(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
   try {
	
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      List<Arb_arquivobancoT> listTemp  = arb_arquivobancoDAO.getByPK(arb_arquivobancoT);	 

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
  public boolean update(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(arb_arquivobancoT)) {
        Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
        arb_arquivobancoDAO.update(arb_arquivobancoT);	 
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
  public Arb_arquivobancoT findbyid(Arb_arquivobancoT arb_arquivobancoT) throws Exception {
    try {
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      List<Arb_arquivobancoT> listTemp  = arb_arquivobancoDAO.getByPK( arb_arquivobancoT);	 

      return listTemp.size()>0?listTemp.get(0):new Arb_arquivobancoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
