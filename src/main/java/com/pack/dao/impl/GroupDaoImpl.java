package com.pack.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Service;

import com.pack.dao.GroupDao;
import com.pack.exception.UserNotFoundException;
import com.pack.model.Group;
import com.pack.model.User;
import com.pack.service.GroupService;
import com.pack.service.UserService;
import com.pack.util.JWTUtil;
import com.pack.util.UtilMethods;

@Service
public class GroupDaoImpl implements GroupDao{
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	@Override
	public Group createGroup(Group group, String token) {
		group.setId(UtilMethods.generateRandomeNumber());
		group.setActivation(true);
		group.setCreationDate(LocalDate.now().toString());
		if(group.getGroupCreatedById() == null) {
			User u = userService.findByEmailId(
					jwtUtil.extractUsername(
							token));
			group.setGroupCreatedById(u);
		}
		
		group.setGroupMemberList(new ArrayList<>());
		
		if(group.getGroupMemberList().isEmpty())
			group.getGroupMemberList().add(group.getGroupCreatedById());
		return groupService.createGroup(group);
	}

	@Override
	public List<Group> getAllGroupList() {
		return groupService.getAllGroupList();
	}

	@Override
	public List<Group> getGroupListByCreatorId(String id) {
		return groupService.findGroupByCreatorId(id);
	}

	@Override
	public Group makeMemberOfGroup(String memberId, 
			String groupId, String token) throws AccessDeniedException,RuntimeException,UserNotFoundException{
		Group g = groupService.findByGroupId(groupId);
		
		if(!g.getGroupCreatedById().getId().equals(
				userService.findByEmailId(
						jwtUtil.extractUsername(token)
					).getId())){
			
			throw new AccessDeniedException("Your not creator of group to enroll user.");
			
		}
		User u = userService.findByUserId(memberId);
		
		if(g.getGroupMemberList().stream().filter(user->user.getId().equals(memberId)).findAny().isEmpty()) {
			g.getGroupMemberList().add(u);
			return groupService.updateGroup(g);
		}
		else
			throw new RuntimeException("MemberId is already present in group");
	}
	
}
