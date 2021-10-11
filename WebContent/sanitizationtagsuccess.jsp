                                                                                                                                                     
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil" errorPage="notfound.jsp"%>                                                   
<jsp:include page="header.jspf"/>                                                                                                                    
                                                                                                                                                     
<div id="wrapper" style="width: 99%;">                                                                                                               
	<jsp:include page="/toc.jspf"/>                                                                                                                  
   <td valign="top" colspan="3" class="bb">                                                                                                          
		<div class="fl" style="width: 99%;">                                                                                                         
		</span></p>          
		<h3 style="color:green;" style="font-size:16px">Thank You..!  <br> Mr/Mrs:  <%
         out.println(request.getParameter("name"));
      %> </h3>
		
      
	<p style="font-size:14px">Dear Customer, Your <%
         out.println("Email ID: " + request.getParameter("email"));
      %>has been registered with Altoro Bank & will be reviewed by our Customer Service staff. The latest offers & cashbacks will be sent to your mail.  </p>
		                                                                                                                                                                                                                                                                                                                                                                   
		</div>                                                                                                                                                                                                                                                                      
    </td>                                                                                                                                            
</div>                                                                                                                                               
                                                                                                                                                     
<jsp:include page="footer.jspf"/>                                                                                                                    