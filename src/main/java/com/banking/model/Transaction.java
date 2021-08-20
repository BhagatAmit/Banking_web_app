package com.banking.model;

public class Transaction {
private int tid;
private long accountno;
private double previousBalance;
private double withdrawlAmount;
private double depositedAmount;
private String transactionDate;
private double currbalance;
public Transaction() {
	// TODO Auto-generated constructor stub
}
public Transaction(long accountno, double depositedAmount) {
	super();
	this.accountno = accountno;
	this.depositedAmount = depositedAmount;
}
public Transaction(long accountno, double previousBalance, double withdrawlAmount, double depositedAmount,
		 double currbalance) {
	super();
	this.accountno = accountno;
	this.previousBalance = previousBalance;
	this.withdrawlAmount = withdrawlAmount;
	this.depositedAmount = depositedAmount;
	//this.transactionDate = transactionDate;
	this.currbalance = currbalance;
}
@Override
public String toString() {
	return "Transaction [tid=" + tid + ", accountno=" + accountno + ", previousBalance=" + previousBalance
			+ ", withdrawlAmount=" + withdrawlAmount + ", depositedAmount=" + depositedAmount + ", transactionDate="
			+ transactionDate + ", currbalance=" + currbalance + "]";
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public Transaction(int tid) {
	super();
	this.tid = tid;
}
public long getAccountno() {
	return accountno;
}
public void setAccountno(long accountno) {
	this.accountno = accountno;
}
public double getPreviousBalance() {
	return previousBalance;
}
public void setPreviousBalance(double previousBalance) {
	this.previousBalance = previousBalance;
}
public double getWithdrawlAmount() {
	return withdrawlAmount;
}
public void setWithdrawlAmount(double withdrawlAmount) {
	this.withdrawlAmount = withdrawlAmount;
}
public double getDepositedAmount() {
	return depositedAmount;
}
public void setDepositedAmount(double depositedAmount) {
	this.depositedAmount = depositedAmount;
}
public String getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(String transactionDate) {
	this.transactionDate = transactionDate;
}
public double getCurrbalance() {
	return currbalance;
}
public void setCurrbalance(double currbalance) {
	this.currbalance = currbalance;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (accountno ^ (accountno >>> 32));
	long temp;
	temp = Double.doubleToLongBits(currbalance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(depositedAmount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(previousBalance);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
	temp = Double.doubleToLongBits(withdrawlAmount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Transaction other = (Transaction) obj;
	if (accountno != other.accountno)
		return false;
	if (Double.doubleToLongBits(currbalance) != Double.doubleToLongBits(other.currbalance))
		return false;
	if (Double.doubleToLongBits(depositedAmount) != Double.doubleToLongBits(other.depositedAmount))
		return false;
	if (Double.doubleToLongBits(previousBalance) != Double.doubleToLongBits(other.previousBalance))
		return false;
	if (transactionDate == null) {
		if (other.transactionDate != null)
			return false;
	} else if (!transactionDate.equals(other.transactionDate))
		return false;
	if (Double.doubleToLongBits(withdrawlAmount) != Double.doubleToLongBits(other.withdrawlAmount))
		return false;
	return true;
}

}