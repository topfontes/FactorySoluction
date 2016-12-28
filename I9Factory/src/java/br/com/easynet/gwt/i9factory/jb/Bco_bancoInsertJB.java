package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Bco_bancoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Bco_bancoT bco_bancoT = new Bco_bancoT();

  public void setBco_bancoT(Bco_bancoT bco_bancoT) {
    this.bco_bancoT = bco_bancoT;
  }

  public Bco_bancoT getBco_bancoT() {	
    return bco_bancoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Bco_bancoDAO bco_bancoDAO =  getBco_bancoDAO();
      bco_bancoDAO.insert(bco_bancoT);	 
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
    
      bco_bancoT = new Bco_bancoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "bco_bancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
