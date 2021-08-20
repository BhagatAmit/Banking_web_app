package com.banking.serviceImpl;

import com.banking.dao.BankingDao;
import com.banking.dao.impl.BankingDaoImpl;
import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.service.BankLoginService;

public class BankLoginServiceImpl implements BankLoginService{
	 BankingDao bankDAO=new BankingDaoImpl();
	
	
	@Override
	public boolean customerLogin(Customer customer) throws BankingException {
		boolean b=false;
		if(customer.getCustUserName()!=null && customer.getCustPassword()!=null) {
			b = bankDAO.customerLogin(customer);
		}
		else {
			throw new BankingException("Invalid Details...");
		}
		return b;
		
	}


	@Override
	public boolean isValidEmployeeCredentials(Bank bank) throws BankingException {
		System.out.println(bank);
		boolean b = false;
		if(bank!=null && bank.getEmpUsername()!=null && bank.getEmpPassword()!=null) {
			b = bankDAO.isValidEmployeeCredentials(bank);
		}
		else {
			throw new BankingException("Invalid Username or Password");
		}
		return b;
	}
	

	

}