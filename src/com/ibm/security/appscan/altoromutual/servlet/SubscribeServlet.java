/**
This application is for demonstration use only. It contains known application security
vulnerabilities that were created expressly for demonstrating the functionality of
application security testing tools. These vulnerabilities may present risks to the
technical environment in which the application is installed. You must delete and
uninstall this demonstration application upon completion of the demonstration for
which it is intended. 

IBM DISCLAIMS ALL LIABILITY OF ANY KIND RESULTING FROM YOUR USE OF THE APPLICATION
OR YOUR FAILURE TO DELETE THE APPLICATION FROM YOUR ENVIRONMENT UPON COMPLETION OF
A DEMONSTRATION. IT IS YOUR RESPONSIBILITY TO DETERMINE IF THE PROGRAM IS APPROPRIATE
OR SAFE FOR YOUR TECHNICAL ENVIRONMENT. NEVER INSTALL THE APPLICATION IN A PRODUCTION
ENVIRONMENT. YOU ACKNOWLEDGE AND ACCEPT ALL RISKS ASSOCIATED WITH THE USE OF THE APPLICATION.

IBM AltoroJ
(c) Copyright IBM Corp. 2008, 2013 All Rights Reserved.
 */
package com.ibm.security.appscan.altoromutual.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet allows the user to subscribe for the mailing list
 * Servlet implementation class SubscribeServlet
 * 
 * @author Alexei
 */
public class SubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LEGAL_EMAIL_ADDRESS = "^[\\w\\d\\.\\%-]+@[\\w\\d\\.\\%-]+\\.\\w{2,4}$";
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		if (email == null || !email.matches(LEGAL_EMAIL_ADDRESS)){
			response.sendRedirect("index.jsp");
			return;
		}
		
		//don't actually subscribe the user
		request.setAttribute("message_subscribe", "Thank you. Your email " + email + " has been accepted.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("subscribe.jsp");
		dispatcher.forward(request, response);
	}

}
