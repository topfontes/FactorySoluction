<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="emp_emprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Emp_emprestimoInsertJB" scope="request"/>
<jsp:setProperty name="emp_emprestimoJB" property="*"/>
<jsp:setProperty name="emp_emprestimoJB" property="page" value="${pageContext}"/>
${emp_emprestimoJB.execute}
{"resultado":"${emp_emprestimoJB.msg}"}
