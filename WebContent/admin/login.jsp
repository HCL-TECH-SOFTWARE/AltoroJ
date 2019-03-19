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
	<jsp:include page="/bank/membertoc.jspf"/>
	<td valign="top" colspan="3" class="bb">
		<h1>Administration Login</h1>
		
		<!-- Password: Altoro1234 -->
		
		<form id="Default" method="post" action="doAdminLogin">
		<!-- <img id="captcha" src="getCaptcha.jsp" /><br /> -->
		  <p>
		<!--  add captcha input here -->
		    <strong>Enter the administrative password:</strong><br />
		    <input id="password" name="password" type=password runat="server" /><br /><br />
		    <input type="submit" name="btnSubmit" value="Login">
		  </p>
		<p><span id="_ctl0__ctl0_Content_Main_message" style="color:#FF0066;font-size:12pt;font-weight:bold;">
			<%
			java.lang.String error = (String)request.getAttribute("loginError");
			
			if (error != null && error.trim().length() > 0){
				request.getSession().removeAttribute("loginError");
				out.print(error);
			}
			%>
		</span></p>
		</form>
		
		<script>
		window.onload = document.forms[1].elements[1].focus();
		</script>
	</td>
</div>

<jsp:include page="/footer.jspf"/>