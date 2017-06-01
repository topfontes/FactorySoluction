<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="org_orgaoJB" class="br.com.easynet.gwt.i9factory.jb.Org_orgaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="org_orgaoJB" property="*"/>                                         
<jsp:setProperty name="org_orgaoJB" property="page" value="${pageContext}"/>                                         
${org_orgaoJB.execute}                                         
                                                                                

<form name="org_orgao" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/org_orgao/org_orgaoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${org_orgaoJB.tipoMsg}">${org_orgaoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('org_orgao', 'update' , '/i9factory/factory/org_orgao/org_orgaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('org_orgao', 'delete' , '/i9factory/factory/org_orgao/org_orgaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('org_orgao', 'consult', '/i9factory/factory/org_orgao/org_orgaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('org_orgao', 'consult' , '/i9factory/factory/org_orgao/org_orgaoConsult.jsp')" /-->

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
		org_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_nr_id" value="${org_orgaoJB.org_orgaoT.org_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_cnpj:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_cnpj" value="${org_orgaoJB.org_orgaoT.org_tx_cnpj}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_razaosocial:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_razaosocial" value="${org_orgaoJB.org_orgaoT.org_tx_razaosocial}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_nomefantasia:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_nomefantasia" value="${org_orgaoJB.org_orgaoT.org_tx_nomefantasia}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_inscestadual:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_inscestadual" value="${org_orgaoJB.org_orgaoT.org_tx_inscestadual}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_tipologradouro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_tipologradouro" value="${org_orgaoJB.org_orgaoT.org_tx_tipologradouro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_logradouro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_logradouro" value="${org_orgaoJB.org_orgaoT.org_tx_logradouro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_numero:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_numero" value="${org_orgaoJB.org_orgaoT.org_tx_numero}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_cep:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_cep" value="${org_orgaoJB.org_orgaoT.org_tx_cep}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_complemento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_complemento" value="${org_orgaoJB.org_orgaoT.org_tx_complemento}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_bairro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_bairro" value="${org_orgaoJB.org_orgaoT.org_tx_bairro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_municipio:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_municipio" value="${org_orgaoJB.org_orgaoT.org_tx_municipio}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_uf:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_uf" value="${org_orgaoJB.org_orgaoT.org_tx_uf}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_telefone1:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_telefone1" value="${org_orgaoJB.org_orgaoT.org_tx_telefone1}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_tx_telefone2:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="org_orgaoT.org_tx_telefone2" value="${org_orgaoJB.org_orgaoT.org_tx_telefone2}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('org_orgao', 'update' , '/i9factory/factory/org_orgao/org_orgaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('org_orgao', 'delete' , '/i9factory/factory/org_orgao/org_orgaoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('org_orgao', 'consult', '/i9factory/factory/org_orgao/org_orgaoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('org_orgao', 'consult' , '/i9factory/factory/org_orgao/org_orgaoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
