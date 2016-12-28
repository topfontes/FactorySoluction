<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="org_orgaoJB" class="br.com.easynet.gwt.i9factory.jb.Org_orgaoInsertJB" scope="request"/>
<jsp:setProperty name="org_orgaoJB" property="*"/>
<jsp:setProperty name="org_orgaoJB" property="page" value="${pageContext}"/>
${org_orgaoJB.execute}
{"resultado":"${org_orgaoJB.msg}"}
