<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.i9factory.jb.Ctp_conta_pagarConsultJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>                                         
${ctp_conta_pagarJB.execute}                                         
{"resultado":[
{"registro":"${ctp_conta_pagarJB.msg}"}
<c:forEach items="${ctp_conta_pagarJB.ds.list}" var="item">
     ,{	"ctp_nr_id":"${item.row[0].value}"
 ,	"ctp_nr_doc":"${item.row[1].value}"
 ,	"ctp_dt_emissao":"<fmt:formatDate value="${item.row[2].value}" pattern="dd/MM/yyyy"/>"
 ,	"ctp_dt_vencimento":"<fmt:formatDate value="${item.row[3].value}" pattern="dd/MM/yyyy"/>"
 ,	"ctp_tx_pago":"${item.row[4].value}"
 ,	"ctp_tx_parcela":"${item.row[5].value}"
 ,	"ctp_valor":"${item.row[6].value}"
 ,	"ctp_dt_pagamento":"<fmt:formatDate value="${item.row[7].value}" pattern="dd/MM/yyyy"/>"
 ,	"ctp_vl_pago":"${item.row[8].value}"
 ,	"ctp_saldo":"${item.row[9].value}"
 ,	"for_nr_id":"${item.row[10].value}"
 ,	"ctp_tx_obs":"${item.row[11].value}"
 ,	"for_tx_nome":"${item.row[12].value}"
 ,	"tid_tx_nome":"${item.row[13].value}"
 ,	"tid_nr_id":"${item.row[14].value}"
  }
</c:forEach>
]}                                                                                
   
