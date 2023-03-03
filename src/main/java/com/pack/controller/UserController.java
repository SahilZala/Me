package com.pack.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.UserDao;
import com.pack.model.User;
import com.pack.util.PathUtil;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping(PathUtil.GET_USER)
	public ResponseEntity<User> getUser(HttpServletRequest req)
	{
		return new ResponseEntity<>(
				userDao.getUserByToken(req.getHeader("Authorization").substring(7))
				,HttpStatus.OK);
	}
}
