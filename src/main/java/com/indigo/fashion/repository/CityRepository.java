package com.indigo.fashion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.indigo.fashion.model.City;


@Repository
public interface CityRepository extends CrudRepository<City,Long> {
	

}
