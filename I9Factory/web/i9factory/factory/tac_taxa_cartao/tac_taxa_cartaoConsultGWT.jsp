<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tac_taxa_cartaoJB" class="br.com.easynet.gwt.i9factory.jb.Tac_taxa_cartaoJB" scope="request"/>                                         
<jsp:setProperty name="tac_taxa_cartaoJB" property="*"/>                                         
<jsp:setProperty name="tac_taxa_cartaoJB" property="page" value="${pageContext}"/>                                         
${tac_taxa_cartaoJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${tac_taxa_cartaoJB.list}" var="item">
    ,{"car_nr_id":"${item.car_nr_id}"
    ,"tac_tx_nome":"${item.tac_tx_nome}"
    ,"tac_nr_taxa":"${item.tac_nr_taxa}"
    ,"tac_nr_id":"${item.tac_nr_id}"
    }
</c:forEach>
]}  