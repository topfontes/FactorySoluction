<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cli_clienteJB" class="br.com.easynet.gwt.i9factory.jb.Cli_clienteConsultJB" scope="request"/>                                         
<jsp:setProperty name="cli_clienteJB" property="*"/>                                         
<jsp:setProperty name="cli_clienteJB" property="page" value="${pageContext}"/>                                         
${cli_clienteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cli_clienteJB.list}" var="item">
     ,{	"cli_nr_id":"${item.cli_nr_id}"
 ,	"cli_tx_nome":"${item.cli_tx_nome}"
 ,	"cli_tx_cpf":"${item.cli_tx_cpf}"
 ,	"cli_tx_rg":"${item.cli_tx_rg}"
 ,	"cli_tx_matricula":"${item.cli_tx_matricula}"
 ,	"cli_tx_sexo":"${item.cli_tx_sexo}"
 ,	"cli_tx_estadocivil":"${item.cli_tx_estadocivil}"
 ,	"cli_tx_tipologradouro":"${item.cli_tx_tipologradouro}"
 ,	"cli_tx_logradouro":"${item.cli_tx_logradouro}"
 ,	"cli_tx_numero":"${item.cli_tx_numero}"
 ,	"cli_tx_cep":"${item.cli_tx_cep}"
 ,	"cli_tx_complemento":"${item.cli_tx_complemento}"
 ,	"cli_tx_bairro":"${item.cli_tx_bairro}"
 ,	"cli_tx_municipio":"${item.cli_tx_municipio}"
 ,	"cli_tx_uf":"${item.cli_tx_uf}"
 ,	"cli_tx_email":"${item.cli_tx_email}"
 ,	"cli_tx_telefone1":"${item.cli_tx_telefone1}"
 ,	"cli_tx_telefone2":"${item.cli_tx_telefone2}"
 ,	"cli_tx_celular":"${item.cli_tx_celular}"
 ,	"cli_tx_ramal":"${item.cli_tx_ramal}"
 ,	"cli_dt_nascimento":"<fmt:formatDate value="${item.cli_dt_nascimento}" pattern="dd/MM/yyyy"/>"
 ,	"cli_bt_foto":"IMAGEM"
 ,	"cli_dt_cadastro":"<fmt:formatDate value="${item.cli_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>"
 ,	"cli_tx_socio":"${item.cli_tx_socio}"
 ,	"mtc_nr_id":"${item.mtc_nr_id}" 
 ,"cli_tx_salario_minimo":"${item.cli_tx_salario_minimo}"
  }
</c:forEach>
],
"contas":[
{"quantidade":"${cli_clienteJB.quantidade}"}
<c:forEach var="item" items="${cli_clienteJB.dsConta.list}">
    ,{"cco_nr_id":"${item.row[0].value}"
    ,"cco_tx_nragencia":"${item.row[1].value}"
    ,"cco_tx_nrcontacorrente":"${item.row[2].value}"
    ,"bco_nr_id":"${item.row[4].value}"
    ,"cli_nr_id":"${item.row[5].value}"
    ,"bco_tx_nome":"${item.row[8].value}"
    ,"org_tx_nome":"${item.row[9].value}"
    ,"org_nr_id":"${item.row[10].value}"
    }
</c:forEach>
],
"proposta":[
{"marcado":"marcador"}
<c:forEach var="item" items="${cli_clienteJB.dsMaxProposta.list}">
    ,{"cli_nr_id":"${item.row[0].value}"
    ,"proposta":"${item.row[1].value}"

    }
</c:forEach>
]


}                                                                                
   
