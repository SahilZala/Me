package com.pack.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.GroupDao;
import com.pack.model.Group;
import com.pack.util.PathUtil;

@RestController
@CrossOrigin
public class GroupController {
	
	@Autowired 
	GroupDao groupDao;
	
	@PostMapping(PathUtil.CREATE_GROUP_PATH)
	public ResponseEntity<Group> createGroup(HttpServletRequest req,@RequestBody Group group){
		return new ResponseEntity<>(
				groupDao.createGroup(
						group,
						req.getHeader("Authorization").substring(7)),
				HttpStatus.OK);
	}
	
	@GetMapping(PathUtil.GET_ALL_GROUP_LIST)
	public ResponseEntity<List<Group>> getGroupList(){
		return new ResponseEntity<>(groupDao.getAllGroupList(),HttpStatus.OK);
	}
	
	@GetMapping(PathUtil.GET_GROUP_BY_USERID)
	public ResponseEntity<List<Group>> getGroupListByUserId(@PathVariable("userId") String userId)
	{
		return new ResponseEntity<>(groupDao.getGroupListByCreatorId(userId),HttpStatus.OK);
	}
	
	@PutMapping(PathUtil.MAKE_MEMBER)
	public ResponseEntity<Group> makeMember(HttpServletRequest req,@RequestBody HashMap<String,String> data)
	{
		return new ResponseEntity<>(groupDao.makeMemberOfGroup(
				data.get("memberId"),
				data.get("groupId"),
				req.getHeader("Authorization").substring(7)),HttpStatus.OK);
	}
	
	@GetMapping(PathUtil.GET_GROUP_OF_USER)
	public ResponseEntity<List<Group>> getGroupListByToken(HttpServletRequest req)
	{
		return new ResponseEntity<>(
				groupDao.getAllGroupOfUser(
						req.getHeader("Authorization").substring(7)),
				HttpStatus.OK);
	}
	
	@GetMapping(PathUtil.GET_GROUP_NOT_USER)
	public ResponseEntity<List<Group>> getAllUserNotGroup(HttpServletRequest req)
	{
		return new ResponseEntity<>(
				groupDao.getAllGroupOfNotUser(
						req.getHeader("Authorization").substring(7)),
				HttpStatus.OK);
	}
	
}
