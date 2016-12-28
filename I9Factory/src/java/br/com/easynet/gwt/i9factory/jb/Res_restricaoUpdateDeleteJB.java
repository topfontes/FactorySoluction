package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Res_restricaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Res_restricaoT res_restricaoT = new Res_restricaoT();

  public void setRes_restricaoT(Res_restricaoT res_restricaoT) {
    this.res_restricaoT = res_restricaoT;
  }

  public Res_restricaoT getRes_restricaoT() {	
    return res_restricaoT;
  }

	
  private List<Res_restricaoT> list;

  public List<Res_restricaoT> getList() {
    return list;
  }
  
  public void setList(List<Res_restricaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCli_cliente();

  }

  public void clear() throws Exception {
    
      res_restricaoT = new Res_restricaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
        res_restricaoDAO.delete(res_restricaoT);	 
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
      Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
      List<Res_restricaoT> listTemp  = res_restricaoDAO.getByPK( res_restricaoT);	 

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
        Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
        res_restricaoDAO.update(res_restricaoT);	 
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
      Res_restricaoDAO res_restricaoDAO = getRes_restricaoDAO();
      List<Res_restricaoT> listTemp  = res_restricaoDAO.getByPK( res_restricaoT);	 

      res_restricaoT= listTemp.size()>0?listTemp.get(0):new Res_restricaoT();
      
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
	  String page = "res_restricaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "res_restricaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
