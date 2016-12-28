package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Idc_indiceConsultJB extends SystemBase {

  // Atributos e propriedades
    private Idc_indiceT idc_indiceT = new Idc_indiceT();

  public void setIdc_indiceT(Idc_indiceT idc_indiceT) {
    this.idc_indiceT = idc_indiceT;
  }

  public Idc_indiceT getIdc_indiceT() {	
    return idc_indiceT;
  }


	
  private List<Idc_indiceT> list;

  public List<Idc_indiceT> getList() {
    return list;
  }
  
  public void setList(List<Idc_indiceT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
      list = idc_indiceDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Idc_indiceDAO idc_indiceDAO = getIdc_indiceDAO();
      idc_indiceDAO.delete(idc_indiceT);	 
      setMsg("Exclusao efetuada com sucesso!");
      idc_indiceT = new Idc_indiceT();
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
	  String page = "idc_indiceInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
