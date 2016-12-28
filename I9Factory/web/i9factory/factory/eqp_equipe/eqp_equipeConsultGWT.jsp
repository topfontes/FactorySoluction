<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eqp_equipeJB" class="br.com.easynet.gwt.i9factory.jb.Eqp_equipeConsultJB" scope="request"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="*"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="page" value="${pageContext}"/>                                         
${eqp_equipeJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
   <c:forEach items="${eqp_equipeJB.ds.list}" var="item">
     ,{	"eqp_nr_id":"${item.row[0].value}"
 ,	"eqp_tx_nome":"${item.row[1]}"
 ,	"eqp_tx_descricao":"${item.row[2].value}"
 ,	"cor_nr_id":"${item.row[3].value}"
  ,	"cor_tx_nome":"${item.row[4]}"
  }
</c:forEach>
]}                                                                                
   

