package br.com.easynet.gwt.i9factory.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tmp_tipomensalidadeBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO =  getTmp_tipomensalidadeDAO();
      tmp_tipomensalidadeDAO.insert(tmp_tipomensalidadeT);	 
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
  public List<Tmp_tipomensalidadeT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
      return tmp_tipomensalidadeDAO.getAll();	 
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
  public boolean delete(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tmp_tipomensalidadeT)) {
        Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
        tmp_tipomensalidadeDAO.delete(tmp_tipomensalidadeT);	 
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
  public boolean exist(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
   try {
	
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
      List<Tmp_tipomensalidadeT> listTemp  = tmp_tipomensalidadeDAO.getByPK(tmp_tipomensalidadeT);	 

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
  public boolean update(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tmp_tipomensalidadeT)) {
        Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
        tmp_tipomensalidadeDAO.update(tmp_tipomensalidadeT);	 
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
  public Tmp_tipomensalidadeT findbyid(Tmp_tipomensalidadeT tmp_tipomensalidadeT) throws Exception {
    try {
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
      List<Tmp_tipomensalidadeT> listTemp  = tmp_tipomensalidadeDAO.getByPK( tmp_tipomensalidadeT);	 

      return listTemp.size()>0?listTemp.get(0):new Tmp_tipomensalidadeT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
