<jsp:useBean id="printJB" class="br.com.easynet.gwt.i9factory.relatorio.print_emprestimo.Print_emprestimo" scope="request"/>
<jsp:setProperty name="printJB" property="*"/>
<jsp:setProperty name="printJB" property="page" value="${pageContext}"/>
${printJB.execute}