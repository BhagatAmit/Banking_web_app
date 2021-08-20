package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.service.BankLoginService;
import com.banking.serviceImpl.BankLoginServiceImpl;


/**
 * Servlet implementation class BankingLoginController
 */
public class BankingLoginController extends HttpServlet {
	private static Logger log = Logger.getLogger(BankingLoginController.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankingLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("inside servlet signup");
		Customer customer=new Customer();
		customer.setCustUserName(request.getParameter("custUserName"));
		customer.setCustPassword(request.getParameter("custPassword"));
		
		BankLoginService loginService=new BankLoginServiceImpl();
		System.out.println(customer);
		RequestDispatcher requestDispatcher=null;
		try {
			if(loginService.customerLogin(customer)) {
				HttpSession session=request.getSession();
				//success
				requestDispatcher=request.getRequestDispatcher("success");
				requestDispatcher.include(request, response);
			
			}
		} catch (BankingException e) {
			//failure
			PrintWriter out=response.getWriter();
			requestDispatcher=request.getRequestDispatcher("index.html");
		
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
			log.warn("Exception occurred");

			
		}
	
	}

	
	

}
