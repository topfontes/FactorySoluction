<jsp:useBean id="idadeJB" class="br.com.easynet.gwt.i9factory.relatorio.clientes_idade_acima.ClientesIdadeAcima" scope="request"/>
<jsp:setProperty name="idadeJB" property="*"/>
<jsp:setProperty name="idadeJB" property="page" value="${pageContext}"/>
${idadeJB.execute}