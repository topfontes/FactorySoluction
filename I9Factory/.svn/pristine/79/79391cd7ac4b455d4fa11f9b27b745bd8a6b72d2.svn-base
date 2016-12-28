package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_arquivo_retorno_bancoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT = new Vw_arquivo_retorno_bancoT();

  public void setVw_arquivo_retorno_bancoT(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) {
    this.vw_arquivo_retorno_bancoT = vw_arquivo_retorno_bancoT;
  }

  public Vw_arquivo_retorno_bancoT getVw_arquivo_retorno_bancoT() {	
    return vw_arquivo_retorno_bancoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO =  getVw_arquivo_retorno_bancoDAO();
      vw_arquivo_retorno_bancoDAO.insert(vw_arquivo_retorno_bancoT);	 
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
    
      vw_arquivo_retorno_bancoT = new Vw_arquivo_retorno_bancoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "vw_arquivo_retorno_bancoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
