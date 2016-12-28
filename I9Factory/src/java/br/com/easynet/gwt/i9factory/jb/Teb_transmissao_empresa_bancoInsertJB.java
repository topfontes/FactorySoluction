package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Teb_transmissao_empresa_bancoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT = new Teb_transmissao_empresa_bancoT();

  public void setTeb_transmissao_empresa_bancoT(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) {
    this.teb_transmissao_empresa_bancoT = teb_transmissao_empresa_bancoT;
  }

  public Teb_transmissao_empresa_bancoT getTeb_transmissao_empresa_bancoT() {	
    return teb_transmissao_empresa_bancoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO =  getTeb_transmissao_empresa_bancoDAO();
      teb_transmissao_empresa_bancoDAO.insert(teb_transmissao_empresa_bancoT);	 
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
    
      teb_transmissao_empresa_bancoT = new Teb_transmissao_empresa_bancoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "teb_transmissao_empresa_bancoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
