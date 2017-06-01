<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.i9factory.jb.Ctp_conta_pagarConsultJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>                                         
${ctp_conta_pagarJB.execute}                                         
                                                                                

<form name="ctp_conta_pagar" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${ctp_conta_pagarJB.tipoMsg}">${ctp_conta_pagarJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('ctp_conta_pagar','', '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('ctp_conta_pagar','consult', '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ctp_conta_pagarJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ctp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_doc" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_nr_doc}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_dt_emissao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<fmt:formatDate value="${item.ctp_dt_emissao}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_dt_vencimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<fmt:formatDate value="${item.ctp_dt_vencimento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_tx_pago" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_tx_pago}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_tx_parcela" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_tx_parcela}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_dt_pagamento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<fmt:formatDate value="${item.ctp_dt_pagamento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_vl_pago" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_vl_pago}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_saldo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_saldo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.for_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_tx_obs" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarUpdateDelete.jsp&op=findbyid&ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&">
      		<c:out value="${item.ctp_tx_obs}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('ctp_conta_pagar','delete', '/i9factory/factory/ctp_conta_pagar/ctp_conta_pagarConsult.jsp?ctp_conta_pagarT.ctp_nr_id=${item.ctp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
