<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="bco_bancoJB" class="br.com.easynet.gwt.i9factory.jb.Bco_bancoConsultJB" scope="request"/>                                         
<jsp:setProperty name="bco_bancoJB" property="*"/>                                         
<jsp:setProperty name="bco_bancoJB" property="page" value="${pageContext}"/>                                         
${bco_bancoJB.execute}                                         
                                                                                

<form name="bco_banco" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/bco_banco/bco_bancoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${bco_bancoJB.tipoMsg}">${bco_bancoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
      <td width="100" nowrap="nowrap">  <div align="left" <class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('bco_banco','', '/i9factory/factory/bco_banco/bco_bancoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('bco_banco','consult', '/i9factory/factory/bco_banco/bco_bancoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td align="right" nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${bco_bancoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Bco_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/bco_banco/bco_bancoUpdateDelete.jsp&op=findbyid&bco_bancoT.bco_nr_id=${item.bco_nr_id}&">
      		<c:out value="${item.bco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_tx_nome" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/bco_banco/bco_bancoUpdateDelete.jsp&op=findbyid&bco_bancoT.bco_nr_id=${item.bco_nr_id}&">
      		<c:out value="${item.bco_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_tx_telefone1" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/bco_banco/bco_bancoUpdateDelete.jsp&op=findbyid&bco_bancoT.bco_nr_id=${item.bco_nr_id}&">
      		<c:out value="${item.bco_tx_telefone1}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_tx_telefone2" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/bco_banco/bco_bancoUpdateDelete.jsp&op=findbyid&bco_bancoT.bco_nr_id=${item.bco_nr_id}&">
      		<c:out value="${item.bco_tx_telefone2}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_tx_nomecontato" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/bco_banco/bco_bancoUpdateDelete.jsp&op=findbyid&bco_bancoT.bco_nr_id=${item.bco_nr_id}&">
      		<c:out value="${item.bco_tx_nomecontato}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('bco_banco','delete', '/i9factory/factory/bco_banco/bco_bancoConsult.jsp?bco_bancoT.bco_nr_id=${item.bco_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
