package com.ab.flightsmanagement.aspects;

import com.ab.flightsmanagement.exceptions.CountryDoesNotExistException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

/**
 * @author Arpit Bhardwaj
 */

@Aspect
public class ExceptionAspect {
    private Logger logger = Logger.getLogger(ExceptionAspect.class.getName());

    @AfterThrowing(
            pointcut="execution (* com.ab.flightsmanagement.dao.PassengerDaoImpl.insert(..))",
            throwing="ex")
    public void log(CountryDoesNotExistException ex) {
        logger.severe("Attempt to insert a passenger with an unexisting country: " + ex.getCountryCode());
    }
}
