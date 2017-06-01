<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="lan_lancamentoJB" class="br.com.easynet.gwt.i9factory.jb.Lan_lancamentoInsertJB" scope="request"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="*"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="page" value="${pageContext}"/>                                         
${lan_lancamentoJB.execute}                                         
                                                                               
	
<form name="lan_lancamento" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/lan_lancamento/lan_lancamentoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${lan_lancamentoJB.tipoMsg}">${lan_lancamentoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('lan_lancamento','insert', '/i9factory/factory/lan_lancamento/lan_lancamentoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('lan_lancamento','Limpar', '/i9factory/factory/lan_lancamento/lan_lancamentoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('lan_lancamento','', '/i9factory/factory/lan_lancamento/lan_lancamentoConsult.jsp')" />
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
		ctr_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="lan_lancamentoT.ctr_nr_id" value="${lan_lancamentoJB.lan_lancamentoT.ctr_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>ctp_nr_id:</label>
	</td>
	<td>
	    <select name="lan_lancamentoT.ctp_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${lan_lancamentoJB.listctp_conta_pagar}" var="item">
            	  <option value="${item.ctp_nr_id}">${item.ctp_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		lan_plc_nr_id_deb:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="lan_lancamentoT.lan_plc_nr_id_deb" value="${lan_lancamentoJB.lan_lancamentoT.lan_plc_nr_id_deb}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		lan_plc_nr_id_cred:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="lan_lancamentoT.lan_plc_nr_id_cred" value="${lan_lancamentoJB.lan_lancamentoT.lan_plc_nr_id_cred}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		lan_dt_lancamento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="lan_lancamentoT.lan_dt_lancamento" value="<fmt:formatDate value="${lan_lancamentoJB.lan_lancamentoT.lan_dt_lancamento}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		lan_tx_historico:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="lan_lancamentoT.lan_tx_historico" value="${lan_lancamentoJB.lan_lancamentoT.lan_tx_historico}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		lan_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="lan_lancamentoT.lan_valor" value="${lan_lancamentoJB.lan_lancamentoT.lan_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		lan_nr_id_super:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="lan_lancamentoT.lan_nr_id_super" value="${lan_lancamentoJB.lan_lancamentoT.lan_nr_id_super}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('lan_lancamento','insert', '/i9factory/factory/lan_lancamento/lan_lancamentoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('lan_lancamento','Limpar', '/i9factory/factory/lan_lancamento/lan_lancamentoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('lan_lancamento','', '/i9factory/factory/lan_lancamento/lan_lancamentoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
