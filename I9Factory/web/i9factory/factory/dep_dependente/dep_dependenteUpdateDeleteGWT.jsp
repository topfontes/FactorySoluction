<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="dep_dependenteJB" class="br.com.easynet.gwt.i9factory.jb.Dep_dependenteUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="*"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="page" value="${pageContext}"/>                                         
${dep_dependenteJB.execute}                                         
{"resultado":
{"msg":"${dep_dependenteJB.msg}",
     "dep_dependente":{	"dep_nr_id":"${dep_dependenteJB.dep_dependenteT.dep_nr_id}"
 ,	"cli_nr_id":"${dep_dependenteJB.dep_dependenteT.cli_nr_id}"
 ,	"dep_tx_nome":"${dep_dependenteJB.dep_dependenteT.dep_tx_nome}"
 ,	"dep_dt_nascimento":"<fmt:formatDate value="${dep_dependenteJB.dep_dependenteT.dep_dt_nascimento}" pattern="dd/MM/yyyy"/>"
 ,	"dep_tx_grauparentesco":"${dep_dependenteJB.dep_dependenteT.dep_tx_grauparentesco}"
  }
    }
     
}                                                                                
   
