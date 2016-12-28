package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cor_corretoraInsertJB extends SystemBase {

  // Atributos e propriedades
    private Cor_corretoraT cor_corretoraT = new Cor_corretoraT();

  public void setCor_corretoraT(Cor_corretoraT cor_corretoraT) {
    this.cor_corretoraT = cor_corretoraT;
  }

  public Cor_corretoraT getCor_corretoraT() {	
    return cor_corretoraT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Cor_corretoraDAO cor_corretoraDAO =  getCor_corretoraDAO();
      cor_corretoraDAO.insert(cor_corretoraT);	 
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
    
      cor_corretoraT = new Cor_corretoraT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cor_corretoraConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
