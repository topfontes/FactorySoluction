<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="tmp_tipomensalidadeJB" class="br.com.easynet.gwt.i9factory.jb.Tmp_tipomensalidadeConsultJB" scope="request"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="*"/>                                         
<jsp:setProperty name="tmp_tipomensalidadeJB" property="page" value="${pageContext}"/>                                         
${tmp_tipomensalidadeJB.execute}                                         
                                                                                

<form name="tmp_tipomensalidade" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${tmp_tipomensalidadeJB.tipoMsg}">${tmp_tipomensalidadeJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('tmp_tipomensalidade','', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('tmp_tipomensalidade','consult', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${tmp_tipomensalidadeJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Tmp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeUpdateDelete.jsp&op=findbyid&tmp_tipomensalidadeT.tmp_nr_id=${item.tmp_nr_id}&">
      		<c:out value="${item.tmp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tmp_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeUpdateDelete.jsp&op=findbyid&tmp_tipomensalidadeT.tmp_nr_id=${item.tmp_nr_id}&">
      		<c:out value="${item.tmp_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tmp_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeUpdateDelete.jsp&op=findbyid&tmp_tipomensalidadeT.tmp_nr_id=${item.tmp_nr_id}&">
      		<c:out value="${item.tmp_tx_descricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tmp_nr_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeUpdateDelete.jsp&op=findbyid&tmp_tipomensalidadeT.tmp_nr_id=${item.tmp_nr_id}&">
      		<c:out value="${item.tmp_nr_valor}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('tmp_tipomensalidade','delete', '/i9factory/factory/tmp_tipomensalidade/tmp_tipomensalidadeConsult.jsp?tmp_tipomensalidadeT.tmp_nr_id=${item.tmp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
