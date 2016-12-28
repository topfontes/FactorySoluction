package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_despesaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Tid_tipo_despesaT tid_tipo_despesaT = new Tid_tipo_despesaT();

  public void setTid_tipo_despesaT(Tid_tipo_despesaT tid_tipo_despesaT) {
    this.tid_tipo_despesaT = tid_tipo_despesaT;
  }

  public Tid_tipo_despesaT getTid_tipo_despesaT() {	
    return tid_tipo_despesaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Tid_tipo_despesaDAO tid_tipo_despesaDAO =  getTid_tipo_despesaDAO();
      tid_tipo_despesaDAO.insert(tid_tipo_despesaT);	 
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
    
      tid_tipo_despesaT = new Tid_tipo_despesaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tid_tipo_despesaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
