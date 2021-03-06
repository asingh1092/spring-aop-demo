package com.singh.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.singh.aopdemo.dao.AccountDAO;
import com.singh.aopdemo.dao.MembershipDAO;
import com.singh.aopdemo.entity.Account;

public class MainApp {

	public static void main(String[] args) {
		//read spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		try {
			// get bean from spring container
			AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
			MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
			
			// call the business method
			Account account = new Account();
			accountDAO.addAccount();
			accountDAO.addAccount(account);
			accountDAO.addAccount(account, true);
			accountDAO.doWork();
			membershipDAO.addMember();
			membershipDAO.goToSleep();

			// close the context
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}

}
