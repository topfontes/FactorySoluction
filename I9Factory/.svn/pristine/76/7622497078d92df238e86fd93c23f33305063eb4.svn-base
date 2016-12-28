<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="dep_dependenteJB" class="br.com.easynet.gwt.i9factory.jb.Dep_dependenteConsultJB" scope="request"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="*"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="page" value="${pageContext}"/>                                         
${dep_dependenteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${dep_dependenteJB.list}" var="item">
     ,{	"dep_nr_id":"${item.dep_nr_id}"
 ,	"cli_nr_id":"${item.cli_nr_id}"
 ,	"dep_tx_nome":"${item.dep_tx_nome}"
 ,	"dep_dt_nascimento":"<fmt:formatDate value="${item.dep_dt_nascimento}" pattern="dd/MM/yyyy"/>"
 ,	"dep_tx_grauparentesco":"${item.dep_tx_grauparentesco}"
  }
</c:forEach>
]}                                                                                
   
