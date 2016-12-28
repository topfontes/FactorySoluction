<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="vw_arquivo_retorno_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Vw_arquivo_retorno_bancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="*"/>                                         
<jsp:setProperty name="vw_arquivo_retorno_bancoJB" property="page" value="${pageContext}"/>                                         
${vw_arquivo_retorno_bancoJB.execute}                                         
                                                                                

<form name="vw_arquivo_retorno_banco" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${vw_arquivo_retorno_bancoJB.tipoMsg}">${vw_arquivo_retorno_bancoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('vw_arquivo_retorno_banco','', '/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('vw_arquivo_retorno_banco','consult', '/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${vw_arquivo_retorno_bancoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Teb_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.teb_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Teb_dt_envio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<fmt:formatDate value="${item.teb_dt_envio}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Teb_dt_retorno" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<fmt:formatDate value="${item.teb_dt_retorno}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Teb_tx_status" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.teb_tx_status}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Teb_tx_operacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.teb_tx_operacao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_dt_vencimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<fmt:formatDate value="${item.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_tx_parcela" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_tx_parcela}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_nr_valorparcela" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.ple_nr_valorparcela}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_proposta" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.emp_nr_proposta}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.cli_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('vw_arquivo_retorno_banco','delete', '/i9factory/factory/vw_arquivo_retorno_banco/vw_arquivo_retorno_bancoConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
