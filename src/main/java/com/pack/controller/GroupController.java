package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.model.Group;
import com.pack.service.GroupService;
import com.pack.util.PathUtil;

@RestController
@CrossOrigin
public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	@PostMapping(PathUtil.CREATE_GROUP_PATH)
	public ResponseEntity<Group> createGroup(@RequestBody Group group){
		
		group = groupService.createGroup(group);
		
		return new ResponseEntity<>(group,HttpStatus.OK);
	}
	
	@GetMapping(PathUtil.GET_ALL_GROUP_LIST)
	public ResponseEntity<List<Group>> getGroupList(){
		return new ResponseEntity<>(groupService.getAllGroupList(),HttpStatus.OK);
	}
	
}
