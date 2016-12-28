package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Age_agenciadorConsultJB extends SystemBase {

  // Atributos e propriedades
    private Age_agenciadorT age_agenciadorT = new Age_agenciadorT();
    private DataSet ds ;

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
      ds = age_agenciadorDAO.getAll();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Age_agenciadorDAO age_agenciadorDAO = getAge_agenciadorDAO();
      age_agenciadorDAO.delete(age_agenciadorT);	 
      setMsg("Exclusao efetuada com sucesso!");
      age_agenciadorT = new Age_agenciadorT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "age_agenciadorInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
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
