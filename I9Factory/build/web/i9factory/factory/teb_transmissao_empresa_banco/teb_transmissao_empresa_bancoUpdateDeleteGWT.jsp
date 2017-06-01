<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="teb_transmissao_empresa_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Teb_transmissao_empresa_bancoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="teb_transmissao_empresa_bancoJB" property="*"/>                                         
<jsp:setProperty name="teb_transmissao_empresa_bancoJB" property="page" value="${pageContext}"/>                                         
${teb_transmissao_empresa_bancoJB.execute}                                         
{"resultado":
{"msg":"${teb_transmissao_empresa_bancoJB.msg}",
     "teb_transmissao_empresa_banco":{	"teb_nr_id":"${teb_transmissao_empresa_bancoJB.teb_transmissao_empresa_bancoT.teb_nr_id}"
 ,	"teb_dt_envio":"<fmt:formatDate value="${teb_transmissao_empresa_bancoJB.teb_transmissao_empresa_bancoT.teb_dt_envio}" pattern="dd/MM/yyyy"/>"
 ,	"teb_dt_retorno":"<fmt:formatDate value="${teb_transmissao_empresa_bancoJB.teb_transmissao_empresa_bancoT.teb_dt_retorno}" pattern="dd/MM/yyyy"/>"
 ,	"teb_tx_status":"${teb_transmissao_empresa_bancoJB.teb_transmissao_empresa_bancoT.teb_tx_status}"
  }
    }
     
}                                                                                
   
