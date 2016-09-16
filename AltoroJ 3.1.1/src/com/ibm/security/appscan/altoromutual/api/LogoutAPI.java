package com.ibm.security.appscan.altoromutual.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.ibm.security.appscan.altoromutual.util.ServletUtil;

@Path("/logout")
public class LogoutAPI extends AltoroAPI{

	@GET
	public Response doLogOut(@Context HttpServletRequest request){
		
		try{
			request.getSession().removeAttribute(ServletUtil.SESSION_ATTR_USER);
			String response="{\"LoggedOut\" : \"True\"}";
			return Response.status(200).entity(response).build();}
		catch(Exception e){
			String response = "{\"Error \": \"Unknown error encountered\"}";
			return Response.status(500).entity(response).build();
		}
	}
}
