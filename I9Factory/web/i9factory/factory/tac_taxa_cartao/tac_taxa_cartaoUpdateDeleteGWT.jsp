<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tac_taxa_cartaoJB" class="br.com.easynet.gwt.i9factory.jb.Tac_taxa_cartaoJB" scope="request"/>                                         
<jsp:setProperty name="tac_taxa_cartaoJB" property="*"/>                                         
<jsp:setProperty name="tac_taxa_cartaoJB" property="page" value="${pageContext}"/>                                         
${tac_taxa_cartaoJB.execute}                                         
{"resultado":
{"msg":"${tac_taxa_cartaoJB.msg}",
"tac_taxa_cartao":{"car_nr_id":"${tac_taxa_cartaoJB.tac_taxa_cartaoT.car_nr_id}"
,"tac_tx_nome":"${tac_taxa_cartaoJB.tac_taxa_cartaoT.tac_tx_nome}"
,"tac_tx_taxa":"${tac_taxa_cartaoJB.tac_taxa_cartaoT.tac_nr_taxa}"
}
}
}