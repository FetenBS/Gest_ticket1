package org.sid.controllers;


import java.util.List;

//import javax.validation.Valid;

import org.sid.dto.models.MetDTO;


import org.sid.services.MetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MetCtrl {
	private MetService metService;
	@PostMapping("api/mets")
		public MetDTO saveDTO(@RequestBody MetDTO dto) {
		return metService.saveMetInDB(dto);
}
	@GetMapping("api/mets")
	public List<MetDTO> getAllDTO(){
		return metService.getAllMet();
	}
}