package com.pack.dao;

import com.pack.model.GroupJoinRequest;

public interface GroupJoinRequestDao {
	GroupJoinRequest pushJoiningRequest(
			String groupJoinRequest,
			String token);
}
