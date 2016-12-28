package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class For_fornecedorConsultJB extends SystemBase {

  // Atributos e propriedades
    private For_fornecedorT for_fornecedorT = new For_fornecedorT();

  public void setFor_fornecedorT(For_fornecedorT for_fornecedorT) {
    this.for_fornecedorT = for_fornecedorT;
  }

  public For_fornecedorT getFor_fornecedorT() {	
    return for_fornecedorT;
  }


	
  private List<For_fornecedorT> list;

  public List<For_fornecedorT> getList() {
    return list;
  }
  
  public void setList(List<For_fornecedorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
      list = for_fornecedorDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
      for_fornecedorDAO.delete(for_fornecedorT);	 
      setMsg("Exclusao efetuada com sucesso!");
      for_fornecedorT = new For_fornecedorT();
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
	  String page = "for_fornecedorInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
