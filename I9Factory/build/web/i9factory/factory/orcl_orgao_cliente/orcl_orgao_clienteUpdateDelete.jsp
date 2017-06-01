<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="orcl_orgao_clienteJB" class="br.com.easynet.gwt.i9factory.jb.Orcl_orgao_clienteUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="orcl_orgao_clienteJB" property="*"/>                                         
<jsp:setProperty name="orcl_orgao_clienteJB" property="page" value="${pageContext}"/>                                         
${orcl_orgao_clienteJB.execute}                                         
                                                                                

<form name="orcl_orgao_cliente" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${orcl_orgao_clienteJB.tipoMsg}">${orcl_orgao_clienteJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('orcl_orgao_cliente', 'update' , '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('orcl_orgao_cliente', 'delete' , '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('orcl_orgao_cliente', 'consult', '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('orcl_orgao_cliente', 'consult' , '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsult.jsp')" /-->

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
		orcl_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="orcl_orgao_clienteT.orcl_nr_id" value="${orcl_orgao_clienteJB.orcl_orgao_clienteT.orcl_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>cli_nr_id:</label>
	</td>
	<td>
	    <select name="orcl_orgao_clienteT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${orcl_orgao_clienteJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>org_nr_id:</label>
	</td>
	<td>
	    <select name="orcl_orgao_clienteT.org_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${orcl_orgao_clienteJB.listorg_orgao}" var="item">
            	  <option value="${item.org_nr_id}">${item.org_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('orcl_orgao_cliente', 'update' , '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('orcl_orgao_cliente', 'delete' , '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('orcl_orgao_cliente', 'consult', '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('orcl_orgao_cliente', 'consult' , '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
