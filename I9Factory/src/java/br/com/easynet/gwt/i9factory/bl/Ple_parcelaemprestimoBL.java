package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ple_parcelaemprestimoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO =  getPle_parcelaemprestimoDAO();
      ple_parcelaemprestimoDAO.insert(ple_parcelaemprestimoT);	 
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
  public List<Ple_parcelaemprestimoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
      return null;
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
  public boolean delete(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ple_parcelaemprestimoT)) {
        Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
        ple_parcelaemprestimoDAO.delete(ple_parcelaemprestimoT);	 
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
  public boolean exist(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
   try {
	
      Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
      List<Ple_parcelaemprestimoT> listTemp  = ple_parcelaemprestimoDAO.getByPK(ple_parcelaemprestimoT);	 

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
  public boolean update(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ple_parcelaemprestimoT)) {
        Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
        ple_parcelaemprestimoDAO.update(ple_parcelaemprestimoT);	 
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
  public Ple_parcelaemprestimoT findbyid(Ple_parcelaemprestimoT ple_parcelaemprestimoT) throws Exception {
    try {
      Ple_parcelaemprestimoDAO ple_parcelaemprestimoDAO = getPle_parcelaemprestimoDAO();
      List<Ple_parcelaemprestimoT> listTemp  = ple_parcelaemprestimoDAO.getByPK( ple_parcelaemprestimoT);	 

      return listTemp.size()>0?listTemp.get(0):new Ple_parcelaemprestimoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
