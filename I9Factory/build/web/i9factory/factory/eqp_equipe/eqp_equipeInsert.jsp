<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="eqp_equipeJB" class="br.com.easynet.gwt.i9factory.jb.Eqp_equipeInsertJB" scope="request"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="*"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="page" value="${pageContext}"/>                                         
${eqp_equipeJB.execute}                                         
                                                                               
	
<form name="eqp_equipe" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/eqp_equipe/eqp_equipeInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${eqp_equipeJB.tipoMsg}">${eqp_equipeJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('eqp_equipe','insert', '/i9factory/factory/eqp_equipe/eqp_equipeInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('eqp_equipe','Limpar', '/i9factory/factory/eqp_equipe/eqp_equipeInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('eqp_equipe','', '/i9factory/factory/eqp_equipe/eqp_equipeConsult.jsp')" />
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
		eqp_tx_nome:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="eqp_equipeT.eqp_tx_nome" value="${eqp_equipeJB.eqp_equipeT.eqp_tx_nome}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		eqp_tx_descricao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="eqp_equipeT.eqp_tx_descricao" value="${eqp_equipeJB.eqp_equipeT.eqp_tx_descricao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>cor_nr_id:</label>
	</td>
	<td>
	    <select name="eqp_equipeT.cor_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${eqp_equipeJB.listcor_corretora}" var="item">
            	  <option value="${item.cor_nr_id}">${item.cor_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('eqp_equipe','insert', '/i9factory/factory/eqp_equipe/eqp_equipeInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('eqp_equipe','Limpar', '/i9factory/factory/eqp_equipe/eqp_equipeInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('eqp_equipe','', '/i9factory/factory/eqp_equipe/eqp_equipeConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
