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
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	//	transaction.setDepositedAmount(request.getParameter("amount"));
		double depositedAmount=transaction.getDepositedAmount();
		
		BankSearchService bankSearchService=new BankSearchServiceImpl();
		
	

	//	out.print(gson.toJson(transaction1)); //POJO TO JSON
			
				long accountpresent=0;
				try {
						accountpresent=bankSearchService.getCustomerByAccountno(accountno1);
						double currbalance;
						currbalance = bankSearchService.getCurrbalanceByAccountno(accountno1);
						if(accountpresent!=0)
						{
							if(depositedAmount<0)
								out.print("Please Enter the Correct amount");	
								//	currbalance=previousBalance+depositedAmount;
							Transaction transaction2=new Transaction(accountno1,currbalance, 0, depositedAmount,currbalance+depositedAmount);
							BankCrudService bankCrudService2=new BankCrudServiceImpl();
							try {
								bankCrudService2.depositedAmount(transaction2);
								if(transaction2!=null) {
									out.print("Amount deposited Succesfully");
									out.print(transaction2);
									response.sendRedirect("customertask.html");
							}
							}catch (Exception e1) {
							e1.getMessage();
							}
						}	
				} catch (BankingException e1) {
		
			e1.printStackTrace();
		}

	}}
}

		




