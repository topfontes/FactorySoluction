<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="for_fornecedorJB" class="br.com.easynet.gwt.i9factory.jb.For_fornecedorConsultJB" scope="request"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="page" value="${pageContext}"/>                                         
${for_fornecedorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${for_fornecedorJB.list}" var="item">
     ,{	"for_nr_id":"${item.for_nr_id}"
 ,	"for_tx_nome":"${item.for_tx_nome}"
 ,	"for_tx_endereco":"${item.for_tx_endereco}"
 ,	"for_tx_cpf_cnpj":"${item.for_tx_cpf_cnpj}"
 ,	"for_tx_rg_inscricao":"${item.for_tx_rg_inscricao}"
 ,	"for_tx_cep":"${item.for_tx_cep}"
 ,	"for_tx_cidade":"${item.for_tx_cidade}"
 ,	"for_tx_estado":"${item.for_tx_estado}"
 ,	"for_tx_bairro":"${item.for_tx_bairro}"
 ,	"for_tx_email":"${item.for_tx_email}"
 ,	"for_tx_home_page":"${item.for_tx_home_page}"
 ,	"for_tx_contato":"${item.for_tx_contato}"
 ,	"for_tx_status":"${item.for_tx_status}"
 ,	"for_tx_telefone1":"${item.for_tx_telefone1}"
 ,	"for_tx_telefone2":"${item.for_tx_telefone2}"
  }
</c:forEach>
]}                                                                                
   
