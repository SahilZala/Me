package com.pack.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pack.model.Group;

public interface GroupRepository extends MongoRepository<Group, String>{
	
	@Query("{groupCreatedById: {$ref: 'user',$id: '?0'}}")
	List<Group> findGroupByCreaterId(String id);
	
	@Query("{groupMemberList: {$ref: 'user',$id: '?0'}}")
	List<Group> findAllGroupOfUser(String id);
}
