package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Idc_indiceInsertJB extends SystemBase {

  // Atributos e propriedades
    private Idc_indiceT idc_indiceT = new Idc_indiceT();

  public void setIdc_indiceT(Idc_indiceT idc_indiceT) {
    this.idc_indiceT = idc_indiceT;
  }

  public Idc_indiceT getIdc_indiceT() {	
    return idc_indiceT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Idc_indiceDAO idc_indiceDAO =  getIdc_indiceDAO();
      idc_indiceDAO.insert(idc_indiceT);	 
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
    
      idc_indiceT = new Idc_indiceT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "idc_indiceConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
