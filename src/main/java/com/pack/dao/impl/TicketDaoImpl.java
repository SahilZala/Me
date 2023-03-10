package com.pack.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dao.TicketDao;
import com.pack.model.Ticket;
import com.pack.model.User;
import com.pack.service.TicketService;
import com.pack.service.UserService;
import com.pack.util.JWTUtil;
import com.pack.util.TicketStatus;
import com.pack.util.UtilMethods;

@Service
public class TicketDaoImpl implements TicketDao {

	@Autowired
	TicketService ticketService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	UserService userService;
	
	
	@Override
	public Ticket pushTicket(Ticket ticket,String token) {
		
		ticket.setId(UtilMethods.generateRandomeNumber());
		ticket.setFrom(userService.findByEmailId(jwtUtil.extractUsername(token)));
		ticket.setDate(UtilMethods.getCurrentDate());
		ticket.setTime(UtilMethods.getCurrentTime());
		ticket.setStatus(TicketStatus.RAISED);
		
		return ticketService.createTicket(ticket);
	}


	@Override
	public List<Ticket> getReceiveTicket(String groupId, String token) {
		User u = userService.findByEmailId(jwtUtil.extractUsername(token));
		return ticketService.getReceiveTicket(groupId,u.getId());
	}
	
}
