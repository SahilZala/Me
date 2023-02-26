package com.pack.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.exception.NoDataFoundException;
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

	@Override
	public List<Group> findGroupByCreatorId(String id) {
		return groupRepo.findGroupByCreaterId(id);
	}

	@Override
	public Group findByGroupId(String id) throws NoDataFoundException {
		Optional<Group> g = groupRepo.findById(id);
		if(g.isEmpty())
			throw new NoDataFoundException("No group found");
		return g.get();
	}

	@Override
	public Group updateGroup(Group g) {
		
		return groupRepo.save(g);
	}

	@Override
	public List<Group> findAllGroupOfUser(String id) {
		
		return groupRepo.findAllGroupOfUser(id);
	}
	
	
	
	
}
