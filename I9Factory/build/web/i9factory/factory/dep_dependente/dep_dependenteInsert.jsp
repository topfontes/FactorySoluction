<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="dep_dependenteJB" class="br.com.easynet.gwt.i9factory.jb.Dep_dependenteInsertJB" scope="request"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="*"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="page" value="${pageContext}"/>                                         
${dep_dependenteJB.execute}                                         
                                                                               
	
<form name="dep_dependente" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/dep_dependente/dep_dependenteInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${dep_dependenteJB.tipoMsg}">${dep_dependenteJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('dep_dependente','insert', '/i9factory/factory/dep_dependente/dep_dependenteInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('dep_dependente','Limpar', '/i9factory/factory/dep_dependente/dep_dependenteInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('dep_dependente','', '/i9factory/factory/dep_dependente/dep_dependenteConsult.jsp')" />
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
	    <select name="dep_dependenteT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${dep_dependenteJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		dep_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="dep_dependenteT.dep_tx_nome" value="${dep_dependenteJB.dep_dependenteT.dep_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		dep_dt_nascimento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="dep_dependenteT.dep_dt_nascimento" value="<fmt:formatDate value="${dep_dependenteJB.dep_dependenteT.dep_dt_nascimento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		dep_tx_grauparentesco:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="dep_dependenteT.dep_tx_grauparentesco" value="${dep_dependenteJB.dep_dependenteT.dep_tx_grauparentesco}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('dep_dependente','insert', '/i9factory/factory/dep_dependente/dep_dependenteInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('dep_dependente','Limpar', '/i9factory/factory/dep_dependente/dep_dependenteInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('dep_dependente','', '/i9factory/factory/dep_dependente/dep_dependenteConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
