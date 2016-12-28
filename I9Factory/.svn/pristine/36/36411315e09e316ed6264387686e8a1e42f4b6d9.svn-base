<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tmp_tipomensalidadeJB" class="br.com.easynet.gwt.i9factory.jb.Tmp_tipomensalidadeConsultJB" scope="request"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="*"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="page" value="${pageContext}"/>                                         
${tmp_tipomensalidadeJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
   <c:forEach items="${tmp_tipomensalidadeJB.list}" var="item" varStatus="cont">
     ,{	"tmp_nr_id":"${item.tmp_nr_id}"
 ,	"tmp_tx_nome":"${item.tmp_tx_nome}"
 ,	"tmp_tx_descricao":"${item.tmp_tx_descricao}"
 ,	"tmp_nr_valor":"${item.tmp_nr_valor}"
 }
</c:forEach>
]}                                                                                
   
