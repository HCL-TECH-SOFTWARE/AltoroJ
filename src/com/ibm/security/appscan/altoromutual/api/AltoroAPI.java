package com.ibm.security.appscan.altoromutual.api;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

import com.ibm.security.appscan.altoromutual.filter.ApiAuthFilter;

@ApplicationPath("api")
public class AltoroAPI extends ResourceConfig{
	public AltoroAPI(){
		packages("com.ibm.security.appscan.altoromutual.api");
		register(ApiAuthFilter.class);
	}
}
