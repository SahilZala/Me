package com.pack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Ticket;
import com.pack.repository.TicketRepository;
import com.pack.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepo;
	
	@Override
	public Ticket createTicket(Ticket ticket) {
		
		 
		return ticketRepo.save(ticket);
	}

	@Override
	public List<Ticket> getReceiveTicket(String groupId, String userId) {
		return ticketRepo.findReceiveTicket(groupId, userId);
	}
	
}
