<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="arb_arquivobancoJB" class="br.com.easynet.gwt.i9factory.jb.Arb_arquivobancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="*"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="page" value="${pageContext}"/>                                         
${arb_arquivobancoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${arb_arquivobancoJB.list}" var="item">
     ,{	"arb_nr_id":"${item.arb_nr_id}"
 ,	"arb_dt_data":"<fmt:formatDate value="${item.arb_dt_data}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"arb_tx_tipo":"${item.arb_tx_tipo}"
 ,	"arb_nr_seq":"${item.arb_nr_seq}"
  }
</c:forEach>
]}                                                                                
   
