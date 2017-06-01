<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ped_percentual_descontoJB" class="br.com.easynet.gwt.i9factory.jb.Ped_percentual_descontoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="*"/>                                         
<jsp:setProperty name="ped_percentual_descontoJB" property="page" value="${pageContext}"/>                                         
${ped_percentual_descontoJB.execute}                                         
                                                                                

<form name="ped_percentual_desconto" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${ped_percentual_descontoJB.tipoMsg}">${ped_percentual_descontoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('ped_percentual_desconto','', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('ped_percentual_desconto','consult', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ped_percentual_descontoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ped_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoUpdateDelete.jsp&op=findbyid&ped_percentual_descontoT.ped_nr_id=${item.ped_nr_id}&">
      		<c:out value="${item.ped_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ped_nr_parcela" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoUpdateDelete.jsp&op=findbyid&ped_percentual_descontoT.ped_nr_id=${item.ped_nr_id}&">
      		<c:out value="${item.ped_nr_parcela}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ped_nr_desconto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoUpdateDelete.jsp&op=findbyid&ped_percentual_descontoT.ped_nr_id=${item.ped_nr_id}&">
      		<c:out value="${item.ped_nr_desconto}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('ped_percentual_desconto','delete', '/i9factory/factory/ped_percentual_desconto/ped_percentual_descontoConsult.jsp?ped_percentual_descontoT.ped_nr_id=${item.ped_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
