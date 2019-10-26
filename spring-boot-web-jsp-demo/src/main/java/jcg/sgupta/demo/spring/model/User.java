package jcg.sgupta.demo.spring.model;

import jcg.sgupta.demo.spring.entity.Account;

public class User {

	private String userName;

	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
