package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ped_percentual_descontoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ped_percentual_descontoT ped_percentual_descontoT = new Ped_percentual_descontoT();

  public void setPed_percentual_descontoT(Ped_percentual_descontoT ped_percentual_descontoT) {
    this.ped_percentual_descontoT = ped_percentual_descontoT;
  }

  public Ped_percentual_descontoT getPed_percentual_descontoT() {	
    return ped_percentual_descontoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Ped_percentual_descontoDAO ped_percentual_descontoDAO = getPed_percentual_descontoDAO();
      ped_percentual_descontoDAO.insert(ped_percentual_descontoT);	 
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
    
      ped_percentual_descontoT = new Ped_percentual_descontoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ped_percentual_descontoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
