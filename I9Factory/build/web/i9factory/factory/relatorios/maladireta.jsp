<jsp:useBean id="malaJB" class="br.com.easynet.gwt.i9factory.relatorio.maladireta.Maladireta" scope="request"/>
<jsp:setProperty name="malaJB" property="*"/>
<jsp:setProperty name="malaJB" property="page" value="${pageContext}"/>
${malaJB.execute}