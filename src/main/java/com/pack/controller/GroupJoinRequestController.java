package com.pack.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.GroupJoinRequestDao;
import com.pack.model.GroupJoinRequest;
import com.pack.util.PathUtil;

@RestController
@CrossOrigin
public class GroupJoinRequestController {
	
	@Autowired
	GroupJoinRequestDao groupJoinRequestDao;
	
	@PostMapping(PathUtil.PUSH_JOIN_REQUEST)
	public ResponseEntity<GroupJoinRequest> pushRequest(
			HttpServletRequest req,
			@RequestBody Map<String,String> gid)
	{
		
		return new ResponseEntity<>( groupJoinRequestDao.pushJoiningRequest(
				gid.get("gid"), 
				req.getHeader("Authorization").substring(7)),
				HttpStatus.OK);
	}
}
