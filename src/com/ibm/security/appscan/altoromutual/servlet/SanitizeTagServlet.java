package com.ibm.security.appscan.altoromutual.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SanitizeTagServlet
 */
public class SanitizeTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanitizeTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String attId = goodSanitationForTag(request.getParameter("name"));
		String attValue = goodSanitationForTag(request.getParameter("email"));
		request. setAttribute("attId", attId);
		request.setAttribute("attValue", attValue);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sanitizationtagsuccess.jsp");
		dispatcher.forward(request, response);   
	}

	protected String goodSanitationForTag(String parameter) {
		 String  parameter1 = parameter;
		    parameter1 = parameter1.replaceAll("&", "&amp;");
		    parameter1 = parameter1.replaceAll("<", "\\u003C");
		    parameter1 = parameter1.replaceAll(">", "\\u003E");
		    return parameter1;
		}
}
