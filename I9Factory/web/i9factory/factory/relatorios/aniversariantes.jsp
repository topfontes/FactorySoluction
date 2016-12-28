<jsp:useBean id="aniverJB" class="br.com.easynet.gwt.i9factory.relatorio.aniversariantes.Aniversariantes" scope="request"/>
<jsp:setProperty name="aniverJB" property="*"/>
<jsp:setProperty name="aniverJB" property="page" value="${pageContext}"/>
${aniverJB.execute}