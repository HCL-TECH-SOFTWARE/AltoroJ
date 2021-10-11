
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil"
	errorPage="notfound.jsp"%>
<jsp:include page="header.jspf" />

<div id="wrapper" style="width: 99%;">
	<jsp:include page="/toc.jspf" />
	<td valign="top" colspan="3" class="bb">
		<div class="fl" style="width: 99%;">
			</span>
			</p>
			<form name="cmt" method="post" action="postSanitize">
				<table>
				<h2 style="color:green;">Personalized Product Offers </h2>
					<p>AltoroBank offers are spread across brands and if you are an Internet Banking or Mobile Banking customer,
					 you have an added advantage on the deals and online offers</p>
					 <br>
					 <h2 style="color:black;">Altoro Private World </h2>
					 
					<p> Experience a world of rewards & offers!</p>
					<p>We'll need a bit of information to get you started</p>
					
					<div>
						<td>Name</td>
						<td><input name="name" id="uid" name="uid" 
							style="width: 150px;"></td>
					</div><br>
					
					<div>
					
						<td>Number</td>
						<td><input name="number" id="ps" name="ps" 
							style="width: 150px;"></td>
					</div>

					<tr>
						<%
						String content = request.getParameter("input");
						%>
						<td></td>
						<td><input type="submit" name="btnSubmit"
							value="Register" class="input" id="btnSubmit" /></td>

					</tr>

				</table>
			</form>
			<div id="result"></div>

		</div> <!-- <script type="text/javascript">
		 //document.getElementById("uid").value
		 document.getElementById("btnSubmit").onclick = function () {
			 var i = document.getElementById("uid").value;
			 var p = document.getElementById("ps").value;
		    var k = goodSanitationForTag(i);
		    var psw = goodSanitationForTag(p);
		    document.getElementById('result').innerHTML ="<input type='text' id='"+k+"'/>";
		    document.getElementById('result').innerHTML +="<p>" + p + "</p>";
		 };
		 
		 document.getElementById("btnSanitizeAttribute").onclick = function () {
			 var i = document.getElementById("uid").value;
			 var p = document.getElementById("ps").value;
		    var k = goodSanitationForIdAttribute(i);
		    var psw = goodSanitationForIdAttribute(p);
		    document.getElementById('result').innerHTML ="<input type='text' id='"+k+"'/>";
		    document.getElementById('result').innerHTML +="<p>" + p + "</p>";
		 };
		 
		 function goodSanitationForIdAttribute(parameter) {
			 var parameter1 = parameter;
			    parameter1 = parameter1.replaceAll("'", "&#39;");
			    parameter1 = parameter1.replaceAll("\"", "&quot;");
			    parameter1 = parameter1.replaceAll("&", "&amp;");
			    return parameter1;
			}
		 
		 function goodSanitationForTag(parameter) {
			  var parameter1 = parameter;
			    parameter1 = parameter1.replaceAll("&", "&amp;");
			    parameter1 = parameter1.replaceAll("<", "\\u003C");
			    parameter1 = parameter1.replaceAll(">", "\\u003E");
			    return parameter1;
			}
		</script> -->
	</td>
</div>

<jsp:include page="footer.jspf" />