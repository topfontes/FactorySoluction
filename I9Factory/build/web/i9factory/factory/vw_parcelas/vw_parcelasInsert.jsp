<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_parcelasJB" class="br.com.easynet.gwt.i9factory.jb.Vw_parcelasInsertJB" scope="request"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="*"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="page" value="${pageContext}"/>                                         
${vw_parcelasJB.execute}                                         
                                                                               
	
<form name="vw_parcelas" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/vw_parcelas/vw_parcelasInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${vw_parcelasJB.tipoMsg}">${vw_parcelasJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('vw_parcelas','insert', '/i9factory/factory/vw_parcelas/vw_parcelasInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('vw_parcelas','Limpar', '/i9factory/factory/vw_parcelas/vw_parcelasInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('vw_parcelas','', '/i9factory/factory/vw_parcelas/vw_parcelasConsult.jsp')" />
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
		ple_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_nr_id" value="${vw_parcelasJB.vw_parcelasT.ple_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.emp_nr_id" value="${vw_parcelasJB.vw_parcelasT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_dt_vencimento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_dt_vencimento" value="<fmt:formatDate value="${vw_parcelasJB.vw_parcelasT.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_dt_pagamento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_dt_pagamento" value="<fmt:formatDate value="${vw_parcelasJB.vw_parcelasT.ple_dt_pagamento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_nr_valorparcela:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_nr_valorparcela" value="${vw_parcelasJB.vw_parcelasT.ple_nr_valorparcela}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_nr_valordesconto:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_nr_valordesconto" value="${vw_parcelasJB.vw_parcelasT.ple_nr_valordesconto}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_nr_cdformapagto:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_nr_cdformapagto" value="${vw_parcelasJB.vw_parcelasT.ple_nr_cdformapagto}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_tx_parcela:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_tx_parcela" value="${vw_parcelasJB.vw_parcelasT.ple_tx_parcela}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ple_tx_tipo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.ple_tx_tipo" value="${vw_parcelasJB.vw_parcelasT.ple_tx_tipo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_dt_emprestimo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.emp_dt_emprestimo" value="<fmt:formatDate value="${vw_parcelasJB.vw_parcelasT.emp_dt_emprestimo}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_proposta:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.emp_nr_proposta" value="${vw_parcelasJB.vw_parcelasT.emp_nr_proposta}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.emp_nr_valor" value="${vw_parcelasJB.vw_parcelasT.emp_nr_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_valor_afin_liquido:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.emp_nr_valor_afin_liquido" value="${vw_parcelasJB.vw_parcelasT.emp_nr_valor_afin_liquido}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cli_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.cli_nr_id" value="${vw_parcelasJB.vw_parcelasT.cli_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		org_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.org_nr_id" value="${vw_parcelasJB.vw_parcelasT.org_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cli_tx_cpf:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.cli_tx_cpf" value="${vw_parcelasJB.vw_parcelasT.cli_tx_cpf}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cli_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.cli_tx_nome" value="${vw_parcelasJB.vw_parcelasT.cli_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cco_tx_nragencia:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.cco_tx_nragencia" value="${vw_parcelasJB.vw_parcelasT.cco_tx_nragencia}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cco_tx_nrcontacorrente:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.cco_tx_nrcontacorrente" value="${vw_parcelasJB.vw_parcelasT.cco_tx_nrcontacorrente}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		bco_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.bco_nr_id" value="${vw_parcelasJB.vw_parcelasT.bco_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		bco_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.bco_tx_nome" value="${vw_parcelasJB.vw_parcelasT.bco_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		bco_tx_codigo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="vw_parcelasT.bco_tx_codigo" value="${vw_parcelasJB.vw_parcelasT.bco_tx_codigo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('vw_parcelas','insert', '/i9factory/factory/vw_parcelas/vw_parcelasInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('vw_parcelas','Limpar', '/i9factory/factory/vw_parcelas/vw_parcelasInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('vw_parcelas','', '/i9factory/factory/vw_parcelas/vw_parcelasConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
