package com.banking.service;

import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Customer;

public interface BankLoginService {
	public boolean isValidEmployeeCredentials(Bank bank) throws BankingException;
	public boolean customerLogin(Customer customer) throws BankingException;
}