<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="emp_emprestimoJB" class="br.com.easynet.gwt.i9factory.jb.Emp_emprestimoConsultJB" scope="request"/>                                         
<jsp:setProperty name="emp_emprestimoJB" property="*"/>                                         
<jsp:setProperty name="emp_emprestimoJB" property="page" value="${pageContext}"/>                                         
${emp_emprestimoJB.execute}                                         
                                                                                

<form name="emp_emprestimo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/emp_emprestimo/emp_emprestimoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${emp_emprestimoJB.tipoMsg}">${emp_emprestimoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('emp_emprestimo','', '/i9factory/factory/emp_emprestimo/emp_emprestimoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('emp_emprestimo','consult', '/i9factory/factory/emp_emprestimo/emp_emprestimoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${emp_emprestimoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.age_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.idc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_dt_emprestimo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<fmt:formatDate value="${item.emp_dt_emprestimo}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_nr_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_status" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_status}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_observacoes" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_observacoes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_dt_aprovacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<fmt:formatDate value="${item.emp_dt_aprovacao}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_dt_liberacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<fmt:formatDate value="${item.emp_dt_liberacao}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_dt_quitacao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<fmt:formatDate value="${item.emp_dt_quitacao}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_dt_enviobanco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<fmt:formatDate value="${item.emp_dt_enviobanco}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_dt_retornobanco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<fmt:formatDate value="${item.emp_dt_retornobanco}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_cdlancamentobanco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_cdlancamentobanco}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_cdlancamentopendente" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_cdlancamentopendente}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_numerocheque" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/emp_emprestimo/emp_emprestimoUpdateDelete.jsp&op=findbyid&emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_numerocheque}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('emp_emprestimo','delete', '/i9factory/factory/emp_emprestimo/emp_emprestimoConsult.jsp?emp_emprestimoT.emp_nr_id=${item.emp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
