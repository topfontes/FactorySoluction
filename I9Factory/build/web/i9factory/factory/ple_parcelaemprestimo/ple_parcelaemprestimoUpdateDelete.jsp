<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ple_parcelaemprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Ple_parcelaemprestimoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="*"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="page" value="${pageContext}"/>                                         
${ple_parcelaemprestimoJB.execute}                                         
                                                                                

<form name="ple_parcelaemprestimo" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${ple_parcelaemprestimoJB.tipoMsg}">${ple_parcelaemprestimoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ple_parcelaemprestimo', 'update' , '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('ple_parcelaemprestimo', 'delete' , '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ple_parcelaemprestimo', 'consult', '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('ple_parcelaemprestimo', 'consult' , '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsult.jsp')" /-->

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
		ple_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ple_parcelaemprestimoT.ple_nr_id" value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>emp_nr_id:</label>
	</td>
	<td>
	    <select name="ple_parcelaemprestimoT.emp_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ple_parcelaemprestimoJB.listemp_emprestimo}" var="item">
            	  <option value="${item.emp_nr_id}">${item.emp_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		ple_dt_vencimento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ple_parcelaemprestimoT.ple_dt_vencimento" value="<fmt:formatDate value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_dt_pagamento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ple_parcelaemprestimoT.ple_dt_pagamento" value="<fmt:formatDate value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_dt_pagamento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_nr_valorparcela:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ple_parcelaemprestimoT.ple_nr_valorparcela" value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_valorparcela}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_nr_valordesconto:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ple_parcelaemprestimoT.ple_nr_valordesconto" value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_valordesconto}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_nr_cdformapagto:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ple_parcelaemprestimoT.ple_nr_cdformapagto" value="${ple_parcelaemprestimoJB.ple_parcelaemprestimoT.ple_nr_cdformapagto}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ple_parcelaemprestimo', 'update' , '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('ple_parcelaemprestimo', 'delete' , '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ple_parcelaemprestimo', 'consult', '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('ple_parcelaemprestimo', 'consult' , '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
