package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ref_referenciaUpdateDeleteJB extends SystemBase {

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
	//
		consultCli_cliente();

  }

  public void clear() throws Exception {
    
      ref_referenciaT = new Ref_referenciaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
        ref_referenciaDAO.delete(ref_referenciaT);	 
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
      Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
      List<Ref_referenciaT> listTemp  = ref_referenciaDAO.getByPK( ref_referenciaT);	 

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
        Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
        ref_referenciaDAO.update(ref_referenciaT);	 
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
	private List<Cli_clienteT> listcli_cliente;
	public List<Cli_clienteT> getListcli_cliente() {
		return listcli_cliente;
	}

	 public void setListcli_cliente(List<Cli_clienteT> list) {
		this.listcli_cliente=list;
	}
	public void consultCli_cliente() throws Exception {
		try {
			Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
			listcli_cliente=cli_clienteDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Ref_referenciaDAO ref_referenciaDAO = getRef_referenciaDAO();
      List<Ref_referenciaT> listTemp  = ref_referenciaDAO.getByPK( ref_referenciaT);	 

      ref_referenciaT= listTemp.size()>0?listTemp.get(0):new Ref_referenciaT();
      
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
	  String page = "ref_referenciaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ref_referenciaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
