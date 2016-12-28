package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ref_referenciaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ref_referenciaT ref_referenciaT = new Ref_referenciaT();

  public void setRef_referenciaT(Ref_referenciaT ref_referenciaT) {
    this.ref_referenciaT = ref_referenciaT;
  }

  public Ref_referenciaT getRef_referenciaT() {	
    return ref_referenciaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCli_cliente();

  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Ref_referenciaDAO ref_referenciaDAO =  getRef_referenciaDAO();
      ref_referenciaDAO.insert(ref_referenciaT);	 
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
    
      ref_referenciaT = new Ref_referenciaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ref_referenciaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
