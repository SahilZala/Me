package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.model.User;
import com.pack.service.UserService;

@RestController
@CrossOrigin
public class CrateUserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<User> createNewUser(@RequestBody User u) {
		User user = userService.createNewUser(u);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
