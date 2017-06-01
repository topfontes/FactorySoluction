<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_parcelasJB" class="br.com.easynet.gwt.i9factory.jb.Vw_parcelasConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="*"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="page" value="${pageContext}"/>                                         
${vw_parcelasJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${vw_parcelasJB.list}" var="item">
    ,{	"ple_nr_id":"${item.ple_nr_id}"
    ,	"emp_nr_id":"${item.emp_nr_id}"
    ,	"ple_dt_vencimento":"<fmt:formatDate value="${item.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>"
    ,	"ple_dt_pagamento":"<fmt:formatDate value="${item.ple_dt_pagamento}" pattern="dd/MM/yyyy"/>"
    ,	"ple_nr_valorparcela":"${item.ple_nr_valorparcela}"
    ,	"ple_nr_valordesconto":"${item.ple_nr_valordesconto}"
    ,	"ple_nr_cdformapagto":"${item.ple_nr_cdformapagto}"
    ,	"ple_tx_parcela":"${item.ple_tx_parcela}"
    ,	"ple_tx_tipo":"${item.ple_tx_tipo}"
    ,	"emp_dt_emprestimo":"<fmt:formatDate value="${item.emp_dt_emprestimo}" pattern="dd/MM/yyyy"/>"
    ,	"emp_nr_proposta":"${item.emp_nr_proposta}"
    ,	"emp_nr_valor":"${item.emp_nr_valor}"
    ,	"emp_nr_valor_afin_liquido":"${item.emp_nr_valor_afin_liquido}"
    ,	"cli_nr_id":"${item.cli_nr_id}"
    ,	"org_nr_id":"${item.org_nr_id}"
    ,	"cli_tx_cpf":"${item.cli_tx_cpf}"
    ,	"cli_tx_nome":"${item.cli_tx_nome}"
    ,	"cco_tx_nragencia":"${item.cco_tx_nragencia}"
    ,	"cco_tx_nrcontacorrente":"${item.cco_tx_nrcontacorrente}"
    ,	"bco_nr_id":"${item.bco_nr_id}"
    ,	"bco_tx_nome":"${item.bco_tx_nome}"
    ,	"bco_tx_codigo":"${item.bco_tx_codigo}"
    ,	"org_tx_nome":"${item.org_tx_nome}"
    ,	"cor_tx_nome":"${item.cor_tx_nome}"
    ,	"cli_tx_matricula":"${item.cli_tx_matricula}"
    ,	"ple_tx_historico":"${item.ple_tx_historico}"
    ,	"ple_nr_id_vinculo":"${item.ple_nr_id_vinculo}"
    ,   "cli_dt_nascimento":"<fmt:formatDate value="${item.cli_dt_nascimento}" pattern="dd/MM/yyyy"/>"
    }
</c:forEach>
]}                                                                                

