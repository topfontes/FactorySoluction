<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cco_contacorrenteJB" class="br.com.easynet.gwt.i9factory.jb.Cco_contacorrenteConsultJB" scope="request"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="*"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="page" value="${pageContext}"/>                                         
${cco_contacorrenteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cco_contacorrenteJB.ds.list}" var="item">
     ,{	"cco_nr_id":"${item.row[0].value}"
 ,	"cco_tx_nragencia":"${item.row[1].value}"
 ,	"cco_tx_nrcontacorrente":"${item.row[2].value}"
 ,	"cco_tx_nomecorrentista":"${item.row[3].value}"
 ,	"bco_nr_id":"${item.row[4].value}"
 ,	"cli_nr_id":"${item.row[5].value}"
 ,	"org_nr_id":"${item.row[6].value}"
 ,	"cor_nr_id":"${item.row[7].value}"
 ,	"bco_tx_nome":"${item.row[8].value}"
  }
</c:forEach>
]}                                                                                
   
