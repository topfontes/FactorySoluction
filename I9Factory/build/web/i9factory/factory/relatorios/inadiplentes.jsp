<jsp:useBean id="inadiplentesJB" class="br.com.easynet.gwt.i9factory.relatorio.inadimplentes.Inadiplentes" scope="request"/>
<jsp:setProperty name="inadiplentesJB" property="*"/>
<jsp:setProperty name="inadiplentesJB" property="page" value="${pageContext}"/>
${inadiplentesJB.execute}