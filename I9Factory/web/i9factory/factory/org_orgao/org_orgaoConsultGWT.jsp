<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="org_orgaoJB" class="br.com.easynet.gwt.i9factory.jb.Org_orgaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="org_orgaoJB" property="*"/>                                         
<jsp:setProperty name="org_orgaoJB" property="page" value="${pageContext}"/>                                         
${org_orgaoJB.execute}                                         
{"resultado":[
   <c:forEach items="${org_orgaoJB.list}" var="item" varStatus="linha">
     {	"org_nr_id":"${item.org_nr_id}"
 ,	"org_tx_cnpj":"${item.org_tx_cnpj}"
 ,	"org_tx_razaosocial":"${item.org_tx_razaosocial}"
 ,	"org_tx_nomefantasia":"${item.org_tx_nomefantasia}"
 ,	"org_tx_inscestadual":"${item.org_tx_inscestadual}"
 ,	"org_tx_tipologradouro":"${item.org_tx_tipologradouro}"
 ,	"org_tx_logradouro":"${item.org_tx_logradouro}"
 ,	"org_tx_numero":"${item.org_tx_numero}"
 ,	"org_tx_cep":"${item.org_tx_cep}"
 ,	"org_tx_complemento":"${item.org_tx_complemento}"
 ,	"org_tx_bairro":"${item.org_tx_bairro}"
 ,	"org_tx_municipio":"${item.org_tx_municipio}"
 ,	"org_tx_uf":"${item.org_tx_uf}"
 ,	"org_tx_telefone1":"${item.org_tx_telefone1}"
 ,	"org_tx_telefone2":"${item.org_tx_telefone2}"
  }
         ${linha.count != org_orgaoJB.quantItens ? ',':''}

  
</c:forEach>
]}                                                                                
   
