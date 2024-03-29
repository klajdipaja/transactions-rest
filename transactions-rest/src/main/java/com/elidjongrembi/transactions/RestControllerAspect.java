package com.elidjongrembi.transactions;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    @Before("execution(public * com.elidjongrembi.transactions.api.rest.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
    	
    	log.info(":::::AOP Before REST call:::::" + pjp);
    }
    
    private static final Logger log = LoggerFactory.getLogger(RestControllerAspect.class);
}
