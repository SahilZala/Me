package com.pack.service;

import java.util.List;

import com.pack.model.Group;

public interface GroupService {
	public Group createGroup(Group g);
	public List<Group> getAllGroupList();
	public List<Group> findGroupByCreatorId(String id);
	public Group findByGroupId(String id);
	public Group updateGroup(Group g);
	public List<Group> findAllGroupOfUser(String id);
	
	
}
