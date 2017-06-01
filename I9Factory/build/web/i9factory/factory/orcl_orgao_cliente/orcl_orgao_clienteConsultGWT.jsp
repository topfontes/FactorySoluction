<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="orcl_orgao_clienteJB" class="br.com.easynet.gwt.i9factory.jb.Orcl_orgao_clienteConsultJB" scope="request"/>                                         
<jsp:setProperty name="orcl_orgao_clienteJB" property="*"/>                                         
<jsp:setProperty name="orcl_orgao_clienteJB" property="page" value="${pageContext}"/>                                         
${orcl_orgao_clienteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${orcl_orgao_clienteJB.ds.list}" var="item">
     ,{	"orcl_nr_id":"${item.row[0].value}"
 ,	"cli_nr_id":"${item.row[1].value}"
 ,	"org_nr_id":"${item.row[2].value}"
 ,	"orgao":"${item.row[3].value}"
  }
</c:forEach>
]}                                                                                
   
