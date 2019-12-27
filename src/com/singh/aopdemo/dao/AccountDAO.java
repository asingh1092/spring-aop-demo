package com.singh.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.singh.aopdemo.entity.Account;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(getClass() + " : doing DB work - adding an account.");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + " : doing DB work with Account parameter");
	}
	
}
