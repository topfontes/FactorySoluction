<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tid_tipo_despesaJB" class="br.com.easynet.gwt.i9factory.jb.Tid_tipo_despesaConsultJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipo_despesaJB" property="*"/>                                         
<jsp:setProperty name="tid_tipo_despesaJB" property="page" value="${pageContext}"/>                                         
${tid_tipo_despesaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tid_tipo_despesaJB.list}" var="item">
     ,{	"tid_nr_id":"${item.tid_nr_id}"
 ,	"tid_tx_nome":"${item.tid_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
