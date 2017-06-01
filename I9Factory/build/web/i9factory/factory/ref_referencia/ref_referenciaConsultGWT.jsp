<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ref_referenciaJB" class="br.com.easynet.gwt.i9factory.jb.Ref_referenciaConsultJB" scope="request"/>                                         
<jsp:setProperty name="ref_referenciaJB" property="*"/>                                         
<jsp:setProperty name="ref_referenciaJB" property="page" value="${pageContext}"/>                                         
${ref_referenciaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ref_referenciaJB.list}" var="item">
     ,{	"ref_nr_id":"${item.ref_nr_id}"
 ,	"cli_nr_id":"${item.cli_nr_id}"
 ,	"ref_tx_nome":"${item.ref_tx_nome}"
 ,	"ref_tx_telefone":"${item.ref_tx_telefone}"
 ,	"ref_tx_celular":"${item.ref_tx_celular}"
  }
</c:forEach>
]}                                                                                
   
