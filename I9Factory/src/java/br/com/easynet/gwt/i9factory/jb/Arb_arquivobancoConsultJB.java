package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Arb_arquivobancoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Arb_arquivobancoT arb_arquivobancoT = new Arb_arquivobancoT();

  public void setArb_arquivobancoT(Arb_arquivobancoT arb_arquivobancoT) {
    this.arb_arquivobancoT = arb_arquivobancoT;
  }

  public Arb_arquivobancoT getArb_arquivobancoT() {	
    return arb_arquivobancoT;
  }


	
  private List<Arb_arquivobancoT> list;

  public List<Arb_arquivobancoT> getList() {
    return list;
  }
  
  public void setList(List<Arb_arquivobancoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      list = arb_arquivobancoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }

  public void consultarRemessa() throws Exception {
    try {
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      arb_arquivobancoT.setArb_tx_tipo("REM");
      list = arb_arquivobancoDAO.getByArb_tx_tipo(arb_arquivobancoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");
    } finally {
	close();
    }
  }

  public void consultarRetorno() throws Exception {
    try {
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      arb_arquivobancoT.setArb_tx_tipo("RET");
      list = arb_arquivobancoDAO.getByArb_tx_tipo(arb_arquivobancoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");
    } finally {
	close();
    }
  }

  public void delete() throws Exception {
    try {
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      arb_arquivobancoDAO.delete(arb_arquivobancoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      arb_arquivobancoT = new Arb_arquivobancoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "arb_arquivobancoInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
