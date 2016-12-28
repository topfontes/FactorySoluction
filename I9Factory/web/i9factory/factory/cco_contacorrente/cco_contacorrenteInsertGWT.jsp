<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cco_contacorrenteJB" class="br.com.easynet.gwt.i9factory.jb.Cco_contacorrenteInsertJB" scope="request"/>
<jsp:setProperty name="cco_contacorrenteJB" property="*"/>
<jsp:setProperty name="cco_contacorrenteJB" property="page" value="${pageContext}"/>
${cco_contacorrenteJB.execute}
{"resultado":"${cco_contacorrenteJB.msg}"}
