<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ref_referenciaJB" class="br.com.easynet.gwt.i9factory.jb.Ref_referenciaInsertJB" scope="request"/>                                         
<jsp:setProperty name="ref_referenciaJB" property="*"/>                                         
<jsp:setProperty name="ref_referenciaJB" property="page" value="${pageContext}"/>                                         
${ref_referenciaJB.execute}                                         
                                                                               
	
<form name="ref_referencia" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/ref_referencia/ref_referenciaInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${ref_referenciaJB.tipoMsg}">${ref_referenciaJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('ref_referencia','insert', '/i9factory/factory/ref_referencia/ref_referenciaInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('ref_referencia','Limpar', '/i9factory/factory/ref_referencia/ref_referenciaInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('ref_referencia','', '/i9factory/factory/ref_referencia/ref_referenciaConsult.jsp')" />
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
	<td>
		<label>cli_nr_id:</label>
	</td>
	<td>
	    <select name="ref_referenciaT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ref_referenciaJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		ref_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ref_referenciaT.ref_tx_nome" value="${ref_referenciaJB.ref_referenciaT.ref_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ref_tx_telefone:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ref_referenciaT.ref_tx_telefone" value="${ref_referenciaJB.ref_referenciaT.ref_tx_telefone}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ref_tx_celular:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ref_referenciaT.ref_tx_celular" value="${ref_referenciaJB.ref_referenciaT.ref_tx_celular}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('ref_referencia','insert', '/i9factory/factory/ref_referencia/ref_referenciaInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('ref_referencia','Limpar', '/i9factory/factory/ref_referencia/ref_referenciaInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('ref_referencia','', '/i9factory/factory/ref_referencia/ref_referenciaConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
