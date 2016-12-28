package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tmp_tipomensalidadeInsertJB extends SystemBase {

  // Atributos e propriedades
    private Tmp_tipomensalidadeT tmp_tipomensalidadeT = new Tmp_tipomensalidadeT();

  public void setTmp_tipomensalidadeT(Tmp_tipomensalidadeT tmp_tipomensalidadeT) {
    this.tmp_tipomensalidadeT = tmp_tipomensalidadeT;
  }

  public Tmp_tipomensalidadeT getTmp_tipomensalidadeT() {	
    return tmp_tipomensalidadeT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO =  getTmp_tipomensalidadeDAO();
      tmp_tipomensalidadeDAO.insert(tmp_tipomensalidadeT);	 
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
    
      tmp_tipomensalidadeT = new Tmp_tipomensalidadeT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tmp_tipomensalidadeConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
