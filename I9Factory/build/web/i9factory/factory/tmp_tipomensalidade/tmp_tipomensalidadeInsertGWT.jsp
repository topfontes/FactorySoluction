<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tmp_tipomensalidadeJB" class="br.com.easynet.gwt.i9factory.jb.Tmp_tipomensalidadeInsertJB" scope="request"/>
<jsp:setProperty name="tmp_tipomensalidadeJB" property="*"/>
<jsp:setProperty name="tmp_tipomensalidadeJB" property="page" value="${pageContext}"/>
${tmp_tipomensalidadeJB.execute}
{"resultado":"${tmp_tipomensalidadeJB.msg}"}
