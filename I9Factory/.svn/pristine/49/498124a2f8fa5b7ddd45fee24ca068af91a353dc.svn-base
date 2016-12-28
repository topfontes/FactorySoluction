package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqp_equipeConsultJB extends SystemBase {

  // Atributos e propriedades
    private Eqp_equipeT eqp_equipeT = new Eqp_equipeT();
    private DataSet ds = new DataSet();

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
      ds = eqp_equipeDAO.getAll();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Eqp_equipeDAO eqp_equipeDAO = getEqp_equipeDAO();
      eqp_equipeDAO.delete(eqp_equipeT);	 
      setMsg("Exclusao efetuada com sucesso!");
      eqp_equipeT = new Eqp_equipeT();
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
	  String page = "eqp_equipeInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
