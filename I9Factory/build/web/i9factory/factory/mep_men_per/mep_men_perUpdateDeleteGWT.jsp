<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="mep_men_perJB" class="br.com.easynet.gwt.i9factory.jb.Mep_men_perUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="mep_men_perJB" property="*"/>                                         
<jsp:setProperty name="mep_men_perJB" property="page" value="${pageContext}"/>                                         
${mep_men_perJB.execute}
{"resultado":"${mep_men_perJB.msg}"}