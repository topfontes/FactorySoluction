<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="car_cartaoJB" class="br.com.easynet.gwt.i9factory.jb.Car_cartaoJB" scope="request"/>                                         
<jsp:setProperty name="car_cartaoJB" property="*"/>                                         
<jsp:setProperty name="car_cartaoJB" property="page" value="${pageContext}"/>                                         
${car_cartaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${car_cartaoJB.list}" var="item">
     ,{	"car_nr_id":"${item.car_nr_id}"
 ,	"car_tx_nome":"${item.car_tx_nome}"
  }
</c:forEach>
]}  