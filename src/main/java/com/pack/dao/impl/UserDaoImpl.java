package com.pack.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dao.UserDao;
import com.pack.model.User;
import com.pack.service.UserService;
import com.pack.util.JWTUtil;

@Service
public class UserDaoImpl implements UserDao {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JWTUtil jwtUtil;
	@Override
	public User getUserByToken(String token) {
		return userService.findByEmailId(jwtUtil.extractUsername(token));
	}
}
