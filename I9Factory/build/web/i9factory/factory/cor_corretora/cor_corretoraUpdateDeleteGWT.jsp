<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cor_corretoraJB" class="br.com.easynet.gwt.i9factory.jb.Cor_corretoraUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="*"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="page" value="${pageContext}"/>                                         
${cor_corretoraJB.execute}                                         
{"resultado":
{"msg":"${cor_corretoraJB.msg}",
     "cor_corretora":{	"cor_nr_id":"${cor_corretoraJB.cor_corretoraT.cor_nr_id}"
 ,	"cor_tx_cnpj":"${cor_corretoraJB.cor_corretoraT.cor_tx_cnpj}"
 ,	"cor_tx_razaosocial":"${cor_corretoraJB.cor_corretoraT.cor_tx_razaosocial}"
 ,	"cor_tx_nomefantasia":"${cor_corretoraJB.cor_corretoraT.cor_tx_nomefantasia}"
 ,	"cor_tx_inscestadual":"${cor_corretoraJB.cor_corretoraT.cor_tx_inscestadual}"
 ,	"cor_tx_responsavel":"${cor_corretoraJB.cor_corretoraT.cor_tx_responsavel}"
 ,	"cor_tx_tipologradouro":"${cor_corretoraJB.cor_corretoraT.cor_tx_tipologradouro}"
 ,	"cor_tx_logradouro":"${cor_corretoraJB.cor_corretoraT.cor_tx_logradouro}"
 ,	"cor_tx_numero":"${cor_corretoraJB.cor_corretoraT.cor_tx_numero}"
 ,	"cor_tx_cep":"${cor_corretoraJB.cor_corretoraT.cor_tx_cep}"
 ,	"cor_tx_complemento":"${cor_corretoraJB.cor_corretoraT.cor_tx_complemento}"
 ,	"cor_tx_bairro":"${cor_corretoraJB.cor_corretoraT.cor_tx_bairro}"
 ,	"cor_tx_municipio":"${cor_corretoraJB.cor_corretoraT.cor_tx_municipio}"
 ,	"cor_tx_uf":"${cor_corretoraJB.cor_corretoraT.cor_tx_uf}"
 ,	"cor_tx_telefone1":"${cor_corretoraJB.cor_corretoraT.cor_tx_telefone1}"
 ,	"cor_tx_telefone2":"${cor_corretoraJB.cor_corretoraT.cor_tx_telefone2}"
  }
    }
     
}                                                                                
   
