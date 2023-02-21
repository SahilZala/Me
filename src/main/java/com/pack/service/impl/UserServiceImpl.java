package com.pack.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.exception.DuplicateUserException;
import com.pack.exception.UserNotFoundException;
import com.pack.model.User;
import com.pack.repository.UserRepository;
import com.pack.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	@Override
	public User findByEmailId(String emailId) throws UserNotFoundException {
		Optional<User> u = userRepo.findByMailId(emailId);
		
		if(u.isEmpty()) {
			throw new UserNotFoundException("user not found");
		}
		
		return u.get();
	}
	@Override
	public User createNewUser(User user) throws DuplicateUserException {
		
		try {
			this.findByEmailId(user.getMailId());
			throw new DuplicateUserException("Email id already in use by someone else");
			
		}
		catch(UserNotFoundException ex) {
			try {
				this.findByUsername(user.getUsername());
				throw new DuplicateUserException("Username already in use by someone else");
			}
			catch(UserNotFoundException e) {
				User u = userRepo.save(user);
			}
		}
		
		return user;
	}
	@Override
	public User findByUsername(String username) throws UserNotFoundException {
		Optional<User> u = userRepo.findByUsername(username);
		
		if(u.isEmpty()) {
			throw new UserNotFoundException("user not found");
		}
		
		return u.get();
	}
	
	
}
