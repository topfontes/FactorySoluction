<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="tmp_tipomensalidadeJB" class="br.com.easynet.gwt.i9factory.jb.Tmp_tipomensalidadeInsertJB" scope="request"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="*"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="page" value="${pageContext}"/>                                         
${tmp_tipomensalidadeJB.execute}                                         
                                                                               
	
<form name="tmp_tipomensalidade" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${tmp_tipomensalidadeJB.tipoMsg}">${tmp_tipomensalidadeJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('tmp_tipomensalidade','insert', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('tmp_tipomensalidade','Limpar', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('tmp_tipomensalidade','', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeConsult.jsp')" />
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
		tmp_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tmp_tipomensalidadeT.tmp_tx_nome" value="${tmp_tipomensalidadeJB.tmp_tipomensalidadeT.tmp_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		tmp_tx_descricao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tmp_tipomensalidadeT.tmp_tx_descricao" value="${tmp_tipomensalidadeJB.tmp_tipomensalidadeT.tmp_tx_descricao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		tmp_nr_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="tmp_tipomensalidadeT.tmp_nr_valor" value="${tmp_tipomensalidadeJB.tmp_tipomensalidadeT.tmp_nr_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('tmp_tipomensalidade','insert', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('tmp_tipomensalidade','Limpar', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('tmp_tipomensalidade','', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
