<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cco_contacorrenteJB" class="br.com.easynet.gwt.i9factory.jb.Cco_contacorrenteUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="*"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="page" value="${pageContext}"/>                                         
${cco_contacorrenteJB.execute}                                         
{"resultado":
{"msg":"${cco_contacorrenteJB.msg}",
     "cco_contacorrente":{"cco_nr_id":"${cco_contacorrenteJB.cco_contacorrenteT.cco_nr_id}"
 ,	"cco_tx_nragencia":"${cco_contacorrenteJB.cco_contacorrenteT.cco_tx_nragencia}"
 ,	"cco_tx_nrcontacorrente":"${cco_contacorrenteJB.cco_contacorrenteT.cco_tx_nrcontacorrente}"
 ,	"cco_tx_nomecorrentista":"${cco_contacorrenteJB.cco_contacorrenteT.cco_tx_nomecorrentista}"
 ,	"cco_bt_arqremessabanco":"IMAGEM"
 ,	"cco_bt_arqretornobanco":"IMAGEM"
 ,	"bco_nr_id":"${cco_contacorrenteJB.cco_contacorrenteT.bco_nr_id}"
 ,	"cli_nr_id":"${cco_contacorrenteJB.cco_contacorrenteT.cli_nr_id}"
 ,	"cor_nr_id":"${cco_contacorrenteJB.cco_contacorrenteT.cor_nr_id}"
 ,	"org_nr_id":"${cco_contacorrenteJB.cco_contacorrenteT.org_nr_id}"
  }
    }
     
}                                                                                
   
