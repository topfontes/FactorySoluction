package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Vw_arquivo_retorno_bancoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT = new Vw_arquivo_retorno_bancoT();

  public void setVw_arquivo_retorno_bancoT(Vw_arquivo_retorno_bancoT vw_arquivo_retorno_bancoT) {
    this.vw_arquivo_retorno_bancoT = vw_arquivo_retorno_bancoT;
  }

  public Vw_arquivo_retorno_bancoT getVw_arquivo_retorno_bancoT() {	
    return vw_arquivo_retorno_bancoT;
  }


	
  private List<Vw_arquivo_retorno_bancoT> list;

  public List<Vw_arquivo_retorno_bancoT> getList() {
    return list;
  }
  
  public void setList(List<Vw_arquivo_retorno_bancoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO = getVw_arquivo_retorno_bancoDAO();
      list = vw_arquivo_retorno_bancoDAO.getByTeb_dt_envio(vw_arquivo_retorno_bancoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }

  public void historico_par(){
    try {
      Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO = getVw_arquivo_retorno_bancoDAO();
      list = vw_arquivo_retorno_bancoDAO.getByTeb_nr_id(vw_arquivo_retorno_bancoT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");
    } finally {
	close();
    }

  }

  public void delete() throws Exception {
    try {
      Vw_arquivo_retorno_bancoDAO vw_arquivo_retorno_bancoDAO = getVw_arquivo_retorno_bancoDAO();
      vw_arquivo_retorno_bancoDAO.delete(vw_arquivo_retorno_bancoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      vw_arquivo_retorno_bancoT = new Vw_arquivo_retorno_bancoT();
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
	  String page = "vw_arquivo_retorno_bancoInsert.jsp";// defina aqui a pagina que deve ser chamada  
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
