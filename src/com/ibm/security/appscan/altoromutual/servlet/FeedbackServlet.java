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

import com.ibm.security.appscan.altoromutual.util.OperationsUtil;

/**
 * Feedback submission servlet
 * @author Alexei
 */
public class FeedbackServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//the feedback is not actually submitted
		if (request.getParameter("comments") == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		String name = request.getParameter("name");
		if (name != null){
			request.setAttribute("message_feedback", name);
			String email = request.getParameter("email_addr");
			String subject = request.getParameter("subject");
			String comments = request.getParameter("comments");
			//store feedback in the DB - display their feedback once submitted

			String feedbackId = OperationsUtil.sendFeedback(name, email, subject, comments);
			if (feedbackId != null) {
				request.setAttribute("feedback_id", feedbackId);
			}
			
		} else {
			request.removeAttribute("name");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/feedbacksuccess.jsp");
		dispatcher.forward(request, response);
	}
}
