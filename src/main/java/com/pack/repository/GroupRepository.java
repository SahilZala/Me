package com.pack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pack.model.Group;

public interface GroupRepository extends MongoRepository<Group, String>{

}
