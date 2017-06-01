<jsp:useBean id="comissaoJB" class="br.com.easynet.gwt.i9factory.relatorio.comissao.Comissao" scope="request"/>
<jsp:setProperty name="comissaoJB" property="*"/>
<jsp:setProperty name="comissaoJB" property="page" value="${pageContext}"/>
${comissaoJB.execute}