<jsp:useBean id="clienteJB" class="br.com.easynet.gwt.i9factory.relatorio.statuscliente.StatusCliente" scope="request"/>
<jsp:setProperty name="clienteJB" property="*"/>
<jsp:setProperty name="clienteJB" property="page" value="${pageContext}"/>
${clienteJB.execute}
