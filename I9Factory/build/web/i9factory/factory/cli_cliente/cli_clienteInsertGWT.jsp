<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cli_clienteJB" class="br.com.easynet.gwt.i9factory.jb.Cli_clienteInsertJB" scope="request"/>
<jsp:setProperty name="cli_clienteJB" property="*"/>
<jsp:setProperty name="cli_clienteJB" property="page" value="${pageContext}"/>
${cli_clienteJB.execute}
{"resultado":
{"msg"       :{"msg"      :"${cli_clienteJB.msg}"},
"cli_cliente":{"cli_nr_id":"${cli_clienteJB.cli_clienteT.cli_nr_id}"
,	"cli_tx_nome":"${cli_clienteJB.cli_clienteT.cli_tx_nome}"
,	"cli_tx_cpf":"${cli_clienteJB.cli_clienteT.cli_tx_cpf}"
,	"cli_tx_rg":"${cli_clienteJB.cli_clienteT.cli_tx_rg}"
,	"cli_tx_matricula":"${cli_clienteJB.cli_clienteT.cli_tx_matricula}"
,	"cli_tx_sexo":"${cli_clienteJB.cli_clienteT.cli_tx_sexo}"
,	"cli_tx_estadocivil":"${cli_clienteJB.cli_clienteT.cli_tx_estadocivil}"
,	"cli_tx_tipologradouro":"${cli_clienteJB.cli_clienteT.cli_tx_tipologradouro}"
,	"cli_tx_logradouro":"${cli_clienteJB.cli_clienteT.cli_tx_logradouro}"
,	"cli_tx_numero":"${cli_clienteJB.cli_clienteT.cli_tx_numero}"
,	"cli_tx_cep":"${cli_clienteJB.cli_clienteT.cli_tx_cep}"
,	"cli_tx_complemento":"${cli_clienteJB.cli_clienteT.cli_tx_complemento}"
,	"cli_tx_bairro":"${cli_clienteJB.cli_clienteT.cli_tx_bairro}"
,	"cli_tx_municipio":"${cli_clienteJB.cli_clienteT.cli_tx_municipio}"
,	"cli_tx_uf":"${cli_clienteJB.cli_clienteT.cli_tx_uf}"
,	"cli_tx_email":"${cli_clienteJB.cli_clienteT.cli_tx_email}"
,	"cli_tx_telefone1":"${cli_clienteJB.cli_clienteT.cli_tx_telefone1}"
,	"cli_tx_telefone2":"${cli_clienteJB.cli_clienteT.cli_tx_telefone2}"
,	"cli_tx_celular":"${cli_clienteJB.cli_clienteT.cli_tx_celular}"
,	"cli_tx_ramal":"${cli_clienteJB.cli_clienteT.cli_tx_ramal}"
,	"cli_dt_nascimento":"<fmt:formatDate value="${cli_clienteJB.cli_clienteT.cli_dt_nascimento}" pattern="dd/MM/yyyy"/>"
,	"cli_bt_foto":"IMAGEM"
,	"cli_dt_cadastro":"<fmt:formatDate value="${cli_clienteJB.cli_clienteT.cli_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>"
,	"cli_tx_socio":"${cli_clienteJB.cli_clienteT.cli_tx_socio}"
}
},
"conta":{
<c:forEach var="item" items="${cli_clienteJB.dsConta.list}">
    "cco_nr_id":"${item.row[0].value}"
    ,"cco_tx_nragencia":"${item.row[1].value}"
    ,"cco_tx_nrcontacorrente":"${item.row[2].value}"
    ,"bco_nr_id":"${item.row[4].value}"
    ,"cli_nr_id":"${item.row[5].value}"
    ,"bco_tx_nome":"${item.row[8].value}"
    ,"org_tx_nome":"${item.row[9].value}"
    ,"org_nr_id":"${item.row[10].value}"
</c:forEach>
}

}