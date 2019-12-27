package com.singh.aopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	// point cut expression is the stuff in the quotes
	@Before("execution(public void com.singh.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println(getClass() + ": executing @Before advice on addAccount()");
	}
	
	@Before("execution(* add*(com.singh.aopdemo.entity.Account))")
	public void beforeAddAccountWithAccountParamAdvice() {
		System.out.println(getClass() + ": executing @Before advice on addAccount(Account account)");
	}
	
	@Before("execution(* add*(com.singh.aopdemo.entity.Account, ..))")
	public void beforeAddAccountWithAccountBooleanParamAdvice() {
		System.out.println(getClass() + ": executing @Before advice on addAccount(Account account, boolean vipFlag)");
	}
	
	@Before("execution(* com.singh.aopdemo.dao.*.*(..))")
	public void beforeAddAccountWithAnyParamAdvice() {
		System.out.println(getClass() + ": executing @Before advice on any dao class and method");
	}

	
	@AfterReturning("execution(* add*()))")
	public void afterReturningAddAccountAdvice() {
		System.out.println(getClass() + ": executing @AfterReturning advice on addAccount()");
	}
}
