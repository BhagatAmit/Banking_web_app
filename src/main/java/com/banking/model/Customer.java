package com.banking.model;

public class Customer {
	//for Customer Login
			private String custUserName;
			private String custPassword;
			public Customer() {
				// TODO Auto-generated constructor stub
			}
			public Customer(String custUserName, String custPassword) {
				super();
				this.custUserName = custUserName;
				this.custPassword = custPassword;
			}
			public String getCustUserName() {
				return custUserName;
			}
			public void setCustUserName(String custUserName) {
				this.custUserName = custUserName;
			}
			public String getCustPassword() {
				return custPassword;
			}
			public void setCustPassword(String custPassword) {
				this.custPassword = custPassword;
			}
			@Override
			public String toString() {
				return "Customer [custUserName=" + custUserName + ", custPassword=" + custPassword + "]";
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((custPassword == null) ? 0 : custPassword.hashCode());
				result = prime * result + ((custUserName == null) ? 0 : custUserName.hashCode());
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
				Customer other = (Customer) obj;
				if (custPassword == null) {
					if (other.custPassword != null)
						return false;
				} else if (!custPassword.equals(other.custPassword))
					return false;
				if (custUserName == null) {
					if (other.custUserName != null)
						return false;
				} else if (!custUserName.equals(other.custUserName))
					return false;
				return true;
			}
}