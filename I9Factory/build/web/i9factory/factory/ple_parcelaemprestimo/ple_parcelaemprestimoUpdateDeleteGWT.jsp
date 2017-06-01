<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ple_parcelaemprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Ple_parcelaemprestimoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="*"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="page" value="${pageContext}"/>                                         
${ple_parcelaemprestimoJB.execute}                                         
{"resultado":
{"msg":"${ple_parcelaemprestimoJB.msg}",
     "ple_parcelaemprestimo":{	"ple_nr_id":"${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_id}"
 ,	"emp_nr_id":"${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.emp_nr_id}"
 ,	"ple_dt_vencimento":"<fmt:formatDate value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>"
 ,	"ple_dt_pagamento":"<fmt:formatDate value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_dt_pagamento}" pattern="dd/MM/yyyy"/>"
 ,	"ple_nr_valorparcela":"${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_valorparcela}"
 ,	"ple_nr_valordesconto":"${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_valordesconto}"
 ,	"ple_nr_cdformapagto":"${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_cdformapagto}"
  }
    }
     
}                                                                                
   
