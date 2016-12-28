<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="orcl_orgao_clienteJB" class="br.com.easynet.gwt.i9factory.jb.Orcl_orgao_clienteInsertJB" scope="request"/>
<jsp:setProperty name="orcl_orgao_clienteJB" property="*"/>
<jsp:setProperty name="orcl_orgao_clienteJB" property="page" value="${pageContext}"/>
${orcl_orgao_clienteJB.execute}
{"resultado":"${orcl_orgao_clienteJB.msg}"}
