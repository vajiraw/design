package com.indigo.fashion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.indigo.fashion.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	

}
