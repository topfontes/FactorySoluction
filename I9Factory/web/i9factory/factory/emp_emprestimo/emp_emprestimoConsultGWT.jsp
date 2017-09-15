<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="emp_emprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Emp_emprestimoConsultJB" scope="request"/>                                         
<jsp:setProperty name="emp_emprestimoJB" property="*"/>                                         
<jsp:setProperty name="emp_emprestimoJB" property="page" value="${pageContext}"/>                                         
${emp_emprestimoJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${emp_emprestimoJB.ds.list}" var="item">
,{"emp_nr_id":"${item.row[0].value}"
,"cli_nr_id":"${item.row[1].value}"
,"age_nr_id":"${item.row[2].value}"
,"idc_nr_id":"${item.row[3].value}"
,"emp_dt_emprestimo":"<fmt:formatDate value="${item.row[4].value}" pattern="dd/MM/yyyy"/>"
,"emp_nr_valor":"${item.row[5].value}"
,"emp_tx_status":"${item.row[6].value}"
,"emp_tx_observacoes":"${item.row[7].value}"
,"emp_dt_aprovacao":"<fmt:formatDate value="${item.row[8].value}" pattern="dd/MM/yyyy"/>"
,"emp_dt_liberacao":"<fmt:formatDate value="${item.row[9].value}" pattern="dd/MM/yyyy"/>"
,"emp_dt_quitacao":"<fmt:formatDate value="${item.row[10].value}" pattern="dd/MM/yyyy"/>"
,"emp_dt_enviobanco":"<fmt:formatDate value="${item.row[11].value}" pattern="dd/MM/yyyy HH:mm"/>"
,"emp_dt_retornobanco":"<fmt:formatDate value="${item.row[12].value}" pattern="dd/MM/yyyy HH:mm"/>"
,"emp_tx_cdlancamentobanco":"${item.row[13].value}"
,"emp_tx_cdlancamentopendente":"${item.row[14].value}"
,"emp_tx_numerocheque":"${item.row[15].value}"
,"org_nr_id":"${item.row[16].value}"
,"cor_nr_id":"${item.row[17].value}"
,"cli_tx_nome":"${item.row[18].value}"
,"org_tx_nome":"${item.row[19].value}"
,"cor_tx_nome":"${item.row[20].value}"
,"cli_tx_cpf":"${item.row[21].value}"
,"cli_tx_matricula":"${item.row[22].value}"
,"bco_tx_nome":"${item.row[23].value}"
,"emp_nr_valor_parcelas_anterior":"${item.row[24].value}"
,"emp_nr_valor_desc_parcela_anterior":"${item.row[25].value}"
,"emp_nr_valor_afin_bruto":"${item.row[26].value}"
,"emp_nr_valor_afin_liquido":"${item.row[27].value}"
,"emp_nr_proposta":"${item.row[28].value}"
,"usu_tx_nome":"${item.row[29].value}"
,"tic_nr_id":"${item.row[30].value}"
,"emp_tx_compensado":"${item.row[31].value}"
,"emp_tx_acordo":"${item.row[32].value}"
,"emp_seq_nr_boletobb":"${item.row[33].value}"
,"tac_nr_id":"${item.row[34].value}"
}
</c:forEach>
]}