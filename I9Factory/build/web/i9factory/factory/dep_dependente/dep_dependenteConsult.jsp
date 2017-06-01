<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="dep_dependenteJB" class="br.com.easynet.gwt.i9factory.jb.Dep_dependenteConsultJB" scope="request"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="*"/>                                         
<jsp:setProperty name="dep_dependenteJB" property="page" value="${pageContext}"/>                                         
${dep_dependenteJB.execute}                                         
                                                                                

<form name="dep_dependente" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/dep_dependente/dep_dependenteConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${dep_dependenteJB.tipoMsg}">${dep_dependenteJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('dep_dependente','', '/i9factory/factory/dep_dependente/dep_dependenteInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('dep_dependente','consult', '/i9factory/factory/dep_dependente/dep_dependenteConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${dep_dependenteJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Dep_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/dep_dependente/dep_dependenteUpdateDelete.jsp&op=findbyid&dep_dependenteT.dep_nr_id=${item.dep_nr_id}&dep_dependenteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.dep_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/dep_dependente/dep_dependenteUpdateDelete.jsp&op=findbyid&dep_dependenteT.dep_nr_id=${item.dep_nr_id}&dep_dependenteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Dep_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/dep_dependente/dep_dependenteUpdateDelete.jsp&op=findbyid&dep_dependenteT.dep_nr_id=${item.dep_nr_id}&dep_dependenteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.dep_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Dep_dt_nascimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/dep_dependente/dep_dependenteUpdateDelete.jsp&op=findbyid&dep_dependenteT.dep_nr_id=${item.dep_nr_id}&dep_dependenteT.cli_nr_id=${item.cli_nr_id}&">
      		<fmt:formatDate value="${item.dep_dt_nascimento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Dep_tx_grauparentesco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/dep_dependente/dep_dependenteUpdateDelete.jsp&op=findbyid&dep_dependenteT.dep_nr_id=${item.dep_nr_id}&dep_dependenteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.dep_tx_grauparentesco}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('dep_dependente','delete', '/i9factory/factory/dep_dependente/dep_dependenteConsult.jsp?dep_dependenteT.dep_nr_id=${item.dep_nr_id}&dep_dependenteT.cli_nr_id=${item.cli_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
