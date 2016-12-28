<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="vw_parcelasJB" class="br.com.easynet.gwt.i9factory.jb.Vw_parcelasConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="*"/>                                         
<jsp:setProperty name="vw_parcelasJB" property="page" value="${pageContext}"/>                                         
${vw_parcelasJB.execute}                                         
                                                                                

<form name="vw_parcelas" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/vw_parcelas/vw_parcelasConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${vw_parcelasJB.tipoMsg}">${vw_parcelasJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('vw_parcelas','', '/i9factory/factory/vw_parcelas/vw_parcelasInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('vw_parcelas','consult', '/i9factory/factory/vw_parcelas/vw_parcelasConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${vw_parcelasJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ple_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_dt_vencimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<fmt:formatDate value="${item.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_dt_pagamento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<fmt:formatDate value="${item.ple_dt_pagamento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_nr_valorparcela" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_nr_valorparcela}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_nr_valordesconto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_nr_valordesconto}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_nr_cdformapagto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_nr_cdformapagto}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_tx_parcela" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_tx_parcela}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_tx_tipo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_tx_tipo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_dt_emprestimo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<fmt:formatDate value="${item.emp_dt_emprestimo}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_proposta" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.emp_nr_proposta}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.emp_nr_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_valor_afin_liquido" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.emp_nr_valor_afin_liquido}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Org_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.org_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_cpf" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cli_tx_cpf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cli_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cco_tx_nragencia" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cco_tx_nragencia}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cco_tx_nrcontacorrente" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cco_tx_nrcontacorrente}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.bco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.bco_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_tx_codigo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_parcelas/vw_parcelasUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.bco_tx_codigo}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('vw_parcelas','delete', '/i9factory/factory/vw_parcelas/vw_parcelasConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
