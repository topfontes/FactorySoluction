<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="arb_arquivobancoJB" class="br.com.easynet.gwt.i9factory.jb.Arb_arquivobancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="*"/>                                         
<jsp:setProperty name="arb_arquivobancoJB" property="page" value="${pageContext}"/>                                         
${arb_arquivobancoJB.execute}                                         
                                                                                

<form name="arb_arquivobanco" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/arb_arquivobanco/arb_arquivobancoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${arb_arquivobancoJB.tipoMsg}">${arb_arquivobancoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('arb_arquivobanco','', '/i9factory/factory/arb_arquivobanco/arb_arquivobancoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('arb_arquivobanco','consult', '/i9factory/factory/arb_arquivobanco/arb_arquivobancoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${arb_arquivobancoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Arb_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.arb_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arb_dt_data" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp&op=findbyid&">
      		<fmt:formatDate value="${item.arb_dt_data}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arb_by_arquivo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp&op=findbyid&">
      		<img border="0" src="/easyportal/i9factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp?op=downloadImage&"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Arb_tx_tipo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/arb_arquivobanco/arb_arquivobancoUpdateDelete.jsp&op=findbyid&">
      		<c:out value="${item.arb_tx_tipo}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('arb_arquivobanco','delete', '/i9factory/factory/arb_arquivobanco/arb_arquivobancoConsult.jsp?')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
