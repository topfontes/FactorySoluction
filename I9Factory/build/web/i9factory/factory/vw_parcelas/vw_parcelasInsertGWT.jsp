<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_parcelasJB" class="br.com.easynet.gwt.i9factory.jb.Vw_parcelasInsertJB" scope="request"/>
<jsp:setProperty name="vw_parcelasJB" property="*"/>
<jsp:setProperty name="vw_parcelasJB" property="page" value="${pageContext}"/>
${vw_parcelasJB.execute}
{"resultado":"${vw_parcelasJB.msg}"}
