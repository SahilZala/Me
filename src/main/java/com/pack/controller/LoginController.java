package com.pack.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.model.JWTRequest;
import com.pack.model.JWTResponse;
import com.pack.model.StatusModel;
import com.pack.util.JWTUtil;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@Autowired
	public UserDetailsService userDetailsService;
	
	@Autowired
	public JWTUtil jwtUtil;
	

	@PostMapping("/login")
	public ResponseEntity<StatusModel> generateToken(@RequestBody JWTRequest jwtRequest){
		try {
				
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
			UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUserName());
			String token = jwtUtil.generateToken(userDetails);
			
			return new ResponseEntity<>(new StatusModel(LocalDateTime.now().toString(),HttpStatus.OK,"no error","/login",
					new JWTResponse(token,userDetails.getAuthorities().toArray()[0].toString())),HttpStatus.OK);
			
		}
		catch(UsernameNotFoundException ex) {
			System.out.println(ex);
			return new ResponseEntity<>(new StatusModel(LocalDateTime.now().toString(),HttpStatus.FORBIDDEN,ex.getMessage(),"/login","no data"),HttpStatus.FORBIDDEN);
		}
		catch(RuntimeException ex) {
			System.out.println(ex);
			return new ResponseEntity<>(new StatusModel(LocalDateTime.now().toString(),HttpStatus.BAD_REQUEST,ex.getMessage(),"/login","no data"),HttpStatus.BAD_REQUEST);
		}
	}
}
