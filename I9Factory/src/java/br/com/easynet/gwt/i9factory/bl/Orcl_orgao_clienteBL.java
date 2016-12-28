package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Orcl_orgao_clienteBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
//      Orcl_orgao_clienteDAO orcl_orgao_clienteDAO =  getOrcl_orgao_clienteDAO();
//      orcl_orgao_clienteDAO.insert(orcl_orgao_clienteT);
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
  public List<Orcl_orgao_clienteT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
      return null;//orcl_orgao_clienteDAO.getAll();
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
  public boolean delete(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(orcl_orgao_clienteT)) {
        Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
        orcl_orgao_clienteDAO.delete(orcl_orgao_clienteT);	 
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
  public boolean exist(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
   try {
	
      Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
      List<Orcl_orgao_clienteT> listTemp  = orcl_orgao_clienteDAO.getByPK(orcl_orgao_clienteT);	 

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
  public boolean update(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(orcl_orgao_clienteT)) {
        Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
        orcl_orgao_clienteDAO.update(orcl_orgao_clienteT);	 
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
  public Orcl_orgao_clienteT findbyid(Orcl_orgao_clienteT orcl_orgao_clienteT) throws Exception {
    try {
      Orcl_orgao_clienteDAO orcl_orgao_clienteDAO = getOrcl_orgao_clienteDAO();
      List<Orcl_orgao_clienteT> listTemp  = orcl_orgao_clienteDAO.getByPK( orcl_orgao_clienteT);	 

      return listTemp.size()>0?listTemp.get(0):new Orcl_orgao_clienteT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
