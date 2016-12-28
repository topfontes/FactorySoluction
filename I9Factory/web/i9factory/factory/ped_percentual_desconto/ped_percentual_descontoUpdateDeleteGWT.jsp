<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ped_percentual_descontoJB" class="br.com.easynet.gwt.i9factory.jb.Ped_percentual_descontoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="*"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="page" value="${pageContext}"/>                                         
${ped_percentual_descontoJB.execute}                                         
{"resultado":
{"msg":"${ped_percentual_descontoJB.msg}",
     "ped_percentual_desconto":{	"ped_nr_id":"${ped_percentual_descontoJB.ped_percentual_descontoT.ped_nr_id}"
 ,	"ped_nr_parcela":"${ped_percentual_descontoJB.ped_percentual_descontoT.ped_nr_parcela}"
 ,	"ped_nr_desconto":"${ped_percentual_descontoJB.ped_percentual_descontoT.ped_nr_desconto}"
  }
    }
     
}                                                                                
   
