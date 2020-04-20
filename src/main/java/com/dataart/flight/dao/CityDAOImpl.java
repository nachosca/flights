package com.dataart.flight.dao;

import com.dataart.flight.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityDAOImpl extends CrudRepository<City, String> {

}
