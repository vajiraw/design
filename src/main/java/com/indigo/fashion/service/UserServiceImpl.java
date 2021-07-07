package com.indigo.fashion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.indigo.fashion.model.User;
import com.indigo.fashion.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepositry;
	
	
	@Override
	public Optional<User> findUserbyId(Long id) {
		Optional<User> user = userRepositry.findById(id);
		return user;
	}

}
