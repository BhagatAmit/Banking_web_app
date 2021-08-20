package com.banking.service;

import java.util.List;

import com.banking.exception.BankingException;
import com.banking.model.Account;
import com.banking.model.Bank;
import com.banking.model.Transaction;


public interface BankSearchService {
	public String getCustomerByUsername(String username) throws BankingException;
	public String  getPassWordByUsername(String username,String password) throws BankingException;
	
	public long getCustomerByAccountno(long accountno)throws BankingException;
	
	public double getCurrbalanceByAccountno(long accountno)throws BankingException;
	
	public List<Transaction> getTransactionByAccountno(long accountno)throws BankingException;


}