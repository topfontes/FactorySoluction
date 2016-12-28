package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Idc_indiceBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Idc_indiceT idc_indiceT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Idc_indiceDAO idc_indiceDAO =  getIdc_indiceDAO();
      idc_indiceDAO.insert(idc_indiceT);	 
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
  public List<Idc_indiceT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
      return idc_indiceDAO.getAll();	 
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
  public boolean delete(Idc_indiceT idc_indiceT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(idc_indiceT)) {
        Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
        idc_indiceDAO.delete(idc_indiceT);	 
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
  public boolean exist(Idc_indiceT idc_indiceT) throws Exception {
   try {
	
      Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
      List<Idc_indiceT> listTemp  = idc_indiceDAO.getByPK(idc_indiceT);	 

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
  public boolean update(Idc_indiceT idc_indiceT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(idc_indiceT)) {
        Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
        idc_indiceDAO.update(idc_indiceT);	 
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
  public Idc_indiceT findbyid(Idc_indiceT idc_indiceT) throws Exception {
    try {
      Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
      List<Idc_indiceT> listTemp  = idc_indiceDAO.getByPK( idc_indiceT);	 

      return listTemp.size()>0?listTemp.get(0):new Idc_indiceT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
