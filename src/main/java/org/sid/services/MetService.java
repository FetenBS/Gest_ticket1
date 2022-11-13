package org.sid.services;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.sid.dao.MetEntityRepository;
import org.sid.dto.models.MetDTO;

import org.sid.entities.Dessert;
import org.sid.entities.Entree;
import org.sid.entities.MetEntity;
import org.sid.entities.Plat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class MetService {
	@Autowired
private MetEntityRepository metEntityRepository;
	private ModelMapper mapper;

public MetDTO saveMetInDB(MetDTO dto) {
ModelMapper mapper=new ModelMapper();
MetEntity metEntity=null;
switch(dto.getType()) {
case "Plat":
	metEntity=mapper.map(dto,Plat.class);break;
case "Entree":
	metEntity=mapper.map(dto, Entree.class);break;
case "Dessert":
	metEntity=mapper.map(dto,Dessert.class);
break;
}
metEntity=metEntityRepository.save(metEntity);
dto.setId(metEntity.getId());
return dto;
}
public List<MetDTO> getAllMet(){
	List<MetEntity> entities=metEntityRepository.findAll();
	List<MetDTO>dtos=new ArrayList<>();
	for(MetEntity metEntity:entities) {
		MetDTO dto=mapper.map(metEntity,MetDTO.class);
		dto.setType(metEntity.getClass().getSimpleName());
		dtos.add(dto);
	}
	return dtos;
}
}
