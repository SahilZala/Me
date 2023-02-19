package com.pack.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.exception.UserNotFoundException;
import com.pack.model.User;
import com.pack.repository.UserRepository;
import com.pack.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	@Override
	public User findByEmailId(String emailId) {
		Optional<User> u = userRepo.findByMailId(emailId);
		
		if(u.isEmpty()) {
			throw new UserNotFoundException("user not found");
		}
		
		return u.get();
	}
	@Override
	public User createNewUser(User user) {
		User u = userRepo.save(user);
		return u;
	}
	
	
}
