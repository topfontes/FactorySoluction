package br.com.easynet.gwt.i9factory.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.i9factory.dao.*;
import br.com.easynet.gwt.i9factory.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tmp_tipomensalidadeConsultJB extends SystemBase {

  // Atributos e propriedades
    private Tmp_tipomensalidadeT tmp_tipomensalidadeT = new Tmp_tipomensalidadeT();
    private int qtde;

  public void setTmp_tipomensalidadeT(Tmp_tipomensalidadeT tmp_tipomensalidadeT) {
    this.tmp_tipomensalidadeT = tmp_tipomensalidadeT;
  }

  public Tmp_tipomensalidadeT getTmp_tipomensalidadeT() {	
    return tmp_tipomensalidadeT;
  }


	
  private List<Tmp_tipomensalidadeT> list;

  public List<Tmp_tipomensalidadeT> getList() {
    return list;
  }
  
  public void setList(List<Tmp_tipomensalidadeT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consult();
  }

  public void consult() throws Exception {
    try {
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
      list = tmp_tipomensalidadeDAO.getAll();
      qtde = list.size();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Tmp_tipomensalidadeDAO tmp_tipomensalidadeDAO = getTmp_tipomensalidadeDAO();
      tmp_tipomensalidadeDAO.delete(tmp_tipomensalidadeT);	 
      setMsg("Exclusao efetuada com sucesso!");
      tmp_tipomensalidadeT = new Tmp_tipomensalidadeT();
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
	  String page = "tmp_tipomensalidadeInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

}
