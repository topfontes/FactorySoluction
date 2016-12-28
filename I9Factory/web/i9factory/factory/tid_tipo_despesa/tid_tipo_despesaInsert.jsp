<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="tid_tipo_despesaJB" class="br.com.easynet.gwt.i9factory.jb.Tid_tipo_despesaInsertJB" scope="request"/>                                         
<jsp:setProperty name="tid_tipo_despesaJB" property="*"/>                                         
<jsp:setProperty name="tid_tipo_despesaJB" property="page" value="${pageContext}"/>                                         
${tid_tipo_despesaJB.execute}                                         
                                                                               
	
<form name="tid_tipo_despesa" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/tid_tipo_despesa/tid_tipo_despesaInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${tid_tipo_despesaJB.tipoMsg}">${tid_tipo_despesaJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('tid_tipo_despesa','insert', '/i9factory/factory/tid_tipo_despesa/tid_tipo_despesaInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('tid_tipo_despesa','Limpar', '/i9factory/factory/tid_tipo_despesa/tid_tipo_despesaInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('tid_tipo_despesa','', '/i9factory/factory/tid_tipo_despesa/tid_tipo_despesaConsult.jsp')" />
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
		tid_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tid_tipo_despesaT.tid_tx_nome" value="${tid_tipo_despesaJB.tid_tipo_despesaT.tid_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('tid_tipo_despesa','insert', '/i9factory/factory/tid_tipo_despesa/tid_tipo_despesaInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('tid_tipo_despesa','Limpar', '/i9factory/factory/tid_tipo_despesa/tid_tipo_despesaInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('tid_tipo_despesa','', '/i9factory/factory/tid_tipo_despesa/tid_tipo_despesaConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
