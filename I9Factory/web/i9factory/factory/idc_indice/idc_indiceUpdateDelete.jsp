<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="idc_indiceJB" class="br.com.easynet.gwt.i9factory.jb.Idc_indiceUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="idc_indiceJB" property="*"/>                                         
<jsp:setProperty name="idc_indiceJB" property="page" value="${pageContext}"/>                                         
${idc_indiceJB.execute}                                         
                                                                                

<form name="idc_indice" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${idc_indiceJB.tipoMsg}">${idc_indiceJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('idc_indice', 'update' , '/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('idc_indice', 'delete' , '/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('idc_indice', 'consult', '/i9factory/factory/idc_indice/idc_indiceConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('idc_indice', 'consult' , '/i9factory/factory/idc_indice/idc_indiceConsult.jsp')" /-->

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
		idc_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indiceT.idc_nr_id" value="${idc_indiceJB.idc_indiceT.idc_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_diainicial:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indiceT.idc_nr_diainicial" value="${idc_indiceJB.idc_indiceT.idc_nr_diainicial}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_diafinal:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indiceT.idc_nr_diafinal" value="${idc_indiceJB.idc_indiceT.idc_nr_diafinal}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_qtdparcelas:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indiceT.idc_nr_qtdparcelas" value="${idc_indiceJB.idc_indiceT.idc_nr_qtdparcelas}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indiceT.idc_nr_valor" value="${idc_indiceJB.idc_indiceT.idc_nr_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('idc_indice', 'update' , '/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('idc_indice', 'delete' , '/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('idc_indice', 'consult', '/i9factory/factory/idc_indice/idc_indiceConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('idc_indice', 'consult' , '/i9factory/factory/idc_indice/idc_indiceConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
