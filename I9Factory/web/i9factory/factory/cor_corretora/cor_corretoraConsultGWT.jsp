<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cor_corretoraJB" class="br.com.easynet.gwt.i9factory.jb.Cor_corretoraConsultJB" scope="request"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="*"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="page" value="${pageContext}"/>                                         
${cor_corretoraJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cor_corretoraJB.list}" var="item">
     ,{	"cor_nr_id":"${item.cor_nr_id}"
 ,	"cor_tx_cnpj":"${item.cor_tx_cnpj}"
 ,	"cor_tx_razaosocial":"${item.cor_tx_razaosocial}"
 ,	"cor_tx_nomefantasia":"${item.cor_tx_nomefantasia}"
 ,	"cor_tx_inscestadual":"${item.cor_tx_inscestadual}"
 ,	"cor_tx_responsavel":"${item.cor_tx_responsavel}"
 ,	"cor_tx_tipologradouro":"${item.cor_tx_tipologradouro}"
 ,	"cor_tx_logradouro":"${item.cor_tx_logradouro}"
 ,	"cor_tx_numero":"${item.cor_tx_numero}"
 ,	"cor_tx_cep":"${item.cor_tx_cep}"
 ,	"cor_tx_complemento":"${item.cor_tx_complemento}"
 ,	"cor_tx_bairro":"${item.cor_tx_bairro}"
 ,	"cor_tx_municipio":"${item.cor_tx_municipio}"
 ,	"cor_tx_uf":"${item.cor_tx_uf}"
 ,	"cor_tx_telefone1":"${item.cor_tx_telefone1}"
 ,	"cor_tx_telefone2":"${item.cor_tx_telefone2}"
  }
</c:forEach>
]}                                                                                
   
