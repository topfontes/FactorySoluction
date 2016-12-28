<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cli_clienteJB" class="br.com.easynet.gwt.i9factory.jb.Cli_clienteConsultJB" scope="request"/>                                         
<jsp:setProperty name="cli_clienteJB" property="*"/>                                         
<jsp:setProperty name="cli_clienteJB" property="page" value="${pageContext}"/>                                         
${cli_clienteJB.execute}                                         
                                                                                

<form name="cli_cliente" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/cli_cliente/cli_clienteConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${cli_clienteJB.tipoMsg}">${cli_clienteJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('cli_cliente','', '/i9factory/factory/cli_cliente/cli_clienteInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('cli_cliente','consult', '/i9factory/factory/cli_cliente/cli_clienteConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cli_clienteJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Cli_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_cpf" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_cpf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_rg" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_rg}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_matricula" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_matricula}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_sexo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_sexo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_estadocivil" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_estadocivil}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_tipologradouro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_tipologradouro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_logradouro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_logradouro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_numero" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_numero}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_cep" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_cep}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_complemento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_complemento}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_bairro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_municipio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_municipio}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_uf" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_uf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_email" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_email}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_telefone1" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_telefone1}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_telefone2" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_telefone2}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_celular" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_celular}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_ramal" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_ramal}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_dt_nascimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<fmt:formatDate value="${item.cli_dt_nascimento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_bt_foto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<img border="0" src="/easyportal/i9factory/cli_cliente/cli_clienteUpdateDelete.jsp?op=downloadImage&cli_clienteT.cli_nr_id=${item.cli_nr_id}&"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_dt_cadastro" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<fmt:formatDate value="${item.cli_dt_cadastro}" pattern="dd/MM/yyyy HH:mm"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_socio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_socio}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Org_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.org_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Tmp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.tmp_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('cli_cliente','delete', '/i9factory/factory/cli_cliente/cli_clienteConsult.jsp?cli_clienteT.cli_nr_id=${item.cli_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
