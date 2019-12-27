package com.singh.aopdemo;

import java.io.Closeable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.singh.aopdemo.dao.AccountDAO;
import com.singh.aopdemo.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {
		//read spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		try {
			// get bean from spring container
			AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
			MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

			// call the business method
			accountDAO.addAccount();
			membershipDAO.addMember();

			// close the context
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}

}
