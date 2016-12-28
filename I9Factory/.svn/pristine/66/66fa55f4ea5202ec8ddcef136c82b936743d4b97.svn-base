package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipo_despesaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Tid_tipo_despesaT tid_tipo_despesaT = new Tid_tipo_despesaT();

  public void setTid_tipo_despesaT(Tid_tipo_despesaT tid_tipo_despesaT) {
    this.tid_tipo_despesaT = tid_tipo_despesaT;
  }

  public Tid_tipo_despesaT getTid_tipo_despesaT() {	
    return tid_tipo_despesaT;
  }


	
  private List<Tid_tipo_despesaT> list;

  public List<Tid_tipo_despesaT> getList() {
    return list;
  }
  
  public void setList(List<Tid_tipo_despesaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
      list = tid_tipo_despesaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Tid_tipo_despesaDAO tid_tipo_despesaDAO = getTid_tipo_despesaDAO();
      tid_tipo_despesaDAO.delete(tid_tipo_despesaT);	 
      setMsg("Exclusao efetuada com sucesso!");
      tid_tipo_despesaT = new Tid_tipo_despesaT();
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
	  String page = "tid_tipo_despesaInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
