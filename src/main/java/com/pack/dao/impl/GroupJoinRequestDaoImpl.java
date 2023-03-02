package com.pack.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dao.GroupDao;
import com.pack.dao.GroupJoinRequestDao;
import com.pack.model.Group;
import com.pack.model.GroupJoinRequest;
import com.pack.model.User;
import com.pack.service.GroupJoinRequestService;
import com.pack.service.GroupService;
import com.pack.service.UserService;
import com.pack.util.GroupJoinRequestStatus;
import com.pack.util.JWTUtil;
import com.pack.util.UtilMethods;

@Service
public class GroupJoinRequestDaoImpl implements GroupJoinRequestDao{

	@Autowired
	GroupJoinRequestService groupJoinRequestService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	GroupDao groupDao;
	
	@Override
	public GroupJoinRequest pushJoiningRequest(
			String gid,
			String token) {
		
		GroupJoinRequest groupJoinRequest = new GroupJoinRequest();
		Group g = groupService.findByGroupId(gid);		
		String userName = jwtUtil.extractUsername(token);
		User u = userService.findByEmailId(userName);
		
		groupJoinRequest.setId(UtilMethods.generateRandomeNumber());
		
		groupJoinRequest.setTo(
				g.getGroupCreatedById());
		groupJoinRequest.setFrom(u);
		
		groupJoinRequest.setGid(g);
		
		groupJoinRequest.setDate(UtilMethods.getCurrentDate());
		groupJoinRequest.setTime(UtilMethods.getCurrentTime());
		groupJoinRequest.setStatus(GroupJoinRequestStatus.PENDING);
		
		return groupJoinRequestService
				.pushJoiningRequest(groupJoinRequest);
		
	}

	@Override
	public List<GroupJoinRequest> getGroupAllRequest(String token) {
		
		return groupJoinRequestService.getGroupAllRequest(
				userService.findByEmailId(
						jwtUtil.extractUsername(token)).getId());
	}

	@Override
	public GroupJoinRequest approveRequest(String requestId) {
		GroupJoinRequest gjr = groupJoinRequestService.findByRequestId(requestId);
		gjr.approve();
		
		return groupJoinRequestService.pushJoiningRequest(gjr);
	}

	@Override
	public GroupJoinRequest cancelRequest(String reqestId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
