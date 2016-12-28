package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Res_restricaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Res_restricaoT res_restricaoT = new Res_restricaoT();

  public void setRes_restricaoT(Res_restricaoT res_restricaoT) {
    this.res_restricaoT = res_restricaoT;
  }

  public Res_restricaoT getRes_restricaoT() {	
    return res_restricaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCli_cliente();

  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Res_restricaoDAO res_restricaoDAO =  getRes_restricaoDAO();
      res_restricaoDAO.insert(res_restricaoT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
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


  
  public void clear() throws Exception {
    
      res_restricaoT = new Res_restricaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "res_restricaoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
