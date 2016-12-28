package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tmp_tipomensalidadeUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Tmp_tipomensalidadeT tmp_tipomensalidadeT = new Tmp_tipomensalidadeT();

  public void setTmp_tipomensalidadeT(Tmp_tipomensalidadeT tmp_tipomensalidadeT) {
    this.tmp_tipomensalidadeT = tmp_tipomensalidadeT;
  }

  public Tmp_tipomensalidadeT getTmp_tipomensalidadeT() {	
    return tmp_tipomensalidadeT;
  }

	
  private List<Tmp_tipomensalidadeT> list;

  public List<Tmp_tipomensalidadeT> getList() {
    return list;
  }
  
  public void setList(List<Tmp_tipomensalidadeT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      tmp_tipomensalidadeT = new Tmp_tipomensalidadeT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
        tmp_tipomensalidadeDAO.delete(tmp_tipomensalidadeT);	 
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
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
      List<Tmp_tipomensalidadeT> listTemp  = tmp_tipomensalidadeDAO.getByPK( tmp_tipomensalidadeT);	 

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
        Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
        tmp_tipomensalidadeDAO.update(tmp_tipomensalidadeT);	 
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


  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
      List<Tmp_tipomensalidadeT> listTemp  = tmp_tipomensalidadeDAO.getByPK( tmp_tipomensalidadeT);	 

      tmp_tipomensalidadeT= listTemp.size()>0?listTemp.get(0):new Tmp_tipomensalidadeT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a pagina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "tmp_tipomensalidadeConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tmp_tipomensalidadeConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
