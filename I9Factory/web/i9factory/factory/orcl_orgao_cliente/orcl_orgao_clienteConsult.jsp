<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="orcl_orgao_clienteJB" class="br.com.easynet.gwt.i9factory.jb.Orcl_orgao_clienteConsultJB" scope="request"/>                                         
<jsp:setProperty name="orcl_orgao_clienteJB" property="*"/>                                         
<jsp:setProperty name="orcl_orgao_clienteJB" property="page" value="${pageContext}"/>                                         
${orcl_orgao_clienteJB.execute}                                         
                                                                                

<form name="orcl_orgao_cliente" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${orcl_orgao_clienteJB.tipoMsg}">${orcl_orgao_clienteJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('orcl_orgao_cliente','', '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('orcl_orgao_cliente','consult', '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${orcl_orgao_clienteJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Orcl_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp&op=findbyid&orcl_orgao_clienteT.orcl_nr_id=${item.orcl_nr_id}&">
      		<c:out value="${item.orcl_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp&op=findbyid&orcl_orgao_clienteT.orcl_nr_id=${item.orcl_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Org_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteUpdateDelete.jsp&op=findbyid&orcl_orgao_clienteT.orcl_nr_id=${item.orcl_nr_id}&">
      		<c:out value="${item.org_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('orcl_orgao_cliente','delete', '/i9factory/factory/orcl_orgao_cliente/orcl_orgao_clienteConsult.jsp?orcl_orgao_clienteT.orcl_nr_id=${item.orcl_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
