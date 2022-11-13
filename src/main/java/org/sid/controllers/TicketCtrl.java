package org.sid.controllers;

import java.util.List;


import org.sid.dto.models.MetDTO;
import org.sid.dto.models.TicketDTO;
import org.sid.entities.MetEntity;
import org.sid.entities.TicketEntity;
import org.sid.services.StatService;
import org.sid.services.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class TicketCtrl {
	private TicketService ticketService;
	@GetMapping("api/tickets")
	public List<TicketEntity> getAllTicket(){
		return ticketService.getAll();
	}
	@GetMapping("api/ticketss")
	public double getTickets(TicketDTO ticketDTO){
		return ticketService.createTicket(ticketDTO);
	
	
	}
	@PostMapping("api/tickets")
	public TicketEntity saveDTO(@RequestBody TicketEntity tickets) {
		return ticketService.saveTicket(tickets);
	}
}
