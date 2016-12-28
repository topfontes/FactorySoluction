package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class For_fornecedorInsertJB extends SystemBase {

  // Atributos e propriedades
    private For_fornecedorT for_fornecedorT = new For_fornecedorT();

  public void setFor_fornecedorT(For_fornecedorT for_fornecedorT) {
    this.for_fornecedorT = for_fornecedorT;
  }

  public For_fornecedorT getFor_fornecedorT() {	
    return for_fornecedorT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      For_fornecedorDAO for_fornecedorDAO =  getFor_fornecedorDAO();
      for_fornecedorDAO.insert(for_fornecedorT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 

  
  public void clear() throws Exception {
    
      for_fornecedorT = new For_fornecedorT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "for_fornecedorConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
