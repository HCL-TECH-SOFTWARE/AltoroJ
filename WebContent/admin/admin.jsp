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
		
		<%
		String[] users = ServletUtil.getBankUsers();
		
		%>
		<script language="javascript">
		
		function confirmpass(myform)
		{
		  if (myform.password1.value.length && (myform.password1.value==myform.password2.value))
		  {
		    return true;
		  }
		  else
		  {
		    myform.password1.value="";
		    myform.password2.value="";
		    myform.password1.focus();
		    alert ("Passwords do not match");
		    return false;
		  }
		
		}
		</script>
		
		<!-- Be careful what you change.  All changes are made directly to AltoroJ database. -->
		<div class="fl" style="width: 99%;">
		<p><span style="color:#FF0066;font-size:12pt;font-weight:bold;">
		<%
		java.lang.String error = (String)request.getSession().getAttribute("message");
		
		if (error != null && error.trim().length() > 0){
			out.print(error);
		}
		%>
		</span></p>
		
		<h1>Edit User Information</h1>
		
		<table width="100%" border="0">
		<!-- action="addAccount" -->
		<form id="addAccount" name="addAccount" action="<%=ServletUtil.isAppPropertyTrue("enableAdminFunctions")?"addAccount":"" %>" method="post">
		  <tr>
		    <td colspan="4">
		      <h2>Add an account to an existing user</h2>
		    </td>
		  </tr>
		  <tr>
		    <th>
		      Users:
		    </th>
		    <th>
		      Account Types:
		    </th>
		    <th>&nbsp;</th>
		    <th>&nbsp;</th>
		  </tr>
		  <tr>
		    <td>
		      	<select name="username" id="username" size="1">
					<% for (String user:users){ %>
					<option value="<%=user%>"><%=user%></option>
					<%} %>
				</select>
		    </td>
		    <td>
		      <Select name="accttypes">
		        <option Value="Checking">Checking</option>
		        <option Value="Savings" Selected>Savings</option>
		        <option Value="IRA">IRA</option>
		      </Select></td>
		    <td></td>
		    <td><input type="submit" value="Add Account"></td>
		  </tr>
		  </form>
 
 		<!-- action="changePassword" -->
		  <form id="changePass" name="changePass" action="<%=ServletUtil.getAppProperty("enableAdminFunctions").equalsIgnoreCase("true")?"changePass":"" %>" method="post" onsubmit="return confirmpass(this);">
		  <tr>
		    <td colspan="4"><h2><br><br>Change user's password</h2></td>
		  </tr>
		  <tr>
		    <th>
		      Users:
		    </th>
		    <th>
		      Password:
		    </th>
		    <th>
		      Confirm:
		    </th>
		    <th>&nbsp;</th>
		  </tr>
		  <tr>
		    <td>
		        <select name="username" id="username" size="1">
					<% for (String user:users){ %>
					<option value="<%=user%>"><%=user%></option>
					<%} %>
				</select>
		    </td>
		    <td>
		      <input type="password" name="password1">
		    </td>
		    <td>
		      <input type="password" name="password2">
		    </td>
		    <td>
		      <input type="submit" name="change" value="Change Password">
		    </td>
		  </tr>
		  </form>
		  <!-- action="addUser" -->
		  <form method="post" name="addUser" action="<%=ServletUtil.getAppProperty("enableAdminFunctions").equalsIgnoreCase("true")?"addUser":"" %>" id="addUser" onsubmit="return confirmpass(this);">		  
		  <tr>
		    <td colspan="4"><h2><br><br>Add an new user</h2></td>
		  </tr>
		  <tr>
		    <th>
		      First Name:
		      <br>
		      Last Name:
		    </th>
		    <th>
		      Username:
		    </th>
		    <th>
		      Password:
		      <br>
		      Confirm:
		    </th>
		    <th>
		      &nbsp;</th>
		  </tr>
		  <tr>
		    <td>
		      <input type="text" name="firstname">
		      <br>
		      <input type="text" name="lastname">
		    </td>
		    <td>
		      <input type="text" name="username">
		    </td>
		    <td>
		      <input type="password" name="password1">
		      <br>
		      <input type="password" name="password2">
		    </td>
		    <td>
		      <input type="submit" name="add" value="Add User">
		    </td>
		  </tr>
		  <tr>
		    <td colspan="4">It is highly recommended that you leave the username as first
		      initial last name.
		    </td>
		  </tr>
		 </form>
 		 
		</table>
		</div>
    </td>
</div>

<jsp:include page="/footer.jspf"/>		