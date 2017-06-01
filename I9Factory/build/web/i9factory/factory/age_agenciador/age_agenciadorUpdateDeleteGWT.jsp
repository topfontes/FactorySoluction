<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="age_agenciadorJB" class="br.com.easynet.gwt.i9factory.jb.Age_agenciadorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="*"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="page" value="${pageContext}"/>                                         
${age_agenciadorJB.execute}                                         
{"resultado":
{"msg":"${age_agenciadorJB.msg}",
     "age_agenciador":{	"age_nr_id":"${age_agenciadorJB.age_agenciadorT.age_nr_id}"
 ,	"age_tx_cpf":"${age_agenciadorJB.age_agenciadorT.age_tx_cpf}"
 ,	"age_tx_nome":"${age_agenciadorJB.age_agenciadorT.age_tx_nome}"
 ,	"age_dt_cadastro":"<fmt:formatDate value="${age_agenciadorJB.age_agenciadorT.age_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"age_dt_nascimento":"<fmt:formatDate value="${age_agenciadorJB.age_agenciadorT.age_dt_nascimento}" pattern="dd/MM/yyyy"/>"
 ,	"eqp_nr_id":"${age_agenciadorJB.age_agenciadorT.eqp_nr_id}"
 ,	"age_tx_tipologradouro":"${age_agenciadorJB.age_agenciadorT.age_tx_tipologradouro}"
 ,	"age_tx_logradouro":"${age_agenciadorJB.age_agenciadorT.age_tx_logradouro}"
 ,	"age_tx_numero":"${age_agenciadorJB.age_agenciadorT.age_tx_numero}"
 ,	"age_tx_cep":"${age_agenciadorJB.age_agenciadorT.age_tx_cep}"
 ,	"age_tx_complemento":"${age_agenciadorJB.age_agenciadorT.age_tx_complemento}"
 ,	"age_tx_bairro":"${age_agenciadorJB.age_agenciadorT.age_tx_bairro}"
 ,	"age_tx_municipio":"${age_agenciadorJB.age_agenciadorT.age_tx_municipio}"
 ,	"age_tx_uf":"${age_agenciadorJB.age_agenciadorT.age_tx_uf}"
 ,	"age_tx_telefone2":"${age_agenciadorJB.age_agenciadorT.age_tx_telefone2}"
 ,	"age_tx_telefone2_1":"${age_agenciadorJB.age_agenciadorT.age_tx_telefone2_1}"
 ,	"age_tx_celular":"${age_agenciadorJB.age_agenciadorT.age_tx_celular}"
 ,	"age_tx_email":"${age_agenciadorJB.age_agenciadorT.age_tx_email}"
 ,	"age_nr_taxaemprestimo":"${age_agenciadorJB.age_agenciadorT.age_nr_taxaemprestimo}"
 ,	"age_nr_taxamensalidade":"${age_agenciadorJB.age_agenciadorT.age_nr_taxamensalidade}"
  }
    }
     
}                                                                                
   
