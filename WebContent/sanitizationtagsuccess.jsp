                                                                                                                                                   
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil" errorPage="notfound.jsp"%>                                                   
<jsp:include page="header.jspf"/>                                                                                                                    
                                                                                                                                                     
<div id="wrapper" style="width: 99%;">                                                                                                               
	<jsp:include page="/toc.jspf"/>                                                                                                                  
   <td valign="top" colspan="3" class="bb">                                                                                                          
		<div class="fl" style="width: 99%;">                                                                                                         
		</span></p>          
		<h3 style="color:green;" style="font-size:16px">Thank You..! Mr/Mrs:  <%
         out.println(request.getAttribute("attId"));
      %> </h3>
		
      
	<p style="font-size:14px">Dear Customer, Your <%
         out.println("email id " + request.getAttribute("attValue"));
      %>has been registered with Altoro Bank & will be reviewed by our Customer Service staff.<br><br>The latest offers and cash backs will be sent to your mail.<br><br>Thank You for banking with Altoro Bank  </p>
		                                                                                                                                                                                                                                                                                                                                                                   
		</div>                                                                                                                                                                                                                                                                      
    </td>                                                                                                                                            
</div>                                                                                                                                               
                                                                                                                                                     
<jsp:include page="footer.jspf"/>  