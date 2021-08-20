package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.service.BankCrudService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AllCustomer
 */
public class AllCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }
    BankCrudService bankCrudService =null;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		System.out.println("inside servlet");
		
			try {
				//out.print(gson.toJson(bankCrudService.getAllCustomerDetails()));
				List<Bank> list=bankCrudService.getAllCustomerDetails();
			} catch (BankingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
