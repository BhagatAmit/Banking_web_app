package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.service.BankCrudService;
import com.banking.serviceImpl.BankCrudServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CustomerOpenAccount
 */
public class CustomerOpenAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BankCrudService bankCrudService = new BankCrudServiceImpl();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOpenAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//HttpSession session = request.getSession(false);
	HttpSession session = request.getSession(true);

	

		if(session == null) {
			response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<center><h1>You Must Login First</h1></center>");
		out.print("<h4><a href='/banking_web_application'>Click here to HOME PAGE </a> ");
		}
		else {
			Gson gson = new Gson();
			Bank bank = gson.fromJson(request.getReader(),Bank.class);
			try {
				bank = bankCrudService.openCustomerAccount(bank);
				String account=String.valueOf(bank.getAccountno());
				//System.out.println(bank);
				Cookie c1=new Cookie("account",account);
				response.addCookie(c1);
				
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print(bank.getAccountno());
				out.print(gson.toJson(bank)); //POJO TO JSON
			} catch (BankingException e) {
				System.out.println(e.getMessage());
			}
			

	}
	}
}


