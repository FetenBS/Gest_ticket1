package org.sid.controllers;

import javax.validation.Valid;

import org.sid.dto.models.ClientReqDTO;
import org.sid.dto.models.ClientResDTO;

import org.sid.services.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientCtrl {
private ClientService clientService;
@PostMapping("api/clients")
	public ClientResDTO addClient(@Valid @RequestBody ClientReqDTO clientReqDTO) {
	return clientService.saveToDB(clientReqDTO);
}
@GetMapping("api/clients")
public ClientResDTO getClient(@RequestBody ClientReqDTO clientResDTO) {
	return clientService.saveToDB(clientResDTO);
}
}
