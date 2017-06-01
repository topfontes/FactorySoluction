<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="idc_indiceJB" class="br.com.easynet.gwt.i9factory.jb.Idc_indiceInsertJB" scope="request"/>
<jsp:setProperty name="idc_indiceJB" property="*"/>
<jsp:setProperty name="idc_indiceJB" property="page" value="${pageContext}"/>
${idc_indiceJB.execute}
{"resultado":"${idc_indiceJB.msg}"}
