<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.i9factory.jb.Ctp_conta_pagarUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>                                         
${ctp_conta_pagarJB.execute}                                         
                                                                                

<form name="ctp_conta_pagar" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${ctp_conta_pagarJB.tipoMsg}">${ctp_conta_pagarJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ctp_conta_pagar', 'update' , '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('ctp_conta_pagar', 'delete' , '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ctp_conta_pagar', 'consult', '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('ctp_conta_pagar', 'consult' , '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
<br/>
<table width="600" align="left" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
    <table align="left" border="0" width="50%">
    		     <tr>
	<td class="ms-standardheader">
		ctp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_nr_id" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_nr_doc:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_nr_doc" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_doc}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_dt_emissao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_dt_emissao" value="<fmt:formatDate value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_dt_emissao}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_dt_vencimento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_dt_vencimento" value="<fmt:formatDate value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_dt_vencimento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_tx_pago:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_tx_pago" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_pago}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_tx_parcela:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_tx_parcela" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_parcela}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_valor" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_dt_pagamento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_dt_pagamento" value="<fmt:formatDate value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_dt_pagamento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_vl_pago:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_vl_pago" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_vl_pago}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ctp_saldo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_saldo" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_saldo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>for_nr_id:</label>
	</td>
	<td>
	    <select name="ctp_conta_pagarT.for_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ctp_conta_pagarJB.listfor_fornecedor}" var="item">
            	  <option value="${item.for_nr_id}">${item.for_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		ctp_tx_obs:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ctp_conta_pagarT.ctp_tx_obs" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_obs}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ctp_conta_pagar', 'update' , '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('ctp_conta_pagar', 'delete' , '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ctp_conta_pagar', 'consult', '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('ctp_conta_pagar', 'consult' , '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
