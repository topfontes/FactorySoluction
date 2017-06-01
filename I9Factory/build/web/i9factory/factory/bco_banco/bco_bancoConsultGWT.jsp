<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="bco_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Bco_bancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="bco_bancoJB" property="*"/>                                         
<jsp:setProperty name="bco_bancoJB" property="page" value="${pageContext}"/>                                         
${bco_bancoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${bco_bancoJB.list}" var="item">
     ,{	"bco_nr_id":"${item.bco_nr_id}"
 ,	"bco_tx_nome":"${item.bco_tx_nome}"
 ,	"bco_tx_telefone1":"${item.bco_tx_telefone1}"
 ,	"bco_tx_telefone2":"${item.bco_tx_telefone2}"
 ,	"bco_tx_nomecontato":"${item.bco_tx_nomecontato}"
 ,	"bco_tx_codigo":"${item.bco_tx_codigo}"
  }
</c:forEach>
]}                                                                                
   
