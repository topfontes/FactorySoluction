package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lan_lancamentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Lan_lancamentoT lan_lancamentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Lan_lancamentoDAO lan_lancamentoDAO =  getLan_lancamentoDAO();
      lan_lancamentoDAO.insert(lan_lancamentoT);	 
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
  public List<Lan_lancamentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      return lan_lancamentoDAO.getAll();	 
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
  public boolean delete(Lan_lancamentoT lan_lancamentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(lan_lancamentoT)) {
        Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
        lan_lancamentoDAO.delete(lan_lancamentoT);	 
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
  public boolean exist(Lan_lancamentoT lan_lancamentoT) throws Exception {
   try {
	
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      List<Lan_lancamentoT> listTemp  = lan_lancamentoDAO.getByPK(lan_lancamentoT);	 

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
  public boolean update(Lan_lancamentoT lan_lancamentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(lan_lancamentoT)) {
        Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
        lan_lancamentoDAO.update(lan_lancamentoT);	 
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
  public Lan_lancamentoT findbyid(Lan_lancamentoT lan_lancamentoT) throws Exception {
    try {
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      List<Lan_lancamentoT> listTemp  = lan_lancamentoDAO.getByPK( lan_lancamentoT);	 

      return listTemp.size()>0?listTemp.get(0):new Lan_lancamentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
