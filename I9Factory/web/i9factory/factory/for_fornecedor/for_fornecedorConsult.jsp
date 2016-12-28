<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="for_fornecedorJB" class="br.com.easynet.gwt.i9factory.jb.For_fornecedorConsultJB" scope="request"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="page" value="${pageContext}"/>                                         
${for_fornecedorJB.execute}                                         
                                                                                

<form name="for_fornecedor" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/for_fornecedor/for_fornecedorConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${for_fornecedorJB.tipoMsg}">${for_fornecedorJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('for_fornecedor','', '/i9factory/factory/for_fornecedor/for_fornecedorInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('for_fornecedor','consult', '/i9factory/factory/for_fornecedor/for_fornecedorConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${for_fornecedorJB.list}"  pagesize="20" >

		<display:column sortable="false" title="For_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_endereco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_endereco}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_cpf_cnpj" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_cpf_cnpj}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_rg_inscricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_rg_inscricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_cep" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_cep}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_cidade" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_cidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_estado" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_estado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_bairro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_email" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_email}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_home_page" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_home_page}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_contato" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_contato}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_status" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_status}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('for_fornecedor','delete', '/i9factory/factory/for_fornecedor/for_fornecedorConsult.jsp?for_fornecedorT.for_nr_id=${item.for_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
