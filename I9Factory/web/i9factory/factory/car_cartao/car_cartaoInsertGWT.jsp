<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="car_cartaoJB" class="br.com.easynet.gwt.i9factory.jb.Car_cartaoJB" scope="request"/>
<jsp:setProperty name="car_cartaoJB" property="*"/>
<jsp:setProperty name="car_cartaoJB" property="page" value="${pageContext}"/>
${car_cartaoJB.execute}
{"resultado":"${car_cartaoJB.msg}"}
