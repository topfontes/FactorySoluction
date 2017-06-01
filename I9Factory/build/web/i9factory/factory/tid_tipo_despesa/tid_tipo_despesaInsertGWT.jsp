<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tid_tipo_despesaJB" class="br.com.easynet.gwt.i9factory.jb.Tid_tipo_despesaInsertJB" scope="request"/>
<jsp:setProperty name="tid_tipo_despesaJB" property="*"/>
<jsp:setProperty name="tid_tipo_despesaJB" property="page" value="${pageContext}"/>
${tid_tipo_despesaJB.execute}
{"resultado":"${tid_tipo_despesaJB.msg}"}
