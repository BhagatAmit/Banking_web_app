package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.service.BankLoginService;
import com.banking.serviceImpl.BankLoginServiceImpl;

/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		bank.setEmpUsername(request.getParameter("empusername"));
		bank.setEmpPassword(request.getParameter("emppassword"));
		BankLoginService bankLoginService = new BankLoginServiceImpl();
		RequestDispatcher requestDispatcher = null;
		try {
			PrintWriter out=response.getWriter();
			if(bankLoginService.isValidEmployeeCredentials(bank)) {
			//	HttpSession session=request.getSession();
			out.print("<h1>Welcome "+request.getParameter("empusername")+" ..... You have logged in successfully at "+new Date()+"</h1>");
			
			requestDispatcher=request.getRequestDispatcher("employeetask.html");
			out.print("<a href='/banking_web_application'>Click Here to LOGOUT</a>");

			requestDispatcher.include(request, response);
			}
		} catch (BankingException e) {
			PrintWriter out=response.getWriter();
			requestDispatcher=request.getRequestDispatcher("employeelogin.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
	

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

}
