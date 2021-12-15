                                                                                                                                                     
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil" errorPage="notfound.jsp"%>                                                   
<jsp:include page="header.jspf"/>                                                                                                                    
                                                                                                                                                     
<div id="wrapper" style="width: 99%;">                                                                                                               
	<jsp:include page="/toc.jspf"/>                                                                                                                  
    
    
    <td valign="top" colspan="3" class="bb">                                                                                                          
		<div class="fl" style="width: 99%;">                                                                                                         
		</span></p>
		
		<h3 style="color:green;" style="font-size:16px" >Thank You..!  <br> Mr/Mrs:  
		<% String name = (String) request.getAttribute("attId"); 
		
    	out.println(name);
   		
		%></h3>

		<p style="font-size:14px">Dear Customer, Your 
		<% String emailId = (String) request.getAttribute("attValue");
		out.println("email id " + emailId);
		
    	      %> has been registered with personalized product offers of Altoro Bank &  will be
    	       reviewed by our Customer Service staff.
    	       Our Executive will contact you shortly. </p>
                
		                                                                                                                                                                                                                                                                                                                                                                                               
		</div>                                                                                                                                                                                                                                                                      
    </td>                                                                                                                                          
</div>                                                                                                                                               
                                                                                                                                                     
<jsp:include page="footer.jspf"/>                                                                                                                    