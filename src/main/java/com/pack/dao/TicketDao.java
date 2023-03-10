package com.pack.dao;

import java.util.List;

import com.pack.model.Ticket;

public interface TicketDao {
	public Ticket pushTicket(Ticket ticket,String token);
	public List<Ticket> getReceiveTicket(String groupId,String token);
}
