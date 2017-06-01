<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="age_agenciadorJB" class="br.com.easynet.gwt.i9factory.jb.Age_agenciadorConsultJB" scope="request"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="*"/>                                         
<jsp:setProperty name="age_agenciadorJB" property="page" value="${pageContext}"/>                                         
${age_agenciadorJB.execute}                                         
                                                                                

<form name="age_agenciador" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/age_agenciador/age_agenciadorConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${age_agenciadorJB.tipoMsg}">${age_agenciadorJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('age_agenciador','', '/i9factory/factory/age_agenciador/age_agenciadorInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('age_agenciador','consult', '/i9factory/factory/age_agenciador/age_agenciadorConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${age_agenciadorJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Age_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_cpf" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_cpf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_dt_cadastro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<fmt:formatDate value="${item.age_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_dt_nascimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<fmt:formatDate value="${item.age_dt_nascimento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Eqp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.eqp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_tipologradouro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_tipologradouro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_logradouro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_logradouro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_numero" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_numero}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_cep" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_cep}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_complemento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_complemento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_bairro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_municipio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_municipio}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_uf" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_uf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_telefone2" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_telefone2}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_telefone2_1" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_telefone2_1}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_celular" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_celular}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_tx_email" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_tx_email}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_nr_taxaemprestimo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_nr_taxaemprestimo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_nr_taxamensalidade" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/age_agenciador/age_agenciadorUpdateDelete.jsp&op=findbyid&age_agenciadorT.age_nr_id=${item.age_nr_id}&">
      		<c:out value="${item.age_nr_taxamensalidade}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('age_agenciador','delete', '/i9factory/factory/age_agenciador/age_agenciadorConsult.jsp?age_agenciadorT.age_nr_id=${item.age_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
