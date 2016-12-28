<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_arquivo_retorno_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Vw_arquivo_retorno_bancoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="*"/>                                         
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="page" value="${pageContext}"/>                                         
${vw_arquivo_retorno_bancoJB.execute}                                         
{"resultado":
{"msg":"${vw_arquivo_retorno_bancoJB.msg}",
     "vw_arquivo_retorno_banco":{	"teb_nr_id":"${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.teb_nr_id}"
 ,	"teb_dt_envio":"<fmt:formatDate value="${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.teb_dt_envio}" pattern="dd/MM/yyyy"/>"
 ,	"teb_dt_retorno":"<fmt:formatDate value="${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.teb_dt_retorno}" pattern="dd/MM/yyyy"/>"
 ,	"teb_tx_status":"${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.teb_tx_status}"
 ,	"teb_tx_operacao":"${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.teb_tx_operacao}"
 ,	"ple_dt_vencimento":"<fmt:formatDate value="${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>"
 ,	"ple_tx_parcela":"${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.ple_tx_parcela}"
 ,	"ple_nr_valorparcela":"${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.ple_nr_valorparcela}"
 ,	"emp_nr_proposta":"${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.emp_nr_proposta}"
 ,	"cli_tx_nome":"${vw_arquivo_retorno_bancoJB.vw_arquivo_retorno_bancoT.cli_tx_nome}"
  }
    }
     
}                                                                                
   
