package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqp_equipeUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Eqp_equipeT eqp_equipeT = new Eqp_equipeT();

  public void setEqp_equipeT(Eqp_equipeT eqp_equipeT) {
    this.eqp_equipeT = eqp_equipeT;
  }

  public Eqp_equipeT getEqp_equipeT() {	
    return eqp_equipeT;
  }

	
  private List<Eqp_equipeT> list;

  public List<Eqp_equipeT> getList() {
    return list;
  }
  
  public void setList(List<Eqp_equipeT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCor_corretora();

  }

  public void clear() throws Exception {
    
      eqp_equipeT = new Eqp_equipeT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
        eqp_equipeDAO.delete(eqp_equipeT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
      List<Eqp_equipeT> listTemp  = eqp_equipeDAO.getByPK( eqp_equipeT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
        eqp_equipeDAO.update(eqp_equipeT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 
	private List<Cor_corretoraT> listcor_corretora;
	public List<Cor_corretoraT> getListcor_corretora() {
		return listcor_corretora;
	}

	 public void setListcor_corretora(List<Cor_corretoraT> list) {
		this.listcor_corretora=list;
	}
	public void consultCor_corretora() throws Exception {
		try {
			Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
			listcor_corretora=cor_corretoraDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
      List<Eqp_equipeT> listTemp  = eqp_equipeDAO.getByPK( eqp_equipeT);	 

      eqp_equipeT= listTemp.size()>0?listTemp.get(0):new Eqp_equipeT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a pagina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "eqp_equipeConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eqp_equipeConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
