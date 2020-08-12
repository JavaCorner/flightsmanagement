package com.ab.flightsmanagement.aspects;

import com.ab.flightsmanagement.dao.PassengerDaoImpl;
import com.ab.flightsmanagement.domain.Passenger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

/**
 * @author Arpit Bhardwaj
 */
@Aspect
@Order(3)
public class CachingAspect {

    @Around("execution(* com.ab.flightsmanagement.dao.PassengerDaoImpl.getPassenger(..))")
    public void cachePassenger(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        Object[] methodArgs = thisJoinPoint.getArgs();
        Passenger result = (Passenger)thisJoinPoint.proceed();

        int id = (Integer)methodArgs[0];
        if (!PassengerDaoImpl.getPassengersMap().containsKey(id)) {
            PassengerDaoImpl.getPassengersMap().put(id, result);
        }
    }

}
