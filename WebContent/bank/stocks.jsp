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
			<div style="display:inline;">
				<script type="text/javascript" src="../util/swfobject.js"></script>
				<script type="text/javascript">
						swfobject.registerObject("myId", "9.0.0", "../util/expressInstall.swf");
				</script>
			
				<object id="myId" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="550" height="750">
					<param name="movie" value="../util/EasyStock.swf" />
			   		<!--[if !IE]>-->
					<object type="application/x-shockwave-flash" data="../util/EasyStock.swf" width="550" height="750">
					<!--<![endif]-->
			</div>
		</div>
    </td>	
</div>
<jsp:include page="/footer.jspf"/>   

<div style="display:none;">
	<script type="text/javascript" src="util/swfobject.js"></script>
	<script type="text/javascript">
			swfobject.registerObject("myId", "9.0.0", "util/expressInstall.swf");
	</script>

	<object id="myId" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="400" height="300">
		<param name="movie" value="util/vulnerable.swf" />
   		<!--[if !IE]>-->
		<object type="application/x-shockwave-flash" data="util/vulnerable.swf" width="400" height="300">
		<!--<![endif]-->
</div>