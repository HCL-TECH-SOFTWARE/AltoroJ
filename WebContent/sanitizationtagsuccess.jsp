                                                                                                                                                     
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil" errorPage="notfound.jsp"%>                                                   
<jsp:include page="header.jspf"/>                                                                                                                    
                                                                                                                                                     
<div id="wrapper" style="width: 99%;">                                                                                                               
	<jsp:include page="/toc.jspf"/>                                                                                                                  
   <td valign="top" colspan="3" class="bb">                                                                                                          
		<div class="fl" style="width: 99%;">                                                                                                         
		</span></p>          
		<% String k = (String) request.getAttribute("attId"); 
		String p = (String) request.getAttribute("attValue");
   out.write("<input type='text' id='"+k+"' value='check the id' />");
   out.write("<p>" + p + "</p>");
%>                                                                                                                                                                                                                                                                                                                                                                                                
		</div>                                                                                                                                                                                                                                                                      
    </td>                                                                                                                                            
</div>                                                                                                                                               
                                                                                                                                                     
<jsp:include page="footer.jspf"/>                                                                                                                    