package com.banking.service;

import java.util.List;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Transaction;

public interface BankCrudService {
	public Bank registerCustomer(Bank bank) throws BankingException;
	public Bank openCustomerAccount(Bank bank) throws BankingException;
	
	public List<Bank> getAllCustomerDetails() throws BankingException;
	
	public Transaction depositedAmount(Transaction transaction) throws BankingException;
	
	public Transaction withdrawlAmount(Transaction transaction) throws BankingException;

	public void deleteAccount(long accountno) throws BankingException;

}