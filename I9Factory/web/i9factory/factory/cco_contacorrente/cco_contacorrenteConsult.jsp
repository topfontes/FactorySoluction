<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cco_contacorrenteJB" class="br.com.easynet.gwt.i9factory.jb.Cco_contacorrenteConsultJB" scope="request"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="*"/>                                         
<jsp:setProperty name="cco_contacorrenteJB" property="page" value="${pageContext}"/>                                         
${cco_contacorrenteJB.execute}                                         
                                                                                

<form name="cco_contacorrente" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/cco_contacorrente/cco_contacorrenteConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${cco_contacorrenteJB.tipoMsg}">${cco_contacorrenteJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('cco_contacorrente','', '/i9factory/factory/cco_contacorrente/cco_contacorrenteInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('cco_contacorrente','consult', '/i9factory/factory/cco_contacorrente/cco_contacorrenteConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cco_contacorrenteJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Cco_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.cco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cco_tx_nragencia" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.cco_tx_nragencia}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cco_tx_nrcontacorrente" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.cco_tx_nrcontacorrente}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cco_tx_nomecorrentista" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.cco_tx_nomecorrentista}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cco_bt_arqremessabanco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<img border="0" src="/easyportal/i9factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp?op=downloadImage&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cco_bt_arqretornobanco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<img border="0" src="/easyportal/i9factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp?op=downloadImage&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Bco_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.bco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cor_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.cor_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Age_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/cco_contacorrente/cco_contacorrenteUpdateDelete.jsp&op=findbyid&cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&">
      		<c:out value="${item.age_nr_id}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('cco_contacorrente','delete', '/i9factory/factory/cco_contacorrente/cco_contacorrenteConsult.jsp?cco_contacorrenteT.cco_nr_id=${item.cco_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
