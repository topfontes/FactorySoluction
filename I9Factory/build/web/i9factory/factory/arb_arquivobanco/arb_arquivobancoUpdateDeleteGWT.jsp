<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="arb_arquivobancoJB" class="br.com.easynet.gwt.i9factory.jb.Arb_arquivobancoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="*"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="page" value="${pageContext}"/>                                         
${arb_arquivobancoJB.execute}                                         
{"resultado":
{"msg":"${arb_arquivobancoJB.msg}",
     "arb_arquivobanco":{	"arb_nr_id":"${arb_arquivobancoJB.arb_arquivobancoT.arb_nr_id}"
 ,	"arb_dt_data":"<fmt:formatDate value="${arb_arquivobancoJB.arb_arquivobancoT.arb_dt_data}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"arb_tx_tipo":"${arb_arquivobancoJB.arb_arquivobancoT.arb_tx_tipo}"
 ,	"arb_nr_seq":"${arb_arquivobancoJB.arb_arquivobancoT.arb_nr_seq}"
  }
    }
     
}                                                                                
   
