<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="age_agenciadorJB" class="br.com.easynet.gwt.i9factory.jb.Age_agenciadorInsertJB" scope="request"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="*"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="page" value="${pageContext}"/>                                         
${age_agenciadorJB.execute}                                         
                                                                               
	
<form name="age_agenciador" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/age_agenciador/age_agenciadorInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${age_agenciadorJB.tipoMsg}">${age_agenciadorJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('age_agenciador','insert', '/i9factory/factory/age_agenciador/age_agenciadorInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('age_agenciador','Limpar', '/i9factory/factory/age_agenciador/age_agenciadorInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('age_agenciador','', '/i9factory/factory/age_agenciador/age_agenciadorConsult.jsp')" />
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
		age_tx_cpf:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_cpf" value="${age_agenciadorJB.age_agenciadorT.age_tx_cpf}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_nome" value="${age_agenciadorJB.age_agenciadorT.age_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_dt_cadastro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_dt_cadastro" value="<fmt:formatDate value="${age_agenciadorJB.age_agenciadorT.age_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_dt_nascimento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_dt_nascimento" value="<fmt:formatDate value="${age_agenciadorJB.age_agenciadorT.age_dt_nascimento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>eqp_nr_id:</label>
	</td>
	<td>
	    <select name="age_agenciadorT.eqp_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${age_agenciadorJB.listeqp_equipe}" var="item">
            	  <option value="${item.eqp_nr_id}">${item.eqp_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		age_tx_tipologradouro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_tipologradouro" value="${age_agenciadorJB.age_agenciadorT.age_tx_tipologradouro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_logradouro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_logradouro" value="${age_agenciadorJB.age_agenciadorT.age_tx_logradouro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_numero:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_numero" value="${age_agenciadorJB.age_agenciadorT.age_tx_numero}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_cep:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_cep" value="${age_agenciadorJB.age_agenciadorT.age_tx_cep}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_complemento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_complemento" value="${age_agenciadorJB.age_agenciadorT.age_tx_complemento}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_bairro:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_bairro" value="${age_agenciadorJB.age_agenciadorT.age_tx_bairro}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_municipio:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_municipio" value="${age_agenciadorJB.age_agenciadorT.age_tx_municipio}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_uf:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_uf" value="${age_agenciadorJB.age_agenciadorT.age_tx_uf}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_telefone2:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_telefone2" value="${age_agenciadorJB.age_agenciadorT.age_tx_telefone2}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_telefone2_1:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_telefone2_1" value="${age_agenciadorJB.age_agenciadorT.age_tx_telefone2_1}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_celular:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_celular" value="${age_agenciadorJB.age_agenciadorT.age_tx_celular}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_tx_email:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_tx_email" value="${age_agenciadorJB.age_agenciadorT.age_tx_email}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_nr_taxaemprestimo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_nr_taxaemprestimo" value="${age_agenciadorJB.age_agenciadorT.age_nr_taxaemprestimo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		age_nr_taxamensalidade:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="age_agenciadorT.age_nr_taxamensalidade" value="${age_agenciadorJB.age_agenciadorT.age_nr_taxamensalidade}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('age_agenciador','insert', '/i9factory/factory/age_agenciador/age_agenciadorInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('age_agenciador','Limpar', '/i9factory/factory/age_agenciador/age_agenciadorInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('age_agenciador','', '/i9factory/factory/age_agenciador/age_agenciadorConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
