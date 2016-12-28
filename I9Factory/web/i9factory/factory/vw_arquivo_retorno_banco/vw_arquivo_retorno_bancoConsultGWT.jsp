<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_arquivo_retorno_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Vw_arquivo_retorno_bancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="*"/>                                         
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="page" value="${pageContext}"/>                                         
${vw_arquivo_retorno_bancoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_arquivo_retorno_bancoJB.list}" var="item">
     ,{	"teb_nr_id":"${item.teb_nr_id}"
 ,	"teb_dt_envio":"<fmt:formatDate value="${item.teb_dt_envio}" pattern="dd/MM/yyyy"/>"
 ,	"teb_dt_retorno":"<fmt:formatDate value="${item.teb_dt_retorno}" pattern="dd/MM/yyyy"/>"
 ,	"teb_tx_status":"${item.teb_tx_status}"
 ,	"teb_tx_operacao":"${item.teb_tx_operacao}"
 ,	"ple_dt_vencimento":"<fmt:formatDate value="${item.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>"
 ,	"ple_tx_parcela":"${item.ple_tx_parcela}"
 ,	"ple_nr_valorparcela":"${item.ple_nr_valorparcela}"
 ,	"emp_nr_proposta":"${item.emp_nr_proposta}"
 ,	"cli_tx_nome":"${item.cli_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
