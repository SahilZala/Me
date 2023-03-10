package com.pack.service;

import java.util.List;

import com.pack.model.Ticket;

public interface TicketService {
	public Ticket createTicket(Ticket ticket);
	public List<Ticket> getReceiveTicket(String groupId,String userId);
}
