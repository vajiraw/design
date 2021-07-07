package com.indigo.fashion.service;

import java.util.List;

import com.indigo.fashion.model.City;

public interface CityService {
	
	
	boolean contais(String name);
	List<City> findAll();
	City save(City city);

}
