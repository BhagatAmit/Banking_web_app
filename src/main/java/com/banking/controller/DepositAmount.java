package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Transaction;
import com.banking.service.BankCrudService;
import com.banking.serviceImpl.BankCrudServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class DepositAmount
 */
public class DepositAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositAmount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson=new Gson();
		Transaction transaction=null;
		transaction=gson.fromJson(request.getReader(), Transaction.class); // JSON to POJO
		BankCrudService bankCrudService=null;
		bankCrudService = new BankCrudServiceImpl();
		try {
			transaction=bankCrudService.depositedAmount(transaction);
			System.out.println(transaction);
		} catch (BankingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print(gson.toJson(transaction));
	}
	

}
