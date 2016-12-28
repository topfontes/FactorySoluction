<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="eqp_equipeJB" class="br.com.easynet.gwt.i9factory.jb.Eqp_equipeConsultJB" scope="request"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="*"/>                                         
<jsp:setProperty name="eqp_equipeJB" property="page" value="${pageContext}"/>                                         
${eqp_equipeJB.execute}                                         
                                                                                

<form name="eqp_equipe" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/eqp_equipe/eqp_equipeConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${eqp_equipeJB.tipoMsg}">${eqp_equipeJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('eqp_equipe','', '/i9factory/factory/eqp_equipe/eqp_equipeInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('eqp_equipe','consult', '/i9factory/factory/eqp_equipe/eqp_equipeConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${eqp_equipeJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Eqp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/eqp_equipe/eqp_equipeUpdateDelete.jsp&op=findbyid&eqp_equipeT.eqp_nr_id=${item.eqp_nr_id}&">
      		<c:out value="${item.eqp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Eqp_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/eqp_equipe/eqp_equipeUpdateDelete.jsp&op=findbyid&eqp_equipeT.eqp_nr_id=${item.eqp_nr_id}&">
      		<c:out value="${item.eqp_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Eqp_tx_descricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/eqp_equipe/eqp_equipeUpdateDelete.jsp&op=findbyid&eqp_equipeT.eqp_nr_id=${item.eqp_nr_id}&">
      		<c:out value="${item.eqp_tx_descricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/eqp_equipe/eqp_equipeUpdateDelete.jsp&op=findbyid&eqp_equipeT.eqp_nr_id=${item.eqp_nr_id}&">
      		<c:out value="${item.cor_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('eqp_equipe','delete', '/i9factory/factory/eqp_equipe/eqp_equipeConsult.jsp?eqp_equipeT.eqp_nr_id=${item.eqp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
