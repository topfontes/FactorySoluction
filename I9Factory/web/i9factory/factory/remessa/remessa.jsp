<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="remessa" class="br.com.easynet.gwt.i9factory.jb.ArquivoRemessaJB" scope="request"/>
<jsp:setProperty name="remessa" property="*"/>
<jsp:setProperty name="remessa" property="page" value="${pageContext}"/>
${remessa.execute}
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${remessa.listRemessa}" var="item">
     ,{	"linha":"${item.linha}" }
</c:forEach>
]}  
