package com.ab.flightsmanagement.dao;

import com.ab.flightsmanagement.domain.Passenger;

/**
 * @author Arpit Bhardwaj
 */
public interface PassengerDao {
    Passenger getPassenger(int id);
}
