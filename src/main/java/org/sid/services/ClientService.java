package org.sid.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.sid.dao.ClientEntityRepository;

import org.sid.dto.models.ClientReqDTO;
import org.sid.dto.models.ClientResDTO;
import org.sid.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ClientService {
	//@Autowired
	private ClientEntityRepository clientRepository;
	@GetMapping(value="/clients")
	public ClientResDTO saveToDB(ClientReqDTO clientReqDTO) {
		ModelMapper mapper=new ModelMapper();
	ClientEntity clientEntity=mapper.map(clientReqDTO,ClientEntity.class);
		
		/*ClientEntity clientEntity=new ClientEntity();
		clientEntity.setNom(clientReqDTO.getNom());
		clientEntity.setPrenom(clientReqDTO.getPrenom());
		
		clientEntity.setDatenaissance(clientReqDTO.getDatenaissance());
		clientEntity.setCourriel(clientReqDTO.getCourriel());
		clientEntity.setTelephone(clientReqDTO.getTelephone());*/
		clientRepository.save(clientEntity);
		
		
		ClientResDTO clientResDTO=mapper.map(clientEntity, ClientResDTO.class);
		
		/*clientResDTO.setId(clientEntity.getId());
		clientResDTO.setNomComplet(clientEntity.getPrenom()+" "+clientEntity.getNom());
		//clientResDTO.setId(clientEntity.getId());
		clientResDTO.setAge((int)ChronoUnit.YEARS.between(clientEntity.getDatenaissance(), LocalDate.now()));
		*/return clientResDTO;
		
		
}
}