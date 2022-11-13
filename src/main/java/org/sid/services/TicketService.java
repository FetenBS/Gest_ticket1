package org.sid.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.sid.dao.ClientEntityRepository;
import org.sid.dao.MetEntityRepository;
import org.sid.dao.TableEntityRepository;
import org.sid.dao.TicketEntityRepository;
import org.sid.dto.models.TicketDTO;
import org.sid.entities.ClientEntity;
import org.sid.entities.MetEntity;
import org.sid.entities.TableEntity;
import org.sid.entities.TicketEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketService {
	//double addition=0;
	private ClientEntityRepository clientEntityRepository;
	private MetEntityRepository metEntityRepository;
	private TableEntityRepository tableEntityRepository;
	private TicketEntityRepository ticketEntityRepository;
	public double createTicket(TicketDTO ticketDTO) {
	ClientEntity clientEntity=clientEntityRepository.findById(ticketDTO.getClientId()).get();
	TableEntity tableEntity=tableEntityRepository.findById(ticketDTO.getTableNumero()).get();
	List<MetEntity> mets=metEntityRepository.findAllById(Arrays.asList(ticketDTO.getMetsIds()));
	double addition=mets.stream().mapToDouble(met-> met.getPrix())
	 .sum()+tableEntity.getSupplement();
	TicketEntity ticketEntity=new TicketEntity();
	ticketEntity.setClient(clientEntity);
	ticketEntity.setTable(tableEntity);
	ticketEntity.setMets(mets);
	ticketEntity.setAddition(addition);
	ticketEntity.setDateTime(LocalDateTime.now());
	ticketEntityRepository.save(ticketEntity);
	 return addition;
	}
	public List<TicketEntity> getAll(){
    return ticketEntityRepository.findAll();
		
	}
	public TicketEntity saveTicket(TicketEntity t){
		return ticketEntityRepository.save(t);
		
	}
}
