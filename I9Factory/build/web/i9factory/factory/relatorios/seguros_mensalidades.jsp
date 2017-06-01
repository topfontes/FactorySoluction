<jsp:useBean id="seguroJB" class="br.com.easynet.gwt.i9factory.relatorio.seguro_mensalidade.SegurosMensalidade" scope="request"/>
<jsp:setProperty name="seguroJB" property="*"/>
<jsp:setProperty name="seguroJB" property="page" value="${pageContext}"/>
${seguroJB.execute}