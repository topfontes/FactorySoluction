package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ref_referenciaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Ref_referenciaT ref_referenciaT = new Ref_referenciaT();

  public void setRef_referenciaT(Ref_referenciaT ref_referenciaT) {
    this.ref_referenciaT = ref_referenciaT;
  }

  public Ref_referenciaT getRef_referenciaT() {	
    return ref_referenciaT;
  }


	
  private List<Ref_referenciaT> list;

  public List<Ref_referenciaT> getList() {
    return list;
  }
  
  public void setList(List<Ref_referenciaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
      list = ref_referenciaDAO.getByCli_nr_id(ref_referenciaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
      ref_referenciaDAO.delete(ref_referenciaT);	 
      setMsg("Exclusao efetuada com sucesso!");
      ref_referenciaT = new Ref_referenciaT();
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
	  String page = "ref_referenciaInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
