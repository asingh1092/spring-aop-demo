package com.singh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoPointcutDeclarationAspect {
	
	// create pointcut for package
	@Pointcut("execution(* com.singh.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create pointcut for getter methods
	@Pointcut("execution(* com.singh.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut for setter methods
	@Pointcut("execution(* com.singh.aopdemo.dao.*.set*(..))")
	private void setter() {
	}
	
	// combine pointcut: include package but exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {

	}
	
	// apply pointcut declaration to Advices
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountWithAnyParamAdvice() {
		System.out.println(getClass() + ": executing @Before advice on any dao class and method");
	}

	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		System.out.println(getClass() + ": Performing API Analytics");
	}
	
}
