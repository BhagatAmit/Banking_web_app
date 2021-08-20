package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

/**
 * Servlet implementation class SuccessController
 */
public class SuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessController() {
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
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession(false);
		HttpSession session = request.getSession(true);

		PrintWriter out=response.getWriter();
//		if (session == null) {
//
//			out.print("<center><h1>Please Login First</h1></center>");
//			out.print("<h4><a href='/banking_web_application'>Click here to Login </a> ");
//		}
//		else {
		out.print("<h1>Welcome "+request.getParameter("custUserName")+" ..... You have logged in successfully at "+new Date()+"</h1>");
		RequestDispatcher requestDispatcher=null;
		out.print("<a href='logout'>Click Here to LOGOUT</a>");

		requestDispatcher=request.getRequestDispatcher("customertask.html");
		requestDispatcher.include(request, response);
		//out.print("<a href='customertask.html'>Click Here to perform different operation</a>");
	//}
		}

}
