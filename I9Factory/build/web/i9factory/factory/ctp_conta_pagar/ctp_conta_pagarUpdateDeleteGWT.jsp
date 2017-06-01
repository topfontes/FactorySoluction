<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.i9factory.jb.Ctp_conta_pagarUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>                                         
${ctp_conta_pagarJB.execute}                                         
{"resultado":
{"msg":"${ctp_conta_pagarJB.msg}",
     "ctp_conta_pagar":{	"ctp_nr_id":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_id}"
 ,	"ctp_nr_doc":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_doc}"
 ,	"ctp_dt_emissao":"<fmt:formatDate value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_dt_emissao}" pattern="dd/MM/yyyy"/>"
 ,	"ctp_dt_vencimento":"<fmt:formatDate value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_dt_vencimento}" pattern="dd/MM/yyyy"/>"
 ,	"ctp_tx_pago":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_pago}"
 ,	"ctp_tx_parcela":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_parcela}"
 ,	"ctp_valor":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_valor}"
 ,	"ctp_dt_pagamento":"<fmt:formatDate value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_dt_pagamento}" pattern="dd/MM/yyyy"/>"
 ,	"ctp_vl_pago":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_vl_pago}"
 ,	"ctp_saldo":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_saldo}"
 ,	"for_nr_id":"${ctp_conta_pagarJB.ctp_conta_pagarT.for_nr_id}"
 ,	"ctp_tx_obs":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_obs}"
  }
    }
     
}                                                                                
   
