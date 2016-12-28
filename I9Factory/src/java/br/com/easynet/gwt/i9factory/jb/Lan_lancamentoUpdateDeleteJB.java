package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Lan_lancamentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Lan_lancamentoT lan_lancamentoT = new Lan_lancamentoT();

  public void setLan_lancamentoT(Lan_lancamentoT lan_lancamentoT) {
    this.lan_lancamentoT = lan_lancamentoT;
  }

  public Lan_lancamentoT getLan_lancamentoT() {	
    return lan_lancamentoT;
  }

	
  private List<Lan_lancamentoT> list;

  public List<Lan_lancamentoT> getList() {
    return list;
  }
  
  public void setList(List<Lan_lancamentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultCtp_conta_pagar();

  }

  public void clear() throws Exception {
    
      lan_lancamentoT = new Lan_lancamentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
        lan_lancamentoDAO.delete(lan_lancamentoT);	 
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
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      List<Lan_lancamentoT> listTemp  = lan_lancamentoDAO.getByPK( lan_lancamentoT);	 

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
        Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
        lan_lancamentoDAO.update(lan_lancamentoT);	 
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
	private List<Ctp_conta_pagarT> listctp_conta_pagar;
	public List<Ctp_conta_pagarT> getListctp_conta_pagar() {
		return listctp_conta_pagar;
	}

	 public void setListctp_conta_pagar(List<Ctp_conta_pagarT> list) {
		this.listctp_conta_pagar=list;
	}
	public void consultCtp_conta_pagar() throws Exception {
		try {
			Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
//			listctp_conta_pagar=ctp_conta_pagarDAO.getAll();
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
      Lan_lancamentoDAO lan_lancamentoDAO = getLan_lancamentoDAO();
      List<Lan_lancamentoT> listTemp  = lan_lancamentoDAO.getByPK( lan_lancamentoT);	 

      lan_lancamentoT= listTemp.size()>0?listTemp.get(0):new Lan_lancamentoT();
      
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
	  String page = "lan_lancamentoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "lan_lancamentoConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
