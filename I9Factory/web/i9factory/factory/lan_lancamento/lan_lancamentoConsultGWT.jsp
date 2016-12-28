<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="lan_lancamentoJB" class="br.com.easynet.gwt.i9factory.jb.Lan_lancamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="*"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="page" value="${pageContext}"/>                                         
${lan_lancamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${lan_lancamentoJB.list}" var="item">
     ,{	"lan_nr_id":"${item.lan_nr_id}"
 ,	"ctr_nr_id":"${item.ctr_nr_id}"
 ,	"ctp_nr_id":"${item.ctp_nr_id}"
 ,	"lan_plc_nr_id_deb":"${item.lan_plc_nr_id_deb}"
 ,	"lan_plc_nr_id_cred":"${item.lan_plc_nr_id_cred}"
 ,	"lan_dt_lancamento":"<fmt:formatDate value="${item.lan_dt_lancamento}" pattern="dd/MM/yyyy"/>"
 ,	"lan_tx_historico":"${item.lan_tx_historico}"
 ,	"lan_valor":"${item.lan_valor}"
 ,	"lan_nr_id_super":"${item.lan_nr_id_super}"
  }
</c:forEach>
]}                                                                                
   
