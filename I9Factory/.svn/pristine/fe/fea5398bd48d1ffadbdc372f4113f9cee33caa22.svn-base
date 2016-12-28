<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="idc_indiceJB" class="br.com.easynet.gwt.i9factory.jb.Idc_indiceConsultJB" scope="request"/>                                         
<jsp:setProperty name="idc_indiceJB" property="*"/>                                         
<jsp:setProperty name="idc_indiceJB" property="page" value="${pageContext}"/>                                         
${idc_indiceJB.execute}                                         
                                                                                

<form name="idc_indice" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/i9factory/factory/idc_indice/idc_indiceConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${idc_indiceJB.tipoMsg}">${idc_indiceJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('idc_indice','', '/i9factory/factory/idc_indice/idc_indiceInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('idc_indice','consult', '/i9factory/factory/idc_indice/idc_indiceConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${idc_indiceJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Idc_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp&op=findbyid&idc_indiceT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_diainicial" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp&op=findbyid&idc_indiceT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_diainicial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_diafinal" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp&op=findbyid&idc_indiceT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_diafinal}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_qtdparcelas" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp&op=findbyid&idc_indiceT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_qtdparcelas}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/i9factory/factory/idc_indice/idc_indiceUpdateDelete.jsp&op=findbyid&idc_indiceT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_valor}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('idc_indice','delete', '/i9factory/factory/idc_indice/idc_indiceConsult.jsp?idc_indiceT.idc_nr_id=${item.idc_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
