package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.service.BankCrudService;
import com.banking.service.BankSearchService;
import com.banking.serviceImpl.BankCrudServiceImpl;
import com.banking.serviceImpl.BankSearchServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class BankingCrudController
 */
public class BankingCrudController extends HttpServlet {
	private static Logger log = Logger.getLogger(BankingCrudController.class);

	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BankingCrudController() {
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  BankCrudService bankCrudService=new BankCrudServiceImpl();
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		System.out.println("inside servlet");
		
			try {
				out.print(gson.toJson(bankCrudService.getAllCustomerDetails()));
				//List<Bank> list=bankCrudService.getAllCustomerDetails();
			} catch (BankingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson=new Gson();
		System.out.println("inside servlet of register");
	
		PrintWriter out=response.getWriter();
	

		 Bank user=gson.fromJson(request.getReader(), Bank.class); // JSON to POJO
		
		 BankCrudService bankCrudService1 = new BankCrudServiceImpl();
		try {
			user=bankCrudService1.registerCustomer(user);
			System.out.println(user);
		} catch (BankingException e) {
			log.warn("Exception occurred");
			e.printStackTrace();
		}
		response.setContentType("application/json;charset=UTF-8");
		
		out.print(gson.toJson(user));
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
