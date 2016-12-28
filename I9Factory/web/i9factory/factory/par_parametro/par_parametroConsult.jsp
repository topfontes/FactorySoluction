<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="par_parametroJB" class="br.com.easynet.gwt.i9factory.jb.Par_parametroConsultJB" scope="request"/>                                         
<jsp:setProperty name="par_parametroJB" property="*"/>                                         
<jsp:setProperty name="par_parametroJB" property="page" value="${pageContext}"/>                                         
${par_parametroJB.execute}                                         
                                                                                

<form name="par_parametro" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/par_parametro/par_parametroConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${par_parametroJB.tipoMsg}">${par_parametroJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('par_parametro','', '/i9factory/factory/par_parametro/par_parametroInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('par_parametro','consult', '/i9factory/factory/par_parametro/par_parametroConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${par_parametroJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Par_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/par_parametro/par_parametroUpdateDelete.jsp&op=findbyid&par_parametroT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Par_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/par_parametro/par_parametroUpdateDelete.jsp&op=findbyid&par_parametroT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Par_tx_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/par_parametro/par_parametroUpdateDelete.jsp&op=findbyid&par_parametroT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_tx_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Par_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/par_parametro/par_parametroUpdateDelete.jsp&op=findbyid&par_parametroT.par_nr_id=${item.par_nr_id}&">
      		<c:out value="${item.par_tx_descricao}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('par_parametro','delete', '/i9factory/factory/par_parametro/par_parametroConsult.jsp?par_parametroT.par_nr_id=${item.par_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
