<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tic_tipo_creditoJB" class="br.com.easynet.gwt.i9factory.jb.Tic_tipo_creditoConsultJB" scope="request"/>                                         
<jsp:setProperty name="tic_tipo_creditoJB" property="*"/>                                         
<jsp:setProperty name="tic_tipo_creditoJB" property="page" value="${pageContext}"/>                                         
${tic_tipo_creditoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tic_tipo_creditoJB.list}" var="item">
     ,{	"tic_nr_id":"${item.tic_nr_id}"
 ,	"tic_tx_nome":"${item.tic_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
