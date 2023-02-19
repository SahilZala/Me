package com.pack.service;

import com.pack.model.User;

public interface UserService {
	User findByEmailId(String emailId);
	User createNewUser(User user);
}
