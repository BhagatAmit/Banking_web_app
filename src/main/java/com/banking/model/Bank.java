package com.banking.model;

public class Bank {
	private long accountno;
	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}
	private String custUserName;
	private String custFname;
	private String custLname;
	private String custGender;
	private String custDob;
	private long custMobileno ;
	private String custPan;
	private String custCity;
	private String custState;
	private float initialAmount;
//	for registration
	private String name;
	private String email;
	private String username;
	private String password;
// for employee login
	private String empUsername;
	private String empPassword;
	private String empname;
	public Bank() {
		// TODO Auto-generated constructor stub
	}
	public Bank(String custUserName, String custFname, String custLname, String custGender, String custDob,
			long custMobileno, String custPan, String custCity, String custState, float initialAmount) {
		super();
		this.custUserName = custUserName;
		this.custFname = custFname;
		this.custLname = custLname;
		this.custGender = custGender;
		this.custDob = custDob;
		this.custMobileno = custMobileno;
		this.custPan = custPan;
		this.custCity = custCity;
		this.custState = custState;
		this.initialAmount = initialAmount;
	}
	public Bank(String name, String email, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public Bank(String empUsername, String empPassword) {
		super();
		this.empUsername = empUsername;
		this.empPassword = empPassword;
	}
	public String getCustUserName() {
		return custUserName;
	}
	public void setCustUserName(String custUserName) {
		this.custUserName = custUserName;
	}
	public String getCustFname() {
		return custFname;
	}
	public void setCustFame(String custFname) {
		this.custFname = custFname;
	}
	public String getCustLname() {
		return custLname;
	}
	public void setCustLname(String custLname) {
		this.custLname = custLname;
	}
	public String getCustGender() {
		return custGender;
	}
	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}
	public String getCustDob() {
		return custDob;
	}
	public void setCustDob(String custDob) {
		this.custDob = custDob;
	}
	public long getCustMobileno() {
		return custMobileno;
	}
	public void setCustMobileno(long custMobileno) {
		this.custMobileno = custMobileno;
	}
	public String getCustPan() {
		return custPan;
	}
	public void setCustPan(String custPan) {
		this.custPan = custPan;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	public String getCustState() {
		return custState;
	}
	public void setCustState(String custState) {
		this.custState = custState;
	}
	public float getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(float initialAmount) {
		this.initialAmount = initialAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpUsername() {
		return empUsername;
	}
	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	@Override
	public String toString() {
		return "Bank [custUserName=" + custUserName + ", custFame=" + custFname + ", custLname=" + custLname
				+ ", custGender=" + custGender + ", custDob=" + custDob + ", custMobileno=" + custMobileno
				+ ", custPan=" + custPan + ", custCity=" + custCity + ", custState=" + custState + ", initialAmount="
				+ initialAmount + "]";
	}
	
}