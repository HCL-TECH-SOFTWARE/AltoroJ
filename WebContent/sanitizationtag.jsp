
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil" errorPage="notfound.jsp"%>
<jsp:include page="header.jspf"/>

<div id="wrapper" style="width: 99%;">
	<jsp:include page="/toc.jspf"/>
   <td valign="top" colspan="3" class="bb">
		<div class="fl" style="width: 99%;">
		</span></p>
		<form name="cmt" method="post" action="postSanitizeTag">
		  <table>
		  
		  <h2 style="color:green;">Offers Exclusively for you</h2>
		  <p>Avail great offers across travel, dining, shopping, wellness and more</p>
		  
		  <p>To avail amazing deals,
			authenticate yourself by filling up the required details.</p>

		    <div>
						<td>Name</td>
						<td><input id="uid" name="uid" 
							style="width: 150px;"></td>
					</div><br>
					
					<div>
					
						<td>Email ID</td>
						<td><input id="ps" name="ps" 
							style="width: 150px;"></td>
					</div>
		   
		    <tr>
		    <%
			String content = request.getParameter("input");
		    
			%>
		        <td></td>
		        <td>
		          <input type="submit" name="btnSubmit" value="Register" class="input" id="btnSubmit" />
		        </td>
		        
		      </tr>
		      
		  </table>
		  </form>
		<div id="result">
		</div>
		
		</div>		
		
    </td>
</div>

<jsp:include page="footer.jspf"/>