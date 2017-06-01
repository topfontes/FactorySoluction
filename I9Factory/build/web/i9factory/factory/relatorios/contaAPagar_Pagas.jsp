<jsp:useBean id="ctp" class="br.com.easynet.gwt.i9factory.relatorio.contaAPagar_Pagas.ContasAPagar_Pagas" scope="request"/>
<jsp:setProperty name="ctp" property="*"/>
<jsp:setProperty name="ctp" property="page" value="${pageContext}"/>
${ctp.execute}