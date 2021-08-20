package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.service.BankSearchService;
import com.banking.serviceImpl.BankSearchServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetCustomers
 */
public class GetCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		BankSearchService banksearchservice=new BankSearchServiceImpl();
		PrintWriter out=response.getWriter();
	
	}

}
