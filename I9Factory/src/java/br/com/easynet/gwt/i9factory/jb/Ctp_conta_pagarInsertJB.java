package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ctp_conta_pagarInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();

  public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
    this.ctp_conta_pagarT = ctp_conta_pagarT;
  }

  public Ctp_conta_pagarT getCtp_conta_pagarT() {	
    return ctp_conta_pagarT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		//consultFor_fornecedor();

  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Ctp_conta_pagarDAO ctp_conta_pagarDAO =  getCtp_conta_pagarDAO();
      ctp_conta_pagarDAO.insert(ctp_conta_pagarT);	 
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
	private List<For_fornecedorT> listfor_fornecedor;
	public List<For_fornecedorT> getListfor_fornecedor() {
		return listfor_fornecedor;
	}

	 public void setListfor_fornecedor(List<For_fornecedorT> list) {
		this.listfor_fornecedor=list;
	}
	public void consultFor_fornecedor() throws Exception {
		try {
			For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
			listfor_fornecedor=for_fornecedorDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      ctp_conta_pagarT = new Ctp_conta_pagarT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ctp_conta_pagarConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
