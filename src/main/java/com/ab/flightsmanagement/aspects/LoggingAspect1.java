package com.ab.flightsmanagement.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

/**
 * @author Arpit Bhardwaj
 */
@Aspect
@Order(1)
public class LoggingAspect1 {

    private Logger logger = Logger.getLogger(LoggingAspect1.class.getName());

    @Before("execution(public String com.ab.flightsmanagement.domain.Flight.getId())")
    public void loggingAdviceGetId(){
        logger.info("Flight getId method will be called");
    }

    @AfterReturning("execution(public * * .print())")
    public void loggingAdvicePrint(){
        logger.warning("A print method has been called");
    }

    @Pointcut("within(com.ab.flightsmanagement.domain.Ticket)")
    public void allTicketMethods() {}

    @After("allTicketMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
        logger.info("A ticket method had been called.");
        logger.info(joinPoint.toString());
        logger.info(joinPoint.getTarget().toString());
    }
}
