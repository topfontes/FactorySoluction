<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="arb_arquivobancoJB" class="br.com.easynet.gwt.i9factory.jb.Arb_arquivobancoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="*"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="page" value="${pageContext}"/>                                         
${arb_arquivobancoJB.execute}                                         
                                                                                

<form name="arb_arquivobanco" action="portal.jsp" method="post" enctype="multipart/form-data" >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alterac�o ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${arb_arquivobancoJB.tipoMsg}">${arb_arquivobancoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arb_arquivobanco', 'update' , '/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('arb_arquivobanco', 'delete' , '/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arb_arquivobanco', 'consult', '/i9factory/factory/arb_arquivobanco/arb_arquivobancoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('arb_arquivobanco', 'consult' , '/i9factory/factory/arb_arquivobanco/arb_arquivobancoConsult.jsp')" /-->

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
		arb_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arb_arquivobancoT.arb_nr_id" value="${arb_arquivobancoJB.arb_arquivobancoT.arb_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arb_dt_data:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arb_arquivobancoT.arb_dt_data" value="<fmt:formatDate value="${arb_arquivobancoJB.arb_arquivobancoT.arb_dt_data}" pattern="dd/MM/yyyy HH:mm"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arb_by_arquivo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="file" name="arb_arquivobancoT.arb_by_arquivo" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="arb_arquivobancoUpdateDelete.jsp?op=downloadImage&"/>
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		arb_tx_tipo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="arb_arquivobancoT.arb_tx_tipo" value="${arb_arquivobancoJB.arb_arquivobancoT.arb_tx_tipo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arb_arquivobanco', 'update' , '/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('arb_arquivobanco', 'delete' , '/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('arb_arquivobanco', 'consult', '/i9factory/factory/arb_arquivobanco/arb_arquivobancoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('arb_arquivobanco', 'consult' , '/i9factory/factory/arb_arquivobanco/arb_arquivobancoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
