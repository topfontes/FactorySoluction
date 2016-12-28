<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ped_percentual_descontoJB" class="br.com.easynet.gwt.i9factory.jb.Ped_percentual_descontoInsertJB" scope="request"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="*"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="page" value="${pageContext}"/>                                         
${ped_percentual_descontoJB.execute}                                         
                                                                               
	
<form name="ped_percentual_desconto" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${ped_percentual_descontoJB.tipoMsg}">${ped_percentual_descontoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('ped_percentual_desconto','insert', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('ped_percentual_desconto','Limpar', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('ped_percentual_desconto','', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoConsult.jsp')" />
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
		ped_nr_parcela:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ped_percentual_descontoT.ped_nr_parcela" value="${ped_percentual_descontoJB.ped_percentual_descontoT.ped_nr_parcela}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ped_nr_desconto:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ped_percentual_descontoT.ped_nr_desconto" value="${ped_percentual_descontoJB.ped_percentual_descontoT.ped_nr_desconto}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('ped_percentual_desconto','insert', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('ped_percentual_desconto','Limpar', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('ped_percentual_desconto','', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
