package com.banking.model;
public class Account {
private int accno;
private String custFname;
private String custUserName;
private float openingbalance;
@Override
public String toString() {
	return "Account [accno=" + accno + ", custFname=" + custFname + ", custUserName=" + custUserName
			+ ", openingBalance=" + openingbalance + "]";
}
public Account() {
	// TODO Auto-generated constructor stub
}
public Account(int accno, String custFname, String custUserName, float openingBalance) {
	super();
	this.accno = accno;
	this.custFname = custFname;
	this.custUserName = custUserName;
	this.openingbalance = openingBalance;
}
public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}
public String getCustFname() {
	return custFname;
}
public float getOpeningbalance() {
	return openingbalance;
}
public void setOpeningbalance(float openingbalance) {
	this.openingbalance = openingbalance;
}
public void setCustFname(String custFname) {
	this.custFname = custFname;
}
public String getCustUserName() {
	return custUserName;
}
public void setCustUserName(String custUserName) {
	this.custUserName = custUserName;}
}
