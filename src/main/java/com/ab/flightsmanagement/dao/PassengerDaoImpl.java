package com.ab.flightsmanagement.dao;

import com.ab.flightsmanagement.domain.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */
public class PassengerDaoImpl implements PassengerDao{

    private static Map<Integer, Passenger> passengersMap = new HashMap<>();
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public Passenger getPassenger(int id) {
        if (passengersMap.get(id) != null){
            return passengersMap.get(id);
        }
        Passenger passenger = getById(id);
        return passenger;
    }

    private RowMapper<Passenger> rowMapper = (resultSet, rowNum) -> {
        Passenger passenger = new Passenger();
        passenger.setName(resultSet.getString("name"));
        passenger.setCountry(resultSet.getString("country"));
        return passenger;
    };

    private Passenger getById(int id) {
        String sql = "SELECT * FROM PASSENGERS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
