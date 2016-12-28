<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eqp_equipeJB" class="br.com.easynet.gwt.i9factory.jb.Eqp_equipeUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="*"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="page" value="${pageContext}"/>                                         
${eqp_equipeJB.execute}                                         
{"resultado":
{"msg":"${eqp_equipeJB.msg}",
"eqp_equipe":{	"eqp_nr_id":"${eqp_equipeJB.eqp_equipeT.eqp_nr_id}"
,	"eqp_tx_nome":"${eqp_equipeJB.eqp_equipeT.eqp_tx_nome}"
,	"eqp_tx_descricao":"${eqp_equipeJB.eqp_equipeT.eqp_tx_descricao}"
,	"cor_nr_id":"${eqp_equipeJB.eqp_equipeT.cor_nr_id}"
}
}

}                                                                                

