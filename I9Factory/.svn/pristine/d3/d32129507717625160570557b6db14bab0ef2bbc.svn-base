package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_parcelasInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_parcelasT vw_parcelasT = new Vw_parcelasT();

  public void setVw_parcelasT(Vw_parcelasT vw_parcelasT) {
    this.vw_parcelasT = vw_parcelasT;
  }

  public Vw_parcelasT getVw_parcelasT() {	
    return vw_parcelasT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_parcelasDAO vw_parcelasDAO =  getVw_parcelasDAO();
      vw_parcelasDAO.insert(vw_parcelasT);	 
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
    
      vw_parcelasT = new Vw_parcelasT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_parcelasConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
