package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eqp_equipeInsertJB extends SystemBase {

  // Atributos e propriedades
    private Eqp_equipeT eqp_equipeT = new Eqp_equipeT();

  public void setEqp_equipeT(Eqp_equipeT eqp_equipeT) {
    this.eqp_equipeT = eqp_equipeT;
  }

  public Eqp_equipeT getEqp_equipeT() {	
    return eqp_equipeT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCor_corretora();

  }

  // Metodo de Eventos
  public void insert() throws Exception {
    
    try {
      Eqp_equipeDAO eqp_equipeDAO =  getEqp_equipeDAO();
      eqp_equipeDAO.insert(eqp_equipeT);	 
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
	private List<Cor_corretoraT> listcor_corretora;
	public List<Cor_corretoraT> getListcor_corretora() {
		return listcor_corretora;
	}

	 public void setListcor_corretora(List<Cor_corretoraT> list) {
		this.listcor_corretora=list;
	}
	public void consultCor_corretora() throws Exception {
		try {
			Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
			listcor_corretora=cor_corretoraDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      eqp_equipeT = new Eqp_equipeT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eqp_equipeConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
