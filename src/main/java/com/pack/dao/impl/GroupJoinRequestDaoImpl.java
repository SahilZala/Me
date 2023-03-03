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
	GroupDao groupDao;
	
	@Override
	public GroupJoinRequest pushJoiningRequest(
			String gid,
			String token) {
		
		GroupJoinRequest groupJoinRequest = new GroupJoinRequest();
		Group g = groupDao.findByGroupId(gid);		
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
	public GroupJoinRequest approveRequest(String requestId, String token) {
		GroupJoinRequest groupJoinRequest = groupJoinRequestService.findByRequestId(requestId);
		groupJoinRequest.setStatus(GroupJoinRequestStatus.APPROVE);
		Group g = groupDao.makeMemberOfGroup(groupJoinRequest.getFrom().getId(),groupJoinRequest.getGid().getId(),token);
		groupJoinRequest.setGid(g);
		return groupJoinRequestService.updateJoinRequest(groupJoinRequest);
	}
	@Override
	public GroupJoinRequest cancelRequest(String requestId, String token) {
		GroupJoinRequest groupJoinRequest = groupJoinRequestService.findByRequestId(requestId);
		groupJoinRequest.setStatus(GroupJoinRequestStatus.CANCEL);
		return groupJoinRequestService.updateJoinRequest(groupJoinRequest);
	}
}
