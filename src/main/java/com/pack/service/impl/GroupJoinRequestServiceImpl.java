package com.pack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.GroupJoinRequest;
import com.pack.repository.GroupJoinRequestRepository;
import com.pack.service.GroupJoinRequestService;

@Service
public class GroupJoinRequestServiceImpl implements GroupJoinRequestService {

	@Autowired
	GroupJoinRequestRepository groupJoinRequestRepository;
	
	@Override
	public GroupJoinRequest pushJoiningRequest(GroupJoinRequest groupJoinRequest)
		throws RuntimeException
	{
		GroupJoinRequest g = null;
		g = groupJoinRequestRepository.save(groupJoinRequest);	
		return g;
	}
}
