<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="res_restricaoJB" class="br.com.easynet.gwt.i9factory.jb.Res_restricaoInsertJB" scope="request"/>                                         
<jsp:setProperty name="res_restricaoJB" property="*"/>                                         
<jsp:setProperty name="res_restricaoJB" property="page" value="${pageContext}"/>                                         
${res_restricaoJB.execute}                                         
                                                                               
	
<form name="res_restricao" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/res_restricao/res_restricaoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${res_restricaoJB.tipoMsg}">${res_restricaoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('res_restricao','insert', '/i9factory/factory/res_restricao/res_restricaoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('res_restricao','Limpar', '/i9factory/factory/res_restricao/res_restricaoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('res_restricao','', '/i9factory/factory/res_restricao/res_restricaoConsult.jsp')" />
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
		res_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="res_restricaoT.res_tx_nome" value="${res_restricaoJB.res_restricaoT.res_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>cli_nr_id:</label>
	</td>
	<td>
	    <select name="res_restricaoT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${res_restricaoJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('res_restricao','insert', '/i9factory/factory/res_restricao/res_restricaoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('res_restricao','Limpar', '/i9factory/factory/res_restricao/res_restricaoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('res_restricao','', '/i9factory/factory/res_restricao/res_restricaoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
