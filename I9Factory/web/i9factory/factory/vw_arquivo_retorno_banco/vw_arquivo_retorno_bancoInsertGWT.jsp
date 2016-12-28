<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_arquivo_retorno_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Vw_arquivo_retorno_bancoInsertJB" scope="request"/>
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="*"/>
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="page" value="${pageContext}"/>
${vw_arquivo_retorno_bancoJB.execute}
{"resultado":"${vw_arquivo_retorno_bancoJB.msg}"}
