<jsp:useBean id="carteiraJB" class="br.com.easynet.gwt.i9factory.relatorio.carteira.Carteira" scope="request"/>
<jsp:setProperty name="carteiraJB" property="*"/>
<jsp:setProperty name="carteiraJB" property="page" value="${pageContext}"/>
${carteiraJB.execute}