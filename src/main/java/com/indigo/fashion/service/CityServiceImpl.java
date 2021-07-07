package com.indigo.fashion.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indigo.fashion.model.City;
import com.indigo.fashion.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{
	@Autowired
	CityRepository cityRepository;
	

	@Override
	public List<City> findAll() {
		List<City> cities = (List<City>) cityRepository.findAll();		
		return (List<City>) cityRepository.findAll();
	}


	@Override
	public City save(City city) {
		City city2 = cityRepository.save(city);
		return city2;
	}


	@Override
	public boolean contais(String name) {
		List<String> words = Arrays.asList("work","sonna","punk","weed");
		
		return words.contains(name);
	}


	
	

}
