package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Teb_transmissao_empresa_bancoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO =  getTeb_transmissao_empresa_bancoDAO();
      teb_transmissao_empresa_bancoDAO.insert(teb_transmissao_empresa_bancoT);	 
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
  public List<Teb_transmissao_empresa_bancoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
      return teb_transmissao_empresa_bancoDAO.getAll();	 
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
  public boolean delete(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(teb_transmissao_empresa_bancoT)) {
        Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
        teb_transmissao_empresa_bancoDAO.delete(teb_transmissao_empresa_bancoT);	 
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
  public boolean exist(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
   try {
        return false;
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
  public boolean update(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(teb_transmissao_empresa_bancoT)) {
        Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
        teb_transmissao_empresa_bancoDAO.update(teb_transmissao_empresa_bancoT);	 
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
  public Teb_transmissao_empresa_bancoT findbyid(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) throws Exception {
    try {
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();

      return null;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
