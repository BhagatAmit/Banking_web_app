package com.banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

import com.banking.dao.BankingDao;
import com.banking.dbutil.PostgresConnection;
import com.banking.exception.BankingException;
import com.banking.model.Bank;
import com.banking.model.Customer;
import com.banking.model.Transaction;

public class BankingDaoImpl implements BankingDao{
	private static Logger log = Logger.getLogger(BankingDao.class);

	



	@Override
	public Bank registerCustomer(Bank bank) throws BankingException {
		try(Connection connection = PostgresConnection.getConnection()){
			String sql = "insert into bank_schema.customerlogin(name,email,username,password) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, bank.getName());
			preparedStatement.setString(2, bank.getEmail());
			preparedStatement.setString(3, bank.getUsername());
			preparedStatement.setString(4, bank.getPassword());
			int rowAffected = preparedStatement.executeUpdate();
			if(rowAffected!=1) {
				log.info("Rows not affected");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
		return bank;
	}

	@Override
	public Bank openCustomerAccount(Bank bank) throws BankingException {
		try(Connection connection = PostgresConnection.getConnection()){
			
			System.out.println(bank);
			String sql = "insert into bank_schema.customerpersonal(custusername,custfname,custlname,custgender,custdob,custmobileno,custpan,custcity,custstate,initialamount)values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,bank.getCustUserName());
			preparedStatement.setString(2,bank.getCustFname());
			preparedStatement.setString(3,bank.getCustLname());
			preparedStatement.setString(4,bank.getCustGender());
			preparedStatement.setString(5,bank.getCustDob());
			preparedStatement.setLong(6, bank.getCustMobileno());
			preparedStatement.setString(7,bank.getCustPan());
			preparedStatement.setString(8,bank.getCustCity());
			preparedStatement.setString(9,bank.getCustState());
			preparedStatement.setFloat(10, bank.getInitialAmount());
			
			
			int c=preparedStatement.executeUpdate();
			if(c==1) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					bank.setAccountno(resultSet.getLong("accountno"));
					
				}
			}

			String sql1 = "insert into bank_schema.customeraccount(custusername,currbalance) values(?,?) ";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			preparedStatement1.setString(1,bank.getCustUserName());
			preparedStatement1.setFloat(2, bank.getInitialAmount());
			
			int d=preparedStatement1.executeUpdate();
			if(c!=1) {
				log.info("NO rows has been affected"); 
			}
			if(d!=1) {
				log.info("NO rows has been affected");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
		return bank;
	}

	@Override
	public List<Bank> getAllCustomerDetails() throws BankingException {
		
		List<Bank> bankList=new ArrayList<>();
		try(Connection connection = PostgresConnection.getConnection()){
			System.out.println("inside dao try");
		//	String sql = "select custusername,custfname,custlname,custgender,custdob,custmobile,custpan,custcity,custstate,initialamount from bank_schema.customerpersonal";
			String sql = "select * from bank_schema.customerpersonal";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("inside resultset");
				Bank bank = new Bank();
				
				bank.setCustUserName(resultSet.getString("custusername"));
				bank.setCustFame(resultSet.getString("custfname"));
				bank.setCustLname(resultSet.getString("custlname"));
				bank.setCustGender(resultSet.getString("custgender"));
				bank.setCustDob(resultSet.getString("custdob"));
				bank.setCustMobileno(resultSet.getLong("custmobileno"));
				bank.setCustPan(resultSet.getString("custpan"));
				bank.setCustCity(resultSet.getString("custcity"));
				bank.setCustState(resultSet.getString("custstate"));
				bank.setInitialAmount(resultSet.getFloat("initialamount"));
				System.out.println(bank);
				bankList.add(bank);
			}
			System.out.println(bankList.size());
			if(bankList.size()==0) {
				throw new BankingException("No Customer details exists as of now");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured....Kindly Contact SysAdmin");
		}
		return bankList;
	}

	
	@Override
	public boolean customerLogin(Customer customer) throws BankingException {
		boolean b=false;
		try(Connection connection = PostgresConnection.getConnection()){
		
			String sql="select username,password from bank_schema.customerlogin where username=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCustUserName());
			preparedStatement.setString(2, customer.getCustPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()) {
//			customer.setCustUserName(resultSet.getString("username"));
//				customer.setCustPassword(resultSet.getString("password"));
//			}
			if(resultSet.next())
			{
				b=true;
			}
			else
				throw new BankingException("Invalid Credentials");
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
	
		return b;
	}



	@Override
	public String getCustomerByUsername(String username) throws BankingException {
		String string=null;
		try (Connection connection=PostgresConnection.getConnection()){
			String sql="Select * from bank_schema.customerlogin where username=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,username);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				string=resultSet.getString("username");
			}
			
		}catch (Exception e) {
			
		}
		return string;
	}

	@Override
	public String getPassWordByUsername(String username,String password) throws BankingException {
		String string=null;
		//log.info("inside Dao");
		try (Connection connection=PostgresConnection.getConnection()){
			String sql="Select password from bank_schema.customerlogin where username=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);

			ResultSet resultSet=preparedStatement.executeQuery();
			
			//System.out.println(password);
			if(resultSet.next())
			{
				//System.out.println("inside resultset");
				string=resultSet.getString("password");
			}
			
		}catch (Exception e) {
			
		}
		return string;
	}

	@Override
	public Transaction depositedAmount(Transaction transaction) throws BankingException {
		try (Connection connection=PostgresConnection.getConnection()){
		
			int rowAffected=0;
			String sql="INSERT INTO bank_schema.\"transaction\"\r\n" + 
					"(accountno, \"previousBalance\", currbalance, \"depositedAmount\", \"withdrawlAmount\")\r\n" + 
					"VALUES(?,?,?,?,?);";
			PreparedStatement preparedStatement=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,transaction.getAccountno());
			preparedStatement.setDouble(2,transaction.getPreviousBalance());
			preparedStatement.setDouble(4,transaction.getDepositedAmount());
			//preparedStatement.setString(2, transaction.getTransactionDate());
			preparedStatement.setDouble(3, transaction.getCurrbalance());
			preparedStatement.setDouble(5,transaction.getWithdrawlAmount());
			rowAffected=preparedStatement.executeUpdate();
			
			  //ResultSet resultSet = preparedStatement.getGeneratedKeys();
				//int c1 = preparedStatement1.executeUpdate();

				if (rowAffected== 1 ) {
					ResultSet resultSet = preparedStatement.getGeneratedKeys();
					if (resultSet.next()) {
						transaction.setTid(resultSet.getInt("tid"));
						transaction.setTransactionDate(resultSet.getString("transactionDate"));
					}
				}
				String sql1="update bank_schema.customeraccount set currbalance=? where accountno=?";
				PreparedStatement preparedStatement2=connection.prepareStatement(sql1);
				preparedStatement2.setDouble(1,transaction.getCurrbalance());
				preparedStatement2.setLong(2, transaction.getAccountno());
				int c=preparedStatement2.executeUpdate();
				if(c!=0)
				{
					log.info("account table updated Succesfully");
				}
			//ResultSet resultSet=preparedStatement.executeQuery();
//			if(resultSet.next())
//			{
//				  //ResultSet resultSet = preparedStatement.getGeneratedKeys();
//
//				Transaction transaction1=new Transaction();
//				transaction1.setTransactionDate(resultSet.getString(1));
//				transaction1.setTid(resultSet.getInt(1));
//
//				
//			}
//			if(rowAffected!=1)
//			{
//				log.info("No rows affected");
//			}
		
		}catch (Exception e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}

		return transaction;
	}

	@Override
	public long getCustomerByAccountno(long accountno) throws BankingException {
		long found=0;

		try (Connection connection=PostgresConnection.getConnection()){
			String sql="select * from bank_schema.customeraccount where accountno=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setLong(1,accountno);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				found=1;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
			return found;
	}

	@Override
	public double getCurrbalanceByAccountno(long accountno) throws BankingException {
		double currbalance=0;
		try (Connection connection=PostgresConnection.getConnection()){
			String sql="select currbalance from bank_schema.customeraccount where accountno=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setLong(1,accountno);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
		//		Transaction transaction=new Transaction();
				
				currbalance=resultSet.getDouble("currbalance");
				//System.out.println(currbalance);
			}
			
		}catch (Exception e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
			return currbalance;
		
	}

	@Override
	public Transaction withdrawlAmount(Transaction transaction) throws BankingException {
		try (Connection connection=PostgresConnection.getConnection()){
			//System.out.println("inside dao");
			int rowAffected=0;
			String sql="INSERT INTO bank_schema.\"transaction\"\r\n" + 
					"(accountno, \"previousBalance\", currbalance, \"depositedAmount\", \"withdrawlAmount\")\r\n" + 
					"VALUES(?,?,?,?,?);";
			PreparedStatement preparedStatement=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,transaction.getAccountno());
			preparedStatement.setDouble(2,transaction.getPreviousBalance());
			preparedStatement.setDouble(4,transaction.getDepositedAmount());
			//preparedStatement.setString(2, transaction.getTransactionDate());
			preparedStatement.setDouble(3, transaction.getCurrbalance());
			preparedStatement.setDouble(5,transaction.getWithdrawlAmount());
			rowAffected=preparedStatement.executeUpdate();
			
			  //ResultSet resultSet = preparedStatement.getGeneratedKeys();
				//int c1 = preparedStatement1.executeUpdate();

				if (rowAffected== 1 ) {
					ResultSet resultSet = preparedStatement.getGeneratedKeys();
					if (resultSet.next()) {
						transaction.setTid(resultSet.getInt("tid"));
						transaction.setTransactionDate(resultSet.getString("transactionDate"));
					}
				}
				String sql1="update bank_schema.customeraccount set currbalance=? where accountno=?";
				PreparedStatement preparedStatement2=connection.prepareStatement(sql1);
				preparedStatement2.setDouble(1,transaction.getCurrbalance());
				preparedStatement2.setLong(2, transaction.getAccountno());
				int c=preparedStatement2.executeUpdate();

			//ResultSet resultSet=preparedStatement.executeQuery();
//			if(resultSet.next())
//			{
//				  //ResultSet resultSet = preparedStatement.getGeneratedKeys();
//
//				Transaction transaction1=new Transaction();
//				transaction1.setTransactionDate(resultSet.getString(1));
//				transaction1.setTid(resultSet.getInt(1));
//
//				
//			}
//			if(rowAffected!=1)
//			{
//				log.info("No rows affected");
//			}
		
		}catch (Exception e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}

		return transaction;
	}

	@Override
	public List<Transaction> getTransactionByAccountno(long accountno) throws BankingException {
	//	Transaction transaction=null;
		List<Transaction> list=new ArrayList<>();
;		try (Connection connection=PostgresConnection.getConnection()){
			String sql="SELECT accountno, \"transactionDate\", \"previousBalance\", currbalance, \"depositedAmount\", \"withdrawlAmount\", tid\r\n" + 
					"FROM bank_schema.\"transaction\" where accountno=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setLong(1,accountno);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			//log.info("inside dao");
			Transaction transaction=new Transaction();
			
			transaction.setAccountno(resultSet.getLong("accountno"));
			transaction.setTid(resultSet.getInt("tid"));
			transaction.setCurrbalance(resultSet.getDouble("currbalance"));
			transaction.setDepositedAmount(resultSet.getDouble("depositedAmount"));
			transaction.setWithdrawlAmount(resultSet.getDouble("withdrawlAmount"));
			transaction.setPreviousBalance(resultSet.getDouble("previousBalance"));
			transaction.setTransactionDate(resultSet.getString("transactionDate"));
			//log.info(transaction);
			list.add(transaction);
		}
			if(list.size()==0)
				throw new BankingException("No transaction done till now");
			
			
			
		}catch (ClassNotFoundException| SQLException e) {
		throw new BankingException("Internal error occured... Kindly conatct SYSADMIN........");
		}
		return list;
	}

	@Override
	public boolean isValidEmployeeCredentials(Bank bank) throws BankingException {
		boolean b = false;
		try(Connection connection = PostgresConnection.getConnection()){
			String sql="select empusername from bank_schema.employee where empusername =? and emppassword = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bank.getEmpUsername());
			preparedStatement.setString(2, bank.getEmpPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				b=true;
			}else {
				throw new BankingException("Invaid Login Credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
		return b;
	}

	@Override
	public void deleteAccount(long accountno) throws BankingException {
	
		try(Connection connection = PostgresConnection.getConnection()){
			System.out.println("inside dao");
//			String sql="DELETE FROM bank_schema.customerpersonal\r\n" + 
//					"WHERE accountno=?";
			String sql1="DELETE FROM bank_schema.customeraccount\r\n" + 
					"WHERE accountno=?";
			String sql2="DELETE FROM bank_schema.transaction\r\n" + 
					"WHERE accountno=?";
			//PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

//			preparedStatement.setLong(1,accountno);
			preparedStatement1.setLong(1,accountno);
			preparedStatement2.setLong(1,accountno);

			//int c=preparedStatement.executeUpdate();
			int d=preparedStatement1.executeUpdate();
			int e=preparedStatement2.executeUpdate();

			if(d==1 && e==1)
			{
				System.out.println("Account deleted Successfully");
			}else {
				throw new BankingException("Invaid Login Credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BankingException("Internal Error Occured... Kindly contact SysAdmin");
		}
	
	
		
	}

}