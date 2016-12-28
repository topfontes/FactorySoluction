<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="res_restricaoJB" class="br.com.easynet.gwt.i9factory.jb.Res_restricaoInsertJB" scope="request"/>
<jsp:setProperty name="res_restricaoJB" property="*"/>
<jsp:setProperty name="res_restricaoJB" property="page" value="${pageContext}"/>
${res_restricaoJB.execute}
{"resultado":"${res_restricaoJB.msg}"}
