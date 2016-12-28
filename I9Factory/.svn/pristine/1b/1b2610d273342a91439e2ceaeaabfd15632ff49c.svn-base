package br.com.easynet.gwt.i9factory.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_creditoConsultJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
    private Tic_tipo_creditoT tic_tipo_creditoT = new Tic_tipo_creditoT();

  public void setTic_tipo_creditoT(Tic_tipo_creditoT tic_tipo_creditoT) {
    this.tic_tipo_creditoT = tic_tipo_creditoT;
  }

  public Tic_tipo_creditoT getTic_tipo_creditoT() {	
    return tic_tipo_creditoT;
  }


	
  private List<Tic_tipo_creditoT> list;

  public List<Tic_tipo_creditoT> getList() {
    return list;
  }
  
  public void setList(List<Tic_tipo_creditoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
      list = tic_tipo_creditoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Tic_tipo_creditoDAO tic_tipo_creditoDAO = getTic_tipo_creditoDAO();
      tic_tipo_creditoDAO.delete(tic_tipo_creditoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      tic_tipo_creditoT = new Tic_tipo_creditoT();
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
	  String page = "tic_tipo_creditoInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
