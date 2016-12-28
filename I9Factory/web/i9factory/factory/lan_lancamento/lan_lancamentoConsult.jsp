<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="lan_lancamentoJB" class="br.com.easynet.gwt.i9factory.jb.Lan_lancamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="*"/>                                         
<jsp:setProperty name="lan_lancamentoJB" property="page" value="${pageContext}"/>                                         
${lan_lancamentoJB.execute}                                         
                                                                                

<form name="lan_lancamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/lan_lancamento/lan_lancamentoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${lan_lancamentoJB.tipoMsg}">${lan_lancamentoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('lan_lancamento','', '/i9factory/factory/lan_lancamento/lan_lancamentoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('lan_lancamento','consult', '/i9factory/factory/lan_lancamento/lan_lancamentoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${lan_lancamentoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Lan_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.lan_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctr_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.ctr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ctp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.ctp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Lan_plc_nr_id_deb" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.lan_plc_nr_id_deb}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Lan_plc_nr_id_cred" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.lan_plc_nr_id_cred}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Lan_dt_lancamento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<fmt:formatDate value="${item.lan_dt_lancamento}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Lan_tx_historico" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.lan_tx_historico}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Lan_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.lan_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Lan_nr_id_super" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/lan_lancamento/lan_lancamentoUpdateDelete.jsp&op=findbyid&lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&">
      		<c:out value="${item.lan_nr_id_super}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('lan_lancamento','delete', '/i9factory/factory/lan_lancamento/lan_lancamentoConsult.jsp?lan_lancamentoT.lan_nr_id=${item.lan_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
