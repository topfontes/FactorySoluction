<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="teb_transmissao_empresa_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Teb_transmissao_empresa_bancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="teb_transmissao_empresa_bancoJB" property="*"/>                                         
<jsp:setProperty name="teb_transmissao_empresa_bancoJB" property="page" value="${pageContext}"/>                                         
${teb_transmissao_empresa_bancoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${teb_transmissao_empresa_bancoJB.list}" var="item">
     ,{	"teb_nr_id":"${item.teb_nr_id}"
 ,	"teb_dt_envio":"<fmt:formatDate value="${item.teb_dt_envio}" pattern="dd/MM/yyyy"/>"
 ,	"teb_dt_retorno":"<fmt:formatDate value="${item.teb_dt_retorno}" pattern="dd/MM/yyyy"/>"
 ,	"teb_tx_status":"${item.teb_tx_status}"
 ,	"teb_tx_operacao":"${item.teb_tx_operacao}"
  }
</c:forEach>
]}                                                                                
   
