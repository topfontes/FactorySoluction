package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_emprestimoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Emp_emprestimoT emp_emprestimoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Emp_emprestimoDAO emp_emprestimoDAO =  getEmp_emprestimoDAO();
      emp_emprestimoDAO.insert(emp_emprestimoT);	 
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

  /**
   * Deletar um registro
   */	
  public boolean delete(Emp_emprestimoT emp_emprestimoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(emp_emprestimoT)) {
        Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
        emp_emprestimoDAO.delete(emp_emprestimoT);	 
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
  public boolean exist(Emp_emprestimoT emp_emprestimoT) throws Exception {
   try {
	
      Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
      List<Emp_emprestimoT> listTemp  = emp_emprestimoDAO.getByPK(emp_emprestimoT);	 

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
  public boolean update(Emp_emprestimoT emp_emprestimoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(emp_emprestimoT)) {
        Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
        emp_emprestimoDAO.update(emp_emprestimoT);	 
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
  public Emp_emprestimoT findbyid(Emp_emprestimoT emp_emprestimoT) throws Exception {
    try {
      Emp_emprestimoDAO emp_emprestimoDAO = getEmp_emprestimoDAO();
      List<Emp_emprestimoT> listTemp  = emp_emprestimoDAO.getByPK( emp_emprestimoT);	 

      return listTemp.size()>0?listTemp.get(0):new Emp_emprestimoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
