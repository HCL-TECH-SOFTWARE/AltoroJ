package com.ibm.security.appscan.altoromutual.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.security.PermitAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;

import com.ibm.security.appscan.altoromutual.util.DBUtil;

public class ApiAuthFilter implements ContainerRequestFilter {

	@Context 
	private ResourceInfo resourceInfo;
	
	private static final String NOT_LOGGED_IN_ERROR = "loggedIn=false"+System.lineSeparator()+"Please log in first";
	
	private static final String AUTHENTICATION_SCHEME = "Bearer";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		java.lang.reflect.Method method = resourceInfo.getResourceMethod(); 
		
		if(method.isAnnotationPresent(PermitAll.class)) {
			return;
		}
	
		//Get request headers 
		final MultivaluedMap<String, String> headers = requestContext.getHeaders();
		final List<String> authorization = headers.get("Authorization");
			
		//If there's no authorization present, deny request 
		if(authorization==null || authorization.isEmpty()){
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
		            .entity(NOT_LOGGED_IN_ERROR).build());
            return;
		}
			
		//Get encoded username, password & date 
		String encodedToken = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME+ " ", "");
			
		//Decode security token
		String accessToken = new String(Base64.decodeBase64(encodedToken));
		if(!accessToken.matches(".*:.*")){
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
		            .entity(NOT_LOGGED_IN_ERROR).build());
	           return;
		}
			
		//Get username password and date 
		StringTokenizer tokenizer = new StringTokenizer(accessToken,":");
		String username = new String(Base64.decodeBase64(tokenizer.nextToken()));
		String password = new String(Base64.decodeBase64(tokenizer.nextToken()));
					
		try {
			if(!DBUtil.isValidUser(username, password)){
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
			            .entity(NOT_LOGGED_IN_ERROR).build());
				return;
			}
		} catch (SQLException e) {
			requestContext.abortWith(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error has occurred: "+e.getLocalizedMessage()).build());
		}
	}
}
