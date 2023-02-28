package com.pack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pack.model.GroupJoinRequest;

public interface GroupJoinRequestRepository extends 
	MongoRepository<GroupJoinRequest,String>{
	
}
