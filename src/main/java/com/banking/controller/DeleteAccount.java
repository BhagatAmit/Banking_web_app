package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.exception.BankingException;
import com.banking.model.Transaction;
import com.banking.service.BankCrudService;
import com.banking.service.BankSearchService;
import com.banking.serviceImpl.BankCrudServiceImpl;
import com.banking.serviceImpl.BankSearchServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class DeleteAccount
 */
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside servlet");
		response.setContentType("application/json;charset=UTF-8");
		response.setContentType("text/html");

		PrintWriter out=response.getWriter();
		Transaction transaction=null;
		Gson gson = new Gson();
		//HttpSession session = request.getSession(false);
		HttpSession session = request.getSession(true);

		if (session == null) {

			out.print("<center><h1>Please Login First</h1></center>");
			out.print("<h4><a href='/banking_web_application'>Click here to Login </a> ");
		} 
		else {
		transaction=gson.fromJson(request.getReader(), Transaction.class);
	
		long accountno1=transaction.getAccountno();
	
		BankSearchService bankSearchService=new BankSearchServiceImpl();
	
			
				long accountpresent=0;
				try {
						accountpresent=bankSearchService.getCustomerByAccountno(accountno1);
			
						if(accountpresent!=0)
						{
							BankCrudService bankCrudService2=new BankCrudServiceImpl();
							try {
								bankCrudService2.deleteAccount(accountno1);
								
									out.print("Account deleted Succesfully");
									
									response.sendRedirect("employeetask.html");
							
							}catch (Exception e1) {
							e1.getMessage();
							}
						}	
				} catch (BankingException e1) {
		
			e1.printStackTrace();
		
				}
	}
	
	}		
}
