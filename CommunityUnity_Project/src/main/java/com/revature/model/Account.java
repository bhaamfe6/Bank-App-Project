package com.revature.model;

public class Account {
	
	private int id;
	private String usersname;
	private String accountnum;
	private String acct_type_descrip;
	private double balance;
	
	//	private User user;
	public Account(int id, String usersname, String acct_type_descrip, String accountnum, double balance) {
		super();
		this.id = id;
		this.usersname = usersname;
		this.accountnum = accountnum;
		this.acct_type_descrip = acct_type_descrip;
		this.balance = balance;
	}
	public String getAcct_type_descrip() {
		return acct_type_descrip;
	}
	public void setAcct_type_descrip(String acct_type_descrip) {
		this.acct_type_descrip = acct_type_descrip;
	}
	public Account() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsersname() {
		return usersname;
	}
	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountnum == null) ? 0 : accountnum.hashCode());
		result = prime * result + ((acct_type_descrip == null) ? 0 : acct_type_descrip.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((usersname == null) ? 0 : usersname.hashCode());
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
		Account other = (Account) obj;
		if (accountnum == null) {
			if (other.accountnum != null)
				return false;
		} else if (!accountnum.equals(other.accountnum))
			return false;
		if (acct_type_descrip == null) {
			if (other.acct_type_descrip != null)
				return false;
		} else if (!acct_type_descrip.equals(other.acct_type_descrip))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (usersname == null) {
			if (other.usersname != null)
				return false;
		} else if (!usersname.equals(other.usersname))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Account [id=" + id + ", usersname=" + usersname + ", accountnum=" + accountnum + ", acct_type_descrip="
				+ acct_type_descrip + ", balance=" + balance + "]";
	}
	
	}

