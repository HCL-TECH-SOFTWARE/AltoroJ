<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
/**
 This application is for demonstration use only. It contains known application security
vulnerabilities that were created expressly for demonstrating the functionality of
application security testing tools. These vulnerabilities may present risks to the
technical environment in which the application is installed. You must delete and
uninstall this demonstration application upon completion of the demonstration for
which it is intended. 

IBM DISCLAIMS ALL LIABILITY OF ANY KIND RESULTING FROM YOUR USE OF THE APPLICATION
OR YOUR FAILURE TO DELETE THE APPLICATION FROM YOUR ENVIRONMENT UPON COMPLETION OF
A DEMONSTRATION. IT IS YOUR RESPONSIBILITY TO DETERMINE IF THE PROGRAM IS APPROPRIATE
OR SAFE FOR YOUR TECHNICAL ENVIRONMENT. NEVER INSTALL THE APPLICATION IN A PRODUCTION
ENVIRONMENT. YOU ACKNOWLEDGE AND ACCEPT ALL RISKS ASSOCIATED WITH THE USE OF THE APPLICATION.

IBM AltoroJ
(c) Copyright IBM Corp. 2008, 2013 All Rights Reserved.
*/
%>    
    
<jsp:include page="/header.jspf"/>

<div id="wrapper" style="width: 99%;">
	<jsp:include page="membertoc.jspf"/>
    <td valign="top" colspan="3" class="bb">
		<div class="fl" style="width: 99%;">
			<h1>Altoro Mutual Gold Visa Application</h1>
			<span><p><b>No application is needed.</b>To approve your new $10000 Altoro Mutual Gold Visa<br />with an 7.9% APR simply enter your password below.</p>
			<p><span id="_ctl0__ctl0_Content_Main_message" style="color:#FF0066;font-size:12pt;font-weight:bold;">
			<%
				java.lang.String error = (String)request.getSession(true).getAttribute("loginError");
		
				if (error != null && error.trim().length() > 0){
					request.getSession().removeAttribute("loginError");
					out.print(error);
				}
			%>
			</span></p>			
			<form method="post" name="Credit" action="ccApply"><table border=0><tr><td>Password:</td><td><input type="password" name="passwd"></td></tr><tr><td></td><td><input type="submit" name="Submit" value="Submit"></td></tr></table></form></span>
		</div>
    </td>	
</div>
<jsp:include page="/footer.jspf"/>   
