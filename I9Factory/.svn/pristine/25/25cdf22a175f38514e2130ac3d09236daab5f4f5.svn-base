package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cor_corretoraConsultJB extends SystemBase {

  // Atributos e propriedades
    private Cor_corretoraT cor_corretoraT = new Cor_corretoraT();

  public void setCor_corretoraT(Cor_corretoraT cor_corretoraT) {
    this.cor_corretoraT = cor_corretoraT;
  }

  public Cor_corretoraT getCor_corretoraT() {	
    return cor_corretoraT;
  }


	
  private List<Cor_corretoraT> list;

  public List<Cor_corretoraT> getList() {
    return list;
  }
  
  public void setList(List<Cor_corretoraT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
//      consult();
  }
    public void consultByNome() throws Exception {
        try {
            Cor_corretoraDAO cdao = getCor_corretoraDAO();
            list = cdao.getByCor_tx_nomefantasia(cor_corretoraT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

  public void consult() throws Exception {
    try {
      Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
      list = cor_corretoraDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Cor_corretoraDAO cor_corretoraDAO = getCor_corretoraDAO();
      cor_corretoraDAO.delete(cor_corretoraT);	 
      setMsg("Exclusao efetuada com sucesso!");
      cor_corretoraT = new Cor_corretoraT();
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
	  String page = "cor_corretoraInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
