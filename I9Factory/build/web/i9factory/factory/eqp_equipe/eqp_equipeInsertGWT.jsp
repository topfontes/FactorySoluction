<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="eqp_equipeJB" class="br.com.easynet.gwt.i9factory.jb.Eqp_equipeInsertJB" scope="request"/>
<jsp:setProperty name="eqp_equipeJB" property="*"/>
<jsp:setProperty name="eqp_equipeJB" property="page" value="${pageContext}"/>
${eqp_equipeJB.execute}
{"resultado":"${eqp_equipeJB.msg}"}
