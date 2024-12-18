package com.gl.springaopone.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//add class level annotations
public class LoggingAspect {

	private Logger logger=LogManager.getLogger(this.getClass());
	
	//add annotation to target exception from CustomerDAOImpl
	public void logExceptionFromDAO(Exception exception) throws Exception {

		logger.error(exception.getMessage(),exception);
		
	}

	//add annotation to target exception from CustomerServiceImpl
	public void logExceptionFromService(Exception exception) throws Exception {

		logger.error(exception.getMessage(),exception);

	}

}
