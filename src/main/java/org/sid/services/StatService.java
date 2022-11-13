package org.sid.services;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.sid.dao.ClientEntityRepository;
import org.sid.dao.MetEntityRepository;
import org.sid.dao.TableEntityRepository;
import org.sid.dao.TicketEntityRepository;
import org.sid.dto.models.ClientResDTO;
import org.sid.dto.models.MetDTO;
import org.sid.entities.ClientEntity;
import org.sid.entities.MetEntity;
import org.sid.entities.Plat;
import org.sid.entities.TicketEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatService {
private ModelMapper mapper;
private MetEntityRepository metEntityRepository;
private ClientEntityRepository clientEntityRepository;
private TicketEntityRepository ticketEntityRepository;
public MetDTO plasPlusAchetee(LocalDate deb,LocalDate fin) {
	List<MetEntity> mets=metEntityRepository.findAll();
	System.out.println(mets);
	
	//Local plat objects
	mets.removeIf(met->!(met instanceof Plat));
	//System.out.println(mets);
	for(MetEntity metEntity:mets) {
		//remove tickets out of periode
		 metEntity.getTickets().removeIf(t->t.getDateTime().toLocalDate().isBefore(deb)||
				t.getDateTime().toLocalDate().isAfter(fin));
		 }
				int max=-1;
				MetEntity entity=null;
				for(MetEntity metEntity : mets ) {
					if(metEntity.getTickets().size()>max) {
					max=metEntity.getTickets().size();
					entity=metEntity;
				}
	            }
	MetDTO dto=mapper.map(entity,MetDTO.class);
	dto.setType("Plat");
	return dto;
}
public MetEntity saveMet(MetEntity met) {
	// TODO Auto-generated method stub
	return metEntityRepository.save(met);
}
public ClientResDTO clientFidele() {
List<ClientEntity>	clientsEntities=clientEntityRepository.findAll();
Optional<ClientEntity> opt=clientsEntities.stream()
.max(Comparator.comparing(client->client.getTickets().size()));
ClientEntity entity=null;
if(opt.isPresent()) 
	entity=opt.get();
	return mapper.map(entity, ClientResDTO.class);
}
//return null;

public String jourClient(int id) {
	ClientEntity clientEntity=clientEntityRepository.findById(id).get();
	List<TicketEntity> tickets=clientEntity.getTickets();
			return null;
}
}
