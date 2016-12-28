<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="lan_lancamentoJB" class="br.com.easynet.gwt.i9factory.jb.Lan_lancamentoInsertJB" scope="request"/>
<jsp:setProperty name="lan_lancamentoJB" property="*"/>
<jsp:setProperty name="lan_lancamentoJB" property="page" value="${pageContext}"/>
${lan_lancamentoJB.execute}
{"resultado":"${lan_lancamentoJB.msg}"}
