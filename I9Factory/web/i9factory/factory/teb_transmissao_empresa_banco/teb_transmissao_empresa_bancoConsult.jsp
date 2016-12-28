<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="teb_transmissao_empresa_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Teb_transmissao_empresa_bancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="teb_transmissao_empresa_bancoJB" property="*"/>                                         
<jsp:setProperty name="teb_transmissao_empresa_bancoJB" property="page" value="${pageContext}"/>                                         
${teb_transmissao_empresa_bancoJB.execute}                                         
                                                                                

<form name="teb_transmissao_empresa_banco" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${teb_transmissao_empresa_bancoJB.tipoMsg}">${teb_transmissao_empresa_bancoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('teb_transmissao_empresa_banco','', '/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('teb_transmissao_empresa_banco','consult', '/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${teb_transmissao_empresa_bancoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Teb_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoUpdateDelete.jsp&op=findbyid&teb_transmissao_empresa_bancoT.teb_dt_envio=${item.teb_dt_envio}&">
      		<c:out value="${item.teb_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Teb_dt_envio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoUpdateDelete.jsp&op=findbyid&teb_transmissao_empresa_bancoT.teb_dt_envio=${item.teb_dt_envio}&">
      		<fmt:formatDate value="${item.teb_dt_envio}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Teb_dt_retorno" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoUpdateDelete.jsp&op=findbyid&teb_transmissao_empresa_bancoT.teb_dt_envio=${item.teb_dt_envio}&">
      		<fmt:formatDate value="${item.teb_dt_retorno}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Teb_tx_status" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoUpdateDelete.jsp&op=findbyid&teb_transmissao_empresa_bancoT.teb_dt_envio=${item.teb_dt_envio}&">
      		<c:out value="${item.teb_tx_status}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('teb_transmissao_empresa_banco','delete', '/i9factory/factory/teb_transmissao_empresa_banco/teb_transmissao_empresa_bancoConsult.jsp?teb_transmissao_empresa_bancoT.teb_dt_envio=${item.teb_dt_envio}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
