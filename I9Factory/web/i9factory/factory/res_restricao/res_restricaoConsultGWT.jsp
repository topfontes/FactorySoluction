<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="res_restricaoJB" class="br.com.easynet.gwt.i9factory.jb.Res_restricaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="res_restricaoJB" property="*"/>                                         
<jsp:setProperty name="res_restricaoJB" property="page" value="${pageContext}"/>                                         
${res_restricaoJB.execute}
{"resultado":[
   {"registro":"marcacao"}   
<c:forEach items="${res_restricaoJB.ds.list}" var="item">
     ,{	"res_nr_id":"${item.row[0].value}"
 ,	"res_tx_nome":"${item.row[1].value}"
 ,	"cli_nr_id":"${item.row[2].value}"
 ,	"cli_tx_nome":"${item.row[3].value}"
  }
</c:forEach>
]}