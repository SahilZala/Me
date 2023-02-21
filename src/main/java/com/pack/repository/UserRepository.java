package com.pack.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pack.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query("{mailId: '?0'}")
	Optional<User> findByMailId(String emailId);
	
	@Query("{username: '?0'}")
	Optional<User> findByUsername(String username);
}
