package com.pack.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pack.model.GroupJoinRequest;

public interface GroupJoinRequestRepository extends 
	MongoRepository<GroupJoinRequest,String>{
	
	@Query("{to: {$ref: 'user',$id: '?0'}}")
	public List<GroupJoinRequest> getAllGroupRequest(String id);
}
