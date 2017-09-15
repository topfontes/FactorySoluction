<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="car_cartaoJB" class="br.com.easynet.gwt.i9factory.jb.Car_cartaoJB" scope="request"/>                                         
<jsp:setProperty name="car_cartaoJB" property="*"/>                                         
<jsp:setProperty name="car_cartaoJB" property="page" value="${pageContext}"/>                                         
${car_cartaoJB.execute}                                         
{"resultado":
{"msg":"${car_cartaoJB.msg}",
"car_cartao":{	"car_nr_id":"${car_cartaoJB.car_cartaoT.car_nr_id}"
,"car_tx_nome":"${car_cartaoJB.car_cartaoT.car_tx_nome}"
}
}
}