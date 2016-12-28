<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="idc_indiceJB" class="br.com.easynet.gwt.i9factory.jb.Idc_indiceConsultJB" scope="request"/>                                         
<jsp:setProperty name="idc_indiceJB" property="*"/>                                         
<jsp:setProperty name="idc_indiceJB" property="page" value="${pageContext}"/>                                         
${idc_indiceJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${idc_indiceJB.list}" var="item">
     ,{	"idc_nr_id":"${item.idc_nr_id}"
 ,	"idc_nr_diainicial":"${item.idc_nr_diainicial}"
 ,	"idc_nr_diafinal":"${item.idc_nr_diafinal}"
 ,	"idc_nr_qtdparcelas":"${item.idc_nr_qtdparcelas}"
 ,	"idc_nr_valor":"${item.idc_nr_valor}"
  }
</c:forEach>
]}                                                                                
   
