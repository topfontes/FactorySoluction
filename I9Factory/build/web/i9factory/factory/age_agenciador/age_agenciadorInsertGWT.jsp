<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="age_agenciadorJB" class="br.com.easynet.gwt.i9factory.jb.Age_agenciadorInsertJB" scope="request"/>
<jsp:setProperty name="age_agenciadorJB" property="*"/>
<jsp:setProperty name="age_agenciadorJB" property="page" value="${pageContext}"/>
${age_agenciadorJB.execute}
{"resultado":"${age_agenciadorJB.msg}"}
