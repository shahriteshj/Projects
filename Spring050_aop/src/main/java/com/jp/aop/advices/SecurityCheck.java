package com.jp.aop.advices;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SecurityCheck {
	
	
	@Around("execution(* com.jp.aop.services.*MyServices.*(..))")
	public Object checkAuthorization(ProceedingJoinPoint doCall ) throws Throwable{
		System.out.println("Check for authorization");
		Object obj = doCall.proceed();
		System.out.println("Logging");
		return obj;
	}

}
