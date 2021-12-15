
<%@page import="com.ibm.security.appscan.altoromutual.util.ServletUtil" errorPage="notfound.jsp"%>
<jsp:include page="header.jspf"/>

<div id="wrapper" style="width: 99%;">
	<jsp:include page="/toc.jspf"/>
   <td valign="top" colspan="3" class="bb">
		<div class="fl" style="width: 99%;">
		</span></p>
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
						<td><input id="uid" name="uid" 
							style="width: 150px;"></td>
					</div><br>
					
					<div>					
						<td>Email</td>
						<td><input id="ps" name="ps" 
							style="width: 150px;">
						</td>
					</div>

					<tr>
						<% String content = request.getParameter("input"); %>
						<td></td>
						<td><input type="submit" name="btnSubmit"
							value="Register" class="input" id="btnSubmit" />
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