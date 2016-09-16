package com.ibm.security.appscan.altoromutual.api;

import java.security.InvalidParameterException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.apache.wink.json4j.*;

import com.ibm.security.appscan.altoromutual.util.DBUtil;
import com.ibm.security.appscan.altoromutual.util.ServletUtil;

@Path("login")
public class LoginAPI extends AltoroAPI {

	@GET
	// @Path("/login")
	public Response checkLogin(@Context HttpServletRequest request) throws JSONException {
		JSONObject myJson = new JSONObject();
		// HttpSession session = request.getSession(true);
		if (ServletUtil.isLoggedin(request)) {
			myJson.put("loggedin", "true");
			myJson.put("user", ServletUtil.getUser(request).getUsername());
			return Response.status(200).entity(myJson.toString()).build();
		} else {
			myJson.put("loggedin", "false");
			return Response.status(200).entity(myJson.toString()).build();
		}
	}

	@POST
	public Response login(String bodyJSON, @Context HttpServletRequest request) throws JSONException {

		HttpSession session = request.getSession(true);

		JSONObject myJson = new JSONObject();
		try {
			myJson =new JSONObject(bodyJSON);
		} catch (Exception e) {
			// e.printStackTrace();
			myJson.clear();
			myJson.put("error", "body is not JSON");
			return Response.status(400).entity(myJson.toString()).build();
		}

		// Check username and password parameters are there
		if (!myJson.containsKey("username") && myJson.containsKey("password")) {
			myJson.clear();
			myJson.put("error", "username or password parameter missing");
			return Response.status(400).entity(myJson.toString()).build();
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
			else
				e.printStackTrace();
			
			myJson.put("error", e.getLocalizedMessage());
			return Response.status(400).entity(myJson.toString()).build();
		}

		// Handle the cookie using ServletUtil.establishSession(String)
		// TODO:refactor
		try {
			Cookie accountCookie = ServletUtil.establishSession(username,
					session);
			javax.ws.rs.core.Cookie someCookie = new javax.ws.rs.core.Cookie(
					ServletUtil.ALTORO_COOKIE, accountCookie.getValue());
			NewCookie myCookie = new NewCookie(someCookie);
			myJson.put("success", username + " is now logged in");
			return Response.status(200).entity(myJson.toString())
					.cookie(myCookie).build();
		} catch (Exception ex) {
			myJson.put("error", "Unexpected error occured. Please try again");
			return Response.status(500).entity(myJson.toString()).build();
		}

		// response.addCookie(accountCookie);
		// response.sendRedirect(request.getContextPath()+"/bank/main.jsp");

		// return Response.status(200).entity(response).build();
	}
}
