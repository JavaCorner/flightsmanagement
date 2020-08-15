package com.ab.flightsmanagement.flyer;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author Arpit Bhardwaj
 */
public class FlyerImpl extends DelegatingIntroductionInterceptor implements Flyer{
    @Override
    public void takeOff() {
        System.out.println("Taking off");
    }

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void land() {
        System.out.println("Landing");
    }
}
