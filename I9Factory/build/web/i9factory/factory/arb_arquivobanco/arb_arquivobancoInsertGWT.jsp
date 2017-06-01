<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="arb_arquivobancoJB" class="br.com.easynet.gwt.i9factory.jb.Arb_arquivobancoInsertJB" scope="request"/>
<jsp:setProperty name="arb_arquivobancoJB" property="*"/>
<jsp:setProperty name="arb_arquivobancoJB" property="page" value="${pageContext}"/>
${arb_arquivobancoJB.execute}
{"resultado":"${arb_arquivobancoJB.msg}"}
