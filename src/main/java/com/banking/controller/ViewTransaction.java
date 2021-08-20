package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Transaction;
import com.banking.service.BankSearchService;
import com.banking.serviceImpl.BankSearchServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class ViewTransaction
 */
public class ViewTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ViewTransaction.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    BankSearchService bankSearchService=new BankSearchServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Gson gson=new Gson();
		Long accountno = Long.parseLong(request.getParameter("accountno"));
		//session.getAttribute("userId");
		PrintWriter out=response.getWriter();
		System.out.println(accountno);
		
		try {
			System.out.println("inside try");
			out.print(gson.toJson(bankSearchService.getTransactionByAccountno(accountno)));
		} catch (BankingException e) {
			
			out.print(e.getMessage());
		
		}
	}
//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	Transaction transaction=null;
//	BankSearchService bankSearchService=new BankSearchServiceImpl();
//	//String Accountno=request.getParameter("accountForDelete");
//	//long accountno=Long.parseLong(Accountno);
//	Gson gson = new Gson();
//	
//	transaction=gson.fromJson(request.getReader(),Transaction.class);
//	
//	PrintWriter out=response.getWriter();
//	long accountno=transaction.getAccountno();
//	try {
//		List<Transaction> transaction1=bankSearchService.getTransactionByAccountno(accountno);
//		for(Transaction t:transaction1)
//		{
//			out.print(t);
//		}
//		JsonElement element = gson.toJsonTree(transaction1, new TypeToken<List<Transaction>>() {}.getType());
//		
//		JsonArray jsonArray = element.getAsJsonArray();
//		response.setContentType("application/json");
//		response.getWriter().print(jsonArray);
//	} catch (BankingException e) {
//		e.printStackTrace();
//	}
//	
//}

//		HttpSession session = request.getSession(true);
//		String Accountno=request.getParameter("accountForDelete");
//		long accountno=Long.parseLong(Accountno);
//		if(session == null) {
//			response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("<center><h1>You Must Login First</h1></center>");
//		out.print("<h4><a href='/bankapp_v2/login'>Click here to HOME PAGE </a> ");
//		}
//		else {
//			Gson gson = new Gson();
//			//Bank bank = gson.fromJson(request.getReader(),Bank.class);
//			try {
//			//	bank = bankCrudService.openCustomerAccount(bank);
//				//System.out.println(bank);
//				
//				response.setContentType("application/json;charset=UTF-8");
//				PrintWriter out=response.getWriter();
//				//out.print(gson.toJson(bank)); //POJO TO JSON
//			} catch (Exception e) {
//				e.getMessage();
//			}
//			
//
//	}
//	}
    
		
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	BankSearchService bankSearchService=new BankSearchServiceImpl();
//    	String Accountno=request.getParameter("accountForDelete");
//    	long accountno=Long.parseLong(Accountno);
//    	try {
//			List<Transaction> transaction=bankSearchService.getTransactionByAccountno(accountno);
//			Gson gson = new Gson();
//			JsonElement element = gson.toJsonTree(transaction, new TypeToken<List<Transaction>>() {}.getType());
//
//			JsonArray jsonArray = element.getAsJsonArray();
//			response.setContentType("application/json");
//			response.getWriter().print(jsonArray);
//		} catch (BankingException e) {
//			e.printStackTrace();
//		}
//		
//	}

}
