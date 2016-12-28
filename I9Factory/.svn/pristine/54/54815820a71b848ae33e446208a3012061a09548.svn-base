package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Arb_arquivobancoUpdateDeleteJB extends SystemBase {

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
	//
  }

  public void clear() throws Exception {
    
      arb_arquivobancoT = new Arb_arquivobancoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
        arb_arquivobancoDAO.delete(arb_arquivobancoT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      List<Arb_arquivobancoT> listTemp  = arb_arquivobancoDAO.getByPK( arb_arquivobancoT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
        arb_arquivobancoDAO.update(arb_arquivobancoT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


  //Method Download Image e montando se houver algum campo do tipo binario
  //
  /**
   * Download de Imagem caso existe sen?o pode remover
   */
  public void downloadImage() throws Exception {

        try {
            findbyid();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "arb_arquivobancoT.jpg");
            getRequest().setAttribute(EasyDownloadJB.DATA, arb_arquivobancoT.getArb_by_arquivo());
            getPage().forward("easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }
 


  public void findbyid() throws Exception {
    try {
      Arb_arquivobancoDAO arb_arquivobancoDAO = getArb_arquivobancoDAO();
      List<Arb_arquivobancoT> listTemp  = arb_arquivobancoDAO.getByPK( arb_arquivobancoT);	 

      arb_arquivobancoT= listTemp.size()>0?listTemp.get(0):new Arb_arquivobancoT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p?gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "arb_arquivobancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "arb_arquivobancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
