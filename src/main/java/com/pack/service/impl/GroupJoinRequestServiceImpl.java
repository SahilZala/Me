package com.pack.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.exception.NoDataFoundException;
import com.pack.model.GroupJoinRequest;
import com.pack.repository.GroupJoinRequestRepository;
import com.pack.service.GroupJoinRequestService;

@Service
public class GroupJoinRequestServiceImpl implements GroupJoinRequestService {

	@Autowired
	GroupJoinRequestRepository groupJoinRequestRepository;
	
	Logger logger = LoggerFactory.getLogger(GroupJoinRequestServiceImpl.class);
	
	
	@Override
	public GroupJoinRequest pushJoiningRequest(GroupJoinRequest groupJoinRequest)
		throws RuntimeException
	{
		GroupJoinRequest g = null;
		g = groupJoinRequestRepository.save(groupJoinRequest);	
		return g;
	}

	@Override
	public List<GroupJoinRequest> getGroupAllRequest(String id) {
		
		return groupJoinRequestRepository.getAllGroupRequest(id);
	}

	@Override
	public GroupJoinRequest findByRequestId(String id) throws NoDataFoundException {
		Optional<GroupJoinRequest> groupJoinRequest = groupJoinRequestRepository.findById(id);
		if(groupJoinRequest.isEmpty())
		{
			logger.error("group join request not found");
			throw new NoDataFoundException("group join request not found");
		}		
		return groupJoinRequest.get();
	}

	@Override
	public GroupJoinRequest updateJoinRequest(GroupJoinRequest groupJoinRequest) {
		return groupJoinRequestRepository.save(groupJoinRequest);
	}
	
	
	
}
