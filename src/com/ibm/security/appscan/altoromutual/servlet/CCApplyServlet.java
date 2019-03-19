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

import com.ibm.security.appscan.altoromutual.model.User;
import com.ibm.security.appscan.altoromutual.util.DBUtil;
import com.ibm.security.appscan.altoromutual.util.ServletUtil;

/**
 * Credit card application servlet
 * @author Alexei
 */
public class CCApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//do nothing with credit card application
		//redirect to success page
		
		try {
			String passwd = request.getParameter("passwd");
			User user = (User)(request.getSession().getAttribute(ServletUtil.SESSION_ATTR_USER));
			
			//correct password entered
			if (DBUtil.isValidUser(user.getUsername(), passwd.trim())) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/bank/applysuccess.jsp");
				dispatcher.forward(request, response);	
			}
			
			//incorrect password entered
			request.getSession().setAttribute("loginError", "Login Failed: We're sorry, but this username or password was not found in our system. Please try again.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bank/apply.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			response.sendError(500);
		}
				

	}

}
