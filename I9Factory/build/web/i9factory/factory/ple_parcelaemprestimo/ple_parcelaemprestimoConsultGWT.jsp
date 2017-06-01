<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ple_parcelaemprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Ple_parcelaemprestimoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="*"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="page" value="${pageContext}"/>                                         
${ple_parcelaemprestimoJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${ple_parcelaemprestimoJB.ds.list}" var="item">
,{"ple_nr_id":"${item.row[0].value}"
,"emp_nr_id":"${item.row[1].value}"
,"ple_dt_vencimento":"<fmt:formatDate value="${item.row[2].value}" pattern="dd/MM/yyyy"/>"
,"ple_dt_pagamento":"<fmt:formatDate value="${item.row[3].value}" pattern="dd/MM/yyyy"/>"
,"ple_nr_valorparcela":"${item.row[4].value}"
,"ple_nr_valordesconto":"${item.row[5].value}"
,"ple_nr_cdformapagto":"${item.row[6].value}"
,"ple_tx_parcela":"${item.row[7].value}"
,"cli_tx_nome":"${item.row[8].value}"
,"ple_tx_tipo":"${item.row[9].value}"
,"ple_tx_historico":"${item.row[10].value}"
,"ple_nr_id_vinculo":"${item.row[11].value}"
,"ple_nr_seq_boleto":"${item.row[12].value}"
}
</c:forEach>
]}