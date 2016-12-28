package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Age_agenciadorUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Age_agenciadorT age_agenciadorT = new Age_agenciadorT();
    private DataSet ds = new DataSet();

  public void setAge_agenciadorT(Age_agenciadorT age_agenciadorT) {
    this.age_agenciadorT = age_agenciadorT;
  }

  public Age_agenciadorT getAge_agenciadorT() {	
    return age_agenciadorT;
  }

	
  private List<Age_agenciadorT> list;

  public List<Age_agenciadorT> getList() {
    return list;
  }
  
  public void setList(List<Age_agenciadorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultEqp_equipe();

  }

  public void clear() throws Exception {
    
      age_agenciadorT = new Age_agenciadorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
        age_agenciadorDAO.delete(age_agenciadorT);	 
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
      Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
      List<Age_agenciadorT> listTemp  = age_agenciadorDAO.getByPK( age_agenciadorT);	 

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
        Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
        age_agenciadorDAO.update(age_agenciadorT);	 
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
	private List<Eqp_equipeT> listeqp_equipe;
	public List<Eqp_equipeT> getListeqp_equipe() {
		return listeqp_equipe;
	}

	 public void setListeqp_equipe(List<Eqp_equipeT> list) {
		this.listeqp_equipe=list;
	}
	public void consultEqp_equipe() throws Exception {
		try {
			Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
			ds = eqp_equipeDAO.getAll();
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
      Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
      List<Age_agenciadorT> listTemp  = age_agenciadorDAO.getByPK( age_agenciadorT);	 

      age_agenciadorT= listTemp.size()>0?listTemp.get(0):new Age_agenciadorT();
      
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
	  String page = "age_agenciadorConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "age_agenciadorConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the ds
     */
    public DataSet getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSet ds) {
        this.ds = ds;
    }

}
