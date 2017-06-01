<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ped_percentual_descontoJB" class="br.com.easynet.gwt.i9factory.jb.Ped_percentual_descontoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="*"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="page" value="${pageContext}"/>                                         
${ped_percentual_descontoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ped_percentual_descontoJB.list}" var="item">
     ,{	"ped_nr_id":"${item.ped_nr_id}"
 ,	"ped_nr_parcela":"${item.ped_nr_parcela}"
 ,	"ped_nr_desconto":"${item.ped_nr_desconto}"
  }
</c:forEach>
]}                                                                                
   
