<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ref_referenciaJB" class="br.com.easynet.gwt.i9factory.jb.Ref_referenciaInsertJB" scope="request"/>
<jsp:setProperty name="ref_referenciaJB" property="*"/>
<jsp:setProperty name="ref_referenciaJB" property="page" value="${pageContext}"/>
${ref_referenciaJB.execute}
{"resultado":"${ref_referenciaJB.msg}"}
