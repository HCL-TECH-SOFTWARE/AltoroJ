package com.ibm.security.appscan.altoromutual.api;

import java.security.InvalidParameterException;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.apache.wink.json4j.*;
import com.ibm.security.appscan.altoromutual.util.DBUtil;
import com.ibm.security.appscan.altoromutual.util.OperationsUtil;

@Path("/login")
public class LoginAPI{

	@GET
	public Response checkLogin(@Context HttpServletRequest request) throws JSONException {
		JSONObject myJson = new JSONObject();
		myJson.put("loggedin", "true");
		return Response.status(Response.Status.OK).entity(myJson.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	@POST
	@PermitAll
	public Response login(String bodyJSON, @Context HttpServletRequest request) throws JSONException {

		JSONObject myJson = new JSONObject();
		try {
			myJson =new JSONObject(bodyJSON);
		} catch (Exception e) {
			// e.printStackTrace();
			myJson.clear();
			myJson.put("error", "body is not JSON");
			return Response.status(Response.Status.BAD_REQUEST).entity(myJson.toString()).build();
		}

		// Check username and password parameters are there
		if (!(myJson.containsKey("username") && myJson.containsKey("password"))) {
			myJson.clear();
			myJson.put("error", "username or password parameter missing");
			return Response.status(Response.Status.BAD_REQUEST).entity(myJson.toString()).build();
		}

		String username, password;
		username = myJson.get("username").toString().toLowerCase();
		password = myJson.get("password").toString().toLowerCase();

		myJson.clear();
		
		try {
			if (!DBUtil.isValidUser(username, password)) {
				throw new InvalidParameterException(
						"We're sorry, but this username or password was not found in our system.");
			}
		} catch (Exception e) {
			if (e instanceof InvalidParameterException)
				System.out.println("Invalid user error: " + e.getLocalizedMessage());
			
			myJson.put("error", e.getLocalizedMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(myJson.toString()).build();
		}

		try {
			myJson.put("success", username + " is now logged in");
			
			//Generate a very basic auth token      			
			String authToken = Base64.encodeBase64String(username.getBytes()) +":"+ Base64.encodeBase64String(password.getBytes()) +":"+OperationsUtil.makeRandomString();
			
			myJson.put("Authorization",Base64.encodeBase64String(authToken.getBytes()));
			return Response.status(Response.Status.OK).entity(myJson.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (Exception ex) {
			myJson.put("failed", "Unexpected error occured. Please try again.");
			myJson.put("error", ex.getLocalizedMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(myJson.toString()).build();
		}
	}
}
