package com.singh.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMember() {
		System.out.println(getClass() + ": doing db work - adding a membership account");
	}
}
