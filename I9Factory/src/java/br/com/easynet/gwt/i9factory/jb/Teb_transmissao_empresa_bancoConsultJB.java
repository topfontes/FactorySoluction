package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Teb_transmissao_empresa_bancoConsultJB extends SystemBase {

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
      list = teb_transmissao_empresa_bancoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Teb_transmissao_empresa_bancoDAO teb_transmissao_empresa_bancoDAO = getTeb_transmissao_empresa_bancoDAO();
      teb_transmissao_empresa_bancoDAO.delete(teb_transmissao_empresa_bancoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      teb_transmissao_empresa_bancoT = new Teb_transmissao_empresa_bancoT();
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
	  String page = "teb_transmissao_empresa_bancoInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
