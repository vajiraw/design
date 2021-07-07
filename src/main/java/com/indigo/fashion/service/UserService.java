package com.indigo.fashion.service;

import java.util.Optional;

import com.indigo.fashion.model.User;

public interface UserService {
	
	public Optional<User> findUserbyId(Long Id);

}
