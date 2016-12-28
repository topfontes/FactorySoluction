<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="emp_emprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Emp_emprestimoInsertJB" scope="request"/>                                         
<jsp:setProperty name="emp_emprestimoJB" property="*"/>                                         
<jsp:setProperty name="emp_emprestimoJB" property="page" value="${pageContext}"/>                                         
${emp_emprestimoJB.execute}                                         
                                                                               
	
<form name="emp_emprestimo" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/emp_emprestimo/emp_emprestimoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${emp_emprestimoJB.tipoMsg}">${emp_emprestimoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('emp_emprestimo','insert', '/i9factory/factory/emp_emprestimo/emp_emprestimoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('emp_emprestimo','Limpar', '/i9factory/factory/emp_emprestimo/emp_emprestimoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('emp_emprestimo','', '/i9factory/factory/emp_emprestimo/emp_emprestimoConsult.jsp')" />
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
	    <select name="emp_emprestimoT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${emp_emprestimoJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>age_nr_id:</label>
	</td>
	<td>
	    <select name="emp_emprestimoT.age_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${emp_emprestimoJB.listage_agenciador}" var="item">
            	  <option value="${item.age_nr_id}">${item.age_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>idc_nr_id:</label>
	</td>
	<td>
	    <select name="emp_emprestimoT.idc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${emp_emprestimoJB.listidc_indice}" var="item">
            	  <option value="${item.idc_nr_id}">${item.idc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		emp_dt_emprestimo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_dt_emprestimo" value="<fmt:formatDate value="${emp_emprestimoJB.emp_emprestimoT.emp_dt_emprestimo}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_nr_valor" value="${emp_emprestimoJB.emp_emprestimoT.emp_nr_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_tx_status:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_tx_status" value="${emp_emprestimoJB.emp_emprestimoT.emp_tx_status}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_tx_observacoes:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_tx_observacoes" value="${emp_emprestimoJB.emp_emprestimoT.emp_tx_observacoes}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_dt_aprovacao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_dt_aprovacao" value="<fmt:formatDate value="${emp_emprestimoJB.emp_emprestimoT.emp_dt_aprovacao}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_dt_liberacao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_dt_liberacao" value="<fmt:formatDate value="${emp_emprestimoJB.emp_emprestimoT.emp_dt_liberacao}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_dt_quitacao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_dt_quitacao" value="<fmt:formatDate value="${emp_emprestimoJB.emp_emprestimoT.emp_dt_quitacao}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_dt_enviobanco:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_dt_enviobanco" value="<fmt:formatDate value="${emp_emprestimoJB.emp_emprestimoT.emp_dt_enviobanco}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_dt_retornobanco:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_dt_retornobanco" value="<fmt:formatDate value="${emp_emprestimoJB.emp_emprestimoT.emp_dt_retornobanco}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_tx_cdlancamentobanco:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_tx_cdlancamentobanco" value="${emp_emprestimoJB.emp_emprestimoT.emp_tx_cdlancamentobanco}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_tx_cdlancamentopendente:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_tx_cdlancamentopendente" value="${emp_emprestimoJB.emp_emprestimoT.emp_tx_cdlancamentopendente}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_tx_numerocheque:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="emp_emprestimoT.emp_tx_numerocheque" value="${emp_emprestimoJB.emp_emprestimoT.emp_tx_numerocheque}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('emp_emprestimo','insert', '/i9factory/factory/emp_emprestimo/emp_emprestimoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('emp_emprestimo','Limpar', '/i9factory/factory/emp_emprestimo/emp_emprestimoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('emp_emprestimo','', '/i9factory/factory/emp_emprestimo/emp_emprestimoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
