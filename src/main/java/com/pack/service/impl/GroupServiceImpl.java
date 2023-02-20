package com.pack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Group;
import com.pack.repository.GroupRepository;
import com.pack.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{
	
	
	@Autowired
	private GroupRepository groupRepo;
	
	@Override
	public Group createGroup(Group g) {
		return groupRepo.save(g);
	}

	@Override
	public List<Group> getAllGroupList() {
		return groupRepo.findAll();
	}
	
	
	
}
