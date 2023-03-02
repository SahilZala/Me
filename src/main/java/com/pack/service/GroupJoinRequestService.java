package com.pack.service;

import java.util.List;

import com.pack.model.GroupJoinRequest;

public interface GroupJoinRequestService {
	public GroupJoinRequest pushJoiningRequest(GroupJoinRequest groupJoinRequest);
	public List<GroupJoinRequest> getGroupAllRequest(String id);
	public GroupJoinRequest findByRequestId(String requestId);
}
