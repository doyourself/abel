package com.xx.abel.exceptionAdvice;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 
 * @author : AlenLi  E-mail : hlwan_cn@hotmail.com
 * @version:         Created：2011-7-5 上午11:03:11
 *
 */
public class ExceptionAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice, ThrowsAdvice {
	
	Logger logger =  Logger.getLogger(ExceptionAdvice.class);
	
	private long beforeRunTime;

	private long afterRunTime;

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		beforeRunTime = System.currentTimeMillis();
		// 类名
		
		String clazzName = target.getClass().getName();
		// 方法名
		String methodName = method.getName();
		logger.error("类"+clazzName+"的"+methodName+"方法,开始执行============Alen");
	}

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		afterRunTime = System.currentTimeMillis();
		long durationTimes = afterRunTime - beforeRunTime;

		String clazzName = target.getClass().getName();

		String methodName = method.getName();
		logger.error("类"+clazzName+"的"+methodName+"方法,执行完成==耗时"+durationTimes+"ms====Alen");

	}

	/**
	 * 对未知异常的处理.
	 * 
	 * @param method
	 * @param args
	 * @param target
	 * @param ex
	 * @throws Throwable
	 */
	public void afterThrowing(Method method, Object[] args, Object target,
			Exception ex) throws Throwable {
		logger.error("*****************全局异常捕获开始********************");
		logger.error("Error happened in class: "
				+ target.getClass().getName());
		logger.error("Error happened in method: " + method.getName());

		for (int i = 0; i < args.length; i++) {
			System.out.println("arg[" + i + "]: " + args[i]);
		}
		
		logger.error("Exception class: " + ex.getClass().getName());
		logger.error("*************全局异常捕获结束************************");
	}

	/**
	 * 对NullPointerException异常的处理
	 * 
	 * @param method
	 * @param args
	 * @param target
	 * @param ex
	 * @throws Throwable
	 */
	public void afterThrowing(Method method, Object[] args, Object target,
			NullPointerException ex) throws Throwable {
		logger.error("****************全局异常捕获开始*********************");
		logger.error("Error happened in class: "+ target.getClass().getName());
		logger.error("Error happened in method: " + method.getName());

		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]: " + args[i]);
		}
		logger.error("Exception class: " + ex.getClass().getName());
		logger.error("******************全局异常捕获结束*******************");
	}

}