<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="age_agenciadorJB" class="br.com.easynet.gwt.i9factory.jb.Age_agenciadorConsultJB" scope="request"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="*"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="page" value="${pageContext}"/>                                         
${age_agenciadorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${age_agenciadorJB.ds.list}" var="item">
     ,{	"age_nr_id":"${item.row[0].value}"
 ,	"age_tx_cpf":"${item.row[1].value}"
 ,	"age_tx_nome":"${item.row[2].value}"
 ,	"age_dt_cadastro":"<fmt:formatDate value="${item.row[3].value}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"age_dt_nascimento":"<fmt:formatDate value="${item.row[4].value}" pattern="dd/MM/yyyy"/>"
 ,	"eqp_nr_id":"${item.row[5].value}"
 ,	"age_tx_tipologradouro":"${item.row[6].value}"
 ,	"age_tx_logradouro":"${item.row[7].value}"
 ,	"age_tx_numero":"${item.row[8].value}"
 ,	"age_tx_cep":"${item.row[9].value}"
 ,	"age_tx_complemento":"${item.row[10].value}"
 ,	"age_tx_bairro":"${item.row[11].value}"
 ,	"age_tx_municipio":"${item.row[12].value}"
 ,	"age_tx_uf":"${item.row[13].value}"
 ,	"age_tx_telefone2":"${item.row[14].value}"
 ,	"age_tx_telefone2_1":"${item.row[15].value}"
 ,	"age_tx_celular":"${item.row[16].value}"
 ,	"age_tx_email":"${item.row[17].value}"
 ,	"age_nr_taxaemprestimo":"${item.row[18].value}"
 ,	"age_nr_taxamensalidade":"${item.row[19].value}"
 ,	"eqp_tx_nome":"${item.row[20].value}"

  }

</c:forEach>
]}                                                                                
   
