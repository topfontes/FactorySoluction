<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cor_corretoraJB" class="br.com.easynet.gwt.i9factory.jb.Cor_corretoraConsultJB" scope="request"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="*"/>                                         
<jsp:setProperty name="cor_corretoraJB" property="page" value="${pageContext}"/>                                         
${cor_corretoraJB.execute}                                         
                                                                                

<form name="cor_corretora" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/cor_corretora/cor_corretoraConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${cor_corretoraJB.tipoMsg}">${cor_corretoraJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('cor_corretora','', '/i9factory/factory/cor_corretora/cor_corretoraInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('cor_corretora','consult', '/i9factory/factory/cor_corretora/cor_corretoraConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cor_corretoraJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Cor_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_cnpj" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_cnpj}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_razaosocial" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_razaosocial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_nomefantasia" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_nomefantasia}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_inscestadual" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_inscestadual}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_responsavel" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_responsavel}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_tipologradouro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_tipologradouro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_logradouro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_logradouro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_numero" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_numero}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_cep" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_cep}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_complemento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_complemento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_bairro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_municipio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_municipio}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_uf" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_uf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_telefone1" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_telefone1}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_tx_telefone2" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cor_corretora/cor_corretoraUpdateDelete.jsp&op=findbyid&cor_corretoraT.cor_nr_id=${item.cor_nr_id}&">
      		<c:out value="${item.cor_tx_telefone2}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('cor_corretora','delete', '/i9factory/factory/cor_corretora/cor_corretoraConsult.jsp?cor_corretoraT.cor_nr_id=${item.cor_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
