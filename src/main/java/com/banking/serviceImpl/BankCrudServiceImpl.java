package com.banking.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.banking.dao.BankingDao;
import com.banking.dao.impl.BankingDaoImpl;
import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Transaction;
import com.banking.service.BankCrudService;

public class BankCrudServiceImpl implements BankCrudService {
	private BankingDao bankDAO=new BankingDaoImpl();
	@Override
	public Bank registerCustomer(Bank bank) throws BankingException {
		//if(bank.getName()!=null && bank.getEmail()!=null && bank.getUsername()!=null && bank.getPassword()!=null) {
			bank = bankDAO.registerCustomer(bank);
		//}
	//	else {
			//throw new BankingException("Invalid Details...");
		//}
		
		return bank;
	}

	@Override
	public Bank openCustomerAccount(Bank bank) throws BankingException {
		if(bank.getCustFname()!=null && bank.getCustLname()!=null
				&& bank.getCustGender()!=null && bank.getCustDob()!=null && bank.getCustMobileno()!=0
				&& bank.getCustPan()!=null && bank.getCustCity()!=null && bank.getCustState()!=null && bank.getInitialAmount()>=0.0) {
			bank = bankDAO.openCustomerAccount(bank);
		}
		else {
			throw new BankingException("Invalid Details...");
		}
		return bank;
	}

	@Override
	public List<Bank> getAllCustomerDetails() throws BankingException {
		System.out.println("inside service ");
	//	Bank bank =new Bank();
		List<Bank> bankList = new ArrayList<>();
//		
				bankList = bankDAO.getAllCustomerDetails();
				System.out.println("Came from dao");
				System.out.println(bankList);
		return bankList;
	}




	@Override
	public Transaction depositedAmount(Transaction transaction) throws BankingException {
		if(transaction.getDepositedAmount()!=0)
		{
		//	System.out.println("inside service");
			BankingDao bankingDao=new BankingDaoImpl();
			bankingDao.depositedAmount(transaction);
		}
		return transaction;
	}

	@Override
	public Transaction withdrawlAmount(Transaction transaction) throws BankingException {
		if(transaction.getWithdrawlAmount()!=0)
		{
			//System.out.println("inside service");
			BankingDao bankingDao=new BankingDaoImpl();
			bankingDao.withdrawlAmount(transaction);
		}
		return transaction;
	}

	@Override
	public void deleteAccount(long accountno) throws BankingException {
	if(accountno!=0)
	{
		BankingDao bankingDao=new BankingDaoImpl();
		bankingDao.deleteAccount(accountno);
	}
	else
	{
		System.out.println("account not found");
	}
		
	}


//
//	@Override
//	public Transaction withDrawAmount(Transaction transaction1) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Transaction depositAmount(Transaction transaction) throws BankingException{
//		transaction =bankDAO.depositAmount(transaction);
//		return transaction;
//	}
//
//	@Override
//	public Transaction withDrawAmount(Transaction transaction1) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}