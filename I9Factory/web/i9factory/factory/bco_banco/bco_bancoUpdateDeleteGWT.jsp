<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="bco_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Bco_bancoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="bco_bancoJB" property="*"/>                                         
<jsp:setProperty name="bco_bancoJB" property="page" value="${pageContext}"/>                                         
${bco_bancoJB.execute}                                         
{"resultado":
{"msg":"${bco_bancoJB.msg}",
     "bco_banco":{	"bco_nr_id":"${bco_bancoJB.bco_bancoT.bco_nr_id}"
 ,	"bco_tx_nome":"${bco_bancoJB.bco_bancoT.bco_tx_nome}"
 ,	"bco_tx_telefone1":"${bco_bancoJB.bco_bancoT.bco_tx_telefone1}"
 ,	"bco_tx_telefone2":"${bco_bancoJB.bco_bancoT.bco_tx_telefone2}"
 ,	"bco_tx_nomecontato":"${bco_bancoJB.bco_bancoT.bco_tx_nomecontato}"
 ,	"bco_tx_codigo":"${bco_bancoJB.bco_bancoT.bco_tx_codigo}"
  }
    }
     
}                                                                                
   
