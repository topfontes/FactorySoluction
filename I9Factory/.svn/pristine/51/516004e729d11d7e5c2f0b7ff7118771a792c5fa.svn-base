package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Teb_transmissao_empresa_bancoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT = new Teb_transmissao_empresa_bancoT();

  public void setTeb_transmissao_empresa_bancoT(Teb_transmissao_empresa_bancoT teb_transmissao_empresa_bancoT) {
    this.teb_transmissao_empresa_bancoT = teb_transmissao_empresa_bancoT;
  }

  public Teb_transmissao_empresa_bancoT getTeb_transmissao_empresa_bancoT() {	
    return teb_transmissao_empresa_bancoT;
  }

	
  private List<Teb_transmissao_empresa_bancoT> list;

  public List<Teb_transmissao_empresa_bancoT> getList() {
    return list;
  }
  
  public void setList(List<Teb_transmissao_empresa_bancoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      teb_transmissao_empresa_bancoT = new Teb_transmissao_empresa_bancoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
        teb_transmissao_empresa_bancoDAO.delete(teb_transmissao_empresa_bancoT);	 
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
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
      Teb_transmissao_empresa_bancoT tebT  = teb_transmissao_empresa_bancoDAO.getByPK( teb_transmissao_empresa_bancoT);

      return tebT != null;
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
        Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
        teb_transmissao_empresa_bancoDAO.update(teb_transmissao_empresa_bancoT);	 
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
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
      Teb_transmissao_empresa_bancoT tebT  = teb_transmissao_empresa_bancoDAO.getByPK( teb_transmissao_empresa_bancoT);

      teb_transmissao_empresa_bancoT= tebT == null?tebT:new Teb_transmissao_empresa_bancoT();
      
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
	  String page = "teb_transmissao_empresa_bancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "teb_transmissao_empresa_bancoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
