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
		<div class="fl" style="width: 99%;">

			<h1>Subscribe</h1>
			
			<p>We recognize that things are always evolving and changing here at Altoro Mutual.
			Please enter your email below and we will automatically notify of noteworthy events.</p>
			
			<form action="doSubscribe" method="post" name="subscribe" id="subscribe" onsubmit="return confirmEmail(txtEmail.value);">
			  <table>
			    <tr>
			      <td colspan="2">
			        <div style="font-weight: bold; font-size: 12px; color: red;" id="message"><%=(request.getAttribute("message_subscribe")!=null)?request.getAttribute("message_subscribe"):"" %></div>
			      </td>
			    </tr>
			    <tr>
			      <td>
			        Email:
			      </td>
			      <td>
			        <input type="text" id="txtEmail" name="txtEmail" value="" style="width: 150px;">
			      </td>
			    </tr>
			    <tr>
			        <td></td>
			        <td>
			          <input type="submit" name="btnSubmit" value="Subscribe">
			        </td>
			      </tr>
			  </table>
			</form>
			
			<script>
			function confirmEmail(sEmail) {
			  var msg = null;
			  if (sEmail != "") {
			    var emailFilter=/^[\w\d\.\%-]+@[\w\d\.\%-]+\.\w{2,4}$/;
			    if (!(emailFilter.test(sEmail))) {
			      var illegalChars= /[^\w\d\.\%\-@]/;
			      if (sEmail.match(illegalChars)) {
			          msg = "Your email can only contain alphanumeric\ncharacters and the following:  @.%-\n\n";
			      } else {
			        msg = "Your email address does not appear to be valid. Please try again.\n\n";
			      }
			    }
			  } else {
			    msg = "Please enter an email address.\n\n";
			  }
			  if (msg != null) {
			      alert(msg);
			      return false;
			  } else {
			      return true;
			  }
			}
			</script>
			
		</div>    
    </td>	
</div>

<jsp:include page="footer.jspf"/>   