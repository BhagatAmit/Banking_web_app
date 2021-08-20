package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.model.Bank;

/**
 * Servlet implementation class AccountCreationSuccess
 */
public class AccountCreationSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCreationSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Bank bank=null;
		out.print("<center><h2>Your Account Number is:"+bank.getAccountno()+"</h2></center>");
		
	
		
		out.print("<p><a href='/banking_web_application'>Click Here to go to MainMenu</a></p>");


	}

}
