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
		<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil"%>
		<div class="fl" style="width: 99%;">
			<h1>Search News Articles</h1>
			<form id="QueryXpath" method="get" action="<%=request.getRequestURL()%>">
			  Search our news articles database
			  <br /><br />
				<input type="hidden" id=content" name="content" value="queryxpath.jsp"/>
				<input type="text" id="query" name="query" width=450 value="<%=(request.getParameter("query")==null)?"Enter title (e.g. Watchfire)":request.getParameter("query")%>"/>
				<input type="submit" width=75 id="Button1" value="Query">
			  <br /><br />
			<%
				if (request.getParameter("query") != null) {
				String[] results = ServletUtil.searchArticles(request.getParameter("query"), request.getSession().getServletContext().getRealPath("/pr/Docs.xml"));
				if (results == null)
					out.println("News title not found, try again");
				else {
					out.println("Found news title:<br/>");
					for(String result:results)
				out.println(result+"<br/>");
				}
			}
			%>
			
			</form>
		</div>    
    </td>	
</div>

<jsp:include page="/footer.jspf"/>  