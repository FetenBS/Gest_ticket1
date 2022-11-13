package org.sid.controllers;

import java.time.LocalDate;

import java.util.List;

import org.sid.dto.models.ClientResDTO;
import org.sid.dto.models.MetDTO;
//import org.sid.dto.models.MetDTO;
import org.sid.entities.MetEntity;
import org.sid.services.MetService;
import org.sid.services.StatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StatCtrl {
private StatService statService;
@GetMapping("/api/stats/plat/{deb}/{fin}")
public MetDTO getPlatPLusAchetee(@PathVariable String deb,@PathVariable String fin) {
	LocalDate debDate=LocalDate.parse(deb);
	LocalDate finDate=LocalDate.parse(fin);
	return statService.plasPlusAchetee(debDate,finDate);
	
}
@PostMapping("/api/stats/plat/{deb}/{fin}")
	public MetEntity saveDTO(@RequestBody MetEntity met) {
		return statService.saveMet(met);
}
@GetMapping("/api/clientplusFidele")
public ClientResDTO getclientFidele() {
	return statService.clientFidele();
}
}

