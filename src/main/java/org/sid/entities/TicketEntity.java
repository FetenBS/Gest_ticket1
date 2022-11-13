package org.sid.entities;


import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import lombok.Data;
@Entity
@Data
public class TicketEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	private LocalDateTime dateTime;
	private int nbCouverts;
	private double addition;
	@ManyToOne
	private ClientEntity client;
	@ManyToOne
	private TableEntity table;
	@ManyToMany
	private List<MetEntity> mets;
}
