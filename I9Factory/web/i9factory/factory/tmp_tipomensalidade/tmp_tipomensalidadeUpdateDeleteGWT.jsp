<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tmp_tipomensalidadeJB" class="br.com.easynet.gwt.i9factory.jb.Tmp_tipomensalidadeUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="*"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="page" value="${pageContext}"/>                                         
${tmp_tipomensalidadeJB.execute}                                         
{"resultado":
{"msg":"${tmp_tipomensalidadeJB.msg}",
     "tmp_tipomensalidade":{	"tmp_nr_id":"${tmp_tipomensalidadeJB.tmp_tipomensalidadeT.tmp_nr_id}"
 ,	"tmp_tx_nome":"${tmp_tipomensalidadeJB.tmp_tipomensalidadeT.tmp_tx_nome}"
 ,	"tmp_tx_descricao":"${tmp_tipomensalidadeJB.tmp_tipomensalidadeT.tmp_tx_descricao}"
 ,	"tmp_nr_valor":"${tmp_tipomensalidadeJB.tmp_tipomensalidadeT.tmp_nr_valor}"
  }
    }
     
}                                                                                
   
