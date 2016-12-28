<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cco_contacorrenteJB" class="br.com.easynet.gwt.i9factory.jb.Cco_contacorrenteInsertJB" scope="request"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="*"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="page" value="${pageContext}"/>                                         
${cco_contacorrenteJB.execute}                                         
                                                                               
	
<form name="cco_contacorrente" action="portal.jsp" method="post" enctype="multipart/form-data" > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/cco_contacorrente/cco_contacorrenteInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${cco_contacorrenteJB.tipoMsg}">${cco_contacorrenteJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('cco_contacorrente','insert', '/i9factory/factory/cco_contacorrente/cco_contacorrenteInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('cco_contacorrente','Limpar', '/i9factory/factory/cco_contacorrente/cco_contacorrenteInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('cco_contacorrente','', '/i9factory/factory/cco_contacorrente/cco_contacorrenteConsult.jsp')" />
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
		cco_tx_nragencia:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cco_contacorrenteT.cco_tx_nragencia" value="${cco_contacorrenteJB.cco_contacorrenteT.cco_tx_nragencia}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cco_tx_nrcontacorrente:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cco_contacorrenteT.cco_tx_nrcontacorrente" value="${cco_contacorrenteJB.cco_contacorrenteT.cco_tx_nrcontacorrente}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cco_tx_nomecorrentista:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="cco_contacorrenteT.cco_tx_nomecorrentista" value="${cco_contacorrenteJB.cco_contacorrenteT.cco_tx_nomecorrentista}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cco_bt_arqremessabanco:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="file" name="cco_contacorrenteT.cco_bt_arqremessabanco" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="cco_contacorrenteUpdateDelete.jsp?op=downloadImage&cco_contacorrenteT.cco_nr_id=${cco_contacorrenteJB.cco_contacorrenteT.cco_nr_id}&"/>
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cco_bt_arqretornobanco:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="file" name="cco_contacorrenteT.cco_bt_arqretornobanco" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="cco_contacorrenteUpdateDelete.jsp?op=downloadImage&cco_contacorrenteT.cco_nr_id=${cco_contacorrenteJB.cco_contacorrenteT.cco_nr_id}&"/>
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>bco_nr_id:</label>
	</td>
	<td>
	    <select name="cco_contacorrenteT.bco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cco_contacorrenteJB.listbco_banco}" var="item">
            	  <option value="${item.bco_nr_id}">${item.bco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>cli_nr_id:</label>
	</td>
	<td>
	    <select name="cco_contacorrenteT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cco_contacorrenteJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>cor_nr_id:</label>
	</td>
	<td>
	    <select name="cco_contacorrenteT.cor_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cco_contacorrenteJB.listcor_corretora}" var="item">
            	  <option value="${item.cor_nr_id}">${item.cor_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>age_nr_id:</label>
	</td>
	<td>
	    <select name="cco_contacorrenteT.age_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cco_contacorrenteJB.listage_agenciador}" var="item">
            	  <option value="${item.age_nr_id}">${item.age_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('cco_contacorrente','insert', '/i9factory/factory/cco_contacorrente/cco_contacorrenteInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('cco_contacorrente','Limpar', '/i9factory/factory/cco_contacorrente/cco_contacorrenteInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('cco_contacorrente','', '/i9factory/factory/cco_contacorrente/cco_contacorrenteConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
