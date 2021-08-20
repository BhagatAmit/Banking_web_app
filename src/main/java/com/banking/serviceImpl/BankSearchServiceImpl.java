package com.banking.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.banking.dao.BankingDao;
import com.banking.dao.impl.BankingDaoImpl;
import com.banking.exception.BankingException;
import com.banking.model.Transaction;
import com.banking.service.BankSearchService;


public class BankSearchServiceImpl implements BankSearchService {
	private static Logger log = Logger.getLogger(BankSearchServiceImpl.class);

BankingDao bankingDao=new BankingDaoImpl();
	@Override
	public String getCustomerByUsername(String username) throws BankingException {
		String str1=null;
		try {
		
		if(username!=null) {
			str1=bankingDao.getCustomerByUsername(username);
		}
		}
		catch (Exception e) {
			log.info("INVALID DETAILS...");
		
		}	
		return str1;
		
	}
	@Override
	public String  getPassWordByUsername(String username,String password) throws BankingException {
		//log.info("inside service");
		String str1=null;
		try {
		
		if(password!=null) {
			str1=bankingDao.getPassWordByUsername(username,password);
		}
		}
		catch (Exception e) {
			log.info("INVALID DETAILS...");
		
		}	
		return str1;
	}
	@Override
	public long getCustomerByAccountno(long accountno) throws BankingException {
		long accountpresent=0;
		if(accountno!=0)
		{
			accountpresent=bankingDao.getCustomerByAccountno(accountno);
			
			
		}
		
		return accountpresent ;
	}
	@Override
	public double getCurrbalanceByAccountno(long accountno) throws BankingException {
		double currbalance=0;
		if(accountno!=0)
		{
			currbalance=bankingDao.getCurrbalanceByAccountno(accountno);
			
			
		}
		return currbalance;
	}
	@Override
	public List<Transaction> getTransactionByAccountno(long accountno) throws BankingException {
		
		List<Transaction> list=null;
		if(accountno==0) {
			throw new BankingException("Invalid Accountno : "+accountno);
		}else {
			//code here to DAO
			list=bankingDao.getTransactionByAccountno(accountno);
		}
		return list;
	}
	

}