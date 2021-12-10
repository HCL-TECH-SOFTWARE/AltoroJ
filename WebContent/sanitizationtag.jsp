
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil" errorPage="notfound.jsp"%>
<jsp:include page="header.jspf"/>

<div id="wrapper" style="width: 99%;">
	<jsp:include page="/toc.jspf"/>
   <td valign="top" colspan="3" class="bb">
		<div class="fl" style="width: 99%;">
		</span></p>
		<form name="cmt" method="post" action="postSanitizeTag">
		  <table>
		    <tr>
		      <td>
		        First input:
		      </td>
		      <td>
		        <input type="text" id="uid" name="uid" value="" style="width: 150px;">
		      </td>
		      <td>
		      <input type="text" id="ps" name="ps" value="" style="width: 150px;">
		      </td>
		    </tr>
		   
		    <tr>
		    <%
			String content = request.getParameter("input");
		    
			%>
		        <td></td>
		        <td>
		          <input type="submit" name="btnSubmit" value="Sanitize Tag" class="input" id="btnSubmit" />
		        </td>
		        
		      </tr>
		      
		  </table>
		  </form>
		<div id="result">
		</div>
		
		</div>
		
		<!-- <script type="text/javascript">
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

<jsp:include page="footer.jspf"/>