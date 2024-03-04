package com.ibm.security.appscan.altoromutual.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.*;

import com.ibm.security.appscan.altoromutual.util.DBUtil;
import com.ibm.security.appscan.altoromutual.util.ServletUtil;

@Path("/admin")
public class AdminAPI extends AltoroAPI{
	
	@POST
	@Path("/changePassword")
	public Response changePassword(String bodyJSON, @Context HttpServletRequest request) throws IOException{
		JSONObject bodyJson= new JSONObject();
		
		//Don't really care if the user is admin or not - I think that's how it works in AltoroJ
				
		//Convert request to JSON
		String username;
		String password1;
		String password2;
		try {
			bodyJson =new JSONObject(bodyJSON);
			
			//Parse the body for the required parameters
			username = bodyJson.get("username").toString();
			password1 = bodyJson.get("password1").toString();
			password2 = bodyJson.get("password2").toString();
		} catch (JSONException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"Error\": \"Request is not in JSON format\"}").build();
		}
		
		
		//Try to change the password 
		if (username == null || username.trim().length() == 0
				|| password1 == null || password1.trim().length() == 0
				|| password2 == null || password2.trim().length() == 0)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"An error has occurred. Please try again later.\"}").build();
		
		if (!password1.equals(password2)){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"Entered passwords did not match.\"}").build();
		}
	
		String error = null;
		
		if (ServletUtil.getAppProperty("enableAdminFunctions").equalsIgnoreCase("true"))
			error = DBUtil.changePassword(username, password1);	
		
		if (error != null)
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\""+error+"\"}").build();
		

		return Response.status(Response.Status.OK).entity("{\"success\":\"Requested operation has completed successfully.\"}").type(MediaType.APPLICATION_JSON_TYPE).build();
	}
	
	@POST
	@Path("/addUser")
	public Response addUser(String bodyJSON, @Context HttpServletRequest request) throws IOException{
		JSONObject bodyJson= new JSONObject();
		
		//Checking if user is logged in
		
		String firstname;
		String lastname;
		String username;
		String password1;
		String password2;
				
		//Convert request to JSON
		try {
			bodyJson =new JSONObject(bodyJSON);
			//Parse the request for the required parameters
			firstname = bodyJson.get("firstname").toString();
			lastname = bodyJson.get("lastname").toString();
			username = bodyJson.get("username").toString();
			password1 = bodyJson.get("password1").toString();
			password2 = bodyJson.get("password2").toString();
		} catch (JSONException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"Error\": \"Request is not in JSON format\"}").build();
		}
		
		if (username == null || username.trim().length() == 0
			|| password1 == null || password1.trim().length() == 0
			|| password2 == null || password2.trim().length() == 0)
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\":\"An error has occurred. Please try again later.\"}").build();
		
		if (!password1.equals(password2)){
			return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\":\"Entered passwords did not match.\"}").build();
		}
		
		String error = null;
		
		if (ServletUtil.getAppProperty("enableAdminFunctions").equalsIgnoreCase("true"))
			error = DBUtil.addUser(username, password1, firstname, lastname);
		
		if (error != null)
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\""+error+"\"}").build();
		
		
		return Response.status(Response.Status.OK).entity("{\"success\":\"Requested operation has completed successfully.\"}").type(MediaType.APPLICATION_JSON_TYPE).build();
	}

}
