package com.ibm.security.appscan.altoromutual.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class SanitizationServlet
 */
public class SanitizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanitizationServlet() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attId = goodSanitationForIdAttribute(request.getParameter("uid"));
		String attValue = goodSanitationForIdAttribute(request.getParameter("ps"));
		request. setAttribute("attId", attId);
		request.setAttribute("attValue", attValue);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sanitizationsucess.jsp");
		dispatcher.forward(request, response);   
      }
	
	protected String goodSanitationForIdAttribute(String parameter) {
		 String  parameter1 = parameter;
		    parameter1 = parameter1.replaceAll("'", "&#39;");
		    parameter1 = parameter1.replaceAll("\"", "&quot;");
		    parameter1 = parameter1.replaceAll("&", "&amp;");
		    return parameter1;
		}
	}
