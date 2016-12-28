<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ple_parcelaemprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Ple_parcelaemprestimoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="*"/>                                         
<jsp:setProperty name="ple_parcelaemprestimoJB" property="page" value="${pageContext}"/>                                         
${ple_parcelaemprestimoJB.execute}                                         
                                                                                

<form name="ple_parcelaemprestimo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${ple_parcelaemprestimoJB.tipoMsg}">${ple_parcelaemprestimoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('ple_parcelaemprestimo','', '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('ple_parcelaemprestimo','consult', '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ple_parcelaemprestimoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ple_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp&op=findbyid&ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&">
      		<c:out value="${item.ple_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp&op=findbyid&ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_dt_vencimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp&op=findbyid&ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&">
      		<fmt:formatDate value="${item.ple_dt_vencimento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_dt_pagamento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp&op=findbyid&ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&">
      		<fmt:formatDate value="${item.ple_dt_pagamento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_nr_valorparcela" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp&op=findbyid&ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&">
      		<c:out value="${item.ple_nr_valorparcela}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_nr_valordesconto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp&op=findbyid&ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&">
      		<c:out value="${item.ple_nr_valordesconto}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ple_nr_cdformapagto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoUpdateDelete.jsp&op=findbyid&ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&">
      		<c:out value="${item.ple_nr_cdformapagto}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('ple_parcelaemprestimo','delete', '/i9factory/factory/ple_parcelaemprestimo/ple_parcelaemprestimoConsult.jsp?ple_parcelaemprestimoT.ple_nr_id=${item.ple_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
