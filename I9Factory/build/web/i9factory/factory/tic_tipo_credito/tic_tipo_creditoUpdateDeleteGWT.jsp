<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tic_tipo_creditoJB" class="br.com.easynet.gwt.i9factory.jb.Tic_tipo_creditoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tic_tipo_creditoJB" property="*"/>                                         
<jsp:setProperty name="tic_tipo_creditoJB" property="page" value="${pageContext}"/>                                         
${tic_tipo_creditoJB.execute}                                         
{"resultado":
{"msg":"${tic_tipo_creditoJB.msg}",
     "tic_tipo_credito":{	"tic_nr_id":"${tic_tipo_creditoJB.tic_tipo_creditoT.tic_nr_id}"
 ,	"tic_tx_nome":"${tic_tipo_creditoJB.tic_tipo_creditoT.tic_tx_nome}"
  }
    }
     
}                                                                                
   
