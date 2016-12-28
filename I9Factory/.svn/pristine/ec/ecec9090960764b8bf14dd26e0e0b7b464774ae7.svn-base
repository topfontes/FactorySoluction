<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="lan_lancamentoJB" class="br.com.easynet.gwt.i9factory.jb.Lan_lancamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="*"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="page" value="${pageContext}"/>                                         
${lan_lancamentoJB.execute}                                         
{"resultado":
{"msg":"${lan_lancamentoJB.msg}",
     "lan_lancamento":{	"lan_nr_id":"${lan_lancamentoJB.lan_lancamentoT.lan_nr_id}"
 ,	"ctr_nr_id":"${lan_lancamentoJB.lan_lancamentoT.ctr_nr_id}"
 ,	"ctp_nr_id":"${lan_lancamentoJB.lan_lancamentoT.ctp_nr_id}"
 ,	"lan_plc_nr_id_deb":"${lan_lancamentoJB.lan_lancamentoT.lan_plc_nr_id_deb}"
 ,	"lan_plc_nr_id_cred":"${lan_lancamentoJB.lan_lancamentoT.lan_plc_nr_id_cred}"
 ,	"lan_dt_lancamento":"<fmt:formatDate value="${lan_lancamentoJB.lan_lancamentoT.lan_dt_lancamento}" pattern="dd/MM/yyyy"/>"
 ,	"lan_tx_historico":"${lan_lancamentoJB.lan_lancamentoT.lan_tx_historico}"
 ,	"lan_valor":"${lan_lancamentoJB.lan_lancamentoT.lan_valor}"
 ,	"lan_nr_id_super":"${lan_lancamentoJB.lan_lancamentoT.lan_nr_id_super}"
  }
    }
     
}                                                                                
   
