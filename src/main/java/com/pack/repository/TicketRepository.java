package com.pack.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pack.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
	
	@Query("{groupId: {$ref: 'group',$id: '?0'},to: {$ref: 'user',$id: '?1'}}")
	List<Ticket> findReceiveTicket(String groupId,String userId);
}
