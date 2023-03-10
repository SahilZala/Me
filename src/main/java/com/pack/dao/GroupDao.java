package com.pack.dao;

import java.util.List;

import com.pack.model.Group;

public interface GroupDao {
	Group createGroup(Group group,String token);
	List<Group> getAllGroupList();
	List<Group> getGroupListByCreatorId(String id);
	Group makeMemberOfGroup(String memberId,String groupId,String token);
	List<Group> getGroupListByToken(String token);
	List<Group> getAllGroupOfUser(String token);
	List<Group> getAllGroupOfNotUser(String token);
	Group findByGroupId(String id);
}
