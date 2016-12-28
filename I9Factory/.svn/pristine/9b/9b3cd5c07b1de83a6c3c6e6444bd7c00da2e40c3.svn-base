package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Par_parametroConsultJB extends SystemBase {

  // Atributos e propriedades
    private Par_parametroT par_parametroT = new Par_parametroT();

  public void setPar_parametroT(Par_parametroT par_parametroT) {
    this.par_parametroT = par_parametroT;
  }

  public Par_parametroT getPar_parametroT() {	
    return par_parametroT;
  }


	
  private List<Par_parametroT> list;

  public List<Par_parametroT> getList() {
    return list;
  }
  
  public void setList(List<Par_parametroT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Par_parametroDAO par_parametroDAO = getPar_parametroDAOLocal();
      list = par_parametroDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Par_parametroDAO par_parametroDAO = getPar_parametroDAOLocal();
      par_parametroDAO.delete(par_parametroT);	 
      setMsg("Exclusao efetuada com sucesso!");
      par_parametroT = new Par_parametroT();
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
	  String page = "par_parametroInsert.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
