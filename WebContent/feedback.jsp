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
    
<jsp:include page="header.jspf"/>

<div id="wrapper" style="width: 99%;">
	<jsp:include page="toc.jspf"/>
    <td valign="top" colspan="3" class="bb">
		<%@page import="com.ibm.security.appscan.altoromutual.model.User"%>

		<%User user = null;
		try {
		 user = (User)request.getSession().getAttribute("user"); 
		} catch (Exception e) { /* do nothing */ }%>
		
		<div class="fl" style="width: 99%;">
		
		<h1>Feedback</h1>
		
		<p>Our Frequently Asked Questions area will help you with many of your inquiries.<br />
		If you can't find your question, return to this page and use the e-mail form below.</p>
		
		<p><b>IMPORTANT!</b> This feedback facility is not secure.  Please do not send any <br />
		account information in a message sent from here.</p>
		
		<form name="cmt" method="post" action="sendFeedback">
		
		<!--- Dave- Hard code this into the final script - Possible security problem.
		  Re-generated every Tuesday and old files are saved to .bak format at L:\backup\website\oldfiles    --->
		<input type="hidden" name="cfile" value="comments.txt">
		
		<table border=0>
		  <tr>
		    <td align=right>To:</td>
		    <td valign=top><b>Online Banking</b> </td>
		  </tr>
		  <tr>
		    <td align=right>Your Name:</td>
		    <td valign=top><input name="name" size=25 type=text value = "<%= ((user != null && user.getFirstName() != null)?user.getFirstName()+" ":"") + ((user != null && user.getLastName() != null)?user.getLastName():"") %>"></td>
		  </tr>
		  <tr>
		    <td align=right>Your Email Address:</td>
		    <td valign=top><input name="email_addr" type=text size=25></td>
		  </tr>
		  <tr>
		    <td align=right>Subject:</td>
		    <td valign=top><input name="subject" size=25></td>
		  </tr>
		  <tr>
		    <td align=right valign=top>Question/Comment:</td>
		    <td><textarea cols=65 name="comments" rows=8 wrap=PHYSICAL align="top"></textarea></td>
		  </tr>
		  <tr>
		    <td>&nbsp;</td>
		    <td><input type=submit value=" Submit " name="submit">&nbsp;<input type=reset value=" Clear Form " name="reset"></td>
		  </tr>
		</table>
		</form>
		
		<br /><br />
		
		<img id="bug" src="" height=1 width=1 />
		
		</div>
    </td>
	
</div>

<jsp:include page="footer.jspf"/>