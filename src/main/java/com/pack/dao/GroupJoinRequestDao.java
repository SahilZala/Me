package com.pack.dao;

import java.util.List;

import com.pack.model.GroupJoinRequest;

public interface GroupJoinRequestDao {
	GroupJoinRequest pushJoiningRequest(
			String groupJoinRequest,
			String token);
	
	List<GroupJoinRequest> getGroupAllRequest(String token);
}
