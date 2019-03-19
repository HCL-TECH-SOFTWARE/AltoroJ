<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page import="com.ibm.security.appscan.altoromutual.model.Feedback"%>
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
		<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil"%>
		
		<% if (ServletUtil.isAppPropertyTrue("enableFeedbackRetention")){%>
		<br><br>
		<h1>Customer feedback submissions</h1>
		<p>
		<% 
		
		ArrayList<Feedback> feedbackDetails = ServletUtil.getAllFeedback();
		
		for (int i=0; i<feedbackDetails.size();i++){
			
		%>
			<table border=0>
			  <tr>
			    <td align=right>Feedback ID:</td>
			    <td valign=top><%=feedbackDetails.get(i).getFeedbackID() %></td>
			  </tr>
			  <tr>
			    <td align=right>Customer Name:</td>
			    <td valign=top><%=feedbackDetails.get(i).getName() %></td>
			  </tr>
			  <tr>
			    <td align=right>Customer Email Address:</td>
			    <td valign=top><%=feedbackDetails.get(i).getEmail() %></td>
			  </tr>
			  <tr>
			    <td align=right>Customer Subject:</td>
			    <td valign=top><%=feedbackDetails.get(i).getSubject() %></td>
			  </tr>
			  <tr>
			    <td align=right valign=top>Customer Question/Comment:</td>
			    <td><%=feedbackDetails.get(i).getMessage()%></td>
			  </tr>
			</table>
			<hr>
		<% } %>
		</p>
		<% } %>
		</div>
    </td>
</div>

<jsp:include page="/footer.jspf"/>		