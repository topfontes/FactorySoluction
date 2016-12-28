<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cor_corretoraJB" class="br.com.easynet.gwt.i9factory.jb.Cor_corretoraInsertJB" scope="request"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="*"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="page" value="${pageContext}"/>                                         
${cor_corretoraJB.execute}                                         
                                                                               
	
<form name="cor_corretora" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/cor_corretora/cor_corretoraInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${cor_corretoraJB.tipoMsg}">${cor_corretoraJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('cor_corretora','insert', '/i9factory/factory/cor_corretora/cor_corretoraInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('cor_corretora','Limpar', '/i9factory/factory/cor_corretora/cor_corretoraInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('cor_corretora','', '/i9factory/factory/cor_corretora/cor_corretoraConsult.jsp')" />
    </div></td>
  </tr>
</table>
<br/>
<table align="left" width="600" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
	<table align="left" width="50%" border="0">
	         <tr>
	<td class="ms-standardheader">
		cor_tx_cnpj:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_cnpj" value="${cor_corretoraJB.cor_corretoraT.cor_tx_cnpj}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_razaosocial:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_razaosocial" value="${cor_corretoraJB.cor_corretoraT.cor_tx_razaosocial}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_nomefantasia:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_nomefantasia" value="${cor_corretoraJB.cor_corretoraT.cor_tx_nomefantasia}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_inscestadual:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_inscestadual" value="${cor_corretoraJB.cor_corretoraT.cor_tx_inscestadual}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_responsavel:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_responsavel" value="${cor_corretoraJB.cor_corretoraT.cor_tx_responsavel}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_tipologradouro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_tipologradouro" value="${cor_corretoraJB.cor_corretoraT.cor_tx_tipologradouro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_logradouro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_logradouro" value="${cor_corretoraJB.cor_corretoraT.cor_tx_logradouro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_numero:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_numero" value="${cor_corretoraJB.cor_corretoraT.cor_tx_numero}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_cep:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_cep" value="${cor_corretoraJB.cor_corretoraT.cor_tx_cep}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_complemento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_complemento" value="${cor_corretoraJB.cor_corretoraT.cor_tx_complemento}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_bairro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_bairro" value="${cor_corretoraJB.cor_corretoraT.cor_tx_bairro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_municipio:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_municipio" value="${cor_corretoraJB.cor_corretoraT.cor_tx_municipio}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_uf:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_uf" value="${cor_corretoraJB.cor_corretoraT.cor_tx_uf}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_telefone1:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_telefone1" value="${cor_corretoraJB.cor_corretoraT.cor_tx_telefone1}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cor_tx_telefone2:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cor_corretoraT.cor_tx_telefone2" value="${cor_corretoraJB.cor_corretoraT.cor_tx_telefone2}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('cor_corretora','insert', '/i9factory/factory/cor_corretora/cor_corretoraInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('cor_corretora','Limpar', '/i9factory/factory/cor_corretora/cor_corretoraInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('cor_corretora','', '/i9factory/factory/cor_corretora/cor_corretoraConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
