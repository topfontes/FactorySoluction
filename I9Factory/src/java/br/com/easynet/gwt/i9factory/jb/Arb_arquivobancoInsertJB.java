package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Arb_arquivobancoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Arb_arquivobancoT arb_arquivobancoT = new Arb_arquivobancoT();

  public void setArb_arquivobancoT(Arb_arquivobancoT arb_arquivobancoT) {
    this.arb_arquivobancoT = arb_arquivobancoT;
  }

  public Arb_arquivobancoT getArb_arquivobancoT() {	
    return arb_arquivobancoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Arb_arquivobancoDAO arb_arquivobancoDAO =  getArb_arquivobancoDAO();
      arb_arquivobancoDAO.insert(arb_arquivobancoT);	 
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
    
      arb_arquivobancoT = new Arb_arquivobancoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "arb_arquivobancoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
