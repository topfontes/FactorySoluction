package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_creditoInsertJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Tic_tipo_creditoT tic_tipo_creditoT = new Tic_tipo_creditoT();

  public void setTic_tipo_creditoT(Tic_tipo_creditoT tic_tipo_creditoT) {
    this.tic_tipo_creditoT = tic_tipo_creditoT;
  }

  public Tic_tipo_creditoT getTic_tipo_creditoT() {	
    return tic_tipo_creditoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Tic_tipo_creditoDAO tic_tipo_creditoDAO =  getTic_tipo_creditoDAO();
      tic_tipo_creditoDAO.insert(tic_tipo_creditoT);	 
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
    
      tic_tipo_creditoT = new Tic_tipo_creditoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tic_tipo_creditoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
