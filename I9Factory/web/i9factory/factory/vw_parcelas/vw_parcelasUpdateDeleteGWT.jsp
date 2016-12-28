<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_parcelasJB" class="br.com.easynet.gwt.i9factory.jb.Vw_parcelasUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="*"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="page" value="${pageContext}"/>                                         
${vw_parcelasJB.execute}                                         
{"resultado":
{"msg":"${vw_parcelasJB.msg}",
     "vw_parcelas":{	"ple_nr_id":"${vw_parcelasJB.vw_parcelasT.ple_nr_id}"
 ,	"emp_nr_id":"${vw_parcelasJB.vw_parcelasT.emp_nr_id}"
 ,	"ple_dt_vencimento":"<fmt:formatDate value="${vw_parcelasJB.vw_parcelasT.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>"
 ,	"ple_dt_pagamento":"<fmt:formatDate value="${vw_parcelasJB.vw_parcelasT.ple_dt_pagamento}" pattern="dd/MM/yyyy"/>"
 ,	"ple_nr_valorparcela":"${vw_parcelasJB.vw_parcelasT.ple_nr_valorparcela}"
 ,	"ple_nr_valordesconto":"${vw_parcelasJB.vw_parcelasT.ple_nr_valordesconto}"
 ,	"ple_nr_cdformapagto":"${vw_parcelasJB.vw_parcelasT.ple_nr_cdformapagto}"
 ,	"ple_tx_parcela":"${vw_parcelasJB.vw_parcelasT.ple_tx_parcela}"
 ,	"ple_tx_tipo":"${vw_parcelasJB.vw_parcelasT.ple_tx_tipo}"
 ,	"emp_dt_emprestimo":"<fmt:formatDate value="${vw_parcelasJB.vw_parcelasT.emp_dt_emprestimo}" pattern="dd/MM/yyyy"/>"
 ,	"emp_nr_proposta":"${vw_parcelasJB.vw_parcelasT.emp_nr_proposta}"
 ,	"emp_nr_valor":"${vw_parcelasJB.vw_parcelasT.emp_nr_valor}"
 ,	"emp_nr_valor_afin_liquido":"${vw_parcelasJB.vw_parcelasT.emp_nr_valor_afin_liquido}"
 ,	"cli_nr_id":"${vw_parcelasJB.vw_parcelasT.cli_nr_id}"
 ,	"org_nr_id":"${vw_parcelasJB.vw_parcelasT.org_nr_id}"
 ,	"cli_tx_cpf":"${vw_parcelasJB.vw_parcelasT.cli_tx_cpf}"
 ,	"cli_tx_nome":"${vw_parcelasJB.vw_parcelasT.cli_tx_nome}"
 ,	"cco_tx_nragencia":"${vw_parcelasJB.vw_parcelasT.cco_tx_nragencia}"
 ,	"cco_tx_nrcontacorrente":"${vw_parcelasJB.vw_parcelasT.cco_tx_nrcontacorrente}"
 ,	"bco_nr_id":"${vw_parcelasJB.vw_parcelasT.bco_nr_id}"
 ,	"bco_tx_nome":"${vw_parcelasJB.vw_parcelasT.bco_tx_nome}"
 ,	"bco_tx_codigo":"${vw_parcelasJB.vw_parcelasT.bco_tx_codigo}"
  }
    }
     
}                                                                                
   
