package com.ibm.security.appscan.altoromutual.filter;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SwaggerFilter implements Filter{

	public SwaggerFilter() {
		// TODO Auto-generated constructor stub
		super();
	}

	public void init(FilterConfig arg0) throws ServletException{
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stubs
		if(req instanceof HttpServletRequest){
			HttpServletRequest request= (HttpServletRequest) req;
			String host = new String();// = request.getLocalName()+":"+request.getLocalPort()+request.getContextPath();
			String port = Integer.toString(request.getLocalPort());
			String appPath = request.getContextPath();
			
			if (request instanceof HttpServletRequest) {
				 String url = ((HttpServletRequest)request).getRequestURL().toString();
				 URI uri;
				 try {
					uri = new URI(url);
					String domain = uri.getHost();
					//System.out.println(domain + "\n" + port +"\n" + appPath);
					host = domain + ":" +port + appPath;
					
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					host = request.getLocalName() + ":" + port + appPath;
				}
				 
				 
			}
			
			//System.out.println("\"host\": \""+host+"\"");
			
			Path path = Paths.get(request.getSession().getServletContext().getRealPath(File.separator)+"/swagger/test.json");
			Charset charset = StandardCharsets.UTF_8;
			String content = new String(Files.readAllBytes(path),charset);
			
			if(!content.contains(host)){
			//System.out.println("Changing file");
			content = content.replaceAll("\"host\": \".*\"", "\"host\": \""+host+"\"");
			Files.write(path, content.getBytes(charset));
			}
			
			chain.doFilter(req, resp);
		}
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
