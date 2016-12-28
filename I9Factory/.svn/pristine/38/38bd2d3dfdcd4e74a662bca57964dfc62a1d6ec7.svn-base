package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Bco_bancoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Bco_bancoT bco_bancoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Bco_bancoDAO bco_bancoDAO =  getBco_bancoDAO();
      bco_bancoDAO.insert(bco_bancoT);	 
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
  public List<Bco_bancoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
      return bco_bancoDAO.getAll();	 
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
  public boolean delete(Bco_bancoT bco_bancoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(bco_bancoT)) {
        Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
        bco_bancoDAO.delete(bco_bancoT);	 
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
  public boolean exist(Bco_bancoT bco_bancoT) throws Exception {
   try {
	
      Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
      List<Bco_bancoT> listTemp  = bco_bancoDAO.getByPK(bco_bancoT);	 

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
  public boolean update(Bco_bancoT bco_bancoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(bco_bancoT)) {
        Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
        bco_bancoDAO.update(bco_bancoT);	 
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
  public Bco_bancoT findbyid(Bco_bancoT bco_bancoT) throws Exception {
    try {
      Bco_bancoDAO bco_bancoDAO = getBco_bancoDAO();
      List<Bco_bancoT> listTemp  = bco_bancoDAO.getByPK( bco_bancoT);	 

      return listTemp.size()>0?listTemp.get(0):new Bco_bancoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
