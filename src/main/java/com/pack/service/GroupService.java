package com.pack.service;

import java.util.List;

import com.pack.model.Group;

public interface GroupService {
	public Group createGroup(Group g);
	public List<Group> getAllGroupList();
}
