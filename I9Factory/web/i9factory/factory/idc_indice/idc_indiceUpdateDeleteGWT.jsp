<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="idc_indiceJB" class="br.com.easynet.gwt.i9factory.jb.Idc_indiceUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="idc_indiceJB" property="*"/>                                         
<jsp:setProperty name="idc_indiceJB" property="page" value="${pageContext}"/>                                         
${idc_indiceJB.execute}                                         
{"resultado":
{"msg":"${idc_indiceJB.msg}",
     "idc_indice":{	"idc_nr_id":"${idc_indiceJB.idc_indiceT.idc_nr_id}"
 ,	"idc_nr_diainicial":"${idc_indiceJB.idc_indiceT.idc_nr_diainicial}"
 ,	"idc_nr_diafinal":"${idc_indiceJB.idc_indiceT.idc_nr_diafinal}"
 ,	"idc_nr_qtdparcelas":"${idc_indiceJB.idc_indiceT.idc_nr_qtdparcelas}"
 ,	"idc_nr_valor":"${idc_indiceJB.idc_indiceT.idc_nr_valor}"
  }
    }
     
}                                                                                
   
