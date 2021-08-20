package com.banking.dao;



import java.util.List;

import com.banking.exception.BankingException;
import com.banking.model.Customer;
import com.banking.model.Transaction;



import com.banking.exception.BankingException;
import com.banking.model.Account;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.model.Transaction;

public interface BankingDao {
	public String getCustomerByUsername(String username) throws BankingException;

	public Bank registerCustomer(Bank bank) throws BankingException;
	
	public Bank openCustomerAccount(Bank bank) throws BankingException;
	
	public List<Bank> getAllCustomerDetails()throws BankingException;
	
	//Bank login service
	public boolean isValidEmployeeCredentials(Bank bank) throws BankingException;
	
	//Bank Customer service
	public boolean customerLogin(Customer customer) throws BankingException;
	
	public String  getPassWordByUsername(String username,String password) throws BankingException;
	
	public Transaction depositedAmount(Transaction transaction) throws BankingException;
	
	public long getCustomerByAccountno(long accountno) throws BankingException;
	
	public double getCurrbalanceByAccountno(long accountno)throws BankingException;
	
	public Transaction withdrawlAmount(Transaction transaction) throws BankingException;
	
	public List<Transaction> getTransactionByAccountno(long accountno)throws BankingException;
	public void deleteAccount(long accountno) throws BankingException;






	

	
}