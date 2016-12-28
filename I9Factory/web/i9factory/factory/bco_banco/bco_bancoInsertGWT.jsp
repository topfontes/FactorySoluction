<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="bco_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Bco_bancoInsertJB" scope="request"/>
<jsp:setProperty name="bco_bancoJB" property="*"/>
<jsp:setProperty name="bco_bancoJB" property="page" value="${pageContext}"/>
${bco_bancoJB.execute}
{"resultado":"${bco_bancoJB.msg}"}
