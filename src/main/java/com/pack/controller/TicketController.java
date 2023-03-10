package com.pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.TicketDao;
import com.pack.model.Ticket;
import com.pack.util.PathUtil;

@RestController
@CrossOrigin
public class TicketController {
	
	@Autowired
	TicketDao ticketDao;
	
	@PostMapping(PathUtil.RAISE_TICKET)
	public ResponseEntity<Ticket> raiseTicket(@RequestBody Ticket ticket,HttpServletRequest req)
	{
		return new ResponseEntity<>(
				ticketDao.pushTicket(
						ticket, 
						req.getHeader("Authorization").substring(7)
						),
				HttpStatus.OK);
	}
	
	@GetMapping(PathUtil.GET_RECEVED_TICKET+"/{groupId}")
	public ResponseEntity<List<Ticket>> getReceiveTicket(@PathVariable("groupId") String groupId,HttpServletRequest req)
	{
		return new ResponseEntity<>(
				ticketDao.getReceiveTicket(groupId,req.getHeader("Authorization").substring(7)),
				HttpStatus.OK);
	}
	
	
}
